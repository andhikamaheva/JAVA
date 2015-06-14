import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class User {
  
  private int id;
  public String username;
  private String password;
  
  //Validasi Otoritas User
  public static boolean benar=false;
  private static int ad;
  public static int menu=0;
    
  public User (int id, String username, String password) {
    this.id=id; 
    this.username=username;
    this.password=password;
    
  }

  public int getId(){
  return id;
  }
  
  public String getUser(){
  return username;
  }
  
  public String getPass(){
  return password;
  }
  
  public void setPassword(String pass){
  password=pass;
  }
  
  public static boolean cekUser(String username, String password ){
    
    int error=0;
    for(int i=0;i<TugasAkhir.Usr1.size();i++){
      if((username.equalsIgnoreCase(TugasAkhir.Usr1.elementAt(i).getUser())) && (password.equalsIgnoreCase(TugasAkhir.Usr1.elementAt(i).getPass()))){
      error++;
      benar=true;
      ad=i;
      }
  }
    if(error==0){
    System.out.println("Username atau password Anda salah");
    benar=false;
    }
    return (benar);
    
    
  }
  
  public static void cekOtoritas(String username){
    if(benar=true){
        if(ad==0){
        System.out.println("Selamat Datang "+username+",\nAnda login sebagai administrator");
        menu=1;
        }
      
       if (ad>0){
        System.out.println("Selamat Datang "+username+",\nAnda login sebagai Kasir");
        menu=2;
        }
    }
    
    }
  
  }
         
  
  

