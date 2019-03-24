package vocabularyextractor.vocabularyParser.phrasalVerbs

import edu.stanford.nlp.ling.HasWord
import vocabularyextractor.vocabularyParser.NLPModels.dependencyParser
import vocabularyextractor.vocabularyParser.NLPModels.posTagger
import vocabularyextractor.vocabularyParser.VocabularyPart

class NeuralNetworkPhrasalVerbParser(text: String) : PhrasalVerbParser(text) {

    override fun parse(): Set<VocabularyPart> {
        val phrasalVerbs = mutableSetOf<VocabularyPart>()
        for (sentence in sentences)
            for (dependency in typedDependencies(sentence))
                if (isPhrasal(dependency))
                    phrasalVerbs.add(parsePhrasalVerb(dependency, sentence))
        return phrasalVerbs
    }

    private fun typedDependencies(sentence: MutableList<HasWord>) =
        parseSentence(sentence).typedDependencies()

    private fun parseSentence(sentence: MutableList<HasWord>) =
        dependencyParser.predict(posTagger.tagSentence(sentence))
}