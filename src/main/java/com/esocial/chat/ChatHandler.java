package com.esocial.chat;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class ChatHandler extends TextWebSocketHandler {
	
	static Set<WebSocketSession> chatroomUsers = Collections.synchronizedSet(new HashSet<WebSocketSession>());
	
    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
    	System.out.println("server rcvd message : " + message);
    	
    
        session.sendMessage(new TextMessage("Server echo: "+ message));  
        
    }
    
    @Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus closeStatus)
    {
    	System.out.println(session.getRemoteAddress());
    	//chatroomUsers.remove(session);
    	System.out.println("Connection has closed");
    }
    
    @Override
	public void afterConnectionEstablished(WebSocketSession session)
    {
    	System.out.println(session.getRemoteAddress());
    	System.out.println("Connection established");
    }
    

}