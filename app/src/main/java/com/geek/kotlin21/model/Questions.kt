package com.geek.kotlin21.model

data class Questions(
    val results: List<Results>?
)

data class Results(
    val category: String?,
    val type: String?,
    val difficulty: String?,
    val question: String?,
    val correct_answer: String?,
    val incorrect_answers: List<String>?
)