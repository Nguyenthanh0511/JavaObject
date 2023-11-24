package quanlyvattuxaydung;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
public class ListItems {
    //static
    ArrayList<Item> listItem = new ArrayList<Item>();
    public ArrayList<Item> getListItem() {
        return listItem;
    }
    public ArrayList<Item> item() {
        return listItem; 
    }
    public ListItems(){
        this.listItem = new ArrayList<>(); //CẤP PHÁT BỘ NHỚ
        // return listItem;
    }
    public void setListItem(ArrayList<Item> listItem) {
        this.listItem = listItem;
    }
    //Kiểm tra
    public void Output(){
        if(listItem.isEmpty()){
            System.err.println("Danh sach mat hang rong");
        }
        else{
            // duyệt 
            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s%n", "Ten san pham", "Ma san pham", "Don vi", "Gia ca", "So luong", "Nha cung cap");
            for(Item i :listItem){ // kiểu dữ liệu Item chưa các thuộc tính Item bên trong , và lấy danh sách từ listItem 
                System.out.println("______________________________________________________________________");
                i.Output();

            }
        }
    }
    public int getSoLuong(){
        return listItem.size();
    }
    //get Item
    public Item getItem(int soLuong){
        return listItem.get(soLuong);
    }
    //remove 
    public void removeItem(Item i) {
        listItem.remove(i);
    }
    //add
    public void addItem(Item i){
        listItem.add(i);
    }
    // public ListItems getListSanPhams() {
    //     return listItem;
    // }
    // public String getName(Item i){
    //     // ArrayList<Item> item = new ArrayList<>();
    //     return listItem.addItem(i);
    // }
    //changeInformation
        // 3 tham số ( Item , thuộc tính , và giá trị đối tượng)
    public void changeItem(ListItems listSanPham ,String id,String thuocTinh,String giaTriMoi){
        Item sanPhamCanThayDoi = timKiem(listSanPham,id);
        if(sanPhamCanThayDoi != null){
            switch(thuocTinh){
                case "name":
                    sanPhamCanThayDoi.setName(giaTriMoi);
                    break;
                case "price":
                    sanPhamCanThayDoi.setPrice(Double.parseDouble(giaTriMoi)); // ép kiểu từ string sang double
                    break;
                case "Unit":
                    sanPhamCanThayDoi.setUnit(giaTriMoi);
                    break;
                case "mieuTa":
                    sanPhamCanThayDoi.setMieuTa(giaTriMoi);
                default:
                    System.out.println("Thuoc tinh khong hop le.");
            }
            System.out.println("Da thay doi thong tin san pham:");
            sanPhamCanThayDoi.Output(); // In ra thông tin sau khi thay đổi
        }
        else{
            System.out.println("Khong tim thay id :");
        }
    }
    
    // Thay đổi thông tin sản phẩm 

    // Sap xep 
    private void QuickSort(ArrayList<Item> arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
    
            QuickSort(arr, left, pivotIndex - 1);
            QuickSort(arr, pivotIndex + 1, right);
        }
    }
    
    private int partition(ArrayList<Item> arr, int left, int right) {
        double pivot = arr.get(right).getPrice();
        int i = left - 1;
    
        for (int j = left; j < right; j++) {
            if (arr.get(j).getPrice() <= pivot) {
                i++;
                Collections.swap(arr, i, j);
            }
        }
    
        Collections.swap(arr, i + 1, right);
        return i + 1;
    }
    
    public ArrayList<Item> sortPrice() {
        ArrayList<Item> result = new ArrayList<>(listItem);
        QuickSort(result, 0, result.size() - 1);
        return result;
    }
    // ghi file 
    // static
    public void writeToFile(String fileName){
        // Item item = new Item("cat","1",90,"USB","Hoa phat","Vat lieu xay dung nha ",2);
        // listItem.add(item);
        try(BufferedWriter  bw = new BufferedWriter(new FileWriter(new File(fileName))))
        {
            for(Item item2: listItem){
                String dong = item2.getName()+","+item2.getId()+","+item2.getPrice()+","+item2.getUnit()+","+item2.getNhaCungCap()+","+item2.getMieuTa()+","+item2.getSoLuong();
                bw.write(dong);
                bw.newLine();
                System.out.println();
            }
            System.out.println("Luu du lieu thanh cong!");
        }catch(IOException e){
            e.printStackTrace();
        }
    }
//Doc tu file 
    public void ReadFile(String fileName){
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while((line =br.readLine())!=null){
                String[] parts = line.split(",");
                // Item item = new Item(parts[0],parts[1],Double.parseDouble(parts[2]),parts[3],new NhaCungCap(parts[4]),parts[5],Integer.parseInt(parts[6]));
                Item item = new Item(parts[0], parts[1], Double.parseDouble(parts[2]), parts[3],
                new NhaCungCap(parts[4]), parts[5], Integer.parseInt(parts[6]));
                listItem.add(item);
            }
        }catch(IOException | NumberFormatException e){
            e.printStackTrace();
        }
    }
    // Đoạn mã code tìm kiếm sản phẩm 
    public Item timKiem(ListItems listSanPham, String id) {
        for (Item i : listSanPham.getListItem()) {
            if (i.getId().equals(id)) {
                return i;
            }
        }
        return null; // Trả về null nếu không tìm thấy sản phẩm
    }
    // Tìm kiểm trả về boolean
    public boolean findItems(String value){
        for(Item k : listItem){
            if(k.getId().equals(value)||k.getName().equals(value)){
                return true;
            }
        }
        return false;
    }
}






//                                             Bên dưới là đoạn mã hàm main test chương trình











// public static void main(String[] args) {
// //     // writeToFile("QuanLyVatTuXayDung\\src\\Data\\ListItem.txt");
//     // ListItems listItem = new ListItems();
// //     // Generate and add 10 sample Item data
// //     for (int i = 0; i < 10; i++) {
// //         Item item = new Item(
// //                 "Item" + i,
// //                 String.valueOf(i),
// //                 10.0 * (i + 1),
// //                 "Unit" + i,
// //                 new NhaCungCap("NCC" + i),
// //                 "Description" + i,
// //                 i + 1
// //         );
// //         listItem.addItem(item);
// //     }
// //     // Write the data to the file
// //     listItem.writeToFile("ListItem.txt");


// // Test hàm changeItem
//     ListItems listItem = new ListItems();
//     listItem.addItem(new Item("Muc 1", "ID1", 10.0, "Unit1", new NhaCungCap ("NCC1"), "Mieu ta 1", 5));
//     listItem.addItem(new Item("Muc 2", "ID2", 15.0, "Unit2", new NhaCungCap ("NCC2"), "Mieu ta 2", 3));
//     Item itemToChange = new Item("Muc 1", "ID1", 10.0, "Unit1", ("NCC3"), "Mieu ta 1", 5);
//     System.out.println("Danh sach truoc khi thay doi");
//     listItem.Output();
//     // Gọi hàm changeItem để thay đổi tên của itemToChange thành "Mục 1 (Thay doi)"
//     listItem.changeItem(itemToChange,"name","Thay doi muc 1");

//     // Hiển thị danh sách sau khi thay đổi
//     System.out.println("Danh sach sau khi thay doi:");
//     listItem.Output();

//     // xử lý cách lấy theo danh sách sản phẩm 
//     // ArrayList<Item> dsSanPham = listItem.getListItem();
//     // for(Item i :dsSanPham){
//     //     int j = 1;
//     //     System.out.println("San pham thu "+j+"\n"+i);
//     //     j +=1;
//     // }
//     // // in ra từng thuộc tính bên trong 
//     // for (Item i : dsSanPham) {
//     //     System.out.println("Ten san pham: " + i.getName());
//     //     System.out.println("Ma san pham: " + i.getId());
//     //     System.out.println("Gia : " + i.getPrice());
//     //     System.out.println("Don vi: " + i.getUnit());
//     //     System.out.println("Nha cung cap: " + i.getNhaCungCap().getName()); // Ví dụ, in tên nhà cung cấp
//     //     System.out.println("Mieu ta: " + i.getMieuTa());
//     //     System.out.println("So luong: " + i.getSoLuong());
//     //     System.out.println("------------------------");
//     // }
//     // // listItem.Output();
// }