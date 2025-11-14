package com.example.prova_pdm_jara

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var txtnome: EditText
    private lateinit var txtmatricula: EditText
    private lateinit var txtnota: EditText
    private lateinit var btnCadastrar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(findViewById(R.id.toolbarMenu1))
        supportActionBar?.title = "Resgistro de Alunos"
        supportActionBar?.setDisplayHomeAsUpEnabled(false)

        txtnota = findViewById(R.id.editTextNota)
        txtnome = findViewById(R.id.editTextNome)
        txtmatricula = findViewById(R.id.editTextMatricula)

        btnCadastrar = findViewById(R.id.btnCadastrar)

        btnCadastrar.setOnClickListener {
            onClickCadastrar()
        }

    }

    private fun onClickCadastrar() {
        val nome = txtnome.text.toString()
        val matricula = txtmatricula.text.toString()
        val nota = txtnota.text.toString().toDoubleOrNull()
        val img = R.drawable.aluno1

        var student: Student = Student(nome, matricula, nota ?: 0.0, img)

        val intent = Intent(this, ListarActivity::class.java)
        intent.putExtra("aluno", student.nome)
        intent.putExtra("matricula", student.matricula)
        intent.putExtra("notaFinal", student.notaFinal)
        intent.putExtra("imagem", student.imagem)
        startActivity(intent)

        Toast.makeText(
            this@MainActivity,
            "Aluno $nome cadastrado com sucesso",
            Toast.LENGTH_SHORT
        ).show()

        txtnome.text.clear()
        txtmatricula.text.clear()
        txtnota.text.clear()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menubar, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val intent: Intent

        when (item.itemId) {
            R.id.action_Listar -> {
                intent = Intent(this, ListarActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

}