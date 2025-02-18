package br.com.fiap.minhaidade

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.minhaidade.ui.theme.MinhaIdadeTheme
import kotlin.math.log

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MinhaIdadeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ){
                    MeuComponente()
                }

            }
        }
    }
}

@Composable
fun MeuComponente() {

    var idade = remember {
        mutableStateOf(0)
    }



    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ){
        Text(
            text = "Qual a sua idade?",
            color = Color.Magenta,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Pressione os botoes para informar a sua idade!",
            fontSize = 18.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(30.dp))
        Text(
            text = "${idade.value}",
            fontSize = 48.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(30.dp))
        Row (
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.fillMaxWidth()
        ) {
            Button(
                onClick = {
                    if (idade.value == 0){
                        Log.i("Idade", "Idade minima de 0 anos atingida")
                    }else{
                        idade.value --
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
                modifier = Modifier.size(70.dp),
                shape = RoundedCornerShape(24.dp),
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Text(
                    text = "-",
                    fontSize = 28.sp,
                )
            }
            Spacer(modifier = Modifier.width(40.dp))
            Button(
                onClick = {
                    if (idade.value >= 130){
                        Log.i("Idade", "Idade maxima de 130 anos atingida")
                    }else{
                    idade.value ++
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Magenta),
                modifier = Modifier.size(70.dp),
                shape = RoundedCornerShape(24.dp),
                border = BorderStroke(1.dp, Color.Black)
            ) {
                Text(
                    text = "+",
                    fontSize = 28.sp)
            }

        }

        if (idade.value >= 18){
            Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Voce e MAIOR de idade",
            fontSize = 24.sp,
            color = Color.Magenta,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth() )
        }else{
            Spacer(modifier = Modifier.height(40.dp))
        Text(text = "Voce e MENOR de idade",
            fontSize = 24.sp,
            color = Color.Magenta,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth() )
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun MeuComponentePreview() {
    MeuComponente()
}