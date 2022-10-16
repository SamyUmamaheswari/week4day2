package week4day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Snapdeal {
	
	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//Go to Mens Fashion
		WebElement s = driver.findElement(By.xpath("//span[@class='catText']"));
		Actions shoes = new Actions(driver);
		shoes.moveToElement(s).perform();
		
		//Go to Sports Shoes
		
		WebElement s2 = driver.findElement(By.xpath("//span[@class='linkTest']"));
		Actions builder = new Actions(driver);
		builder.click(s2).perform();
		
		//Get the count of the sports shoes
		String text = driver.findElement(By.xpath("//span[@class='category-name category-count']")).getText();
		System.out.println(text);
		
		//Click Training shoes
		WebElement s3 = driver.findElement(By.xpath("//div[text()='Training Shoes']"));
		Actions builder2 = new Actions(driver);
		builder2.click(s3).perform();
		
		//Sort by Low to High
		driver.findElement(By.xpath("//div[@class='sort-drop clearfix']")).click();
		WebElement a = driver.findElement(By.xpath("(//li[@data-index='1'])[2]"));
		Actions b = new Actions(driver);
		b.click(a).perform();
		
		//Select the price range (900-1200)
		driver.findElement(By.xpath("//input[@value='499']")).clear();
		driver.findElement(By.xpath("//input[@value='499']")).sendKeys("900");
		driver.findElement(By.xpath("//input[@value='2057']")).clear();
		driver.findElement(By.xpath("//input[@value='2057']")).sendKeys("1200");
		driver.findElement(By.xpath("//div[contains(@class,'price-go-arrow btn')]")).click();
		
		//Mouse Hover on first resulting Training shoes
		WebElement c = driver.findElement(By.xpath("//img[@class='product-image wooble']"));
		Actions b2 = new Actions(driver);
		b2.moveToElement(c).perform();
		
		//click QuickView button
		WebElement d = driver.findElement(By.xpath("//div[contains(@class,'center quick-view-bar')]"));
		Actions c1 = new Actions(driver);
		c1.click(d).perform();
		
		//Print the cost and the discount percentage
		String text2 = driver.findElement(By.xpath("//span[text()='1,199 ']")).getText();
		System.out.println(text2);
		String text3 = driver.findElement(By.xpath("//span[text()='8% Off']")).getText();
		System.out.println(text3);
		
		//Take the snapshot of the shoes.
		File source = driver.getScreenshotAs(OutputType.FILE);
		File destination = new File("./snaps/shoes.png");
		FileUtils.copyFile(source, destination);
		
		
		

		
		
		
		
		
		
		
		
		
		
		
		
		

}
}