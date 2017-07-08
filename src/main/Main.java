package main;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;

public class Main{
	static int portNumber = 23;
	
	public static void main(String[] args) throws IOException{
		Socket clientSocket = null;
		System.out.println("Began execution on port "+portNumber);
		InetAddress addr = InetAddress.getByName("192.168.42.1");
		ServerSocket serverSocket = new ServerSocket(portNumber, 0, addr);
		StopHandler sthand = new StopHandler(serverSocket);
		StopWindow stpwin = new StopWindow(sthand);
		stpwin.init();
		while(!(serverSocket.isClosed())){
			try{
				clientSocket = serverSocket.accept();
			}catch(SocketException e){
				//null
			}
			if(serverSocket.isClosed()){
				break;
			}
			System.out.println("New client @ "+clientSocket.getRemoteSocketAddress());
			CommandHandler CHandler = new CommandHandler(clientSocket, sthand);
			CHandler.getDisplay().getTerminateButton().addActionListener(CHandler);
			CHandler.start();
		}
		System.out.println("Finished execution");
		stpwin.exit();
	}
}
