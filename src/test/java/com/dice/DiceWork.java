package com.dice;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DiceWork {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		List<String> list = new ArrayList<>();
		list.add("Application Developer");
		list.add("Application Support Analyst");
		list.add("Chief Information Officer (CIO) ");
		list.add("Cloud Architect");
		list.add("Cloud Consultant");
		list.add("Cloud Services Developer");
		list.add("Cloud Software and Network Engineer");
		list.add("Cloud System Engineer");
		list.add("Computer and Information Research Scientist");
		list.add("Computer Network Architect");
		list.add("Computer Programmer");
		list.add("Computer Systems Analyst");
		list.add("Computer Systems Manager");
		list.add("Customer Support Administrator");
		list.add("Customer Support Specialist");
		list.add("Data Quality Manager");
		list.add("Java Developer");
		list.add("Junior Software Engineer");
		list.add("NET Developer");
		list.add("Network Administrator");

		List<String> newList = new ArrayList<>();

		for (int i = 0; i < list.size(); i++) {
			String url = "https://www.dice.com";
			driver.get(url);

			driver.findElement(By.id("search-field-keyword")).clear();
			  driver.findElement(By.id("search-field-keyword")).sendKeys(list.get(i));

			String zipCode = "02111";
			 driver.findElement(By.id("search-field-location")).clear();
			  driver.findElement(By.id("search-field-location")).sendKeys(zipCode);

			  driver.findElement(By.id("findTechJobs")).click();

			String count = driver.findElement(By.id("posiCountId")).getText();
			newList.add(list.get(i) + "-" + count.replaceAll(",", ""));
		}

		driver.close();
		System.out.println("TEST COMPLeTED- " + LocalDateTime.now());
		System.out.println( newList );

	}

}
