package vocabularyextractor.vocabularyParser.lexicalizedParsers

import vocabularyextractor.vocabularyParser.VocabularyPart
import vocabularyextractor.vocabularyParser.VocabularyType
import vocabularyextractor.vocabularyParser.isAdjective

class AdjectiveAdapter : SimpleVocabularyParseAdapter({
    it.isAdjective()
}, { taggedWord, context ->
    VocabularyPart(VocabularyType.ADJECTIVE, taggedWord, context)
})
