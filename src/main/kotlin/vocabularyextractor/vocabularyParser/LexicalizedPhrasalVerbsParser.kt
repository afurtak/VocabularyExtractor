package vocabularyextractor.vocabularyParser

import edu.stanford.nlp.ling.HasWord
import edu.stanford.nlp.trees.GrammaticalStructureFactory
import edu.stanford.nlp.trees.PennTreebankLanguagePack
import edu.stanford.nlp.trees.Tree
import vocabularyextractor.vocabularyParser.NLPModels.lexicalParser


class LexicalizedPhrasalVerbsParser(text: String) : PhrasalVerbParser(text) {

    override fun parsePhrasalVerbs(): Set<String> {
        val grammaticalRelationsTrees = parseGrammaticalRelation(sentences)
        val factory = PennTreebankLanguagePack().grammaticalStructureFactory()
        val phrasalVerbs = mutableSetOf<String>()

        for (tree in grammaticalRelationsTrees)
            for (dependency in typedDependencies(factory, tree))
                if (isPhrasal(dependency))
                    phrasalVerbs.add(parsePhrasalVerb(dependency))
        return phrasalVerbs
    }

    private fun typedDependencies(factory: GrammaticalStructureFactory, dependencyTree: Tree) =
        factory
            .newGrammaticalStructure(dependencyTree)
            .typedDependencies()

    private fun parseGrammaticalRelation(sentences: List<MutableList<HasWord>>): List<Tree> {
        val trees = mutableListOf<Tree>()
        for (sentence in sentences)
            trees.add(lexicalParser.apply(sentence))
        return trees
    }
}