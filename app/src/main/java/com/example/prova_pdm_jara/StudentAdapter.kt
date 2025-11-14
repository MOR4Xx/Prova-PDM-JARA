package com.example.prova_pdm_jara

import android.R.color.holo_red_dark
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(
    private val context: Context,
    private val students: List<Student>? = null,
    private val onClickListener: EstudanteOnClickListener
) : RecyclerView.Adapter<EstudanteViewHolder>() {
    interface EstudanteOnClickListener {
        fun onClick(holder: EstudanteViewHolder?, index: Int)
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): EstudanteViewHolder {
        val view = LayoutInflater.from(context).inflate(
            R.layout.adapter_estudante,
            viewGroup,
            false
        )
        return EstudanteViewHolder(view)
    }

    override fun getItemCount(): Int = students?.size ?: 0

    override fun onBindViewHolder(holder: EstudanteViewHolder, position: Int) {
        val estudante = students!![position]
        holder.tNome.text = "Nome: ${estudante.nome}"
        holder.tMatricula.text = "Matricula: ${estudante.matricula}"

        if (estudante.notaFinal <= 6.0) {
            holder.card.background = ContextCompat.getDrawable(holder.itemView.context, R.color.red)
        } else {
            holder.card.background = ContextCompat.getDrawable(holder.itemView.context, R.color.white)
        }

        holder.itemView.setOnClickListener { onClickListener.onClick(holder, position) }
    }
}

class EstudanteViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var tNome: TextView = view.findViewById(R.id.item_aluno_nome)
    var tMatricula: TextView = view.findViewById(R.id.item_aluno_matricula)

    val card: LinearLayout = view.findViewById(R.id.cardAluno)
}

