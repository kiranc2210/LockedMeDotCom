/**
 * 
 */
package com.LockedMeDotCom.dataAccessObject;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author kiran
 *
 */
public interface LockedMeDAO {

	public File addUserFile(String files) throws IOException;

	public String getFileByName(String fileNeme) throws IOException;

	public List<File> getAllFileNames() throws IOException;

	public void updateFile(String fileName, String fileContents) throws IOException;
	
	public File deleteUserFile(String fileName) throws IOException;

}
