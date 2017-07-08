package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class CommandInterpreter{
	public static void interpret(StopHandler sthand, Display display, Socket clientSocket, BoolHolder live, PrintWriter out, BufferedReader in, String fallbackCmd){
		String command = fallbackCmd;
		try{
			if(fallbackCmd.equals("")){
				command = in.readLine();
				//System.out.println(clientScoket.getRemoteSocketAddress()+": "+command); //Debug incoming
			}
		}catch (IOException e1){
			System.err.println("Client @ "+clientSocket.getRemoteSocketAddress()+" dropped connection. Aborting this thread.");
			display.close();
			try{
				clientSocket.close();
				in.close();
				out.close();
			}catch(IOException e){
				//e.printStackTrace(); //We don't care at this point.
			}
			live.setValue(false);
		}
		
		if(command.equals("close")){
			display.close();
			try{
				clientSocket.close();
				in.close();
				out.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			live.setValue(false);
		}else if(command.equals("destroyActiveHandle")){
			//Don't need to do anything. The device is obviously not using an active negotiation handle.
		}else if(command.equals("terminate")){
			display.close();
			try{
				clientSocket.close();
				in.close();
				out.close();
			}catch(IOException e){
				e.printStackTrace();
			}
			live.setValue(false);
			sthand.stop();
		}else if(command.equals("identify")){
			try{
				display.identify(in.readLine());
			}catch(IOException e){
				e.printStackTrace();
			}
		}else if(command.equals("setOn")){
			try{
				String id = in.readLine();
				if(id.equals("V0")){
					display.enInd0();
				}else if(id.equals("V1")){
					display.enInd1();
				}else if(id.equals("V2")){
					display.enInd2();
				}else if(id.equals("V3")){
					display.enInd3();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}else if(command.equals("setOff")){
			try{
				String id = in.readLine();
				if(id.equals("V0")){
					display.disInd0();
				}else if(id.equals("V1")){
					display.disInd1();
				}else if(id.equals("V2")){
					display.disInd2();
				}else if(id.equals("V3")){
					display.disInd3();
				}
			}catch(IOException e){
				e.printStackTrace();
			}
		}else if(command.equals("allowUser")){
			display.allowUser();
		}else if(command.equals("disallowUser")){
			display.disallowUser();
		}
	}
}
