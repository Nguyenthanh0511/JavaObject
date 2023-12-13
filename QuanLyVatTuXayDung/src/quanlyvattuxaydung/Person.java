/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package quanlyvattuxaydung;

import java.util.*;
public class Person { //Nguoi
    //Đây là thuộc tính ( name và PhoneNumber)
    protected String name;
    protected String PhoneNumber ;
    public Person(String name,String PhoneNumber){ //Phương thức khởi tạo 
        this.name = name; 
        this.PhoneNumber = PhoneNumber;
    }
    public Person(){  // 

    }
    public Person(String name){ // thay đổi đổi tên 
        this.name = name;
    }
    //Input 
    public void Input(){                                                                                                                                                                                                            
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ho ten :");
        name = sc.nextLine();
        System.out.println("Nhap so dien thoai :");
        PhoneNumber = sc.nextLine();
    }
    public void Output(){
        System.out.printf("\n%20s",name ); 
        System.out.printf("%5s",PhoneNumber );
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPhoneNumber() {
        return PhoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }
}
