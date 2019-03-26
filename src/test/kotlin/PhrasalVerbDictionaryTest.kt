import junit.framework.Assert.assertEquals
import org.junit.jupiter.api.Test
import vocabularyextractor.dictionary.PhrasalVerbsDictionary

class PhrasalVerbDictionaryTest {
    @Test
    fun simpleTest() {
        assertEquals(3350, PhrasalVerbsDictionary.phrasalVerbs.size)
    }
}