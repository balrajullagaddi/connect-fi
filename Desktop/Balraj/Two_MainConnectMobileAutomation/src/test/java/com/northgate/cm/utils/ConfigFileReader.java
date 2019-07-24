package com.northgate.cm.utils;

//Reading config fiile conigDEVINT2.PROPERTIES

import java.util.Properties;
import java.io.BufferedReader;
import java.io.FileReader;
public class ConfigFileReader {
	
	private Properties properties;
	private final String propertyFilePath = "src/main/resource/configs/configuration.properties";
	
	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			}catch (Exception e) {
				// TODO: handle exception logger required
			}
		}catch (Exception e) {
			// TODO: handle exception logger Required
		}
	}
	
	public String getReportConfigPath() {
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if(reportConfigPath!=null) return reportConfigPath;
		else {
			throw new RuntimeException("Report Config Path is not specified in the configuration.properties for the Key : reportConfigPath ");
		}
	}
	

}
