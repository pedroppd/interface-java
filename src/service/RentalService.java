package service;

import domain.CarRental;
import domain.Invoice;

public class RentalService {

	private Double pricePerHour;

	private Double pricePerDay;

	private TaxService TaxService;

	public void processInvoice(CarRental carRental) {
		Long t1 = carRental.getStart().getTime();
		Long t2 = carRental.getFinish().getTime();

		Double hours = (double) (t2 - t1) / 1000 / 60 / 60;
		double basicPayment;
		
		if (hours <= 12.0) {
			basicPayment = Math.ceil(hours) * pricePerHour;
		}
		else {
			basicPayment = Math.ceil(hours / 24) * pricePerHour;
		}
		
		double tax = TaxService.tax(basicPayment);
		carRental.setInvoice(new Invoice(basicPayment, tax));
		
	}

	public RentalService(Double pricePerHour, Double pricePerDay, TaxService taxService) {
		this.pricePerHour = pricePerHour;
		this.pricePerDay = pricePerDay;
		this.TaxService=taxService;
	}

	public Double getPricePerHour() {
		return pricePerHour;
	}

	public void setPricePerHour(Double pricePerHour) {
		this.pricePerHour = pricePerHour;
	}

	public Double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(Double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public TaxService getTaxService() {
		return TaxService;
	}

	public void setTaxService(BrazilTaxService taxService) {
		this.TaxService = taxService;
	}

}
