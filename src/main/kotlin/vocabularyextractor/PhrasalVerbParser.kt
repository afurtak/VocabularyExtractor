package vocabularyextractor

import edu.stanford.nlp.ling.HasWord
import edu.stanford.nlp.process.Morphology
import edu.stanford.nlp.tagger.maxent.MaxentTagger
import edu.stanford.nlp.trees.TypedDependency
import edu.stanford.nlp.trees.UniversalEnglishGrammaticalRelations
import java.io.StringReader


abstract class PhrasalVerbParser(text: String) {
    protected val sentences: MutableList<MutableList<HasWord>> = MaxentTagger.tokenizeText(StringReader(text))

    abstract fun parsePhrasalVerbs(): Set<String>

    fun isPhrasal(dependency: TypedDependency): Boolean {
        return dependency.reln() == UniversalEnglishGrammaticalRelations.PHRASAL_VERB_PARTICLE
    }

    fun parsePhrasalVerb(dependency: TypedDependency): String {
        val first =getBaseForm(dependency.gov().word())
        val second = dependency.dep().word()
        return "$first $second"
    }

    fun getBaseForm(word: String): String {
        return Morphology().stem(word)
    }
}