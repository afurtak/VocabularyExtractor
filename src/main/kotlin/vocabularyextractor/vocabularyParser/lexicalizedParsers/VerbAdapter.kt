package vocabularyextractor.vocabularyParser.lexicalizedParsers

import vocabularyextractor.vocabularyParser.VocabularyPart
import vocabularyextractor.vocabularyParser.PartOfSpeechTag
import vocabularyextractor.vocabularyParser.isVerb

class VerbAdapter : SimpleVocabularyParseAdapter({
    it.isVerb()
}, { taggedWord, context ->
    VocabularyPart(PartOfSpeechTag.VERB, taggedWord, context)
})