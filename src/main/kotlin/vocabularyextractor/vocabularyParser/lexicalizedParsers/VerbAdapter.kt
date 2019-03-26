package vocabularyextractor.vocabularyParser.lexicalizedParsers

import vocabularyextractor.vocabularyParser.VocabularyPart
import vocabularyextractor.vocabularyParser.VocabularyType
import vocabularyextractor.vocabularyParser.isVerb

class VerbAdapter : SimpleVocabularyParseAdapter({
    it.isVerb()
}, { taggedWord, context ->
    VocabularyPart(VocabularyType.VERB, taggedWord, context)
})