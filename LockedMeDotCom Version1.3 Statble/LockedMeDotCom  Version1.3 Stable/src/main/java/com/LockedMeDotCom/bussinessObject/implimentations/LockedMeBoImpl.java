/**
 * 
 */
package com.LockedMeDotCom.bussinessObject.implimentations;

import java.io.File;
import java.io.IOException;

import com.LockedMeDotCom.dataAccessObject.LockedMeDAO;
import com.LockedMeDotCom.dataAccessObject.implimentaions.LockedMeDaoImpl;
import com.LockedMeDotCom.bussinessob.LockedMeBOI;

/**
 * @author kiran
 *
 */
public class LockedMeBoImpl implements LockedMeBOI {

	private LockedMeDAO lmd;

	private LockedMeDAO getLMD() {
		if (lmd == null) {
			lmd = new LockedMeDaoImpl();
		}
		return lmd;
	}

	public File addUserFile(String fileName) throws IOException {

		String userFileName = "";
		String[] filename = fileName.split(" ");
		for (String name : filename) {
			userFileName = name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
		}

		File fn = getLMD().addUserFile(userFileName);

		return fn;
	}

	public String getFileByName(String fileName) throws IOException {

		String file = "";
		String fname = getLMD().getFileByName(fileName);

		if ((fname).equals(fileName)) {
			file = fname;
			System.out.println("File Found is: " + file);

		} else {
			System.out.println(fileName + " " + "does not exist");
		}

		return file;
	}

	public void updateFile(String fileName, String fileContents) throws IOException {
		boolean updatesuccess = false;
		getLMD().updateFile(fileName, fileContents);
		updatesuccess = true;

		if (updatesuccess) {
			System.out.println("Update Success full");
			System.out.println("\n");
		} else {
			System.out.println("Update Fail");
			System.out.println("\n");
		}

	}

	public void deleteUserFile(String fileName) throws IOException {

		File file = getLMD().deleteUserFile(fileName);
		if (file.exists()) {
			file.delete();
		} else {
			System.out.println("File Does not exit in the directory");
		}

		System.out.println("File has been Deleted");

	}

	public void getAllFileNames() throws IOException {

		// java.util.List<File>
		// fileName=(getLMD().getAllFileNames()).stream().sorted().collect(Collectors.toList());
		// fileName.stream().forEach(System.out::println);
		java.util.List<File> fileName = getLMD().getAllFileNames();

		int listSize = fileName.size();
		if (listSize == 0) {
			System.out.println("Directory is Empty");

		} else {
			for (File file : fileName) {
				String name = file.getName();

				System.out.print(name + "\n");

			}

		}
		System.out.println("Totoal number of file Available in the Directory:" + listSize);

	}
}
