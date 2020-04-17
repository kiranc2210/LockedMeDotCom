/**
 * 
 */
package com.LockedMeDotCom;

import java.util.Scanner;

import com.LockedMeDotCom.bussinessObject.LockedMeBOInterface;
import com.LockedMeDotCom.bussinessObject.implimentations.LockedMeBoImpl;

/**
 * @author kiran
 *
 */
public class Main {
	LockedMeBOInterface lockedMeBOI;

	/**
	 * @param args
	 */
	public void subMian() {
		lockedMeBOI = new LockedMeBoImpl();
		System.out.println("\n\n");

		System.out.println("****File Available in the Current Directory****\n");
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
				System.out.println(
						"***Enter the File Name to create new file(FileName Should Contain Atleast 3 character):***");

				try {
					String fileName = scan.nextLine();
					if (("[a-zA-z0-9.-_]{3,}").matches(fileName)) {

						lockedMeBOI.addUserFile(fileName);
						System.out.println("*********************");
						System.out.println("\n");
					}else {
						System.out.println("File Name Should contain Atleast 3 characters ");
					}

				} catch (Exception e) {

					e.printStackTrace();
				}
				break;

			case 2:
				System.out.println("***Get file by providing specified File Name:***");
				try {

					String fileName = scan.nextLine();
					lockedMeBOI.getFileByName(fileName);
					System.out.println("*********************");
					System.out.println("\n");
					Runtime.getRuntime()
							.exec("notepad" + " " + System.getProperty("user.dir") + "/LockedMeDotCom/" + fileName);

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

				}
				break;
			case 3:
				System.out.println("****Update the Existing File with new contents*****");
				System.out.println("**Enter the FileName to update**");
				String fileName = scan.nextLine();

				System.out.println("**Enter contents to be updated**");
				String contents = scan.nextLine();
				try {
					lockedMeBOI.updateFile(fileName, contents);
				} catch (Exception e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				break;
			case 4:
				System.out.println("***Enter the file name to delete the file from directory:***");

				String filename = scan.nextLine();
				try {

					if (!lockedMeBOI.getFileByName(filename).contains("File Found is: " + filename)) {
						
						System.out.println("**Are you sure want to delete? Yes Or No**");
						if ((scan.nextLine()).equalsIgnoreCase("Yes")) {
							try {
								lockedMeBOI.deleteUserFile(filename);
								System.out.println("*********************");
								System.out.println("\n");
								new Main().subMian();

							} catch (Exception e) {

								e.printStackTrace();
							}
						} else {
							System.out.println("*********************");
							System.out.println("\n");
							new Main().subMian();
						}
					} else {
						System.out.println("File Not Found use Right File Name to delete:");
						new Main().subMian();
					}

				} catch (Exception e1) {

				}

				break;
			case 5:
				System.out.println("Exit from the Application");
				System.exit(0);
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

	public static void main(String[] args) {
		System.out.println("\t\t\t\tWelcome to LockedMe.com V1.0");
		System.out.println();

		System.out.print("ProjectName" + " " + ":" + "   " + "LOCKEDME.COM\t\t\t");
		System.out.println("\t\tAuthorName" + "  " + ":" + "   " + "Kiran Kumar C");
		System.out.println();

		Main main = new Main();
		main.subMian();

	}

}
