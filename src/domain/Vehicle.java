package domain;

import java.io.Serializable;

public class Vehicle implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private String model;
	
	
	public Vehicle() {
		
	}
	
	public Vehicle(String model) {
		this.model = model;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}
	
	@Override
	public String toString() {
		return "model: "+model+" ";
	}
	
	
}
