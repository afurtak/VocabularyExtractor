import edu.stanford.nlp.tagger.maxent.MaxentTagger
import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.io.StringReader

class TestDependencies {

    @Test
    fun testAssert() {
        assertEquals(42, Integer.sum(19, 23))
    }

    @Test
    fun testPOSTagger() {
        val text = "Hi, my name is Adam. What is yours?"

        val tagger = MaxentTagger("edu/stanford/nlp/models/pos-tagger/wsj-0-18-left3words-distsim.tagger")
        val sentences = MaxentTagger.tokenizeText(StringReader(text))

        for (sentence in sentences) {
            val tagged = tagger.tagSentence(sentence)
            println(tagged)
        }
    }
}