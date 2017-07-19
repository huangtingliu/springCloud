package com.huangtl.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.*;
import org.springframework.web.socket.handler.AbstractWebSocketHandler;

import java.io.IOException;
import java.util.Vector;

/**
 * created by htl on 2017/7/17.
 */
@Component
public class WsHandler extends AbstractWebSocketHandler {

    WebSocketSession session;
    String nickName;
    private static Vector<WsHandler> clients= new Vector<WsHandler>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        super.afterConnectionEstablished(session);
        this.session = session;
        clients.add(this);
        System.out.println("websocket is connection");
    }

    @Override
    public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
        super.handleMessage(session, message);
//        System.out.println("websocket handleMessage run :"+message.getPayload());
//        sendMsg(message);
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        super.handleTextMessage(session, message);

        String payload = message.getPayload();
        System.out.println("websocket message is :"+ payload);

        //登录
        if(payload.split("##").length==2){
            nickName = payload.split("##")[0];
            sendMsg(nickName+":我上线了");
            return;
        }
        sendMsg(nickName+":"+payload);
    }

    @Override
    protected void handlePongMessage(WebSocketSession session, PongMessage message) throws Exception {
        super.handlePongMessage(session, message);
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        super.afterConnectionClosed(session, status);
        System.out.println("connection is closed ");
        clients.remove(this);
    }


    public void sendMsg(String msg) throws IOException {
        WebSocketMessage<?> websocketMessage = new TextMessage(msg);
//        this.session.sendMessage(websocketMessage);
        for(WsHandler client : clients){
            try {
                client.session.sendMessage(websocketMessage);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void sendMsg(WebSocketMessage<?> msg){

        for(WsHandler client : clients){
            try {
                client.session.sendMessage(msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
