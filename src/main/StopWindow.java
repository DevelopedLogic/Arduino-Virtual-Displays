package main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class StopWindow implements ActionListener{
	StopHandler sthand;
	JFrame frame;
	
	public StopWindow(StopHandler sthand){
		this.sthand = sthand;
	}
	
	public void init(){
		JFrame frame = new JFrame("Arduino Display Server Controls");
		this.frame = frame;
		JPanel panel = new JPanel();
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		JButton stopButton = new JButton("Stop Server");
		panel.add(stopButton);
		frame.pack();
		stopButton.addActionListener(this);
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent event){
	    sthand.stop();
	}
	
	public void exit(){
		frame.dispose();
	}
}
