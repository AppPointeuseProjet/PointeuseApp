package com.pointeuse.client;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
 
	private int port;
	private Socket sock;
	
	public Client(String serveurIp,int port) throws UnknownHostException, IOException{
		this.port = port;
		this.sock = new Socket(serveurIp, port);
	}
	
	public void requete(String message) throws Exception {   
		    int c = 0  ;
		    StringBuffer sb = new StringBuffer();		
			System.out.println("client connect "+sock.getInetAddress());
			InputStream  in  = sock.getInputStream() ;
	        OutputStream out = sock.getOutputStream();  
	        out.write(message.getBytes());
	  
	        while ((char)c != '\n'){
	         c = in.read();
		     sb.append((char)c);
	        }
		
	      System.out.println(sb);
		  in.close();
		  out.close();
	     }
	}
