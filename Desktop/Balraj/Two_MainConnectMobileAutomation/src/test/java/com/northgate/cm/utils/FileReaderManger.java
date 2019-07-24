package com.northgate.cm.utils;

//Writing Extent report

public class FileReaderManger {
	private static FileReaderManger fileReaderManger = new FileReaderManger();
	private static ConfigFileReader configFileReader;
	
	private FileReaderManger() {
		
	}
	
	public static FileReaderManger getInstance() {
		return fileReaderManger;
	}
	public static ConfigFileReader getConfigReader() {
		return (configFileReader == null)? new ConfigFileReader():configFileReader;
	}
}
