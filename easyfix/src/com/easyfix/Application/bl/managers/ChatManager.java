package com.easyfix.Application.bl.managers;

import com.easyfix.Application.bl.classes.ChatMessage;
import com.easyfix.Application.bl.services.ChatService;
import com.easyfix.Application.db.dbProviders;
import com.easyfix.Application.bl.services.DbService;
import com.easyfix.Application.models.ChatMessageModel;

import java.util.ArrayList;

public class  ChatManager implements ChatService {

    public DbService dbService;

    public ChatManager(){
        dbService = dbProviders.getDbService();
    }


    public boolean sendMessage(int senderId,int receiverId,String senderType ,String message) throws Exception {

        boolean exists = true;

        if(dbService.does_customer_exist(senderId) || dbService.does_worker_exist(senderId)){
            if(dbService.does_customer_exist(receiverId) || dbService.does_worker_exist(receiverId)){
                exists = true;
            }
        }

        if(exists = true){
            ChatMessage c = new ChatMessage(senderId,receiverId,message);
            if(senderType.equals("customer"))
                dbService.store_chat(c.getSenderId(),c.getReceiverId(),dbService.get_customer(senderId).name,dbService.get_worker(receiverId).name,c.getMessage());
            else if(senderType.equals("worker"))
                dbService.store_chat(c.getSenderId(),c.getReceiverId(),dbService.get_worker(senderId).name,dbService.get_customer(receiverId).name,c.getMessage());
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
