package vocabularyextractor.vocabularyParser.lexicalizedParsers

import edu.stanford.nlp.ling.HasWord
import edu.stanford.nlp.trees.TypedDependency
import edu.stanford.nlp.trees.UniversalEnglishGrammaticalRelations
import vocabularyextractor.vocabularyParser.VocabularyPart
import vocabularyextractor.vocabularyParser.VocabularyType
import vocabularyextractor.vocabularyParser.getBaseForm

class CompoundNounsAdapter: LexicalizedVocabularyParserAdapter {
    override fun isDependencyRightType(dependency: TypedDependency) =
            dependency.reln() == UniversalEnglishGrammaticalRelations.COMPOUND_MODIFIER

    override fun parseVocabularyType(dependency: TypedDependency, context: List<HasWord>): VocabularyPart {
        val first = getBaseForm(dependency.gov().word())
        val second = dependency.dep().word()
        return VocabularyPart(
            VocabularyType.COMPOUND_NOUN,
            "$second $first".toLowerCase(),
            context
        )
    }
}