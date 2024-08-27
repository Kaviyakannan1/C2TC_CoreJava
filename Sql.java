package com.tns;

	import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.PreparedStatement;
	import java.sql.ResultSet;
	import java.sql.SQLException;
	import java.util.Scanner;

	public class Sql  {
		private static final String URL = "jdbc:mysql://localhost:3306/employee";
			    private static final String USER = "root";
			    private static final String PASSWORD = "root";

			    public static void main(String[] args) {
			        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD);
			             Scanner scanner = new Scanner(System.in)) {
			            System.out.println("Connected to the database.");
			            
			            while (true) {
			                System.out.println("\nChoose an operation:");
			                System.out.println("1. Create Employee");
			                System.out.println("2. Read Employees");
			                System.out.println("3. Update Employee Salary");
			                System.out.println("4. Delete Employee");
			                System.out.println("5. Exit");

			                int choice = scanner.nextInt();
			                scanner.nextLine(); // consume newline

			                switch (choice) {
			                    case 1:
			                        System.out.print("Enter name: ");
			                        String name = scanner.nextLine();
			                        System.out.print("Enter department: ");
			                        String role = scanner.nextLine();
			                        System.out.print("Enter salary: ");
			                        double salary = scanner.nextDouble();
			                        createEmployee(connection, name, role, salary);
			                        break;
			                    case 2:
			                        readEmployees(connection);
			                        break;
			                    case 3:
			                        System.out.print("Enter employee ID to update: ");
			                        int updateId = scanner.nextInt();
			                        System.out.print("Enter new salary: ");
			                        double newSalary = scanner.nextDouble();
			                        updateEmployeeSalary(connection, updateId, newSalary);
			                        break;
			                    case 4:
			                        System.out.print("Enter employee ID to delete: ");
			                        int deleteId = scanner.nextInt();
			                        deleteEmployee(connection, deleteId);
			                        break;
			                    case 5:
			                        System.out.println("Exiting...");
			                        return;
			                    default:
			                        System.out.println("Invalid choice. Please try again.");
			                }
			            }
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			        
			    }

			    public static void createEmployee(Connection connection, String name, String role, double salary) {
			        String sql = "INSERT INTO employees (name, role, salary) VALUES (?, ?, ?)";
			        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			            preparedStatement.setString(1, name);
			            preparedStatement.setString(2, role);
			            preparedStatement.setDouble(3, salary);
			            int rowsAffected = preparedStatement.executeUpdate();
			            System.out.println("Inserted " + rowsAffected + " row(s).");
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			    }
			    public static void readEmployees(Connection connection) {
			        String sql = "SELECT * FROM employees";
			        try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
			             ResultSet resultSet = preparedStatement.executeQuery()) {
			            while (resultSet.next()) {
			                int id = resultSet.getInt("id");
			                String name = resultSet.getString("name");
			                String role = resultSet.getString("role");
			                double salary = resultSet.getDouble("salary");
			                System.out.println("ID: " + id + ", Name: " + name + ", Department: " + role + ", Salary: " + salary);
			            }
			        } catch (SQLException e) {
			            e.printStackTrace();
			        }
			    }

			public static void updateEmployeeSalary(Connection connection, int id, double newSalary) {
			    String sql = "UPDATE employees SET salary = ? WHERE id = ?";
			    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			        preparedStatement.setDouble(1, newSalary);
			        preparedStatement.setInt(2, id);
			        int rowsAffected = preparedStatement.executeUpdate();
			        System.out.println("Updated " + rowsAffected + " row(s).");
			    } catch (SQLException e) {
			        e.printStackTrace();
			    }

			}
			public static void deleteEmployee(Connection connection, int id) {
			    String sql = "DELETE FROM employees WHERE id = ?";
			    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
			        preparedStatement.setInt(1, id);
			        int rowsAffected = preparedStatement.executeUpdate();
			        System.out.println("Deleted " + rowsAffected + " row(s).");
			    } catch (SQLException e) {
			        e.printStackTrace();
		}
			}
		}

