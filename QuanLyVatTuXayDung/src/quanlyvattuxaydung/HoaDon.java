package quanlyvattuxaydung;
import java.util.*;
import java.util.function.Supplier;
public class HoaDon {
    private String id;
    private String dateTime;
    NhaCungCap nhaCungCap;
    Employee employee;
    ListItems listSanPhams;
    public HoaDon(String id,String dateTime,NhaCungCap nhaCungCap,Employee employee,ListItems listSanPhams){
            this.id = id;
            this.dateTime = dateTime;
            this.nhaCungCap = nhaCungCap;
            this.employee=employee;
            this.listSanPhams = listSanPhams;
    }
    public HoaDon(){
        listSanPhams = new ListItems();
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
        }
    public String getDateTime() {
        return dateTime;
    }
    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
    public HoaDon(ListItems listSanPhams) {
        this.listSanPhams = listSanPhams;
    }
    public NhaCungCap getNhaCungCap() {
        return nhaCungCap;
    }
    public void setNhaCungCap(NhaCungCap nhaCungCap) {
        this.nhaCungCap = nhaCungCap;
    }
    public Employee getEmployee() {
       return employee;
    }
        public void setEmployee(Employee employee) {
            this.employee = employee;
        }
    public ListItems getListSanPham() {
        return listSanPhams;
    }
    public void setListSanPham(ListItems listSanPhams) {
            this.listSanPhams = listSanPhams;
    }
        //Tính tổng tiền 
    public double tongTienHoaDon()    {
        double tong = 0.0;
        for(int i = 0;i<listSanPhams.getSoLuong();i++){
            tong +=listSanPhams.getItem(i).getPrice();
        }
        return tong;
    }
        // so luong hoa don 
        public int soLuongHoaDon(){
            int soLuong = 0;
            for(int i = 0 ;i <listSanPhams.getSoLuong();i++){
                soLuong = listSanPhams.getItem(i).getSoLuong();
            }
            return soLuong;
        }
       
    public void Input(){
            int luaChon;
            ListNhaCungCap listNhaCungCap = new ListNhaCungCap();
            ListCustomer listCustomer = new ListCustomer();
            //ListEmployee
            Scanner sc = new Scanner(System.in);
            ListHoaDon listHoaDon = new ListHoaDon();
            System.out.println("Nhap thong tin hoa don: ");
            do {
                System.out.print("Nhap ma hoa don: ");
                id = sc.nextLine();
                if (!listHoaDon.findHoaDonById(id))
                    break;
                System.out.println("Hoa don nay da ton tai. Vui long nhap lai.");
            }while(true);
            System.out.println("============================");
            System.out.print("Nhap ngay nhap: ");
            dateTime = sc.nextLine();
            System.out.println("============================");
            System.out.println("Chon nha cung cap( Chon so tuong ung ): ");
            for (int i = 0; i < listNhaCungCap.getListNhaCungCap().size() + 1; i++) {
                if (i == listNhaCungCap.getListNhaCungCap().size()) {
                    System.out.println((i + 1) + ". Them nha cung cap");
                    break;
                }
                System.out.println((i + 1) + ". " + listNhaCungCap.getListNhaCungCap().get(i).getName());
            }
            System.out.print("Nhap su lua chon: ");
            luaChon = sc.nextInt();
            if (luaChon - 1 == listNhaCungCap.getListNhaCungCap().size()) {
                NhaCungCap LnhaCungCap = new NhaCungCap();
                nhaCungCap.Input();
                listNhaCungCap.addNhaCungCap(nhaCungCap);
                nhaCungCap = LnhaCungCap;
            } else {
                nhaCungCap = listNhaCungCap.getListNhaCungCap().get(luaChon - 1);
            }
            System.out.println("============================");
            System.out.print("Chon nhung san pham nhap ( Chon so tuong ung ): ");
            for (int i = 0; i < listSanPhams.getListItem().size() + 2; i++) {
                if (i == listSanPhams.getListItem().size()) {
                    System.out.println((i + 1) + ". Them san pham");
                    continue;
                } else if (i == listSanPhams.getListItem().size() + 1) {
                    System.out.println((i + 1) + ". Dung");
                    break;
                }
                System.out.println((i + 1) + ". " + listSanPhams.getListItem().get(i).getName());
                }
                System.out.printf("Nhap cac su lua chon (%d de dung):\n", listSanPhams.getListItem().size() + 2);
                do {
                System.out.print("San pham so: ");
                luaChon = sc.nextInt();
                if (luaChon - 2 == listSanPhams.getListItem().size() + 2)
                    break;
                else if (luaChon - 1 == listSanPhams.getListItem().size()) {
                    System.out.println("Thong tin san pham muon them: ");
                    Item sanPham = new Item();
                    sanPham.Input();
                    listSanPhams.addItem(sanPham);
                    listSanPhams.addItem(sanPham);
                } else {
                    Item sanPham = listSanPhams.getListItem().get(luaChon - 1);
                    System.out.printf("Nhap so luong san pham %s: ", sanPham.getName());
                    int newQuantity = sc.nextInt();
                    sanPham.setSoLuong(newQuantity);
                    listSanPhams.addItem(sanPham);
                }
                } while (true);
                System.out.println("=============================");
            }
            public void Output() {
                System.out.printf("%23sThong tin hoa don\n", "");
                System.out.printf("Ma Hoa Don:%24s\n", id);
                System.out.printf("Ngay Nhap:%25s\n", dateTime);
                System.out.printf("Don Vi Cung Cap:%19s\n", nhaCungCap.getName());
                // System.out.printf("Nhan Vien Nhap:%20s\n", membership.getName());
                // System.out.printf("Kho Hang:%26s\n", warehouse.getName());
                System.out.println("Danh Sach San Pham:");
                for (Item k : listSanPhams.getListItem()) {
                    System.out.print(" - ");
                    k.Output();
                }
            }
        
}




    //  public static void main(String[] args) {
    // // Create instances for testing
    //         // NhaCungCap nhaCungCap = new NhaCungCap("NCC001", "Nha Cung Cap A", "an lao", new ArrayList<>(),); // Initialize ArrayList for sanPhams
    //         Employee employee = new Employee("E001", "John Doe","134","an lao");
    //         // Create instances of items
    //         Item item1 = new Item("Item001", "Product A", 10.0, "Unit", nhaCungCap, "Description", 5);
    //         Item item2 = new Item("Item002", "Product B", 15.0, "Unit", nhaCungCap, "Description", 3);
    //         // Create a list of items
    //         ListItems listSanPham = new ListItems();
    //         listSanPham.addItem(item1);
    //         listSanPham.addItem(item2);
    //         // Create an instance of HoaDon
    //         HoaDon hoaDon = new HoaDon("HD001", "2023-11-11", nhaCungCap, employee, listSanPham);
    //         // Display the initial details
    //         for(int i = 0;i<hoaDon.soLuongHoaDon();i++){
    //             System.out.println("Initial details of the order:");
    //             System.out.println("Order ID: " + hoaDon.getId());
    //             System.out.println("Date Time: " + hoaDon.getDateTime());
    //             System.out.println("Total Quantity: " + hoaDon.soLuongHoaDon());
    //             System.out.println("Total Amount: " + hoaDon.tongTienHoaDon());
    //             System.out.println("Ten nha cung cap :"+nhaCungCap.getName());
    //             System.out.println("Ten san pham :"+item1.getName());
    //         }

    //         // Modify some details
    //         hoaDon.setId("HD002");
    //         hoaDon.setDateTime("2023-11-12");

    //         // Display the modified details
    //         System.out.println("\nModified details of the order:");
    //         System.out.println("Order ID: " + hoaDon.getId());
    //         System.out.println("Date Time: " + hoaDon.getDateTime());
    //         System.out.println("Total Quantity: " + hoaDon.soLuongHoaDon());
    //         System.out.println("Total Amount: " + hoaDon.tongTienHoaDon());
    // }