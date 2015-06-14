import java.util.*;
import java.io.*;

public class Barang {

private int idB;
private String nama;
private int stock;
private int hargabeli;
private int hargajual;

public Barang (int idB, String nama, int stock, int hargabeli, int hargajual){
  this.idB=idB;
  this.nama=nama;
  this.stock=stock;
  this.hargabeli=hargabeli;
  this.hargajual=hargajual;
}

public int getIdB(){
  return idB;
}

public String getNama(){
  return nama;
}

public int getStock(){
  return stock;
}

public int getHbeli(){
  return hargabeli;
}

public int getHjual(){
  return hargajual;
}

public void setHjual(int harga){
  hargajual=harga;
}

public void setHbeli(int harga){
  hargabeli=harga;
}

public void setStock(int stock1){
  stock=stock1;
}

}