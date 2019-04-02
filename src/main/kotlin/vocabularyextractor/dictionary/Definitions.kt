package vocabularyextractor.dictionary

import net.sf.extjwnl.dictionary.Dictionary.getDefaultResourceInstance
import vocabularyextractor.vocabularyParser.VocabularyPart

object Definitions {
    val dictionary
            by lazy {
                getDefaultResourceInstance()
            }

    fun getDefinition(word: VocabularyPart): List<String>  =
            mutableListOf<String>().apply {
                dictionary.getIndexWord(word.type.getWordNetTag(), word.content)
                    ?.senses
                    ?.forEach {
                        add(it.gloss.toString())
                    }
            }
}