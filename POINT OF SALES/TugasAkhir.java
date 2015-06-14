import java.io.*;
import java.util.*;


public class TugasAkhir {
  
  public static Vector<User> Usr1 = new Vector<User>();
  public static Vector<Barang> Barang = new Vector<Barang>();
  
  public static void main(String [] argx) throws IOException{
  BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
  
 //Database user awal
  Usr1.add(new User(1,"admin","admin"));
  Usr1.add(new User(2,"andhika","andhika"));
  Usr1.add(new User(3,"raysa","raysa"));
  
  Barang.add(new Barang(1,"Apel",10,8000,10000));
  
  String cekusr="";
  String cekpas="";
  int ulang=0;
  boolean log = true;
  
  //Pilihan untuk menu
  int pil = 0;
  int pil2 = 0;
  int pil3 = 0;
  String jawab;
  
  //Others Variabel
  String name="";
  String pass="";
  int idk=0;
  int error=0;
  
  //Variabel untuk Barang
  String namab="";
  int stock;
  int hargab;
  int hargaj;
  
  do{
  System.out.println("====================================");
  System.out.println("\"Toko Buah Laris Manis\"");
  System.out.println("Jln. Kedung Baruk No.98");
  System.out.println("====================================");
  System.out.println("LOGIN ADMINISTRATOR");
    
  
  do{
  ulang++;
  System.out.print("Username : ");
  cekusr=in.readLine();
  System.out.print("Password : ");
  cekpas=in.readLine();
  log=User.cekUser(cekusr,cekpas);
  if((ulang>=4) && (log!=true)){
  System.exit(0);
  }
  
  }while(log!=true);
  
  User.cekOtoritas(cekusr);
  ulang=0;
  //Menu untuk Administrator
  if(User.menu==1){
    do{
  System.out.println("1. Manage Kasir");
  System.out.println("2. Manage Barang");
  System.out.println("3. Report Penjualan");
  System.out.println("4. Logout");
  pil = Integer.parseInt(in.readLine());
  
  //Menu Manage Kasir
  switch(pil){
    case 1:
      do{
      System.out.println("1. Lihat Kasir");
      System.out.println("2. Tambah kasir");
      System.out.println("3. Ganti Password kasir");
      System.out.println("4. Hapus Kasir");
      System.out.println("5. Kembali");
      pil2 = Integer.parseInt(in.readLine());
      //Sub menu Manage Kasir
      switch(pil2){
        case 1:
          System.out.println("ID\tUsername\tOtoritas");
          String oto="";
          for(int i=0;i<Usr1.size();i++){
          if(Usr1.elementAt(i).getId()==1){
            oto="Administrator";
          }
          else {
            oto="Kasir";
          }
          System.out.println(Usr1.elementAt(i).getId()+"\t"+Usr1.elementAt(i).getUser()+"\t"+oto);
        }
          idk=0;
          break;
        case 2:
          error=0;
          idk=Usr1.size()+1;
          for(int i=0;i<Usr1.size();i++){
            if(idk==Usr1.elementAt(i).getId()){
            idk++;
            }
          }
          
          do{
            ulang=0;
          System.out.print("Masukkan Username Kasir : ");
          name = in.readLine();
            for(int i=0;i<Usr1.size();i++){
            if(!name.equalsIgnoreCase(Usr1.elementAt(i).getUser())){
            idk = i;
            error=59;
            ulang=5;
            }
            else{
            System.out.println("Maaf username yang Anda masukkan sudah ada di Database!");
            }
          }
          }while(ulang<5);
          if(ulang==5){
          System.out.print("Masukkan Password : ");
          pass = in.readLine();
          Usr1.add(new User(idk, name, pass));
          }
          break;
        case 3:
          System.out.print("Cari ID Kasir yang akan dirubah : ");
          int cari = Integer.parseInt(in.readLine());
          for(int i=0;i<Usr1.size();i++){
            if(cari==Usr1.elementAt(i).getId()){
            idk = i;
            error=1;
            }
          }
           if(error==0) {
            System.out.println("ID Yang Anda Masukkan tidak ada");
            }
           System.out.println("Data yang akan dirubah adalah "+Usr1.elementAt(idk).getUser());
          ulang=0;
          
          do{
          System.out.print("Masukkan Password lama : ");
            pass = in.readLine();
          if(pass.equalsIgnoreCase(Usr1.elementAt(idk).getPass())){
            ulang=5;
          }
          else{
          ulang++;  
          }
           }while(ulang<4);
           if(ulang==4){
           System.exit(0);
           }
           System.out.print("Masukkan Password Baru : ");
           pass = in.readLine();
           Usr1.elementAt(idk).setPassword(pass);
          break;
        case 4:
          System.out.print("Cari ID Kasir yang akan dihapus : ");
          cari = Integer.parseInt(in.readLine());
          if (cari==1){
          System.out.println("Anda tidak dapat menghapus Administrator");
          }
          if(cari!=1){
          for(int i=0;i<Usr1.size();i++){
            if(cari==Usr1.elementAt(i).getId()){
            idk = i;
            error=1;
            }
          }
          
           if(error==0) {
            System.out.println("ID Yang Anda Masukkan tidak ada");
            }
          System.out.println("Data Kasir yang akan dihapus adalah "+Usr1.elementAt(idk).getUser());
          System.out.print("Apakah Anda yakin ? (Y / N) : ");
          jawab = in.readLine();
          if(jawab.equalsIgnoreCase("Y")){
          Usr1.removeElementAt(idk);
          }
          }
          ulang=0;
          break;
      }
    }while(pil2<5);
      break;
    case 2:
      System.out.println("Manage Barang");
      
      do{
      System.out.println("1. Tambah Data Buah");
      System.out.println("2. Delete Data Buah");
      System.out.println("3. Update Data Buah");
      System.out.println("4. Lihat Data Buah");
      System.out.println("5. Kembali");
      pil3 = Integer.parseInt(in.readLine());
      
      switch(pil3){
        case 1:
          
          do{
          idk=Barang.size()+1;
          error=9;
          for(int i=0;i<Barang.size();i++){
            if(idk==Barang.elementAt(i).getIdB()){
            idk++;
            }
          }
          System.out.print("Masukkan nama Buah : ");
          namab = in.readLine();
          for(int i=0;i<Barang.size();i++){
            if(namab.equalsIgnoreCase(Barang.elementAt(i).getNama())){
            System.out.println("Nama Buah "+namab+" Sudah ada didalam Databse. Apakah akan update barang ? (Y/N)");
            jawab = in.readLine();
            if(jawab.equalsIgnoreCase("y")){
           System.out.println("Nama Buah yang akan diedit adalah "+Barang.elementAt(i).getNama());
          do{
          error=1;
          System.out.println("Masukkan Field Yang akan diupdate : ");
          System.out.println("1. Stock Buah"); 
          System.out.println("2. Harga Beli");
          System.out.println("3. Harga Jual");
          System.out.println("4. Save");
          pil = Integer.parseInt(in.readLine());
          
          switch(pil){
            case 1 :
              System.out.print("Jumlah Stock update : ");
              stock = Integer.parseInt(in.readLine());
              Barang.elementAt(i).setStock(stock);
              break;
            case 2:
              System.out.print("Harga Beli update : ");
              hargab = Integer.parseInt(in.readLine());
              Barang.elementAt(i).setHbeli(hargab);
              break;
            case 3:
              System.out.print("Harga Jual update : ");
              hargaj = Integer.parseInt(in.readLine());
              Barang.elementAt(i).setHjual(hargaj);
              break;
          }
          }while(pil<4);
          System.out.println("Update Berhasil Disimpan!");
            }
           if(jawab.equalsIgnoreCase("n")){
             error=3;
             break;
           }
             
            }
            
             else if(!namab.equalsIgnoreCase(Barang.elementAt(i).getNama()) ) {
              error=9;
            }
            }
          if(error==9){
          System.out.print("Masukkan stock Buah : ");
          stock = Integer.parseInt(in.readLine());
          System.out.print("Masukkan Harga Beli : ");
          hargab = Integer.parseInt(in.readLine());
          System.out.print("Masukkan Harga Jual : ");
          hargaj = Integer.parseInt(in.readLine());
          Barang.add(new Barang(idk,namab,stock,hargab,hargaj));
          }
          System.out.print("Masukkan Data Buah lagi ? (Y/N) : ");
          jawab = in.readLine();
        }while(!jawab.equalsIgnoreCase("n"));
          break;
        case 2:
          do{
          do{
          idk=0;
          error=0;
          System.out.print("Cari Nama Buah yang akan dihapus : ");
          namab = in.readLine();
          for(int i=0;i<Barang.size();i++){
            if(namab.equalsIgnoreCase(Barang.elementAt(i).getNama())){
            idk = i;
            error=2;
            ulang=5;
            }
          }
           if(error==0) {
            System.out.println("Nama Buah yang Anda Masukkan Tiidak Ada");
            }
        }while(ulang!=5);
        if(error==2){
          System.out.println("Nama Buah yang akan dihapus adalah "+Barang.elementAt(idk).getNama());
          System.out.print("Apakah Anda yakin ? (Y / N) : ");
          jawab = in.readLine();
          if(jawab.equalsIgnoreCase("Y")){
          Barang.removeElementAt(idk);
          }
        }
          System.out.print("Hapus Data Buah lagi ? (Y/N) : ");
          jawab = in.readLine();
          }while(!jawab.equalsIgnoreCase("n"));
          ulang=0;
           
          break;
        case 3:
         
          do{
          do{
           error=0;
           ulang=0;
          System.out.print("Cari Nama Buah yang akan diupdate : ");
          namab = in.readLine();
          for(int i=0;i<Barang.size();i++){
            if(namab.equalsIgnoreCase(Barang.elementAt(i).getNama())){
            idk = i;
            error=1;
            ulang=5;
            }
          }
           if(error==0) {
            System.out.println("Nama Buah yang Anda Masukkan Tidak Ada");
            }
        }while(ulang!=5);
        if(error==1){
          System.out.println("Nama Buah yang akan diedit adalah "+Barang.elementAt(idk).getNama());
          do{
          System.out.println("Masukkan Field Yang akan diupdate : ");
          System.out.println("1. Stock Buah"); 
          System.out.println("2. Harga Beli");
          System.out.println("3. Harga Jual");
          System.out.println("4. Save");
          pil = Integer.parseInt(in.readLine());
          
          switch(pil){
            case 1 :
              System.out.print("Jumlah Stock update : ");
              stock = Integer.parseInt(in.readLine());
              Barang.elementAt(idk).setStock(stock);
              break;
            case 2:
              System.out.print("Harga Beli update : ");
              hargab = Integer.parseInt(in.readLine());
              Barang.elementAt(idk).setHbeli(hargab);
              break;
            case 3:
              System.out.print("Harga Jual update : ");
              hargaj = Integer.parseInt(in.readLine());
              Barang.elementAt(idk).setHjual(hargaj);
              break;
          }
          }while(pil<4);
          System.out.println("Update Berhasil Disimpan!");
        }
          System.out.print("Update Buah lagi ? (Y/N) : ");
          jawab = in.readLine();
          }while(!jawab.equalsIgnoreCase("n"));
          ulang=0;
          
          break;
        case 4 :
          System.out.println("ID\tNama Buah\t\tStock(Kg)\tHarga Beli\t\tHarga Jual");
          for(int i=0;i<Barang.size();i++){
        System.out.println(Barang.elementAt(i).getIdB()+"\t"+Barang.elementAt(i).getNama()+"\t\t"+Barang.elementAt(i).getStock()+"\t"+Barang.elementAt(i).getHbeli()+"\t\t"+Barang.elementAt(i).getHjual());
        }
          break;
      }
      }while(pil3<5);
      break;
    case 3:
      break;
  
  }
    }while(pil<4);
  }
  
  //Menu Untuk Kasir
   if(User.menu==2){
     do{
  System.out.println("1. Point Of Sale");
  System.out.println("2. Penjualan Harian");
  System.out.println("3. Logout");
  pil = Integer.parseInt(in.readLine());
  
  switch(pil){
    case 1:
      break;
    case 2:
      break;
  }
  }while(pil<3);
  
   }
  }while(true);
  }
}