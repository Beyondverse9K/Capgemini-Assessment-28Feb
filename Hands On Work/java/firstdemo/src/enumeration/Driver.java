package enumeration;

public class Driver {

	public static void main(String[] args) {
		Status status=Status.APPROVED;
		System.out.println(status);
		//switch
		System.out.println(Status.PENDING);
		switch (status) {
		case PENDING:
		System.out.println("Order placed");
		break;
		case APPROVED:
		System.out.println("Order processing");
		break;
		case REJECTED:
		System.out.println("Order delivered");
		break;
		}
		//additional int code
		OrderStatus OS = OrderStatus.SHIPPED;
		System.out.println(OS.getCode());
		//iteration
		for(Status s: Status.values()) {
			System.out.println(s);
		}
		//index
		System.out.println(Status.PENDING.ordinal());
	}
}
