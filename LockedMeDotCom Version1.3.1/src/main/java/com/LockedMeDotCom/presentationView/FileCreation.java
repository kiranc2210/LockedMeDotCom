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
public class FileCreation {

	@SuppressWarnings("resource")
	public static void fileCreate(LockedMeBOI lockedMeBOI,Scanner scan) {
		 scan = new Scanner(System.in);

		System.out.println("***Enter the File Name to create new file(FileName Should Contain Atleast 3 character):***");

		try {
			String fileName = scan.nextLine();
			
			if (fileName.length() > 3) {

				lockedMeBOI.addUserFile(fileName);
				System.out.println("*********************");
				System.out.println("\n");
			} else {
				System.out.println("File Name Should contain Atleast 3 characters ");
			}

		} catch (Exception e) {

			e.printStackTrace();
		} /*finally {
			scan.close();
		}*/
	}

}
