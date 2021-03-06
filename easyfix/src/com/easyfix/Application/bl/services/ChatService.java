package com.easyfix.Application.bl.services;
import com.easyfix.Application.models.ChatMessageModel;

import java.util.ArrayList;


public interface ChatService {
    public boolean sendMessage(int senderId,int receiverId,String senderType,String message) throws Exception;
    public ArrayList<ChatMessageModel> loadMessageHistory(int senderId, int receiverId) throws Exception;
}
