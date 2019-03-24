import org.junit.Test
import vocabularyextractor.vocabularyParser.LexicalizedPhrasalVerbsParser
import vocabularyextractor.vocabularyParser.NeuralNetworkPhrasalVerbParser


class PhrasalVerbParserTest {

    @Test
    fun dependencyParserTest() {
        val testText = listOf(
            "Eventually, I ran out of patience and answered back– I said I was not going to put up with it anymore, and if she wanted to lay me off, she should go ahead. Anyway, to cut a long story short, I stormed out, phoned Mark’modelPath secretary, who put me through to him. I told Mark I’d like to take him up on his offer. So, in the end, everything has worked out perfectly!",
            "When I set off for work this morning, my car broke down, so I ended up taking the bus. As soon as I got off, I bumped into an old schoolmate, Mark. While we were talking, he brought up something I had already found out from some mutual friends- that he had come into some money and had set up his own business. He told me that there was a lot to sort out, and offered to take me on, but I turned him down straight away.",
            "When I clocked in, my boss had a go at me, telling me off in front of everyone. When I got over the initial shock, I told her I’d make up for being late, but it turned out that she had blown up over a deal that had fallen through, after a client of mine had pulled out of a contract. She told me that I wouldn’t get away with it, that I’d let everybody down, and just went on and on…."
        )

        var number = 1
        for (text in testText) {
            println("Text nr. ${number++}")
            val parsers = listOf(
                NeuralNetworkPhrasalVerbParser(text),
                LexicalizedPhrasalVerbsParser(text)
            )

            for (parser in parsers) {
                val phrasalVerbs = parser.parsePhrasalVerbs()
                println("\t${phrasalVerbs.size}")
                for (phrasal in phrasalVerbs)
                    println("\t\t $phrasal")
            }
        }
    }

    @Test
    fun testLexicalizedPhrasalVerbParser() {
        val testText = listOf(
            "Eventually, I ran out of patience and answered back– I said I was not going to put up with it anymore, and if she wanted to lay me off, she should go ahead. Anyway, to cut a long story short, I stormed out, phoned Mark’modelPath secretary, who put me through to him. I told Mark I’d like to take him up on his offer. So, in the end, everything has worked out perfectly!",
            "When I set off for work this morning, my car broke down, so I ended up taking the bus. As soon as I got off, I bumped into an old schoolmate, Mark. While we were talking, he brought up something I had already found out from some mutual friends- that he had come into some money and had set up his own business. He told me that there was a lot to sort out, and offered to take me on, but I turned him down straight away.",
            "When I clocked in, my boss had a go at me, telling me off in front of everyone. When I got over the initial shock, I told her I’d make up for being late, but it turned out that she had blown up over a deal that had fallen through, after a client of mine had pulled out of a contract. She told me that I wouldn’t get away with it, that I’d let everybody down, and just went on and on….",
            "Little Johnny hated going to see the dentist. It wasn't that his dentist was nasty; it was that Johnny wasn't too fond of sweets. His dentist had warned him that his teeth would fall out if he kept up eating candy. Time and time again, the dentist had told him to cut out sweet food or at least cut down on the amount he ate. As he lay down in the dentist's chair, all the horrible memories from his last visit came back to him. On that occasion, the dentist had to pull out one of his teeth! The pain was terrible - even with the anaesthetic the dentist had given him. When the anesthetic wore off it was difficult for him to eat or chew anything at all. This time the check up was much better. His dentist checked out his teeth, made him wash out his mouth with pink liquid and then told him to spit it out into the sink.  That was it. No problems and no pain! Johnny was delighted and so was his dentist. Johnny has finally learned his lesson and was taking better care of his teeth. Well done, Johnny!"
        )

        val quantity = listOf(
            9,
            12,
            12,
            12
        )
        println("---- Lexicalized phrasal verb parser ----")
        for ((i, text) in testText.withIndex()) {
            val phrasalVerbs = LexicalizedPhrasalVerbsParser(text).parsePhrasalVerbs()
            println("actual: ${phrasalVerbs.size}, expected: ${quantity[i]}")
        }
        println("---- Lexicalized phrasal verb parser ----")
        for ((i, text) in testText.withIndex()) {
            val phrasalVerbs = NeuralNetworkPhrasalVerbParser(text).parsePhrasalVerbs()
            println("actual: ${phrasalVerbs.size}, expected: ${quantity[i]}")
        }
    }
}