package vocabularyextractor.vocabularyParser.lexicalizedParsers

import edu.stanford.nlp.ling.HasWord
import edu.stanford.nlp.ling.TaggedWord
import vocabularyextractor.vocabularyParser.VocabularyPart

open class SimpleVocabularyParseAdapter(
    val checkRightType: (TaggedWord) -> Boolean,
    val vocabularyPartCreator: (TaggedWord, List<HasWord>) -> VocabularyPart
) {
    open fun isRightType(taggedWord: TaggedWord) =
            checkRightType(taggedWord)

    open fun parseVocabularyPart(taggedWord: TaggedWord, context: List<HasWord>) =
            vocabularyPartCreator(taggedWord, context)
}