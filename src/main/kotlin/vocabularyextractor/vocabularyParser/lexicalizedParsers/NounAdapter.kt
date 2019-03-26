package vocabularyextractor.vocabularyParser.lexicalizedParsers

import vocabularyextractor.vocabularyParser.VocabularyPart
import vocabularyextractor.vocabularyParser.VocabularyType
import vocabularyextractor.vocabularyParser.isNoun

class NounAdapter : SimpleVocabularyParseAdapter({
    it.isNoun()
}, { taggedWord, context ->
    VocabularyPart(VocabularyType.NOUN, taggedWord, context)
})
