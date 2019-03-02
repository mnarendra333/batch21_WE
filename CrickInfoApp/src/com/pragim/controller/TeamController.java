package com.pragim.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.pragim.dao.CrickInfoDao;
import com.pragim.dao.CrickInoDaoImpl;
import com.pragim.model.Teams;

/**
 * Servlet implementation class CrickInfoController
 */
@WebServlet("/getdata")
public class TeamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CrickInfoDao dao  =new CrickInoDaoImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TeamController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String operation = request.getParameter("click");
		String teamId=null;
		String teamName=null;
		String btnName=null;
		String country = null;
		int nop = 0;
		int rank = 0;
		if(request.getParameter("teamId")!=null)
			teamId = request.getParameter("teamId");
		if(request.getParameter("btnName")!=null)
			btnName = request.getParameter("btnName");
		if(request.getParameter("tname")!=null)
			teamName = request.getParameter("tname");
		if(request.getParameter("nop")!=null)
			nop = Integer.parseInt(request.getParameter("nop"));
		if(request.getParameter("country")!=null)
			country = request.getParameter("country");
		if(request.getParameter("rank")!=null)
			rank = Integer.parseInt(request.getParameter("rank"));
		Teams obj = null;
		if(request.getParameter("teamId")!=null)
			obj  =new Teams(Integer.parseInt(teamId), teamName, nop, country, rank);
		else
			obj  =new Teams(0, teamName, nop, country, rank);
		
		
		
		if(btnName!=null){
			
			if(btnName.equalsIgnoreCase("delete")){
				
				String deleteTeam = dao.deleteTeam(teamId);
				request.setAttribute("message", deleteTeam);
				getTeamsDataAndRedirectToUI(request,response);
			}else if(btnName.equalsIgnoreCase("add")){
				
				String deleteTeam = dao.addTeam(obj);
				request.setAttribute("message", deleteTeam);
				getTeamsDataAndRedirectToUI(request,response);
			}else if(btnName.equalsIgnoreCase("edit")){
				
				Teams team = dao.getTeamDataById(teamId);
				request.setAttribute("teamObj", team);
				RequestDispatcher rd = request.getRequestDispatcher("editTeam.jsp");
				rd.forward(request, response);
				
			}
			else if(btnName.equalsIgnoreCase("update")){
				
				String message = dao.updateTeam(obj);
				request.setAttribute("message", message);
				getTeamsDataAndRedirectToUI(request,response);
				
			}
			
		}else{
			getTeamsDataAndRedirectToUI(request,response);
		}
		
					
		
		
		
		
	}
	
	
	public void getTeamsDataAndRedirectToUI(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		List<Teams> teamsInfo = dao.getTeamsInfo();
		HttpSession session = request.getSession();
		session.setAttribute("teamlist", teamsInfo);
		
		//dispatch logic
		
		RequestDispatcher rd = request.getRequestDispatcher("displayTeams.jsp");
		rd.forward(request, response);
	}

}
