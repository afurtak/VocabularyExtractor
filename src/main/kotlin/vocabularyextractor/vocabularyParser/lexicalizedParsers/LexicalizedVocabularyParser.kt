package vocabularyextractor.vocabularyParser.lexicalizedParsers

import edu.stanford.nlp.ling.HasWord
import edu.stanford.nlp.ling.TaggedWord
import edu.stanford.nlp.trees.GrammaticalStructureFactory
import edu.stanford.nlp.trees.PennTreebankLanguagePack
import edu.stanford.nlp.trees.Tree
import edu.stanford.nlp.trees.TypedDependency
import vocabularyextractor.vocabularyParser.*
import vocabularyextractor.vocabularyParser.NLPModels.lexicalParser
import vocabularyextractor.vocabularyParser.NLPModels.posTagger

open class LexicalizedVocabularyParser(text: String): VocabularyParser(text) {
    protected val grammaticalStructureFactory: GrammaticalStructureFactory by lazy {
        PennTreebankLanguagePack().grammaticalStructureFactory()
    }

    val complexVocabularyAdapters = listOf(
        PhrasalVerbsAdapter(),
        CompoundNounsAdapter()
    )

    val simpleVocabularyAdapter = listOf(
        NounAdapter(),
        VerbAdapter(),
        AdjectiveAdapter()
    )

    protected open fun typedDependencies(dependencyTree: Tree): MutableCollection<TypedDependency> =
            grammaticalStructureFactory
                .newGrammaticalStructure(dependencyTree)
                .typedDependencies()

    protected open fun parseGrammaticalRelation(sentence: List<HasWord>): Tree =
            lexicalParser.apply(sentence)

    override fun parse(): Set<VocabularyPart> =
        mutableSetOf<VocabularyPart>().apply {
            parseAndAddComplexVocabulary()
        }.apply {
            parseAndAddSingleVocabulary()
        }

    private fun MutableSet<VocabularyPart>.parseAndAddSingleVocabulary() {
        for (sentence in sentences)
            for (taggedWord in posTagger.tagSentence(sentence))
                simpleVocabularyAdapter
                    .filter { it.isRightType(taggedWord) }
                    .forEach { this.add(it.parseVocabularyPart(taggedWord, sentence)) }
    }

    private fun MutableSet<VocabularyPart>.parseAndAddComplexVocabulary() {
        for (sentence in sentences)
            for (dependency in typedDependencies(parseGrammaticalRelation(sentence)))
                complexVocabularyAdapters
                    .filter { it.isDependencyRightType(dependency) }
                    .forEach { this.add(it.parseVocabularyPart(dependency, sentence)) }
    }
}