package view;

import LogIn_SignUp.AccountEntity;
import LogIn_SignUp.Accounts;
import controller.StudentContr;
import model.entity.StudentEntity;
import model.repository.StudentRepo;


import javax.swing.*;
import java.awt.*;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class UI1 {
    public static void main(String[] args) {
/////////////////////////////////////////////////پنجره ورود یا ثبت نام کاربر////////////////////////////////////////////
        JFrame f = new JFrame("ورود و ثبت نام");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel label = new JLabel();//متن خطا یا اعلام عملیات موفق
        label.setBounds(140, 200, 200, 50);

        JPasswordField value = new JPasswordField();//پسورد
        value.setBounds(100, 75, 100, 30);

        JLabel l1 = new JLabel("* نام کاربری");//نام کاربری:
        l1.setBounds(20, 20, 80, 30);

        JLabel l2 = new JLabel("* رمز عبور");//: پسورد
        l2.setBounds(20, 75, 80, 30);

        JLabel l3 = new JLabel("اگر حساب ندارید لطفا دکمه زیر را بزنید و ثبت نام کنید...");
        l3.setBounds(50, 200, 400, 100);
        l3.setForeground(Color.blue);

        JButton a = new JButton("ورود");//دکمه ورود
        a.setBounds(115, 130, 70, 25);
        a.setBackground(Color.pink);

        JButton b = new JButton("ثبت نام");//دکمه ثبت نام
        b.setBounds(150, 300, 80, 30);
        b.setBackground(Color.CYAN);

        JTextField text = new JTextField();//نام کاربری
        text.setBounds(100, 20, 100, 30);

        JLabel jt = new JLabel();//خالی بودن کادر اسم
        jt.setBounds(200, 20, 100, 30);
        jt.setForeground(Color.red);

        JLabel jp = new JLabel();//خالی بودن کادر رمز
        jp.setBounds(200, 75, 100, 30);
        jp.setForeground(Color.red);

        f.add(value);// وارد کردن پسورد
        f.add(l1);//نام کاربری
        f.add(l2);//پسورد
        f.add(l3);//اگر حساب ندارید...
        f.add(label);//متن خطا یا موفقیت
        f.add(a);//دکمه ورود
        f.add(b);//دکمه ثبت نام
        f.add(text);//وارد کردن نام کاربری
        f.add(jt);//کادر خالی تذکر
        f.add(jp);//کادرخالی تذکر

        f.setSize(400, 500);
        f.setLayout(null);
        f.setVisible(true);
///////////////////////////////////////////////////////////اگر دکمه ورود را زد /////////////////////////////////////////
        a.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username;
                String password;

                String D = "";

                if (text.getText().equals(D) && String.valueOf(value.getPassword()).equals(D)) {
                    jt.setText("لطفا پر کنید...");
                    jp.setText("لطفا پر کنید...");

                }
                else if (text.getText().equals(D)) {
                    jt.setText("لطفا پر کنید...");
                    jp.setText("");

                }
                else if (String.valueOf(value.getPassword()).equals(D)) {
                    jp.setText("لطفا پر کنید...");
                    jt.setText("");

                }
                else {//کادری خالی نباشد

                    username = text.getText();
                    password = String.valueOf(value.getPassword());

                    ////////////////////////////
                    Accounts accounts = null;
                    ArrayList<AccountEntity> list = null;
                    ///////محتوای دیتابیس را در لیستی از اشیا میریزیم///
                    try {
                        accounts = new Accounts();
                        list = accounts.chek();
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    ///////////////////////////چک کردن صحت رمز عبور و نام کاربری////////
                    boolean R = false;
                    for (AccountEntity a : list) {
                        if (a.getUsername().equals(username) && a.getPassword().equals(password)) {
                            R = true;//// نام کاربری و رمز هر دو وجود دارد و هر دو صحیح است
                            break;
                        }
                        else if (!a.getUsername().equals(username) && !a.getPassword().equals(password)) {
                            R = false;//هر دو همزمان باید مطابقت داشته باشند
                        }
                    }
/////////////////////////////////////////////اگر اطلاعاتش رو صحیح وارد کرد///////////////////////////////////////////////
                    if (R == true) {//نام کاربری و رمز درست بود
                        label.setForeground(Color.green);
                        label.setText("با موفقیت وارد شدید");
                        jt.setText("");
                        jp.setText("");
                        /////////////////////////////////////////به دیتا بیس دسترسی پیدا میکنه//////////////////////////
                        JFrame jFrame = new JFrame();
                        jFrame.setLocation(0, 0);
                        jFrame.setSize(700, 700);//پنجره دکمه های عملیات مربوط به دانش آموزان
                        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        jFrame.setVisible(true);

                        GridLayout gridLayout = new GridLayout(5, 2);
                        jFrame.setLayout(gridLayout);

                        JButton jr1 = new JButton("ثبت نام دانش آموز");
                        jr1.setBackground(Color.pink);
                        jr1.setBounds(600, 20, 50, 50);

                        JButton jr2 = new JButton("حذف");
                        jr2.setBackground(Color.red);
                        jr2.setBounds(700, 20, 50, 50);

                        JButton jr3 = new JButton("نمایش");
                        jr3.setBackground(Color.green);
                        jr3.setBounds(600, 100, 50, 50);

                        JButton jr4 = new JButton("به روز رسانی معدل");
                        jr4.setBackground(Color.cyan);
                        jr4.setBounds(700, 100, 50, 50);

                        JButton jr5 = new JButton("به روز رسانی اسم");
                        jr5.setBackground(Color.orange);
                        jr5.setBounds(600, 180, 50, 50);

                        JButton jr6 = new JButton("به روز رسانی نام پدر");
                        jr6.setBackground(Color.LIGHT_GRAY);
                        jr6.setBounds(700, 180, 50, 50);

                        JButton jr7 = new JButton("به روز رسانی کد ملی");
                        jr7.setBackground(Color.white);
                        jr7.setBounds(600, 260, 50, 50);

                        JButton jr8 = new JButton("به روز رسانی رشته");
                        jr8.setBackground(Color.blue);
                        jr8.setBounds(700, 260, 50, 50);

                        JButton jr9 = new JButton("به روز رسانی تاریخ تولد");
                        jr9.setBackground(Color.pink);
                        jr9.setBounds(600, 340, 50, 50);

                        JButton jr0 = new JButton("به روز رسانی مقطع تحصیلی");
                        jr0.setBackground(Color.GRAY);
                        jr0.setBounds(700, 340, 50, 50);

                        jFrame.add(jr1);
                        jFrame.add(jr2);
                        jFrame.add(jr3);
                        jFrame.add(jr4);
                        jFrame.add(jr5);
                        jFrame.add(jr6);
                        jFrame.add(jr7);
                        jFrame.add(jr8);
                        jFrame.add(jr9);
                        jFrame.add(jr0);

///////////////////////////////////////////////////////////ثبت نام دانش اموز////////////////////////////////////////////
                        jr1.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame jFrame1 = new JFrame();
                                jFrame1.setLocation(700, 0);
                                jFrame1.setSize(600, 800);

                                /////////////////////////////////////////////////
                                JLabel j1 = new JLabel("نام و نام خانوادگی");
                                j1.setBounds(5, 50, 300, 30);
                                JTextField t1 = new JTextField();//name
                                t1.setBounds(100, 50, 300, 30);

                                JLabel j2 = new JLabel("نام پدر");
                                j2.setBounds(5, 100, 300, 30);
                                JTextField t2 = new JTextField();//fathername
                                t2.setBounds(100, 100, 300, 30);

                                JLabel j3 = new JLabel("کدملی");
                                j3.setBounds(5, 150, 300, 30);
                                JTextField t3 = new JTextField();//codemelli
                                t3.setBounds(100, 150, 300, 30);

                                JLabel j4 = new JLabel("رشته");
                                j4.setBounds(5, 200, 300, 30);
                                JTextField t4 = new JTextField();//reshte
                                t4.setBounds(100, 200, 300, 30);

                                JLabel j5 = new JLabel("تاریخ تولد");
                                j5.setBounds(5, 250, 300, 30);
                                JTextField t5 = new JTextField();//maghta
                                t5.setBounds(100, 250, 300, 30);

                                JLabel j6 = new JLabel("مقطع تحصیلی");
                                j6.setBounds(5, 300, 300, 30);
                                JTextField t6 = new JTextField();
                                t6.setBounds(100, 300, 300, 30);
                                ////////////////////////////////////////////////////
                                JButton js = new JButton("ثبت");
                                js.setBounds(50, 500, 60, 60);
                                js.setBackground(Color.orange);
                                //////////////////////////تذکر کادر خالی//////////////////////
                                JLabel jt1 = new JLabel();
                                jt1.setBounds(400, 50, 300, 30);
                                jt1.setForeground(Color.red);

                                JLabel jt2 = new JLabel();
                                jt2.setBounds(400, 100, 300, 30);
                                jt2.setForeground(Color.red);

                                JLabel jt3 = new JLabel();
                                jt3.setBounds(400, 150, 300, 30);
                                jt3.setForeground(Color.red);

                                JLabel jt4 = new JLabel();
                                jt4.setBounds(400, 200, 300, 30);
                                jt4.setForeground(Color.red);

                                JLabel jt5 = new JLabel();
                                jt5.setBounds(400, 250, 300, 30);
                                jt5.setForeground(Color.red);

                                JLabel jt6 = new JLabel();
                                jt6.setBounds(400, 300, 300, 30);
                                jt6.setForeground(Color.red);
                                //////////////////////////اعلام خطا یا موفقیت//////////////////////////
                                JLabel label = new JLabel();
                                label.setBounds(50, 600, 200, 50);
                                label.setForeground(Color.green);
                                ///////////////////////////////////////////////////////
                                jFrame1.add(j1);
                                jFrame1.add(j2);
                                jFrame1.add(j3);
                                jFrame1.add(j4);
                                jFrame1.add(j5);
                                jFrame1.add(j6);

                                jFrame1.add(t1);
                                jFrame1.add(t2);
                                jFrame1.add(t3);
                                jFrame1.add(t4);
                                jFrame1.add(t5);
                                jFrame1.add(t6);

                                jFrame1.add(js);

                                jFrame1.add(jt1);
                                jFrame1.add(jt2);
                                jFrame1.add(jt3);
                                jFrame1.add(jt4);
                                jFrame1.add(jt5);
                                jFrame1.add(jt6);

                                jFrame1.add(label);

                                jFrame1.setLayout(null);
                                jFrame1.setVisible(true);


   /////////////////////////////////////////////////////وقتی ثبت رو زد////////////////////////////////////////
                                js.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        StudentEntity s = new StudentEntity();

                                        String D = "";

                                        if (t1.getText().equals(D)) {
                                            jt1.setText("لطفا پر کنید...");
                                            jt2.setText("");
                                            jt3.setText("");
                                            jt4.setText("");
                                            jt5.setText("");
                                            jt6.setText("");

                                        }
                                        else if (t2.getText().equals(D)) {
                                            jt1.setText("");
                                            jt2.setText("لطفا پر کنید...");
                                            jt3.setText("");
                                            jt4.setText("");
                                            jt5.setText("");
                                            jt6.setText("");
                                        }
                                        else if (t3.getText().equals(D)) {
                                            jt1.setText("");
                                            jt2.setText("");
                                            jt3.setText("لطفا پر کنید...");
                                            jt4.setText("");
                                            jt5.setText("");
                                            jt6.setText("");
                                        }
                                        else if (t4.getText().equals(D)) {
                                            jt1.setText("");
                                            jt2.setText("");
                                            jt3.setText("");
                                            jt4.setText("لطفا پر کنید...");
                                            jt5.setText("");
                                            jt6.setText("");
                                        }
                                        else if (t5.getText().equals(D)) {
                                            jt1.setText("");
                                            jt2.setText("");
                                            jt3.setText("");
                                            jt4.setText("");
                                            jt5.setText("لطفا پر کنید...");
                                            jt6.setText("");
                                        }
                                        else if (t6.getText().equals(D)) {
                                            jt1.setText("");
                                            jt2.setText("");
                                            jt3.setText("");
                                            jt4.setText("");
                                            jt5.setText("");
                                            jt6.setText("لطفا پر کنید...");
                                        }
                                        else {
                                            jt1.setText("");
                                            jt2.setText("");
                                            jt3.setText("");
                                            jt4.setText("");
                                            jt5.setText("");
                                            jt6.setText("");
                                            //تذکر کادر های خالی پاک شوند

                                            s.setName(t1.getText());
                                            s.setFather_name(t2.getText());
                                            s.setMelli_code(t3.getText());
                                            s.setField(t4.getText());
                                            s.setBirth_day(t5.getText());
                                            s.setMaghta_tahsil(t6.getText());

                                            new StudentContr().save1(s);
                                            label.setText("با موفقیت ثبت شد....");
                                        }

                                    }
                                });
                            }
                        });
         //////////////////////////////////////////////////////////حذف دانش اموز////////////////////////////////////////

                        jr2.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame jFrame2 = new JFrame();
                                jFrame2.setLocation(700, 0);
                                jFrame2.setSize(700, 700);


                                JButton jr = new JButton("ثبت");
                                jr.setBounds(600, 20, 50, 50);
                                jr.setBackground(Color.orange);

                                JLabel ji = new JLabel("id");
                                ji.setBounds(200, 20, 30, 30);

                                JTextField ti = new JTextField();
                                ti.setBounds(250, 20, 200, 30);

                                JLabel jti =new JLabel();//تذکر کادر خالی
                                jti.setBounds(480,20,100,30);
                                jti.setForeground(Color.red);

                                JLabel j = new JLabel();
                                j.setBounds(500, 100, 200, 50);


                                jFrame2.add(jr);
                                jFrame2.add(ji);
                                jFrame2.add(ti);
                                jFrame2.add(jti);
                                jFrame2.add(j);
                                ///////////وقتی دکمه ثبت رو زد//////
                                jr.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {

                                        String D = "";
                                        /////کادر خالی نباشد//
                                        if (ti.getText().equals(D)) {

                                            jti.setText("لطفا پر کنید...");

                                        }
                                        ///////////////////////////////////////////////////////////////
                                        else {
                                            jti.setText("");//اگر تذکر داده بود پاک شود

                                            int id = Integer.parseInt(ti.getText());

                                            StudentContr s = null;
                                            ArrayList<StudentEntity> list1 = null;

                                            try {
                                                s = new StudentContr();
                                                list1 = s.report_all();
                                            } catch (Exception e1) {
                                                e1.printStackTrace();
                                            }
                                            ////////////////////////////////
                                            boolean o = false;
                                            for (StudentEntity a : list1) {
                                                if (a.getSid() == id) {//ای دی موجود بوده است
                                                    o = true;
                                                    break;
                                                } else {
                                                    o = false;
                                                }
                                            }

                                            if (o == true) {
                                                new StudentContr().remove(id);
                                                j.setForeground(Color.green);
                                                j.setText("با موفقیت حذف شد...");
                                                jti.setText("");

                                            } else if (o == false) {
                                                jti.setText("");

                                                j.setForeground(Color.red);
                                                j.setText("این شماره دانش آموزی موجود نمی باشد...");
                                            }

                                        }
                                    }
                                });


                                  jFrame2.setLayout(null);
                                  jFrame2.setVisible(true);
                              }

                        });
 ///////////////////////////////////////////////////////////////نمایش///////////////////////////////////////////////////

                        jr3.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {

                                JFrame f = new JFrame();
                                String[][] data = new String[40][8];//ارایه مربوط به اطلاعات دانش اموزان
                                //////////////////////////////////
                                ArrayList<StudentEntity> entities = new StudentContr().report_all();
                                int j = 0;
                                for (StudentEntity s : entities) {
                                    data[j][0] = String.valueOf(s.getSid());
                                    data[j][1] = s.getName();
                                    data[j][2] = s.getFather_name();
                                    data[j][3] = s.getMelli_code();
                                    data[j][4] = s.getBirth_day();
                                    data[j][5] = s.getMaghta_tahsil();
                                    data[j][6] = s.getAvg();
                                    data[j][7] = s.getField();
                                    j += 1;
                                }
                                /////////////////////////////////////
                                String column[] = {"شماره دانش آموزی", "نام", "نام پدر", "شماره شناسنامه", "تاریخ تولد", "مقطع تحصیلی", "معدل", "رشته تحصیلی"};//عنوان ستون ها

                                JTable jt = new JTable(data, column);
                                jt.setEnabled(false);//قابل تغییر نیستند وقتی نمایش داده میشوند

                                JScrollPane sp = new JScrollPane(jt);

                                f.setSize(1000, 400);
                                f.setVisible(true);

                                f.add(sp);
                            }
                        });
   //////////////////////////////////////////////////////////////به روز رسانی معدل//////////////////////////////////////
                        jr4.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame jFrame4 = new JFrame();
                                jFrame4.setLocation(700, 0);
                                jFrame4.setSize(700, 700);
                                /////////////////////////////////////////////////
                                JLabel ju = new JLabel("شماره دانش اموزی");
                                ju.setBounds(1, 50, 300, 30);
                                JTextField tu = new JTextField();
                                tu.setBounds(100, 50, 300, 30);
                                JLabel jti1=new JLabel();
                                jti1.setBounds(420,50,100,30);
                                jti1.setForeground(Color.red);

                                JLabel ju1 = new JLabel("معدل");
                                ju1.setBounds(1, 100, 300, 30);
                                JTextField tu1 = new JTextField();
                                tu1.setBounds(100, 100, 300, 30);
                                JLabel jti2=new JLabel();
                                jti2.setBounds(420,100,100,30);
                                jti2.setForeground(Color.red);
                                /////////////////////متن موفقیت یا خطا//////////////
                                JLabel j= new JLabel();
                                j.setBounds(50, 300, 200, 50);
                                j.setForeground(Color.blue);
                                ////////////////////////////////////////////////
                                jFrame4.add(ju);
                                jFrame4.add(tu);
                                jFrame4.add(ju1);
                                jFrame4.add(tu1);
                                jFrame4.add(jti1);
                                jFrame4.add(jti2);
                                jFrame4.add(j);
                                ////////////////////////////////////////////////
                                JButton jbu = new JButton("ثبت");
                                jbu.setBounds(100, 200, 50, 50);
                                jbu.setBackground(Color.orange);
                                jFrame4.add(jbu);
                                //////////////////دکمه ثبت رو که زد//////////////////////////
                                jbu.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String D = "";
                                        /////کادر خالی نباشد//
                                        if(tu1.getText().equals(D) && tu.getText().equals(D) ){
                                            jti2.setText("لطفا پر کنید...");
                                            jti1.setText("لطفا پر کنید...");
                                        }
                                        else if (tu.getText().equals(D)) {
                                            jti1.setText("لطفا پر کنید...");
                                            jti2.setText("");
                                        }
                                        else if(tu1.getText().equals(D)) {
                                            jti2.setText("لطفا پر کنید...");
                                            jti1.setText("");
                                        }
                                        else {
                                            int id = Integer.parseInt(tu.getText());
                                            String avg = tu1.getText();
                                            ////////////////////////
                                            StudentContr s = null;
                                            ArrayList<StudentEntity> list1 = null;
                                            try {
                                                s = new StudentContr();
                                                list1 = s.report_all();
                                            } catch (Exception e1) {
                                                e1.printStackTrace();
                                            }
                                            ////////////////////////////////
                                            boolean o = false;
                                            for (StudentEntity a : list1) {
                                                if (a.getSid() == id) {
                                                    o = true;
                                                    break;
                                                } else {
                                                    o = false;
                                                }
                                            }
                                            //////////////////////
                                            if (o == true) {
                                                new StudentContr().update_avg(id, avg);
                                                j.setText("با موفقیت تغییر یافت...");
                                                jti1.setText("");
                                                jti2.setText("");

                                            }
                                            else if (o == false) {
                                                jti1.setText("");
                                                jti2.setText("");
                                                j.setText("این شماره دانش آموزی موجود نمی باشد...");
                                            }
                                        }
                                    }
                                });
                                ///////////////////////
                                jFrame4.setLayout(null);
                                jFrame4.setVisible(true);
                            }
                        });
//////////////////////////////////////////////////////به روز رسانی نام//////////////////////////////////////////////////
                        jr5.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame jFrame5 = new JFrame();
                                jFrame5.setLocation(700, 0);
                                jFrame5.setSize(700, 700);

                                /////////////////////////////////////////////////
                                JLabel ju = new JLabel("شماره دانش اموزی");
                                ju.setBounds(1, 50, 300, 30);
                                JTextField tu = new JTextField();
                                tu.setBounds(100, 50, 300, 30);
                                JLabel jti1=new JLabel();//کادر خالی
                                jti1.setBounds(420,50,100,30);
                                jti1.setForeground(Color.red);

                                JLabel ju1 = new JLabel("نام جدید");
                                ju1.setBounds(1, 100, 300, 30);
                                JTextField tu1 = new JTextField();//name
                                tu1.setBounds(100, 100, 300, 30);
                                JLabel jti2=new JLabel();//کادرخالی
                                jti2.setBounds(420,100,100,30);
                                jti2.setForeground(Color.red);

                                /////////////////////متن خطا یا موفقیت//////////////
                                JLabel label = new JLabel();
                                label.setBounds(50, 300, 200, 50);
                                label.setForeground(Color.blue);
                                //////////////////////////////////////////////
                                jFrame5.add(ju);
                                jFrame5.add(tu);
                                jFrame5.add(ju1);
                                jFrame5.add(tu1);
                                jFrame5.add(tu1);
                                jFrame5.add(jti1);
                                jFrame5.add(jti2);
                                jFrame5.add(label);
                                ////////////////////////////////////////////////
                                JButton jbu = new JButton("ثبت");
                                jbu.setBounds(100, 200, 50, 50);
                                jbu.setBackground(Color.orange);
                                jFrame5.add(jbu);
                                /////////////////////////////////////////////////
                                jbu.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String D = "";
                                        /////کادر خالی نباشد//
                                        if(tu1.getText().equals(D) && tu.getText().equals(D) ){
                                            jti1.setText("لطفا پر کنید...");
                                            jti2.setText("لطفا پر کنید...");
                                        }
                                        else if (tu.getText().equals(D)) {
                                            jti1.setText("لطفا پر کنید...");
                                            jti2.setText("");
                                        }
                                        else if(tu1.getText().equals(D)) {
                                            jti2.setText("لطفا پر کنید...");
                                            jti1.setText("");
                                        }
                                        else {
                                            int id = Integer.parseInt(tu.getText());
                                            String name = tu1.getText();

                                            //////////////////////
                                            StudentContr s = null;
                                            ArrayList<StudentEntity> list1 = null;
                                            try {
                                                s = new StudentContr();
                                                list1 = s.report_all();
                                            } catch (Exception e1) {
                                                e1.printStackTrace();
                                            }
                                            ////////////////////////////////
                                            boolean o = false;
                                            for (StudentEntity a : list1) {
                                                if (a.getSid() == id) {
                                                    o = true;
                                                    break;
                                                } else {
                                                    o = false;
                                                }
                                            }
                                            ///////////////////////////////
                                            if (o == true) {
                                                new StudentContr().update_name(id, name);
                                                jti1.setText("");
                                                jti2.setText("");
                                                label.setText("با موفقیت تغییر یافت...");
                                            }
                                            else if (o == false) {
                                                jti1.setText("");
                                                jti2.setText("");
                                                label.setText("این شماره دانش آموزی موجود نمی باشد...");
                                            }
                                        }

                                    }
                                });
                                ///////////////////////////////////////////////////
                                jFrame5.setLayout(null);
                                jFrame5.setVisible(true);
                            }
                        });
////////////////////////////////////////////////////////////////به روزرسانی نام پدر/////////////////////////////////////
                        jr6.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame jFrame6 = new JFrame();
                                jFrame6.setLocation(700, 0);
                                jFrame6.setSize(700, 700);

                                /////////////////////////////////////////////////
                                JLabel ju = new JLabel("شماره دانش اموزی");
                                ju.setBounds(1, 50, 300, 30);
                                JTextField tu = new JTextField();
                                tu.setBounds(100, 50, 300, 30);
                                JLabel jti1=new JLabel();
                                jti1.setBounds(420,50,100,30);
                                jti1.setForeground(Color.red);

                                JLabel ju1 = new JLabel("نام پدر (جدید)");
                                ju1.setBounds(1, 100, 300, 30);
                                JTextField tu1 = new JTextField();//name
                                tu1.setBounds(100, 100, 300, 30);
                                JLabel jti2=new JLabel();
                                jti2.setBounds(420,100,100,30);
                                jti2.setForeground(Color.red);
                                //////////////////////////////////////////////
                                JLabel label = new JLabel();
                                label.setBounds(50, 300, 200, 50);
                                label.setForeground(Color.blue);
                                /////////////////////////////////////////////
                                jFrame6.add(ju);
                                jFrame6.add(tu);
                                jFrame6.add(ju1);
                                jFrame6.add(tu1);
                                jFrame6.add(jti1);
                                jFrame6.add(jti2);
                                jFrame6.add(label);
                                ////////////////////////////////////////////////
                                JButton jbu = new JButton("ثبت");
                                jbu.setBounds(100, 200, 50, 50);
                                jbu.setBackground(Color.orange);
                                jFrame6.add(jbu);
                                /////////////////////////////////////////////////
                                jbu.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String D = "";
                                        /////کادر خالی نباشد//
                                        if(tu1.getText().equals(D) && tu.getText().equals(D) ){
                                            jti1.setText("لطفا پر کنید...");
                                            jti2.setText("لطفا پر کنید...");
                                        }
                                        else if (tu.getText().equals(D)) {
                                            jti1.setText("لطفا پر کنید...");
                                            jti2.setText("");
                                        }
                                        else if(tu1.getText().equals(D)) {
                                            jti2.setText("لطفا پر کنید...");
                                            jti1.setText("");
                                        }
                                        else {
                                            int id = Integer.parseInt(tu.getText());
                                            String name = tu1.getText();
                                            //////////////////////////
                                            StudentContr s = null;
                                            ArrayList<StudentEntity> list1 = null;

                                            try {
                                                s = new StudentContr();
                                                list1 = s.report_all();
                                            } catch (Exception e1) {
                                                e1.printStackTrace();
                                            }
                                            ////////////////////////////////
                                            boolean o = false;
                                            for (StudentEntity a : list1) {
                                                if (a.getSid() == id) {
                                                    o = true;
                                                    break;
                                                } else {
                                                    o = false;
                                                }
                                            }
                                            ///////////////////////////////
                                            if (o == true) {
                                                new StudentContr().update_father_name(id, name);
                                                label.setText("با موفقیت تغییر یافت...");
                                                jti1.setText("");
                                                jti2.setText("");
                                            }
                                            else if (o == false) {
                                                jti1.setText("");
                                                jti2.setText("");
                                                label.setText("این شماره دانش آموزی موجود نمی باشد...");
                                            }
                                        }

                                    }
                                });
                                ///////////////////////////////////////////////////
                                jFrame6.setLayout(null);
                                jFrame6.setVisible(true);
                            }
                        });
  ////////////////////////////////////////////////////////به روزرسانی کدملی/////////////////////////////////////////////
                        jr7.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame jFrame7 = new JFrame();
                                jFrame7.setLocation(700, 0);
                                jFrame7.setSize(700, 700);

                                ////////////////////////////////////////////////////////////
                                JLabel ju5 = new JLabel("شماره دانش اموزی");
                                ju5.setBounds(1, 50, 300, 30);
                                JTextField tu5 = new JTextField();
                                tu5.setBounds(100, 50, 300, 30);
                                JLabel jti1=new JLabel();
                                jti1.setBounds(420,50,100,30);
                                jti1.setForeground(Color.red);

                                JLabel ju6 = new JLabel("کدملی");
                                ju6.setBounds(1, 100, 300, 30);
                                JTextField tu6 = new JTextField();//name
                                tu6.setBounds(100, 100, 300, 30);
                                JLabel jti2=new JLabel();
                                jti2.setBounds(420,100,100,30);
                                jti2.setForeground(Color.red);
                                ////////////////////////////////////////////////////////
                                JLabel label = new JLabel();
                                label.setBounds(50, 300, 200, 50);
                                label.setForeground(Color.blue);
                                ///////////////////////////////////////////////////////
                                jFrame7.add(ju5);
                                jFrame7.add(tu5);
                                jFrame7.add(ju6);
                                jFrame7.add(tu6);
                                jFrame7.add(jti1);
                                jFrame7.add(jti2);
                                jFrame7.add(label);
                                /////////////////////////////////////////////////////
                                JButton jbu7 = new JButton("ثبت");
                                jbu7.setBounds(100, 200, 50, 50);
                                jbu7.setBackground(Color.orange);
                                jFrame7.add(jbu7);
                                //////////////////////دکمه ثبت رو زد//////////////////
                                jbu7.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String D = "";
                                        /////کادر خالی نباشد//
                                        if(tu5.getText().equals(D) && tu6.getText().equals(D) ){
                                            jti1.setText("لطفا پر کنید...");
                                            jti2.setText("لطفا پر کنید...");
                                        }
                                        else if (tu5.getText().equals(D)) {
                                            jti1.setText("لطفا پر کنید...");
                                            jti2.setText("");
                                        }
                                        else if(tu6.getText().equals(D)) {
                                            jti2.setText("لطفا پر کنید...");
                                            jti1.setText("");
                                        }
                                        else {

                                            int id = Integer.parseInt(tu5.getText());
                                            String code = tu6.getText();

                                            StudentContr s = null;
                                            ArrayList<StudentEntity> list1 = null;

                                            try {
                                                s = new StudentContr();
                                                list1 = s.report_all();
                                            } catch (Exception e1) {
                                                e1.printStackTrace();
                                            }
                                            ////////////////////////////////
                                            boolean o = false;
                                            for (StudentEntity a : list1) {
                                                if (a.getSid() == id) {
                                                    o = true;
                                                    break;
                                                } else {
                                                    o = false;
                                                }
                                            }
                                            ///////////////////////////////
                                            if (o == true) {
                                                new StudentContr().update_melli_code(id, code);
                                                label.setText("با موفقیت تغییر یافت...");
                                                jti1.setText("");
                                                jti2.setText("");
                                            }
                                            else if (o == false) {
                                                jti1.setText("");
                                                jti2.setText("");
                                                label.setText("این شماره دانش آموزی موجود نمی باشد...");
                                            }
                                        }
                                    }
                                });
                                //////////////////////////////////////////////////////
                                jFrame7.setLayout(null);
                                jFrame7.setVisible(true);
                            }
                        });
///////////////////////////////////////////////////////////////////به روزرسانی رشته/////////////////////////////////////
                        jr8.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame jFrame8 = new JFrame();
                                jFrame8.setLocation(700, 0);
                                jFrame8.setSize(700, 700);

                                ////////////////////////////////////////////////////////////
                                JLabel ju7 = new JLabel("شماره دانش اموزی");
                                ju7.setBounds(1, 50, 300, 30);
                                JTextField tu7 = new JTextField();
                                tu7.setBounds(100, 50, 300, 30);
                                JLabel jti1=new JLabel();
                                jti1.setBounds(420,50,100,30);
                                jti1.setForeground(Color.red);

                                JLabel ju8 = new JLabel("رشته");
                                ju8.setBounds(1, 100, 300, 30);
                                JTextField tu8 = new JTextField();
                                tu8.setBounds(100, 100, 300, 30);
                                JLabel jti2=new JLabel();
                                jti2.setBounds(420,100,100,30);
                                jti2.setForeground(Color.red);
                                //////////////////////////////////////////////////////////
                                JLabel label = new JLabel();
                                label.setBounds(50, 300, 200, 50);
                                label.setForeground(Color.blue);
                                ////////////////////////////////////////////////////////
                                jFrame8.add(ju7);
                                jFrame8.add(tu7);
                                jFrame8.add(ju8);
                                jFrame8.add(tu8);
                                jFrame8.add(tu8);
                                jFrame8.add(jti1);
                                jFrame8.add(jti2);
                                jFrame8.add(label);
                                ///////////////////////////////////////////////////
                                JButton jbu9 = new JButton("ثبت");
                                jbu9.setBounds(100, 200, 50, 50);
                                jbu9.setBackground(Color.orange);
                                jFrame8.add(jbu9);
                                /////////////////////دکمه ثبت//////////////////////
                                jbu9.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String D = "";
                                        /////کادر خالی نباشد//
                                        if(tu7.getText().equals(D) && tu8.getText().equals(D) ){
                                            jti1.setText("لطفا پر کنید...");
                                            jti2.setText("لطفا پر کنید...");
                                        }
                                        else if (tu7.getText().equals(D)) {
                                            jti1.setText("لطفا پر کنید...");
                                            jti2.setText("");
                                        }
                                        else if(tu8.getText().equals(D)) {
                                            jti2.setText("لطفا پر کنید...");
                                            jti1.setText("");
                                        }
                                        else {
                                            int id = Integer.parseInt(tu7.getText());
                                            String name = tu8.getText();

                                            StudentContr s = null;
                                            ArrayList<StudentEntity> list1 = null;

                                            try {
                                                s = new StudentContr();
                                                list1 = s.report_all();
                                            } catch (Exception e1) {
                                                e1.printStackTrace();
                                            }
                                            ////////////////////////////////
                                            boolean o = false;
                                            for (StudentEntity a : list1) {
                                                if (a.getSid() == id) {
                                                    o = true;
                                                    break;
                                                } else {
                                                    o = false;
                                                }
                                            }
                                            ///////////////////////////////
                                            if (o == true) {
                                                new StudentContr().update_field(id, name);
                                                jti1.setText("");
                                                jti2.setText("");
                                                label.setText("با موفقیت تغییر یافت...");
                                            } else if (o == false) {
                                                jti1.setText("");
                                                jti2.setText("");
                                                label.setText("این شماره دانش آموزی موجود نمی باشد...");
                                            }
                                        }
                                    }
                                });
                                        jFrame8.setLayout(null);
                                        jFrame8.setVisible(true);
                                }
                            });
//////////////////////////////////////////////////////به روز رسانی تاریخ تولد///////////////////////////////////////////
                        jr9.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame jFrame9 = new JFrame();
                                jFrame9.setLocation(700, 0);
                                jFrame9.setSize(700, 700);
                                //////////////////////////////////////////////
                                JLabel jq2 = new JLabel("شماره دانش اموزی");
                                jq2.setBounds(1, 50, 300, 30);
                                JTextField tq2 = new JTextField();
                                tq2.setBounds(100, 50, 300, 30);
                                JLabel jti1=new JLabel();
                                jti1.setBounds(420,50,100,30);
                                jti1.setForeground(Color.red);

                                JLabel jq3 = new JLabel("تاریخ تولد");
                                jq3.setBounds(1, 100, 300, 30);
                                JTextField tq3 = new JTextField();
                                tq3.setBounds(100, 100, 300, 30);
                                JLabel jti2=new JLabel();
                                jti2.setBounds(420,100,100,30);
                                jti2.setForeground(Color.red);
                                //////////////////////////////////////////////////////////
                                JLabel label = new JLabel();
                                label.setBounds(50, 300, 200, 50);
                                label.setForeground(Color.blue);
                                //////////////////////////////////////////////////////
                                jFrame9.add(jq2);
                                jFrame9.add(tq2);
                                jFrame9.add(jq3);
                                jFrame9.add(tq3);
                                jFrame9.add(jti1);
                                jFrame9.add(jti2);
                                jFrame9.add(label);
                                ///////////////////////////////////////////////////
                                JButton jbq1 = new JButton("ثبت");
                                jbq1.setBounds(100, 200, 50, 50);
                                jbq1.setBackground(Color.orange);
                                jFrame9.add(jbq1);
                                ////////////////////////ثبت/////////////////
                                jbq1.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String D = "";
                                        /////کادر خالی نباشد//
                                        if(tq2.getText().equals(D) && tq3.getText().equals(D) ){
                                            jti1.setText("لطفا پر کنید...");
                                            jti2.setText("لطفا پر کنید...");
                                        }
                                        else if (tq2.getText().equals(D)) {
                                            jti1.setText("لطفا پر کنید...");
                                            jti2.setText("");
                                        }
                                        else if(tq3.getText().equals(D)) {
                                            jti2.setText("لطفا پر کنید...");
                                            jti1.setText("");
                                        }
                                        else {
                                            int id = Integer.parseInt(tq2.getText());
                                            String name = tq3.getText();
                                            //////////////////////////
                                            StudentContr s = null;
                                            ArrayList<StudentEntity> list1 = null;

                                            try {
                                                s = new StudentContr();
                                                list1 = s.report_all();
                                            } catch (Exception e1) {
                                                e1.printStackTrace();
                                            }
                                            ////////////////////////////////
                                            boolean o = false;
                                            for (StudentEntity a : list1) {
                                                if (a.getSid() == id) {
                                                    o = true;
                                                    break;
                                                } else {
                                                    o = false;
                                                }
                                            }
                                            ///////////////////////////////
                                            if (o == true) {
                                                new StudentContr().update_birthday(id, name);
                                                label.setText("با موفقیت تغییر یافت...");
                                                jti1.setText("");
                                                jti2.setText("");
                                            }
                                            else if (o == false) {
                                                label.setText("این شماره دانش آموزی موجود نمی باشد...");
                                                jti1.setText("");
                                                jti2.setText("");
                                            }
                                        }
                                    }
                                });
                                jFrame9.setLayout(null);
                                jFrame9.setVisible(true);
                            }
                        });
////////////////////////////////////////////////////به روز رسانی مقطع تحصیلی////////////////////////////////////////////
                        jr0.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                JFrame jFrame0 = new JFrame();
                                jFrame0.setLocation(700, 0);
                                jFrame0.setSize(700, 700);
                                /////////////////////////////////////////////////////////
                                JLabel jq2 = new JLabel("شماره دانش اموزی");
                                jq2.setBounds(1, 50, 300, 30);
                                JTextField tq2 = new JTextField();
                                tq2.setBounds(100, 50, 300, 30);
                                JLabel jti1=new JLabel();
                                jti1.setBounds(420,50,100,30);
                                jti1.setForeground(Color.red);

                                JLabel jq3 = new JLabel("مقطع تحصیلی");
                                jq3.setBounds(1, 100, 300, 30);
                                JTextField tq3 = new JTextField();//name
                                tq3.setBounds(100, 100, 300, 30);
                                JLabel jti2=new JLabel();
                                jti2.setBounds(420,100,100,30);
                                jti2.setForeground(Color.red);
                                //////////////////////////////////////////////////////////
                                JLabel label = new JLabel();
                                label.setBounds(50, 300, 200, 50);
                                label.setForeground(Color.blue);
                                //////////////////////////////////////////////////////
                                jFrame0.add(jq2);
                                jFrame0.add(tq2);
                                jFrame0.add(jq3);
                                jFrame0.add(tq3);
                                jFrame0.add(jti1);
                                jFrame0.add(jti2);
                                jFrame0.add(label);
                                ///////////////////////////////////////////////////
                                JButton jbq1 = new JButton("ثبت");
                                jbq1.setBounds(100, 200, 50, 50);
                                jbq1.setBackground(Color.orange);
                                jFrame0.add(jbq1);
                                ////////////////////////ثبت//////////////////////////
                                jbq1.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent e) {
                                        String D = "";
                                        /////کادر خالی نباشد//
                                        if(tq2.getText().equals(D) && tq3.getText().equals(D) ){
                                            jti1.setText("لطفا پر کنید...");
                                            jti2.setText("لطفا پر کنید...");
                                        }
                                        else if (tq2.getText().equals(D)) {
                                            jti1.setText("لطفا پر کنید...");
                                            jti2.setText("");
                                        }
                                        else if(tq3.getText().equals(D)) {
                                            jti2.setText("لطفا پر کنید...");
                                            jti1.setText("");
                                        }
                                        else {
                                            int id = Integer.parseInt(tq2.getText());
                                            String name = tq3.getText();

                                            StudentContr s = null;
                                            ArrayList<StudentEntity> list1 = null;

                                            try {
                                                s = new StudentContr();
                                                list1 = s.report_all();
                                            } catch (Exception e1) {
                                                e1.printStackTrace();
                                            }
                                            ////////////////////////////////
                                            boolean o = false;
                                            for (StudentEntity a : list1) {
                                                if (a.getSid() == id) {
                                                    o = true;
                                                    break;
                                                } else {
                                                    o = false;
                                                }
                                            }
                                            ///////////////////////////////
                                            if (o == true) {
                                                new StudentContr().update_maghta_tahsil(id, name);
                                                label.setText("با موفقیت تغییر یافت...");
                                                jti1.setText("");
                                                jti2.setText("");
                                            }
                                            else if (o == false) {
                                                label.setText("این شماره دانش آموزی موجود نمی باشد...");
                                                jti1.setText("");
                                                jti2.setText("");
                                            }
                                        }
                                    }
                                });
                                jFrame0.setLayout(null);
                                jFrame0.setVisible(true);
                            }
                        });

                    }
///////////////////////////////////////تو مرحله ورود اگر اطلاعاتش رو اشتباه وارد کرد/////////////////////////////////////
                    else if (R == false) {
                        label.setForeground(Color.red);
                        label.setText("نام کاربری یا رمز عبور اشتباه است");
                    }

                }//else  مربوط به خالی نبودن فیلد های ورود
            }
        });
////////////////////////////////////////////////////////اکر دکمه ثبت نام رو زد//////////////////////////////////////////
                b.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        JFrame frameS = new JFrame("ثبت نام");
                        ///////////////////////////////////////
                        frameS.setSize(500, 600);
                        frameS.setLocation(330, 0);
                        frameS.setLayout(null);
                        frameS.setVisible(true);
                        frameS.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        ///////////////////////////////////////
                        JLabel l1S = new JLabel(" * نام کاربری");// : نام کاربری
                        l1S.setBounds(20, 20, 100, 30);


                        JLabel l2S = new JLabel(" * سمت در مدرسه");// : سمت
                        l2S.setBounds(20, 75, 100, 30);


                        JLabel l3S = new JLabel("* رمز عبور");//: پسورد
                        l3S.setBounds(20, 120, 100, 30);


                        JLabel l4S = new JLabel("* تکرار رمز عبور");//:تکرار پسورد
                        l4S.setBounds(20, 175, 100, 30);

                        //////////////////////////////////////////////////////

                        JTextField textusernmae = new JTextField();//نام کاربری
                        textusernmae.setBounds(130, 20, 100, 30);

                        JTextField textsemat = new JTextField();//سمت در مدرسه
                        textsemat.setBounds(130, 70, 100, 30);

                        JPasswordField value1S = new JPasswordField();//پسورد1
                        value1S.setBounds(130, 120, 100, 30);

                        JPasswordField value2S = new JPasswordField();//تکرار پسورد
                        value2S.setBounds(130, 170, 100, 30);

                        ////////////////////////////////////////////////////////
                        JButton bS = new JButton("ثبت");//دکمه ثبت نام
                        bS.setBounds(150, 250, 80, 50);
                        bS.setBackground(Color.yellow);
                        ///////////////////////////////////////////////////////
                        JLabel labelS = new JLabel();//متن اعلام عملیات موفق
                        labelS.setBounds(300, 300, 200, 50);
                        /////////////////////////تذکر کادر خالی///////////////////
                        JLabel labeln = new JLabel();
                        labeln.setBounds(300, 20, 200, 30);
                        labeln.setForeground(Color.red);

                        JLabel labels = new JLabel();
                        labels.setBounds(300, 65, 200, 50);
                        labels.setForeground(Color.red);

                        JLabel labelp1 = new JLabel();
                        labelp1.setBounds(300, 115, 200, 50);
                        labelp1.setForeground(Color.red);

                        JLabel labelp2 = new JLabel();
                        labelp2.setBounds(300, 165, 200, 50);
                        labelp2.setForeground(Color.red);
                        /////////////////////////////////////////////////////////
                        frameS.add(l1S);
                        frameS.add(l2S);
                        frameS.add(l3S);
                        frameS.add(l4S);
                        frameS.add(textusernmae);
                        frameS.add(textsemat);
                        frameS.add(value1S);
                        frameS.add(value2S);
                        frameS.add(bS);
                        frameS.add(labelS);

                        frameS.add(labeln);
                        frameS.add(labels);
                        frameS.add(labelp1);
                        frameS.add(labelp2);

                        ///////////////////////////دکمه ثبت اطاعات///////////////////////
                        bS.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                String D = "";
                                if (textusernmae.getText().equals(D)) {
                                    labeln.setText("لطفا پر کنید...");
                                    labels.setText("");
                                    labelp1.setText("");
                                    labelp2.setText("");
                                }
                                else if (textsemat.getText().equals(D)) {
                                    labeln.setText("");
                                    labels.setText("لطفا پر کنید...");
                                    labelp1.setText("");
                                    labelp2.setText("");
                                }
                                else if (String.valueOf(value1S.getPassword()).equals(D)) {
                                    labeln.setText("");
                                    labels.setText("");
                                    labelp1.setText("لطفا پر کنید...");
                                    labelp2.setText("");
                                }
                                else if (String.valueOf(value2S.getPassword()).equals(D)) {
                                    labeln.setText("");
                                    labels.setText("");
                                    labelp1.setText("");
                                    labelp2.setText("لطفا پر کنید...");
                                }
                                else {//کادری خالی نباشه...

                                    labeln.setText("");
                                    labels.setText("");
                                    labelp1.setText("");
                                    labelp2.setText("");

                                    String username = textusernmae.getText();
                                    String semat = textsemat.getText();
                                    String userpassword1 = String.valueOf(value1S.getPassword());
                                    String userpassword2 = String.valueOf(value2S.getPassword());

                                    ///////////////////////////////////
                                    Accounts accounts = null;
                                    ArrayList<AccountEntity> list = null;
                                    ///////////////////اکانت های موجود در دیتا بیس به صورت شی در لیست ذخیره شوند///////
                                    try {
                                        accounts = new Accounts();
                                        list = accounts.chek();
                                        accounts.commit();
                                        accounts.close();

                                    } catch (Exception e1) {
                                        e1.printStackTrace();
                                    }

                                    ////////////////////چک شود که رمز عبور و تکرار آن باهم برابر باشد///////////////
                                    boolean v = true;
                                    if (userpassword1.equals(userpassword2)) {
                                        v = true;
                                    } else {
                                        v = false;
                                    }
                                    ///////////////////////چک شود که نام کاربری از قبل موجود نباشد//////////////////////
                                    boolean R = true;
                                    for (AccountEntity a : list) {
                                        String name = a.getUsername();
                                        if (name.equals(null)) {//اولین نفری که ثبت نام میکنه
                                            R = true;
                                        }

                                        if (name.equals(username)) {//نام کاربری قبلا موجود بوده
                                            R = false;
                                            break;//لازم نیست بقیه رو چک کنه دیگه
                                        }
                                        else if (!name.equals(username)) {
                                            R = true;
                                        }
                                    }

                                    ///////////////////////////////////
                                    if (R == true && v == true) {//همه چی درسته//نام کاربری موجود نبوده است
                                        try {
                                            Accounts accounts1 = new Accounts();
                                            AccountEntity a = new AccountEntity();
                                            a.setUsername(username);
                                            a.setPassword(userpassword1);
                                            a.setSemat(semat);
                                            accounts1.insert(a);
                                            accounts1.commit();
                                            accounts1.close();
                                        } catch (Exception e1) {
                                            e1.printStackTrace();
                                        }

                                        labelS.setText("ثبت نام با موفقیت انجام شد ...");

                                    }
                                    else if (R == false) {//نام کاربری از قبل وجود داشته

                                        labelS.setText("نام کاربری قبلا وجود داشته است...");
                                    }
                                    else if (v == false) {//کادر های رمز باهم برابر نبودن
                                        labelS.setText("رمز عبورتان را مجددا وارد کنید...");
                                    }
                                }
                            }
                        });
                    }

                });

            //ساخت table حساب کاربری برای اولین بار(فقط دفعه اول ران بشود)
            /*
            try {
                new Accounts().ctreattable();
            } catch (Exception e) {
                e.printStackTrace();
            }
            */

            //ساخت table مربوط به اطلاعات دانش آموزان مدرسه(فقط دفعه اول ران شود)

            /*
            try {
                new StudentRepo().ctreattable();
            } catch (Exception e) {
                e.printStackTrace();
            }
            */
    }
}
