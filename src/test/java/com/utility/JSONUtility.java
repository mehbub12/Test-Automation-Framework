package com.utility;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojos.Config;
import com.ui.pojos.Environment;

public class JSONUtility {

	public static String readJSON(Env env){
		// TODO Auto-generated method stub
		//Gson is responsible for converting json to java objects
		Gson gson=new Gson();
		//To get the path
		File jsonFile=new File(System.getProperty("user.dir")+ "\\config\\config.json");
		//filereader is responsible for reading the file
		FileReader fileReader = null;
		try {
			//reading the json file
			fileReader = new FileReader(jsonFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Deserialize json to pojo config class
		Config config=gson.fromJson(fileReader, Config.class);
		Environment environment=config.getEnvrionments().get(env.name());
		
		return environment.getUrl();
	}

}
