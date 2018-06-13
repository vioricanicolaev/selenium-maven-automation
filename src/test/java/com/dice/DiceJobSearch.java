package com.dice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceJobSearch {
	
	public static void main(String[] args) {
		
		  // set the properties for chromedriver
		  WebDriverManager.chromedriver().setup();
	      // open the chromeBrowser
		  WebDriver driver = new ChromeDriver();
		  // full screen 
		  driver.manage().window().fullscreen();
		  // set universal wait time in case the website is very slow
		  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		  
		  /* Steep1. 
		   * 
		   */
		  
		  String url = "https://dice.com";
		  driver.get(url);
		  
		  String actualTitle = driver.getTitle();
		  String expectedTitle = "Job Search for Technology Professionals | Dice.com";
		  
		  if(actualTitle.equals(expectedTitle)) {
			  System.out.println("Step PASS: Dice home page successfully loaded.");
		  }else {
			  System.out.println("Step FAIL: Dice home page did not load successfully.");
			  throw new RuntimeException("Step FAIL: Dice home page did not load successfully.");
		  }
		  
		  String keyword = "java developer";
		  driver.findElement(By.id("search-field-keyword")).clear();
		  driver.findElement(By.id("search-field-keyword")).sendKeys(keyword);
		  
		  String location = "22102";
		  driver.findElement(By.id("search-field-location")).clear();
		  driver.findElement(By.id("search-field-location")).sendKeys(location);
		  
		  driver.findElement(By.id("findTechJobs")).click();
		  
		  String count = driver.findElement(By.id("posiCountId")).getText();
		  System.out.println(count);
		  
		  int countResult = Integer.parseInt(count.replaceAll(",", ""));
		  
		  if(countResult > 0) {
				System.out.println( "Step PASS: Keyword : " + keyword +" search returned " +
				countResult +" results in " + location);
			}else {
				System.out.println( "Step FAIL: Keyword : " + keyword +" search returned " +
						countResult +" results in " + location);
			}
			
			driver.close();
			
			
			
			
			
			
			
			
			

	}

}
