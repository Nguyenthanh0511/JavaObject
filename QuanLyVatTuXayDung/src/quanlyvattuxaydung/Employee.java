package quanlyvattuxaydung;
import java.util.*;
public class Employee extends Person{
    private String id;
    private String address;
   public Employee(String name , String PhoneNumber, String id,String address){
       super(name,PhoneNumber);
       this.id=id;
       this.address = address;
   }
    @Override
    public void Input() {
        super.Input();  
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap thong thin dang nhap:");
        super.Input();
        System.out.println("Nhap Dia Chi:");
        address = sc.nextLine();
    }
    @Override
    public void Output() {
        super.Output(); 
        System.out.println("Employee ID: " + id);
        System.out.println("Employee Address: " + address);
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
