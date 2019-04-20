package assignment2_2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class EnrolmentTrackerDB {
	
	final static int classFee = 600; //the fee for one class
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
			//Create database
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/db0419?serverTimezone=UTC","root", "PASWORD");
			Statement st = (Statement) con.createStatement();
			//Create tables
			boolean s1 = st.execute("Create table student(sid numeric(5), sname varchar(50), year numeric(4), primary key(sid))");
			boolean s2 = st.execute("Create table enroll(sid numeric(5), sname varchar(50), cname varchar(50))");
					
			//Declare variable
			Scanner reader = new Scanner(System.in);
			int schoolarYear = 0, sid =0;
			String studentName = null, className = null, expression = null;
			int answer = 7;
			
			while (answer != 0) {
				System.out.println("Please enter your option: \n\t 1 - to enroll students; \n\t 2 - to get the balance for a student; \n\t 0 - to quit.");
				answer = reader.nextInt();
	
				if (answer == 1) {
					answer = 7;
					int nrOfstud = 0;
					System.out.println("How many students do you want to add ?");
					nrOfstud = reader.nextInt();
					for (int i = 0; i < nrOfstud; i++) {
					System.out.println("Please enter the name of the student: ");
					studentName = reader.next();
					System.out.println("Please enter the scholar year");
					schoolarYear = reader.nextInt();
					Random rand = new Random(); //generate a random nr
					int ran = rand.nextInt((9998 - 1000) + 1) + 1000;
					sid = schoolarYear*10000 + ran; //generate sid
					//adding to db
					boolean s9 = st.execute("insert into student values('"+sid+"', "+"'"+studentName+"', "+"'"+schoolarYear+"')");			
					answer = 7;
						while (answer!= 0) {
							System.out.println("Chose the classes: \n\t 1 - History 101; \n\t 2 - Mathematics 101; \n\t 3 - English 101; \n\t 4 - Chemistry 101; \n\t 5 - Computer Science 101; \n\t 0 - to quit.");
							answer = reader.nextInt();
							if (answer == 1) addToDatabase("History 101", sid, studentName, st);
							if (answer == 2) addToDatabase("Mathematics 101", sid, studentName, st);
							if (answer == 3) addToDatabase("English 101", sid, studentName, st);
							if (answer == 4) addToDatabase("Chemistry 101", sid, studentName, st);
							if (answer == 5) addToDatabase("Computer Science 101", sid, studentName, st);
						}	
					}	
				}
				if (answer == 2) {
					System.out.println("Enter the name of the student");
					studentName = reader.next();					
					displayStudentInfo (studentName, st);
				}
			}
			st.close();
			con.close();
	}
	//Method that will display the student info
	private static void displayStudentInfo (String studentName, Statement st) throws SQLException {
		String classes = "";
		int sid = 0;
		int nrC = 0;
		//Querying the db for enrolled classes
		ResultSet rs = st.executeQuery("select cname from enroll where sname = '"+studentName+"'");
		while (rs.next()) {
			classes += rs.getString(1)+", ";
		}
		//Querying the db for the number of enrolled classes
		rs = st.executeQuery("select count(cname) from enroll where sname = '"+ studentName +"'");
		while (rs.next()) {
			nrC =rs.getInt(1);
		}
		//Querying for student ID
		rs = st.executeQuery("select sid from enroll where sname = '"+studentName+"'");
		while (rs.next()) {
			sid = rs.getInt(1);
		}	
		System.out.println(studentName+" with the sid: "+sid+", is enrolled in the following classes: "+classes+"\nThe total balance is: $"+nrC*classFee);
		rs.close();
	}
	//Method that will register a row in the enroll table from the db
	private static void addToDatabase(String className, int sid, String studentName, Statement st) throws SQLException {
		boolean s10 = st.execute("insert into enroll values('"+sid+"', "+"'"+studentName+"', "+"'"+className+"')");
		System.out.println("The student "+ studentName +" was enroled in "+className+" class.");
	}
}