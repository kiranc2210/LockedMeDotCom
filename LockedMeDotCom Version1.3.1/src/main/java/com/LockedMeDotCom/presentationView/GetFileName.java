/**
 * 
 */
package com.LockedMeDotCom.presentationView;

import java.awt.Desktop;
import java.io.File;
import java.util.Scanner;

import com.LockedMeDotCom.bussinessObject.LockedMeBOI;

/**
 * @author kiran
 *
 */
public class GetFileName {
	
	@SuppressWarnings("resource")
	public static void getFileByName(LockedMeBOI lockedMeBOI,Scanner scan) {
		 scan = new Scanner(System.in);
		System.out.println("***Get file by providing specified File Name:***");
		try {
			
			
			String fileName = scan.nextLine();
			String flnm =lockedMeBOI.getFileByName(fileName);
			
			if(flnm.equals(fileName)) {
				System.out.println("***Do you want to open the file? Yes or No***");
			if ((scan.nextLine()).equalsIgnoreCase("Yes")) {
			
				if(!Desktop.isDesktopSupported()){
		            System.out.println("Desktop is not supported on opening the File");
		            return;
		        }
			 Desktop desktop = Desktop.getDesktop();
		        //let's try to open PDF file
		       File file = new File(System.getProperty("user.dir") + "/LockedMeDotCom/" +fileName);
		        if(file.exists()) desktop.open(file);
			
			}else {
				System.out.println("***Thanks Come Again***");
			}
			}else {
				System.out.println("***There is some problem in opening the File***");
			}
			System.out.println("*********************");
			System.out.println("\n");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		/*finally {
			scan.close();
		}*/
	}

}
