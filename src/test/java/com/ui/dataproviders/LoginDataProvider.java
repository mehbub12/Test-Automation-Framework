package com.ui.dataproviders;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.annotations.DataProvider;

import com.google.gson.Gson;
import com.ui.pojos.TestData;
import com.ui.pojos.User;
import com.utility.CSVReaderUtility;
import com.utility.ExcelUtility;

public class LoginDataProvider {
	
	@DataProvider(name="LoginData")
	public Iterator<Object[]> loginDataProvider() throws FileNotFoundException {
		
		Gson gson=new Gson();
		
		File testDataFile=new File(System.getProperty("user.dir")+ "\\TestData\\logindata.json");
		
		FileReader fileReader=new FileReader(testDataFile);
		TestData data=gson.fromJson(fileReader, TestData.class);
		
		List<Object[]> dataToReturn=new ArrayList<Object[]>();
		
		for(User user:data.getData()) {
			dataToReturn.add(new Object[] {user});
		}
		return dataToReturn.iterator();
	}
	
	@DataProvider(name="LoginCSVData")
	public Iterator<User> loginCSVDataProvider() {
		return CSVReaderUtility.CSVReader("loginData.csv");
	}
	@DataProvider(name="LoginExcelData")
	public Iterator<User> loginExcelDataProvider(){
		return ExcelUtility.ExcelReader();
	}
}
