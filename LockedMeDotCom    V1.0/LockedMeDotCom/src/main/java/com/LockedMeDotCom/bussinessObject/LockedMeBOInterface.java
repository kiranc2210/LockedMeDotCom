/**
 * 
 */
package com.LockedMeDotCom.bussinessObject;

import java.io.File;

/**
 * @author kiran
 *
 */
public interface LockedMeBOInterface {
	public File addUserFile(String files) throws Exception;

	public String getFileByName(String fileNeme) throws Exception;

	public void updateFile(String fileName, String fileContents) throws Exception;

	public String readContentsFromFile(String fileName) throws Exception;

	public void getAllFileNames() throws Exception;

	public void deleteUserFile(String fileName) throws Exception;

}
