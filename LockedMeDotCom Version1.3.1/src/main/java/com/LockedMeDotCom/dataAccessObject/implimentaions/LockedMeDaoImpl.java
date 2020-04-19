/**
 * 
 */
package com.LockedMeDotCom.dataAccessObject.implimentaions;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;

import com.LockedMeDotCom.dataAccessObject.LockedMeDAO;

/**
 * @author kiran
 *
 */
public class LockedMeDaoImpl implements LockedMeDAO {

	/*
	 * private static String getFileExtension(String filename) { String fileName =
	 * filename; if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") !=
	 * 0) return fileName.substring(fileName.lastIndexOf(".")+1); else return ""; }
	 */

	public File addUserFile(String userFileName) throws IOException {

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

	public String getFileByName(String fileName) throws IOException {
		List<File> listFiles = this.getAllFileNames();
		String fi ="";
		for (int i = 0; i <= listFiles.size() - 1; i++) {
			if ((listFiles.get(i).getName()).equals(fileName)) {
				fi = listFiles.get(i).getName();
			}
		}
		return fi;

	}

	public List<File> getAllFileNames() throws IOException {
		List<File> fileList = new ArrayList<File>();
		File dir = new File(System.getProperty("user.dir") + "/LockedMeDotCom/");

		File[] files = dir.listFiles();
		for (File file : files) {

			fileList.add(file);
		}

		return fileList;
	}

	public void updateFile(String fileName, String fileContents) throws IOException {

		boolean success = false;

		BufferedWriter bw = null;
		FileWriter fw = null;

		try {
			File file = new File(System.getProperty("user.dir") + "/LockedMeDotCom/" + fileName);
			if (file.exists()) {
				success = true;
			} else {
				success = false;
			}
			if (success) {

				// true = append file
				fw = new FileWriter(file.getAbsoluteFile(), true);
				bw = new BufferedWriter(fw);

				bw.write(fileContents);

			}
			else {
				System.out.println("FIle Does not Found");
			}

		} catch (IOException e) {

			e.printStackTrace();

		} finally {

			try {

				if (bw != null)
					bw.close();

				if (fw != null)
					fw.close();

			} catch (IOException ex) {

				ex.printStackTrace();

			}
		}
	}

	public File deleteUserFile(String fileName) throws IOException {

		File file = new File(System.getProperty("user.dir") + "/LockedMeDotCom/" + fileName);
		
		

		return file;

	}

}
