package com.gameland.steemstone.common;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class CommFunc {

	public CommFunc(){}
	
	/**
	 * Load Properties
	 * @param path
	 * @return
	 * @throws IOException
	 */
	public Properties loadProp(String path) throws IOException, Exception{
	    InputStream inputStream = getClass().getResourceAsStream(path);
	    Properties properties = new Properties();
	    properties.load(inputStream);
	    inputStream.close();
	    return properties;
	}
}
