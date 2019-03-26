package vocabularyextractor.vocabularyParser.lexicalizedParsers

import edu.stanford.nlp.ling.HasWord
import edu.stanford.nlp.trees.TypedDependency
import edu.stanford.nlp.trees.UniversalEnglishGrammaticalRelations
import vocabularyextractor.vocabularyParser.VocabularyPart
import vocabularyextractor.vocabularyParser.VocabularyType
import vocabularyextractor.vocabularyParser.getBaseForm

class PhrasalVerbsAdapter: ComplexVocabularyParseAdapter {
    override fun parseVocabularyPart(dependency: TypedDependency, context: List<HasWord>): VocabularyPart {
        val first = dependency.gov().word().getBaseForm()
        val second = dependency.dep().word()
        return VocabularyPart(
            VocabularyType.PHRASAL_VERB,
            "$first $second".toLowerCase(),
            context
        )
    }

    override fun isDependencyRightType(dependency: TypedDependency) =
            dependency.reln() == UniversalEnglishGrammaticalRelations.PHRASAL_VERB_PARTICLE
}