package vocabularyextractor.vocabularyParser.compoundNouns

import edu.stanford.nlp.ling.HasWord
import edu.stanford.nlp.trees.GrammaticalStructureFactory
import edu.stanford.nlp.trees.PennTreebankLanguagePack
import edu.stanford.nlp.trees.Tree
import vocabularyextractor.vocabularyParser.NLPModels
import vocabularyextractor.vocabularyParser.VocabularyPart

class LexicalizedCompoundNounsParser(text: String): CompoundNounsParser(text) {
    override fun parse(): Set<VocabularyPart> {
        val factory = PennTreebankLanguagePack().grammaticalStructureFactory()
        val compoundNouns = mutableSetOf<VocabularyPart>()

        for (sentence in sentences)
            for (dependency in typeDependencies(factory, parseGrammaticalRelation(sentence)))
                if (isCompound(dependency))
                    compoundNouns.add(parseCompoundNoun(dependency, sentence))
        return compoundNouns
    }

    private fun typeDependencies(factory: GrammaticalStructureFactory, dependencyTree: Tree) =
        factory
            .newGrammaticalStructure(dependencyTree)
            .typedDependencies()

    private fun parseGrammaticalRelation(sentence: List<HasWord>) =
        NLPModels.lexicalParser.apply(sentence)
}