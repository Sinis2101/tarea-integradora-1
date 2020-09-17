package ui;

import model.Budget;
import java.util.Scanner;

public class Main {
	
	private static final int ROUGH_CONSTRUCTION = 1300000;
	private static final int FINAL_CONSTRUCTION = 2600000;
	private static final int PAINTING = 980000;
	private static final int WORKFORCE = ROUGH_CONSTRUCTION+FINAL_CONSTRUCTION+PAINTING;
	
	/**
	* Prints all elements from a String array. <br>
	* <b>pre: </b> Array is initialized. <br>
	* <b>post: </b> All elements from the array were printed.
	* @param list String array. list != null and list != "".
	*/
	public static void printList(String[] list) {
		for(int i=0; i<list.length; i++) {
			System.out.println(list[i]);
		}
	}
	public static int totalMaterials(Scanner sc) {
		System.out.println("Ingrese la cantidad de materiales necesarios:");
		int numberOfMaterials = sc.nextInt();
		sc.nextLine();
		return numberOfMaterials;
	}
	public static String[] getMaterialName(int neededMaterials, Scanner sc) {
		String[] materialName = new String[neededMaterials];
		for (int i=0; i<neededMaterials; i++) {
			System.out.println("Ingrese el nombre del material "+(i+1)+":");
			materialName[i] = sc.nextLine();
		}
		return materialName;		
	}
	public static int[] getMaterialAmount(int neededMaterials, String[] materials, Scanner sc) {
		int[] materialAmount = new int[neededMaterials];
		for (int i=0; i<neededMaterials; i++) {
			System.out.println("Ingrese la cantidad de "+materials[i]+":");
			materialAmount[i] = sc.nextInt();
		}
		sc.nextLine();
		return materialAmount;		
	}
	public static String[] getMaterialUse(int neededMaterials, String[] materials, Scanner sc) {
		String[] materialUse = new String[neededMaterials];
		for (int i=0; i<neededMaterials; i++) {
			System.out.println("Ingrese la categoria de "+materials[i]+". Obra negra, Obra Blanca o Pintura?");
			materialUse[i] = sc.nextLine();		
		}
		return materialUse;		
	}
	public static int[] getMaterialPrice(int neededMaterials, String[] materials, Scanner sc, String shop) {
		int[] materialPrice = new int[neededMaterials];
		for (int i=0; i<neededMaterials; i++) {
			System.out.println("Ingrese el precio de "+materials[i]+" en "+shop+":");
			materialPrice[i] = sc.nextInt();
		}
		sc.nextLine();
		return materialPrice;
	}
	public static void showBestPrice(String[] material, int[] bestPriceList, String[] bestPricePlaceList) {
		for(int i=0; i<material.length; i++) {
			System.out.println("El mejor precio para "+material[i]+" es "+bestPriceList[i]+" en "+bestPricePlaceList[i]);
		}
	}
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
