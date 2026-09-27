package ca.gbc.comp3074.tai_maria.lab2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.LineHeightStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ca.gbc.comp3074.tai_maria.lab2.ui.theme.Lab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab2Theme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = MaterialTheme.colorScheme.tertiary
                ) { innerPadding ->
                    StepElements(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun StepElements(modifier: Modifier = Modifier) {
    var count by remember { mutableStateOf(0)}
    var step by remember { mutableStateOf(1)}
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp, 100.dp),
        verticalArrangement = Arrangement.Center
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Image(
                painter = painterResource(R.drawable.logo),
                contentDescription = "Steps Simple Application Logo",
                modifier = Modifier.width(100.dp).height(100.dp)
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ){
            Text(
                text = count.toString(),
                fontSize = 30.sp
            )
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(35.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(50.dp)
        ){
            Button(
                modifier = Modifier.weight(0.2f),
                colors = ButtonDefaults.buttonColors(Color.Red),
                onClick = {
                    if (count > 0){
                        count = count - step
                    }
                }
            ){
                Text(text = "-",
                    fontSize = 23.sp
                )
            }
            Button(
                modifier = Modifier.weight(0.2f),
                colors = ButtonDefaults.buttonColors(Color.Blue),
                onClick = {count = count + step}
            ){
                Text(text = "+",
                    fontSize = 23.sp
                )
            }
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(50.dp)
        ){
            Button(
                modifier = Modifier.weight(0.2f),
                colors = ButtonDefaults.buttonColors(Color.Magenta),
                onClick = {
                    count = 0
                }
            ){
                Text(
                    text = "Reset",
                    fontSize = 17.sp
                )
            }
            Button(
                modifier = Modifier.weight(0.2f),
                onClick = { step++ }
            ){
                Text(
                    text = "Step",
                    fontSize = 17.sp
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab2Theme {
        StepElements(modifier = Modifier.fillMaxWidth())
    }
}