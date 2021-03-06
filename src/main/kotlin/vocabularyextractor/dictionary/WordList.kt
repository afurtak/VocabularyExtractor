package vocabularyextractor.dictionary

import vocabularyextractor.dictionary.WordList.words
import java.util.*

object WordList {
    val words: Set<String>
            by lazy {
                readWords()
            }

    private const val wordListDataBase = "/dictionary/english words.txt"

    private fun readWords(): Set<String> {
        val set = mutableSetOf<String>()
        val inputStream = javaClass
            .getResource(wordListDataBase)
            .openStream()

        return set.apply {
            Scanner(inputStream).forEach { set.add(it) }
        }
    }
}

fun String.isProperWord() =
    words.contains(this)