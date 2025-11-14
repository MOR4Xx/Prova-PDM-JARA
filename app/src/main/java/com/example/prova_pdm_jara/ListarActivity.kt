package com.example.prova_pdm_jara

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class ListarActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudentAdapter
    private var students: MutableList<Student>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listar)

        setSupportActionBar(findViewById(R.id.toolbarMenu2))
        supportActionBar?.title = "Resgistro de Alunos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        recyclerView = findViewById(R.id.listaAluno)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.itemAnimator = DefaultItemAnimator()

        val dividerItemDecoration = DividerItemDecoration(recyclerView.context, RecyclerView.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)

        recyclerView.setHasFixedSize(true)
        students = Estudantes.getEstudantes()

        if (intent.hasExtra("aluno")) {
            val nome = intent.getStringExtra("aluno")
            val matricula = intent.getStringExtra("matricula")
            val notaFinal = intent.getDoubleExtra("notaFinal", 0.0)
            val imagem = intent.getIntExtra("imagem", 0)

            // Apenas adiciona se os dados forem válidos
            if (nome != null && matricula != null) {
                val student = Student(nome, matricula, notaFinal, imagem)
                students?.add(student)
            }
        }

        adapter = StudentAdapter(this, students, onClickOEstudante())
        recyclerView.adapter = adapter

    }

    private fun onClickOEstudante(): StudentAdapter.EstudanteOnClickListener {
        return object : StudentAdapter.EstudanteOnClickListener {
            override fun onClick(holder: EstudanteViewHolder?, index: Int) {
                val aluno = students?.get(index)
                val nome = aluno?.nome
                val matricula = aluno?.matricula
                val notaFinal = aluno?.notaFinal
                val imagem = aluno?.imagem
                val situacao = if (notaFinal!! >= 6.0) "Aprovado" else "Reprovado"

                val intent : Intent = Intent(this@ListarActivity, EstudanteInfoActivity::class.java)
                intent.putExtra("nome", nome)
                intent.putExtra("matricula", matricula)
                intent.putExtra("notaFinal", notaFinal)
                intent.putExtra("imagem", imagem)
                intent.putExtra("situacao", situacao)
                startActivity(intent)
            }
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
