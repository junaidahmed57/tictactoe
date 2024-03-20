package com.junaidahmed57.tictactoe.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.junaidahmed57.tictactoe.R

@Composable
fun TicTacToeApp(viewModel: GameViewModel = androidx.lifecycle.viewmodel.compose.viewModel()){

    val gameUiState = viewModel.uiState.collectAsState().value

    Column(
        Modifier
            .padding(bottom = 16.dp)
            .fillMaxHeight()
            .fillMaxWidth(),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Column(
            Modifier
                .height(400.dp)
                .background(colorResource(id = R.color.teal_200))
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            GameRow(1, gameUiState.playerSelections, onClicked = {viewModel.boxClicked(it)})
            Spacer(
                modifier = Modifier
                    .height(8.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            )
            GameRow(2, gameUiState.playerSelections){viewModel.boxClicked(it)}
            Spacer(
                modifier = Modifier
                    .height(8.dp)
                    .fillMaxWidth()
                    .background(Color.White)
            )
            GameRow(3, gameUiState.playerSelections){viewModel.boxClicked(it)}
        }

        GameStatus(status = "${gameUiState.playerTurn.name} Turn")

        Column {
            Text(
                text = "Score",
                fontWeight = FontWeight.Bold,
                fontSize = 24.sp,
                modifier = Modifier.padding(16.dp)
            )
            PlayerInfo(player = 1, score = gameUiState.player1)
            PlayerInfo(player = 2, score = gameUiState.player2)
        }
        Button(onClick = { viewModel.resetGame() }) {
            Text(text = "Reset Game")
        }
    }

    if (gameUiState.showDialog.first){
        MinimalDialog(text = gameUiState.showDialog.second) {
            viewModel.dialogDismissed()
        }
    }

}



