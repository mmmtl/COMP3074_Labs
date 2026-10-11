package ca.gbc.comp3074.tai_maria.lab3

import android.R
import android.R.id
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Android
import androidx.compose.material.icons.outlined.Android
import androidx.compose.material.icons.twotone.Android
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun MessageScreen(){
    val context = LocalContext.current

    val courses = loadMessage(context)

    Column(modifier = Modifier.fillMaxSize().padding(10.dp, 50.dp)){
        LazyMessageList(courses)
    }
}


@Composable
fun MessageItem(message: Message){
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp)){
        Icon(
            imageVector = Icons.TwoTone.Android,
            contentDescription = "Android icon",
            modifier = Modifier
                .size(50.dp)
                .border(2.dp, Color.Red, CircleShape)
        )
        Column(modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)){
            Text(
                text = message.user,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                text = message.text,
                fontSize = 18.sp,
                style = TextStyle(
                    color = Color.DarkGray
                )
            )
        }
    }
}

@Composable
fun LazyMessageList(messages: List<Message>){
    LazyColumn(
        modifier = Modifier.fillMaxWidth()
            .padding(16.dp)
    ) {
        items(messages){
            message ->
            MessageItem(message)
        }
    }
}