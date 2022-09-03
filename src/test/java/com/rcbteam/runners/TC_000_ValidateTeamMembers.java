package com.rcbteam.runners;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rcb.helpers.JsonFileReader;

public class TC_000_ValidateTeamMembers {

	JSONObject teamInformation = null;

	public TC_000_ValidateTeamMembers()
	{
		teamInformation = JsonFileReader.getTeamInfo();
	}

	@Test
	public void validateTeamToHave11Members()
	{
		JSONObject teamInformation = JsonFileReader.getTeamInfo();
		JSONArray teamList = (JSONArray) teamInformation.get("player");

		Assert.assertTrue(teamList.size()==11);
	}
}
