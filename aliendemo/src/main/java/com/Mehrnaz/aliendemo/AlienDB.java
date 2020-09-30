package com.Mehrnaz.aliendemo;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class AlienDB {
	
	Connection con = null;
	
	public AlienDB() {
		
		String url = "jdbc:postgresql://localhost:5433/alien";
		String user = "root";
		String pass = "";
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pass);
			
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
		
	public void addAlien(Alien alien) {
		String query = "Insert Into myTable(id,name,expertise) values (?,?,?)";
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setInt(1, alien.getId());
			st.setString(2, alien.getName());
			st.setString(3, alien.getExpertise());
			st.executeUpdate();
			st.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public Alien getAlien(int id) {
		
		String query = "Select * From myTable Where id="+id;
		Alien alien = new Alien();
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			if(rs.next()) {
				alien.setId(rs.getInt(1));
				alien.setName(rs.getString(2));
				alien.setExpertise(rs.getString(3));
			}
			st.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return alien;
	} 
	
	public List<Alien> getAliens(){
		List<Alien> res = new ArrayList<>();
		String query = "Select * From myTable";
		try {
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				Alien alien = new Alien();
				alien.setId(rs.getInt(1));
				alien.setName(rs.getString(2));
				alien.setExpertise(rs.getString(3));
				res.add(alien);
			}
			st.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return res;
	}
	
	public void deleteAlien(int id) {
		
		String query = "Delete from myTable where id="+id;
		try {
			
			Statement st = con.createStatement();
			st.executeUpdate(query);
			st.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public void updateAlien(Alien alien) {
		
		String query = "Update myTable set name=?,expertise=? where id=?";
		try {
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, alien.getName());
			st.setString(2, alien.getExpertise());
			st.setInt(3, alien.getId());
			st.executeUpdate();
			st.close();
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}
