package com.epam.mentoring.dataprovider;

public interface IDataProvider {
	
//	Data structure that is stored in the data source
//	index|login|password|verifName
//	  0  |log  |pass    |name
//	  1  |log  |pass    |mane
//	  2  |log  |pass    |name
	
//	All data that stored in data source 
	public String[][] loadData();
	
//	one exact line of the data(e.g. ->login, password, verifName) 
	public String[] loadData(int startRowIndex);
	
}