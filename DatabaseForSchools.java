package Week1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseForSchools {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		//step 1 - update the pom.xml file
		//step 2 - put the password and update the connection 
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hwdb0415?serverTimezone=UTC","root", "YourPasswordHere!!!"); 
		Statement st = con.createStatement();
		//CREATING TABLES - after creating the tables first time comment the code
		boolean s1 = st.execute("Create table student(sid numeric(10), sname varchar(50), sex varchar(10), age numeric(3), year numeric(4), gpa decimal(4), primary key(sid))");
		boolean s2 = st.execute("Create table dept(dname varchar(50), numphds numeric(6), primary key(dname))");
		boolean s3 = st.execute("Create table prof(pname varchar(50), dname varchar(50), primary key(pname), foreign key(dname) references dept(dname))");
		boolean s4 = st.execute("Create table course(dname varchar(50), cno numeric(10), cname varchar(50), primary key(cno), foreign key(dname) references dept(dname))");
		boolean s5 = st.execute("Create table major(dname varchar(50), sid numeric(10), foreign key(dname) references dept(dname), foreign key(sid) references student(sid))");
		boolean s6 = st.execute("Create table section(dname varchar(50), cno numeric(10), sectno numeric(10), pname varchar(50), primary key(sectno), foreign key(dname) references dept(dname), foreign key(cno) references course(cno), foreign key(pname) references prof(pname)) ");
		boolean s7 = st.execute("Create table enroll(sid numeric(10), dname varchar(50), cno numeric(10), sectno numeric(10), grade decimal(4), foreign key(sid) references student(sid), foreign key(dname) references dept(dname), foreign key(cno) references course(cno), foreign key(sectno) references section(sectno)) ");
		//INSERT RECORDS - after inserting records comment the code
		boolean s11 = st.execute("insert into student values(1001, 'George', 'm', 22, 2017, 3.21)");
		boolean s12 = st.execute("insert into student values(1002, 'John', 'm', 23, 2017, 3.03)");
		boolean s13 = st.execute("insert into student values(1003, 'David', 'm', 17, 2017, 2.72)");
		boolean s14 = st.execute("insert into student values(1004, 'Mike', 'm', 18, 2018, 0.94)");
		boolean s15 = st.execute("insert into student values(1005, 'Maria', 'f', 18, 2018, 3.73)");
		boolean s16 = st.execute("insert into student values(1006, 'Ioana', 'm', 24, 2018, 3.6)");
		boolean s17 = st.execute("insert into student values(1007, 'Alexandru', 'm', 19, 2018, 3.96)");
		boolean s18 = st.execute("insert into student values(1008, 'Mario', 'm', 20, 2018, 3.87)");
		boolean s19 = st.execute("insert into student values(1009, 'Dominic', 'm', 46, 2018, 2.82)");
		boolean s20 = st.execute("insert into student values(1010, 'Cristina', 'f', 29, 2019, 2.76)");
		boolean s21 = st.execute("insert into student values(1011, 'Lorea', 'f', 34, 2019, 3.54)");
		boolean s22 = st.execute("insert into student values(1012, 'Megan', 'f', 22, 2019, 0.89)");
		boolean s23 = st.execute("insert into student values(1013, 'Andrei', 'm', 21, 2019, 3.32)");
		boolean s24 = st.execute("insert into student values(1014, 'Andy', 'm', 28, 2019, 3.24)");
		boolean s25 = st.execute("insert into dept values('Science', 80)");
		boolean s26 = st.execute("insert into dept values('Math', 60)");
		boolean s27 = st.execute("insert into dept values('Arts', 40)");
		boolean s28 = st.execute("insert into prof values('Jose', 'Math')");
		boolean s29 = st.execute("insert into prof values('Alfonso', 'Math')");
		boolean s30 = st.execute("insert into prof values('Akas', 'Science')");
		boolean s31 = st.execute("insert into prof values('Sohan', 'Science')");
		boolean s32 = st.execute("insert into prof values('Diana', 'Arts')");
		boolean s33 = st.execute("insert into course values('Math', 101, 'Mathematics')");
		boolean s34 = st.execute("insert into course values('Math', 102, 'Geometry')");
		boolean s35 = st.execute("insert into course values('Science', 103, 'Computer Science')");
		boolean s36 = st.execute("insert into course values('Science', 104, 'Civil Engineering')");
		boolean s37 = st.execute("insert into major values('Arts', 1012)");
		boolean s38 = st.execute("insert into major values('Arts', 1013)");
		boolean s39 = st.execute("insert into major values('Arts', 1014)");
		boolean s40 = st.execute("insert into major values('Math', 1001)");
		boolean s41 = st.execute("insert into major values('Math', 1002)");
		boolean s42 = st.execute("insert into major values('Math', 1003)");
		boolean s43 = st.execute("insert into major values('Science', 1004)");
		boolean s44 = st.execute("insert into major values('Science', 1005)");
		boolean s45 = st.execute("insert into major values('Science', 1006)");
		boolean s46 = st.execute("insert into major values('Science', 1007)");
		boolean s47 = st.execute("insert into major values('Science', 1008)");
		boolean s48 = st.execute("insert into major values('Science', 1009)");
		boolean s49 = st.execute("insert into major values('Science', 1010)");
		boolean s50 = st.execute("insert into major values('Science', 1011)");
		boolean s51 = st.execute("insert into section values('Math', 101, 1011, 'Jose')");
		boolean s52 = st.execute("insert into section values('Math', 102, 1021, 'Alfonso')");
		boolean s53 = st.execute("insert into section values('Science', 103, 1031, 'Akas')");
		boolean s54 = st.execute("insert into section values('Science', 104, 1041, 'Sohan')");
		boolean s55 = st.execute("insert into section values('Arts', 105, 1051, 'Diana')");
		boolean s56 = st.execute("insert into enroll values(1001, 'Arts', 105, 1051, 3.3)");
		boolean s57 = st.execute("insert into enroll values(1001, 'Science', 103, 1031, 2.8)");
		boolean s58 = st.execute("insert into enroll values(1007, 'Arts', 105, 1051, 4)");
		boolean s59 = st.execute("insert into enroll values(1003, 'Arts', 105, 1051, 3.3)");
		boolean s60 = st.execute("insert into enroll values(1006, 'Arts', 105, 1051, 3.8)");
		boolean s61 = st.execute("insert into enroll values(1009, 'Arts', 105, 1051, 3.7)");
		boolean s62 = st.execute("insert into enroll values(1007, 'Science', 103, 1031, 3.8)");
		boolean s63 = st.execute("insert into enroll values(1002, 'Science', 103, 1031, 2.8)");
		boolean s64 = st.execute("insert into enroll values(1003, 'Science', 103, 1031, 2.9)");
		boolean s65 = st.execute("insert into enroll values(1004, 'Science', 103, 1031, 2.7)");
		boolean s66 = st.execute("insert into enroll values(1005, 'Science', 103, 1031, 3.7)");
		boolean s67 = st.execute("insert into enroll values(1006, 'Science', 103, 1031, 3.3)");
		boolean s68 = st.execute("insert into enroll values(1008, 'Science', 103, 1031, 2.8)");
		boolean s69 = st.execute("insert into enroll values(1001, 'Science', 104, 1041, 2.6)");
		boolean s70 = st.execute("insert into enroll values(1002, 'Science', 104, 1041, 3.6)");
		boolean s80 = st.execute("insert into enroll values(1003, 'Science', 104, 1041, 2.9)");
		boolean s81 = st.execute("insert into enroll values(1004, 'Science', 104, 1041, 2.7)");
		boolean s82 = st.execute("insert into enroll values(1001, 'Math', 101, 1011, 2.9)");
		boolean s83 = st.execute("insert into enroll values(1002, 'Math', 101, 1011, 2.6)");
		boolean s84 = st.execute("insert into enroll values(1003, 'Math', 101, 1011, 3.4)");
		boolean s85 = st.execute("insert into enroll values(1004, 'Math', 101, 1011, 2.2)");
		boolean s86 = st.execute("insert into enroll values(1005, 'Math', 101, 1011, 0.9)");
		boolean s89 = st.execute("insert into enroll values(1006, 'Math', 101, 1011, 1.7)");
		boolean s90 = st.execute("insert into enroll values(1007, 'Math', 101, 1011, 3.7)");
		boolean s91 = st.execute("insert into enroll values(1008, 'Math', 102, 1021, 2.9)");
		boolean s92 = st.execute("insert into enroll values(1001, 'Math', 102, 1021, 3.1)");
		boolean s93 = st.execute("insert into enroll values(1009, 'Math', 102, 1021, 2.1)");
		boolean s94 = st.execute("insert into enroll values(1010, 'Math', 102, 1021, 3.3)");
		boolean s95 = st.execute("insert into enroll values(1011, 'Math', 102, 1021, 2.7)");
		//QUEERING THE DATABASE
		System.out.println("1. Name of professors who work in departaments that have fewer than 50 PhD students: ");
		ResultSet rs = st.executeQuery("select pname from prof where dname in (select dname from dept where numphds < 50)");
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
		System.out.println("2. The name of the students with the lowest gpa: ");
		rs = st.executeQuery("select sname from student where gpa = (select min(gpa) from student)");
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
		System.out.println("3. For each Computer Science class, print the class number, section number and the average gpa of the students enroled: ");
//		rs = st.executeQuery("select enroll.cno, enroll.sectno, avg.student(gpa) from enroll inner join student on enroll.sid = student.sid where cno = 103");
//		while (rs.next()) {
//			System.out.println(rs.getInt(1)+" "+rs.getInt(2)+" "+rs.getInt(3));
//		}
		System.out.println("4. The section of the classes with more than six students enrolled: ");
		rs = st.executeQuery("select sectno  from enroll group by sectno having count(sectno) > 6");
		while (rs.next()) {
			System.out.println(rs.getInt(1));
		}
		System.out.println("5. The name and sid of the students enrolled in the most classes: ");
		rs = st.executeQuery("select student.sname, student.sid from student, enroll where student.sid = enroll.sid and enroll.cno =(select cno from enroll group by cno order by count(*) DESC limit 1)");
		int m = 0;
		while (rs.next() && m < 1) {
			System.out.println(rs.getString(1)+" "+rs.getInt(2));
			m++;
		}
		System.out.println("6. The names of departaments that have at least one major undrer 18 years");
		rs = st.executeQuery("select dname from enroll where sid in (select sid from student where age < 18)");
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
		System.out.println("7. The names of the students who are taking a Geometry class: ");
		rs = st.executeQuery("select sname from student where sid in (select sid from enroll where cno = 102)");
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
		System.out.println("8. For those departments that have no major taking a College Geometry course print the department name and the number of PhD students in the department.");
		rs = st.executeQuery("select dept.dname, dept.numphds from dept left join course on dept.dname = course.dname where course.cname = 'Geometry'");
		while (rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2));
		}
		System.out.println("9. Print the names of students who are taking both a Computer Sciences course and a Mathematics course.");
		rs = st.executeQuery("select sname from student where sid in (select sid from enroll where cno = 103 and (101 or 102))");
		while (rs.next()) {
			System.out.println(rs.getString(1));
		}
		System.out.println("10. Print the age difference between the oldest and the youngest Computer sciences major.");
		rs = st.executeQuery("select (select age from student where age = (select max(age) from student)) - (select age from student where age = (select min(age) from student)) from student");
		int i = 0;
		while (rs.next() && i < 1) {
			System.out.println((rs).getInt(1));
			i++;
		}
		System.out.println("11. For each department that has one or more majors with a GPA under 2.0, print the name of the department and the average GPA of its majors.");
		rs = st.executeQuery("select enroll.dname, avg(student.gpa) from student inner join enroll on student.sid = enroll.sid where enroll.dname in (select enroll.dname from student inner join enroll on student.sid = enroll.sid where student.gpa < 2.0) group by enroll.dname"); 
		while (rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getInt(2));
		}
		System.out.println("12. Print the ids, names and GPAs of the students who are currently taking all the Civil Engineering courses.");
		rs = st.executeQuery("select sid, sname, gpa from student where sid in (select sid from enroll where cno = 104)");
		while (rs.next()) {
			System.out.println(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(3));
		}
		
		rs.close();
		st.close();
		con.close();
	}
}
