package com.junaidahmed57.tictactoe.ui

enum class Players{
    PlayerOne,
    PlayerTwo
}

data class GameUiState(
    val playerTurn: Players = Players.PlayerOne,
    val player1: Int = 0,
    val player2: Int = 0,
    val clickCount: Int = 0,
    val showDialog: Pair<Boolean, String> = Pair(first = false, second = ""),
    val playerSelections: List<Pair<String, Int>> = defaultSelections
)

val defaultSelections = listOf(
    Pair(first = "", second = 0),
    Pair(first = "", second = 1),
    Pair(first = "", second = 2),
    Pair(first = "", second = 3),
    Pair(first = "", second = 4),
    Pair(first = "", second = 5),
    Pair(first = "", second = 6),
    Pair(first = "", second = 7),
    Pair(first = "", second = 8)
)

val winningCombinations: List<List<Int>> = listOf(
    listOf(0,1,2),
    listOf(3,4,5),
    listOf(6,7,8),
    listOf(0,3,6),
    listOf(1,4,7),
    listOf(2,5,8),
    listOf(0,4,8),
    listOf(2,4,6),
)