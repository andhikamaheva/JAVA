import java.io.*;
import java.util.*;
import java.text.*;

public class TugasAkhir {
  

  public static Vector<User> Usr1 = new Vector<User>();
  public static Vector<Barang> Barang = new Vector<Barang>();
  public static Vector<DTransaksi> DTransaksi = new Vector<DTransaksi>();
  public static Vector<Transaksi> Transaksi = new Vector<Transaksi>();
  
  public static void main(String [] argx) throws IOException{
  BufferedReader in = new BufferedReader (new InputStreamReader(System.in));
  
 //Database user awal
 SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
 Date date1 = new Date();
 String date = dateFormat.format(date1); 
 
  
  Usr1.add(new User(1,"admin","admin"));
  Usr1.add(new User(2,"andhika","andhika"));
  Usr1.add(new User(3,"raysa","raysa"));
  
  Barang.add(new Barang(1,"Apel",10.0,8000.0,10000.0));
  
  String cekusr="";
  String cekpas="";
  Console console = System.console();
  int ulang=0;
  boolean log = true;
  int cari;
  Double jumlah;
  int trans=0;
  int max=0;
  
  //Pilihan untuk menu
  int pil = 0;
  int pil2 = 0;
  int pil3 = 0;
  int pil4 = 0;
  int pil5 = 0;
  int pil6 = 0;
  int pil7 = 0;
  int pil8 = 0;
  String jawab;
  
  //Others Variabel
  String name="";
  String pass="";
  int idk=0;
  int idx=0;
  int error=0;
  
  //Variabel untuk Barang
  String namab="";
  Double stock;
  Double hargab;
  Double hargaj;
  
  //Variabel PointOfSale
  String namaD;
  Double hargaD;
  int idDtr;
  Double subD;
  Double totalD = 0.0;
  Double uang;
  Double akhir;
  Double keuntungan = 0.0;
  Double kuantitas;
  Double hargastart;
  Double beliD;
  Double totk=0.0;
  Double totk2=0.0;
  Double totb=0.0;
  Double totb2=0.0;
  Double totd=0.0;
  
  
  do{
 System.out.println("====================================");
 System.out.println("\tToko Buah Laris Manis\"");
 System.out.println("\tJln. Kedung Baruk No.98");
 System.out.println("====================================");
 //System.out.println("Time Server : " +date);
    
    do{
     ulang++;
     System.out.print("Username : ");
     cekusr=in.readLine();
     System.out.print("Password : ");
     char[] password = console.readPassword();
     cekpas = new String(password);
     log=User.cekUser(cekusr,cekpas);
     if((ulang>=4) && (log!=true)){
     System.exit(0);
     }
    
    }while(log!=true);
 System.out.println();
 System.out.println();
 System.out.println();
 User.cekOtoritas(cekusr);
 ulang=0;
 
 //Menu untuk Administrator
 if(User.menu==1){
    do{
  System.out.println();
  System.out.println();
  System.out.println("1. Manage Kasir");
  System.out.println("2. Manage Barang");
  System.out.println("3. Report Penjualan");
  System.out.println("4. Logout");
  System.out.print("Pilihan Anda : ");
  pil = Integer.parseInt(in.readLine());
 //Menu Manage Kasir
 switch(pil){
    case 1:
      do{
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("1. Lihat Kasir");
      System.out.println("2. Tambah kasir");
      System.out.println("3. Ganti Password kasir");
      System.out.println("4. Hapus Kasir");
      System.out.println("5. Kembali");
      System.out.print("Pilihan Anda : ");
      pil2 = Integer.parseInt(in.readLine());
      //Sub menu Manage Kasir
      switch(pil2){
        case 1:
          System.out.println();
          System.out.println();
          System.out.println("ID\tUsername\tOtoritas");
          String oto="";
          for(int i=0;i<Usr1.size();i++){
          if(Usr1.elementAt(i).getId()==1){
            oto="Administrator";
          }
          else {
            oto="Kasir";
          }
          System.out.println(Usr1.elementAt(i).getId()+"\t"+Usr1.elementAt(i).getUser()+"\t\t"+oto);
        }
          idk=0;
          break;
        case 2:
      System.out.println();
      System.out.println();
          error=1;
          
          ulang=0;
          do{
          log=true;
          System.out.print("Masukkan Username Kasir : ");
          name = in.readLine();
          for(int i=0;i<Usr1.size();i++){
            if(!Usr1.elementAt(i).getUser().equalsIgnoreCase(name)){

            ulang=5;
            
            }
            else{

            ulang=0;
            log=false;
            System.out.println("Username yang Anda masukkan telah ada di database!");
            }
          }
       }while(log!=true);
         
          idk=Usr1.size()+1;
          for(int i=0;i<Usr1.size();i++){
            if(idk==Usr1.elementAt(i).getId()){
            idk++;
            }
          }
          if(log==true){
          System.out.print("Masukkan Password : ");
          char[] password = console.readPassword();
          pass = new String (password);
          Usr1.add(new User(idk, name, pass));
          }
          break;
        case 3:
      System.out.println();
      System.out.println();
          System.out.print("Cari ID Kasir yang akan dirubah : ");
          cari = Integer.parseInt(in.readLine());
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
          char[] password = console.readPassword();
          pass = new String(password);
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
           char[] password = console.readPassword();
           pass = new String(password);
           Usr1.elementAt(idk).setPassword(pass);
          break;
        case 4:
          System.out.println();
          System.out.println();
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
      System.out.println();
      System.out.println();
      System.out.println();
      System.out.println("1. Tambah Data Buah");
      System.out.println("2. Delete Data Buah");
      System.out.println("3. Update Data Buah");
      System.out.println("4. Lihat Data Buah");
      System.out.println("5. Kembali");
      System.out.print("Pilihan Anda : ");
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
          System.out.println();
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
          System.out.println();
          System.out.println();
          System.out.println("Masukkan Field Yang akan diupdate : ");
          System.out.println("1. Stock Buah"); 
          System.out.println("2. Harga Beli");
          System.out.println("3. Harga Jual");
          System.out.println("4. Save");
          System.out.print("Pilihan Anda : ");
          pil5 = Integer.parseInt(in.readLine());
          
          switch(pil5){
            case 1 :
              System.out.print("Jumlah Stock update : ");
              stock = Double.parseDouble(in.readLine());
              Barang.elementAt(i).setStock(stock);
              break;
            case 2:
              System.out.print("Harga Beli update : ");
              hargab = Double.parseDouble(in.readLine());
              Barang.elementAt(i).setHbeli(hargab);
              break;
            case 3:
              System.out.print("Harga Jual update : ");
              hargaj = Double.parseDouble(in.readLine());
              Barang.elementAt(i).setHjual(hargaj);
              break;
          }
          }while(pil5<4);
          System.out.println("Update Berhasil Disimpan!");
          error=0;
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
          stock = Double.parseDouble(in.readLine());
          System.out.print("Masukkan Harga Beli : ");
          hargab = Double.parseDouble(in.readLine());
          System.out.print("Masukkan Harga Jual : ");
          hargaj = Double.parseDouble(in.readLine());
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
          System.out.println();
          System.out.println();
          System.out.println("Masukkan Field Yang akan diupdate : ");
          System.out.println("1. Stock Buah"); 
          System.out.println("2. Harga Beli");
          System.out.println("3. Harga Jual");
          System.out.println("4. Save");
          System.out.print("Pilihan Anda : ");
          pil6 = Integer.parseInt(in.readLine());
          
          switch(pil6){
            case 1 :
              
              System.out.print("Jumlah Stock update : ");
              stock = Double.parseDouble(in.readLine());
              Barang.elementAt(idk).setStock(stock);
              break;
            case 2:
              System.out.print("Harga Beli update : ");
              hargab = Double.parseDouble(in.readLine());
              Barang.elementAt(idk).setHbeli(hargab);
              break;
            case 3:
              System.out.print("Harga Jual update : ");
              hargaj = Double.parseDouble(in.readLine());
              Barang.elementAt(idk).setHjual(hargaj);
              break;
          }
          }while(pil6<4);
          System.out.println("Update Berhasil Disimpan!");
        }
          System.out.print("Update Buah lagi ? (Y/N) : ");
          jawab = in.readLine();
          }while(!jawab.equalsIgnoreCase("n"));
          ulang=0;
          
          break;
        case 4 :
          System.out.println();
          System.out.println();
          System.out.println("ID\tNama Buah\tStock(Kg)\tHarga Beli\tHarga Jual");
          for(int i=0;i<Barang.size();i++){
        System.out.println(Barang.elementAt(i).getIdB()+"\t"+Barang.elementAt(i).getNama()+"\t\t"+(Barang.elementAt(i).getStock())+"\t\t"+Barang.elementAt(i).getHbeli()+"\t\t"+Barang.elementAt(i).getHjual());
        }
          break;
      }
      }while(pil3<5);
      break;
    case 3:
      System.out.println("====================================");
      System.out.println("          Report Penjualan          ");
      System.out.println("====================================");
      do{
      System.out.println();
      System.out.println();
      System.out.println("1. Stock Barang");
      System.out.println("2. Laporan Penjualan Keuntungan");
      System.out.println("3. Kembali");
      System.out.print("Pilihan Anda : ");
      pil4 = Integer.parseInt(in.readLine());
      switch(pil4){
        case 1:
        System.out.println("ID\tNama Buah\tStock(Kg)");
        for(int i=0;i<Barang.size();i++){
        System.out.println(Barang.elementAt(i).getIdB()+"\t"+Barang.elementAt(i).getNama()+"\t\t"+Barang.elementAt(i).getStock());
        }
          break;
        case 2:
          do{
          System.out.println();
          System.out.println();
          System.out.println("1. Penjualan Keseluruhan");
          System.out.println("2. Penjualan Pencarian Kasir");
          System.out.println("3. Keuntungan Berdasar Jenis Buah");
          System.out.println("4. Kembali");
          System.out.print("Pilihan Anda : ");
          pil8 = Integer.parseInt(in.readLine());
          switch(pil8){
            case 1:
      System.out.println("====================================");
      System.out.println("       PENJUALAN KESELURUHAN        ");
      System.out.println("====================================");
              
     for(int i=0;i<Transaksi.size();i++){
      System.out.println("-----------------------------------------------------");
      System.out.println("Order No.\t: "+ Transaksi.elementAt(i).getIdTr());
      System.out.println("Nama Kasir\t: "+ Transaksi.elementAt(i).getKasir());
      System.out.println("Tanggal\t\t: "+ Transaksi.elementAt(i).getTglTr());
      System.out.println("-----------------------------------------------------");
       System.out.println();
      System.out.println("ID\tNama Buah\t\tHarga\tJumlah\tTotal");
      
         for(int x=0;x<DTransaksi.size();x++){
           if(DTransaksi.elementAt(x).getIdDtr()==Transaksi.elementAt(i).getIdTr()){
           System.out.println(DTransaksi.elementAt(x).getIdBarang()+"\t"+DTransaksi.elementAt(x).getNamaD()+"\t\t"+DTransaksi.elementAt(x).getHargaD()+"\t"+DTransaksi.elementAt(x).getJumlah()+"\t"+DTransaksi.elementAt(x).getSubD());
           totalD+=DTransaksi.elementAt(x).getTotalD();
           totb+=DTransaksi.elementAt(x).getJumlah();
           keuntungan += (DTransaksi.elementAt(x).getHargaD()-DTransaksi.elementAt(x).getBeliD())*DTransaksi.elementAt(x).getJumlah();
           }
         }
         System.out.println("Total transaksi :" + totalD);
         totd+=totalD;
         totk+=keuntungan;
         System.out.println("Jumlah Barang terjual : "+totb);
         totb2+=totb;
         System.out.println("Keuntungan Order No. "+Transaksi.elementAt(i).getIdTr() +" adalah  "+ keuntungan);
         keuntungan=0.0;
         totalD=0.0;
         totb=0.0;
         System.out.println();
         System.out.println();
      }
              System.out.println("-------------------------------------");
              System.out.println("Total Transaksi : "+totd);
              System.out.println("Total Barang Terjual : " +totb2);
              System.out.println("Total Keseluruhan Keuntungan :" + totk);
              System.out.println("-------------------------------------");
              totd=0.0;
              totb2=0.0;
              totk=0.0;
              break;
              
            case 2:
              System.out.print("Masukkan Nama Kasir : ");
              jawab = in.readLine();
               
              for(int i=0;i<Transaksi.size();i++){
                if(jawab.equalsIgnoreCase(Transaksi.elementAt(i).getKasir())){
      System.out.println("Order No.\t: "+ Transaksi.elementAt(i).getIdTr());
      System.out.println("Nama Kasir\t: "+ Transaksi.elementAt(i).getKasir());
      System.out.println("Tanggal\t: "+ Transaksi.elementAt(i).getTglTr());
      System.out.println("-----------------------------------------------------");
      System.out.println();
      System.out.println("ID\tNama Buah\t\tHarga\tJumlah\tTotal");
      
         for(int x=0;x<DTransaksi.size();x++){
           if(DTransaksi.elementAt(x).getIdDtr()==Transaksi.elementAt(i).getIdTr()){
           System.out.println(DTransaksi.elementAt(x).getIdBarang()+"\t"+DTransaksi.elementAt(x).getNamaD()+"\t\t"+DTransaksi.elementAt(x).getHargaD()+"\t"+DTransaksi.elementAt(x).getJumlah()+"\t"+DTransaksi.elementAt(x).getSubD());
           totalD+=DTransaksi.elementAt(x).getTotalD();
           totb+=DTransaksi.elementAt(x).getJumlah();
           keuntungan += (DTransaksi.elementAt(x).getHargaD()-DTransaksi.elementAt(x).getBeliD())*DTransaksi.elementAt(x).getJumlah();
           }
         }
         System.out.println("Total transaksi :" + totalD);
         totd+=totalD;
         totk+=keuntungan;
         System.out.println("Jumlah Barang terjual : "+totb);
         totb2+=totb;
         System.out.println("Keuntungan Order No. "+Transaksi.elementAt(i).getIdTr() +" adalah  "+ keuntungan);
         keuntungan=0.0;
         totalD=0.0;
         totb=0.0;
         System.out.println();
         System.out.println();
      }
    }
              System.out.println("-------------------------------------");
              System.out.println("Total Transaksi : Rp. "+totd);
              System.out.println("Total Barang Terjual : " +totb2);
              System.out.println("Total Keseluruhan Keuntungan : Rp. " + totk);
              System.out.println("-------------------------------------");
              totd=0.0;
              totb2=0.0;
              totk=0.0;
              break;
              
            case 3:
              System.out.println();
             System.out.println("ID   Nama Buah\tTerjual\tHarga Beli\tHarga Jual\tKeuntungan");
              for(int i=0;i<Barang.size();i++){
                for(int x=0;x<DTransaksi.size();x++){
                  if(Barang.elementAt(i).getNama().equalsIgnoreCase(DTransaksi.elementAt(x).getNamaD())){
                  totb += DTransaksi.elementAt(x).getJumlah();
                  keuntungan += (DTransaksi.elementAt(x).getHargaD()-DTransaksi.elementAt(x).getBeliD())*DTransaksi.elementAt(x).getJumlah();
                  }
                }
                System.out.println(Barang.elementAt(i).getIdB()+"    "+Barang.elementAt(i).getNama()+"\t"+totb+"\t"+Barang.elementAt(i).getHbeli()+"\t\t"+Barang.elementAt(i).getHjual()+"\t\t"+keuntungan);
                totb=0.0;
                keuntungan=0.0;
              }
              break;
          }
          }while(pil8<3);
        
          break;
        
      
      
      }
      }while(pil4<3);
        break;
      }

    }while(pil<4);
  }
  
  //Menu Untuk Kasir
   if(User.menu==2){
     do{
  System.out.println();
  System.out.println();
  System.out.println("1. Point Of Sale");
  System.out.println("2. Penjualan Harian");
  System.out.println("3. Logout");
  System.out.print("Pilihan Anda : ");
  pil7 = Integer.parseInt(in.readLine());
  
  switch(pil7){
    case 1:
      idk=0;
      error=0;
      System.out.println("====================================");
      System.out.println("          Point Of Sale             ");
      System.out.println("====================================");
      idx=Transaksi.size()+1;
          for(int i=0;i<Transaksi.size();i++){
            if(idk==Transaksi.elementAt(i).getIdTr()){
            idx++;
            }
          }
          
       System.out.println();   
       System.out.println();
       System.out.println("-----------------------------------------------------");
       System.out.println("Order No.\t: "+idx);
       System.out.println("Nama Kasir\t: "+cekusr);
       System.out.println("Tanggal\t\t: " +date);
       System.out.println("-----------------------------------------------------");
       System.out.println();
       Transaksi.add(new Transaksi(idx,date,cekusr));
      do{
        System.out.println("Masukan berupa : ");
        System.out.println("1. ID Buah");
        System.out.println("2. Nama Buah");
        System.out.print("Masukkan 1-2 : ");
        jawab = in.readLine();
        
        System.out.println();
        System.out.println();
        if(jawab.equalsIgnoreCase("1")){
        do{
      System.out.print("Masukkan ID : ");
      cari = Integer.parseInt(in.readLine());
          for(int i=0;i<Barang.size();i++){
            if(cari==Barang.elementAt(i).getIdB()){
            idk = i;
            error=1;
            log=true;
            ulang=5;
            }
            else{
            log=false;
            error=0;
            }
          }
        if(ulang!=5) {
            log=false;
            System.out.println("ID Yang Anda Masukkan tidak ada");
            }
      }while(log!=true && ulang!=5);
      log=true;
        }
        
        if(jawab.equalsIgnoreCase("2")){
      do{
      System.out.print("Masukkan Nama Buah : ");
      jawab = in.readLine();
          for(int i=0;i<Barang.size();i++){
            if(jawab.equalsIgnoreCase(Barang.elementAt(i).getNama())){
            idk = i;
            error=1;
            log=true;
            ulang=5;
            }
            else{
            log=false;
            error=0;
            }
          }
        if(ulang!=5) {
            log=false;
            System.out.println("Nama Buah Yang Anda Masukkan tidak ada");
            }
      }while(log!=true && ulang!=5);
      log=true;
        }
        trans++;
        subD=0.0;
        hargaD=0.0;
          System.out.println();
          System.out.println();
          System.out.println("ID\tNama Buah\tStock\t\tHarga");
          
          System.out.println(Barang.elementAt(idk).getIdB()+"\t"+Barang.elementAt(idk).getNama()+"\t\t"+Barang.elementAt(idk).getStock()+"\t\t"+Barang.elementAt(idk).getHjual());
          ulang=0;
          do{
          log=true;
          System.out.print("Masukkan Jumlah : ");
          jumlah = Double.parseDouble(in.readLine());
          if(Barang.elementAt(idk).getStock()==0 || jumlah>Barang.elementAt(idk).getStock()){
          System.out.println("Stock buah tidak menyukupi. Masukkan kurang dari atau sama dengan " +Barang.elementAt(idk).getStock() +" (kg)");
          log=!true;
          ulang++;
          }
          }while(log!=true && ulang!=3);
          if(ulang==3){
          jumlah=0.0;
          }
          Barang.elementAt(idk).minOrder(jumlah);
         
          
          idDtr=Barang.elementAt(idk).getIdB();
          namaD=Barang.elementAt(idk).getNama();
          hargaD=Barang.elementAt(idk).getHjual();
          beliD=Barang.elementAt(idk).getHbeli();
          subD=hargaD*jumlah;
          totalD+=subD;
          
          DTransaksi.add(new DTransaksi(idx,idDtr,cekusr,namaD,jumlah,hargaD,beliD,subD,totalD));
          
         System.out.print("Tambah Transaksi ? (Y / N) : ");
          jawab = in.readLine();
      }while(!jawab.equalsIgnoreCase("n"));
          
          System.out.println();
          System.out.println();
          System.out.println("-----------------------------------------------------");
          System.out.println("Order No.\t: "+idx);
          System.out.println("Nama Kasir\t: "+cekusr);
          System.out.println("Tanggal\t\t: "+date);
           System.out.println("-----------------------------------------------------");
           System.out.println();
          System.out.println("ID\tNama Buah\tHarga\t\tSub Total");
          for(int i=max;i<trans;i++){
          System.out.println(DTransaksi.elementAt(i).getIdDtr()+"\t"+DTransaksi.elementAt(i).getNamaD()+"\t\t"+DTransaksi.elementAt(i).getHargaD()+"\t\t"+DTransaksi.elementAt(i).getSubD());
          }
          
          
          System.out.println("Total yang harus dibayar : "+totalD);
          do{
          System.out.print("Masukkan Uang :");
          uang = Double.parseDouble(in.readLine());
          
          if(uang<totalD){
          System.out.println("Uang yang Anda masukkan tidak cukup, silahkan coba lagi!");
          log=false;
          }
          else{
          log=true;
          }
          }while(log!=true);
          akhir = uang-totalD;
          
          
          
          //Keluaran Report
          System.out.println();
          System.out.println();
          System.out.println("-----------------------------------------------------");
          System.out.println("Order No.\t: "+idx);
          System.out.println("Nama Kasir\t: "+cekusr);
          System.out.println("Tanggal\t\t: "+date);
           System.out.println("-----------------------------------------------------");
           System.out.println();
          System.out.println("ID\tNama Buah\tHarga\t\tSub Total");
          for(int i=max;i<trans;i++){
          System.out.println(DTransaksi.elementAt(i).getIdDtr()+"\t"+DTransaksi.elementAt(i).getNamaD()+"\t\t"+DTransaksi.elementAt(i).getHargaD()+"\t\t"+DTransaksi.elementAt(i).getSubD());
          //DTransaksi.add(new DTransaksi(idx,cekusr,DTransaksi.elementAt(i).getNamaD(),DTransaksi.elementAt(i).getHargaD(),DTransaksi.elementAt(i).getSubD(),totalD));
          }
          max=trans;
          System.out.println();
          System.out.println();
          System.out.println("Total Yang Harus dibayar : Rp." +totalD);
          System.out.println("Uang yang dibayarkan : Rp."+uang);
          if(akhir==0){
          System.out.println("Tidak ada Kembalian");
          }
          else{
          System.out.println("Kembalian Rp. "+akhir);
          }
          
          System.out.println();
          System.out.println();
          System.out.println();
          totalD=0.0;
         
          
      break;
    case 2:
      int order=0;
      System.out.println("====================================");
      System.out.println("          LIHAT TRANSAKSI            ");
      System.out.println("====================================");
      System.out.println();
      System.out.println();
      for(int i=0;i<Transaksi.size();i++){
        if((cekusr.equalsIgnoreCase(Transaksi.elementAt(i).getKasir()))){
      System.out.println();
      System.out.println();
     System.out.println("-----------------------------------------------------");     
      System.out.println("Order No.\t: "+ Transaksi.elementAt(i).getIdTr());
      System.out.println("Nama Kasir\t: "+ Transaksi.elementAt(i).getKasir());
      System.out.println("Tanggal\t: "+ Transaksi.elementAt(i).getTglTr());
      System.out.println("-----------------------------------------------------");
      System.out.println();
      System.out.println("ID\tNama Buah\tHarga\tJumlah\tTotal");
      
         for(int x=0;x<DTransaksi.size();x++){
           if(DTransaksi.elementAt(x).getIdDtr()==Transaksi.elementAt(i).getIdTr()){
           System.out.println(DTransaksi.elementAt(x).getIdBarang()+"\t"+DTransaksi.elementAt(x).getNamaD()+"\t\t"+DTransaksi.elementAt(x).getHargaD()+"\t"+DTransaksi.elementAt(x).getJumlah()+"\t"+DTransaksi.elementAt(x).getSubD());
           totalD+=DTransaksi.elementAt(x).getTotalD();
           }
         }
         System.out.println("Total transaksi :" + totalD);
         totalD=0.0;
         System.out.println();
         System.out.println();
        }
      }
      break;
  }
  }while(pil7<3);
  
   }
  }while(true);
  }
}