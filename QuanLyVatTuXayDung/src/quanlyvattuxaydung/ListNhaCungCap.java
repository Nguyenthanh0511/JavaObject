package quanlyvattuxaydung;
import java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
public class ListNhaCungCap {
    ArrayList<NhaCungCap> listNhaCungCap;
    //Khởi tạo construct 
    public ListNhaCungCap(ArrayList<NhaCungCap> listNhaCungCap){
        this.listNhaCungCap = (listNhaCungCap != null)? listNhaCungCap : new ArrayList<>();
    }
    //get list
    public ArrayList<NhaCungCap> getListNhaCungCap(){
        return listNhaCungCap;
    }

    public ListNhaCungCap(){
        this.listNhaCungCap = new ArrayList();
    }
    // lấy danh sách getList 
    //Thay đổi thông tin 
    public void setNhaCungCap(ArrayList<NhaCungCap> listNhaCungCap){
        this.listNhaCungCap = listNhaCungCap;
    }
    // Add a new NhaCungCap to the list
    public void addNhaCungCap(NhaCungCap newNhaCungCap) {
        if (listNhaCungCap.contains(newNhaCungCap)) {
            System.out.println("Nha cung cap da ton tai!");
            return;
        }
        listNhaCungCap.add(newNhaCungCap);
    }

    // Output method to display the list of NhaCungCaps
    public void Output() {
        if (listNhaCungCap == null || listNhaCungCap.isEmpty()) {
            System.out.println("Danh sach rong");
        } else {
            System.out.printf("%-20s %-10s %-15s %-10s %-10s%n", "Name", "ID", "Phone", "Dia Chi", "Ten san pham");
            for (NhaCungCap nhaCungCap : listNhaCungCap) {
                System.out.printf("%-20s %-10s %-15s %-10s",
                        nhaCungCap.getName(), nhaCungCap.getCode(), nhaCungCap.getPhoneNumber(), nhaCungCap.getAddress());

                ArrayList<Item> sanPhams = nhaCungCap.getSanPhams();
                if (sanPhams != null && !sanPhams.isEmpty()) {
                    System.out.print(" ");
                    for (Item sanPham : sanPhams) {
                        System.out.print(sanPham.getName() + ", ");
                    }
                }
                System.out.println();
            }
        }
    }
    // xóa 
    public void removeNhaCungCap(NhaCungCap ncc){
        listNhaCungCap.remove(ncc);
    }

    //Xóa thông tin nhà cùng cápa
    public void nhaCungCapRemove(Scanner sc) {
        System.out.println("Nhap Nha cung cap muon xoa");
        String codeXoa = sc.next();
        NhaCungCap nccXoa = new NhaCungCap();
        nccXoa.setCode(codeXoa);
        removeNhaCungCap(nccXoa);
    }
    
    // Cập nhật nhà cung cấp :
    public void updateNhaCungCap(NhaCungCap updatedNhaCungCap) {
        if (listNhaCungCap.contains(updatedNhaCungCap)) {
            listNhaCungCap.remove(updatedNhaCungCap);
            listNhaCungCap.add(updatedNhaCungCap);
            System.out.println("Cap nhat thong tin thanh cong.");
        } else {
            System.out.println("Khong tim thay Nha cung cap can cap nhat.");
        }
    }
    // Tìm kiếm nhà cung cấp
    public NhaCungCap searchNhaCungCapByCode(String code) {
        for (NhaCungCap nhaCungCap : listNhaCungCap) {
            if (nhaCungCap.getCode().equals(code)) {
                return nhaCungCap;
            }
        }
        return null;
    }
    //Đọc file
    //Ghi thông tin nhà cung cấp
     // writeToFile method
     public void writeToFile(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (NhaCungCap ncc : listNhaCungCap) {
                writer.write(ncc.getName() + "," + ncc.getCode() + "," + ncc.getPhoneNumber() + "," + ncc.getAddress());
                ArrayList<Item> sanPhams = ncc.getSanPhams();
                if (sanPhams != null && !sanPhams.isEmpty()) {
                    writer.write(",");
                    for (Item sanPham : sanPhams) {
                        writer.write(sanPham.getName());
                    }
                }
                writer.newLine();
            }
            System.out.println("Danh sách nhà cung cấp đã được ghi vào file '" + fileName + "'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFromFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                String code = parts[1];
                String phoneNumber = parts[2];
                String address = parts[3];
                String docSanPham = parts.length > 4 ? parts[4] : "";
                
                ArrayList<Item> sanPham = new ArrayList<>();
                if (!docSanPham.isEmpty()) {
                    String[] itemNames = docSanPham.split(";");
                    for (String itemName : itemNames) {
                        Item item = new Item(itemName);
                        sanPham.add(item);
                    }
                }

                NhaCungCap nhaCungCap = new NhaCungCap(name, code, phoneNumber, address, sanPham);
                addNhaCungCap(nhaCungCap);
            }
            System.out.println("Danh sach da duoc doc thanh cong tu file :" + fileName + "'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






    // public void readFromFile(String fileName) {
    //     try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
    //         String line;
    //         while ((line = reader.readLine()) != null) {
    //             // Split the line into parts using commas as the delimiter
    //             String[] parts = line.split(",");
                
    //             // Extract information for the supplier
    //             String name = parts[0];
    //             String code = parts[1];
    //             String phoneNumber = parts[2];
    //             String address = parts[3];
                
    //         // Extract the product information from the fourth field
    //         String docSanPham = parts.length > 4 ? parts[4] : "";
    //         ArrayList<Item> sanPham = new ArrayList<>();
    //         if (!docSanPham.isEmpty()) {
    //             String[] itemNames = docSanPham.split(";");
    //             for (String itemName : itemNames) {
    //                 Item item = new Item(); // Tạo đối tượng Item từ tên sản phẩm
    //                 sanPham.add(item);
    //             }
    //         }
    //         // Create a new supplier object
    //         // NhaCungCap nhaCungCap = new NhaCungCap(name, code, phoneNumber, address, new ArrayList<>());
    //         NhaCungCap nhaCungCap = new NhaCungCap(name, code, phoneNumber, address, new ArrayList<>());
    //         // Add products to the supplier
    //         // nhaCungCap.setSanPhams(sanPham);

    //         // Add the supplier to the list
    //         addNhaCungCap(nhaCungCap);
    //             addNhaCungCap(nhaCungCap);
    //         }
    //         System.out.println("Danh sách nhà cung cấp đã được đọc từ file '" + fileName + "'.");
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
    
    //Ghi file nhà Cung cấp 
    // public void readFile(String filename){
    //     try(BufferedWriter bw = new BufferedWriter(new FileWriter(new File(filename)))){
    //         for(NhaCungCap ncc :listNhaCungCap){
    //             String dong = ncc.getName()+","+ncc.getCode()+","+ncc.getPhoneNumber()+","+ncc.getAddress()+","+
    //         }
    //     }
    // }
}
