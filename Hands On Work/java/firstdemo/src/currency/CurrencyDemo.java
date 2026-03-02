package currency;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class CurrencyDemo {

	public CurrencyDemo() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) {
		Currency inr = Currency.getInstance("INR");
		Currency usd = Currency.getInstance("USD");
		System.out.println("Codes : "+inr.getCurrencyCode());
		System.out.println("Codes : "+usd.getCurrencyCode());
		BigDecimal bd = new BigDecimal("125000.75");
		NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(new Locale("en","IN"));
		NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
		NumberFormat ukFormat = NumberFormat.getCurrencyInstance(Locale.UK);
		System.out.println(indiaFormat.format(bd));
		System.out.println(ukFormat.format(bd));
	}
}
