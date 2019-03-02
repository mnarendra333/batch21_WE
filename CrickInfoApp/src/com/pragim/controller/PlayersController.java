package com.pragim.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.pragim.dao.CrickInfoDao;
import com.pragim.dao.CrickInoDaoImpl;
import com.pragim.model.Players;

/**
 * Servlet implementation class PlayersController
 */
@WebServlet("/plyersdata")
public class PlayersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlayersController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String teamId = request.getParameter("teamId");
		
		CrickInfoDao dao = new CrickInoDaoImpl();
		List<Players> playersInfo = dao.getPlayersInfo(teamId);
		request.setAttribute("playersList", playersInfo);
		
		RequestDispatcher rd = request.getRequestDispatcher("displayTeams.jsp");
		rd.forward(request, response);
		
	}

}
