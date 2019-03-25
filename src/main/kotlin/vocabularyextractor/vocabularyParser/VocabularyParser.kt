package vocabularyextractor.vocabularyParser

import edu.stanford.nlp.ling.HasWord
import edu.stanford.nlp.process.Morphology
import edu.stanford.nlp.tagger.maxent.MaxentTagger
import java.io.StringReader

abstract class VocabularyParser(text: String) {
    protected val sentences: MutableList<MutableList<HasWord>> = MaxentTagger.tokenizeText(StringReader(text))
    abstract fun parse(): Set<VocabularyPart>
}