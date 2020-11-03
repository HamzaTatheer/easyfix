package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.services.ChatService;
import com.easyfix.Application.bl.classes.Chat;

import java.util.ArrayList;

public class ChatManager implements ChatService {
    public Boolean sendMessage(int senderId,int receiverId,String message){
        //call db Service to store message in db
        //Return true when there is a message in db for sure
        //Hence User can do loadmessagehistory as soon as message is stored in db to get new messages
        return true;
    }
    public ArrayList<Chat> loadMessageHistory(int senderId, int recieverId, String message){
        //get chats from db and store in array list
        ArrayList<Chat> c = new ArrayList<Chat>();
        return c;
    }

}
