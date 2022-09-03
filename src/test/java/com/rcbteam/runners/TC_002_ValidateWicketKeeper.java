package com.rcbteam.runners;

import org.json.simple.JSONArray;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TC_002_ValidateWicketKeeper extends TC_000_ValidateTeamMembers{

	
	@Test(dependsOnMethods= {"validateTeamToHave11Members"})
	public void validateTeamAtlease1WicketKeeper()
	{
		SoftAssert softassert = new SoftAssert();
		
		JSONArray teamList = (JSONArray) teamInformation.get("player");

		softassert.assertTrue(teamList.size()==11);
		softassert.assertAll();

	}
}
