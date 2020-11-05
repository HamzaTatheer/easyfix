package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.services.ChatService;
import com.easyfix.Application.bl.services.UserService;
import com.easyfix.Application.models.ChatMessageModel;

import java.security.spec.ECField;
import java.util.ArrayList;

public class ChatManager implements ChatService {
    public boolean sendMessage(int senderId,int receiverId,String message){
        //call db Service to store message in db
        //Return true when there is a message in db for sure
        //Hence User can do loadmessagehistory as soon as message is stored in db to get new messages
        return true;
    }
    public ArrayList<ChatMessageModel> loadMessageHistory(int senderId, int receiverId){

        UserManager userManage = new UserManager();

        //get chats from db and store in array list
        ArrayList<ChatMessageModel> chat = new ArrayList<ChatMessageModel>();
        ChatMessageModel reply1 = new ChatMessageModel();
        reply1.senderId = 1;
        reply1.receiverId = 2;


        reply1.message = "Hi i called you 6 months ago.you did not come you stupid man";
        chat.add(reply1);

        ChatMessageModel reply2 = new ChatMessageModel();
        reply2.senderId = 2;
        reply2.receiverId = 1;




        reply2.message = "Sorry sir, this wont happen again. i promise";
        chat.add(reply2);
        return chat;
    }

}
