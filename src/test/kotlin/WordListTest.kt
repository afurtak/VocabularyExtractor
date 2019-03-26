import junit.framework.Assert.assertEquals
import org.junit.Test
import vocabularyextractor.dictionary.WordList

class WordListTest {
    @Test
    fun simpleTesT() {
        assertEquals(370099, WordList.words.size)
    }
}