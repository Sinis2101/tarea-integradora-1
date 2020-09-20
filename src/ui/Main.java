package ui;

import model.Budget;
import java.util.Scanner;

public class Main {
	
	private static final int ROUGH_CONSTRUCTION = 1300000;
	private static final int FINAL_CONSTRUCTION = 2600000;
	private static final int PAINTING = 980000;
	private static final int WORKFORCE = ROUGH_CONSTRUCTION+FINAL_CONSTRUCTION+PAINTING;
	
	/**
	 * Prints all the elements from a String array. <br>
	 * @param list String array. list != null.
	 */
	public static void printList(String[] list) {
		for(int i=0; i<list.length; i++) {
			System.out.println(list[i]);
		}
	}
	
	/**
	 * Gets the number of materials needed.
	 * @param sc Scanner to read what the user types. Scanner must be initialized.
	 * @return Returns the amount of materials needed.
	 */
	public static int totalMaterials(Scanner sc) {
		System.out.println("Ingrese la cantidad de materiales necesarios:");
		int numberOfMaterials = sc.nextInt();
		sc.nextLine();
		return numberOfMaterials;
	}
	
	/**
	 * Gets the name of each material.
	 * @param neededMaterials The amount of materials needed. neededMaterials != null.
	 * @param sc Scanner to read what the user types. Scanner must be initialized.
	 * @return Returns a String array with the name of all needed materials.
	 */
	public static String[] getMaterialName(int neededMaterials, Scanner sc) {
		String[] materialName = new String[neededMaterials];
		for (int i=0; i<neededMaterials; i++) {
			System.out.println("Ingrese el nombre del material "+(i+1)+":");
			materialName[i] = sc.nextLine();
		}
		return materialName;		
	}
	
	/**
	 * Gets the amount needed for each material.
	 * @param neededMaterials The amount of materials needed. neededMaterials != null.
	 * @param materials A String array with the name of all needed materials.
	 * @param sc Scanner to read what the user types. Scanner must be initialized.
	 * @return Returns an integer array with the amount needed for each material.
	 */
	public static int[] getMaterialAmount(int neededMaterials, String[] materials, Scanner sc) {
		int[] materialAmount = new int[neededMaterials];
		for (int i=0; i<neededMaterials; i++) {
			System.out.println("Ingrese la cantidad de "+materials[i]+":");
			materialAmount[i] = sc.nextInt();
		}
		sc.nextLine();
		return materialAmount;		
	}
	
	/**
	 * Gets the use of each material.
	 * @param neededMaterials The amount of materials needed. neededMaterials != null.
	 * @param materials A String array with the name of all needed materials.
	 * @param sc Scanner to read what the user types. Scanner must be initialized.
	 * @return Returns a String array with the use of each material.
	 */
	public static String[] getMaterialUse(int neededMaterials, String[] materials, Scanner sc) {
		String[] materialUse = new String[neededMaterials];
		for (int i=0; i<neededMaterials; i++) {
			System.out.println("Ingrese la categoria de "+materials[i]+". Obra negra, Obra Blanca o Pintura?");
			materialUse[i] = sc.nextLine();		
		}
		return materialUse;		
	}
	
	/**
	 * Gets the price of each material for each shop.
	 * @param neededMaterials The amount of materials needed. neededMaterials != null.
	 * @param materials A String array with the name of all needed materials.
	 * @param sc Scanner to read what the user types. Scanner must be initialized.
	 * @param shop The name of the shop. shop != null and shop != "".
	 * @return Returns an integer array with the price of each material.
	 */
	public static int[] getMaterialPrice(int neededMaterials, String[] materials, Scanner sc, String shop) {
		int[] materialPrice = new int[neededMaterials];
		for (int i=0; i<neededMaterials; i++) {
			System.out.println("Ingrese el precio de "+materials[i]+" en "+shop+":");
			materialPrice[i] = sc.nextInt();
		}
		sc.nextLine();
		return materialPrice;
	}
	
	/**
	 * Compares all the prices from all the shops and gets the best price for each material.
	 * @param material A String array with the name of all needed materials.
	 * @param bestPriceList An integer array with the best price of each material.
	 * @param bestPricePlaceList A String array with the shop that has the best price of each material.
	 */
	public static void showBestPrice(String[] material, int[] bestPriceList, String[] bestPricePlaceList) {
		for(int i=0; i<material.length; i++) {
			System.out.println("El mejor precio para "+material[i]+" es "+bestPriceList[i]+" en "+bestPricePlaceList[i]);
		}
	}
	
	/**
	 * Calculates the delivery cost for each shop based on location and total price for all materials.
	 * @param location Location of the building place. Valid values (Ignores case): "Norte", "Centro", "Sur".
	 * @param totalPrice Total price for all materials.
	 * @return Returns the delivery cost.
	 */
	public static int deliveryCost(String location, int totalPrice) {
		int cost = 0;
		location = location.toLowerCase();
		switch(location) {
			case "norte":
				if(totalPrice<80000) {
					cost = 120000;
				}else if(totalPrice<300000) {
					cost = 28000;
				}else {
					cost = 0;
				}				
				break;
			case "centro":
				if(totalPrice<80000) {
					cost = 50000;
				}else if(totalPrice<300000) {
					cost = 0;
				}else {
					cost = 0;
				}
				break;	
			case "sur":
				if(totalPrice<80000) {
					cost = 120000;
				}else if(totalPrice<300000) {
					cost = 55000;
				}else {
					cost = 0;
				}
				break;	
		}
		return cost;
	}
	
	/**
	 * Shows the total cost of the work. It takes into account delivery cost and fixed workforce price.
	 * @param materialPrice The total price for the materials.
	 * @param deliveryPrice The delivery cost.
	 * @param workforce Fixed price for the workforce.
	 * @param shop The name of the shop. shop != null and shop != "".
	 */
	public static void showTotalPerShop(int materialPrice, int deliveryPrice, int workforce, String shop) {
		int total = materialPrice+deliveryPrice+workforce;
		System.out.println("El costo total de la obra si los materiales se compran en "+shop+" es: "+total);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int totalMaterial = totalMaterials(sc);
		String[] materialList = getMaterialName(totalMaterial, sc);
		int[] amountList = getMaterialAmount(totalMaterial, materialList, sc);
		String[] useList = getMaterialUse(totalMaterial, materialList, sc);
		int[] pricesHomeCenter = getMaterialPrice(totalMaterial, materialList, sc, "HomeCenter");
		int[] pricesFerreteriaCentro = getMaterialPrice(totalMaterial, materialList, sc, "Ferreteria del centro");
		int[] pricesFerreteriaBarrio = getMaterialPrice(totalMaterial, materialList, sc, "Ferreteria del barrio");
		int materialTotalHomeCenter = Budget.totalPrice(pricesHomeCenter, amountList);
		int materialTotalFerreteriaCentro = Budget.totalPrice(pricesFerreteriaCentro, amountList);
		int materialTotalFerreteriaBarrio = Budget.totalPrice(pricesFerreteriaBarrio, amountList);
		System.out.println("Ingrese la ubicacion de su inmueble. Norte, centro o sur?");
		String location = sc.nextLine();
		int deliveryCostHomeCenter = deliveryCost(location, materialTotalHomeCenter);
		int deliveryCostFerreteriaCentro = deliveryCost(location, materialTotalFerreteriaCentro);
		int deliveryCostFerreteriaBarrio = deliveryCost(location, materialTotalFerreteriaBarrio);
		showTotalPerShop(materialTotalHomeCenter, deliveryCostHomeCenter, WORKFORCE, "HomeCenter");
		showTotalPerShop(materialTotalFerreteriaCentro, deliveryCostFerreteriaCentro, WORKFORCE, "la Ferreteria del Centro");
		showTotalPerShop(materialTotalFerreteriaBarrio, deliveryCostFerreteriaBarrio, WORKFORCE, "la Ferreteria del Barrio");
		int[] bestPriceList = Budget.bestPrice(pricesHomeCenter, pricesFerreteriaCentro, pricesFerreteriaBarrio);
		String[] bestPricePlaceList = Budget.bestPricePlace(bestPriceList, pricesHomeCenter, pricesFerreteriaCentro, pricesFerreteriaBarrio);
		showBestPrice(materialList, bestPriceList, bestPricePlaceList);
		int bestTotal = Budget.getBestTotal(bestPriceList, amountList);
		int bestTotalDeliveryCost = deliveryCost(location, bestTotal);
		System.out.println("El costo total de la obra si los materiales se compran al mejor precio es: "+(bestTotal+bestTotalDeliveryCost+WORKFORCE));
		System.out.println("Ingrese una categoria para ver sus materiales. Obra negra, Obra Blanca o Pintura?");
		String filter = sc.nextLine();
		int filterListSize = Budget.getFilterListSize(useList, filter);
		String[] filterList = Budget.getFilterList(filterListSize, materialList, useList, filter);
		printList(filterList);
	}
}
