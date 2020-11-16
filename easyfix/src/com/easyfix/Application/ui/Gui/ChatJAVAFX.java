package com.easyfix.Application.ui.Gui;

public class ChatJAVAFX {

    private String mess;
    private String mess2;
    public ChatJAVAFX(String _mess,String _mess2){
        this.mess=_mess;
        this.mess2=_mess2;
    }

    public String getMess2() {
        return mess2;
    }

    public void setMess2(String mess2) {
        this.mess2 = mess2;
    }

    public String getMess() {
        return mess;
    }

    public void setMess(String mess) {
        this.mess = mess;
    }
}
