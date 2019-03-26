package vocabularyextractor.vocabularyParser

import edu.stanford.nlp.ling.TaggedWord
import edu.stanford.nlp.process.Morphology

val tagMeaning = mutableMapOf(
    Pair("CC", "Coordinating conjunction"),
    Pair("CD", "Cardinal number"),
    Pair("DT", "Determiner"),
    Pair("EX", "Existential there"),
    Pair("FW", "Foreign word"),
    Pair("IN", "Preposition or subordinating conjunction"),
    Pair("JJ", "Adjective"),
    Pair("JJR", "Adjective, comparative"),
    Pair("JJS", "Adjective, superlative"),
    Pair("LS", "List item marker"),
    Pair("MD", "Modal"),
    Pair("NN", "Noun, singular or mass"),
    Pair("NNS", "Noun, plural"),
    Pair("NNP", "Proper noun, singular"),
    Pair("NNPS", "Proper noun, plural"),
    Pair("PDT", "Predeterminer"),
    Pair("POS", "Possessive ending"),
    Pair("PRP", "Personal pronoun"),
    Pair("PRP$", "Possessive pronoun"),
    Pair("RB", "Adverb"),
    Pair("RBR", "Adverb, comparative"),
    Pair("RBS", "Adverb, superlative"),
    Pair("RP", "Particle"),
    Pair("SYM", "Symbol"),
    Pair("TO", "to"),
    Pair("UH", "Interjection"),
    Pair("VB", "Verb, base form"),
    Pair("VBD", "Verb, past tense"),
    Pair("VBG", "Verb, gerund or present participle"),
    Pair("VBN", "Verb, past participle"),
    Pair("VBP", "Verb, non­3rd person singular present"),
    Pair("VBZ", "Verb, 3rd person singular present"),
    Pair("WDT", "Wh­determiner"),
    Pair("WP", "Wh­pronoun"),
    Pair("WP$", "Possessive wh­pronoun"),
    Pair("WRB", "Wh­adverb")
)

fun TaggedWord.isNoun(): Boolean =
        tag().startsWith("NN")

fun TaggedWord.isVerb(): Boolean =
        tag().startsWith("VB")

fun TaggedWord.isAdjective(): Boolean =
        tag().startsWith("JJ")

fun getTagMeaning(tag: String): String? {
    return if (!tagMeaning.containsKey(tag))
        null
    else
        tagMeaning[tag]
}

fun String.getBaseForm(): String =
    Morphology().stem(this)