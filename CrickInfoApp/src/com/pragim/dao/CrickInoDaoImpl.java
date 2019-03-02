package com.pragim.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.pragim.model.Players;
import com.pragim.model.Teams;
import com.pragim.utility.ConnectionUtility;

public class CrickInoDaoImpl implements CrickInfoDao {

	@Override
	public List<Teams> getTeamsInfo() {
		
		Connection connection = ConnectionUtility.getConnectionFromOracle();
		List<Teams> teamList = null;
		try {
			
			PreparedStatement pstmt = connection.prepareStatement("select * from teams");
			ResultSet rs = pstmt.executeQuery();
			teamList = convertRsIntoList(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return teamList;
	}

	private List<Teams> convertRsIntoList(ResultSet rs) {
		
		List<Teams> list = new ArrayList<Teams>();
		try {
			while (rs.next()) {
				Teams teamObj = new Teams(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
				list.add(teamObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	private List<Players> convertRsIntoListForPlayer(ResultSet rs) {
		
		List<Players> list = new ArrayList<Players>();
		try {
			while (rs.next()) {
				Players teamObj = new Players(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getInt(4), rs.getString(5),rs.getInt(6));
				list.add(teamObj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<Players> getPlayersInfo(String teamId) {

		Connection connection = ConnectionUtility.getConnectionFromOracle();
		List<Players> playersList = null;
		try {
			
			PreparedStatement pstmt = connection.prepareStatement("select p.ply_id,p.ply_name,p.age,p.now,p.skill,p.rank from teams t inner join players p on p.tid=t.team_id where t.team_id=?");
			pstmt.setInt(1, Integer.parseInt(teamId));
			ResultSet rs = pstmt.executeQuery();
			playersList = convertRsIntoListForPlayer(rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return playersList;
	}

	@Override
	public String deleteTeam(String teamId) {
		Connection connection = ConnectionUtility.getConnectionFromOracle();
		String message = null;
		try {
			
			PreparedStatement pstmt = connection.prepareStatement("delete from teams where team_id=?");
			pstmt.setInt(1, Integer.parseInt(teamId));
			int executeUpdate = pstmt.executeUpdate();
			if(executeUpdate>0)
				message = "record deleted successfully";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return message;
		
	}

	@Override
	public String addTeam(Teams obj) {
		Connection connection = ConnectionUtility.getConnectionFromOracle();
		String message = null;
		try {
			
			PreparedStatement pstmt = connection.prepareStatement("insert into teams values(team_seq.nextval,?,?,?,?,null)");
			
			pstmt.setString(1, obj.getTeamName());
			pstmt.setInt(2, obj.getNo_of_players());
			pstmt.setString(3, obj.getCountry());
			pstmt.setInt(4, obj.getRank());
			int executeUpdate = pstmt.executeUpdate();
			if(executeUpdate>0)
				message = "record inserted successfully";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return message;
	}

	@Override
	public Teams getTeamDataById(String teamId) {

		Connection connection = ConnectionUtility.getConnectionFromOracle();
		Teams team = null;
		try {
			
			PreparedStatement pstmt = connection.prepareStatement("select * from teams where team_id=?");
			pstmt.setInt(1, Integer.parseInt(teamId));
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()){
				team = new Teams(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return team;
	}

	@Override
	public String updateTeam(Teams obj) {
		Connection connection = ConnectionUtility.getConnectionFromOracle();
		String message = null;
		try {
			
			PreparedStatement pstmt = connection.prepareStatement("update teams set team_name=?,no_of_players=?,country=?,rank=? where team_id=?");
			
			pstmt.setString(1, obj.getTeamName());
			pstmt.setInt(2, obj.getNo_of_players());
			pstmt.setString(3, obj.getCountry());
			pstmt.setInt(4, obj.getRank());
			pstmt.setInt(5, obj.getTeamId());
			int executeUpdate = pstmt.executeUpdate();
			if(executeUpdate>0)
				message = "record updated successfully";
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return message;
	}

}
