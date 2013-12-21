package com.epam.mentoring.core;

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
	
//	get one value specified by indexes
	public String loadData(int startRowIndex, int startColumnIndex);
	
//	get one value specified by index and column name
	public String loadData(int startRowIndex, String columnName);

}
