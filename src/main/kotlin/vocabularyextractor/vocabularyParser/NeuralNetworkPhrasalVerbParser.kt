package vocabularyextractor.vocabularyParser

import edu.stanford.nlp.ling.HasWord
import vocabularyextractor.vocabularyParser.NLPModels.dependencyParser
import vocabularyextractor.vocabularyParser.NLPModels.posTagger

class NeuralNetworkPhrasalVerbParser(text: String) : PhrasalVerbParser(text) {

    override fun parsePhrasalVerbs(): Set<String> {
        val phrasalVerbs = mutableSetOf<String>()
        for (sentence in sentences)
            for (dependency in typedDependencies(sentence))
                if (isPhrasal(dependency))
                    phrasalVerbs.add(parsePhrasalVerb(dependency))
        return phrasalVerbs
    }

    private fun typedDependencies(sentence: MutableList<HasWord>) =
        parseSentence(sentence).typedDependencies()

    private fun parseSentence(sentence: MutableList<HasWord>) =
        dependencyParser.predict(posTagger.tagSentence(sentence))
}