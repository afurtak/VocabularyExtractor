package vocabularyextractor.vocabularyParser.phrasalVerbs

import edu.stanford.nlp.ling.HasWord
import edu.stanford.nlp.trees.TypedDependency
import edu.stanford.nlp.trees.UniversalEnglishGrammaticalRelations
import vocabularyextractor.vocabularyParser.VocabularyParser
import vocabularyextractor.vocabularyParser.VocabularyPart
import vocabularyextractor.vocabularyParser.VocabularyType


abstract class PhrasalVerbParser(text: String): VocabularyParser(text) {
    fun isPhrasal(dependency: TypedDependency) =
        dependency.reln() == UniversalEnglishGrammaticalRelations.PHRASAL_VERB_PARTICLE

    fun parsePhrasalVerb(dependency: TypedDependency, context: List<HasWord>): VocabularyPart {
        val first =getBaseForm(dependency.gov().word())
        val second = dependency.dep().word()
        return VocabularyPart(
            VocabularyType.PHRASAL_VERB,
            "$first $second",
            context
        )
    }
}