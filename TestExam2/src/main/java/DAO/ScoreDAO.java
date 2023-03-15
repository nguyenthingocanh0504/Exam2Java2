package DAO;

import Model.Score;
import Connection.MyConnection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ScoreDAO {
    // getAll
    public List<Score> getAll(){
        final String sql = "SELECT * FROM students";
        List<Score> scoreList = new ArrayList<>();
        try {
            Connection connection = MyConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Score s = new Score();
                s.setStdcode(resultSet.getInt("stdcode"));
                s.setStdName(resultSet.getString("stdName"));
                s.setStdAge(resultSet.getInt("stdAge"));
                s.setStdClass(resultSet.getString("stdClass"));
                s.setStdGPA(resultSet.getDouble("stdGPA"));
                s.setStdGender(resultSet.getString("stdGender"));
                scoreList.add(s);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return scoreList;
    }
    // them moi sinh vien
    public void insertStd(Score s){
        final String sql = String.format("INSERT INTO `students` VALUES (NULL,'%s','%d','%s','%f','%s')",
        s.getStdName(), s.getStdAge(), s.getStdClass(), s.getStdGPA(), s.getStdGender());
        try {
            Connection connection = MyConnection.getConnection();
            Statement statement = connection.createStatement();
            long rs = statement.executeUpdate(sql);
            if (rs == 0) {
                System.out.println("Fail");
            }
            statement.close();
            connection.close();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Score getById(int id){
        final String sql =String.format("SELECT * From `students` WHERE stdcode = '%d' " , id);
        Score s = null;
        try {
            Connection connection = MyConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                s = new Score();
                s.setStdcode(resultSet.getInt("stdcode"));
                s.setStdName(resultSet.getString("stdName"));
                s.setStdAge(resultSet.getInt("stdAge"));
                s.setStdClass(resultSet.getString("stdClass"));
                s.setStdGPA(resultSet.getInt("stdGPA"));
                s.setStdGender(resultSet.getString("stdGender"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }

    public Score getByName(String name) {
        Score s = null;
        final String sql =String.format("Select * from `students` where stdName like '%s'", name);
        try {
            Connection connection = MyConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                s = new Score();
                s.setStdcode(resultSet.getInt("stdcode"));
                s.setStdName(resultSet.getString("stdName"));
                s.setStdAge(resultSet.getInt("stdAge"));
                s.setStdClass(resultSet.getString("stdClass"));
                s.setStdGPA(resultSet.getInt("stdGPA"));
                s.setStdGender(resultSet.getString("stdGender"));
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return s;
    }
}
