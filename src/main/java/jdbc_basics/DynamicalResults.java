package jdbc_basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DynamicalResults {
	public static void main(String[] args) throws SQLException {
		
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/aquarium", "root", "root");
		Scanner input = new Scanner(System.in);
		
		//Getting User Input
		System.out.println("Enter ID");
		int fid = input.nextInt();
		System.out.println("Enter fish name");
		String fname = input.next();
		System.out.println("Enter fish type");
		String ftype = input.next();
		input.close();
		
		//DML
		String InsertData = "insert into fishinfo(fid, fname, ftype) values (?, ?, ?);";
		
		//Creating Statement Dynamically
		PreparedStatement preparedStatement = connection.prepareStatement(InsertData);
		
		//Setting the values, Set them according to the user data
		preparedStatement.setInt(1, fid);
		preparedStatement.setString(2, fname);
		preparedStatement.setString(3, ftype);
		
		preparedStatement.executeUpdate();
		System.out.println("Changes made successfully");
		connection.close();
		
	}
}
