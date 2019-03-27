import edu.stanford.nlp.tagger.maxent.MaxentTagger
import edu.stanford.nlp.trees.PennTreebankLanguagePack
import edu.stanford.nlp.trees.UniversalEnglishGrammaticalRelations
import edu.stanford.nlp.trees.UniversalEnglishGrammaticalRelations.COMPOUND_MODIFIER
import junit.framework.TestCase.assertEquals
import org.junit.Test
import vocabularyextractor.vocabularyParser.NLPModels
import vocabularyextractor.vocabularyParser.SRTReader
import java.io.File
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

    @Test
    fun srtTest() {
        println(SRTReader("/home/afurtak/Desktop/0101.srt").parse())
    }

    @Test
    fun testParser() {
        val testText = listOf(
            "I was more turned on by this gravy boat than by Barry"
        )
        for (text in testText) {
            val tree = NLPModels.lexicalParser.parse(text)
            val grammaticalStructure = PennTreebankLanguagePack()
                .grammaticalStructureFactory()
                .newGrammaticalStructure(tree)
                .typedDependencies()
            println(COMPOUND_MODIFIER)
            grammaticalStructure.forEach {
                if (it.reln() == UniversalEnglishGrammaticalRelations.COMPOUND_MODIFIER)
                    println(it)
            }
        }
    }
}