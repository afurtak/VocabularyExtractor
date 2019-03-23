package vocabularyextractor

import edu.stanford.nlp.parser.lexparser.LexicalizedParser
import edu.stanford.nlp.parser.nndep.DependencyParser
import edu.stanford.nlp.tagger.maxent.MaxentTagger

object NLPModels {
    private const val lexicalParserModelPath = "NLPModels/LexParser/englishFactored.ser.gz"
    private const val dependencyParserModelPath = "NLPModels/NNParser/english_UD.gz"
    private const val posTaggerModelPath = "NLPModels/POSTagger/english-bidirectional-distsim.tagger"

    val lexicalParser: LexicalizedParser
            by lazy {
                LexicalizedParser.loadModel(lexicalParserModelPath)
            }

    val dependencyParser: DependencyParser
            by lazy {
                DependencyParser.loadFromModelFile(dependencyParserModelPath)
            }

    val posTagger
            by lazy {
                MaxentTagger(posTaggerModelPath)
            }
}