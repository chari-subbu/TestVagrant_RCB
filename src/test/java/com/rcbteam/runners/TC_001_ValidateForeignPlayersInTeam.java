package com.rcbteam.runners;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.rcb.customexceptons.TeamException;

public class TC_001_ValidateForeignPlayersInTeam extends TC_000_ValidateTeamMembers{


	@Test(dependsOnMethods= {"validateTeamToHave11Members"})
	public void validateTeamToHaveOnly4Foreigners()
	{
		int foreignPlayers = 0;

		for(Object teamMember : teamList)
		{
			JSONObject memberInfo = (JSONObject)teamMember;

			String CountryOfPlayer = memberInfo.get("country").toString().toLowerCase().trim();

			if(!CountryOfPlayer.equals("india"))
			{
				foreignPlayers++;
			}
		}

		System.out.println("Foreign Players count : "+foreignPlayers);

		try
		{
			Assert.assertTrue(foreignPlayers == 4);
		}
		catch(AssertionError error)
		{
			if(foreignPlayers > 4)
			{
				int removePlayers = foreignPlayers-4;
				throw new TeamException("Team is filled with "+foreignPlayers+" Foreign players, please remove "+removePlayers +" foreign players to match with 4 foreigns");
			}
			else
			{
				int addPlayers = 4-foreignPlayers;
				throw new TeamException("Team is filled with "+foreignPlayers+" Foreign players, please add "+addPlayers +" foreign players to match with 4 foreigns");
			}
		}
		catch(Exception excp)
		{
			excp.printStackTrace();
		}

	}

}
