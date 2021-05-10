package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class MyUtils {
	private Connection connection;
	private Statement statement;
	private String schemaName;

	public Connection createConnection() throws SQLException {
		DriverManager.registerDriver(new org.h2.Driver());
		connection = DriverManager.getConnection("jdbc:h2:mem:test", "", "");
		return connection;
	}

	public void closeConnection() throws SQLException {
		connection.close();
	}

	public Statement createStatement() throws SQLException {
		statement = connection.createStatement();
		return statement;
	}

	public void closeStatement() throws SQLException {
		statement.close();
	}

	public void createSchema(String schemaName) throws SQLException {
		this.schemaName = schemaName;
		statement.execute("CREATE SCHEMA IF NOT EXISTS " + schemaName);
	}

	public void dropSchema() throws SQLException {
		statement.execute("DROP SCHEMA IF EXISTS " + this.schemaName);
	}

	public void useSchema() throws SQLException {
		statement.execute("USE " + schemaName);
	}

	public void createTableRoles() throws SQLException {
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS Roles " + "(id INTEGER NOT NULL AUTO_INCREMENT, "
				+ " roleName VARCHAR(255), " + "PRIMARY KEY (id))");
	}

	public void createTableDirections() throws SQLException {
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS Directions " + "(id INTEGER NOT NULL AUTO_INCREMENT, "
				+ " directionName VARCHAR(255), " + " PRIMARY KEY (id))");
	}

	public void createTableProjects() throws SQLException {
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS Projects " + "(id INTEGER NOT NULL AUTO_INCREMENT, "
				+ " projectName VARCHAR(255), " + " directionId INTEGER NOT NULL, " + " PRIMARY KEY (id) "
						+ "FOREIGN KEY(directionId) REFERENCES Directions(id))");
	}

	public void createTableEmployee() throws SQLException {
		statement.executeUpdate("CREATE TABLE IF NOT EXISTS Employee " + "(id INTEGER NOT NULL AUTO_INCREMENT, "
				+ " firstName VARCHAR(255), " + "roleId INTEGER NOT NULL, "
				+ " projectId INTEGER NOT NULL, " + " PRIMARY KEY (id)"
						+ "FOREIGN KEY(roleId) REFERENCES Roles(id))" + "FOREIGN KEY(projectId) REFERENCES Projects(id)))");
	}

	public void dropTable(String tableName) throws SQLException {
		statement.execute("DROP TABLE IF EXISTS " + tableName);
	}

	public void insertTableRoles(String roleName) throws SQLException {
		statement.executeUpdate("INSERT INTO Roles(roleName) VALUES('" + roleName + "')");
	}

	public void insertTableDirections(String directionName) throws SQLException {
		statement.executeUpdate("INSERT INTO Directions(directionName) VALUES('" + directionName + "')");
	}

	public void insertTableProjects(String projectName, String directionName) throws SQLException {
		int directionNameId = getDirectionId(directionName);
		statement.executeUpdate(
				"INSERT INTO Projects(projectName, directionId) VALUES('" + projectName + ", '" + directionNameId + "')");
	}

	public void insertTableEmployee(String firstName, String roleName, String projectName) throws SQLException {
		int roleId = getRoleId(roleName);
		int projectId = getProjectId(projectName);
		statement.executeUpdate("INSERT INTO Employee(firstName, roleId, projectId) VALUES('" + firstName + "', '" + roleId + "', '" + projectId + "')");
	}

	public int getRoleId(String roleName) throws SQLException {
		int roleId = 0;
		ResultSet res = statement.executeQuery("SELECT id FROM Roles WHERE roleName  = '" + roleName + "'");
		while (res.next()) {
			roleId = res.getInt(1);
		}
		return roleId;
	}

	public int getDirectionId(String directionName) throws SQLException {
		int directionId = 0;
		ResultSet res = statement.executeQuery("SELECT id FROM Directions WHERE directionName = '" + directionName + "'");
		while (res.next()) {
			directionId = res.getInt("id");
		}
		return directionId;
	}

	public int getProjectId(String projectName) throws SQLException {
		int projectID = 0;
		ResultSet res = statement.executeQuery("SELECT id FROM Projects WHERE projectName = '" + projectName + "'");
		while (res.next()) {
			projectID = res.getInt("id");
		}
		return projectID;
	}

	public int getEmployeeId(String firstName) throws SQLException {
		int employeeId = 0;
		ResultSet res = statement.executeQuery("SELECT id FROM Employee WHERE firstName = '" + firstName + "'");
		while (res.next()) {
			employeeId = res.getInt("id");
		}
		return employeeId;
	}

	public List<String> getAllRoles() throws SQLException {
		List<String> roles = new ArrayList<>();
		ResultSet res = statement.executeQuery("SELECT roleName FROM Roles");
		while (res.next()) {
			roles.add(res.getString("roleName"));
		}
		return roles;
	}

	public List<String> getAllDirestion() throws SQLException {
		List<String> directions = new ArrayList<>();
		ResultSet res = statement.executeQuery("SELECT directionName FROM Direction");
		while (res.next()) {
			directions.add(res.getString("directionName"));
		}
		return directions;
	}

	public List<String> getAllProjects() throws SQLException {
		List<String> projects = new ArrayList<>();
		ResultSet res = statement.executeQuery("SELECT projectName FROM Projects");
		while (res.next()) {
			projects.add(res.getString("projectName"));
		}
		return projects;
	}

	public List<String> getAllEmployee() throws SQLException {
		List<String> employees = new ArrayList<>();
		ResultSet res = statement.executeQuery("SELECT firstName FROM Employee");
		while (res.next()) {
			employees.add(res.getString("firstName"));
		}
		return employees;
	}

	public List<String> getAllDevelopers() throws SQLException {
		List<String> allDevelopers = new ArrayList<>();
		int developer = getRoleId("Developer");
		ResultSet res = statement.executeQuery("SELECT firstName FROM Employee WHERE roleId = '" + developer + "'");
		while (res.next()) {
			allDevelopers.add(res.getString("firstName"));
		}
		return allDevelopers;
	}

	public List<String> getAllJavaProjects() throws SQLException {
		List<String> allProjects = new ArrayList<>();
		int projectId = getDirectionId("Java");
		ResultSet res = statement.executeQuery("SELECT projectName FROM Projects WHERE directionId = '" + projectId + "'");
		while (res.next()) {
			allProjects.add(res.getString("projectName"));
		}
		return allProjects;
	}

	public List<String> getAllJavaDevelopers() throws SQLException {
		List<String> allJavaDevelopers = new ArrayList<>();
		int developer = getRoleId("Developer");
		List<String> javaProjects = getAllJavaProjects();
		for (String javap : javaProjects) {
			int projectId = getProjectId(javap);
			ResultSet res = statement.executeQuery("SELECT firstName FROM Employee WHERE roleId = '" + developer + "'" + " AND projectId = '" + projectId + "'");
			while (res.next()) {
				allJavaDevelopers.add(res.getString("firstName"));
			}
		}
//		ResultSet res = statement.executeQuery("SELECT firstName FROM Employee WHERE roleId = '" + developer + "'" + " AND projectId = '" + projectId + "'");
//		while (res.next()) {
//			allJavaDevelopers.add(res.getString("firstName"));
//		}
		return allJavaDevelopers;
	}
}
