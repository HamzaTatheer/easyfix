package com.easyfix.Application.bl.services;

import com.easyfix.Application.models.Chat;

import java.util.ArrayList;

public interface ChatService {
    public Boolean sendMessage(int senderId,int receiverId,String message);
    public ArrayList<Chat> loadMessageHistory(int senderId, int recieverId, String message);

}
