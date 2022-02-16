package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dbutil.DbUtil;
import pojo.Product;

public class ProductManagentDao {
	
	public static List<Product> getAllProducts(){
		List<Product> productList = new ArrayList<>();
		
		try {
			Connection conn = DbUtil.getConnection();
			Statement stmnt = conn.createStatement();
			ResultSet rs = stmnt.executeQuery("select * from product");
			
			while(rs.next()) {
				productList.add(new Product(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4)));
			}
			DbUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return productList;
	}
	
	public static int addProduct(Product product) {
		int status = 0;
		try {
			Connection conn = DbUtil.getConnection();
			PreparedStatement stmnt = conn.prepareStatement("insert into product values(?,?,?,?)");
			stmnt.setString(1, product.getProductId());
			stmnt.setString(2, product.getProductName());
			stmnt.setString(3, product.getProductCategory());
			stmnt.setInt(4, product.getProductPrice());
			status = stmnt.executeUpdate();
			DbUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return status;
		
	}
	
	public static Product getProductById(String productId) {
		Product product = null;
		try {
			Connection conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from product where product_id = ?");
			ps.setString(1, productId);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				product = new Product(rs.getString(1),rs.getString(2),rs.getString(3),rs.getInt(4));
			}
			DbUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return product;
	}
	public static int updateProduct(Product product) {
		int status=0;
		try {
			Connection conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("update product set product_name=?, product_category=?, product_price=? where product_id=?");
			ps.setString(1, product.getProductName());
			ps.setString(2, product.getProductCategory());
			ps.setInt(3, product.getProductPrice());
			ps.setString(4, product.getProductId());
			status = ps.executeUpdate();
			DbUtil.closeConnection(conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return status;
	}

	public static int deleteProduct(String productId) {
		int status=0;
		try {
			Connection conn = DbUtil.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from product where product_id=?");
			ps.setString(1, productId);
			status = ps.executeUpdate();
			DbUtil.closeConnection(conn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
}
