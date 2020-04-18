/**
 * 
 */
package com.LockedMeDotCom.presentationView;

import java.io.IOException;

/**
 * 
 */

import java.util.Scanner;

import com.LockedMeDotCom.bussinessObject.implimentations.LockedMeBoImpl;
import com.LockedMeDotCom.bussinessob.LockedMeBOI;

/**
 * @author kiran
 *
 */
public class Main {

	public static void main(String[] args) {
		System.out.println("\t\t\t\tWelcome to LockedMe.com V1.3");
		System.out.println();

		System.out.print("ProjectName" + " " + ":" + "   " + "LOCKEDME.COM\t\t\t");
		System.out.println("\t\tDeveloperName" + "  " + ":" + "   " + "Kiran Kumar C");
		System.out.println();

		LockedMeBOI lockedMeBOI;

	
			lockedMeBOI = new LockedMeBoImpl();
			System.out.println("\n\n");

			System.out.println("****File Available in the Current Directory****\n");
			try {
				lockedMeBOI.getAllFileNames();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println();

			Scanner scan = new Scanner(System.in);

			int choice = 0;

			System.out.println("Main Manu operations");
			System.out.println("*********************\n");
			do {
				System.out.println("1. Add a file to the existing directory with File Extension\r\n");
				System.out.println("2. Get File by providing the FileName\r\n");
				System.out.println("3. Update the File by Entering fileName and Contents of file\r\n");
				System.out.println("4. Delete the file by fileName whit Extension \r\n");
				System.out.println("5. exite context\r\n");
				System.out.println("Enter your choice");

				try {

					choice = Integer.parseInt(scan.nextLine());

				} catch (NumberFormatException e) {

				}

				
				switch (choice) {

				case 1:
					FileCreation.fileCreate(lockedMeBOI, scan);
					break;

				case 2:
					GetFileName.getFileByName(lockedMeBOI, scan);
					break;
				case 3:
					FileUpdate.updateFile(lockedMeBOI, scan);
					break;
				case 4:
					
					FileDelete.deleteFile(lockedMeBOI, scan);
					break;
				case 5:
					System.out.println("Exit from the Application");
					System.exit(0);
					break;
				default:
					
					System.out.println("Entered choice is invalid. Choice should be between 1 to 5");
					System.out.println("**********************************************************");
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
