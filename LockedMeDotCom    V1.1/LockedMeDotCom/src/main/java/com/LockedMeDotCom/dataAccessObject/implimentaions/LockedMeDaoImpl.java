/**
 * 
 */
package com.LockedMeDotCom.dataAccessObject.implimentaions;

import java.io.File;

import java.util.ArrayList;

import java.util.List;

import com.LockedMeDotCom.dataAccessObject.LockedMeDaoInterface;

/**
 * @author kiran
 *
 */
public class LockedMeDaoImpl implements LockedMeDaoInterface {

	/*
	 * private static String getFileExtension(String filename) { String fileName =
	 * filename; if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") !=
	 * 0) return fileName.substring(fileName.lastIndexOf(".")+1); else return ""; }
	 */

	public File addUserFile(String userFileName) throws Exception {

		boolean success = false;

		File file = new File(System.getProperty("user.dir") + "/LockedMeDotCom/" + userFileName);

		if (file.exists()) {
			System.out.println("File already exists");
		} else {
			System.out.println("No such file exists, creating now");
			success = file.createNewFile();

			if (success) {
				System.out.println("Successfully created new file:" + userFileName);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				Runtime.getRuntime()
						.exec("notepad" + " " + System.getProperty("user.dir") + "/LockedMeDotCom/" + userFileName);

			} else {
				System.out.println("Failed to create new file:" + userFileName);
			}

		}

		return file;

	}

	public String getFileByName(String fileName) throws Exception {
		List<String> listFiles = this.getAllFileNames();
		String fi = "";
		for (int i = 0; i <= listFiles.size() - 1; i++) {
			if ((listFiles.get(i)).equals(fileName)) {
				fi = listFiles.get(i);
			}
		}
		return fi;

	}

	public List<String> getAllFileNames() throws Exception {
		List<String> fileList = new ArrayList<String>();
		File dir = new File(System.getProperty("user.dir") + "/LockedMeDotCom/");

		File[] files = dir.listFiles();
		for (File file : files) {

			fileList.add(file.getName());
		}

		return fileList;
	}

	public void updateFile(String fileName, String fileContents) throws Exception {
		
		boolean success = false;

		File file = new File(System.getProperty("user.dir") + "/LockedMeDotCom/" + fileName);

		if (file.exists()) {
			
		}
	}

	public String readContentsFromFile(String fileName) throws Exception {
		System.out.println("Feature yet to be implimented");

		return null;
	}

	public File deleteUserFile(String fileName) throws Exception {

		File file = new File(System.getProperty("user.dir") + "/LockedMeDotCom/" + fileName);

		return file;

	}

}
