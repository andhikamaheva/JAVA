import java.util.*;
import java.io.*;
import java.text.SimpleDateFormat;

public class Transaksi {

  private int idTr;
  private String tglTr;
  private String kasir;
  
  
  public Transaksi (int idTr, String tglTr, String kasir) {
  this.idTr=idTr;
  this.tglTr=tglTr;
  this.kasir=kasir;
  }
  
  public int getIdTr(){
  return idTr=idTr;
  }
  
  public String getTglTr(){
  return tglTr=tglTr;
  }
  
  public String getKasir(){
  return kasir=kasir;
  }
}