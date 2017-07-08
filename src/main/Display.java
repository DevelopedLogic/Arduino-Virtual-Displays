package main;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display{
	JFrame frame;
	JPanel panel;
	JButton terminate;
	JCheckBox[] indicators = {new JCheckBox(), new JCheckBox(), new JCheckBox(), new JCheckBox()};
	
	public Display(){
		JFrame frame = new JFrame("Arduino Display - Unidentified Controller");
		JPanel panel = new JPanel();
		JButton terminate = new JButton("Close this display");
		this.frame = frame;
		this.panel = panel;
		this.terminate = terminate;
		
		frame.add(panel);
		frame.setSize(400, 200);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		panel.add(indicators[0]);
		panel.add(indicators[1]);
		panel.add(indicators[2]);
		panel.add(indicators[3]);
		panel.add(terminate);
		
		indicators[0].setEnabled(false);
		indicators[1].setEnabled(false);
		indicators[2].setEnabled(false);
		indicators[3].setEnabled(false);
		
		indicators[0].setText("V0");
		indicators[1].setText("V1");
		indicators[2].setText("V2");
		indicators[3].setText("V3");
	}
	
	public JButton getTerminateButton(){
		return terminate;
	}
	
	public void allowUser(){
		indicators[0].setEnabled(true);
		indicators[1].setEnabled(true);
		indicators[2].setEnabled(true);
		indicators[3].setEnabled(true);
	}
	
	public void disallowUser(){
		indicators[0].setEnabled(false);
		indicators[1].setEnabled(false);
		indicators[2].setEnabled(false);
		indicators[3].setEnabled(false);
	}
	
	public void show(){
		frame.setVisible(true);
	}
	
	public void hide(){
		frame.setVisible(false);
	}
	
	public void close(){
		frame.dispose();
	}
	
	public void enInd0(){
		indicators[0].setSelected(true);
	}
	
	public void enInd1(){
		indicators[1].setSelected(true);
	}
	
	public void enInd2(){
		indicators[2].setSelected(true);
	}
	
	public void enInd3(){
		indicators[3].setSelected(true);
	}
	
	public void disInd0(){
		indicators[0].setSelected(false);
	}
	
	public void disInd1(){
		indicators[1].setSelected(false);
	}
	
	public void disInd2(){
		indicators[2].setSelected(false);
	}
	
	public void disInd3(){
		indicators[3].setSelected(false);
	}

	public void identify(String name) {
		frame.setTitle("Arduino Display - "+name);
	}
}
