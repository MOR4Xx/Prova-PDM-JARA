package com.example.prova_pdm_jara

data class Student(val nome: String,
                   val matricula: String,
                   val notaFinal: Double,
                   val imagem: Int)

object Estudantes{
    fun getEstudantes(): MutableList<Student>{
        return mutableListOf(

            Student("Aluno 1", "111111111", 10.0, R.drawable.aluno1),
            Student("Aluno 2", "222222222", 9.0, R.drawable.aluno2),
            Student("Aluno 3", "333333333", 5.0, R.drawable.aluno3),
            Student("Aluno 4", "444444444", 7.0, R.drawable.aluno4),
            Student("Aluno 5", "555555555", 5.0, R.drawable.aluno5)
        )
    }
}
