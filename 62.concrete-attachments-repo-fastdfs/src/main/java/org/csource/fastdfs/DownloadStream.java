/*
 * Copyright (c) 2017 coodex.org (jujus.shen@126.com)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *  http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package org.csource.fastdfs;

import java.io.IOException;
import java.io.OutputStream;

/**
* Download file by stream (download callback class)
* @author  zhouzezhong & Happy Fish / YuQing
* @version Version 1.11
*/
public class DownloadStream implements DownloadCallback
{
	private OutputStream out;
	private long currentBytes = 0;
	
	public DownloadStream(OutputStream out)
	{
		super();
		this.out = out;
	}

	/**
	* recv file content callback function, may be called more than once when the file downloaded
	* @param fileSize file size
	*	@param data data buff
	* @param bytes data bytes
	* @return 0 success, return none zero(errno) if fail
	*/
	public int recv(long fileSize, byte[] data, int bytes)
	{
		try
		{
			out.write(data, 0, bytes);
		}
		catch(IOException ex)
		{
			ex.printStackTrace(); 
			return -1;
		}
		
		currentBytes +=	bytes;
		if (this.currentBytes == fileSize)
		{
			this.currentBytes = 0;
		}
		
		return 0;
	}
}
