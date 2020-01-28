package model.repository;

import model.entity.StudentEntity;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ExecutionException;

public class StudentRepo implements AutoCloseable{
    private PreparedStatement preparedStatement;
    private Connection connection;

    public  StudentRepo() throws Exception{
        Class.forName("oracle.jdbc.driver.OracleDriver");
        connection= DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe" ,
                "rastin" , "java");
        connection.setAutoCommit(false);
    }
    public void ctreattable()throws Exception{
        preparedStatement=connection.prepareStatement("create table student(sid number,name varchar2(20),father_name varchar2(20),melli_code varchar2(20),field varchar2(20),birth_day varchar2(20),avg varchar2(20),maghta_tahsil varchar2(20))");
        preparedStatement.executeUpdate();
        connection.commit();
        preparedStatement.close();
        connection.close();
    }
    public void insert(StudentEntity studentEntity) throws Exception{
        preparedStatement=connection.prepareStatement("insert into student(sid,name,father_name,melli_code,field,birth_day,avg,maghta_tahsil) values(?,?,?,?,?,?,?,?)");
        preparedStatement.setString(2,studentEntity.getName());
        preparedStatement.setString(3,studentEntity.getFather_name());
        preparedStatement.setString(4,studentEntity.getMelli_code());
        preparedStatement.setString(5,studentEntity.getField());
        preparedStatement.setString(6,studentEntity.getBirth_day());
        preparedStatement.setString(7,"0");//موقع ثبت نام دانش اموز معدل ندارد...بعدا با متد اپدیت معدل تغییر داده میشود
        preparedStatement.setString(8,studentEntity.getMaghta_tahsil());

        Random random = new Random();//سیستم به صورت خودکار و  رندوم ID برای هر دانش آموز صادر میکنه
        int sid=random.nextInt(401)+1;//فرض بر اینکه مدرسه 400 دانش اموز داره
        preparedStatement.setLong(1,sid);

        preparedStatement.executeUpdate();
        System.out.println("SUCCESSFULLY");
    }
    public void update_name(int id , String name)throws Exception{
        preparedStatement=connection.prepareStatement("update student set name=? where sid=?");
        preparedStatement.setString(1,name);
        preparedStatement.setLong(2,id);
        preparedStatement.executeUpdate();
        System.out.println("SUCCESSFULLY");
    }
    public void update_father_name(int id , String name)throws Exception{
        preparedStatement=connection.prepareStatement("update student set father_name=? where sid=?");
        preparedStatement.setString(1,name);
        preparedStatement.setLong(2,id);
        preparedStatement.executeUpdate();
        System.out.println("SUCCESSFULLY");
    }
    public void update_melli_code(int id , String code)throws Exception{
        preparedStatement=connection.prepareStatement("update student set melli_code=? where sid=?");
        preparedStatement.setString(1,code);
        preparedStatement.setLong(2,id);
        preparedStatement.executeUpdate();
        System.out.println("SUCCESSFULLY");
    }
    public void update_field(int id , String f)throws Exception{
        preparedStatement=connection.prepareStatement("update student set field=? where sid=?");
        preparedStatement.setString(1,f);
        preparedStatement.setLong(2,id);
        preparedStatement.executeUpdate();
        System.out.println("SUCCESSFULLY");
    }
    public void update_bith_day(int id , String day)throws Exception{
        preparedStatement=connection.prepareStatement("update student set birth_day=? where sid=?");
        preparedStatement.setString(1,day);
        preparedStatement.setLong(2,id);
        preparedStatement.executeUpdate();
        System.out.println("SUCCESSFULLY");
    }
    public void update_avg(int id , String avg)throws Exception{
        preparedStatement=connection.prepareStatement("update student set avg=? where sid=?");
        preparedStatement.setString(1,avg);
        preparedStatement.setLong(2,id);
        preparedStatement.executeUpdate();
        System.out.println("SUCCESSFULLY");
    }
    public void update_maghta_tahsil(int id , String m)throws Exception{
        preparedStatement=connection.prepareStatement("update student set maghta_tahsil=? where sid=?");
        preparedStatement.setString(1,m);
        preparedStatement.setLong(2,id);
        preparedStatement.executeUpdate();
        System.out.println("SUCCESSFULLY");
    }
    public void delete(int id)throws Exception{
        preparedStatement=connection.prepareStatement("delete student where sid=?");
        preparedStatement.setLong(1,id);
        preparedStatement.executeUpdate();
        System.out.println("SUCCESSFULLY");
    }
    public ArrayList<StudentEntity> select_all() throws  Exception{
        ArrayList<StudentEntity> arrayList = new ArrayList<>();
        preparedStatement=connection.prepareStatement("select * from student");
        ResultSet resultSet = preparedStatement.executeQuery();
        while(resultSet.next()){
            StudentEntity s = new StudentEntity();//هر رکورد در یه شی ذخیره میشه
            s.setSid(resultSet.getLong("sid"));
            s.setName(resultSet.getString("name"));
            s.setFather_name(resultSet.getString("father_name"));
            s.setMelli_code(resultSet.getString("melli_code"));
            s.setField(resultSet.getString("field"));
            s.setBirth_day(resultSet.getString("birth_day"));
            s.setAvg(resultSet.getString("avg"));
            s.setMaghta_tahsil(resultSet.getString("maghta_tahsil"));
            arrayList.add(s);//شی ها به لیست اضافه میشوند
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
