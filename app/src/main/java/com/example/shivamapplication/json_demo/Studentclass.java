package com.example.shivamapplication.json_demo;

public class Studentclass {
    private  String ID ;
    private  String F_Name ;
    private  String M_Name ;
    private  String L_Name ;
    private  String Grade ;


    public Studentclass(String ID, String f_Name, String m_Name, String l_Name, String grade) {
        this.ID = ID;
        F_Name = f_Name;
        M_Name = m_Name;
        L_Name = l_Name;
        Grade = grade;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getF_Name() {
        return F_Name;
    }

    public void setF_Name(String f_Name) {
        F_Name = f_Name;
    }

    public String getM_Name() {
        return M_Name;
    }

    public void setM_Name(String m_Name) {
        M_Name = m_Name;
    }

    public String getL_Name() {
        return L_Name;
    }

    public void setL_Name(String l_Name) {
        L_Name = l_Name;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }

    public Studentclass() {

    }
}

