package com.northgateps.cm.threads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmulatorThread extends Thread {
	static String location_of_SDK = "/home/rave/Android/Sdk"; //location of Android SDk in UBUNTU

	public final static String  systemOSname = System.getProperty("os.name");
	static Process process;
	static BufferedReader reader;
	public static void setLocationOfSDK() {
		try {
			if (systemOSname.startsWith("Windows")) {
				String command = "cmd.exe /c echo %android_home%";
				process = Runtime.getRuntime().exec(command);
				reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				EmulatorThread.location_of_SDK = reader.readLine();
			}
			else {
				//code required for getting the location of SDk in UBUNTU
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void run() {
		String line = "";
		String emulatorName = null;
		
		String [] listAVDcommmand;
		String [] selectAVDcommand;
		try {
				
				// command builder for knowing current AVDs
				if (systemOSname.startsWith("Windows")) {
					listAVDcommmand = new String [] {"cmd.exe", "/c", location_of_SDK+"\\emulator\\emulator","-list-avds"};
				}
				else {
				listAVDcommmand = new String[] { "/bin/bash", "-c",	location_of_SDK + "/emulator/emulator","-list-avds" };
				}
				
				//run command
				process = new ProcessBuilder(listAVDcommmand).start();
				reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

				while ((line = reader.readLine()) != null) {
					emulatorName = line;
				}
				reader.close();
				
				// command builder for launching current AVD
				if (systemOSname.startsWith("Windows")) {
					selectAVDcommand = new String [] {"cmd.exe", "/c",location_of_SDK+"\\emulator\\emulator","@"+emulatorName};
				}
				else {
					selectAVDcommand = new String[] { "/bin/bash", "-c",location_of_SDK + "/emulator/emulator","@"+emulatorName };
				}
				
				//run command
				process = new ProcessBuilder(selectAVDcommand).start();
				reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				
				while ((line = reader.readLine()) != null) {
				}
				System.out.println("Emulator started");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void close() {
		String command = location_of_SDK + "/platform-tools/adb -s " + AppiumThread.DeviceID + " emu kill";

		try {
			Process process = Runtime.getRuntime().exec(command);

			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				System.out.println(line);
			}

			reader.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}


}
