/**
 * 
 */
package com.LockedMeDotCom.presentationView;

import java.util.Scanner;

import com.LockedMeDotCom.bussinessObject.LockedMeBOI;

/**
 * @author kiran
 *
 */
public class FileDelete {
	@SuppressWarnings("resource")
	public static void deleteFile(LockedMeBOI lockedMeBOI,Scanner scan) {
		 scan = new Scanner(System.in);
		System.out.println("***Enter the file name to delete the file from directory:***");

		String filename = scan.nextLine();
		try {

			if (lockedMeBOI.getFileByName(filename).equals(filename)) {

				System.out.println("**Are you sure want to delete? Yes Or No**");
				if ((scan.nextLine()).equalsIgnoreCase("Yes")) {
					try {
						lockedMeBOI.deleteUserFile(filename);
						System.out.println("*********************");
						System.out.println("\n");

					} catch (Exception e) {

						e.printStackTrace();
					}
				} else {
					System.out.println("*********************");
					System.out.println("\n");

				}
			} else {
				System.out.println("Use Right File Name to delete:");

			}

		} catch (Exception e1) {

		}
		
		/*finally {
			scan.close();
		}	*/
	}

}
