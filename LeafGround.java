package week4day2;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LeafGround {
	
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/drag.xhtml");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement x = driver.findElement(By.xpath("//p[text()='Drag to target']"));
		WebElement y = driver.findElement(By.xpath("//span[text()='Droppable Target']"));
		
		Point location = x.getLocation();
		Point location2 = y.getLocation();
		
		int a = location.getX();
	    int b = location2.getY();
	    Actions builder = new Actions(driver);
	    builder.clickAndHold(x).moveToElement(y).perform();
	    
		
		
		
		
		
		
		
		
		
	}

}
