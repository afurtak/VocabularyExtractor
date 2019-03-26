package vocabularyextractor.vocabularyParser

import edu.stanford.nlp.ling.HasWord
import edu.stanford.nlp.ling.TaggedWord

data class VocabularyPart(val type: VocabularyType, val content: String, val context: List<HasWord>) {

    constructor(type: VocabularyType, taggedWord: TaggedWord, context: List<HasWord>) : this(
        type,
        taggedWord.word().toLowerCase().getBaseForm(),
        context
    )

    override fun equals(other: Any?): Boolean {
        if (other !is VocabularyPart)
            return false
        return type == other.type && content == other.content
    }

    override fun hashCode(): Int {
        var result = type.hashCode()
        result = 31 * result + content.hashCode()
        return result
    }

    override fun toString(): String =
        StringBuilder().apply {
            this.append(content)
                .append(" is a ")
                .append(type)
                .append(", in sentence: ")
            for (word in context)
                this.append(word.word())
                    .append(" ")
        }.toString()

    fun getContext(): String =
        context.joinToString(" ") { it.word() }
}

enum class VocabularyType {
    PHRASAL_VERB {
        override fun toString() = "phrasal verb"
    },
    COMPOUND_NOUN {
        override fun toString() = "compound noun"
    },
    VERB {
        override fun toString() = "verb"
    },
    NOUN {
        override fun toString() = "noun"
    },
    ADJECTIVE {
        override fun toString() = "adjective"
    },
}
