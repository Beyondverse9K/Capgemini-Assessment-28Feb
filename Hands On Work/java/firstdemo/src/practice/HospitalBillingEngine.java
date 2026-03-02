package practice;

interface BillingOperations {
    void calculateBill() throws InvalidBillException;
    void calculateBill(double discount) throws InvalidBillException;
    void calculateBill(String insuranceId) throws InvalidBillException;
}

// Checked Exception
class InvalidBillException extends Exception {
    public InvalidBillException(String message) {
        super(message);
    }
}

// Unchecked Exception
class PaymentNotAllowedException extends RuntimeException {
    public PaymentNotAllowedException(String message) {
        super(message);
    }
}

abstract class PatientAccount implements BillingOperations {

    private String patientId;
    private String patientName;
    private double billAmount;

    protected PatientAccount(String id, String name, double bill) {
        this.patientId = id;
        this.patientName = name;
        this.billAmount = bill;
    }

    protected double getBillAmount() {
        return billAmount;
    }

    protected void validateBill(double amount) throws InvalidBillException {
        if (amount < 0)
            throw new InvalidBillException("Bill amount cannot be negative");
    }
}

// General Patient
class GeneralPatient extends PatientAccount {

    public GeneralPatient(String id, String name, double bill) {
        super(id, name, bill);
    }

    @Override
    public void calculateBill() throws InvalidBillException {
        validateBill(getBillAmount());
        System.out.println("General Patient Bill: " + getBillAmount());
    }

    @Override
    public void calculateBill(double discount) throws InvalidBillException {
        if (discount < 0 || discount > getBillAmount())
            throw new InvalidBillException("Invalid discount");

        double finalBill = getBillAmount() - discount;
        System.out.println("General Patient Bill after discount: " + finalBill);
    }

    @Override
    public void calculateBill(String insuranceId) {
        throw new PaymentNotAllowedException("Insurance not allowed for General Patient");
    }
}

// Insured Patient
class InsuredPatient extends PatientAccount {

    public InsuredPatient(String id, String name, double bill) {
        super(id, name, bill);
    }

    @Override
    public void calculateBill() {
        throw new PaymentNotAllowedException("Cash payment not allowed for Insured Patient");
    }

    @Override
    public void calculateBill(double discount) throws InvalidBillException {
        throw new InvalidBillException("Discount not applicable for Insured Patient");
    }

    @Override
    public void calculateBill(String insuranceId) throws InvalidBillException {
        if (insuranceId == null || insuranceId.isEmpty())
            throw new InvalidBillException("Invalid insurance ID");

        validateBill(getBillAmount());
        System.out.println("Insured Patient Bill settled via Insurance");
    }
}

// Test Class
public class HospitalBillingEngine {

    public static void main(String[] args) {

        BillingOperations p1 =
                new GeneralPatient("P101", "Subarna", 5000);

        BillingOperations p2 =
                new InsuredPatient("P202", "Sumit", 12000);

        try {
            p1.calculateBill(500);            // Cash with discount
            p2.calculateBill("INS-8899");     // Insurance billing
        } catch (InvalidBillException e) {
            System.out.println(e.getMessage());
        }
    }
}