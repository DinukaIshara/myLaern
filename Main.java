import java.util.*;

public class Main{
	static Scanner input = new Scanner(System.in);
	static String[] ar = {"danujav","1234"};
	static String[] supplierID = new String[0];
    static String[] supplierName = new String[0];
    static String[] itemCategorys = new String[0];
    static String[][] item = new String[0][7];
	
	//-Clear Console Method-
	private final static void clearConsole() {
		final String os = System.getProperty("os.name");
		try {
			if (os.equals("Linux")) {
			System.out.print("\033\143");
		} else if (os.equals("Windows")) {
			new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		} else {
			System.out.print("\033[H\033[2J");
			System.out.flush();
			}
		} catch (final Exception e) {
			//handle the exception
			System.err.println(e.getMessage());
		}
	}
	
	//----Main Method----
	public static void main(String[] args){
		loginPage(); // Call the Login Page
	}
	
	//---Login Page---(Q01)
	public static void loginPage() {
		System.out.println("\n+---------------------------------------------------------------+");
		System.out.println("|\t\t\tLOGIN PAGE\t\t\t\t|");
		System.out.println("+---------------------------------------------------------------+\n");
		System.out.println();
		
		checkUserNameLogin(); // Call the User Name check method
	}
	
	public static void checkUserNameLogin(){
		System.out.print("User Name : ");
		String userName = input.next();
		
		if (userName.equals(ar[0])) {
			checkPasswordLogin(); // condition true , call the Password check method
		}else{
			System.out.println("User name is invalid. Please try again!");
			System.out.println();
			checkUserNameLogin(); //canditon false, recall the checkUserNameLogin method (recursion)
			
		}
	}
	
	public static void checkPasswordLogin() {
		System.out.print("\nPassword : ");
		String password = input.next();
		
		if (password.equals(ar[1])) {
			clearConsole();
			homePage();
		}else{
			System.out.println("Password is incorrect. Please try again!");
			checkPasswordLogin();
		}
	}
	//---Choose Main Options---Home Page (Q02)
	public static void homePage() {
		System.out.println("\n+-------------------------------------------------------+");
		System.out.println("|\tWELCOME TO IJSE STOCK MANAGEMENT SYSTEM\t\t|");
		System.out.println("+-------------------------------------------------------+\n");
		
		System.out.println("[1] Change the Credentials\t[2] Supplier Manage\n[3] Stock Manage\t\t[4] Log out\n[5] Exit the system");
		
		checkOptions();
	}
	
	public static void checkOptions() {
		System.out.print("\nEnter an option to continue > ");
		int option = input.nextInt();
		
		switch (option) {
			case 1:
				clearConsole();
				changeTheCredentialsPage();
				break;
			case 2:
				clearConsole();
				supplierManagePage();
				break;
			case 3:
				clearConsole();
				stockManagePage();
				break;
			case 4:
				clearConsole();
				loginPage(); //(Q04). Log out
				break;
			case 5:
				clearConsole();
				return;//System.exit(0);  -->  Exit (Q05)
			default:
				System.out.println("Invalid Option");
				homePage();
		}
		
	}
	//--Credential Manage Page--(Q03)
	public static void changeTheCredentialsPage() {
		System.out.println("\n+---------------------------------------------------------------+");
		System.out.println("|\t\t\tCREDENTIAL MANAGE\t\t\t|");
		System.out.println("+---------------------------------------------------------------+\n");
		
		changeTheCredentials();
	}
	
	public static void changeTheCredentials() {
		System.out.print("\nPlease enter the user name to verify it's you : ");
		String userName = input.next();
		
		if (userName.equals(ar[0])) {
			System.out.println("Hey " + ar[0]);
			checkCurruntPassword();
		}else{
			System.out.println("Invalid user name. try again!\n");
			changeTheCredentials();
			
		}
	}
	
	public static void checkCurruntPassword() {
		System.out.print("Enter your current password : ");
		String password = input.next();
		
		if (password.equals(ar[1])) {
			System.out.print("Enter your new password : ");
			ar[1] = input.next();
			System.out.print("Password changed successfully!!  Do you want to go home page (y/n) : ");
			String option = input.next();
			
			switch (option) {
				case "y":
					clearConsole();
					homePage();
					break;
				default:
					clearConsole();
					return;
				}
				
		}else{
			System.out.print("incorrect password. try again!");
			checkCurruntPassword();
		}
	}
	
	//---Supplier Manage---(Q06)
	public static void supplierManagePage() {
		System.out.println("\n+---------------------------------------------------------------+");
		System.out.println("|\t\t\tSUPPLIER MANAGE\t\t\t\t|");
		System.out.println("+---------------------------------------------------------------+\n");
		
		System.out.println("[1] Add Supplier\t\t[2] Update Supplier\n[3] Delete Supplier\t\t[4] Viwe Suppliyers\n[5] Search Supplier\t\t[6] Home Page");
		chooseSMOption();
		
	}
	
	public static void chooseSMOption() {
		System.out.print("\nEnter an option to continue > ");
		int option = input.nextInt();
		
		switch (option) {
			case 1:
				clearConsole();
				addSupplierOption();
				break;
			case 2:
				clearConsole();
				updateSupplierPage();
				break;
			case 3:
				clearConsole();
				deleteSupplierPage();
				break;
			case 4:
				clearConsole();
				viewSupplier();
				break;
			case 5:
				clearConsole();
				searchSupplierPage();
				break;
			case 6:
				clearConsole();
				homePage();
				break;
			default:
				System.out.println("Invalid Option");
				chooseSMOption();
		}
	}
	
	//--Add Suppliers--(Q07)
	public static void addSupplierOption() {
		System.out.println("\n+---------------------------------------------------------------+");
		System.out.println("|\t\t\tADD SUPPLIER\t\t\t\t|");
		System.out.println("+---------------------------------------------------------------+\n");
	
		addSupplier();
	}
	
    public static void addSupplier() {

        String option = "y";
				
		supplierID = grow(supplierID);
		supplierName = grow(supplierName);

		String newSupplierID;
		boolean isDuplicate;

		do {
			System.out.print("Supplier ID\t: ");
			newSupplierID = input.next();

			// Check if the newSupplierID is a duplicate (isUniqe method pass true or false)
			isDuplicate = isUniqe(newSupplierID,supplierID);

			if (isDuplicate) {
				System.out.println("already exists. try another supplier Id!\n");
			}

		} while (isDuplicate);

		supplierID[supplierID.length - 1] = newSupplierID;

		System.out.print("Supplier Name\t: ");
		supplierName[supplierName.length - 1] = input.next();
			
		System.out.print("Supplier added successfully! Do you want to add another supplier (y/n)? ");
		option = input.next();
					
		if(option.equals("y") || option.equals("n") || option.equals("Y") || option.equals("N")) {
			if(option.equals("y") || option.equals("Y")) {
				clearConsole();
				addSupplierOption();
						
			}else{
				clearConsole();
				supplierManagePage();
			}

		}else{
			System.out.println("Invalid Option!");
			System.out.print("\nDo you want to add another supplier (y/n)? ");
			option = input.next();
		}
    }
    
    //-Grow 1D Array-
	public static String[] grow(String[] supplier) {
        String[] temp = new String[supplier.length + 1];
        
        for (int i = 0; i < supplier.length; i++) {
            temp[i] = supplier[i];
        }
        return temp;
    }
    
    //-Check Unic Supplier ID-
	public static boolean isUniqe(String newSupplierID, String[] supplierID) {
        for (String sID : supplierID) {
            if (sID != null && sID.equals(newSupplierID)) {
                return true;
            }
        }
        return false;
    }
	
	//--Update Supplier--(Q08)
	public static void updateSupplierPage() {
		System.out.println("\n+---------------------------------------------------------------+");
		System.out.println("|\t\t\tUPDATE SUPPLIER\t\t\t\t|");
		System.out.println("+---------------------------------------------------------------+");
		
		updateSupplier();
	}
	
	public static void updateSupplier() {
		System.out.print("\nSupplier ID\t: ");
        String sID = input.next();

        boolean id = false;

        for (int i = 0; i < supplierID.length; i++) {
            if (sID.equals(supplierID[i])) {
                id = true;

                System.out.println("Supplier Name\t: " + supplierName[i]);

                System.out.print("\nEnter the new supplier name : ");
                supplierName[i] = input.next();

                System.out.print("Updated Successfully! Do you want to update another supplier? (y/n): ");
                String option = input.next();

                if (option.equals("y")) {
					clearConsole();
                    updateSupplierPage();
                } else if (option.equals("n")) {
                    clearConsole();
                    supplierManagePage();
                } else {
                    System.out.println("Invalid option. Exiting.");
                    return;
                }
            }
        }

        if (!id) {
            System.out.println("Can't find supplier ID. Try again.");
            updateSupplier();
        }
    }

	//--Delete Suppliers--(Q09)
	public static void deleteSupplierPage() {
		System.out.println("\n+---------------------------------------------------------------+");
		System.out.println("|\t\t\tDELETE SUPPLIER\t\t\t\t|");
		System.out.println("+---------------------------------------------------------------+\n");
		
		deleteSupplier();
	}
	// Drop array
	public static String[] drop(String id, String[] supplier) {
        String[] temp = new String[supplier.length - 1];
        int j = 0;

        for (int i = 0; i < supplier.length; i++) {
            if (!id.equals(supplier[i])) {
                temp[j++] = supplier[i];
            }
        }
        return temp;
    }
	
	public static void deleteSupplier() {
		System.out.print("Supplier ID\t: ");
        String id = input.next();
        
        boolean bool = false;

        for (int i = 0; i < supplierID.length; i++) {
            if (id.equals(supplierID[i])) {
				
                bool = true;
                
                supplierID = drop(id, supplierID);
                supplierName = drop(supplierName[i], supplierName);
                System.out.print("Deleted successfully! Do you want to delete another? (y/n): ");
                String option = input.next();

                if (option.equals("y")) {
                    deleteSupplier();
                } else if (option.equals("n")) {
                    clearConsole();
                    // Assuming you have a method named supplierManagePage(), call it here
                    supplierManagePage();
                } else {
                    System.out.println("Invalid option. Exiting.");
                    return;
                }
            }
        }

       if (!bool) {
            System.out.println("Can't find supplier ID. Try again!\n");
            deleteSupplier();
        }
	}
	//--Viwe Suppliers--(Q10)
	public static void viewSupplier() {
		System.out.println("\n+---------------------------------------------------------------+");
		System.out.println("|\t\t\tVIWE SUPPLIER\t\t\t\t|");
		System.out.println("+---------------------------------------------------------------+\n");
		
		System.out.printf("+------------------+------------------+%n");
		System.out.printf("| %-16s | %-16s	|%n", "SUPPLIYER ID", "SUPPLIER NAME");
		System.out.printf("+------------------+------------------+%n");
		for (int i = 0; i < supplierID.length; i++) {
			System.out.printf("| %-16s | %-16s |%n", supplierID[i],supplierName[i]);
		}
		System.out.printf("+------------------+------------------+%n");
		
		System.out.print("Do you want to go supplier manage page(y/n)?");
		String option = input.next();
				
				if (option.equals("y") || option.equals("n")) {
					if (option.equals("y")) {
						clearConsole();
						supplierManagePage();
					}else{
						clearConsole();
						return;
					}
				}	
			}
	//--Search Supplier--(Q11)		
	public static void searchSupplierPage() {
		System.out.println("\n+---------------------------------------------------------------+");
		System.out.println("|\t\t\tSEARCH SUPPLIER\t\t\t\t|");
		System.out.println("+---------------------------------------------------------------+\n");
		
		searchSupplier();
	}

	public static void searchSupplier() {
		System.out.print("Supplier ID\t: ");
		String sID = input.next();
		
		boolean con = false;
		
		for (int i = 0; i < supplierID.length; i++) {
			
			if (sID.equals(supplierID[i])) {
				con = true;
				System.out.println("Supplier Name\t: " + supplierName[i]);
				System.out.println("Search successfully! Do you want to search another ID ?(y/n)");
				String option = input.next();
				
					if (option.equals("y") || option.equals("Y")) {
						clearConsole();
						searchSupplierPage();
					}else if (option.equals("n") || option.equals("N")){
						clearConsole();
						supplierManagePage();
					}else{
						clearConsole();
						return;
					}
			}
		}
		if (!con){
			System.out.println("Sorry!!!!! invalid id try again");
			searchSupplier();
		}
	}
	//--Stock Management Page--(Q13)
	public static void stockManagePage() {
		System.out.println("\n+---------------------------------------------------------------+");
		System.out.println("|\t\t\tSTOCK MANAGEMENT\t\t\t|");
		System.out.println("+---------------------------------------------------------------+\n");
		
		System.out.println("[1] Manage Item Categories\t\t[2] Add Item\n[3] Get Item Supplier Wise\t\t[4] Viwe Items\n[5] Rank Items Per Unit Price\t\t[6] Home Page");
		
		stockManage();
	}
	
	public static void stockManage() {
		System.out.print("\nEnter an option to continue > ");
		int option = input.nextInt();
		
		switch(option) {
			case 1:
				clearConsole();
				manageItemCategoryPage();
				break;
			case 2:
				clearConsole();
				addItemPage();
				break;
			case 3:
				clearConsole();
				getItemsSupplierWisePage();
				break;
			case 4:
				clearConsole();
				viweItems();
				break;
			case 5:
				clearConsole();
				rankItemsPerUnitPrice();
				break;
			case 6:
				clearConsole();
				homePage();
				break;
			default:
				System.out.println("Invalid Option");
				stockManage();
		}	
	}
	//--Manage Item Category--(Q14)
	public static void manageItemCategoryPage() {
		System.out.println("\n+---------------------------------------------------------------+");
		System.out.println("|\t\t\tMANAGE ITEM CATEGORY\t\t\t|");
		System.out.println("+---------------------------------------------------------------+\n");
		
		System.out.println("[1] Add new Item Category\t[2] Delete Item Category\n[3] Update Item Category\t[4] Stock Management");
		
		manageItemCategoryOption();
	}	
	
	public static void manageItemCategoryOption() {
		System.out.print("\nEnter an option to continue > ");
		int option = input.nextInt();
		
		switch(option) {
			case 1:
				clearConsole();
				addNewItemCategoryPage();
				break;
			case 2:
				clearConsole();
				deleteItemCategoryPage();
				break;
			case 3:
				clearConsole();
				updateItemCategoryPage();
				break;
			case 4:
				clearConsole();
				stockManagePage();
				break;
			default:
				System.out.println("Invalid Option! Please try again.");
				manageItemCategoryOption();
			}
	}
	//--Add Item Category--(Q15)
	public static void addNewItemCategoryPage() {
		System.out.println("\n+---------------------------------------------------------------+");
		System.out.println("|\t\t\tADD ITEM CATEGORY\t\t\t|");
		System.out.println("+---------------------------------------------------------------+\n");
		
		addNewItemCategory();
	}
	
	public static void addNewItemCategory() {

		String itemCategory;
		boolean isDuplicate;

		do {
			System.out.print("Enter the new item category : ");
			itemCategory = input.next();

			// Check if the newSupplierID is a duplicate (isUniqe method pass true or false)
			isDuplicate = isUniqe(itemCategory,itemCategorys);

			if (isDuplicate) {
				System.out.println("already exists. try another item category!\n");
			}

		} while (isDuplicate);
		
		itemCategorys = grow(itemCategorys);
			
		itemCategorys[itemCategorys.length - 1] = itemCategory;
			
		System.out.print("added successfully! Do you want to add another category (y/n)? ");
		String option = input.next();
					
		if(option.equals("y") || option.equals("n") || option.equals("Y") || option.equals("N")) {
			if(option.equals("y") || option.equals("Y")) {
				clearConsole();
				addNewItemCategoryPage();
						
			}else{
				clearConsole();
				stockManagePage();
			}
		}
	}
	
	public static void deleteItemCategoryPage() {
		System.out.println("\n+---------------------------------------------------------------+");
		System.out.println("|\t\t\tDELETE ITEM CATEGORY\t\t\t|");
		System.out.println("+---------------------------------------------------------------+\n");
		
		deleteItemCategory();
	}
	
	public static void deleteItemCategory() {
		System.out.print("Enter the item category : ");
		String category = input.next();
		
		boolean bool = false;
		
		for (int i = 0; i < itemCategorys.length; i++) {
			if (category.equals(itemCategorys[i])) {
				
				itemCategorys = drop(category,itemCategorys);
				bool = true;
				
				System.out.print("Delete Successfully! Do you want to delete another category : ");
				String option= input.next();
				
				if(option.equals("y") || option.equals("n")) {
					if(option.equals("y")) {
						clearConsole();
						deleteItemCategoryPage();
						
					}else{
						clearConsole();
						manageItemCategoryPage();
					}
				}
			}
		}
		if (!bool) {
            System.out.println("Can't find item category. Try again!\n");
            deleteItemCategory();
        }
	}
	
	public static void updateItemCategoryPage() {
		System.out.println("\n+---------------------------------------------------------------+");
		System.out.println("|\t\t\tUPDATE ITEM CATEGORY\t\t\t|");
		System.out.println("+---------------------------------------------------------------+\n");
		
		updateItemCategory();
	}
	
	public static void updateItemCategory() {
		System.out.print("\nEnter item category\t: ");
        String iC = input.next();
		
		String newItemCategory;
		boolean isDuplicate = false;

		for (int i = 0; i < itemCategorys.length; i++) {
            if (iC.equals(itemCategorys[i])) {
				do {
					System.out.print("Enter the new item category : ");
					newItemCategory = input.next();

					// Check if the newSupplierID is a duplicate (isUniqe method pass true or false)
					isDuplicate = isUniqe(newItemCategory,itemCategorys);

					if (isDuplicate) {
						System.out.println("already exists. try another item category!\n");
					}

				} while (isDuplicate);
			
				itemCategorys[i] = newItemCategory;
			
				System.out.print("update successfully! Do you want to update another category (y/n)? ");
				String option = input.next();
							
				if (option.equals("y")) {
							updateItemCategory();
						} else if (option.equals("n")) {
							clearConsole();
							manageItemCategoryPage();
						}else if (option.equals("Y")) {
							updateItemCategory();
						} else if (option.equals("N")) {
							clearConsole();
							manageItemCategoryPage();
						} else {
							return;
						}
				}
		}
		if (!isDuplicate) {
					System.out.println("Can't find item category. Try again.");
					updateItemCategory();
		}
	}
	
	//--Add Items--(Q16)
	public static void addItemPage() {
		System.out.println("\n+-------------------------------------------------------+");
		System.out.println("|\t\t\tADD ITEM\t\t\t|");
		System.out.println("+-------------------------------------------------------+\n");
		
		addItem();
	}
	
	//--Grow 2D array--
	public static String[][] grow2D(String[][] item) {
		String[][] temp = new String[item.length + 1][7];

        for (int i = 0; i < item.length; i++) {
                temp[i] = item[i];
        }
        return temp;
	}
	
	public static void addItem() {

		if (itemCategorys.length > 0) {
			if (supplierID.length > 0) {
				String newItemId;
				boolean isDuplicate;
				
				do {
					System.out.print("Item Code\t: ");
					newItemId = input.next();
					
					// Check if the newSupplierID is a duplicate (isUnique method pass true or false)
					isDuplicate = unique2D(newItemId);
					
					if (isDuplicate) {
						System.out.println("already exists. try another Item Code!\n");
						addItem();
					}
					
				} while (isDuplicate);
					item = grow2D(item);
					item[item.length - 1][0] = newItemId;
					itemSuppliers();
					
				} else {
					System.out.print("OOPS! It seems that you don't have any supplier in the system.\nDo you want to add a new supplier?(Y/N) ");
					String option2 = input.next();

					if (option2.equals("y")) {
						clearConsole();
						addSupplierOption();
					} else if (option2.equals("n")) {
						clearConsole();
						manageItemCategoryPage();
					}else if (option2.equals("Y")) {
						clearConsole();
						addSupplierOption();
					} else if (option2.equals("N")) {
						clearConsole();
						manageItemCategoryPage();
					}else {
						return;
					}
			}
		} else {
			System.out.print("OOPS! It seems that you don't have any item category in the system.\nDo you want to add a new item category?(Y/N) ");
			String option = input.next();

			if (option.equals("y")) {
				clearConsole();
				addNewItemCategoryPage();
			} else if (option.equals("n")) {
				clearConsole();
				manageItemCategoryPage();
			}else if (option.equals("Y")) {
				clearConsole();
				addNewItemCategoryPage();
			} else if (option.equals("N")) {
				clearConsole();
				manageItemCategoryPage();
			} else {
				return;
			}
		}
	}
	
	public static boolean unique2D(String newItemId) {
		for (int i = 0; i < item.length; i++) {
            if (item[i][0] != null && item[i][0].equals(newItemId)) {
                return true;
            }
        }
        return false;
	}
	
	public static void itemSuppliers() {
		//supplier list
		System.out.println("\nSuppliers list :");
		System.out.printf("+------------------+------------------+------------------+%n");
        System.out.printf("| %-16s | %-16s | %-16s |%n", "#", "SUPPLIER ID", "SUPPLIER NAME");
        System.out.printf("+------------------+------------------+------------------+%n");
        
        for (int i = 0; i < supplierID.length; i++) {
            System.out.printf("| %-16s | %-16s | %-16s |%n", (i + 1), supplierID[i], supplierName[i]);
        }
        System.out.printf("+------------------+------------------+------------------+%n");
        
        System.out.print("\nEnter the Supplier Number > ");
        int num = input.nextInt();
        
        boolean con = numCheck(num,supplierID);
        
        if (con) {
			//item array copy to supplier Id and supplierName
			item[item.length - 1][1] = supplierID[num - 1];
			item[item.length - 1][2] = supplierName[num - 1];
			itemSCategory();
		}else {
			itemSuppliers();
		}
	}
	
	public static int[] growNum(int[] ar) {
		int[] temp = new int[ar.length + 1];
        
        for (int i = 0; i < ar.length; i++) {
            temp[i] = ar[i];
        }
        return temp;
    }

	public static boolean numCheck(int num,String[] ar) {
		int[] count = {};
		for (int i = 0; i < ar.length; i++) {
			count = growNum(count);
			count[i] = (i + 1);
		}
		for (int i = 0; i < count.length; i++) {
			if (count[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	public static void itemSCategory() {
		
		//item category list
		System.out.println("\nItem Categories :");
		System.out.printf("+------------------+------------------+%n");
        System.out.printf("| %-16s | %-16s |%n", "#", "Items Categories");
        System.out.printf("+------------------+------------------+%n");

        for (int i = 0; i < itemCategorys.length; i++) {
            System.out.printf("| %-16s | %-16s |%n", (i + 1), itemCategorys[i]);
        }

        System.out.println("+------------------+------------------+");

        System.out.print("\nEnter the category number > ");
        int num1 = input.nextInt();
        
        boolean con = numCheck(num1,itemCategorys);
        //item array copy to item category
        if (con) {
			item[item.length - 1][3] = itemCategorys[num1 - 1];
			other();
		}else {
			itemSCategory();
		}
	}
	
	public static void other() {
		//item wargaya
		System.out.print("\nDescription > ");
		String desc = input.next();
        item[item.length - 1][4] = desc;
        
        //item ekaka price eka
        System.out.print("Unit Price > ");
        item[item.length - 1][5] = input.next();
        
        //item kiyak thiyenoda
        System.out.print("Qty on Hand > ");
        item[item.length - 1][6] = input.next();
        
        //thawa item ekak add karanna onada nadda
        System.out.print("added succsessfully! Do you want to add another Item (y/n)? ");
        char ys = input.next().charAt(0);
        
        if (ys == 'y') {
			clearConsole();
			addItemPage();
		}else if (ys == 'n') {
			clearConsole();
			stockManagePage();
		}else if (ys == 'Y') {
			clearConsole();
			addItemPage();
		}else if (ys == 'N') {
			clearConsole();
			stockManagePage();
		}else{
			clearConsole();
			return;
		}
        
	}
	//--Get Item Supplier Wise--(Q17)
	public static void getItemsSupplierWisePage() {
		System.out.println("\n+----------------------------------------------+");
		System.out.println("|\t\tSEARCH SUPPLIER\t\t\t|");
		System.out.println("+----------------------------------------------+\n");
	
		getItemsSupplierWise();
	}
	
	public static void getItemsSupplierWise() {
		
		boolean con = false;
		
		do {
			System.out.print("Input  Supplier ID :");
			String ID = input.next();

			for (int i = 0; i < supplierID.length; i++) {
				con = (ID.equals(supplierID[i]));
				if (con) {
					System.out.println("Supplier name :" + supplierName[i]);
					System.out.println();
					    
					System.out.printf("+------------------+------------------+------------------+------------------+------------------+%n");
					System.out.printf("| %-16s | %-16s | %-16s | %-16s | %-16s |%n", "ITEM CODE", "DESCRIPTION", "UNIT PRICE","QTY ON HAND","CATEGORY");
					System.out.printf("+------------------+------------------+------------------+------------------+------------------+%n");

					for (int j = 0; j <item.length; j++){
						if(item[j][1].equals(ID)){
							System.out.printf("| %-16s | %-16s | %-16s | %-16s | %-16s |%n",item[j][0],item[j][4],Double.parseDouble(item[j][5]), item[j][6],item[j][3]);
							System.out.printf("+------------------+------------------+------------------+------------------+------------------+%n");
						}
					}
					System.out.print("Find successfully!.");
					break;
				}
			}
			if (!con) {
				System.out.println("Can not find Supplier Id,try again");
				getItemsSupplierWise();
			}

		} while (!con);
		
	
		System.out.print("Do you want to Search another Supplier  (y/n): ");
		String option = input.next();

		switch (option) {
			case ("y"):
				clearConsole();
				getItemsSupplierWisePage();
				break;
			case ("n"):
				clearConsole();
				stockManagePage();
				break;
			case ("Y"):
				clearConsole();
				getItemsSupplierWisePage();
				break;
			case ("N"):
				clearConsole();
				stockManagePage();
				break;
			default:
				clearConsole();
				return;
		}
	}
	//--View Item--(Q18)
	public static void viweItems() {
		
		System.out.println("\n+-------------------------------------------------------+");
		System.out.println("|\t\t\tVIWE ITEMS\t\t\t|");
		System.out.println("+-------------------------------------------------------+\n");
		
		for (int j = 0; j < itemCategorys.length; j++) {
			System.out.println(itemCategorys[j] + ": ");
			
			System.out.printf("+------------------+------------------+------------------+------------------+------------------+%n");
			System.out.printf("| %-16s | %-16s | %-16s | %-16s | %-16s |%n", "SUPPLIER", "ITEM CODE", "DESCRIPTION","UNIT PRICE","QTY ON HAND");
			System.out.printf("+------------------+------------------+------------------+------------------+------------------+%n");			

			for (int i = 0; i < item.length; i++) {
				if (itemCategorys[j].equals(item[i][3])) {
					System.out.printf("| %-16s | %-16s | %-16s | %-16s | %-16s |%n", item[i][1], item[i][0], item[i][4],Double.parseDouble(item[i][5]), item[i][6]);
				}
			}
			System.out.printf("+------------------+------------------+------------------+------------------+------------------+%n");
		}
		
		
		System.out.print("Do you want to Go Stock Manage(y/n):  ");
		String option = input.next();

		switch (option) {
			case "y":
				clearConsole();
				stockManagePage();
				break;
			case "n":
				clearConsole();
				homePage();
				break;
			case "Y":
				clearConsole();
				stockManagePage();
				break;
			case "N":
				clearConsole();
				homePage();
				break;
			default:
				return;
		}
	}
	
	//--Rank Items Per Unit Price--(Q19)
	public static void rankItemsPerUnitPrice() {
		System.out.println("\n+---------------------------------------------------------------+");
		System.out.println("|\t\t\tRANKED UNIT PRICE\t\t\t|");
		System.out.println("+---------------------------------------------------------------+\n");
		
		System.out.printf("+------------------+------------------+------------------+------------------+------------------+------------------+%n");
		System.out.printf("| %-16s | %-16s | %-16s | %-16s | %-16s | %-16s |%n", "SID", "CODE", "DESC","PIRCE","QTY","CAT");
		System.out.printf("+------------------+------------------+------------------+------------------+------------------+------------------+%n");
		
		String[][] tem = item;
		
		for (int i = 0; i < tem.length - 1; i++) {
			for(int j = 0; j < tem.length - 1; j++){
				if (Double.parseDouble(tem[j][5]) > Double.parseDouble(tem[j + 1][5])) {
					String[] temp = tem[j];
					tem[j] = tem[j + 1];
					tem[j + 1] = temp;
				}		
			}
		}
		for (int j = 0; j < tem.length; j++) {
			System.out.printf("| %-16s | %-16s | %-16s | %-16s | %-16s | %-16s |%n", tem[j][1], tem[j][0], tem[j][4],Double.parseDouble(tem[j][5]),tem[j][6],tem[j][3]);	
		}
		
		System.out.printf("+------------------+------------------+------------------+------------------+------------------+------------------+%n");
		
		System.out.print("Do you want to Go Stock Manage(y/n):  ");
		String option = input.next();

		switch (option) {
			case "y":
				clearConsole();
				stockManagePage();
				break;
			case "n":
				clearConsole();
				homePage();
				break;
			case "Y":
				clearConsole();
				stockManagePage();
				break;
			case "N":
				clearConsole();
				homePage();
				break;
			default:
				return;
		}
	}
}

