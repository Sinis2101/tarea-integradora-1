package model;

public class Budget {
	
	public static void printList(String[] list) {
		for(int i=0; i<list.length; i++) {
			System.out.println(list[i]);
		}
	}
	
	public static int totalPrice(int[] price, int[] amount) {
		int total = 0;
		for(int i=0; i<price.length; i++) {
			total += price[i]*amount[i];
		}
		return total;
	}
		
	public static int[] bestPrice(int[] priceList1, int[] priceList2, int[] priceList3) {
		int[] bestPriceList = new int[priceList1.length];
		for(int i=0; i<priceList1.length; i++) {
			if(priceList1[i]<=priceList2[i]&&priceList1[i]<=priceList3[i]) {
				bestPriceList[i] = priceList1[i];
			} else if(priceList2[i]<=priceList1[i]&&priceList2[i]<=priceList3[i]) {
				bestPriceList[i] = priceList2[i];
			} else if(priceList3[i]<=priceList1[i]&&priceList3[i]<=priceList2[i]){
				bestPriceList[i] = priceList3[i];
			}
		}
		return bestPriceList;
	}

	public static String[] bestPricePlace(int[] bestPriceList, int[] priceList1, int[] priceList2, int[] priceList3) {
		String[] bestPricePlaceList = new String[bestPriceList.length];
		for(int i=0; i<bestPriceList.length; i++) {
			if(bestPriceList[i]==priceList1[i]) {
				bestPricePlaceList[i]="Homecenter";
			}else if(bestPriceList[i]==priceList2[i]) {
				bestPricePlaceList[i]="Ferreteria del centro";
			}else{
				bestPricePlaceList[i]="Ferreteria del barrio";
			}
		}
		return bestPricePlaceList;
	} 
			
	public static int getFilterListSize(String[] useList, String filter) {
		int size = 0;
		for(int i=0;i<useList.length;i++) {
			if(useList[i].equalsIgnoreCase(filter)) {
				size += 1;
			}
		}
		return size;
	}
	
	public static String[] getFilterList(int size, String[] materialList, String[] useList, String filter) {
		String[] filterList = new String[size];
		for(int i=0;i<useList.length;i++) {
			if(useList[i].equalsIgnoreCase(filter)) {
				filterList[i] = materialList[i];
			}
		}
		return filterList;
	}
	
	public static int getBestTotal(int[] bestPriceList, int[] amountList) {
		int total = 0;
		for(int i=0; i<bestPriceList.length;i++) {
			total += bestPriceList[i]*amountList[i];
		}
		return total;
	}
}
