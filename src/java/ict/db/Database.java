package ict.db;

import ict.bean.CustomerBean;

import java.sql.*;
import java.util.ArrayList;

public class Database {
    private final String url = "jdbc:mysql://localhost:3306/ITP4511_DB";
    private final String username = "root";
    private final String password = "";

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return DriverManager.getConnection(url, username, password);
    }

    public void createCustTable() {
        try {
            Connection c = getConnection();
            Statement s = c.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS customer (" +
                    "id varchar(5) NOT NULL," +
                    "name varchar(25) NOT NULL," +
                    "tel varchar(10) NOT NULL," +
                    "age int(11) NOT NULL," +
                    "PRIMARY KEY (id)" +
                    ")";
            s.execute(sql);
            s.close();
            c.close();
        } catch (SQLException e) {
            SQLException throwables = e;
            while (throwables != null) {
                throwables.printStackTrace();
                throwables = throwables.getNextException();
            }
        }
    }

    public boolean addRecord(String custId, String name, String tel, int age) {
        boolean isSuccess = false;
        try {
            Connection connection = getConnection();
            String preQueryStatement = "INSERT INTO customer VALUES (?,?,?,?)";
            PreparedStatement statement = connection.prepareStatement(preQueryStatement);
            statement.setString(1, custId);
            statement.setString(2, name);
            statement.setString(3, tel);
            statement.setInt(4, age);
            int rowCount = statement.executeUpdate();
            if (rowCount >= 1)
                isSuccess = true;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            while (e != null) {
                e.printStackTrace();
                e = e.getNextException();
            }
        }
        return isSuccess;
    }

    public CustomerBean queryCustByID(String id) {
        CustomerBean customer = null;
        try {
            Connection connection = getConnection();
            String queryStatement = "SELECT * FROM customer WHERE custid=?";
            PreparedStatement statement = connection.prepareStatement(queryStatement);
            statement.setString(1, id);
            ResultSet resultSet = statement.executeQuery();
            customer = resultSetToCustomerList(resultSet).get(0);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            while (e != null) {
                e.printStackTrace();
                e = e.getNextException();
            }
        }
        return customer;
    }

    // test methods for all below methods

    public ArrayList<CustomerBean> queryCustByName(String name) {
        return queryCustByColumn("name", name);
    }

    public ArrayList<CustomerBean> queryCustByTel(String tel) {
        return queryCustByColumn("tel", tel);
    }

    private ArrayList<CustomerBean> queryCustByColumn(String columnName, String value) {
        ArrayList<CustomerBean> customers = new ArrayList<>();
        try {
            Connection connection = getConnection();
            String queryStatement = "SELECT * FROM customer WHERE "+columnName+"=?";
            PreparedStatement statement = connection.prepareStatement(queryStatement);
            statement.setString(1, value);
            ResultSet resultSet = statement.executeQuery();
            customers = resultSetToCustomerList(resultSet);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            while (e != null) {
                e.printStackTrace();
                e = e.getNextException();
            }
        }
        return customers;
    }

    public ArrayList<CustomerBean> queryCust() {
        ArrayList<CustomerBean> customers = new ArrayList<>();
        try {
            Connection connection = getConnection();
            String queryStatement = "SELECT * FROM customer";
            PreparedStatement statement = connection.prepareStatement(queryStatement);
            ResultSet resultSet = statement.executeQuery();
            customers = resultSetToCustomerList(resultSet);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            while (e != null) {
                e.printStackTrace();
                e = e.getNextException();
            }
        }
        return customers;
    }

    public boolean delRecord(String custId) {
        boolean isSuccess = false;
        try {
            Connection connection = getConnection();
            String sql = "DELETE FROM customer WHERE custId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, custId);
            int rowCount = statement.executeUpdate();
            if (rowCount >= 1)
                isSuccess = true;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            while (e != null) {
                e.printStackTrace();
                e = e.getNextException();
            }
        }
        return isSuccess;
    }

    public boolean editRecord(CustomerBean customer) {
        boolean isSuccess = false;
        try {
            Connection connection = getConnection();
            String sql = "UPDATE customer SET name=?, tel=?, age=? WHERE custId = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, customer.getName());
            statement.setString(2, customer.getTel());
            statement.setInt(3, customer.getAge());
            statement.setString(4, customer.getCustId());
            int rowCount = statement.executeUpdate();
            if (rowCount >= 1)
                isSuccess = true;
            statement.close();
            connection.close();
        } catch (SQLException e) {
            while (e != null) {
                e.printStackTrace();
                e = e.getNextException();
            }
        }
        return isSuccess;
    }

    public void dropCustTable() {
        try {
            Connection c = getConnection();
            Statement s = c.createStatement();
            String sql = "DROP TABLE customer";
            s.execute(sql);
            s.close();
            c.close();
        } catch (SQLException e) {
            SQLException throwables = e;
            while (throwables != null) {
                throwables.printStackTrace();
                throwables = throwables.getNextException();
            }
        }
    }

    private ArrayList<CustomerBean> resultSetToCustomerList(ResultSet resultSet) {
        ArrayList<CustomerBean> customers = new ArrayList<>();
        try {
            while (resultSet.next()){
                System.out.println("creating customer");
                customers.add(new CustomerBean(
                        resultSet.getString("custId"),
                        resultSet.getString("name"),
                        resultSet.getString("tel"),
                        resultSet.getInt("age")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return customers;
    }
}
