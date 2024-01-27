package jdbc_basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReadTableDynamically {

	public static void main(String[] args) throws SQLException{
		
		String url = "jdbc:mysql://localhost:3306/aquarium";
		String username = "root";
		String password = "root";
		
		Connection connection = DriverManager.getConnection(url, username, password);
		
		String statement = "select * from fishinfo";
		
		PreparedStatement preparedStatement = connection.prepareStatement(statement);
		
		ResultSet resultSet = preparedStatement.executeQuery();
		
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2) + " " + resultSet.getString(3));
		}
	}
}
