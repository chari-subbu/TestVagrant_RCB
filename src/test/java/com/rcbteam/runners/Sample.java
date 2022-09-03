package com.rcbteam.runners;

import com.rcb.customexceptons.TeamException;

public class Sample {

	public static void main(String[] args) {
		throw new TeamException("Foreign players  are more than 4 in the team, please check once.");
		

	}

}
