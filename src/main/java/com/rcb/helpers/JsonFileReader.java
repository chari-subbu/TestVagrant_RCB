package com.rcb.helpers;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.rcb.constants.Constants;

public interface JsonFileReader {

	public static JSONObject getCredsJsonObject()
	{
		JSONParser jsonParser = new JSONParser();
		FileReader reader = null;
		try {
			reader = new FileReader(Constants.RcbTeamJsonFileLocation);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Object obj = null;
		try {
			obj = jsonParser.parse(reader);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

		JSONObject credsList = (JSONObject) obj;

		return credsList;
	}
	
}
