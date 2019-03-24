import junit.framework.Assert.assertEquals
import org.junit.Test
import vocabularyextractor.vocabularyParser.lexicalizedParsers.LexicalizedCompoundNounsParser

class CompoundNounsParserTest {
    @Test
    fun simpleTest() {
        val text = "I was more turned on by this gravy boat than by Barry"
        assertEquals(1, LexicalizedCompoundNounsParser(text).parse().size)
        for (noun in LexicalizedCompoundNounsParser(text).parse())
            println(noun)
    }
}