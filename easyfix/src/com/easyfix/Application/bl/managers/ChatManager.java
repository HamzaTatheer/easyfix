package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.classes.ChatMessage;
import com.easyfix.Application.bl.services.ChatService;
import com.easyfix.Application.bl.services.UserService;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.db.services.DbService;
import com.easyfix.Application.models.ChatMessageModel;

import java.security.spec.ECField;
import java.util.ArrayList;

public class ChatManager implements ChatService {

    public DbService dbService;

    public ChatManager(){
        dbService = dbProviders.getDbService();
    }


    public boolean sendMessage(int senderId,int receiverId,String message) throws Exception {

        boolean exists = true;

        if(dbService.does_customer_exist(senderId) || dbService.does_worker_exist(senderId)){
            if(dbService.does_customer_exist(receiverId) || dbService.does_worker_exist(receiverId)){
                exists = true;
            }
        }

        if(exists = true){
            ChatMessage c = new ChatMessage(senderId,receiverId,message);
            dbService.store_chat(c.getSenderId(),c.getReceiverId(),"sender","receiver",c.getMessage());
            return true;
        }
        else{
            throw new Exception("Either the sender or reciever does not exist");
        }
    }
    public ArrayList<ChatMessageModel> loadMessageHistory(int senderId, int receiverId) throws Exception{
        boolean exists = true;

        if(dbService.does_customer_exist(senderId) || dbService.does_worker_exist(senderId)){
            if(dbService.does_customer_exist(receiverId) || dbService.does_worker_exist(receiverId)){
                exists = true;
            }
        }

        if(exists = true){
            return dbService.get_chat_history(senderId,receiverId);
        }
        else{
            throw new Exception("Either the sender or reciever does not exist");
        }
    }

}
