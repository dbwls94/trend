package speech;

import jxl.*;
import jxl.Sheet; 
import jxl.Workbook; 
import jxl.read.biff.BiffException; 

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.Exceldb;

@WebServlet("/stt/emotion")
public class EmotionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	int id;
	static String mresult = null;
	static double prototypicality;
	static double familiarity;
	static double vitalization;
	static double pleasant;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException, FileNotFoundException {

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		request.setCharacterEncoding("UTF-8");

		// String[] mresult = request.getParameterValues("mresult");
		// String[] quantity = request.getParameterValues("bookonum");
		// System.out.println("quantity"+quantity.length);

		try {

			///////////////////////// ���� ����//////////////////////////////
			Workbook myWorkbook = Workbook.getWorkbook(new File("C:\\Users\\wlsgo\\Desktop\\trend\\final\\db2.xls")); // ������
			// ����
			Sheet mySheet = myWorkbook.getSheet(0); // ��Ʈ�� �Է� ����

			//////////////////////////////////////////////////////////////

			ServletContext sc = this.getServletContext();

			Class.forName(sc.getInitParameter("driver"));
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());

			conn = DriverManager.getConnection(
					"jdbc:mysql://localhost/resultdb?useUnicode=true&characterEncoding=UTF-8", // JDBC
																								// //
																								// URL
					"sttresult", // DBMS ����� ���̵�
					"sttresult"); // DBMS ����� ��ȣ
			stmt = conn.createStatement();

			rs = stmt.executeQuery("SELECT id,MRESULT FROM MORPHRESULT");
			response.setContentType("text/html; charset=UTF-8");

			ArrayList<Exceldb> emotions = new ArrayList<Exceldb>();

			while (rs.next()) {
				emotions.add(new Exceldb().setid(rs.getInt("id")).setmresult(rs.getString("mresult")));

				for (int no = 0; no < 434; no++) { // ���� ���� ��ŭ ������
					for (int i = 0; i < 5; i++) { // ���� ���� ��ŭ ������
						Cell myCell = mySheet.getCell(i, no); // ���� ��� ���� ������
																// ������
						if (i == 0)
							mresult = defaultString(myCell.getContents());
						if (i == 1)
							prototypicality = defaultDouble(myCell.getContents());
						if (i == 2)
							familiarity = defaultDouble(myCell.getContents());
						if (i == 3)
							vitalization = defaultDouble(myCell.getContents());
						if (i == 4)
							pleasant = defaultDouble(myCell.getContents());
						
						if(mresult.contains(rs.getString("mresult"))) { //���������� ���ԵǾ� ������
							//emotions.add(new Exceldb().setprototypicality(prototypicality).setfamiliarity(familiarity)
								//.setvitalization(vitalization).setpleasant(pleasant));
							System.out.println("����");
							// stmt.executeUpdate("INSERT INTO MORPHRESULT(id,prototypicality,familiarity,vitalization,pleasant) VALUES ("+rs.getInt("id")+","+prototypicality+","+familiarity+","+vitalization+","+pleasant+")");
							// stmt = null;
						} else { //���ԵǾ����� ������
							
							//emotions.add(new Exceldb().setprototypicality(prototypicality).setfamiliarity(familiarity)
								//	.setvitalization(vitalization).setpleasant(pleasant));
							// stmt.executeUpdate("INSERT INTO MORPHRESULT(id,prototypicality,familiarity,vitalization,pleasant) VALUES ("+rs.getInt("id")+",0,0,0,0)");
							// stmt = null;
							System.out.println("����x");
						}
						// getContents()�޼ҵ忡 ����

						// Quick and dirty function to return the contents of
						// this cell
						// as a string. �̶�� API�� ���� �ִ�����.
					}
				}
				//System.out.println(emotions);
			}

			request.setAttribute("emotions", emotions);

			response.setContentType("text/html; charset=UTF-8");
			// RequestDispatcher rd =
			// request.getRequestDispatcher("/bookstore/Bookorder.jsp");
			// rd.include(request, response);

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("error", e);
			RequestDispatcher rd = request.getRequestDispatcher("/Error.jsp");
			rd.forward(request, response);
		}
	}

	static public String defaultString(String str) {
		if (str != null && str.length() > 0) {
		} else {
			str = " ";
		}
		return str;
	}

	static public double defaultDouble(String str) {
		if (str != null && str.length() > 0) {
		} else {
			str = "";
		}
		return Double.parseDouble(str);
	}
}