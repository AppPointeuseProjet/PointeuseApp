package com.pointeuse.serveur;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

import com.pointeuse.jdbc.DaoH2;

public class Serveur {

	private int port;
	
	private ServerSocket sock ;
	private DaoH2 daoH2;
	public Serveur( int port ) throws IOException {
	
		 this.port = port;
		 this.sock = new ServerSocket(port) ;
		 daoH2 = new DaoH2();
		 
		 System.out.println("sockte is bound to" +sock.getInetAddress()+"");
		 
	}
	
	public void service() throws Exception {
	
		while(true) {
			
		    System.out.println("waitin connection ...");
			Socket client  = sock.accept();
			System.out.println("client accepted "+client.getInetAddress());
			OutputStream out = client.getOutputStream();
			InputStream  in  = client.getInputStream() ;
			int c = 0  ;
			StringBuffer sb = new StringBuffer();
			while (  (char)c != '\n'  ) {
				  c = in.read();
				  if ((char)c != '\n')
				  sb.append((char)c);
			}
			
			String message = sb.toString();
			String [] msg = message.split("#");
			boolean ok = false ;
			if (msg[0].equals("VFN")){
				 ok = daoH2.verifyExistEmployerName(msg[1]);
					
			}else if(msg[0].equals("VFS")){
				ok = daoH2.verifyExistEmployerSurName(msg[1]);		
			} 
			if (ok){
				out.write("granted\n".getBytes());
			}else {
				out.write("denied\n".getBytes());
			}
			
			out.close();
			in.close();
			
		}
	}
	
    public static void main (String arg0 [] ) throws Exception{
    	Serveur serveur = new Serveur(8000 );
        serveur.service();
    }    
}
