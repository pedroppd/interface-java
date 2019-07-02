package main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import domain.CarRental;
import domain.Vehicle;
import service.BrazilTaxService;
import service.RentalService;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");

		System.out.println("Enter rental date: ");
		System.out.print("Car model: ");
		String carModel = sc.nextLine();
		System.out.print("Pickup (dd/MM/yyyy HH:ss) : ");
		Date start = sdf.parse(sc.nextLine());
		System.out.print("Return (dd/MM/yyy hh:ss): ");
		Date finish = sdf.parse(sc.nextLine());

		CarRental sr = new CarRental(start, finish, new Vehicle(carModel));

		System.out.print("Enter price per hour: ");
		double pricePerHour = sc.nextDouble();
		System.out.print("Enter price per day: ");
		double pricePerDay = sc.nextDouble();
		
		RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());
		
		rentalService.processInvoice(sr);

		System.out.println("INVOICE: ");
		System.out.println("Basic payment: " + String.format("%.2f", sr.getInvoice().getBasicPayment()));
		System.out.println("tax: " + String.format("%.2f", sr.getInvoice().getTax()));
		System.out.println("total Payment: " + String.format("%.2f", sr.getInvoice().getTotalPayment()));
		
		sc.close();

	}
}
