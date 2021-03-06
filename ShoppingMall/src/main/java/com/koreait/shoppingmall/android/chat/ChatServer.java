package com.koreait.shoppingmall.android.chat;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class ChatServer extends JFrame{
	JPanel p_north;
	JTextField t_port;
	JButton bt;
	JTextArea area;
	JScrollPane scroll;
	Thread serverThread;
	ServerSocket server;//접속자 감지 소켓
	Vector<ServerMessageThread> clientList;
	
	public ChatServer() {
		p_north = new JPanel();
		t_port = new JTextField("7777",10);
		bt= new JButton("서버 가동");
		area = new JTextArea();
		scroll = new JScrollPane(area);
		clientList = new Vector<ServerMessageThread>();
		
		p_north.add(t_port);
		p_north.add(bt);
		add(p_north,BorderLayout.NORTH);
		add(scroll);
		
		serverThread = new Thread() {
			public void run() {
				startServer();
			}
		};
		bt.addActionListener(new ActionListener() {			
			public void actionPerformed(ActionEvent e) {
				serverThread.start();
			}
		});
		
		setSize(300,400);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	public void startServer() {
		int port = Integer.parseInt(t_port.getText());
		try {
			server = new ServerSocket(port);
			area.append("서버 가동");
			Socket socket = server.accept();//접속감지 위한 대기
			ServerMessageThread smt = new ServerMessageThread(this, socket);
			smt.start();
			clientList.add(smt);
			area.append("접속자 수 : "+clientList.size()+"\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new ChatServer();
	}
}
