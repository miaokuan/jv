package pp.sql;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DbTest {

    private String DriverMysql = "com.mysql.jdbc.Driver";
    private String dsn = "jdbc:mysql://localhost:3306/mysql";

    public Statement statement;
    public Connection connection;


    public void connect() throws SQLException {

        try {
            Class.forName(DriverMysql);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        connection = DriverManager.getConnection(dsn, "root", "");
        statement = connection.createStatement();
    }

    public ResultSet query(String sql) throws SQLException {
        ResultSet result = null;

        result = statement.executeQuery(sql);


        return result;
    }

    public List<Map> select(String sql) throws SQLException {
        ResultSet rs = statement.executeQuery(sql);
        ResultSetMetaData rsmd;
        rsmd = rs.getMetaData();
        int columnNum = rsmd.getColumnCount();
//System.out.println(columnNum);
        String[] columns = new String[columnNum];
        for (int i = 0; i < columnNum; i++) {
            columns[i] = rsmd.getColumnLabel(i+1);
        }

        List<Map> list = new ArrayList<Map>();
        while (rs.next()) {

            Map<String, Object> map = new HashMap<>();
            for (int i = 0; i < columnNum; i++) {
                map.put(columns[i], rs.getString(i+1));
            }

            list.add(map);
        }

        return list;
    }

    public void close() throws SQLException {

        if (statement != null) {
            statement.close();
        }

        if (connection != null) {
            connection.close();
        }

    }

    public void printResult(ResultSet result) throws SQLException {
        while (result.next()) {
            System.out.println("user name:" + result.getString("name") + " password:" + result.getString("passwd"));
        }
    }

    public static void main(String[] args) throws SQLException {
        DbTest db = new DbTest();
        db.connect();

        String sql = "select name, passwd from test.user;";
        ResultSet result = db.query(sql);
        db.printResult(result);

        List<Map> list = new ArrayList<Map>();
        list = db.select(sql);
        for (Map map : list) {
            System.out.println("list : user name:" + map.get("name") + " password:" + map.get("passwd")
            );
        }


        db.close();
    }
}
