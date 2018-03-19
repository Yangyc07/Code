/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String piccode = (String)request.getSession().getAttribute("piccode");
		
		String checkcode = request.getParameter("checkcode").toLowerCase(); //get请求默认用iso8859-1格式编码，需要先转为UTF-8
		checkcode = new String(checkcode.getBytes("iso8859-1"), "UTF-8");
		
		response.setContentType("text/html;charset=UTF-8"); //设置本文格式，防止出现乱码
		PrintWriter out = response.getWriter();
		if (checkcode.equals(piccode)) {
			out.println("验证码输入正确！");
		}
		else {
			out.print("验证码输入错误！");
		}
		out.println(checkcode);
                out.println(piccode);
		out.flush();
		out.close();
	}
        
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
