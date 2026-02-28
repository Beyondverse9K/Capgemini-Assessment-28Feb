package FoodOrderingSystem;
import java.util.ArrayList;
import java.util.List;
abstract class Food {
	private int id;
	private String name;
	private double price;

	public Food(int id, String name, double price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}

	public abstract double calculateDiscount();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getFinalPrice() {
		return price - calculateDiscount();
	}

	@Override
	public String toString() {
		return String.format("ID: %d | Name: %s | Price: $%.2f | Discount: $%.2f | Final: $%.2f",
				id, name, price, calculateDiscount(), getFinalPrice());
	}
}
class Veg extends Food {
		public Veg(int id, String name, double price) {
			super(id, name, price);
		}

		@Override
		public double calculateDiscount() {
			// 10% discount for veg items
			return getPrice() * 0.10;
		}

		@Override
		public String toString() {
			return "[VEG] " + super.toString();
		}
}

class NonVeg extends Food {	    
	    public NonVeg(int id, String name, double price) {
	        super(id, name, price);
	    }
	    
	    @Override
	    public double calculateDiscount() {
	        // 5% discount for non-veg items
	        return getPrice() * 0.05;
	    }
	    
	    @Override
	    public String toString() {
	        return "[NON-VEG] " + super.toString();
	    }
}

class Order {
	    private List<Food> items;
	    public Order() {
	        this.items = new ArrayList<>();
	    }	    
	    // Add item to order
	    public void addItem(Food item) {
	        items.add(item);
	        System.out.println("Added: " + item.getName());
	    }	    
	    // Remove item from order
	    public void removeItem(int id) {
	        items.removeIf(item -> item.getId() == id);
	    }	    
	    // Calculate total bill after discounts
	    public double calculateTotalBill() {
	        double total = 0;
	        for (Food item : items) {
	            total += item.getFinalPrice();
	        }
	        return total;
	    }
	    // Display order details
	    public void displayOrder() {
	        if (items.isEmpty()) {
	            System.out.println("Order is empty!");
	            return;
	        }	        
	        System.out.println("\nORDER DETAILS");
	        for (Food item : items) {
	            System.out.println(item);
	        }
	        System.out.println("");
	        System.out.printf("TOTAL BILL: %.2f\n", calculateTotalBill());
	        System.out.println("\n");
	    }    
	    // Getter for items list
	    public List<Food> getItems() {
	        return items;
	    }
}

public class FoodOrderingSystem {
    public static void main(String[] args) {
        System.out.println("ONLINE FOOD ORDERING SYSTEM\n");
        Order order = new Order();
        Food item1 = new Veg(101, "Masala Dosa", 250.0);
        Food item2 = new NonVeg(102, "Chicken Biryani", 1350.0);
        Food item3 = new Veg(103, "Vada Pav", 120.0);
        Food item4 = new NonVeg(104, "Roasted Fish", 1450.0);
        Food item5 = new Veg(105, "Mushroom Soup", 100.0);
        order.addItem(item1);
        order.addItem(item2);
        order.addItem(item3);
        order.addItem(item4);
        order.addItem(item5);
        order.displayOrder();
        System.out.println("Item Name: " + item1.getName());
        System.out.println("Item Price: " + item1.getPrice());
        System.out.println("Item ID: " + item1.getId());
        item1.setPrice(1280.0);
        System.out.println("Updated Price: " + item1.getPrice());
        System.out.println("Updated Final Price: " + item1.getFinalPrice());
        for (Food item : order.getItems()) {
            String type = (item instanceof Veg) ? "VEG (10% discount)" : "NON-VEG (5% discount)";
            System.out.printf("%s - %s: Discount = $%.2f\n", 
                item.getName(), type, item.calculateDiscount());
        }
    }
}