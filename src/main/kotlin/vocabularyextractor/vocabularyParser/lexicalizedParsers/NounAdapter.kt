package vocabularyextractor.vocabularyParser.lexicalizedParsers

import vocabularyextractor.vocabularyParser.VocabularyPart
import vocabularyextractor.vocabularyParser.PartOfSpeechTag
import vocabularyextractor.vocabularyParser.isNoun

class NounAdapter : SimpleVocabularyParseAdapter({
    it.isNoun()
}, { taggedWord, context ->
    VocabularyPart(PartOfSpeechTag.NOUN, taggedWord, context)
})
