package com.junaidahmed57.tictactoe.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.junaidahmed57.tictactoe.R

@Composable
fun PlayerInfo(player: Int = 0, score: Int = 0){
    Row(
        Modifier
            .fillMaxWidth()
            .padding(16.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(text = "Player $player: ", fontSize = 20.sp)
        Text(text = "$score", fontSize = 20.sp)
    }
}

@Composable
fun GameStatus(status: String){
    Text(
        text = status,
        fontSize = 20.sp,
        color = colorResource(id = R.color.teal_700),
        textAlign = TextAlign.Center,
        fontWeight = FontWeight.Bold,
        modifier = Modifier.fillMaxWidth())
}