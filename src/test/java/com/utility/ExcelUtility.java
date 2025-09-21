package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.google.common.collect.Table.Cell;
import com.ui.pojos.User;

public class ExcelUtility {

	public static Iterator<User> ExcelReader(){
	 File excelFile=new File(System.getProperty("user.dir")+"\\TestData\\logindata.xlsx");
	 XSSFWorkbook xssfworkbook=null;
	 XSSFSheet sheet;
	 List<User> userList = null;
	 User userData;
	try {
		xssfworkbook = new XSSFWorkbook(excelFile);
		sheet=xssfworkbook.getSheet("logindata");
		 
		 Iterator<Row>rowIterator=sheet.iterator();
		 rowIterator.next();
		 userList=new ArrayList<User>();
		 
		 while(rowIterator.hasNext()) {
			 Row row=rowIterator.next();
			 org.apache.poi.ss.usermodel.Cell emailaddress=row.getCell(0);
			 org.apache.poi.ss.usermodel.Cell password=row.getCell(1);
			 userData=new User(emailaddress.toString(), password.toString());
			 userList.add(userData);
			 System.out.println(userList);
		 }
	} catch (InvalidFormatException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
		return userList.iterator();
	}

}
