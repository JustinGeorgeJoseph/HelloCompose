package com.justin.hellocompose

import android.os.Bundle
import android.os.Message
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.justin.hellocompose.ui.theme.HelloComposeTheme

data class Book(val author:String, val name: String)
data class Messages(val author:String, val name: String)

class MainActivity : ComponentActivity() {
    val messageList = arrayListOf(
        Messages("Justin","HI"),
        Messages("Adam","Hi"),
        Messages("Justin","Nice to meet you!"),
        Messages("Adam","Same Here"),
        Messages("Justin","Ente daivame ne evidanu!"),
        Messages("Adam","Onnum ponam mister, njan evide indu, ne evide anu"),
        Messages("Justin","Ah Angane anengil okay....."),
        Messages("Justin","Ente daivame ne evidanu!"),
        Messages("Adam","Onnum ponam mister, njan evide indu, ne evide anu"),
        Messages("Justin","Ah Angane anengil okay....."),
        Messages("Adam","Appo sry bye bye"),
        Messages("Justin","Bye"),
        Messages("Justin","Take care")
    )
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            HelloComposeTheme {
                showConversationList(messages = messageList)
            }
        }
    }
}

@Composable
fun showConversationList(messages: List<Messages>) {
    LazyColumn{
        items(messages){ item ->
            showMessageCard(item)
        }
    }
}

@Composable
fun showMessageCard(message:Messages){
    Row (modifier = Modifier.padding(all = 8.dp),){
        Image(painter = painterResource(id = R.drawable.justin),
            contentDescription = "Test image",
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
                .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(
                text = message.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(text = message.name,modifier = Modifier.padding(all = 8.dp))
            }
        }
    }

}

@Composable
fun showMessageCard(message:Book){
    Row (modifier = Modifier.padding(all = 8.dp),){
        Image(painter = painterResource(id = R.drawable.justin),
            contentDescription = "Test image",
        modifier = Modifier
            .size(40.dp)
            .clip(CircleShape)
            .border(1.5.dp, MaterialTheme.colors.secondary, CircleShape)
        )
        Column(modifier = Modifier.padding(start = 8.dp)) {
            Text(
                text = message.author,
                color = MaterialTheme.colors.secondaryVariant,
                style = MaterialTheme.typography.subtitle2
            )
            Surface(shape = MaterialTheme.shapes.medium, elevation = 1.dp) {
                Text(text = message.name,modifier = Modifier.padding(all = 8.dp))
            }
        }
    }

}

@Composable
fun MessageCard(){
    showMessageCard(message = Book("Justin","Audacity of hope"))
}

@Preview
@Composable
fun previewConversionList(){
    val messageList = arrayListOf(
        Messages("Justin","HI"),
        Messages("Adam","Hi"),
        Messages("Justin","Nice to meet you!"),
        Messages("Adam","Same Here"),
        Messages("Justin","Ente daivame ne evidanu!"),
        Messages("Adam","Onnum ponam mister, njan evide indu, ne evide anu"),
        Messages("Justin","Ah Angane anengil okay....."),
        Messages("Adam","Appo sry bye bye"),
        Messages("Justin","Bye"),
        Messages("Justin","Take care")
    )
    showConversationList(messages = messageList)
}
