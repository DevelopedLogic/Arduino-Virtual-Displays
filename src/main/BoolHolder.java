package main;

public class BoolHolder{
	boolean bool;
	
	public BoolHolder(boolean defaultValue){
		bool = defaultValue;
	}
	
	public void setValue(boolean value){
		bool = value;
	}
	
	public boolean getValue(){
		return bool;
	}
}
