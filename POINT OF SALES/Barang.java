import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Barang {

private int idB;
private String nama;
private Double stock;
private Double hargabeli;
private Double hargajual;

public Barang (int idB, String nama, Double stock, Double hargabeli, Double hargajual){
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

public Double getStock(){
  return stock;
}

public Double getHbeli(){
  return hargabeli;
}

public Double getHjual(){
  return hargajual;
}

public void setHjual(Double harga){
  hargajual=harga;
}

public void setHbeli(Double harga){
  hargabeli=harga;
}

public void setStock(Double stock1){
  stock=stock1;
}

public void minOrder(Double min){
  stock-=min;

}

}