package com.epam.mentoring.dataprovider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class JsonDataProvider implements IDataProvider {

	private String jsonFilePath = ".//src/test//resources//testData.json";
	
	//reads file and appends all from the file to single string
	private static String readFileAsString(String filePath) throws IOException {	
		StringBuffer buffer = new StringBuffer();
		BufferedReader bufReader = new BufferedReader(new FileReader(filePath));
		char[] buf = new char[1024];
		int numRead = 0;
		while((numRead = bufReader.read(buf)) != -1) {
			String readData = String.valueOf(buf, 0, numRead);
			buffer.append(readData);
		}
    	bufReader.close();
    	return buffer.toString();
	}

	//takes json in String format and parses it
	private static String[] parseSingleUser(String jsonLine, int userIndex) {
	    JsonElement jelement = new JsonParser().parse(jsonLine);
	    JsonObject  jobject = jelement.getAsJsonObject();
	    JsonArray jarray = jobject.getAsJsonArray("users");
	    jobject = jarray.get(userIndex).getAsJsonObject();
	    
	    String[] singleUser = new String[3];
	    String temp;
	    
	    temp = jobject.get("login").toString();
	    singleUser[0] = temp.substring(1, temp.length() - 1);		
	    
	    temp = jobject.get("password").toString();
	    singleUser[1] = temp.substring(1, temp.length() - 1);
	    
	    temp = jobject.get("verifName").toString();
	    singleUser[2] = temp.substring(1, temp.length() - 1);
	    
	    return singleUser;
	}
	
	private static String[][] parseAllUsers(String jsonLine) {
	    JsonElement jelement = new JsonParser().parse(jsonLine);
	    JsonObject  jobject = jelement.getAsJsonObject();
	    JsonArray jarray = jobject.getAsJsonArray("users");
	    jobject = jarray.get(0).getAsJsonObject();
	    //fill array of strings with parsed from json string values
	    String[][] allUsers = new String[jarray.size()][3];			
	    for (int i = 0; i < jarray.size(); i++) {
	    	String temp;
		    
		    temp = jobject.get("login").toString();
		    allUsers[i][0] = temp.substring(1, temp.length() - 1);		
		    
		    temp = jobject.get("password").toString();
		    allUsers[i][1] = temp.substring(1, temp.length() - 1);
		    
		    temp = jobject.get("verifName").toString();
		    allUsers[i][2] = temp.substring(1, temp.length() - 1);
	    } 
	    return allUsers;
	}

	//Implemented IDataProvider method
	@Override
	public String[][] loadData() {
		
		String jsonString = null;
		try {
			jsonString = readFileAsString(jsonFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return parseAllUsers(jsonString);
	}

	//Implemented IDataProvider method
	@Override
	public String[] loadData(int startRowIndex) {
		String jsonString = null;
		try	{
			jsonString = readFileAsString(jsonFilePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return parseSingleUser(jsonString, startRowIndex);
	}
}
