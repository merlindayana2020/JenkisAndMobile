package Practise.AppiumFramework;

import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.TapOptions.tapOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.remote.RemoteWebElement;
//import org.testng.Assert;
import junit.framework.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;

public class TC_01 extends Capability{
	
	AndroidDriver<AndroidElement> driver;
	
	@BeforeTest 
	public void bm() throws IOException, InterruptedException {
		Runtime.getRuntime().exec("taskkill /F /IM node.exe");
        Thread.sleep(5000);
       service = startServer();
       driver = capability(appPackage, appActivity, deviceName, chromedriverexecutable);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
	}
	
	@AfterTest
	public void am() {
		service.stop();
	}
	
	@Test (enabled=false)
	public void testcase1() {
//		//scroll and select India from drop down
//		driver.findElement(MobileBy.id("android:id/text1")).click();		
//		driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"India\"))").click();
//		
//		//Enter name
//		
//		//select gender
//		
//		//click on lets shop butto
        //i am passing data to the name field using id and sendkeys
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
        //i want to select the radio button which is female // i want to use xpath
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        // i have to work with drop down
        //i will click on the value which is by default 
        driver.findElement(By.id("android:id/text1")).click();
        //then scroll and select india
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))").click();
        //i want to verify(assert) to check the country is selected
        String country = driver.findElement(By.xpath("//*[@text='India']")).getText();
        String Expected = "India";
        Assert.assertEquals(country, Expected);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click(); 
		
	}
	
	@Test (enabled=false)
	public void testcase2() {
		
		//i want to select the radio button which is female // i want to use xpath
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        // i have to work with drop down
        //i will click on the value which is by default 
        driver.findElement(By.id("android:id/text1")).click();
        //then scroll and select india
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))").click();
        
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click(); 
        
        //to find the error popup we need to inspect using class name
        String errormsg = driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
        System.out.println(errormsg);
        String expected = "Please enter your name";
        Assert.assertEquals(errormsg, expected);
       
		
	}
	@Test (enabled=false)
	public void testcase3() throws InterruptedException {
		
        //i am passing data to the name field using id and sendkeys
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
        //i want to select the radio button which is female // i want to use xpath
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        // i have to work with drop down
        //i will click on the value which is by default 
        driver.findElement(By.id("android:id/text1")).click();
        //then scroll and select india
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))").click();
        //i want to verify(assert) to check the country is selected
        String country = driver.findElement(By.xpath("//*[@text='Austria']")).getText();
        String Expected = "Austria";
        Assert.assertEquals(country, Expected);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();		
      

        driver.findElementsByAndroidUIAutomator("new UiScrollable(new UiSelector().resourceId(\"com.androidsample.generalstore:id/rvProductList\")).scrollIntoView(textMatches(\"Jordan 6 Rings\"))");
        int count = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).size();
        System.out.println(count);
        for(int i=0;i<count;i++)
        {
        	String productName = driver.findElements(By.id("com.androidsample.generalstore:id/productName")).get(i).getText();
            if(productName.equals("Jordan 6 Rings"))
            {
                System.out.println(productName);
                driver.findElements(By.id("com.androidsample.generalstore:id/productAddCart")).get(i).click();
                break;
            }
        }
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        Thread.sleep(3000);                 
        String checkoutname = driver.findElement(By.id("com.androidsample.generalstore:id/productName")).getText();      
        Thread.sleep(3000);                 
        String expectedname = "Jordan 6 Rings";        
        Assert.assertEquals(expectedname, checkoutname);
        
		//select product and add to cart
//        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"ADD TO CART\"))");
//        driver.findElement(By.xpath("//*[@text='ADD TO CART']")).click();        	

	}
	
	@Test (enabled=false)
	public void testcase4() throws InterruptedException, IOException {
		 //startServer();
	//	service = startServer();
			//service.start();
			
		
		//i am passing data to the name field using id and sendkeys
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
        //i want to select the radio button which is female // i want to use xpath
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        // i have to work with drop down
        //i will click on the value which is by default 
        driver.findElement(By.id("android:id/text1")).click();
        //then scroll and select india
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))").click();
        //i want to verify(assert) to check the country is selected
        String country = driver.findElement(By.xpath("//*[@text='Austria']")).getText();
        String Expected = "Austria";
        Assert.assertEquals(country, Expected);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();		
        
        //List<AndroidElement> addtocart = driver.findElements(By.xpath("//*[@text='ADD TO CART']"));              
        //addtocart.forEach(x -> x.click());
        //above code is also working
        	
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        
        Thread.sleep(3000);
        String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
        amount1 = amount1.substring(1);
        double amount1value = Double.parseDouble(amount1);
        
        
        String amount2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
        amount2 = amount2.substring(1);
        double amount2value = Double.parseDouble(amount2);
        
        //Sum of the amount of first two product
        double TotalAmount = amount1value + amount2value;
        
        //Final one
        String finalamount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        finalamount = finalamount.substring(1);
        double FinalTotal = Double.parseDouble(finalamount);
        
       // Assert.assertEquals(FinalTotal, TotalAmount);
    
        //tap on the checkbox
        AndroidElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
        
        //long press on please read terms and condition
		AndroidElement terms = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
		t.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(2))).release().perform();
		
        //click on ok button on popup 
        driver.findElement(By.xpath("//*[@text='CLOSE']")).click();
        
        //click on visit to the website to complete purchase
        driver.findElement(By.xpath("//*[contains(@text,'Visit to the website to complete purchase')]")).click();
        
        Thread.sleep(10000);
        // to move from native app to web in hybride apps use context
        Set<String> contextNames = driver.getContextHandles();
        for (String contextName : contextNames) {
            System.out.println(contextName); //prints out something like NATIVE_APP \n WEBVIEW_1
        }
        
        //switch to web app
        driver.context("WEBVIEW_com.androidsample.generalstore");
        Thread.sleep(10000);
        //seach for IBM
        driver.findElement(By.xpath("//*[@name='q']")).sendKeys("IBM");
        Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@name='q']")).sendKeys(Keys.RETURN);
		Thread.sleep(5000);
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		Thread.sleep(5000);
		driver.context("NATIVE_APP");		
	       		
	}
	@Test (enabled=true)
	public void testcase5forframework() throws InterruptedException, IOException {
		 //startServer();
	//	service = startServer();
			//service.start();
			
		
		//i am passing data to the name field using id and sendkeys
        driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Niharika");
        //i want to select the radio button which is female // i want to use xpath
        driver.findElement(By.xpath("//*[@text='Female']")).click();
        // i have to work with drop down
        //i will click on the value which is by default 
        driver.findElement(By.id("android:id/text1")).click();
        //then scroll and select india
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Austria\"))").click();
        //i want to verify(assert) to check the country is selected
        String country = driver.findElement(By.xpath("//*[@text='Austria']")).getText();
        String Expected = "Austria";
        Assert.assertEquals(country, Expected);
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();		
        
        //List<AndroidElement> addtocart = driver.findElements(By.xpath("//*[@text='ADD TO CART']"));              
        //addtocart.forEach(x -> x.click());
        //above code is also working
        	
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElements(By.xpath("//*[@text='ADD TO CART']")).get(0).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/appbar_btn_cart")).click();
        
        Thread.sleep(3000);
        String amount1 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(0).getText();
        amount1 = amount1.substring(1);
        double amount1value = Double.parseDouble(amount1);
        
        
        String amount2 = driver.findElements(By.id("com.androidsample.generalstore:id/productPrice")).get(1).getText();
        amount2 = amount2.substring(1);
        double amount2value = Double.parseDouble(amount2);
        
        //Sum of the amount of first two product
        double TotalAmount = amount1value + amount2value;
        
        //Final one
        String finalamount = driver.findElement(By.id("com.androidsample.generalstore:id/totalAmountLbl")).getText();
        finalamount = finalamount.substring(1);
        double FinalTotal = Double.parseDouble(finalamount);
        
       // Assert.assertEquals(FinalTotal, TotalAmount);
    
        //tap on the checkbox
        AndroidElement checkbox = driver.findElementByClassName("android.widget.CheckBox");
		TouchAction t = new TouchAction(driver);
		t.tap(tapOptions().withElement(element(checkbox))).perform();
        
        //long press on please read terms and condition
		AndroidElement terms = driver.findElement(By.xpath("//*[@text='Please read our terms of conditions']"));
		t.longPress(longPressOptions().withElement(element(terms)).withDuration(ofSeconds(2))).release().perform();
		
        //click on ok button on popup 
        driver.findElement(By.xpath("//*[@text='CLOSE']")).click();
        
        //click on visit to the website to complete purchase
        driver.findElement(By.xpath("//*[contains(@text,'Visit to the website to complete purchase')]")).click();
        
	}

}
