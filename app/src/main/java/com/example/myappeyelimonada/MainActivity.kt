package com.example.myappeyelimonada

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.myappeyelimonada.ui.theme.MyAppEyeLimonadaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyAppEyeLimonadaTheme {
                MyAppEyeLimonada()
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MyAppEyeLimonada() {
    var tela by remember { mutableStateOf(3) }
    var idImagem = 1
    var idTexto = 1
    var onClickImagem = {}
    var qtdClicks = 3

    when (tela) {
        1 -> {
            idImagem = R.drawable.lemon_tree
            idTexto = R.string.lemon_tree
            onClickImagem = {
                tela = 2
                qtdClicks = (2..4).random()
            }
        }

        2 -> {
            idImagem = R.drawable.lemon_squeeze
            idTexto = R.string.lemon_squeeze
            onClickImagem = {
                if (qtdClicks > 0)
                    qtdClicks--
                else
                    tela = 3
            }
        }

        3 -> {
            idImagem = R.drawable.lemon_drink
            idTexto = R.string.lemon_drink
            onClickImagem = { tela = 4 }
        }

        4 -> {
            idImagem = R.drawable.lemon_restart
            idTexto = R.string.lemon_restart
            onClickImagem = { tela = 1 }
        }

    }
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
    ) {

        Image(
            painter = painterResource(id = idImagem),
            contentDescription = null,
            modifier = Modifier
                .clickable(onClick = onClickImagem)
        )
        Text(
            text = stringResource(idTexto),
            fontSize = 25.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontFamily = FontFamily.SansSerif,
            textAlign = TextAlign.Center,
        )
    }
}
