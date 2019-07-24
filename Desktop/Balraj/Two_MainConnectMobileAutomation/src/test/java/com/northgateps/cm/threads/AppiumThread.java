package com.northgateps.cm.threads;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import com.northgateps.cm.platform.api.MobilePageHelper;
import com.northgateps.cm.platform.api.Utility;

public class AppiumThread extends Thread {
	private static String location_of_npm = "/usr/local/bin"; // location of Appium in Ubuntu
	private Process process;
	private BufferedReader reader;
	public String ipaddress;
	public String port;

	public AppiumThread(String ipaddress, String port) {
		super();
		this.ipaddress = ipaddress;
		this.port = port;
		MobilePageHelper.setSERVERURL("http://" + ipaddress + ":" + port + "/wd/hub");
	}

	public AppiumThread() {
	}

	public static String DeviceID;
	public static String DeviceName;

	public void run() {
		String line = "";
		String deviceInfo = "";
		String deviceInfo1 = "";
		String[] DeviceIDcommand;
		String[] runAppiumCommand;
		try {
			
			if (EmulatorThread.systemOSname.startsWith("Windows")) {
				DeviceIDcommand = new String[] { EmulatorThread.location_of_SDK + "\\platform-tools\\adb", "devices" };
			} else {
				DeviceIDcommand = new String[] { "/bin/bash", "-c",
						EmulatorThread.location_of_SDK + "/platform-tools/adb", "devices" };
			}

			process = new ProcessBuilder(DeviceIDcommand).start();
			reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
			if (Utility.mobileOS.contains("emulator")) {
				while ((line = reader.readLine()) != null) {
					deviceInfo1 = deviceInfo;
					deviceInfo = line;
				}
			} else {
				for (int i = 0; i < 2; i++) {
					deviceInfo1 = reader.readLine();
				}
			}

			System.out.println("running appium on: " + deviceInfo1);
			if (!deviceInfo1.isEmpty()) {
				DeviceID = deviceInfo1.split("\t")[0];
				DeviceName = deviceInfo1.split("\t")[1];
				reader.close();

				String[] getPackageNameCommand;
				String[] uninstallAppCommand;
				String appPackageName = "";
				
				if (EmulatorThread.systemOSname.startsWith("Windows")) {
					getPackageNameCommand = new String[] { "cmd.exe", "/c", EmulatorThread.location_of_SDK + "\\platform-tools\\adb",
							"-s", DeviceID, "shell", "pm", "list", "packages", "|", "find", "\"ConnectMobile\"" };
				} else {
					getPackageNameCommand = new String[] { "/bin/bash", "-c",
							EmulatorThread.location_of_SDK + "/platform-tools/adb", "-s", DeviceID, "shell", "pm", "list", "packages",
							"|", "grep", "ConnectMobile" };
				}
				process = new ProcessBuilder(getPackageNameCommand).start();
				reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				while ((line = reader.readLine()) != null) {
					appPackageName = line.replace("package:", "");
				}
				if (!appPackageName.isEmpty()) {
					uninstallAppCommand = new String[] { EmulatorThread.location_of_SDK + "\\platform-tools\\adb", "-s",
							DeviceID, "uninstall", appPackageName };
					process = new ProcessBuilder(uninstallAppCommand).start();
					reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
					while ((line = reader.readLine()) != null) {
						System.out.println(appPackageName + " UNINSTALL " + line);
					}
				}

				if (EmulatorThread.systemOSname.startsWith("Windows")) {
					runAppiumCommand = new String[] {"cmd.exe", "/c", location_of_npm + "\\appium.cmd", "-a", ipaddress, "-p", port,
							"-g", new File("log/AppiumLog.log").getAbsolutePath() };
				} else {
					runAppiumCommand = new String[] { "/bin/bash", "-c", location_of_npm + "/appium", "-a", ipaddress,
							"-p", port, "-g", new File("log/AppiumLog.log").getAbsolutePath() };
				}

				process = new ProcessBuilder(runAppiumCommand).start();
				reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				while ((line = reader.readLine()) != null) {
					System.out.println(line);
				}

			} else {
				System.out.println("Device is not configured");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void setLocationOfNPM() {
		if (System.getProperty("os.name").startsWith("Windows")) {
			String command = "cmd.exe /c echo %npm%";
			try {
				Process process = Runtime.getRuntime().exec(command);
				BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
				location_of_npm = reader.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			//code required for getting the location of npm in UBUNTU
		}
	}

	public void close() {
		String command = "taskkill /F /IM node.exe";

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
