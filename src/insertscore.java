import java.awt.Toolkit;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Vector;
import java.util.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;

import org.json.JSONException;
import org.json.JSONObject;

public class insertscore extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/plain;charset=utf-8");
		String score = request.getParameter("score");
		String student_id=request.getParameter("id");
		try {
			String sql = "update student set score='"+score+"' where id = '"+student_id+"' ";
			DBConnection db = new DBConnection();
			boolean flag = db.execute(sql);
			db.close();
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();
			if(flag) {
				obj.put("status", "success");
			}else {
				obj.put("status", "fail");
			}
			System.out.println(obj.toString());
			out.print(obj.toString());
			out.flush();
			out.close();
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
	}

}