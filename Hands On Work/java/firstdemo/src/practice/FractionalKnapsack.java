package practice;
import java.util.Arrays;
import java.util.Comparator;
public class FractionalKnapsack {
	public static double fractionalKnapsack(int W, int[] values, int[] weights) {
		int n = values.length;
		Item[] items = new Item[n];
		// Create items
		for (int i = 0; i < n; i++) {
			items[i] = new Item(values[i], weights[i]);
		}
		// Sort items using Comparator (no lambda)
		Arrays.sort(items, new ItemComparator());
		double totalValue = 0.0;
		// Pick items greedily
		for (int i = 0; i < n; i++) {
			// If full item can be taken
			if (items[i].weight <= W) {
				W = W - items[i].weight;
				totalValue = totalValue + items[i].value;
			}
			// Take fraction of item
			else {
				double fraction = (double) W / items[i].weight;
				totalValue = totalValue + (items[i].value * fraction);
				break;
			}
		}
		return totalValue;
	}
	public static void main(String[] args) {
		int[] values = {60, 100, 120};
		int[] weights = {10, 20, 30};
		int W = 50;
		System.out.println(fractionalKnapsack(W, values, weights));
	}
}


class Item {
	int value;
	int weight;
	Item(int value, int weight) {
		this.value = value;
		this.weight = weight;
	}
}

class ItemComparator implements Comparator<Item> {
	@Override
	public int compare(Item a, Item b) {
		double ratio1 = (double) a.value / a.weight;
		double ratio2 = (double) b.value / b.weight;
		// Sort in descending order of value/weight
		if (ratio1 < ratio2)
			return 1;
		else if (ratio1 > ratio2)
			return -1;
		else
			return 0;
	}

}

