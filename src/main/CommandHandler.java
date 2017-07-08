package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class CommandHandler extends Thread implements ActionListener{
	Socket clientSocket;
	PrintWriter out;
	BufferedReader in;
	StopHandler sthand;
	Display display = new Display();
	BoolHolder live = new BoolHolder(true);
	
	public CommandHandler(Socket clientSocket, StopHandler sthand){
		this.clientSocket = clientSocket;
		this.sthand = sthand;
	}
	
	public Display getDisplay(){
		return display;
	}
	
	public void run(){
		try{
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			this.out = out;
			this.in = in;
		}catch(IOException e){
			e.printStackTrace();
		}
		
		display.show();
		while(live.getValue()){
			CommandInterpreter.interpret(sthand, display, clientSocket, live, out, in, "");
		}
	}

	public void actionPerformed(ActionEvent event) {
		CommandInterpreter.interpret(sthand, display, clientSocket, live, out, in, "close");
	}
}
