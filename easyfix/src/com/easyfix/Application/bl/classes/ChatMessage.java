package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.ChatMessageModel;

public class ChatMessage {
    public int senderId;
    public int receiverId;
    public String message;

    ChatMessage(int _senderId,int _receiverId,String _message){
        senderId = _senderId;
        receiverId = _receiverId;
        message = _message;
    }

    ChatMessage(ChatMessageModel model){
        senderId = model.senderId;
        receiverId = model.receiverId;
        message = model.message;
    }


    public void hideAbusiveWords(){
        String filteredMessage= message.replaceAll("pagal","HIDDEN");
        filteredMessage= message.replaceAll("stupid","HIDDEN");
        filteredMessage= message.replaceAll("chawal","HIDDEN");
        message = filteredMessage;
    }
}
