package vocabularyextractor

import net.sf.extjwnl.dictionary.Dictionary
import org.apache.commons.cli.CommandLine
import org.apache.commons.cli.DefaultParser
import org.apache.commons.cli.Options
import vocabularyextractor.dictionary.Definitions
import vocabularyextractor.reader.SRTReader
import vocabularyextractor.vocabularyParser.VocabularyPart
import vocabularyextractor.vocabularyParser.lexicalizedParsers.LexicalizedVocabularyParser
import java.lang.System.exit

fun main(args: Array<String>) {
    val options = Options().apply {
        addOption("r", false, "Recursive searching for files")
        addOption("f", true, "file")
        addOption("d", true, "directory for searching for files")
        addOption("e", true, "extension of searching files")
    }
    DefaultParser().parse(options, args).apply {
        validateCommandLineArgs()

        if (hasOption("f")) {
            val path = getOptionValue("f")
            val textToParse = SRTReader(path).parse()
            val vocabulary = LexicalizedVocabularyParser(textToParse).parse()
            printVocabulary(vocabulary)
        }
    }
}

private fun printVocabulary(vocabulary: Set<VocabularyPart>) {
    vocabulary.forEach { part ->
        println(part.content)
        println(part.getContext())
        println(Definitions.getDefinition(part))
        println()
    }
}

private fun CommandLine.validateCommandLineArgs() {
    if (hasOption("d") && hasOption("f"))
        exit(-1)
    if (!hasOption("d") && !hasOption("f"))
        exit(-1)
    if (hasOption("d") && !hasOption("e"))
        exit(-1)
    if (hasOption("r") && hasOption("f"))
        exit(-1)
}