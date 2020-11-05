package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.ChatMessageModel;

public class ChatMessage {
    public int senderId;
    public int receiverId;
    public String senderName;
    public String receiverName;
    public String message;

    //Constructors
    ChatMessage(){

    }
    ChatMessage(int _senderId,int _receiverId,String _senderName,String _receiverName,String _message){
        senderId = _senderId;
        receiverId = _receiverId;
        senderName=_senderName;
        receiverName=_receiverName;
        message = _message;
    }
    ChatMessage(ChatMessageModel model){
        senderId = model.senderId;
        receiverId = model.receiverId;
        senderName=model.senderName;
        receiverName=model.receiverName;
        message = model.message;
    }

    //setters
    public void hideAbusiveWords(){
        String filteredMessage= message.replaceAll("pagal","HIDDEN");
        filteredMessage= message.replaceAll("stupid","HIDDEN");
        filteredMessage= message.replaceAll("chawal","HIDDEN");
        message = filteredMessage;
    }

    //getters
    public ChatMessage getChatMessage(ChatMessageModel obj){ //convert model to class
        ChatMessage temp=new ChatMessage();
        temp.senderId=obj.senderId;
        temp.receiverId=obj.receiverId;
        temp.senderName=obj.senderName;
        temp.receiverName=obj.receiverName;
        temp.message=obj.message;
        return temp;
    }
    public ChatMessageModel getChatMessageModel(ChatMessage obj){ //convert class to model
        ChatMessageModel temp=new ChatMessageModel();
        temp.senderId=obj.senderId;
        temp.receiverId=obj.receiverId;
        temp.senderName=obj.senderName;
        temp.receiverName=obj.receiverName;
        temp.message=obj.message;
        return temp;
    }

}
