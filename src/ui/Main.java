package ui;

import model.Budget;
import java.util.Scanner;

public class Main {
	
	static final int ROUGH_CONSTRUCTION = 1300000;
	static final int FINAL_CONSTRUCTION = 2600000;
	static final int PAINTING = 980000;
	static final int WORKFORCE = ROUGH_CONSTRUCTION+FINAL_CONSTRUCTION+PAINTING;
	
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
	public static int[] getMaterialPrice(int neededMaterials, String[] materials, Scanner sc, String tienda) {
		int[] materialPrice = new int[neededMaterials];
		for (int i=0; i<neededMaterials; i++) {
			System.out.println("Ingrese el precio de "+materials[i]+" en "+tienda+":");
			materialPrice[i] = sc.nextInt();
		}
		sc.nextLine();
		return materialPrice;
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
		System.out.println("El valor total de los materiales en Homecenter es: "+Budget.totalPrice(pricesHomeCenter, amountList, WORKFORCE));
		System.out.println("El valor total de los materiales en Ferreteria del centro es: "+Budget.totalPrice(pricesFerreteriaCentro, amountList, WORKFORCE));
		System.out.println("El valor total de los materiales en Ferreteria del barrio es: "+Budget.totalPrice(pricesFerreteriaBarrio, amountList, WORKFORCE));
	}
}
