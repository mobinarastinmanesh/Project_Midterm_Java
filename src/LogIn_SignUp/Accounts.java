package LogIn_SignUp;

import model.entity.StudentEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Accounts implements AutoCloseable{
    private PreparedStatement preparedStatement;
    private Connection connection;
    ////////////////////////////////////////////////////////////////////////////////
    public  Accounts() throws Exception{

        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" ,
                "rastin" , "java");
        connection.setAutoCommit(false);
    }
    /////////////////////////////////////////////////////////////////////////////////
    public void ctreattable()throws Exception{

        preparedStatement=connection.prepareStatement("create table account(username varchar2(20) , password varchar2(20) , semat varchar2(20))");
        preparedStatement.executeUpdate();
        connection.commit();
    }
    //////////////////////////////////////////////////////////////////////////////////
    public void insert(AccountEntity accountEntity) throws Exception{

        preparedStatement=connection.prepareStatement("insert into account(username,password,semat) values(?,?,?)");

        preparedStatement.setString(1,accountEntity.getUsername());
        preparedStatement.setString(2,accountEntity.getPassword());
        preparedStatement.setString(3,accountEntity.getSemat());

        preparedStatement.executeUpdate();
        System.out.println("Insert-->SUCCESSFULLY");
    }
    ////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<AccountEntity> chek() throws  Exception{

        ArrayList<AccountEntity> arrayList = new ArrayList<>();

        preparedStatement=connection.prepareStatement("select * from account");

        ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                AccountEntity s = new AccountEntity();

                s.setUsername(resultSet.getString("username"));
                s.setPassword(resultSet.getString("password"));
                s.setSemat(resultSet.getString("semat"));

                arrayList.add(s);
            }

        return arrayList;
    }

    public void commit() throws Exception{
        connection.commit();
    }

    public void rollback()throws Exception{
        connection.rollback();
    }

    @Override
    public void close() throws Exception {
        preparedStatement.close();
        connection.close();
    }
}
