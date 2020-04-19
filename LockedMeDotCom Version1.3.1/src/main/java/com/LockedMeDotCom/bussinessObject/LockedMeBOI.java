/**
 * 
 */
package com.LockedMeDotCom.bussinessObject;

import java.io.File;
import java.io.IOException;

/**
 * @author kiran
 *
 */
public interface LockedMeBOI {
	public File addUserFile(String files) throws IOException;

	public String getFileByName(String fileNeme) throws IOException;

	public void updateFile(String string, String fileContents) throws IOException;

	public void getAllFileNames() throws IOException;

	public void deleteUserFile(String fileName) throws IOException;

}
