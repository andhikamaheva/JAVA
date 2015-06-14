import java.util.*;

public class UsrMngV2{
 public static Vector<User> tblUser=new Vector<User>();
 public static Scanner sc=new Scanner(System.in);

 public static void main(String []argc){
  //tambahkan 2 user default
  tblUser.add(new User("root","123"));
  tblUser.add(new User("admin","admin"));

  boolean selesai=false;
  if(!login())
   selesai=true;
  while(!selesai) {
   UsrMngV2.mainMenu();
  int pil=bacaInt("Pilih menu 1-5 : ");
   switch(pil){ 
    case 1:add();break;
    case 2:delete();break;
    case 3:changesPassword();break;
    case 4:viewAllUser();break;
    case 5:selesai=true;break;
   }
  }
 }
 public static int bacaInt(String pesan){
  System.out.print(pesan);  
  int i=sc.nextInt();
  return i;
 }
 public static String bacaStr(String pesan){ 
  System.out.print(pesan);  
  String i=sc.next();
  return i;
 }
 public static void add(){
  System.out.println("---ADD NEW USER---");
  String userName=bacaStr("Masukkan User Name: ");
  String password=bacaStr("Masukkan Password : ");    
  User userBaru=new User(userName,password);
  tblUser.add(userBaru);
 }
 public static void viewAllUser(){
  System.out.println("--VIEW ALL USERS--");
  for(User usr:tblUser)
   System.out.println(usr.getUserName()+"\t"+usr.getPassword());
 }
 private static int cari(String userName){
  int idx=-1;
  int i=0;
  do{
   if(tblUser.elementAt(i).getUserName().equals(userName))
    idx=i;
   i++;
  }while((i<tblUser.size()&&(idx==-1)));
  return idx;    
 }
 public static void delete(){
  System.out.println("--DELETE USER--");
  String userName=bacaStr("Masukkan user name yang akan dihapus: ");  
  int idx=cari(userName);
  if(idx==-1)
   System.out.println(userName+" Tidak ada di Tabel User !");  
  else{
   //apakah username tsb akan dihapus? jika ya removeElementAt(idx);  
   String hapus=bacaStr("Apakah user: " + userName +" akan dihapus [y/t]?");
   if(hapus.equalsIgnoreCase("y")){
    tblUser.removeElementAt(idx);
System.out.println("User : " + userName + " Sudah Terhapus !"); 
         
   }
  }   
 }
 public static void changesPassword(){
  System.out.println("--CHANGES PASSWORD--");
  String uname=bacaStr("Masukkan user name yang akan diuabah : "); 
  int idx=cari(uname);  
  if(idx==-1)
   System.out.println(uname + " Tidak ada di tabel User !");
  else{
   String newPass=bacaStr("Masukkan password baru: ");
   tblUser.elementAt(idx).setPassword(newPass); 
  }   
 }
 public static boolean login(){
  boolean oke=false;
  int i=0;
  do{    
  System.out.println("----LOGIN----");
  String uName=bacaStr("Masukkan user name: ");
  String pass=bacaStr("Masukkan password : ");
  int j=0;
  do{
   if(tblUser.elementAt(j).checkUserPassword(uName,pass)){   
   oke=true;
   j=tblUser.size();
}
   j++;
  }while(j<tblUser.size());
  i++;
  }while((!oke)&&(i<3));
  return oke;
 }
}
