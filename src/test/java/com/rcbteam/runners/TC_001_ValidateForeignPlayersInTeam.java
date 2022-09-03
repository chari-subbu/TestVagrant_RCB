package com.rcbteam.runners;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.rcb.helpers.JsonFileReader;

public class TC_001_ValidateForeignPlayersInTeam {

	@Test
	public void validateTeamToHaveOnly4Foreigners()
	{
		SoftAssert softassert = new SoftAssert();

		JSONObject teamInformation = JsonFileReader.getTeamInfo();
		JSONArray teamList = (JSONArray) teamInformation.get("player");

		softassert.assertTrue(teamList.size()==11);

	}

}
