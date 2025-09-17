package supermarket;

import java.util.Scanner;

public class billingsystem {

	public static void main(String[] args) {

		        Scanner sm = new Scanner(System.in);
		        
		        System.out.println("=== SUPERMARKET BILLING SYSTEM ===");
		        
		        // Ask for number of items
		        System.out.print("How many different items did the customer buy? ");
		        int itemCount = sm.nextInt();
		        sm.nextLine(); // Consume newline
		        
		        // Arrays to store item details
		        String[] itemNames = new String[itemCount];
		        double[] prices = new double[itemCount];
		        int[] quantities = new int[itemCount];
		        double[] subtotals = new double[itemCount];
		        
		        double totalBill = 0;
		        
		        // Process each item using for loop
		        for (int i = 0; i < itemCount; i++) {
		            System.out.println("\n--- Item " + (i + 1) + " ---");
		            
		            System.out.print("Item name: ");
		            itemNames[i] = sm.nextLine();
		            
		            System.out.print("Price per unit: ");
		            prices[i] = sm.nextDouble();
		            
		            System.out.print("Quantity purchased: ");
		            quantities[i] = sm.nextInt();
		            sm.nextLine(); // Consume newline
		            
		            // Calculate subtotal
		            subtotals[i] = prices[i] * quantities[i];
		            totalBill += subtotals[i];
		        }
		        
		        // Calculate discount
		        double discount = 0;
		        if (totalBill > 50000) {
		            discount = totalBill * 0.05;
		        }
		        
		        double finalAmount = totalBill - discount;
		        
		        // Print receipt
		        System.out.println("\n=== RECEIPT ===");
		        System.out.println("Item Name\tQty\tPrice\tSubtotal");
		        System.out.println("-----------------------------------");
		        
		        for (int i = 0; i < itemCount; i++) {
		            System.out.print(quantities[i]);
		        }
		        
		        System.out.println("-----------------------------------");
		        System.out.print(totalBill);
		        System.out.print(discount);
		        System.out.print(finalAmount);
		        System.out.println("===================================");
		        
		        sm.close();
		    }
		

	}

