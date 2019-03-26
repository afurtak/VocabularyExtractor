import org.junit.Test
import vocabularyextractor.dictionary.PhrasalVerbsDictionary
import vocabularyextractor.dictionary.PhrasalVerbsDictionary.phrasalVerbs
import vocabularyextractor.vocabularyParser.VocabularyType
import vocabularyextractor.vocabularyParser.lexicalizedParsers.LexicalizedVocabularyParser

class VocabularyParserTest {
    @Test
    fun test() {
        val vocabulary = LexicalizedVocabularyParser(friendsTranscipt).parse()
        vocabulary.forEach {
            println("${it.content}   ${it.getContext()}")
        }

        vocabulary
            .filter { it.type == VocabularyType.PHRASAL_VERB }
            .forEach {
                println(it.getContext())
                println("${it.content}   -   ${phrasalVerbs[it.content]}")
                println()
            }
        println(vocabulary.size)
    }
}

val friendsTranscipt = "There's nothing to tell.  He's just some guy I work with. \n" +
        "C'mon, you're going out with the guy.  There's gotta be something wrong with him. \n" +
        "All right Joey, be nice.   So does he have a hump.  A hump and a hairpiece. \n" +
        "Wait, does he eat chalk. \n" +
        "Just, 'cause, I don't want her to go through what I went through with Carl- oh. \n" +
        "Okay, everybody relax.  This is not even a date.  It's just two people going out to dinner and- not having sex. \n" +
        "Sounds like a date to me. \n" +
        "Alright, so I'm back in high school, I'm standing in the middle of the cafeteria, and I realize I am totally naked. \n" +
        "Oh, yeah.  Had that dream. \n" +
        "Then I look down, and I realize there's a phone.  there. \n" +
        "Instead of. \n" +
        "That's right. \n" +
        "Never had that dream. \n" +
        "No. \n" +
        "All of a sudden, the phone starts to ring.  Now I don't know what to do, everybody starts looking at me. \n" +
        "And they weren't looking at you before. \n" +
        "Finally, I figure I'd better answer it, and it turns out it's my mother, which is very-very weird, because- she never calls me. \n" +
        " Hi. \n" +
        "This guy says hello, I wanna kill myself. \n" +
        "Are you okay, sweetie. \n" +
        "I just feel like someone reached down my throat, grabbed my small intestine, pulled it out of my mouth and tied it around my neck. \n" +
        "Cookie. \n" +
        " Carol moved her stuff out today. \n" +
        "Ohh. \n" +
        " Let me get you some coffee. \n" +
        "Thanks. \n" +
        "Ooh.  Oh.  \n" +
        "No, no don't.  Stop cleansing my aura.  No, just leave my aura alone, okay. \n" +
        "Fine.   Be murky. \n" +
        "I'll be fine, alright.  Really, everyone.  I hope she'll be very happy. \n" +
        "No you don't. \n" +
        "No I don't, to hell with her, she left me. \n" +
        "And you never knew she was a lesbian. \n" +
        "No.  Okay.  Why does everyone keep fixating on that.  She didn't know, how should I know. \n" +
        "Sometimes I wish I was a lesbian.   Did I say that out loud. \n" +
        "I told mom and dad last night, they seemed to take it pretty well. \n" +
        "Oh really, so that hysterical phone call I got from a woman at sobbing 3:00 A. M. , \"I'll never have grandchildren, I'll never have grandchildren. \" was what.   A wrong number. \n" +
        "Sorry. \n" +
        "Alright Ross, look.  You're feeling a lot of pain right now.  You're angry.  You're hurting.  Can I tell you what the answer is. \n" +
        "Strip joint.  C'mon, you're single.  Have some hormones. \n" +
        "I don't want to be single, okay.  I just.  I just- I just wanna be married again. \n" +
        "And I just want a million dollars.  \n" +
        "Rachel. \n" +
        "Oh God Monica hi.  Thank God.  I just went to your building and you weren't there and then this guy with a big hammer said you might be here and you are, you are. \n" +
        "Can I get you some coffee. \n" +
        " De-caff.   Okay, everybody, this is Rachel, another Lincoln High survivor.   This is everybody, this is Chandler, and Phoebe, and Joey, and- you remember my brother Ross. \n" +
        "Hi, sure. \n" +
        "Hi. \n" +
        "So you wanna tell us now, or are we waiting for four wet bridesmaids. \n" +
        "Oh God.  well, it started about a half hour before the wedding.  I was in the room where we were keeping all the presents, and I was looking at this gravy boat.  This really gorgeous Lamauge gravy boat.  When all of a sudden- Sweet 'n' Lo. - I realized that I was more turned on by this gravy boat than by Barry.  And then I got really freaked out, and that'how much Barry looks like Mr.  Potato Head.  Y'know, I mean, I always knew looked familiar, but.  Anyway, I just had to get out of there, and I started wondering 'Why am I doing this, and who am I doing this for. '.   So anyway I just didn't know where to go, and I know that you and I have kinda drifted apart, but you're the only person I knew who lived here in the city. \n" +
        "Who wasn't invited to the wedding. \n" +
        "Ooh, I was kinda hoping that wouldn't be an issue.  \n" +
        "Now I'm guessing that he bought her the big pipe organ, and she's really not happy about it. \n" +
        " Tuna or egg salad.   Decide. \n" +
        " I'll have whatever Christine is having. \n" +
        " Daddy, I just.  I can't marry him.  I'm sorry.  I just don't love him.  Well, it matters to me. \n" +
        " If I let go of my hair, my head will fall off. \n" +
        " Ooh, she should not be wearing those pants. \n" +
        "I say push her down the stairs. \n" +
        "Phoebe, Ross, Chandler, Push her down the stairs.  Push her down the stairs.  Push her down the stairs. \n" +
        "C'mon Daddy, listen to me.  It's like, it's like, all of my life, everyone has always told me, 'You're a shoe.  You're a shoe, you're a shoe, you're a shoe. '.  And today I just stopped and I said, 'What if I don't wanna be a shoe.  What if I wanna be a- a purse, y'know.  Or a- or a hat.  No, I'm not saying I want you to buy me a hat, I'm saying I am a ha- It's a metaphor, Daddy. \n" +
        "You can see where he'd have trouble. \n" +
        "Look Daddy, it's my life.  Well maybe I'll just stay here with Monica. \n" +
        "Well, I guess we've established who's staying here with Monica. \n" +
        "Well, maybe that's my decision.  Well, maybe I don't need your money.  Wait.  Wait, I said maybe. \n" +
        "Just breathe, breathe.  that's it.  Just try to think of nice calm things. \n" +
        " Raindrops on roses and rabbits and kittens,  bluebells and sleighbells and- something with mittens.  La la la la. something and noodles with string.   These are a few. \n" +
        "I'm all better now. \n" +
        " I helped. \n" +
        "Okay, look, this is probably for the best, y'know.  Independence.  Taking control of your life.   The whole, 'hat' thing. \n" +
        " And hey, you need anything, you can always come to Joey.  Me and Chandler live across the hall.  And he's away a lot. \n" +
        "Joey, stop hitting on her.  It's her wedding day. \n" +
        "What, like there's a rule or something. \n" +
        "Please don't do that again, it's a horrible sound. \n" +
        " It's, uh, it's Paul. \n" +
        "Oh God, is it 6:30.   Buzz him in. \n" +
        "Who's Paul. \n" +
        "Paul the Wine Guy, Paul. \n" +
        "Maybe. Wait.  Your 'not a real date' tonight is with Paul the Wine Guy. \n" +
        "He finally asked you out. \n" +
        "Yes. \n" +
        "Ooh, this is a Dear Diary moment. \n" +
        "Rach, wait, I can cancel. \n" +
        "Please, no, go, that'd be fine. \n" +
        " Are, are you okay.  I mean, do you want me to stay. \n" +
        " That'd be good. \n" +
        " Really. \n" +
        " No, go on.  It's Paul the Wine Guy. \n" +
        "What does that mean.    Does he sell it, drink it, or just complain a lot.  \n" +
        "Hi, come in.  Paul, this is.  .  everybody, everybody, this is Paul. \n" +
        "Hey.  Paul.  Hi.  The Wine Guy.  Hey. \n" +
        "I'm sorry, I didn't catch your name.  Paul, was it. \n" +
        "Okay, umm-umm, I'll just--I'll be right back, I just gotta go ah, go ah. \n" +
        "A wandering. \n" +
        "Change.   Okay, sit down.   Two seconds. \n" +
        "Ooh, I just pulled out four eyelashes.  That can't be good. \n" +
        " Hey, Paul. \n" +
        "Yeah. \n" +
        "Here's a little tip, she really likes it when you rub her neck in the same spot over and over and over again until it starts to get a little red. \n" +
        " Shut up, Joey. \n" +
        "So Rachel, what're you, uh.  what're you up to tonight. \n" +
        "Well, I was kinda supposed to be headed for Aruba on my honeymoon, so nothing. \n" +
        "Right, you're not even getting your honeymoon, God.  No, no, although, Aruba, this time of year.  talk about your-  -big lizards.  Anyway, if you don't feel like being alone tonight, Joey and Chandler are coming over to help me put together my new furniture. \n" +
        " Yes, and we're very excited about it. \n" +
        "Well actually thanks, but I think I'm just gonna hang out here tonight.   It's been kinda a long day. \n" +
        "Okay, sure. \n" +
        "Hey Pheebs, you wanna help. \n" +
        "Oh, I wish I could, but I don't want to. \n" +
        "Commercial Break\n" +
        " Love is sweet as summer showers, love is a wondrous work of art, but your love oh your love, your love. is like a giant pigeon. crapping on my heart.   La-la-la-la-la-  Thank you.   La-la-la-la. ohhh. \n" +
        " I'm supposed to attach a brackety thing to the side things, using a bunch of these little worm guys.  I have no brackety thing, I see no whim guys whatsoever and- I cannot feel my legs. \n" +
        "I'm thinking we've got a bookcase here. \n" +
        "It's a beautiful thing. \n" +
        " What's this. \n" +
        "I would have to say that is an 'L'-shaped bracket. \n" +
        "Which goes where. \n" +
        "I have no idea. \n" +
        "Done with the bookcase. \n" +
        "All finished. \n" +
        " This was Carol's favorite beer.  She always drank it out of the can, I should have known. \n" +
        "Hey-hey-hey-hey, if you're gonna start with that stuff we're outta here. \n" +
        "Yes, please don't spoil all this fun. \n" +
        "Ross, let me ask you a question.  She got the furniture, the stereo, the good TV- what did you get. \n" +
        "You guys. \n" +
        "Oh, God. \n" +
        "You got screwed. \n" +
        "Oh my God. \n" +
        "Oh my God. \n" +
        "I know, I know, I'm such an idiot.  I guess I should have caught on when she started going to the dentist four and five times a week.  I mean, how clean can teeth get. \n" +
        "My brother's going through that right now, he's such a mess.  How did you get through it. \n" +
        "Well, you might try accidentally breaking something valuable of hers, say her-\n" +
        "-leg. \n" +
        " That's one way.  Me, I- I went for the watch. \n" +
        "You actually broke her watch.   Wow.   The worst thing I ever did was, I-I shredded by boyfriend's favorite bath towel. \n" +
        "Ooh, steer clear of you. \n" +
        "That's right.  \n" +
        "Barry, I'm sorry.  I am so sorry.  I know you probably think that this is all about what I said the other day about you making love with your socks on, but it isn't.  it isn't, it's about me, and I ju-  Hi, machine cut me off again.  anyway. look, look, I know that some girl is going to be incredibly lucky to become Mrs.  Barry Finkel, but it isn't me, it's not me.   And not that I have any idea who me is right now, but you just have to give me a chance too.  \n" +
        "I'm divorced.   I'm only 26 and I'm divorced. \n" +
        "Shut up. \n" +
        "You must stop.  \n" +
        "That only took me an hour. \n" +
        "Look, Ross, you gotta understand, between us we haven't had a relationship that has lasted longer than a Mento.    You, however have had the love of a woman for four years.    Four years of closeness and sharing at the end of which she ripped your heart out, and that is why we don't do it.   I don't think that was my point. \n" +
        "You know what the scariest part is.  What if there's only one woman for everybody, y'know.  I mean what if you get one woman- and that's it.  Unfortunately in my case, there was only one woman- for her. \n" +
        "What are you talking about.  'One woman'.  That's like saying there's only one flavor of ice cream for you.  Lemme tell you something, Ross.  There's lots of flavors out there.  There's Rocky Road, and Cookie Dough, and Bing.  Cherry Vanilla.  You could get 'em with Jimmies, or nuts, or whipped cream.  This is the best thing that ever happened to you.  You got married, you were, like, what, eight.  Welcome back to the world.  Grab a spoon. \n" +
        "I honestly don't know if I'm hungry or horny. \n" +
        "Stay out of my freezer.  \n" +
        "Ever since she walked out on me, I, uh. \n" +
        "What.  What, you wanna spell it out with noodles. \n" +
        "No, it's, it's more of a fifth date kinda revelation. \n" +
        "Oh, so there is gonna be a fifth date. \n" +
        "Isn't there. \n" +
        "Yeah.  yeah, I think there is.  -What were you gonna say. \n" +
        "Well, ever-ev-.  ever since she left me, um, I haven't been able to, uh, perform.   . Sexually. \n" +
        " Oh God, oh God, I am sorry.  I am so sorry. \n" +
        "It's okay. \n" +
        "I know being spit on is probably not what you need right now.  Um.  how long. \n" +
        "Two years. \n" +
        "Wow.  I'm-I'm-I'm glad you smashed her watch. \n" +
        "So you still think you, um.  might want that fifth date. \n" +
        ". Yeah.  Yeah, I do. \n" +
        "We are gathered here today to join Joanne Louise Cunningham and Charles, Chachi-Chachi-Chachi, Arcola in the bound of holy matrimony. \n" +
        "Oh. see.  but Joanne loved Chachi.  That's the difference. \n" +
        " Grab a spoon.  Do you know how long it's been since I've grabbed a spoon.  Do the words 'Billy, don't be a hero' mean anything to you. \n" +
        "Great story.   But, I uh, I gotta go, I got a date with Andrea--Angela--Andrea.   Oh man, \n" +
        "Angela's the screamer, Andrea has cats. \n" +
        "Right.   Thanks.   It's June.   I'm outta here.  \n" +
        "Y'know, here's the thing.  Even if I could get it together enough to- to ask a woman out,.  who am I gonna ask.  \n" +
        "Commercial Break\n" +
        "Isn't this amazing.  I mean, I have never made coffee before in my entire life. \n" +
        "That is amazing. \n" +
        "Congratulations. \n" +
        "Y'know, I figure if I can make coffee, there isn't anything I can't do. \n" +
        "If can invade Poland, there isn't anything I can't do. \n" +
        "Listen, while you're on a roll, if you feel like you gotta make like a Western omelet or something.   Although actually I'm really not that hungry. \n" +
        " Oh good, Lenny and Squigy are here. \n" +
        "Morning.  Good morning. \n" +
        " Morning. \n" +
        "Morning, Paul. \n" +
        "Hello, Paul. \n" +
        "Hi, Paul, is it. \n" +
        "Thank you.   Thank you so much. \n" +
        "Stop. \n" +
        "No, I'm telling you last night was like umm, all my birthdays, both graduations, plus the barn raising scene in Witness. \n" +
        "We'll talk later. \n" +
        "Yeah.   Thank you.  \n" +
        "That wasn't a real date.  What the hell do you do on a real date. \n" +
        "Shut up, and put my table back. \n" +
        "Okayyy.  \n" +
        "All right, kids, I gotta get to work.  If I don't input those numbers,.  it doesn't make much of a difference. \n" +
        "So, like, you guys all have jobs. \n" +
        "Yeah, we all have jobs.  See, that's how we buy stuff. \n" +
        "Yeah, I'm an actor. \n" +
        "Wow.  Would I have seen you in anything. \n" +
        "I doubt it.  Mostly regional work. \n" +
        "Oh wait, wait, unless you happened to catch the Reruns' production of Pinocchio, at the little theater in the park. \n" +
        "Look, it was a job all right. \n" +
        "'Look, Gippetto, I'm a real live boy. '\n" +
        "I will not take this abuse.  \n" +
        "You're right, I'm sorry.   \"Once I was a wooden boy, a little wooden boy. \"\n" +
        "You should both know, that he's a dead man.   Oh, Chandler.  \n" +
        "So how you doing today.  Did you sleep okay.  Talk to Barry.  I can't stop smiling. \n" +
        "I can see that.  You look like you slept with a hanger in your mouth. \n" +
        "I know, he's just so, so.  Do you remember you and Tony DeMarco. \n" +
        "Oh, yeah. \n" +
        "Well, it's like that.  With feelings. \n" +
        "Oh wow.  Are you in trouble. \n" +
        "Big time. \n" +
        "Want a wedding dress.    Hardly used. \n" +
        "I think we are getting a little ahead of selves here.  Okay.  Okay.  I am just going to get up, go to work and not think about him all day.  Or else I'm just gonna get up and go to work. \n" +
        "Oh, look, wish me luck. \n" +
        "What for. \n" +
        "I'm gonna go get one of those  job things. \n" +
        "Hey, Monica. \n" +
        "Hey Frannie, welcome back.  How was Florida. \n" +
        "You had sex, didn't you. \n" +
        "How do you do that. \n" +
        "Oh, I hate you, I'm pushing my Aunt Roz through Parrot Jungle and you're having sex.   So.  Who. \n" +
        "You know Paul. \n" +
        "Paul the Wine Guy.  Oh yeah, I know Paul. \n" +
        "You mean you know Paul like I know Paul. \n" +
        "Are you kidding.  I take credit for Paul.  Y'know before me, there was no snap in his turtle for two years. \n" +
        "Of course it was a line. \n" +
        "Why.  Why.  Why, why would anybody do something like that. \n" +
        "I assume we're looking for an answer more sophisticated than 'to get you into bed'. \n" +
        "I hate men.   I hate men. \n" +
        "Oh no, don't hate, you don't want to put that out into the universe. \n" +
        "Is it me.  Is it like I have some sort of beacon that only dogs and men with severe emotional problems can hear. \n" +
        "All right, c'mere, gimme your feet.  \n" +
        "I just thought he was nice, y'know. \n" +
        " I can't believe you didn't know it was a line. \n" +
        "Guess what. \n" +
        "You got a job. \n" +
        "Are you kidding.  I'm trained for nothing.  I was laughed out of twelve interviews today. \n" +
        "And yet you're surprisingly upbeat. \n" +
        "You would be too if you found John and David boots on sale, fifty percent off. \n" +
        "Oh, how well you know me. \n" +
        "They're my new 'I don't need a job, I don't need my parents, I've got great boots' boots. \n" +
        "How'd you pay for them. \n" +
        "Uh, credit card. \n" +
        "And who pays for that. \n" +
        "Um.  my.  father. \n" +
        "Oh God, come on you guys, is this really necessary.   I mean, I can stop charging anytime I want. \n" +
        "C'mon, you can't live off your parents your whole life. \n" +
        "I know that.  That's why I was getting married. \n" +
        "Give her a break, it's hard being on your own for the first time. \n" +
        "Thank you. \n" +
        "You're welcome.  I remember when I first came to this city.  I was fourteen.  My mom had just killed herself and my step-dad was back in prison, and I got here, and I didn't know anybody.  And I ended up living with this albino guy who was, like, cleaning windshields outside port authority, and then he killed himself, and then I found aromatherapy.  So believe me, I know exactly how you feel. \n" +
        "The word you're looking for is 'Anyway'. \n" +
        "All right, you ready. \n" +
        "No.   No, no, I'm not ready.   How can I be ready.   \"Hey, Rach.   You ready to jump out the airplane without your parachute. \"  Come on, I can't do this. \n" +
        "You can, I know you can. \n" +
        "I don't think so. \n" +
        "Come on, you made coffee.    You can do anything.  \n" +
        "C'mon, cut.  Cut, cut, cut,. \n" +
        "Cut, cut, cut, cut, cut, cut, cut.  \n" +
        "Y'know what.   I think we can just leave it at that.   It's kinda like a symbolic gesture. \n" +
        " Rachel.   That was a library card. \n" +
        "Cut, cut, cut, cut, cut, cut, cut. \n" +
        " Y'know, if you listen closely, you can hear a thousand retailers scream. \n" +
        "Welcome to the real world.  It sucks.  You're gonna love it. \n" +
        "Well, that's it  You gonna crash on the couch. \n" +
        "No.  No, I gotta go home sometime. \n" +
        "You be okay. \n" +
        "Yeah. \n" +
        "Hey Mon, look what I just found on the floor.   What. \n" +
        "That's Paul's watch.  You just put it back where you found it.  Oh boy.  Alright.  Goodnight, everybody. \n" +
        "Goodnight. \n" +
        "Mmm.   Oh, no-\n" +
        "Sorry-\n" +
        "No no no, go-\n" +
        "No, you have it, really, I don't want it-\n" +
        "Split it. \n" +
        "Okay. \n" +
        "Okay.   You know you probably didn't know this, but back in high school, I had a, um, major crush on you. \n" +
        "I knew. \n" +
        "You did.  Oh.  I always figured you just thought I was Monica's geeky older brother. \n" +
        "I did. \n" +
        "Oh.  Listen, do you think- and try not to let my intense vulnerability become any kind of a factor here- but do you think it would be okay if I asked you out.  Sometime.  Maybe. \n" +
        "Yeah, maybe. \n" +
        "Okay.  okay, maybe I will. \n" +
        "Goodnight. \n" +
        "Goodnight. \n" +
        "See ya.  Waitwait, what's with you. \n" +
        "I just grabbed a spoon.  \n" +
        "Closing Credits\n" +
        "I can't believe what I'm hearing here. \n" +
        " I can't believe what I'm hearing here. \n" +
        "What.  I-I said you had a-\n" +
        " What I said you had. \n" +
        " Would you stop. \n" +
        "Oh, was I doing it again. \n" +
        "Yes. \n" +
        "I said that you had a nice butt, it's just not a great butt. \n" +
        "Oh, you wouldn't know a great butt if it came up and bit ya. \n" +
        "There's an image. \n" +
        " Would anybody like more coffee. \n" +
        "Did you make it, or are you just serving it. \n" +
        "I'm just serving it. \n" +
        "Yeah.  Yeah, I'll have a cup of coffee. \n" +
        "Kids, new dream.  I'm in Las Vegas.  \n" +
        " Ahh, miss.    More coffee. \n" +
        "Ugh.   Excuse me, could you give this to that guy over there.   Go ahead.   Thank you.   Sorry.   Okay, Las Vegas. \n" +
        "Okay, so, I'm in Las Vegas.  I'm Liza Minelli-\n".removeSuffix("\n")