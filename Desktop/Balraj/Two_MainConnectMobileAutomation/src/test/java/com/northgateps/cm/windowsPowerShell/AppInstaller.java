package com.northgateps.cm.windowsPowerShell;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;

import com.northgateps.cm.platform.api.Utility;
import com.northgateps.cm.platform.api.WindowsPageHelper;

public class AppInstaller {

//	public static final String envt = "";
	
//	public static final String windowsAppFolder = System.getProperty("user.dir")+"/build/"+envt+"/archive/frontend/ConM/cordova/platforms/windows/AppPackages/CordovaApp.Windows10_1.0.0.0_anycpu_debug_Test";
	
	public static final String WINAPPFOLDER = "src/main/resources/mobile_apps/windows";
	
//	public static final String importCertFile = WINAPPFOLDER+"/Windows_App.cer";
	
	public static final String appFilePath = WINAPPFOLDER+"/"+Utility.testEnvironment+".appx";

	//	public static final String[] executionPolicy = new String[] {"cmd", "/c", "powershell", "Set-ExecutionPolicy", "Unrestricted", "-Scope", "Process", "-Force"};
	
//	public static final String[] importCerts = new String[] {"cmd", "/c", "powershell", "Import-Certificate", "-FilePath", importCertFile, "-CertStoreLocation", "Cert:\\LocalMachine\\TrustedPeople"};
	
	
	
	public static final String [] installFile = new String[] {"cmd", "/c", "powershell", "Add-AppxPackage", "-Path", appFilePath};
	
	public static final String [] getPackageName = new String[] {"cmd", "/c", "powershell", "Get-AppxPackage", "com.northgate.ConnectMobile", "|", "find", "\"PackageFullName\""};

	private static String PACKAGE_NAME;

	private static final String[] getAppPackageName = new String[] {"cmd", "/c", "powershell", "Get-AppxPackage", "com.northgate.ConnectMobile", "|", "find", "\"PackageFamilyName\""};
	
	private static final String[] getAppName = new String[] {"cmd", "/c", "powershell", "Get-AppxPackage", "com.northgate.ConnectMobile", "|", "find", "\"Name\""};;
	public static void installWindowsApp() throws Exception{
//    	  runCommand(executionPolicy);
    	  
//    	  runCommand(importCerts);
			runCommand(getPackageName);
			if (PACKAGE_NAME != null)
			{	String [] uninstallApp = new String[] {"cmd", "/c", "powershell", "Remove-AppxPackage", PACKAGE_NAME};
			
				runCommand(uninstallApp);
			}
			runCommand(installFile);
			
    	  System.out.println(PACKAGE_NAME);
    	  System.out.println("INSTALLATION SUCCESSFUL");
    	  runCommand(getAppPackageName );
    	  String fullapp = PACKAGE_NAME;
    	  
    	  runCommand(getAppName );
    	  fullapp += "!"+PACKAGE_NAME;
    	  WindowsPageHelper.WINDOWS_APP_PACKAGE_NAME = fullapp;
}

	
	private static void runCommand(String[] args) throws IOException {
		
		Process proc = new ProcessBuilder(args).start();
		BufferedReader reader = new BufferedReader(new InputStreamReader(proc.getInputStream()));
		String line = null;
		while ((line = reader.readLine()) != null) {
	     	PACKAGE_NAME = line.split(": ")[1];
	     	break;
	    }
		
		
	}
	
}