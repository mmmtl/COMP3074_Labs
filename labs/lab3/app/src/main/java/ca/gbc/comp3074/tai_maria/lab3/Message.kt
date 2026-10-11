package ca.gbc.comp3074.tai_maria.lab3

import android.content.Context

// Message class, contains a username and a text message
data class Message (
    val user: String,
    val text: String
)

// Function to get array elements from messages.xml and return them as a Message object
fun loadMessage(context: Context): List<Message>{ //receives a context and returns a list

    val users = context.resources.getStringArray(R.array.users)
    val messages = context.resources.getStringArray(R.array.messages)

    return users.zip(messages){
        user, text ->
            Message(user = user, text = text) // class_property = parameter
    }
}

