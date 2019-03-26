package vocabularyextractor.dictionary

import java.util.*

object PhrasalVerbsDictionary {
    val phrasalVerbs
            by lazy {
                readPhrasalVerbsFromDataBase()
            }

    private const val phrasalVerbsDataBase = "/dictionary/phrasal verbs.txt"

    private fun readPhrasalVerbsFromDataBase(): Map<String, String> {
        val map = mutableMapOf<String, String>()
        val inputStream = javaClass
            .getResource(phrasalVerbsDataBase)
            .openStream()

        Scanner(inputStream)
            .useDelimiter("\n")
            .forEach { line ->
                val (phrasal, definition) = parseLine(line)
                map.putIfAbsent(phrasal, definition)
            }
        return map
    }

    private fun parseLine(line: String): Pair<String, String> {
        val parts = line.split("-")
        return parts[0].trim() to parts[1].trim()
    }
}