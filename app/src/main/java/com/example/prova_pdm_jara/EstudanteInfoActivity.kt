package com.example.prova_pdm_jara

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class EstudanteInfoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activy_info_aluno)

        setSupportActionBar(findViewById(R.id.toolbarMenu3))
        supportActionBar?.title = "Informações do Aluno"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val nome = intent.getStringExtra("nome")
        val matricula = intent.getStringExtra("matricula")
        val notaFinal = intent.getDoubleExtra("notaFinal", 0.0)
        val imagem = intent.getIntExtra("imagem", 0)
        val situacao = intent.getStringExtra("situacao")

        val img : ImageView = findViewById(R.id.imageEstudante)
        val tNome : TextView = findViewById(R.id.infoNome)
        val tMatricula : TextView = findViewById(R.id.infoMatricula)
        val tNota: TextView = findViewById(R.id.infoNota)
        val tSituacao: TextView = findViewById(R.id.infoSituacao)

        tNome.text = "Nome: $nome"
        tMatricula.text = "Matricula $matricula"
        tNota.text = "Nota Final: ${notaFinal.toString()}"
        tSituacao.text = "Situação: $situacao"

        if(imagem != 0){
            img.setImageResource(imagem)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menubar2, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent: Intent

        when (item.itemId) {
            R.id.actionCadastrar -> {
                intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

}