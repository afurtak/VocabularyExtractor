package vocabularyextractor.reader

import java.io.File
import java.util.*

class SRTReader(val file: File) {

    constructor(path: String): this(File(path))

    fun parse(): String {
        var ignore = 2
        val builder = StringBuilder()
        val scanner = Scanner(file.inputStream())
        while (scanner.hasNextLine()) {
            val it = scanner.nextLine()
            when (ignore) {
                0 -> if (it == "")
                        ignore = 2
                    else
                        builder
                            .append(it)
                            .append("\n")
                else ->
                    ignore--
            }
        }

        return builder.toString()
    }
}