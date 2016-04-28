package com.yzx.elec.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yzx.elec.container.ServiceProvider;
import com.yzx.elec.service.IElecUserService;

/**
 * Servlet implementation class CheckLogonName
 */
public class CheckLogonName extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	private IElecUserService userService = (IElecUserService)ServiceProvider.getService(IElecUserService.SERVICE_NAME);
       
	/**
     * @see HttpServlet#HttpServlet()
     */
    public CheckLogonName() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		String logonName = request.getParameter("logonName");
//		userService = (IElecUserService)ServiceProvider.getService(IElecUserService.SERVICE_NAME);
		String result = userService.checkUserExists(logonName);
		out.write(result);
		out.flush();
		out.close();
	}

}
