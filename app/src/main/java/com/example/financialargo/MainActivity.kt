package com.example.financialargo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.financialargo.ui.theme.FinancialArGoTheme
import com.example.financialargo.ui.theme.HeaderBackground
import com.example.financialargo.ui.theme.MainBackground

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            mainView()
        }
    }

    @Preview
    @Composable
    fun mainView(){
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MainBackground)
        ) {

            Column(

                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.15f)
                    .background(
                        HeaderBackground,
                        shape = RoundedCornerShape(
                            bottomEnd = 25.dp,
                            bottomStart = 25.dp
                        )),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally


            ){
                Text(
                    text = stringResource(R.string.counterMain),
                    fontSize = 20.sp,
                )
                Row(
                    Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(
                        onClick = {},
                        Modifier.height(35.dp).width(160.dp)


                    ) {
                       Text(text = stringResource(R.string.cost))
                    }
                    Button(
                        onClick = {},
                        Modifier.height(35.dp).width(160.dp)

                    ) {
                        Text(text = stringResource(R.string.gain))

                    }
                }

            }

        }
    }
}

