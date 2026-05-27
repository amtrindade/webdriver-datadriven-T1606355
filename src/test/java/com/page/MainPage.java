package com.page;

import static com.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainPage {
	
	public MainPage open(String url) {
		getDriver().get(url);
		return this;
	}
	
	public DetailPage searchCountry(String searchContry) {
		
		WebElement tfSearch = getDriver().findElement(By.id("searchInput"));
		tfSearch.sendKeys(searchContry);
		
		WebElement btnSearch = getDriver().findElement(By.xpath("//form[@id='searchform']//button[.='Search']"));
		btnSearch.click();
		
		return new DetailPage();
	}

}
