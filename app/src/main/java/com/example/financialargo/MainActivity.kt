package com.example.financialargo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
        //This is a main Column, he contain the all information of screen
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MainBackground)
        ) {

            // This is a first column contain counter of money and two buttons: expenses, gain
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.15f)
                    .background(
                        HeaderBackground,
                        shape = RoundedCornerShape(
                            bottomEnd = 25.dp,
                            bottomStart = 25.dp
                        )
                    ),
                verticalArrangement = Arrangement.SpaceAround,
                horizontalAlignment = Alignment.CenterHorizontally


            ){

                //The simple text, who contain the counter money
                Text(
                    text = stringResource(R.string.counterMain),
                    fontSize = 20.sp,
                )
                // Contain buttons expenses and gain
                Row(
                    Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceAround
                ) {
                    Button(
                        onClick = {},
                        Modifier
                            .height(35.dp)
                            .width(160.dp)


                    ) {
                       Text(text = stringResource(R.string.expenses))
                    }
                    Button(
                        onClick = {},
                        Modifier
                            .height(35.dp)
                            .width(160.dp)

                    ) {
                        Text(text = stringResource(R.string.gain))

                    }
                }

            }

            // second column, contain periods, pie chart, list
            Column(
                Modifier
                    .background(
                        Color.Gray,
                        shape = RoundedCornerShape(20.dp)
                    )
                    .fillMaxWidth()
                    .fillMaxHeight(0.5f)
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally

            ) {
                // Set period
                Row (
                    horizontalArrangement = Arrangement.SpaceBetween
                ){
                    Button(
                        onClick = {}
                    ){
                        Text(text = stringResource(R.string.Day))

                    }
                    Button(
                        onClick = {}
                    ) {
                        Text(text = stringResource(R.string.Week))

                    }
                    Button(
                        onClick = {}
                    ) {
                        Text(text = stringResource(R.string.Month))

                    }
                    Button(
                        onClick = {}
                    ) {
                        Text(text = stringResource(R.string.Year))

                    }
                }
                //pie chart
                PieChart()
                //Here be show list of expenses
                ListOfExpenses()

            }

        }
    }
    @Composable
    fun PieChart(
        // This is range of pie chart
        values: List<Float> = listOf(70f, 10f, 20f),
        //Color of parts pie chart
        colors: List<Color> =
            listOf(
                Color(0xFF58BDFF),
                Color(0xFF125B7F),
                Color(0xFF092D40)
            ),
        //Item who contains pie
        legend: List<String> =
            listOf(
                stringResource(R.string.Product),
                stringResource(R.string.Transport),
                stringResource(R.string.Cloth)
            ),
        //This is size of pie
        size: Dp = 200.dp
    ) {
        // Sum of all the values
        val sumOfValues = values.sum()

        // Calculate each proportion value
        val proportions = values.map {
            it * 100 / sumOfValues
        }

        // Convert each proportions to angle
        val sweepAngles = proportions.map {
            it * 360 / 100
        }


        //Canvas allows draw the arcs, he build the circle
        Canvas(
            modifier = Modifier
                //Here we connect modifier size with size our pie
                .size(size = size)
                .padding(top = 10.dp)
        ) {
            var startAngle = -90f

            for (i in sweepAngles.indices) {
                drawArc(
                    color = colors[i],
                    startAngle = startAngle,
                    sweepAngle = sweepAngles[i],
                    useCenter = true
                )
                startAngle += sweepAngles[i]
            }
        }

        Spacer(modifier = Modifier.height(32.dp))
        // Row needs to present items under pie chart
        Row {
            for (i in values.indices) {
                DisplayLegend(color = colors[i], legend = legend[i])
            }
        }
    }

    //This fun allows show items, which make up the pie chart
    @Composable
    fun DisplayLegend(color: Color, legend: String) {
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ) {
            // Divider needs to show line
            Divider(
                modifier = Modifier.width(16.dp),
                thickness = 4.dp,
                color = color
            )

            Spacer(modifier = Modifier.width(4.dp))
            // Text needs to show name of items
            Text(
                text = legend,
                color = Color.Black
            )
        }
    }
    fun ListOfExpenses(){

    }
}

