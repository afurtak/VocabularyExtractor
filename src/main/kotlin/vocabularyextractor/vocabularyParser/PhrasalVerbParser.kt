package vocabularyextractor.vocabularyParser

import edu.stanford.nlp.ling.HasWord
import edu.stanford.nlp.process.Morphology
import edu.stanford.nlp.tagger.maxent.MaxentTagger
import edu.stanford.nlp.trees.TypedDependency
import edu.stanford.nlp.trees.UniversalEnglishGrammaticalRelations
import java.io.StringReader


abstract class PhrasalVerbParser(text: String) {
    protected val sentences: MutableList<MutableList<HasWord>> = MaxentTagger.tokenizeText(StringReader(text))

    abstract fun parse(): Set<VocabularyPart>

    fun isPhrasal(dependency: TypedDependency) =
        dependency.reln() == UniversalEnglishGrammaticalRelations.PHRASAL_VERB_PARTICLE

    fun parsePhrasalVerb(dependency: TypedDependency, context: List<HasWord>): VocabularyPart {
        val first =getBaseForm(dependency.gov().word())
        val second = dependency.dep().word()
        return VocabularyPart(VocabularyType.PHRASAL_VERB, "$first $second", context)
    }

    fun getBaseForm(word: String): String =
        Morphology().stem(word)
}