package com.easyfix.Application.models;

public class ChatMessageModel {
    public int senderId;
    public int receiverId;
    public String senderName;
    public String receiverName;
    public String message;

    //getters
    public ChatMessageModel getChatMessageModel(){
        ChatMessageModel temp=new ChatMessageModel();
        temp.senderId=senderId;
        temp.receiverId=receiverId;
        temp.senderName=senderName;
        temp.receiverName=receiverName;
        temp.message=message;
        return temp;
    }
}
