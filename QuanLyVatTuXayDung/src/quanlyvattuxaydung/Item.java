package quanlyvattuxaydung;
import java.util.*;
public class Item{
    private String name;
    private String id;
    private double price;
    private String unit;
    private NhaCungCap nhaCungCap ;
    private String mieuTa ;
    private int soLuong;
    public Item(String id, String name, double price, String unit, NhaCungCap nhaCungCap, String mieuTa, int soLuong) {
        // Your constructor logic here
        this.name = name;
        this.id = id;
        this.price = price;
        this.unit = unit;
        this.nhaCungCap = nhaCungCap;
        this.mieuTa = mieuTa;
        this.soLuong = soLuong;
    }
    // public Item(String parts, String parts2, double d, String parts3, NhaCungCap nhaCungCap2, String parts4, int i){ // tạo danh sách rỗng
    // }
    public Item(){
        
    }
    public Item(String name2, String id2, double price2, String unit2, String string, String mieuTa2, int soLuong2) {
    }
    public void Input() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten san pham: ");
        name = scanner.nextLine();
        System.out.print("Nhap ma san pham: ");
        id = scanner.nextLine();
        System.out.print("Nhap gia tien:");
        price = scanner.nextDouble(); 
        scanner.nextLine();
        System.out.print("Nhap don vi: ");
        unit = scanner.nextLine(); // lỗi không nhâppj 
        System.out.print("Nhap nha cung cap : ");
        // nhaCungCap= scanner.nextLine();
        String tenNhaCungCap = scanner.nextLine();
        NhaCungCap nhaCungCap= new NhaCungCap(tenNhaCungCap);
        System.out.print("Mieu ta: ");
        mieuTa = scanner.nextLine();
        System.out.print("Nhap so luong:");
        soLuong = scanner.nextInt();
        System.out.println("Thong tin mat hang da duoc cap nhap");
    }
    public void Output() {
        System.out.printf("%-10s %-10s %-10s %-10.2f %-10d %-10s%n", name, id, unit, price, soLuong, nhaCungCap.getName());
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }
    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
    public String getMieuTa() {
        return mieuTa;
    }
    public void setMieuTa(String mieuTa) {
        this.mieuTa = mieuTa;
    }
    public int getSoLuong() {
        return soLuong;
    }
    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }
}
