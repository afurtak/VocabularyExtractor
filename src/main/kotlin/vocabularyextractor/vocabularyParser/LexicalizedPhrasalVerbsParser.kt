package vocabularyextractor.vocabularyParser

import edu.stanford.nlp.ling.HasWord
import edu.stanford.nlp.trees.GrammaticalStructureFactory
import edu.stanford.nlp.trees.PennTreebankLanguagePack
import edu.stanford.nlp.trees.Tree
import vocabularyextractor.vocabularyParser.NLPModels.lexicalParser


class LexicalizedPhrasalVerbsParser(text: String) : PhrasalVerbParser(text) {

    override fun parse(): Set<VocabularyPart> {
        val factory = PennTreebankLanguagePack().grammaticalStructureFactory()
        val phrasalVerbs = mutableSetOf<VocabularyPart>()

        for (sentence in sentences)
            for (dependency in typedDependencies(factory, parseGrammaticalRelation(sentence)))
                if (isPhrasal(dependency))
                    phrasalVerbs.add(parsePhrasalVerb(dependency, sentence))
        return phrasalVerbs
    }

    private fun typedDependencies(factory: GrammaticalStructureFactory, dependencyTree: Tree) =
        factory
            .newGrammaticalStructure(dependencyTree)
            .typedDependencies()

    private fun parseGrammaticalRelation(sentence: List<HasWord>) =
        lexicalParser.apply(sentence)
}