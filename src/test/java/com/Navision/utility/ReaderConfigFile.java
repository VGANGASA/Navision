package com.Navision.utility;

public class ReaderConfigFile {
	
public String getReportConfigPath(){
	String reportConfigPath = System.getProperty("reportConfigPath");
	if(reportConfigPath!= null) return reportConfigPath;
	else throw new RuntimeException("Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");		
}
}
