package com.qa.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.qa.utilities.DBconfig;

public class DBconnection {

	private PreparedStatement ps;
	private Connection conn;
	private ResultSet rs;
	
		public DBconnection() throws SQLException {
			conn = DriverManager.getConnection(DBconfig.url, DBconfig.userName, DBconfig.pw);
			
			
		}
	
		public void create(String name) throws SQLException {
			String sql = "INSERT INTO customers (name) values (?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, name);
				ps.execute();
		}
		public void add (String itemName) throws SQLException {
			String sql = "INSERT INTO items (name) values (?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, itemName);
				ps.execute();
		}
		
		public void purchase (int customerId) throws SQLException {
			String sql = "INSERT INTO orders (customer_id) values (?)";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, customerId);
			ps.execute();
			
		}
		public void viewAll() throws SQLException {
			String sql = "SELECT * FROM customers";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if(!rs.next()) { 
				System.out.println("Nothing Found");
			} else {
					do {
					System.out.println(String.format("ID: %d, Name: %s, Email: %s, Address: %s")); 
			} while (rs.next());
			}
		}
	
		public void view(int id) throws SQLException {
			String sql = "SELECT customer_id FROM customers";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			
			
		}
		public void review() {
			
		}
		
		public void reviewAll() {
			
		}
		
		public void read() {
			
		}
		
		public void readAll() {
			
		}
		
		
		public void updateAccount(int uId) {
			
		}
		
		public void updateOrder() {
			
		}
		
		public void restock() {
			
		}
		public void delete(int id2) {
			
		}
		public void remove() {
			
		}
		public void cancel() {
			
		}
		
		
		
		
		public void exit () throws SQLException {
			conn.close();
		}
}
