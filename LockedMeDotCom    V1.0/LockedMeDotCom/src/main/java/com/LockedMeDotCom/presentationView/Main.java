/**
 * 
 */
package com.LockedMeDotCom.presentationView;

import java.util.Scanner;

import com.LockedMeDotCom.bussinessObject.LockedMeBOInterface;
import com.LockedMeDotCom.bussinessObject.implimentations.LockedMeBoImpl;

/**
 * @author kiran
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("\t\t\t\tWelcome to LockedMe.com V1.0");
		System.out.println();

		System.out.print("ProjectName" + " " + ":" + "   " + "LOCKEDME.COM\t\t\t");
		System.out.println("\t\tAuthorName" + "  " + ":" + "   " + "Kiran Kumar C");
		System.out.println();
		System.out.println("****File Available in the Current Directory****");

		LockedMeBOInterface lockedMeBOI = new LockedMeBoImpl();

		try {
			lockedMeBOI.getAllFileNames();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println();
		Scanner scan = new Scanner(System.in);

		int choice = 0;

		System.out.println("Main Manu operations");
		System.out.println("*********************");
		do {
			System.out.println("1. Add a file to the existing directory\r\n");
			System.out.println("2. Get File by providing the FileName\r\n");
			System.out.println("3. Get All File with their created timestamp\r\n");
			System.out.println("4. Update the File by Entering fileName and Contents of file\r\n");
			System.out.println("5. Delete the file by fileName\r\n");
			System.out.println("6. exite context\r\n");
			System.out.println("Enter your choice");

			try {

				choice = Integer.parseInt(scan.nextLine());

			} catch (NumberFormatException e) {

			}

			switch (choice) {

			case 1:
				System.out.println(
						"***Enter the File Name to create new file(FileName Should Contain Atleast 3 character):***");

				try {

					lockedMeBOI.addUserFile(scan.nextLine());

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 2:
				System.out.println("***Get file by providing Currect File Name:***");
				try {
					lockedMeBOI.getFileByName(scan.nextLine()+".txt");
					
					System.out.println();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
				break;
			default:
				System.out.println("****File Available in the Current Directory****");
				try {
					lockedMeBOI.getAllFileNames();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("Entered choice is invalid. Choice should be between 1 to 6");
				break;
			}

			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} while (choice != 5);
		scan.close();
		
	}

}
