package ui;

import model.Budget;
import java.util.Scanner;

public class Main {
	
	static final int ROUGH_CONSTRUCTION = 1300000;
	static final int FINAL_CONSTRUCTION = 2600000;
	static final int PAINTING = 980000;
	
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
			System.out.println("En que se usara el material de: "+materials[i]+". Obra negra, Obra Blanca o Pintura?");
			materialUse[i] = sc.nextLine();		
		}
		sc.nextLine();
		return materialUse;		
	}

	public static void main(String[] args) {
		
	}
}
