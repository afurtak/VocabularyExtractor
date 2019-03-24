import org.junit.Test
import vocabularyextractor.vocabularyParser.lexicalizedParsers.LexicalizedCompoundNounsParser
import vocabularyextractor.vocabularyParser.lexicalizedParsers.LexicalizedPhrasalVerbsParser

class ParsersTest {
    @Test
    fun simpleTest() {
        val text = "I was more turned on by this gravy boat than by Barry"
        val parsers = listOf(
            LexicalizedCompoundNounsParser(text),
            LexicalizedPhrasalVerbsParser(text)
        )
        for (parser in parsers)
            for (voc in parser.parse())
                println(voc)
    }
}