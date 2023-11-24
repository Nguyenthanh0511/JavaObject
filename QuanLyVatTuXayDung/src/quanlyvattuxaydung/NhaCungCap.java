package quanlyvattuxaydung;
import java.util.*;
public class NhaCungCap extends Person{
    private String code;
    private String address; // 
    private ArrayList<Item> sanPhams;
    public NhaCungCap(String name ,String code, String PhoneNumber, String address, ArrayList<Item> sanPhams){// ở danh sách sản phẩm chỉ lấy tên 
        super(name, PhoneNumber);
        this.code = code;
        this.address = address;
        this.sanPhams = sanPhams; // danh sách sản phẩm sẽ lấy những thuộc tính ở danh sách sản phẩm 
    }
    // public NhaCungCap(String phone){
    //     super(PhoneNumber );
    // }
    public NhaCungCap() {
        // Initialization or default constructor
        this.sanPhams = new ArrayList<>();
    }
    public NhaCungCap(String name) {
        super(name);
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public ArrayList<Item> getSanPhams() {
        return sanPhams;
    }
    
    public void setSanPhams(ArrayList<Item> sanPhams) {
        this.sanPhams = sanPhams;
    }
    public void Input(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong thin dang nhap:");
        super.Input();
        System.out.println("Nhap ma code nha cung cap :");
        code =sc.nextLine();
        System.out.println("Nhap Dia Chi:");
        address = sc.nextLine();
        System.out.println("Nhap so luong san pham nha cung cap :");
        int soLuong = 1;
        for(int i = 0 ;i < soLuong;i++){
            Item sanPham = new Item();
            sanPham.Input(); //nHAP VAo 
            sanPhams.add(sanPham); //thêm vào sản phẩm 
        }
        System.out.println("Đã được thêm vào");
    }
    public void Output(){
        System.err.println("Thong tin nha cung cap :");
        super.Output();
        System.err.println("Danh sach san pham:");
        // for(Item sanPham :sanPhams){
        //     sanPham.Output();
        // }
         // format định dạng xuất
        for (Item sanPham : sanPhams) {
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s%n",
                    sanPham.getName(), sanPham.getId(), sanPham.getPrice(),
                    sanPham.getUnit(), sanPham.getNhaCungCap().getName(),
                    sanPham.getMieuTa(), sanPham.getSoLuong());
        }
    }
}
// Tôi làm đến phần nhập và xuất , đang bị lỗi ở NhaCungCap
