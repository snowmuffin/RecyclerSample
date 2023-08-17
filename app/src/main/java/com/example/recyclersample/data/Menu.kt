package com.example.recyclersample.data

data class MenuOrder (
    val id: Long,
    val name: String,
    val antipasto: List<String>,
    val insalata: List<String>,
    val pizza: List<String>,
    val pasta: List<String>,
    val risotto: List<String>,
    val steak: List<String>,
    val coffe: List<String>,
    val ade: List<String>,
    val beer: List<String>,
    val tea: List<String>,
    val traditional: List<String>,
    val smoothjuice: List<String>,
    val wine: List<String>,
)