package com.easyfix.Application.bl.classes;

import com.easyfix.Application.models.ChatMessageModel;

public class ChatMessage {
    private int senderId;
    private int receiverId;

    private String message;


    public ChatMessage(int _senderId, int _recieverId, String _message){
        senderId = _senderId;
        receiverId = _recieverId;
        message= _message;
        hideAbusiveWords();
    }

    //Constructors
    ChatMessage(ChatMessageModel model){
        senderId = model.senderId;
        receiverId = model.receiverId;
        message = model.message;
    }
    //member functions
    public ChatMessageModel getChatMessageModel(){
        ChatMessageModel temp=new ChatMessageModel();
        temp.senderId=senderId;
        temp.receiverId=receiverId;
        //temp.senderName=senderName;
        //temp.receiverName=receiverName;
        temp.message=message;
        return temp;
    }
    private void hideAbusiveWords(){
        String filteredMessage= message.replaceAll("pagal","HIDDEN");
        filteredMessage= message.replaceAll("stupid","HIDDEN");
        filteredMessage= message.replaceAll("chawal","HIDDEN");
        message = filteredMessage;
    }
    //getters
    public int getSenderId() {
        return senderId;
    }

    public int getReceiverId() {
        return receiverId;
    }


    public String getMessage() {
        return message;
    }

    //setters
    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }


    public void setMessage(String message) {
        this.message = message;
    }
}
