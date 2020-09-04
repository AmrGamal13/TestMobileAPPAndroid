package com.TestMobileAPPAndroid.TestMobileAPPAndroid;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestMobileAPP_Package_Activity {
	static AndroidDriver <MobileElement> driver;

	//String OsType = "IOS";
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		String OsType = "Android";
		DesiredCapabilities caps  = new DesiredCapabilities();
		if (OsType.equalsIgnoreCase("Android")) {
			
		}
		
		//We use android mobile capability for getting the app package and app activity
		

		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "HUAWEI MATE 10 lite");
		caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "8.0.0");
		caps.setCapability(MobileCapabilityType.UDID, "FFY5T18116015518");
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "io.selendroid.testapp");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, "io.selendroid.testapp.HomeScreenActivity");
		//caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");
		URL url = new URL("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver <MobileElement>(url ,caps); 
		MobileElement bttn =	driver.findElement(By.id("io.selendroid.testapp:id/buttonStartWebview"));
		bttn.click();
		Thread.sleep(3000);
		//driver.pressKey(new KeyEvent(AndroidKey.BACK));
		
		driver.findElement(MobileBy.xpath("//*[@text='Send me your name!']")).click();
		Thread.sleep(3000);

				
		//MobileElement text=	driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"my_text_fieldCD\"]"));
		//text.click();
	    //text.sendKeys("Adel");
		//driver.pressKey(new KeyEvent(AndroidKey.A));
		//driver.pressKey(new KeyEvent(AndroidKey.D));
		//driver.pressKey(new KeyEvent(AndroidKey.E));
		//driver.pressKey(new KeyEvent(AndroidKey.L));
		
		MobileElement entertext = driver.findElement(MobileBy.className("android.widget.EditText"));
		entertext.click();
		entertext.clear();
		entertext.sendKeys("Adel");
		
		

		
	System.out.println("Done");
		
		



		

		driver.quit();
	}

}
