package vocabularyextractor.vocabularyParser.compoundNouns

import edu.stanford.nlp.ling.HasWord
import edu.stanford.nlp.trees.TypedDependency
import edu.stanford.nlp.trees.UniversalEnglishGrammaticalRelations
import vocabularyextractor.vocabularyParser.VocabularyParser
import vocabularyextractor.vocabularyParser.VocabularyPart
import vocabularyextractor.vocabularyParser.VocabularyType

abstract class CompoundNounsParser(text: String): VocabularyParser(text) {
    fun isCompound(dependency: TypedDependency) =
        dependency.reln() == UniversalEnglishGrammaticalRelations.COMPOUND_MODIFIER

    fun parseCompoundNoun(dependency: TypedDependency, context: List<HasWord>): VocabularyPart {
        val first = getBaseForm(dependency.gov().word())
        val second = dependency.dep().word()
        return VocabularyPart(
            VocabularyType.COMPOUND_NOUN,
            "$second $first",
            context
        )
    }
}