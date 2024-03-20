package com.junaidahmed57.tictactoe.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GameRow(row: Int, selections: List<Pair<String, Int>>, onClicked: (Int) -> Unit){
    var boxValue: List<Int> = emptyList()
    when(row){
        1 -> boxValue = listOf(0,1,2)
        2 -> boxValue = listOf(3,4,5)
        3 -> boxValue = listOf(6,7,8)
    }
    Row{
        DrawXOrY(id = boxValue[0], draw = selections[boxValue[0]].first, onClicked = onClicked)
        Spacer(modifier = Modifier
            .height(108.dp)
            .width(8.dp)
            .background(Color.White))
        DrawXOrY(id = boxValue[1], draw = selections[boxValue[1]].first, onClicked = onClicked)
        Spacer(modifier = Modifier
            .height(108.dp)
            .width(8.dp)
            .background(Color.White))
        DrawXOrY(id = boxValue[2], draw = selections[boxValue[2]].first, onClicked = onClicked)
    }
}

@Composable
fun DrawXOrY(modifier: Modifier = Modifier, id: Int, draw: String = "", onClicked: (Int) -> Unit = {}){
    Text(
        text = draw,
        fontSize = 80.sp,
        textAlign = TextAlign.Center,
        color = Color.White,
        style = MaterialTheme.typography.titleMedium,
        modifier = modifier
            .width(96.dp)
            .height(96.dp)
            .clickable { if (draw.isEmpty()) onClicked(id) }
    )
}