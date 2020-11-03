package com.easyfix.Application.bl.services;
<<<<<<< HEAD
=======

import com.easyfix.Application.bl.classes.Chat;
>>>>>>> parent of ecf40ed... Completed Classes Properly along with model conversion - Chat,Worker,Customer. Added absuive filter in chat
//import com.easyfix.Application.models.ChatMessageModel;


public interface ChatService {
<<<<<<< HEAD
    public boolean sendMessage(int senderId,int receiverId,S message);
=======
    //public Boolean sendMessage(int senderId,int receiverId,String message);
>>>>>>> parent of ecf40ed... Completed Classes Properly along with model conversion - Chat,Worker,Customer. Added absuive filter in chat
    public ArrayList<ChatMessageModel> loadMessageHistory(int senderId, int receiverId);
}
