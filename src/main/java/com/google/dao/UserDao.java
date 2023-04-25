package com.google.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.catalina.connector.Response;

import com.google.bean.EmployeeBean;
import com.google.bean.HRBean;
import com.google.util.DBConnection;

public class UserDao {
	
	public int CreateADMINTable()
	{
		Connection conn = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		PreparedStatement pstmt3 = null;
		
		try {
			String Query1 = "CREATE TABLE ADMIN"
					+ "( "
					+ "AdminId int primary key auto_increment,"
					+ "AdminName varchar(20) unique,"
					+ "AdminEmail varchar(20) unique,"
					+ "AdminPassword varchar(20)"
					+ ");";
			String Query2 = "CREATE TABLE HR"
					+ "("
					+ "HRId int primary key auto_increment,"
					+ "HRName varchar(20) unique,"
					+ "HREmail varchar(20) unique,"
					+ "HRPassword varchar(20)"
					+ ");";
			String Query3 = "INSERT INTO admin(AdminName, AdminEmail,AdminPassword) values('Admin', 'Admin@gmail.com', 'Admin')";
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(Query1);
			pstmt2 = conn.prepareStatement(Query2);
			pstmt3 = conn.prepareStatement(Query3);
			
			pstmt.executeUpdate();
			pstmt2.executeUpdate();
			pstmt3.executeUpdate();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return 1;
	}

	public int AdminLogin(String uname, String password) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		
//		System.out.println(rs);
		conn = DBConnection.getConnection();
		String query = "select * from admin where (AdminName = '"+uname+"' OR AdminEmail = '"+uname+"') AND AdminPassword = '"+password+"'";
//		String query = "select * from admin where (AdminName = ? OR AdminEmail = ?) AND AdminPassword = ?";
//		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(query);
//			pstmt.setString(1, uname);
//			pstmt.setString(2, uname);
//			pstmt.setString(3, password);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				return 1;
			}
			else
			{
				return 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		return 1;
	}

	public int HRLogin(String uname, String password) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		conn = DBConnection.getConnection();
//		String query = "select * from admin where (AdminName = '"+uname+"' OR AdminEmail = '"+uname+"') AND AdminPassword = '"+password+"'";
		String query = "select * from HR where (HRName = ? OR HREmail = ?) AND HRPassword = ?";
//		System.out.println(query);
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, uname);
			pstmt.setString(2, uname);
			pstmt.setString(3, password);
			rs = pstmt.executeQuery();
			if(rs.next())
			{
				return 1;
			}
			return 0;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

	public void addHR(HRBean hrbean) {
		
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String Query = "INSERT INTO HR(HRName, HREmail, HRPassword) VALUES(?,?,?)";
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, hrbean.getName());
			pstmt.setString(2, hrbean.getEmail());
			pstmt.setString(3, hrbean.getPassword());
			pstmt.executeUpdate();
//			System.out.println("Data Inserted Sucessfully !!");
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
	}

	public ArrayList<HRBean> getAllHR() {
		ArrayList<HRBean> hrs = new ArrayList<HRBean>();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = DBConnection.getConnection();
		try {
			String Query = "SELECT * FROM hr";
			pstmt = conn.prepareStatement(Query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				HRBean hr = new HRBean();
				hr.setId(rs.getInt("HRId"));
				hr.setName(rs.getString("HRName"));
				hr.setEmail(rs.getString("HREmail"));
				hr.setPassword(rs.getString("HRPassword"));
//				System.out.println("name1: " + hr.getName());
				hrs.add(hr);
			}
//			for(int i=0;i<hrs.size();i++)
//			{
////				HRBean temp = new HRBean();
//				String tempname = hrs.get(i).getName();
//				System.out.println(tempname);
//			}
//			for(HRBean hr1 : hrs)
//			{
//				String n = hr1.getName();
//				System.out.println("name: " + n);
//			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// TODO Auto-generated method stub
		return hrs;
	}
	
	

	public void deleteHR(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String Query = "DELETE FrOM hr WHERE HRId = ?";
		conn = DBConnection.getConnection();
		try {
			pstmt = conn.prepareStatement(Query);
			pstmt.setInt(1, id);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// TODO Auto-generated method stub
		
	}

	public HRBean getHRbyid(Integer id) {
		
		System.out.println("id: " + id);
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = DBConnection.getConnection();
		String Query = "SELECT * FROM hr WHERE HRId=?";
		HRBean hr = null;
		try {
			pstmt = conn.prepareStatement(Query);
			pstmt.setInt(1, id);
//			System.out.println("Query: " + Query);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				hr = new HRBean();
				hr.setId(Integer.valueOf(rs.getInt("HRId")));
//				System.out.println("RS id: " + rs.getInt("HRId"));
				hr.setName(rs.getString("HRName"));
				hr.setEmail(rs.getString("HREmail"));
				hr.setPassword(rs.getString("HRPassword"));
				return hr;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// TODO Auto-generated method stub
		return hr;
	}

	public void updateHR(HRBean hrbean) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String Query = "UPDATE HR SET HRName=?, HREmail=?, HRPassword=? WHERE HRId=?";
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, hrbean.getName());
			pstmt.setString(2, hrbean.getEmail());
			pstmt.setString(3, hrbean.getPassword());
			pstmt.setInt(4, hrbean.getId());
			pstmt.executeUpdate();
//			System.out.println("Data Updated Sucessfully !!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		// TODO Auto-generated method stub
		

		
		// TODO Auto-generated method stub
		
	}

	public int AddEmployee(EmployeeBean ebean) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String Query = "INSERT INTO employee (name, email, number, experience, resumeurl) VALUES(?,?,?,?,?)";
		String query1 = "SELECT id FROM employee WHERE email = ?";
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, ebean.getName());
			pstmt.setString(2, ebean.getEmail());
			pstmt.setInt(3, ebean.getNumber());
			pstmt.setInt(4, ebean.getExperience());
			pstmt.setString(5, ebean.getResumeurl());
			
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(query1);
			pstmt.setString(1, ebean.getEmail());
			ResultSet rs = pstmt.executeQuery();
			
			rs.next();
//			System.out.println("Data Inserted Sucessfully !!");
//			System.out.println("Returned ID = " + rs.getInt("id"));
			return rs.getInt("id");
//			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int AddLanguage(String language) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String query1 = "SELECT id FROM language WHERE name = ?";
		String Query = "INSERT INTO language (name) VALUES(?)";
		try {
			conn = DBConnection.getConnection();
			
			pstmt = conn.prepareStatement(query1);
			pstmt.setString(1, language);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt("id");
			}
			
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, language);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(query1);
			pstmt.setString(1, language);
			ResultSet rs1 = pstmt.executeQuery();
			if(rs1.next())
			{
				return rs1.getInt("id");
			}
//			System.out.println("Data Inserted Sucessfully !!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	public int AddTechnology(String technology) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String query1 = "SELECT id FROM technology WHERE name = ?";
		String Query = "INSERT INTO technology (name) VALUES(?)";
		try {
			conn = DBConnection.getConnection();
			
			pstmt = conn.prepareStatement(query1);
			pstmt.setString(1, technology);
//			System.out.println("========tech------------" + technology);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt("id");
			}
			
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, technology);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(query1);
			pstmt.setString(1, technology);
			ResultSet rs1 = pstmt.executeQuery();
			if(rs1.next())
			{
				
				return rs1.getInt("id");
			}
//			System.out.println("Data Inserted Sucessfully !!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	
	public int AddDatabase(String database) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String query1 = "SELECT id FROM dbtable WHERE name = ?";
		String Query = "INSERT INTO dbtable (name) VALUES(?)";
		try {
			conn = DBConnection.getConnection();
			
			pstmt = conn.prepareStatement(query1);
			pstmt.setString(1, database);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				return rs.getInt("id");
			}
			
			pstmt = conn.prepareStatement(Query);
			pstmt.setString(1, database);
			pstmt.executeUpdate();
			
			pstmt = conn.prepareStatement(query1);
			pstmt.setString(1, database);
			ResultSet rs1 = pstmt.executeQuery();
			if(rs1.next())
			{
				return rs1.getInt("id");
			}
//			System.out.println("Data Inserted Sucessfully !!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return 0;
	}

	
	
	public void AddEmpLanguage(int eid, int lid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String Query = "INSERT INTO emplanguage(empid, lanid) VALUES(?,?)";
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(Query);
			pstmt.setInt(1, eid);
			pstmt.setInt(2, lid);
			
			pstmt.executeUpdate();
//			System.out.println("Data inserted in EmpLanguage Sucessfully !!");
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub
		
		
	}
	public void AddEmpTechnology(int eid, int tid) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String Query = "INSERT INTO emptechnology(empid, techid) VALUES(?,?)";
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(Query);
			pstmt.setInt(1, eid);
			pstmt.setInt(2, tid);
			
			pstmt.executeUpdate();
//			System.out.println("Data inserted in EmpTech Sucessfully !!");
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub		
	}
	public void AddEmpDatabase(int eid, int did) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String Query = "INSERT INTO empdatabase(empid, dbid) VALUES(?,?)";
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(Query);
			pstmt.setInt(1, eid);
			pstmt.setInt(2, did);
			
			pstmt.executeUpdate();
//			System.out.println("Data inserted in EmpDB Sucessfully !!");
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub		
	}

	public ArrayList<EmployeeBean> getAllEmployee() {
		// TODO Auto-generated method stub
		ArrayList<EmployeeBean> employee = new ArrayList<EmployeeBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		conn = DBConnection.getConnection();
		try {
			String Query = "SELECT * FROM employee";
			pstmt = conn.prepareStatement(Query);
			ResultSet rs = pstmt.executeQuery();
			while(rs.next())
			{
				EmployeeBean emp = new EmployeeBean();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setNumber(rs.getInt("number"));
				emp.setExperience(rs.getInt("experience"));
				emp.setResumeurl(rs.getString("resumeurl"));
//				System.out.println("name1: " + hr.getName());
				employee.add(emp);
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		// TODO Auto-generated method stub
		return employee;
		
	}

	public String getEmpLanguages(int id) {
		// TODO Auto-generated method stub
		String Query = "select name from language inner join emplanguage on language.id = emplanguage.lanid where empid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(Query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			String languages = "";
			while(rs.next())
			{
				languages = languages + rs.getString("name") + ", ";
			}
			return languages.substring(0,languages.length()-2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getEmpTechnologies(int id) {
		String Query = "select name from technology inner join emptechnology on technology.id = emptechnology.techid where empid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(Query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
//			System.out.println("is rs is here: " + rs.next());
			String technologies = "";
//			System.out.println("-----------------------");
			while(rs.next())
			{
				technologies = technologies + rs.getString("name") + ", ";
				System.out.println(technologies);
			}
//			System.out.println("-----------------------");
//			System.out.println("tech are: " + technologies);
			return technologies.substring(0,technologies.length()-2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public String getEmployeeDatabases(int id) {
		String Query = "select name from dbtable inner join empdatabase on dbtable.id = empdatabase.dbid where empid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(Query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			String databases = "";
			while(rs.next())
			{
				databases = databases + rs.getString("name") + ", ";
			}
			return databases.substring(0,databases.length()-2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<EmployeeBean> SearchEmployee(String name, String[] lanarr, String[] techarr, String[] dbarr) {
		// TODO Auto-generated method stub
		ArrayList<EmployeeBean> emplist = new ArrayList<EmployeeBean>();
		Connection conn = null;
		PreparedStatement pstmt = null;
		String Query = "select distinct employee.id as eid, employee.name as ename, email, number, experience, resumeurl  from employee \r\n"
				+ "inner join emplanguage on employee.id = emplanguage.empid\r\n"
				+ "inner join language on emplanguage.lanid = language.id\r\n"
				+ "inner join emptechnology on employee.id = emptechnology.empid\r\n"
				+ "inner join technology on technology.id = emptechnology.techid\r\n"
				+ "inner join empdatabase on empdatabase.empid = employee.id\r\n"
				+ "inner join dbtable on dbtable.id = empdatabase.dbid \r\n"
				+ "where employee.name like '%"+name+"%'";
		if(lanarr.length > 0) {
			Query = Query + " and ( language.name = ?";
			for(int i=1;i<lanarr.length;i++)
			{
				Query = Query + " or language.name = ? ";
			}
			Query = Query + ") ";
		}
		if(techarr.length > 0) {
			Query = Query + " and ( technology.name = ?";
			for(int i=1;i<techarr.length;i++)
			{
				Query = Query + " or technology.name = ? ";
			}
			Query = Query + ") ";
		}
		if(dbarr.length > 0) {
			Query = Query + " and ( dbtable.name = ?";
			for(int i=1;i<dbarr.length;i++)
			{
				Query = Query + " or dbtable.name = ? ";
			}
			Query = Query + ")";
		}
		System.out.println();
		System.out.println("DBArray len: " + dbarr.length);
		System.out.println("Query: " + Query);
		try {
			conn = DBConnection.getConnection();
			pstmt = conn.prepareStatement(Query);
			int index = 1;
			if(lanarr.length > 0) {
				for(int i=0;i<lanarr.length;i++)
				{
					try {
						pstmt.setString(index, lanarr[i].trim().toLowerCase());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					index++;
				}
			}
			if(techarr.length > 0) {
				for(int i=0;i<techarr.length;i++)
				{
					try {
						pstmt.setString(index, techarr[i].trim().toLowerCase());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
//					System.out.println(techarr[i]);
//					System.out.println(techarr[i].trim().toLowerCase());
					index++;
				}
			}
			if(dbarr.length > 0) {
				for(int i=0;i<dbarr.length;i++)
				{
					try {
						pstmt.setString(index, dbarr[i].trim().toLowerCase());
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					index++;
				}
			}
			ResultSet rs = pstmt.executeQuery();
//			System.out.println("------------------------");
			while(rs.next())
			{
				EmployeeBean employee = new EmployeeBean();
//				employee.name as ename, email, number, experience, resumeurl
				System.out.println(rs.getString("ename"));
				System.out.println(rs.getString("email"));
				System.out.println(rs.getInt("number"));
				System.out.println(rs.getInt("experience"));
				System.out.println(rs.getString("resumeurl"));
				employee.setId(rs.getInt("eid"));
				employee.setName(rs.getString("ename"));
				employee.setEmail(rs.getString("email"));
				employee.setNumber(rs.getInt("number"));
				employee.setExperience(rs.getInt("experience"));
				employee.setResumeurl(rs.getString("resumeurl"));
				emplist.add(employee);
			}
//			System.out.println("------------------------");
			return emplist;
		}
			catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	
	
}
