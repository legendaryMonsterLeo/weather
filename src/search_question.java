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

import org.apache.jasper.tagplugins.jstl.core.Out;
import org.json.JSONException;
import org.json.JSONObject;

public class search_question extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		response.setContentType("text/plain;charset=utf-8");
		JSONObject object;
		try {
			String sql = "select * from question";
			String id  ="";
			String question="";
			String opta ="";
			String optb ="";
			String optc ="";
			String optd ="";
			String answer ="";
			DBConnection db = new DBConnection();
			ResultSet rs = db.executeQuery(sql);
			
			ArrayList<Question> list = new ArrayList();
			try{
			while(rs.next()){
				 id = rs.getString("question_id");
				 question = rs.getString("question");
				 opta = rs.getString("optA");
				 optb = rs.getString("optB");
				 optc = rs.getString("optC");
				 optd = rs.getString("optD");
				 answer = rs.getString("answer");
				 Question t = new Question(id, question, opta, optb, optc,optd,answer);
				 list.add(t);
			   }
			}catch (SQLException ex){
	        	  ex.printStackTrace();
	          }
			db.close();
			
			Random r = new Random();
			int j=0;
			int[] flag= new int[1000];
			int[] ques=new int[100];
			while(j<4) {
				int randnumber = r.nextInt(list.size());
				if(flag[randnumber]==0){
					ques[j++] = randnumber;
					flag[randnumber]=1;
				 }
			}
			db.close();
			Question s;
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			JSONObject obj = new JSONObject();
			JSONObject obj1 = new JSONObject();
			s = list.get(ques[0]);
			obj1.put("question", s.question);obj1.put("opta", s.opta);obj1.put("optb", s.optb);obj1.put("optc", s.optc);obj1.put("optd", s.optd);obj1.put("answer", s.answer);
			
			JSONObject obj2 = new JSONObject();
			s = list.get(ques[1]);
			obj2.put("question", s.question);obj2.put("opta", s.opta);obj2.put("optb", s.optb);obj2.put("optc", s.optc);obj2.put("optd", s.optd);obj2.put("answer", s.answer);
			
			JSONObject obj3 = new JSONObject();
			s = list.get(ques[2]);
			obj3.put("question", s.question);obj3.put("opta", s.opta);obj3.put("optb", s.optb);obj3.put("optc", s.optc);obj3.put("optd", s.optd);obj3.put("answer", s.answer);
			
			JSONObject obj4 = new JSONObject();
			s = list.get(ques[3]);
			obj4.put("question", s.question);obj4.put("opta", s.opta);obj4.put("optb", s.optb);obj4.put("optc", s.optc);obj4.put("optd", s.optd);obj4.put("answer", s.answer);
			
			obj.put("question1", obj1);
			obj.put("question2", obj2);
			obj.put("question3", obj3);
			obj.put("question4", obj4);

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