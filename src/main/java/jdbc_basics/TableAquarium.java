package jdbc_basics;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TableAquarium {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		//01. Register and Load the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/aquarium";
		String username = "root";
		String password = "root";
		
		//02. Get connection
		Connection connection = DriverManager.getConnection(url, username, password);

		//03. Create Statement
		Statement statement = connection.createStatement();
		
		//Statements to create, alter, insert, update, truncate and delete tables
		
		//DDL
		String CreateTable = "create table fishes (fid integer primary key, fname varchar(30) not null)";
		String RenameTable = "rename table fishes to fishinfo";
		String AlterTableAddColumn = "alter table fishes add column(ftype varchar(10) not null);";
		String TruncateTable = "truncate table fishes";
		String DropTable = "drop table fishes";
		
		//DML
		String InsertData = "insert into fishes (fid, fname, ftype) values (01, 'tilapia', 'seafish'), (02, 'ielish', 'nonsea')";
		String UpdateData = "update fishes set fname = 'goldfish' where fid = 1";
		String DeleteRow = "delete from fishes where fid = 1";
		
		//04. Execute Query
		statement.execute(RenameTable);
		
		//05. Process Result
		System.out.println("Changes made successfully");
		
		//06. Close the connection
		connection.close();
	}
}
