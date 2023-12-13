package quanlyvattuxaydung;
import java.util.*;
public class Customer extends Person{
    private String code;
    private ArrayList<Item> sanPhams;
    public Customer(String name , String PhoneNumber,String code , ArrayList<Item> sanPhams){
        super(name,PhoneNumber);
        this.code=code;
        this.sanPhams = sanPhams;
    }
    public Customer(){

    }
    public String getCode() {
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public ArrayList<Item> getSanPhams() {
        return sanPhams;
    }
    public void setSanPhams(ArrayList<Item> sanPhams) {
        this.sanPhams = sanPhams;
    }
    // public void setTenSanPham(ArrayList<Item> tenSanPham) {
    //     this.sanPhams = sanPhams;
    // }
    // public void setTenSanPham2(String tenSanPham){
    //     this.tenSanPham = tenSanPham;
    // }
    //nhập 
    @Override // kiểm tra xem có ghi đè hay không 
    public void Input(){
        super.Input();  // Call the input method of the base class (Person)
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong thin dang nhap:");
        // super.Input();
        System.out.println("Nhap id khach hang :");
        code = sc.next();
        sc.nextLine();
        System.out.println("Nhap ten san pham khach hang mua :");
        int soLuong = 1;
        for(int i = 0 ;i<soLuong;i++){
            Item sanPham = new Item();
            sanPham.Input();
            sanPhams.add(sanPham);
        }
    }
    @Override
    public void Output(){
        super.Output();
        System.out.printf("ID khach hang: %-10s%n", code);
        System.out.println("Danh sach san pham :");
        for(Item sanPham : sanPhams){
            System.out.printf("%-20s %-20s %-20s %-20s %-20s %-20s %-20s%n",
            sanPham.getName(), sanPham.getId(), sanPham.getPrice(),
            sanPham.getUnit(), sanPham.getNhaCungCap().getName(),
            sanPham.getMieuTa(), sanPham.getSoLuong());
        }
    }
    
}
