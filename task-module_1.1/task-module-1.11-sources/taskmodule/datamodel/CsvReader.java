/**
 * Project: task-module
 * 
 * File: CsvReader.java
 * 
 * Author: Assaf Israel
 * Created on 26/04/2010	
 * 
 * Rights Reserved (c)
 */
package taskmodule.datamodel;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Assaf
 * 
 */
public class CsvReader {

	BufferedReader in = null;
	String[] labels;
	
	public CsvReader(File file, String encoding) throws IOException {
		openFile(file, encoding);
	}

	private void openFile(File file, String encoding) throws IOException {
		if (null == encoding) {
			encoding = System.getProperty("file.encoding");
		}

		try {
			in = new BufferedReader(new InputStreamReader(
					new FileInputStream(file)));
			
		} catch (FileNotFoundException e) {
			throw new IOException(e);
		}
	}

	public List<String> readLabels() throws IOException {

		String line = in.readLine();
		labels = line.split(",");
		return Arrays.asList(labels);
	}

	public boolean next() throws IOException {
		
		return in.ready();
	}

	public DataObject getData() throws IOException {
		
		String line = in.readLine();
		String[] values = line.split(",");
		
		assert(values.length == labels.length);	//Sanity check
		
		Map<String, String> data = new HashMap<String, String>();
		for (int i = 0; i < labels.length ; i++) {
			data.put(labels[i], values[i]);
		}
		
		return new DataObject(data);
	}
	
	public void close() throws IOException {
		if (null != in){
			in.close();
		}
	}
}
