package com.easyfix.Application.bl.services;
import com.easyfix.Application.models.ChatMessageModel;


public interface ChatService {
    public boolean sendMessage(int senderId,int receiverId,S message);
    public ArrayList<ChatMessageModel> loadMessageHistory(int senderId, int receiverId);
}
