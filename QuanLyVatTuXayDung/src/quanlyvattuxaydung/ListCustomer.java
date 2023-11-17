package quanlyvattuxaydung;
import java.util.*;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
public class ListCustomer {
    ArrayList<Customer> listCustomer;
    public ListCustomer(ArrayList<Customer> listCustomer){ // phương thức khởi tạo 
        this.listCustomer = (listCustomer!=null) ? listCustomer : new ArrayList<>() ; // nếu lhacsh null thì gán listCustomer , = NULL thì tạo một arraylist mới
    }
    public ListCustomer(){ // 
        this.listCustomer = new ArrayList<>();
    }
    public ArrayList<Customer> getListCustomer() { // Phương thức tác dụng trả về danh sách khách hàng
        return listCustomer;   // lấy danh sách Customer 
    }
    public void setListCustomer(ArrayList<Customer> listCustomer) {
        this.listCustomer = listCustomer; // tháy đổi Customer 
    }
    // format 
    public void Output() {
        if (listCustomer.isEmpty()) {
            System.out.println("Danh sach rong");
        } else {
            // Print header
            System.out.printf("%-20s %-10s %-10s %-10s%n", "Name", "ID", "Phone","Ten san pham");
            for (Customer customer : listCustomer) {
                System.out.printf("%-20s %-10d %-15s %-10s%n",
                customer.getName(), customer.getCode(),
                customer.PhoneNumber, customer.getTenSanPham());
            }
        }
    }
    // Thêm khách hàng
    public void addCustomer(Customer newCustomer){
        if(listCustomer.contains(newCustomer))
        {
            System.out.println("Khach hang da ton tai!");
            return;
        }
        listCustomer.add(newCustomer);
    }
    public void removeCustomer(Customer newCustomer){ // sử dụng iterator lặp qua để không xảy ra lỗi ngạoi lệ 
        for(Customer customer :listCustomer){
             if(customer.getCode()==newCustomer.getCode())
                 listCustomer.remove(customer);
        }
        if (listCustomer.isEmpty()) {
            System.out.println("Khong tim thay khach hang co ID: " + newCustomer.getCode());
        } else {
            System.out.println("Da xoa khach hang ID: " + newCustomer.getCode());
        }
    }

    // Thay đổi thông tin 
    public void updateCustomerInfo(Customer cus, String thuocTinh, Object giaTri) {
        if (cus == null) {
            System.out.println("Khong tim thay !");
            return;
        } else {
            for (Customer customer : listCustomer) {
                System.err.println("Neu khong muon thay doi thuoc tinh nao thi nhap 'n' :");
                String str = (String) giaTri;
                switch (thuocTinh) {
                    case "name":
                        if (customer.getCode() == cus.getCode()) {
                            if (giaTri instanceof String) {
                                customer.setName(str);
                            } else if (str.equals("n")) {
                                continue;
                            } else {
                                System.out.println("Khong tim thay !");
                                return;
                            }
                        }
                        break;
                    case "id":
                        if (customer.getCode() == cus.getCode()) {
                            if (giaTri instanceof String) {
                                String id = (String) giaTri;
                                customer.setCode(id);
                            } else if (str.equals("n")) {
                                continue;
                            } else {
                                System.out.println("Khong tim thay !");
                                return;
                            }
                        }
                        break;
                    case "PhoneNumber":
                        // Xử lý cập nhật PhoneNumber ở đây (tương tự như name và id)
                        break;
                    case "tenSanPham":
                        // Xử lý cập nhật tenSanPham ở đây (tương tự như name và id)
                        break;
                    // Thêm các trường hợp khác cần cập nhật
                    default:
                        System.out.println("Thuoc tinh khong hop le!");
                        return;
                }
            }
        }
    }
    // Lấy số lượng customer 
    public int soLuongKhachHang(){
        // Customer customer = new Customer();
        return listCustomer.size();
    }
    // Các update thông tin 2 
   public void updateCustomerInfo(Customer customerToUpdate, String thuocTinh, String giaTriMoi) {
    if (customerToUpdate == null) {
        System.out.println("Khong tim thay !");
        return;
    }
    for (Customer customer : listCustomer) {
        if (customer.getCode() == customerToUpdate.getCode()) {
            switch (thuocTinh) {
                case "name":
                    customer.setName((String) giaTriMoi);
                    break;
                case "id":
                    if (giaTriMoi instanceof String) {
                        customer.setCode((String) giaTriMoi);
                    } else {
                        System.out.println("Gia tri khong hop le cho thuoc tinh 'id'.");
                        return;
                    }
                    break;
                case "PhoneNumber":
                    // Xử lý cập nhật PhoneNumber ở đây
                    if (giaTriMoi instanceof String) {
                        customer.setPhoneNumber((String) giaTriMoi);
                    } else {
                        System.out.println("Gia tri khong hop le cho thuoc tinh 'PhoneNumber'.");
                        return;
                    }
                    break;
                case "tenSanPham":
                    // Xử lý cập nhật tenSanPham ở đây
                    if (giaTriMoi instanceof String) {
                        customer.setTenSanPham((String) giaTriMoi);
                    } else {
                        System.out.println("Gia tri khong hop le cho thuoc tinh 'tenSanPham'.");
                        return;
                    }
                    break;
                // Thêm các trường hợp khác cần cập nhật
                default:
                    System.out.println("Thuoc tinh khong hop le!");
                    return;
            }
            System.out.println("Da cap nhat thuoc tinh " + thuocTinh + " thanh cong.");
            return;
        }
    }
        System.out.println("Khong tim thay khach hang co ID: " + customerToUpdate.getCode());
    }
    // Tìm kiếm 
    public Customer timKiemCustomer(ListCustomer listKhachHang,String idKhachHang){
        for(Customer i :listKhachHang.getListCustomer()){
            if(idKhachHang == i.getCode()){
                return i;
            }
        }
        return null;
    }
    public static void writeCustomersToFile(List<Customer> customers, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Customer customer : customers) {
                writer.write(customer.getName() + "," +
                             customer.getPhoneNumber() + "," +
                             customer.getCode() + "," +
                             customer.getTenSanPham());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Không lấy danh sách 
    public void writeToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Customer customer : listCustomer) {
                writer.write(customer.getName() + "," + customer.getCode() + "," + customer.getPhoneNumber() + "," + customer.getTenSanPham());
                writer.newLine();
            }
            System.out.println("Danh sách khách hàng đã được ghi vào file '" + fileName + "'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}




    // public static void main(String args[]){
    //     ListCustomer listCustomer = new ListCustomer(null);
    //     Scanner sc = new Scanner(System.in);
    //     int n;
    //     System.out.println("Nhap so luong khach hang:");
    //     n = sc.nextInt();
    //     for(int i = 1;i<=n;i++){
    //         System.out.println("Nhap khach hang thu :"+i);
    //         Customer customer = new Customer();
    //         customer.Input();
    //         listCustomer.addCustomer(customer);
    //     }
    //     //hien danh sach
    //        // Display the initial list
    //     System.out.println("Initial list of customers:");
    //     listCustomer.Output();

    //     // Update a customer
    //     Customer customerUpdate = new Customer();
    //     System.out.println("Nhap id muon cap nhat:");
    //     int updateId = sc.nextInt();
    //     customerUpdate.setId(updateId);

    //     sc.nextLine(); // Consume the newline character
    //     System.out.println("Nhap ten moi cho khach hang:");
    //     String newName = sc.nextLine();
    //     listCustomer.updateCustomerName(customerUpdate, newName);

    //     // Display the updated list
    //     System.out.println("\nList after updating a customer:");
    //     listCustomer.Output();

    //     // Remove a customer
    //     // System.out.println("Nhap id muon xoa:");
    //     // int removeId = sc.nextInt();
    //     // Customer customerToRemove = new Customer();
    //     // customerToRemove.setId(removeId);
    //     // listCustomer.removeCustomer(customerToRemove);

    //     // Display the list after removal
    //     System.out.println("\nList after removing a customer:");
    //     listCustomer.Output();
    //     // Cách gọi update 2 
    //     Scanner scanner = new Scanner(System.in);

    //     // Item item = new Item("Example", "123", 10.0, "Unit", new Supplier("ExampleSupplier"), "Description", 5);

    //     System.out.print("Nhap ten thuoc tinh muon thay doi: ");
    //     String propertyName = scanner.nextLine();

    //     System.out.print("Nhap gia tri moi cho thuoc tinh: ");
    //     String propertyValue = scanner.nextLine();

    //     // Example usage
    //     for(Customer cus : listCustomer.getListCustomer()) {
    //         switch (propertyName) {
    //             case "name":
    //                 updateProperty(cus, "name", propertyValue);
    //                 break;
    //             case "id":
    //                 updateProperty(cus, "id", Integer.parseInt(propertyValue));
    //                 break;
    //             // Add other cases for each property in the Customer class
    //             default:
    //                 System.out.println("Thuoc tinh khong hop le.");
    //         }
    //     }
    //     listCustomer.Output();
    // }
