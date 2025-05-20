package vcmsa.ci.flashcards

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.graphics.Color
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class second_screen : AppCompatActivity() {

    data class Question(val text: String, val answer: Boolean)

    private val questions = listOf(
        Question("The sky is blue.", true),
        Question("Cats are reptiles.", false),
        Question("2 + 2 = 4", true),
        Question("Java is the same as JavaScript.", false),
        Question("Water freezes at 0°C.", true)
    )

    private var currentIndex = 0
    private var hasAnswered = false
    private var score = 0

    private lateinit var textViewQuestion: TextView
    private lateinit var tvResponse: TextView
    private lateinit var btnTrue: Button
    private lateinit var btnFalse: Button
    private lateinit var btnNext: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second_screen)

        textViewQuestion = findViewById(R.id.textView2)
        tvResponse = findViewById(R.id.tvResponse)
        btnTrue = findViewById(R.id.btnTrue)
        btnFalse = findViewById(R.id.btnFalse)
        btnNext = findViewById(R.id.btnNext)

        loadQuestion()

        btnTrue.setOnClickListener { checkAnswer(true) }
        btnFalse.setOnClickListener { checkAnswer(false) }

        btnNext.setOnClickListener {
            if (!hasAnswered) {
                Toast.makeText(this, "Please answer the question first!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            currentIndex++
            if (currentIndex < questions.size) {
                loadQuestion()
            } else {
                showScoreDialog()
            }
        }
    }

    private fun loadQuestion() {
        val currentQuestion = questions[currentIndex]
        textViewQuestion.text = currentQuestion.text
        tvResponse.text = ""
        hasAnswered = false
    }

    private fun checkAnswer(userAnswer: Boolean) {
        if (hasAnswered) return

        val correctAnswer = questions[currentIndex].answer

        if (userAnswer == correctAnswer) {
            tvResponse.text = "Correct"
            tvResponse.setTextColor(Color.GREEN)
            score++
        } else {
            tvResponse.text = "Incorrect"
            tvResponse.setTextColor(Color.RED)
        }

        hasAnswered = true
    }

    private fun showScoreDialog() {
        val feedback = if (score >= 3) "Great job!" else "Keep practising!"

        AlertDialog.Builder(this)
            .setTitle("Quiz Finished")
            .setMessage("Your score is $score out of ${questions.size}.\n\n$feedback")
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .setCancelable(false)
            .show()

    }
}
