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

		int foreignPlayersTocheck = Integer.valueOf(System.getProperty("foreignplayers"));

		try
		{
			Assert.assertTrue(foreignPlayers == foreignPlayersTocheck);
		}
		catch(AssertionError error)
		{
			if(foreignPlayers > foreignPlayersTocheck)
			{
				int removePlayers = foreignPlayers-foreignPlayersTocheck;
				throw new TeamException("Team is filled with "+foreignPlayers+" Foreign players, please remove "+removePlayers +" foreign players to equal with "+foreignPlayersTocheck+" foreigns");
			}
			else
			{
				int addPlayers = foreignPlayersTocheck-foreignPlayers;
				throw new TeamException("Team is filled with "+foreignPlayers+" Foreign players, please add "+addPlayers +" foreign players to equal with "+foreignPlayersTocheck+" foreigns");
			}
		}
		catch(Exception excp)
		{
			excp.printStackTrace();
		}

	}

}
