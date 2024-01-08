package com.rentalcamera;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
class cameraData {
	 private int cameraId;
	 private String brand;
	 private String model;
	 private double price;
	 private boolean available;
 cameraData(int cameraId, String brand, String model, double price, boolean available) {
	 this.cameraId = cameraId;
	 this.brand = brand;
	 this.model = model;
	 this.price = price;
	 this.available = available;
 	 }
	 public int getCameraId() {
	 return cameraId;
	 }
	 public String getBrand() {
	 return brand;
	 }
	 public String getModel() {
	 return model;
	 }
	 public double getPrice() {
	 return price;
	 }
	 public boolean isAvailable() {
	 return available;
	 }
	 public void setAvailable(boolean available) {
	 this.available = available;
	 }
	}
public class CameraRentalApp {
	 private static final double INITIAL_BALANCE = 1000;
	 private static List<cameraData> cameraList;
	 private static double walletBalance;
	 public static void main(String[] args) {
	 initialize();
	 login();
	 }
 private static void initialize() {
	 cameraList = new ArrayList<>();
	 walletBalance = INITIAL_BALANCE;
	 cameraList.add(new cameraData(1, "Panasonic", "xc", 1000, true));
	 cameraList.add(new cameraData(2, "Sony", "Ds123", 500, true));
	 cameraList.add(new cameraData(3, "LG", "5050", 280, true));
	 cameraList.add(new cameraData(4, "Canon", "XPL", 300, true));
	 cameraList.add(new cameraData(5, "Nikon", "SRL", 350, true));
	 cameraList.add(new cameraData(6, "Sony", "2130", 260, false));
	 cameraList.add(new cameraData(7, "Samsung", "DL", 550, true));
	 cameraList.add(new cameraData(8, "Chroma", "Digital", 120, false));
	 }
private static void login() {
	 Scanner scanner = new Scanner(System.in);
	 System.out.println("+-------------------------------+");
	 System.out.println("| WELCOME TO CAMERA RENTAL APP |");
	 System.out.println("+-------------------------------+");
	 System.out.println("PLEASE LOGIN TO CONTINUE\n");
	 System.out.print("ENTER USERNAME: ");
	 String username = scanner.nextLine();
	 System.out.print("ENTER PASSWORD: ");
	 String password = scanner.nextLine();
	 if (username.equals("admin") && password.equals("admin123")) {
	 System.out.println("******************");
	 System.out.println(" LOGIN SUCCESSFUL");
	 System.out.println("******************\n");
	 showMainMenu(scanner);
	 } 
	 else {
	 System.out.println("***********************");
	 System.out.println(" AUTHENTICATION FAILED");
	 System.out.println("***********************");
	 }
	 System.out.println("********* THANK YOU FOR VISITING CAMERA RENTAL APPLICATION PROJECT! *********");
	 }
 private static void showMainMenu(Scanner scanner) {
	 int choice;
	 do {
		 System.out.println("\nMENU");
		 System.out.println("***********");
		 System.out.println("1. MY CAMERA");
		 System.out.println("2. RENT A CAMERA");
		 System.out.println("3. VIEW ALL CAMERAS");
		 System.out.println("4. MY WALLET");
		 System.out.println("5. EXIT");
		 System.out.print("Select your option: ");
		 choice = scanner.nextInt();
		 switch (choice) {
		 case 1:
		 showMyCameraMenu(scanner);
		 break;
		 case 2:
		 rentCamera(scanner);
		 break;
		 case 3:
		 viewAllCameras();
		break;
		 case 4:
		 viewWalletBalance(scanner);
		 break;
		 case 5:
		 return;
		 default:
		 System.out.println("INVALID INPUT");
		 break;
		 }
		 } while (true);
	 }
	 private static void showMyCameraMenu(Scanner scanner) {
	 int choice;
	 do {
		 System.out.println("\nMY CAMERA");
		 System.out.println("***********");
		 System.out.println("1. ADD");
		 System.out.println("2. REMOVE");
		 System.out.println("3. VIEW MY CAMERAS");
		 System.out.println("4. GO TO PREVIOUS MENU");
		 System.out.print("Enter Your Choice: ");
		 choice = scanner.nextInt();
		 switch (choice) {
		 case 1:
		 addCamera(scanner);
		 break;
		 case 2:
		 removeCamera(scanner);
		 break;
		 case 3:
		 viewMyCameras();
		break;
		 case 4:
		 return;
		 default:
		 System.out.println("INVALID INPUT");
		 break;
		 }
	 } while (true);
	 }
 private static void addCamera(Scanner scanner) {
	 int cameraId = cameraList.size() + 1;
	 System.out.print("ENTER CAMERA BRAND: ");
	 String brand = scanner.next();
	 System.out.print("ENTER CAMERA MODEL: ");
	 String model = scanner.next();
	 System.out.print("ENTER CAMERA PRICE PER DAY: ");
	 double price = scanner.nextDouble();
	 boolean available = true;
	 cameraList.add(new cameraData(cameraId, brand, model, price, available));
	 System.out.println("YOUR CAMERA HAS BEEN SUCCESSFULLY ADDED TO THE LIST.\n");
	 System.out.println("********************\n");
	 viewAllCameras();
 }
 private static void removeCamera(Scanner scanner) {
	 System.out.print("WHICH ONE YOU WANT TO REMOVE 'ENTER CAMERA ID': ");
	 int cameraId = scanner.nextInt();
	 boolean removed = false;
	 for (cameraData camera : cameraList) {
	 if (camera.getCameraId() == cameraId) {
	 cameraList.remove(camera);
	 System.out.println("CAMERA SUCCESSFULLY REMOVED FROM THE LIST.");
	 System.out.println("**********************\n");
	 removed = true;
	 break;
 }
 }
 if (!removed) {
	 System.out.println("CAMERA WITH ID " + cameraId + " IS NOT FOUND IN THE LIST.");
 }
 viewAllCameras();
 }
 private static void viewMyCameras() {
	 System.out.println("==================================================");
	 System.out.println("CAMERA_ID\t| BRAND\t| MODEL\t| PRICE\t| STATUS |");
	 System.out.println("==================================================");
	 for (cameraData data : cameraList) {
		 String status = data.isAvailable() ? "Available" : "Rented";
		 System.out.println(data.getCameraId() + "\t\t" + data.getBrand() + "\t" +
		 data.getModel() + "\t" +
		 data.getPrice() + "\t" + status);
	 }
	 System.out.println("==================================================");
 }
 private static void rentCamera(Scanner scanner) {
	 System.out.println("==================================================");
	 System.out.println("CAMERA_ID\t| BRAND\t| MODEL\t| PRICE\t| STATUS |");
	 System.out.println("==================================================");
	 for (cameraData data : cameraList) {
		 if (data.isAvailable()) {
		 String status = data.isAvailable() ? "Available" : "Rented";
		 System.out.println(data.getCameraId() + "\t\t" + data.getBrand() + "\t"
		+ data.getModel() + "\t" +
		 data.getPrice() + "\t" + status);
	 }
 }
	 System.out.println("==================================================");
	 System.out.print("WHICH ONE YOU WANT TO RENT 'ENTER CAMERA ID': ");
	 int cameraId = scanner.nextInt();
	 boolean rented = false;
	 for (cameraData camera : cameraList) {
	 if (camera.getCameraId() == cameraId) {
		 if (camera.getPrice() <= walletBalance) {
			 System.out.println("RENTED SUCCESSFULLY\n");
			 camera.setAvailable(false);
			 walletBalance -= camera.getPrice();
			 System.out.println("CURRENT WALLET BALANCE - " + walletBalance);
		 } else {
			 System.out.println("ERROR: TRANSACTION FAILED DUE TO INSUFFICIENT WALLET BALANCE. " +
					 "PLEASE DEPOSIT THE AMOUNT TO YOUR WALLET.");
	 }
		 rented = true;
		 break;
	 }
	 }
	 if (!rented) {
		 System.out.println("CAMERA WITH ID " + cameraId + " IS NOT FOUND IN THE LIST.");
	 }
 }
 private static void viewAllCameras() {
	 System.out.println("==================================================");
	 System.out.println("CAMERA_ID\t| BRAND\t| MODEL\t| PRICE\t| STATUS |");
	 System.out.println("==================================================");
	 for (cameraData data : cameraList) {
		 String status = data.isAvailable() ? "Available" : "Rented";
		 System.out.println(data.getCameraId() + "\t\t" + data.getBrand() + "\t" +
		data.getModel() + "\t" +
		 data.getPrice() + "\t" + status);
	 }
	 System.out.println("==================================================");
 }
 private static void viewWalletBalance(Scanner scanner) {
	 System.out.println("YOUR CURRENT WALLET BALANCE IS: " + walletBalance);
	 System.out.print("DO YOU WANT TO DEPOSIT MORE AMOUNT TO YOUR WALLET? (1.YES2.NO): ");
	 int choice = scanner.nextInt();
	 if (choice == 1) {
		 System.out.print("ENTER DEPOSIT AMOUNT: ");
		 double addAmount = scanner.nextDouble();
		 walletBalance += addAmount;
		 System.out.println("YOUR WALLET BALANCE UPDATED SUCCESSFULLY...");
	 }
	 System.out.println("CURRENT WALLET BALANCE - " + walletBalance);
	 }
}