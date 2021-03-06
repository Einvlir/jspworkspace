package com.koreait.shoppingmall.android.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class ServerMessageThread extends Thread{
	ChatServer chatServer;
	Socket socket;
	BufferedReader buffr;
	BufferedWriter buffw;
	public ServerMessageThread(ChatServer chatServer, Socket socket) {
		this.chatServer = chatServer;
		this.socket=socket;
		try {
			buffr=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			buffw= new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void listen() {
		String msg = null;
		try {
			msg = buffr.readLine();
			send(msg);
			chatServer.area.append(msg+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void send(String msg) {
		try {
			for(int i = 0 ; i < chatServer.clientList.size(); i ++) {
				buffw.write(msg+"\n");
				buffw.flush();				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		while(true) {
			listen();
		}
	}
}
