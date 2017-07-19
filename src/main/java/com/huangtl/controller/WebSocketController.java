package com.huangtl.controller;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.Vector;

/**
 * created by htl on 2017/7/17.
 */
@ServerEndpoint(value = "/ww")
public class WebSocketController {

    private Session session;
    private String nickName;
    private static Vector<WebSocketController> users = new Vector<WebSocketController>();

    @OnOpen
    public void onOpen(Session session){
        this.session = session;
        users.add(this);
        System.out.println("websocker is on open");
        System.out.println(session.getId());
    }

    @OnClose
    public void onClose(){
        users.remove(this);
    }

    @OnMessage
    public void onMessage(String msg){
        sendMsg(nickName+":"+msg);
    }

    @OnError
    public void onError(Throwable t){

    }

    public static void sendMsg(String msg){
        for (WebSocketController user : users) {
            try {
                user.session.getBasicRemote().sendText(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
