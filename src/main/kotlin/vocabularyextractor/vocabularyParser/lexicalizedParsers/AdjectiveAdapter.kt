package vocabularyextractor.vocabularyParser.lexicalizedParsers

import vocabularyextractor.vocabularyParser.VocabularyPart
import vocabularyextractor.vocabularyParser.PartOfSpeechTag
import vocabularyextractor.vocabularyParser.isAdjective

class AdjectiveAdapter : SimpleVocabularyParseAdapter({
    it.isAdjective()
}, { taggedWord, context ->
    VocabularyPart(PartOfSpeechTag.ADJECTIVE, taggedWord, context)
})
