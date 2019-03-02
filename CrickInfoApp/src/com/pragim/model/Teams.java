package com.pragim.model;

public class Teams {

	private int teamId;
	private String teamName;
	private int no_of_players;
	private String country;
	private int rank;

	@Override
	public String toString() {
		return "Teams [teamId=" + teamId + ", teamName=" + teamName
				+ ", no_of_players=" + no_of_players + ", country=" + country
				+ ", rank=" + rank + "]";
	}

	public int getTeamId() {
		return teamId;
	}

	public String getTeamName() {
		return teamName;
	}

	public int getNo_of_players() {
		return no_of_players;
	}

	public String getCountry() {
		return country;
	}

	public int getRank() {
		return rank;
	}

	public Teams(int teamId, String teamName, int no_of_players,
			String country, int rank) {
		super();
		this.teamId = teamId;
		this.teamName = teamName;
		this.no_of_players = no_of_players;
		this.country = country;
		this.rank = rank;
	}

}
