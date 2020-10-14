package neel.com.bayyinahdreamintensive.model



data class Chapter(
    val lessons : List<Lesson>,
    val quizzes : List<Quiz>
)

class Lesson(val text : String)

interface QuizType {
   val type : String
}

abstract class Quiz{
   abstract val question:String
   abstract val answer:String

}


object MCQ : QuizType {
    override val type = "mcq"
}
object FIB : QuizType{
    override val type = "fib"
}

class McqQuiz(override val question: String,
              override val answer: String,
              val choice_one:String,
              val choice_two:String,
              val choice_three:String,
              val choice_four:String
              ) : Quiz(),QuizType by MCQ

class FibQuiz(override val question: String,
              override val answer: String,
              val user_input : String
              ):Quiz(),QuizType by FIB


fun main() {

    val lesson = Lesson("Demo lesson")
    val lessons = mutableListOf<Lesson>()
    lessons.add(lesson)

    val quizzes = mutableListOf<Quiz>()
    val mcqQuiz = McqQuiz(
        "Demo Question",
        "answer",
        "choice_one",
        "choice_two",
        "choice_three",
        "choice_four"
    )

    val fibQuiz = FibQuiz(
        "Fib Question",
        "answer",
        "user_input"
    )

    quizzes.add(mcqQuiz)
    quizzes.add(fibQuiz)

    val chapter = Chapter(lessons,quizzes)
}