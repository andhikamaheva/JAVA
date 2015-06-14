import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;

public class DTransaksi {
  private int idDtr;
  private int idBarang;
  private String kasirD;
  private String namaD;
  private Double jumlah;
  private Double hargaD;
  private Double beliD;
  private Double SubDtr;
  private Double totalD;
  

  
  public DTransaksi (int idDtr, int idBarang, String kasirD, String namaD, Double jumlah, Double hargaD, Double beliD, Double SubDtr, Double totalD){
  this.idDtr=idDtr;
  this.idBarang=idBarang;
  this.kasirD=kasirD;
  this.namaD=namaD;
  this.jumlah=jumlah;
  this.hargaD=hargaD;
  this.beliD=beliD;
  this.SubDtr=SubDtr;
  this.totalD=totalD;
  }
  
  public int getIdDtr(){
  return idDtr=idDtr;
  }
  
  
  public int getIdBarang(){
  return idBarang=idBarang;
  }
  
  public Double getJumlah(){
  return jumlah=jumlah;
  }
  
  public String getKasirD(){
  return kasirD;
  }
  
  public String getNamaD(){
  return namaD;
  }
  
  public Double getHargaD(){
  return hargaD;
  }
  
  public Double getBeliD(){
  return beliD;
  }
  
  public Double getSubD(){
  return SubDtr;
  }
  
  public Double getTotalD(){
  return SubDtr;
  }
 
  
  
}