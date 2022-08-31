package com.example.shivamapplication.jsondemo;

import java.util.jar.Attributes;
class fetch {
  private String Id;
  private String First_Name;
  private String Last_Name;
  private String Country;
  private String State;


    public fetch(){

  }
    public fetch(String Id,String First_Name,String Last_Name,String Country,String State){
        this.Id = Id;
        this.First_Name = First_Name;
        this.First_Name = Last_Name;
        this.First_Name = Country;
        this.First_Name = State;

    }
    public String getId(){
        return Id;
    }

    public void set_Id(String Id){
        this.Id = Id;
    }

    public String getFirst_Name(){
        return First_Name;
    }
    public void setFirst_Name(String First_Name){
        this.First_Name = First_Name;
    }

    public String getLast_Name(){
        return Last_Name;
    }
    public void setLast_Name(String Last_Name){
        this.Last_Name = Last_Name;
    }

    public String getCountry(){
        return Country;
    }
    public void setCountry(String Country){
        this.Country = Country;
    }

    public String getState(){
        return State;
    }
    public void setState(String State){
        this.State = State;
    }

}

