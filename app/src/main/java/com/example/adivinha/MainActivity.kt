package com.example.adivinha;

import android.app.Activity

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.adivinha.R
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var computador: Int = 0
    private lateinit var editText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        val button: Button = findViewById(R.id.button)

        gerarNumeroAleatorio()

        button.setOnClickListener {
            // Obter a suposição do jogador
            val input: String = editText.text.toString()
            if (input.isNotEmpty()) {
                val jogador: Int = input.toInt()

                // Verificar se a suposição está correta
                if (jogador == computador) {
                    exibirMensagem("SE EH O BIXAO MEMO HEIN!", Toast.LENGTH_LONG)
                } else {
                    exibirMensagem("Você perdeu, eu pensei no número $computador e não $jogador", Toast.LENGTH_SHORT)
                }

                // Gerar um novo número aleatório para a próxima rodada
                gerarNumeroAleatorio()
            } else {
                exibirMensagem("Por favor, insira um numero.", Toast.LENGTH_SHORT)
            }
        }
    }

    private fun gerarNumeroAleatorio() {
        computador = Random.nextInt(6)
    }

    private fun exibirMensagem(mensagem: String, duration: Int) {
        Toast.makeText(this, mensagem, duration).show()
    }
}