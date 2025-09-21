package com.ui.listeners;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class MyRetryAnalyzer implements IRetryAnalyzer {

	private static final int MAX_RETRY=3;
	private int retry_count=1;
	
	@Override
	public boolean retry(ITestResult result) {
		if(retry_count<=MAX_RETRY) {
			retry_count++;
			return true;
		}
	
		return false;
	}
	
	

}
