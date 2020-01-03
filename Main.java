package jdbc1;

import java.sql.CallableStatement;
import java.util.*;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import oracle.jdbc.driver.OracleDriver;

class OrderItem {
	int item_id;
	String item_name;
	int quantity;
	int order_id;

	public OrderItem() {
	}

	public OrderItem(int item_id, String item_name, int quantity, int order_id) {
		super();
		this.item_id = item_id;
		this.item_name = item_name;
		this.quantity = quantity;
		this.order_id = order_id;
	}
}

public class Main {

//S1: load the driver
	public static void main(String[] args) {
		Driver d = null;
		Connection conn = null;
		List<OrderItem> l;
		try {

			d = new OracleDriver();
			DriverManager.registerDriver(d);
			String username = "hr";
			String password = "hr";
			String url = "jdbc:oracle:thin:@192.168.1.105:1521:xe";
			conn = DriverManager.getConnection(url, username, password);
			conn.setAutoCommit(false);
			System.out.println("Successfully connected");

// Statement stmt=conn.createStatement();

// CallableStatement cstmt=conn.prepareCall("");
			String orderSql = "insert into orders values(?,?) ";
			String orderItemSql = "insert into order_items values(?,?,?,?)";
			PreparedStatement orderstmt = conn.prepareStatement(orderSql);
			PreparedStatement orderitemstmt = conn.prepareStatement(orderItemSql);

			orderstmt.setInt(1, 124);
			orderstmt.setDate(2, new java.sql.Date(new java.util.Date().getTime()));
			l = new ArrayList<>();
			l.add(new OrderItem(201, "Lays", 8, 124));
			l.add(new OrderItem(202, "Maza", 14, 124));
			l.add(new OrderItem(203, "Kurkure", 6, 124));

			for (OrderItem item : l) {
				orderitemstmt.setInt(1, item.item_id);
				orderitemstmt.setString(2, item.item_name);
				orderitemstmt.setInt(3, item.quantity);
				orderitemstmt.setInt(4, item.order_id);

				orderitemstmt.addBatch();
			}

			int result = orderstmt.executeUpdate();
			System.out.println(result + " - order rows updated");

			int[] batch_res = orderitemstmt.executeBatch();
			for (int i : batch_res) {
				System.out.println(i + "- order items rows updated");
			}
// throw new SQLException("Error Occured here");

			conn.commit();

			/*
			 * while(rs.next()) { System.out.print("Id:="+rs.getInt("employee_id")+" ");
			 * System.out.println("Name: "+rs.getString("first_name")+" "+rs.getString(
			 * "last_name")); }
			 */

// System.out.println("Closing");
		} catch (SQLException e) {

			try {
				System.err.println("Error occured");
				conn.rollback();
			} catch (SQLException e1) {
// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		}

		finally {
			try {
				conn.close();
			} catch (SQLException e) {
// TODO Auto-generated catch block
				System.out.println("Error in finally");
				e.printStackTrace();
			}
		}

	}
}