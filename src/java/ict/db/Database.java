package ict.db;

import ict.misc.Callable;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database<T> {
    private final Callable<ResultSet, T> resultSetToEntity;

    public Database(Callable<ResultSet, T> resultSetToEntity) {
        this.resultSetToEntity = resultSetToEntity;
    }

    public Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        String url = "jdbc:mysql://localhost:3306/ITP4511_DB";
        String username = "root";
        String password = "";
        return DriverManager.getConnection(url, username, password);
    }

    public T queryById(int id, String tableName) {
        T entity = null;
        try {
            String queryStatement = "SELECT * FROM "+tableName+" WHERE id=?";
            PreparedStatement statement = getConnection().prepareStatement(queryStatement);
            statement.setInt(1, id);
            List<T> list = query(statement);
            if (list.isEmpty()) throw new RuntimeException("Entity with id '" + id + "' not found");
            entity = list.get(0);
        } catch (SQLException e) {
            while (e != null) {
                e.printStackTrace();
                e = e.getNextException();
            }
        }
        return entity;
    }
    
    public List<T> query(PreparedStatement statement) {
        ArrayList<T> list = new ArrayList<>();
        try {
            Connection connection = getConnection();
            ResultSet rs = statement.executeQuery();
            while (rs.next())
                list.add(resultSetToEntity.call(rs));
            statement.close();
            connection.close();
        } catch (SQLException e) {
            while (e != null) {
                e.printStackTrace();
                e = e.getNextException();
            }
        }
        return list;
    }
    
    public boolean executeNonQuery(PreparedStatement statement) {
        boolean isSuccess = false;
        try {
            Connection connection = getConnection();
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
    
    public int insertRow(PreparedStatement statement, String tableName) throws SQLException {
        int id;
        statement.execute();
        try {
            statement = getConnection().prepareStatement("SELECT MAX(id) id FROM "+tableName);
            ResultSet resultSet = statement.executeQuery();
            resultSet.next();
            id=  resultSet.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return id;
    }
}
