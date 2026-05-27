package com.test;

import static org.testng.Assert.assertEquals;

import java.io.File;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.core.BaseTest;
import com.core.SpreedSheetData;
import com.page.DetailPage;
import com.page.MainPage;

public class SearchCountryTest extends BaseTest{
	
	private DetailPage detailPage;
	private MainPage mainPage;
	
	@BeforeTest
	public void setUp() {
		mainPage = new MainPage();
	}
	
	@Test(dataProvider = "countriesList")
	public void testSearchCountry(String searchContry, String expectedCountry ) {
		mainPage.open("https://en.wikipedia.org/");
		
		detailPage = mainPage.searchCountry(searchContry);
		
		assertEquals(detailPage.getTextTitle(), expectedCountry);		
	}
	
	@DataProvider(name="countriesList")
	public Object[][] dataProviderContriesList() {
		return new Object[][] {
			{ "Argentina", "Argentina"},
			{ "Brasil", "Brazil"},
			{ "India", "India" }, 
			{ "Italy", "Italy" },
			{ "Paraguay", "Paraguay"},
			{ "Germany", "Germany"}
		};
	}
	
	@DataProvider(name="countriesExcel")
	public Object[][] dataProviderCountriesExcel(){
		return SpreedSheetData.readExcelData(
				"Paises", 
				"src" + File.separator+ "test" + File.separator + "resources" + File.separator + "paises.xls"
				,"Dados");
	}
	
	@Test(dataProvider = "countriesExcel")
	public void testSearchCountryExcel(String searchContry, String expectedCountry ) {
		mainPage.open("https://en.wikipedia.org/");
		
		detailPage = mainPage.searchCountry(searchContry);
		
		assertEquals(detailPage.getTextTitle(), expectedCountry);		
	}

}
