package vcmsa.ci.flashcards

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import vcmsa.ci.flashcards.R.id.btnBack

class third_screen : AppCompatActivity() {

    private lateinit var tvAnswers: TextView
    private lateinit var btnBack: Button
    private lateinit var btnClear: Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third_screen)

        tvAnswers = findViewById(R.id.textView3)
        btnBack = findViewById(R.id.btnBack)
        btnClear = findViewById(R.id.btnClear2)

        val answers = intent.getStringArrayListExtra("userAnswers")
        tvAnswers.text = answers?.joinToString("\n\n") ?: "No answers to show."

        btnBack.setOnClickListener {
            val intent = Intent(this, second_screen::class.java)
            startActivity(intent)
            finish()
        }

        btnClear.setOnClickListener {
            tvAnswers.text = ""
        }
    }
}
