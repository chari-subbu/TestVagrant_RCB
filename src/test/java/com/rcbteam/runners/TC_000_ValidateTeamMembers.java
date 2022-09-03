package com.rcbteam.runners;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rcb.helpers.JsonFileReader;

public class TC_000_ValidateTeamMembers {

	JSONObject teamInformation = null;
	JSONArray teamList = null;

	public TC_000_ValidateTeamMembers()
	{
		teamInformation = JsonFileReader.getTeamInfo();
		teamList = (JSONArray) teamInformation.get("player");
	}

	@Test
	public void validateTeamToHave11Members()
	{
		Assert.assertTrue(teamList.size() == 11);
	}
}
