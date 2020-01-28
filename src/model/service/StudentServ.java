package model.service;


import model.entity.StudentEntity;
import model.repository.StudentRepo;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

public class StudentServ {
//الکوی طراحی singlton
//واسط بین StudentContr و دیتابیس(StudentRepo)

    private static StudentServ ourInstance = new StudentServ();

    public static StudentServ getInstance() {
        return ourInstance;
    }

    private StudentServ() {}

    public void save(StudentEntity studentEntity)throws Exception{
        try(StudentRepo studentRepo = new StudentRepo()){
            studentRepo.insert(studentEntity);
            studentRepo.commit();
            studentRepo.close();
        }
    }
    public void edit_name(int id , String name)throws Exception{
        try(StudentRepo studentRepo = new StudentRepo()){
            studentRepo.update_name(id,name);
            studentRepo.commit();
            studentRepo.close();
        }
    }
    public void edit_father_name(int id , String name)throws Exception{
        try(StudentRepo studentRepo = new StudentRepo()){
            studentRepo.update_father_name(id,name);
            studentRepo.commit();
            studentRepo.close();
        }
    }
    public void edit_melli_code(int id , String code)throws Exception{
        try(StudentRepo studentRepo = new StudentRepo()){
            studentRepo.update_melli_code(id,code);
            studentRepo.commit();
            studentRepo.close();
        }
    }
    public void edit_field(int id , String f)throws Exception{
        try(StudentRepo studentRepo = new StudentRepo()){
            studentRepo.update_field(id,f);
            studentRepo.commit();
            studentRepo.close();
        }
    }
    public void edit_birth_day(int id , String b)throws Exception{
        try(StudentRepo studentRepo = new StudentRepo()){
            studentRepo.update_bith_day(id,b);
            studentRepo.commit();
            studentRepo.close();
        }
    }
    public void edit_avg(int id , String a)throws Exception{
        try(StudentRepo studentRepo = new StudentRepo()){
            studentRepo.update_avg(id,a);
            studentRepo.commit();
            studentRepo.close();
        }
    }
    public void edit_maghta_tahsil(int id , String m)throws Exception{
        try(StudentRepo studentRepo = new StudentRepo()){
            studentRepo.update_maghta_tahsil(id,m);
            studentRepo.commit();
            studentRepo.close();
        }
    }
    public void remove(int id)throws Exception{
        try(StudentRepo studentRepo = new StudentRepo()){
            studentRepo.delete(id);
            studentRepo.commit();
            studentRepo.close();
        }
    }
    public ArrayList<StudentEntity> report_all()throws Exception{
        ArrayList<StudentEntity> arrayList;
        try(StudentRepo studentRepo = new StudentRepo()){
           arrayList =studentRepo.select_all();
            studentRepo.close();
        }
        return arrayList ;
    }



}
