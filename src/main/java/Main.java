

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Main {

	public static void main(String[] args) {
		 System.setProperty("webdriver.chrome.driver",
		            "E:\\Users\\Daika\\eclipse\\project\\cecbrowser\\src\\chromedriver.exe");
	    String url = "http://facebook.com";
	    String email = Secret.email;
	    String password = Secret.password;
	    
	    WebDriver driver = new ChromeDriver(); 
	    driver.get(url);
	    driver.manage().window().maximize();
	    driver.findElement(By.id("email")).sendKeys(email);
	    driver.findElement(By.id("pass")).sendKeys(password + Keys.ENTER);
	    WebDriverWait wait = new WebDriverWait(driver, 500);

	    url = "https://www.facebook.com/groups/1784461175160264/?sorting_setting=CHRONOLOGICAL";
	    
	    driver.get(url);
	    
	    LinkedBlockingQueue<String> listPermalinks = new LinkedBlockingQueue<String>();
	    
//	    try {
//			wait.wait();
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	    
	    List<WebElement> elements =  driver.findElements(By.className("_5pcq"));
	    
	    for (Iterator iterator = elements.iterator(); iterator.hasNext();) {
			WebElement webElement = (WebElement) iterator.next();
			
			String link = webElement.getAttribute("href");
			if(link.startsWith("https://www.facebook.com/groups/cec.edu.vn/permalink/"))
			{
				listPermalinks.add(link);
			}
			
			
			
		}
	    
	    
	    while(listPermalinks.size()>0)
	    {
	    	
	    	String link = listPermalinks.poll();
	    	
	    	System.out.println(link);
	    	driver.get(link);
	    	try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
	    
	    //timestampContent
	    
	    
	}

}
