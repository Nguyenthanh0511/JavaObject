package quanlyvattuxaydung;
import java.util.*;
public class Customer extends Person{
    private String code;
    private String tenSanPham;
    public Customer(String name , String PhoneNumber,String code , String tenSanPham){
        super(name,PhoneNumber);
        this.code=code;
        this.tenSanPham = tenSanPham;
    }
    public Customer(){

    }
    public String getCode() {
        return code;
    }
    public void setCode(String code){
        this.code = code;
    }
    public String getTenSanPham() {
        return tenSanPham;
    }
    
    public void setTenSanPham(String tenSanPham) {
        this.tenSanPham = tenSanPham;
    }
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
        tenSanPham = sc.nextLine();
    }
    @Override
    public void Output(){
        super.Output();
        System.out.printf("ID khach hang: %-10s%n", code);
        System.out.printf("Ten san pham mua: %-20s%n", tenSanPham);
    }
    
}
