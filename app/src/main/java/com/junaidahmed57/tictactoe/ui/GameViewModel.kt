package com.junaidahmed57.tictactoe.ui

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class GameViewModel: ViewModel() {

    private val _uiState = MutableStateFlow(GameUiState())
    val uiState = _uiState.asStateFlow()

    fun boxClicked(boxId: Int){
        if (uiState.value.playerTurn.name == Players.PlayerOne.name){
            val playerSelections = uiState.value.playerSelections.toMutableStateList()
            playerSelections[boxId] = (Pair(first = "X", second = boxId))
            _uiState.update {gameUiState ->
                gameUiState.copy(
                    playerTurn = Players.PlayerTwo,
                    playerSelections = playerSelections,
                    clickCount = gameUiState.clickCount+1
                )
            }
        }
        else{
            val playerSelections = uiState.value.playerSelections.toMutableStateList()
            playerSelections[boxId] = Pair(first = "O", second = boxId)
            _uiState.update {gameUiState ->
                gameUiState.copy(
                    playerTurn = Players.PlayerOne,
                    playerSelections = playerSelections,
                    clickCount = gameUiState.clickCount+1
                )
            }
        }
        checkPlayersStatus()
    }

    private fun checkPlayersStatus(){

        if (uiState.value.clickCount>4){
            val playerOneSelections = uiState.value.playerSelections.filter { it.first == "X" }.map { it.second }.sorted()
            val playerTwoSelections = uiState.value.playerSelections.filter { it.first == "O" }.map { it.second }.sorted()
            var playerWon =  false
            for (combination in winningCombinations){
                if (playerOneSelections.containsAll(combination)){
                    _uiState.update { uiState ->
                        uiState.copy(
                            player1 = uiState.player1+1,
                            showDialog = Pair(first = true, second = "Congratulations! \n Player One Won.")
                        )
                    }
                    playerWon = true
                    break
                }
                if (playerTwoSelections.containsAll(combination)){
                    _uiState.update { uiState ->
                        uiState.copy(
                            player2 = uiState.player2+1,
                            showDialog = Pair(first = true, second = "Congratulations! \n Player Two Won.")
                        )
                    }
                    playerWon = true
                    break
                }
            }

            if (!playerWon && uiState.value.clickCount == 9){
                _uiState.update {gameUiState ->
                    gameUiState.copy(
                        showDialog = Pair(first = true, second = "Game Draw.")
                    )
                }
            }
        }
    }

    private fun restartGame(){
        _uiState.update {gameUiState ->
            gameUiState.copy(
                playerTurn = Players.PlayerOne,
                playerSelections = defaultSelections,
                clickCount = 0
            )
        }
    }

    fun resetGame(){
        _uiState.update {gameUiState ->
            gameUiState.copy(
                playerTurn = Players.PlayerOne,
                player1 = 0,
                player2 = 0,
                playerSelections = defaultSelections,
                clickCount = 0
            )
        }
    }

    fun dialogDismissed(){
        _uiState.update {gameUiState ->
            gameUiState.copy(
                showDialog = Pair(first = false, second = "")
            )
        }
        restartGame()
    }

}