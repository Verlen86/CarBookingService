package CarRent.utils;

import java.util.Scanner;

public class CarOptionChooser {
	private boolean fuelType;
	private boolean transmissionType;
	
	public void fuelChooser(){
		System.out.println("Do you want a diesel car?");
		Scanner scan = new Scanner(System.in);
		String entry=scan.next();
		while(true){
			System.out.println("Please enter a correct answer: y - for diesel, n - for non-diesel:");
			if(entry=="n"||entry=="N")
			{
				fuelType=false;
				return;
			}
			else if(entry=="y"||entry=="Y")
			{
				fuelType=true;
				return;
			}
		}
	}
	
	public void transmissionChooser(){
		System.out.println("Do you want a avtomated transmission ?");
		Scanner scan = new Scanner(System.in);
		String entry=scan.next();
		while(true){
			System.out.println("Please enter a correct answer: y - for diesel, n - for non-diesel:");
			if(entry=="n"||entry=="N")
			{
				transmissionType=false;
				return;
			}
			else if(entry=="y"||entry=="Y")
			{
				transmissionType=true;
				return;
			}
		}		
		
	}

	public boolean getFuelType() {
		return fuelType;
	}

	public boolean getTransmissionType() {
		return transmissionType;
	}
}
