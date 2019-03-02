package com.pragim.dao;

import java.util.List;

import com.pragim.model.Players;
import com.pragim.model.Teams;

public interface CrickInfoDao {
	
	
	
	public List<Players> getPlayersInfo(String teamId);
	
	public List<Teams> getTeamsInfo();
	public String deleteTeam(String teamId);
	public String addTeam(Teams obj);
	public Teams getTeamDataById(String teamId);
	public String updateTeam(Teams obj);
	
	

}
