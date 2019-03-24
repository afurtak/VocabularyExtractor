package vocabularyextractor.vocabularyParser

import edu.stanford.nlp.ling.HasWord

data class VocabularyPart(val type: VocabularyType, val content: String, val context: List<HasWord>) {
    override fun equals(other: Any?): Boolean {
        if (other !is VocabularyPart)
            return false
        return type == other.type && content == other.content
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + content.hashCode()
        result = 31 * result + context.hashCode()
        return result
    }
}

enum class VocabularyType {
    PHRASAL_VERB {
        override fun toString() = "phrasal verb"
    },
    COMPOUND_NOUN {
        override fun toString() = "compound noun"
    }
}
