package com.TestMobileAPPAndroid.TestMobileAPPAndroid;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestMobileApp {

	//installing APK file on the real movile device (if we have the apk file with us)
	static AppiumDriver<MobileElement> driver;
	public static void main(String[] args) throws MalformedURLException {
		//location of the apk file
		File app = new File("/Users/adelmostafa/Documents/TestMobileAPPAndroid/App/selendroid-test-app-0.17.0.apk");
		DesiredCapabilities caps  = new DesiredCapabilities();

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "HUAWEI MATE 10 lite");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
		caps.setCapability(MobileCapabilityType.UDID, "FFY5T18116015518");
		caps.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AppiumDriver<MobileElement>(url ,caps); 



	}

}
