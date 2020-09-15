package model;

public class Budget {
	
	public static void printList(int[] list) {
		for(int i=0; i<list.length; i++) {
			System.out.println(list[i]);
		}
	}
	
	public static int totalPrice(int[] price, int[] amount, int workforce) {
		int total = 0;
		for(int i=0; i<price.length; i++) {
			total += price[i]*amount[i];
		}
		total += workforce;
		return total;
	}
	
}
