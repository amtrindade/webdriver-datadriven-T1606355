package com.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.core.DriverFactory.getDriver;

public class DetailPage {
	
	public String getTextTitle() {
		
		WebElement spanTitle = getDriver().findElement(By.xpath("//h1[@id='firstHeading']//span[@class='mw-page-title-main']"));
		return spanTitle.getText();
		
	}

}
