/**
 * 
 */
package com.LockedMeDotCom.presentationView;

import java.util.Scanner;

import com.LockedMeDotCom.bussinessob.LockedMeBOI;

/**
 * @author kiran
 *
 */
public class FileUpdate {
	
	@SuppressWarnings("resource")
	public static void updateFile(LockedMeBOI lockedMeBOI, Scanner scan) {
	 scan = new Scanner(System.in);
		System.out.println("****Update the Existing File with new contents*****");
		System.out.println("**Enter the FileName to update**");
		String fileName = scan.nextLine();
		try {
			if (lockedMeBOI.getFileByName(fileName).equals(fileName)) {
				System.out.println("**Enter contents to be updated**");
				String contents = scan.nextLine();
				try {
					lockedMeBOI.updateFile(fileName, contents);
					System.out.println("\n");
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			} else {
				System.out.println("Please, Check the File Name");
				System.out.println("\n");
			}
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		/*finally {
			scan.close();
		}*/
	}

}
