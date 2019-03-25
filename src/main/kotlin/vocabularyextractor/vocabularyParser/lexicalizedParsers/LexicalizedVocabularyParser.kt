package vocabularyextractor.vocabularyParser.lexicalizedParsers

import edu.stanford.nlp.ling.HasWord
import edu.stanford.nlp.trees.GrammaticalStructureFactory
import edu.stanford.nlp.trees.PennTreebankLanguagePack
import edu.stanford.nlp.trees.Tree
import edu.stanford.nlp.trees.TypedDependency
import vocabularyextractor.vocabularyParser.NLPModels.lexicalParser
import vocabularyextractor.vocabularyParser.VocabularyParser
import vocabularyextractor.vocabularyParser.VocabularyPart

class LexicalizedVocabularyParser(text: String): VocabularyParser(text) {
    protected val grammaticalStructureFactory: GrammaticalStructureFactory by lazy {
        PennTreebankLanguagePack().grammaticalStructureFactory()
    }

    val adapters = listOf(
        PhrasalVerbsAdapter(),
        CompoundNounsAdapter()
    )

    protected fun typedDependencies(dependencyTree: Tree): MutableCollection<TypedDependency> =
            grammaticalStructureFactory
                .newGrammaticalStructure(dependencyTree)
                .typedDependencies()

    protected fun parseGrammaticalRelation(sentence: List<HasWord>): Tree =
            lexicalParser.apply(sentence)

    override fun parse(): Set<VocabularyPart> =
        mutableSetOf<VocabularyPart>().apply {
            for (sentence in sentences)
                for (dependency in typedDependencies(parseGrammaticalRelation(sentence)))
                    adapters
                        .filter { it.isDependencyRightType(dependency) }
                        .forEach { this.add(it.parseVocabularyType(dependency, sentence)) }
        }
}