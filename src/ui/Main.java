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
		
	public static void main(String[] args) {
		
	}
}
