package domain;

import java.io.Serializable;

public class Invoice implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Double basicPayment;
	private Double tax;
	
	
	public Double getTotalPayment() {
		return this.basicPayment + this.tax;
	}
	
	public Invoice() {
		
	}
	
	public Invoice(Double basicPayment, Double tax) {
		this.basicPayment = basicPayment;
		this.tax = tax;
	}
	
	public Double getBasicPayment() {
		return basicPayment;
	}
	
	public void setBasicPayment(Double basicPayment) {
		this.basicPayment = basicPayment;
	}
	
	public Double getTax() {
		return tax;
	}
	
	public void setTax(Double tax) {
		this.tax = tax;
	}
	
	@Override
	public String toString() {
		return "tax: "+tax+", Basic Payment: " +basicPayment+", Total Payment: " +getTotalPayment()+"";
	}
	
	
	
	

}
