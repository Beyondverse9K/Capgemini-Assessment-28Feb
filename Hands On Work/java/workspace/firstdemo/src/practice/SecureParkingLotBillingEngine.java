package practice;

class InvalidParkingException extends Exception{
	public InvalidParkingException(String message) {
		super(message);
	}
}

class BillingErrorException extends RuntimeException{
	public BillingErrorException(String message) {
		super(message);
	}
}

interface ParkingOptions{
	double FeesCalculator(int hours);
	void ParkVehicle(int hours)throws InvalidParkingException;
}

abstract class ParkingAccount implements ParkingOptions{
	private String ownerName;
	private long vehicleNumber;
	private double parkingFee;
	public ParkingAccount(String ownerName, long vehicleNumber) {
		this.ownerName=ownerName;
		this.vehicleNumber=vehicleNumber;
		this.parkingFee=0.0;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public long getVehicleNumber() {
		return vehicleNumber;
	}
	protected abstract double getHourlyRate();
	protected abstract double getSecurityCap();
	
	@Override
	public void ParkVehicle(int hours) throws InvalidParkingException {
		if(hours<=0) {
			throw new InvalidParkingException("Duration must be greater than 0 hours");
		}
		double amount=FeesCalculator(hours);
		if(amount>getSecurityCap()) {
			throw new BillingErrorException("Preventing accidental overcharges! Calculated Cost: "+amount+" exceeds Security Limit: "+getSecurityCap());
		}
		this.parkingFee=FeesCalculator(hours);
		System.out.println("Owner Name: "+getOwnerName()+"  Vehicle Number: "+getVehicleNumber()+"  Total Charges: "+this.parkingFee);
	}
	public void ParkVehicle(int hours, boolean insurance) throws InvalidParkingException {
		ParkVehicle(hours);
		System.out.println("Added Insurance");
		if(insurance && this.parkingFee >0) {
			this.parkingFee+=1000;
			System.out.println("Updated Total Charges: "+this.parkingFee);
		}
	}
}

class TwoWheeler extends ParkingAccount{
	public TwoWheeler(String ownerName, long vehicleNumber) {
		super(ownerName, vehicleNumber);
	}

	@Override
	protected double getHourlyRate() {
		return 50;
	}
	@Override
	protected double getSecurityCap() {
		return 750;
	}
	@Override
	public double FeesCalculator(int hours) {
		return hours*getHourlyRate();
	}
}

class FourWheeler extends ParkingAccount{
	public FourWheeler(String ownerName, long vehicleNumber) {
		super(ownerName, vehicleNumber);
	}

	@Override
	protected double getHourlyRate() {
		return 100;
	}
	@Override
	protected double getSecurityCap() {
		return 1500;
	}
	@Override
	public double FeesCalculator(int hours) {
		return hours*getHourlyRate();
	}
}

public class SecureParkingLotBillingEngine {

	public SecureParkingLotBillingEngine() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		TwoWheeler tw = new TwoWheeler("Anirban",6767L);
		FourWheeler fw = new FourWheeler("Subarna",7676L);
		System.out.println("Parking Lot");
		System.out.println("Two Wheeler");
		try {
			tw.ParkVehicle(10);
			tw.ParkVehicle(11, true);
		}
		catch(InvalidParkingException e) {
			System.out.println("Error: "+e.getMessage());
		}
		System.out.println("Four Wheeler");
		try {
			fw.ParkVehicle(10);
			fw.ParkVehicle(11, true);
		}
		catch(InvalidParkingException e) {
			System.out.println("Error: "+e.getMessage());
		}
		System.out.println("Testing Invalid Parking Exception");
		try {
			fw.ParkVehicle(-2);
		}
		catch(InvalidParkingException e) {
			System.out.println("Validation Error: "+e.getMessage());
		}
		System.out.println("Testing Billing Error Exception");
		try {
			fw.ParkVehicle(16);
		}
		catch(BillingErrorException e) {
			System.out.println("Security Error: "+e.getMessage());
		}
		catch(InvalidParkingException e) {
			System.out.println("Validation Error"+e.getMessage());
		}
	}
}
