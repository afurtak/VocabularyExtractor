package vocabularyextractor.vocabularyParser.lexicalizedParsers

import edu.stanford.nlp.ling.HasWord
import edu.stanford.nlp.trees.TypedDependency
import vocabularyextractor.vocabularyParser.VocabularyPart

interface LexicalizedVocabularyParserAdapter {
    fun parseVocabularyType(dependency: TypedDependency, context: List<HasWord>): VocabularyPart
    fun isDependencyRightType(dependency: TypedDependency): Boolean
}