/**
 * 
 */
package com.LockedMeDotCom.dataAccessObject;

import java.io.File;

import java.util.List;

/**
 * @author kiran
 *
 */
public interface LockedMeDaoInterface {

	public File addUserFile(String files) throws Exception;

	public String getFileByName(String fileNeme) throws Exception;

	public List<String> getAllFileNames() throws Exception;

	public void updateFile(String fileName, String fileContents) throws Exception;

	public String readContentsFromFile(String fileName) throws Exception;

	public File deleteUserFile(String fileName) throws Exception;

}
