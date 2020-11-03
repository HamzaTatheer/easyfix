package com.easyfix.Application.bl.services;

import com.easyfix.Application.bl.classes.Chat;
import com.easyfix.Application.models.ChatMessageModel;

import java.util.ArrayList;

public interface ChatService {
    //public Boolean sendMessage(int senderId,int receiverId,String message);
    public ArrayList<ChatMessageModel> loadMessageHistory(int senderId, int receiverId);
}