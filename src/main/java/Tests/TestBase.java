package Tests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.touch.TapOptions;

public class TestBase {

	 static Random ran ;
	static AndroidDriver<MobileElement> driver;

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		runAppium();
	}


	public static void runAppium() throws MalformedURLException, InterruptedException 
	{

		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability("deviceName", "HUAWEI P30 lite");
		cap.setCapability("udid", "FFY5T18116015518");

		cap.setCapability("platformName","Android");

		cap.setCapability("platformVersion", "8.0.0");
		cap.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"io.swvl.customer");
		cap.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"io.swvl.customer.features.LaunchScreenActivity");
		cap.setCapability("noReset", "true");  

		URL url = new URL ("http://127.0.0.1:4723/wd/hub");

		driver = new AndroidDriver<MobileElement>(url ,cap); 

		System.out.println("application started ....");
//landing page
	MobileElement PhoneNumber = driver.findElement(By.id("hint"));

	PhoneNumber.click();
	Thread.sleep(5000);
		MobileElement phoneNumberTxt= driver.findElement(By.id("phone_edit_text"));

	phoneNumberTxt.sendKeys("1148494829");

		MobileElement Nextbuttn = driver.findElement(By.id("next_btn"));

		Nextbuttn.click();
//-----
		//login page
	 MobileElement passwordTxt= driver.findElement(By.id("password_edit_text"));

	passwordTxt.sendKeys("adel01148494829");

	MobileElement Nextbuttn_Password = driver.findElement(By.id("next_btn"));

       Nextbuttn_Password.click();
       
       //-----
		Thread.sleep(5000);
//select destination Page
		MobileElement Destination_bttn = driver.findElement(By.id("where_to"));

		Destination_bttn.click();
		
		MobileElement Pickup_bttn = driver.findElement(By.id("pickup_et"));

		Pickup_bttn.click();
		
		MobileElement close = driver.findElement(By.id("pickup_side_icon_iv"));
		close.click();
		
		MobileElement SelectPickUp = driver.findElement(By.xpath("//android.view.ViewGroup[@index='0']"));
		SelectPickUp.click();
		
		
		MobileElement dropoff_Searcg = driver.findElement(By.id("dropoff_et"));
		dropoff_Searcg.sendKeys("Nasr City");
		
		driver.executeScript("mobile:performEditorAction", ImmutableMap.of("action", "done"));
				
		MobileElement SelectdropOff = driver.findElement(By.xpath("//android.view.ViewGroup[@index='2']"));
		
		SelectdropOff.click();
		//------
		Thread.sleep(5000);
		
		//ChooseMyTripPage
	     List<MobileElement> days = driver.findElements(By.id("date_btn"));
	     ran = new Random();
		 int dayNo = ran.nextInt(days.size());
		 
		 MobileElement selectedDay = days.get(dayNo);
		 selectedDay.click();
		 
		 
		 List<MobileElement> rideCards = driver.findElements(By.id("ride_card_view"));
		 int rideCardNo = ran.nextInt(rideCards.size());
		 MobileElement selectedMyRide = rideCards.get(rideCardNo);
		 
		 selectedMyRide.click();
		 //Trip details page
		 MobileElement NextBttnToReservation = driver.findElement(By.id("next_btn"));
		 NextBttnToReservation.click();
		 //booking page
		 
		 MobileElement BookBtn = driver.findElement(By.id("book_btn"));
		 //BookBtn.click();
		 
		 MobileElement SuccessMessage = driver.findElement(By.id("title_tv"));
		 SuccessMessage.getText();
		 
		 
	}
}
