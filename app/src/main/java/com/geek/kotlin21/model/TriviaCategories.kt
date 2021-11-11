package com.geek.kotlin21.model


data class Categories(
    val id: Int?,
    val name: String?
)

data class TriviaCategories(
    val trivia_categories: List<Categories>
)