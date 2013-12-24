package com.epam.mentoring.dataprovider;


public class StubDataProvider implements IDataProvider {

	public String[][] loadData() {
		String[][] data = new String[3][3];
		data[0][0]= "fortrainingepam";
		data[0][1]= "qwe123asd123zxc";
		data[0][2]= "+Sergiy";
		data[1][0]= "epammentoring";
		data[1][1]= "WSXqaz123";
		data[1][2]= "+Mentor";
		data[2][0]= "mentoringdnipro";
		data[2][1]= "123wsxQAZ";
		data[2][2]= "+Antony";
		return data;
	}

	public String[] loadData(int startRowIndex) {
		String[] data = new String[2];
		data[0]= "fortrainingepam";
		data[1]= "qwe123asd123zxc";
		data[2]= "+Sergey";
		return data;
	}

	public String loadData(int startRowIndex, int startColumnIndex) {
		String login = "fortrainingepam";
		return login;
	}

	public String loadData(int startRowIndex, String columnName) {
		String pass = "fortrainingepam";
		return pass;
	}

}
