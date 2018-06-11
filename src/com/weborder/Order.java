package com.weborder;

import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/filiz/Documents/selenium dependencies/drivers/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(" http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		driver.findElement(By.linkText("Order")).click();
		//driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Process.aspx");
		Random rd=new Random();
		int num=rd.nextInt(100-1)+1;
		String nums=""+num;
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(nums);
		//char[] middle= {'A','J','K','L','Z'};
		
		Random r = new Random();
		//int Result = r.nextInt(90-65) + 65;
		String Result = ""+(char)(r.nextInt(90-65) + 65);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John "+Result+" Smith");
		//Customer name
//				int r = (int) (Math.random()*4);
//				String list =new String [] {"Bob", "Alisa", "Michelle", "Juan", "Bill"}[r];
//				driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John "+list+" Smith");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("Austin");
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("TX");
		int zip = r.nextInt(100000-10000) + 10000;
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(""+zip);
		int cardType = rd.nextInt(3);
		if(cardType==0) {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
		}else if(cardType==1) {
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1")).click();
		}else{
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2")).click();			
		}
		String cardNumber;
		if(cardType==0) {
			cardNumber="4";
			for(int i=1; i<16; i++)
				cardNumber+=rd.nextInt(3);
		}
		else if(cardType==1) {
			cardNumber="5";
			for(int i=1; i<16; i++)
				cardNumber+=rd.nextInt(3);
		}else {
			cardNumber="3";
			for(int i=1; i<15; i++)
				cardNumber+=rd.nextInt(3);
		}
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox6")).sendKeys(cardNumber);
		int mm=rd.nextInt(12-1)+1;
		String m="";
		if(mm<10)
			m="0"+mm;
		else
			m=""+mm;
		int yy=rd.nextInt(88-18)+18;
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys(m+"/"+yy);
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		  String Expected = "New order has been successfully added.";
		    String Actual = driver.findElement(By.id("ctl00_MainContent_fmwOrder")).getText();
		    System.out.println(Actual);
		    
		    if(Actual.contains(Expected)) {
		      System.out.println("pass");
		    }else {
		      System.out.println("fail");
		      System.out.println("Expected:\t" + Expected);
		      System.out.println("Actual:\t" + Actual);
		    }

		   // Thread.sleep(7000);
		    // driver.close();
		
		
		
		
		
		
//		WebElement visa=driver.findElement(By.name("ctl00_MainContent_fmwOrder_cardList_0"));
//		visa.click();
		
		
	}

}
