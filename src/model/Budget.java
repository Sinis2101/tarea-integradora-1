package model;

public class Budget {
		
	/**
	 * Gets the total price of the materials by adding each material price multiplied by its amount.
	 * @param price An integer array with all the prices of each material. price != null and price != "".
	 * @param amount An integer array with the amount needed for each material.
	 * @return Returns the sum of each material price multiplied by its amount.
	 */
	public static int totalPrice(int[] price, int[] amount) {
		int total = 0;
		for(int i=0; i<price.length; i++) {
			total += price[i]*amount[i];
		}
		return total;
	}
	
	/**
	 * Compares the prices from each shop and gets the best price for each material.
	 * @param priceList1 An integer array that has all the prices for each material in the first shop.
	 * @param priceList2 An integer array that has all the prices for each material in the second shop.
	 * @param priceList3 An integer array that has all the prices for each material in the third shop.
	 * @return Returns an integer array containing the best prices for each material.
	 */
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

	/**
	 * Gets the name of the shop that has the best price for each material.
	 * @param bestPriceList An integer array containing the best prices for each material.
	 * @param priceList1 An integer array that has all the prices for each material in the first shop.
	 * @param priceList2 An integer array that has all the prices for each material in the second shop.
	 * @param priceList3 An integer array that has all the prices for each material in the third shop.
	 * @return Returns a String array with the name of the shop that has the best price for each material.
	 */
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
	
	/**
	 * Gets the amount of materials in the category introduced.
	 * @param useList A String array that has the use of each material. useList != null.
	 * @param filter The category the user wants to see the materials of. Valid values (Ignores case): "Obra negra", "Obra blanca", "Pintura".
	 * @return Returns the existing amount of materials in the use category.
	 */
	public static int getFilterListSize(String[] useList, String filter) {
		int size = 0;
		for(int i=0;i<useList.length;i++) {
			if(useList[i].equalsIgnoreCase(filter)) {
				size += 1;
			}
		}
		return size;
	}
	
	/**
	 * Gets the list of the name of the materials existing in the filtered category.
	 * @param size The existing amount of materials in the use category. size != null.
	 * @param materialList A String array with the name of each material.
	 * @param useList A String array with the use of each material.
	 * @param filter The category the user wants to see the materials of. Valid values (Ignores case): "Obra negra", "Obra blanca", "Pintura".
	 * @return Returns a String array with the existing materials of the category filter introduced.
	 */
	public static String[] getFilterList(int size, String[] materialList, String[] useList, String filter) {
		String[] filterList = new String[size];
		for(int i=0;i<useList.length;i++) {
			if(useList[i].equalsIgnoreCase(filter)) {
				filterList[i] = materialList[i];
			}
		}
		return filterList;
	}
	
	/**
	 * Sums the best price of each material.
	 * @param bestPriceList An integer array containing the best prices for each material.
	 * @param amountList An integer array with the amount needed for each material.
	 * @return Returns the sum of each material price multiplied by its amount.
	 */
	public static int getBestTotal(int[] bestPriceList, int[] amountList) {
		int total = 0;
		for(int i=0; i<bestPriceList.length;i++) {
			total += bestPriceList[i]*amountList[i];
		}
		return total;
	}
}
