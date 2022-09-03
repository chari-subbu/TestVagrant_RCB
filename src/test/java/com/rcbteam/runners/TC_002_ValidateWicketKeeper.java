package com.rcbteam.runners;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rcb.customexceptons.TeamException;

public class TC_002_ValidateWicketKeeper extends TC_000_ValidateTeamMembers{


	@Test(dependsOnMethods= {"validateTeamToHave11Members"})
	public void validateTeamAtlease1WicketKeeper()
	{
		int WicketKeepers = 0;

		for(Object teamMember : teamList)
		{
			JSONObject memberInfo = (JSONObject)teamMember;

			String roleOfPlayer = memberInfo.get("role").toString().toLowerCase().trim();

			if(roleOfPlayer.equals("wicket-keeper"))
			{
				WicketKeepers++;
			}
		}

		System.out.println("Wicket Keepers count : "+WicketKeepers);

		try
		{
			Assert.assertTrue(WicketKeepers >= 1);
		}
		catch(AssertionError error)
		{
			if(WicketKeepers < 1)
			{
				throw new TeamException("Team is filled with "+WicketKeepers+" wicket keepers, please add atleast one wicket keeper to increase the match winning chances.");
			}
		}
		catch(Exception excp)
		{
			excp.printStackTrace();
		}
	}
}
