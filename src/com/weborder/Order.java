package com.weborder;

import java.util.Random;
import java.util.UUID;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Order {
	public static void main(String[] args) throws InterruptedException{

		System.setProperty("webdriver.chrome.driver", 
		"C:\\Users\\Masha\\Documents\\Selenuim Dependencies\\drivers\\chromedriver.exe");
		
//1. Open browser
		WebDriver driver=new ChromeDriver();
		Thread.sleep(2000);
		
//2.Go to url http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx
		driver.navigate().to("http://secure.smartbearsoftware.com/samples/TestComplete12/WebOrders/Login.aspx");
		Thread.sleep(1000);
		
//3. Login using username Tester and password test
		driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
		Thread.sleep(1000);
		driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
		Thread.sleep(1000);
		driver.findElement(By.name("ctl00$MainContent$login_button")).click();
		Thread.sleep(1000);
		
//4. Click on Order link
		driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/Process.aspx");
		Thread.sleep(1000);

//5. Enter a random quantity between 1 and 100
		final String randomNumber = randomNumber();
		
		WebElement box = driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity"));
		box.sendKeys(Keys.BACK_SPACE);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtQuantity")).sendKeys(randomNumber);
		
//6. Enter Customer Name: John <middle_name> Smith. 
//Instead of <middle_name> your code should enter a random string every time.
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("John ");
		final String randomMiddleName = randomMiddleName();
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys(randomMiddleName);
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$txtName")).sendKeys("   Smith ");
		
		
		
//7. Enter street: 123 Any st
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox2")).sendKeys("123 Any st");

//8. Enter City: AnyTown
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox3")).sendKeys("AnyTown");
		
//9. Enter State: Virginia
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox4")).sendKeys("Virginia");
		
//10. Enter a random 5 digit number to the zip code field
		final String randomZipCode = randomZipCode();
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox5")).sendKeys(randomZipCode);
		
//11. Select any card type. Every time your code should select a different type.
//12. Enter any card number		
		
		Random random = new Random();
		int max = 3;
		int min = 1;
		int num = random.nextInt(max - min + 1) + min;
		
		final String randomCardNumber = randomCardNumber();
		final String randomCardNumberMaster=randomCardNumberMaster();
		final String randomCardNumberAmericanExpress=randomCardNumberAmericanExpress();
		
		if(num == 1){
			WebElement radio1=driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0"));
			radio1.click();
			
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(randomCardNumber);
		}else if(num==2){
			WebElement radio2=driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_1"));
			radio2.click();
			
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(randomCardNumberMaster);
		}else {
			WebElement radio3=driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_2"));
			radio3.click();
			
			driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(randomCardNumberAmericanExpress);
		}

//13. Enter any valid expiration date
		driver.findElement(By.name("ctl00$MainContent$fmwOrder$TextBox1")).sendKeys("12/22");
		Thread.sleep(3000);
		
//14. Click on Process
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_InsertButton")).click();
		
		
		

	}  

	private static String randomNumber() {
		Random r = new Random();
		int randomNum = r.nextInt(100)+1;
        return "" + randomNum;
    }

	//This method generates random string
	private static String randomMiddleName() {
        String letters = "abcdefghijlkmnopqrstuvwyz";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        while (sb.length() < 5) { // length of the random string.
            int index = (int) (rnd.nextFloat() * letters.length());
            sb.append(letters.charAt(index));
        }
        String result = sb.toString();
       
        return result.substring(0, 1).toUpperCase()+result.substring(1);

    }
	
	private static String randomZipCode() {
		Random r = new Random();
		int randomNum = r.nextInt(100000)+10000;
        return "" + randomNum;
    }
	
	private static String randomCardNumber() {
		String letters = "1234567890";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        while (sb.length() <= 14) { // length of the random string.
            int index = (int) (rnd.nextFloat() * letters.length());
            sb.append(letters.charAt(index));
        }
        String result = sb.toString();
       
        return "4"+result;
	}
	
	private static String randomCardNumberMaster() {
		String letters = "123456789";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        while (sb.length() <= 14) { // length of the random string.
            int index = (int) (rnd.nextFloat() * letters.length());
            sb.append(letters.charAt(index));
        }
        String result = sb.toString();
       
        return "5"+result;
        
	}
	
	private static String randomCardNumberAmericanExpress() {
		String letters = "123456789";
        StringBuilder sb = new StringBuilder();
        Random rnd = new Random();
        while (sb.length() <= 15) { // length of the random string.
            int index = (int) (rnd.nextFloat() * letters.length());
            sb.append(letters.charAt(index));
        }
        String result = sb.toString();
       
        return "3"+result;
	}
	

}
	 


