package controller;

import model.entity.StudentEntity;
import model.service.StudentServ;

import java.util.ArrayList;

public class StudentContr {
//واسط UIوStudentSer
//کارهایی که قبلا در main انجام میدادیم
    public void save1(StudentEntity s) {

        try {
            StudentServ.getInstance().save(s);
        } catch (Exception e) {
            e.getMessage();
        }
    }

    public void update_name(int id , String name){
        try{
            StudentServ.getInstance().edit_name(id,name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update_father_name(int id , String name){
        try{
            StudentServ.getInstance().edit_father_name(id,name);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update_melli_code(int id , String c){
        try{
            StudentServ.getInstance().edit_melli_code(id,c);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update_field(int id , String f){
        try{
            StudentServ.getInstance().edit_field(id,f);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update_birthday(int id , String b){
        try{
            StudentServ.getInstance().edit_birth_day(id,b);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update_maghta_tahsil(int id , String m){
        try{
            StudentServ.getInstance().edit_maghta_tahsil(id,m);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void update_avg(int id , String a){
        try{
            StudentServ.getInstance().edit_avg(id,a);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void remove(int id){
        try{
            StudentServ.getInstance().remove(id);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public ArrayList<StudentEntity> report_all(){
        ArrayList<StudentEntity> arrayList = null;
        try {
            arrayList = StudentServ.getInstance().report_all();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

}
