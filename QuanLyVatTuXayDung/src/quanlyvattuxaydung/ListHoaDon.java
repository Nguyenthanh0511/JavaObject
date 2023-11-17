package quanlyvattuxaydung;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Scanner;
public class ListHoaDon {
    private static ArrayList<HoaDon> listHoaDon = new ArrayList<HoaDon>();
    public ListHoaDon(ArrayList<HoaDon> listHoaDon) {
        this.listHoaDon = (listHoaDon != null) ? listHoaDon : new ArrayList<>();
    }
    public ListHoaDon() {
        this.listHoaDon = new ArrayList<>();
    }
    public ArrayList<HoaDon> getListHoaDon() {
        return listHoaDon;
    }
    public void setListHoaDon(ArrayList<HoaDon> listHoaDon) {
        this.listHoaDon = listHoaDon;
    }
    public void addHoaDon(HoaDon hoaDon) {
        listHoaDon.add(hoaDon);
    }
    public void removeHoaDon(HoaDon hoaDon) {
        listHoaDon.remove(hoaDon);
    }
    
    // Find HoaDon by ID
    public boolean findHoaDonById(String id){
        for(HoaDon i : listHoaDon){
            if(i.getId().equals(id)){
                return true;
            }
        }
        return false;
    }
    public HoaDon timKiemHoaDon(String maHoaDon) {
        for (HoaDon hoaDon : listHoaDon) {
            if (hoaDon.getId().equals(maHoaDon)) {
                return hoaDon; // Trả về hóa đơn nếu tìm thấy
            }
        }
        return null; // Trả về null nếu không tìm thấy hóa đơn
    }
    // Update HoaDon information
    public void updateHoaDonInfo(String orderId, Scanner scanner) {
        HoaDon hoaDonToUpdate = timKiemHoaDon(orderId);
        if (hoaDonToUpdate != null) {
            // Hiển thị hóa đơn hiện tại
            System.out.println("Hoa Don hien tai:");
            hienThiDanhSachHoaDon();
            // Hiện thị hóa đơn
            System.out.println("Nhap thong tin hoa don can oder ::");

            System.out.print("ID hoa don moi :: ");
            String newOrderId = scanner.next();
            hoaDonToUpdate.setId(newOrderId);
            System.out.print("Thoi gian :: ");
            String newDateTime = scanner.next();
            hoaDonToUpdate.setDateTime(newDateTime);

            System.out.println("Cap nhat thanh cong.");
            System.out.println("Cap nhat chi tiet:");
            hienThiDanhSachHoaDon();
        } else {
            System.out.println("Order not found!");
        }
    }
    public void hienThiDanhSachHoaDon() {
        for (HoaDon hoaDon : listHoaDon) {
            hoaDon.Output();
            System.out.println("=============================");
        }
    }
    // Ghi file
    // public void writeToFile(String fileName) {
    //     try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
    //         for (HoaDon hoaDon : listHoaDon) {
    //             writer.write(hoaDon.toCSV()); // Sử dụng một phương thức toCSV trong HoaDon để tạo chuỗi CSV
    //             writer.newLine();
    //         }
    //         System.out.println("Danh sách hoa don đã được ghi vào file '" + fileName + "'.");
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
    
    // Đọc file
    // public void readFromFile(String fileName) {
    //     try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
    //         String line;
    //         while ((line = reader.readLine()) != null) {
    //             HoaDon hoaDon = parseHoaDonFromCSV(line); // Sử dụng một phương thức parseHoaDonFromCSV để tạo HoaDon từ chuỗi CSV
    //             if (hoaDon != null) {
    //                 addHoaDon(hoaDon);
    //             }
    //         }
    //         System.out.println("Danh sách hóa đơn đã được đọc từ file '" + fileName + "'.");
    //     } catch (IOException e) {
    //         e.printStackTrace();
    //     }
    // }
    
    // // Phương thức parse HoaDon từ chuỗi CSV
    // private HoaDon parseHoaDonFromCSV(String line) {
    //     try {
    //         String[] parts = line.split(",");
    //         String id = parts[0];
    //         String dateTime = parts[1];
    //         String nhaCungCapCode = parts[2];
    //         String employeeId = parts[3];
    //         String listItemData = parts[4];
    
    //         //... (Tìm hoặc tạo NhaCungCap và Employee)
    
    //         // Tạo HoaDon
    //         return new HoaDon(id, dateTime, nhaCungCap, employee, listSanPham);
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return null;
    //     }
    // }
}

