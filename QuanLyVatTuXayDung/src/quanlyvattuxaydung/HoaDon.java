package quanlyvattuxaydung;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.function.Supplier;
import java.text.ParseException;
import java.io.IOException;
public class HoaDon {
    private String id;
    private Date dateTime;
    NhaCungCap nhaCungCap;
    Employee employee;
    ListItems listSanPhams;
    public HoaDon(String id,Date dateTime,NhaCungCap nhaCungCap,Employee employee,ListItems listSanPhams){
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
    public Date getDateTime() {
        return dateTime;
    }
    public void setDateTime(Date dateTime) {
        this.dateTime = dateTime;
    }
    public HoaDon(ListItems listSanPhams) {
        this.listSanPhams = listSanPhams;
    }
    // public ArrayList<NhaCungCap> getNCC(){
    //     return nhaCungCap;
    // }
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
    //Phương thức nhập vào 
    public void Input(){
            int luaChon;
            ListNhaCungCap listNhaCungCap = new ListNhaCungCap(); //Khai báo cấp phát động của ArrayList
            ListCustomer listCustomer = new ListCustomer();
            ListItems listItems = new ListItems();
            listNhaCungCap.readFromFile("QuanLyVatTuXayDung\\src\\Data\\GhiListNhaCungCap.txt");
            listCustomer.readToFile("QuanLyVatTuXayDung\\src\\Data\\DocListCustomer.txt");
            listItems.ReadFile("QuanLyVatTuXayDung\\src\\Data\\DocListItem.txt");
            Scanner sc = new Scanner(System.in);
            ListHoaDon listHoaDon = new ListHoaDon();
            String dateformat = "dd/mm/yy";
            SimpleDateFormat sdf = new SimpleDateFormat(dateformat);
            System.out.println("Nhap thong tin hoa don: "); 
            do {
                System.out.print("Nhap ma hoa don: ");
                id = sc.nextLine();
                if (!listHoaDon.findHoaDonById(id))
                    break;
                System.out.println("Hoa don nay da ton tai. Vui long nhap lai.");
            }while(true);
            System.out.println("============================");
            do{

                System.out.print("Nhap ngay nhap(dd/mm/yyyy): ");
                String tempDate = sc.next();
                try {
                    this.dateTime = sdf.parse(tempDate); //Chỉnh lại form 
                    break;
                } catch (ParseException e) {
                    System.out.println("Loi. Thu lai.");
                }
            }while(true);
            System.out.println("============================");
            System.out.println("Chon nha cung cap( Chon so tuong ung ): ");
            System.out.println("============================");
            // kiểm tra nhà cung cấp 
            if(listNhaCungCap.getListNhaCungCap().isEmpty()){
                System.out.println("Danh sach nha cung cap rong!!");
            }
            else
            for (int i = 0; i < listNhaCungCap.getListNhaCungCap().size() + 1; i++) {
                if (i == listNhaCungCap.getListNhaCungCap().size()) {
                    System.out.println((i + 1) + ". Them nha cung cap");
                    break;
                }
                System.out.println((i + 1) + ". " + listNhaCungCap.getListNhaCungCap().get(i).getName());
            }
            System.out.print("Nhap su lua chon: ");
            luaChon = sc.nextInt();
            if (luaChon - 1 == listNhaCungCap.getListNhaCungCap().size()) { //Index of array form 0 to ... size -1 
                NhaCungCap tSupplier = new NhaCungCap(); //
                tSupplier.Input();
                listNhaCungCap.addNhaCungCap(tSupplier);
                nhaCungCap = tSupplier;
            } else {
                nhaCungCap = listNhaCungCap.getListNhaCungCap().get(luaChon - 1);
            }
            System.out.println("============================");
            System.out.print("Chon nhung san pham nhap ( Chon so tuong ung ): ");
            for (int i = 0; i < listItems.getListItem().size() + 2; i++) {
                if (i == listItems.getListItem().size()) {
                    System.out.println((i + 1) + ". Them san pham");
                    continue;
                } else if (i == listItems.getListItem().size() + 1) {
                    System.out.println((i + 1) + ". Dung");
                    break;
                }
                System.out.println((i + 1) + ". " + listItems.getListItem().get(i).getName());
                    
                }
                System.out.printf("Nhap cac su lua chon (%d de dung):\n", listItems.getListItem().size() + 2);
                do {
                System.out.print("San pham so: ");
                luaChon = sc.nextInt();
                if (luaChon - 2 == listItems.getListItem().size() + 2)
                    break;
                else if (luaChon - 1 == listItems.getListItem().size()) {
                    System.out.println("Thong tin san pham muon them: ");
                    Item sanPham = new Item();
                    sanPham.Input();
                    listItems.addItem(sanPham);
                    listItems.addItem(sanPham);
                } else {
                    Item sanPham = listItems.getListItem().get(luaChon - 1);
                    System.out.printf("Nhap so luong san pham %s: ", sanPham.getName());
                    int newQuantity = sc.nextInt();
                    sanPham.setSoLuong(newQuantity);
                    listItems.addItem(sanPham);
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



