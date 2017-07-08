package main;

import java.io.IOException;
import java.net.ServerSocket;

public class StopHandler{
	ServerSocket serverSocket;
	
	public StopHandler(ServerSocket serverSocket){
		this.serverSocket = serverSocket;
	}
	
	
	public void stop(){
		try{
			serverSocket.close();
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
