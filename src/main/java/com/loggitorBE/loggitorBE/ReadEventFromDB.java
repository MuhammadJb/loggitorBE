package com.loggitorBE.loggitorBE;

import java.io.IOException;
import java.sql.Date;

import org.json.JSONArray;
import org.json.JSONException;

public class ReadEventFromDB {

	private static JSONArray jsonArr;
	private static int i=0;
	private static String baseUrl = "https://amdocstask.herokuapp.com/SeverityAppPercent/";
	
	public static void getJSONfromURL(String app, String severity, Date date) throws JSONException, IOException
	{
		System.out.println(date.toString());
		String url = baseUrl + app + "/" + severity + "/" + date;
		jsonArr = JsonReader.readJsonFromUrl(url);
		i = 0;

	}
	
	
	public static float getNext()
	{
		float p;
		String strP;
		strP = jsonArr.getJSONObject(i).getString("percentage");
		strP = strP.substring(0, strP.indexOf("%"));

		p = Float.parseFloat(strP);

		i++;
		return p;
	}
	
	public static boolean hasNext()
	{
		if(i < jsonArr.length())
			return true;
		else 
			return false;
	}
	
	
	public static void close()
	{
		i=0;
		jsonArr = null;
	}
	
	
}
