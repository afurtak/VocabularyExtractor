package vocabularyextractor.vocabularyParser.lexicalizedParsers

import edu.stanford.nlp.ling.HasWord
import edu.stanford.nlp.trees.TypedDependency
import edu.stanford.nlp.trees.UniversalEnglishGrammaticalRelations
import vocabularyextractor.dictionary.isProperWord
import vocabularyextractor.vocabularyParser.VocabularyPart
import vocabularyextractor.vocabularyParser.VocabularyType
import vocabularyextractor.vocabularyParser.getBaseForm

class CompoundNounsAdapter: ComplexVocabularyParseAdapter {
    override fun isProper(expression: VocabularyPart): Boolean {
        for (word in expression.content.split(" "))
            if (!word.isProperWord())
                return false
        return true
    }

    override fun isDependencyRightType(dependency: TypedDependency) =
            dependency.reln() == UniversalEnglishGrammaticalRelations.COMPOUND_MODIFIER

    override fun parseVocabularyPart(dependency: TypedDependency, context: List<HasWord>): VocabularyPart {
        val first = dependency.gov().word().getBaseForm()
        val second = dependency.dep().word()
        return VocabularyPart(
            VocabularyType.COMPOUND_NOUN,
            "$second $first".toLowerCase(),
            context
        )
    }
}