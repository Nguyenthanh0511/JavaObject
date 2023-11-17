/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quanlyvattuxaydung;

/**
 *
 * @author Administrator
 */
import java.util.*;

public class QuanLyVatTuXayDung {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int luaChon;
        Scanner sc = new Scanner(System.in);
        ListItems listItem = new ListItems();
        ListCustomer listCustomer = new ListCustomer();
        ListNhaCungCap listNhaCungCap = new ListNhaCungCap();
        ListHoaDon listHoaDon = new ListHoaDon();
        int n;

        do {
            System.out.println("********QUAN LY CUA HANG VAT TU XAY DUNG:********");
            System.out.println("1. Quan ly san pham ");
            System.out.println("2. Quan ly nha Khach hang");
            System.out.println("3. Quan ly Nha cung cap");
            System.out.println("4. Quan ly hoa don ");
            System.out.println("6. Thong ke");
            System.out.println("7. Thoat");
            System.out.println("Nhap lua chon");
            luaChon = sc.nextInt();
            System.out.println("***********************************************");

            switch (luaChon) {
                case 1:
                    System.out.println("=========== QUAN LY NHA SAN PHAM ===========");
                    System.out.println("1. Hien thong tin san pham");
                    System.out.println("2. Them san pham");
                    System.out.println("3. Xoa san pham ");
                    System.out.println("4. Tim kiem san pham");
                    System.out.println("5. Sua thong tin san pham");
                    System.out.println("6. Ghi thong tin vao file :");
                    System.out.println("7. Doc file:");
                    System.out.println("8. Sap xep san pham theo muc gia:");
                    System.out.println("9. Thoat");
                    System.out.println("Nhap lua chon: ");
                    int dong = sc.nextInt();
                    System.out.println("========================================");
                    switch (dong) {
                        case 1:
                            listItem.Output();
                            break;
                        case 2:
                            System.out.println("Nhap so luong muon them :");
                            n = sc.nextInt();
                            for (int i = 0; i < n; i++) {
                                Item item = new Item();
                                item.Input();
                                listItem.addItem(item);
                            }
                            break;
                        case 3:
                            System.out.println("Nhap id san pham can xoa: ");
                            String id = sc.next();

                            for (Item item : listItem.getListItem()) {
                                if (id.equals(item.getId())) { // Use equals() for String comparison
                                    listItem.removeItem(item);
                                    System.out.println("San pham da duoc xoa.");
                                    break; // Exit the loop after removing the item
                                }
                            }
                            break;
                        case 4:
                            System.out.println("Nhap id san pham muon tim kiem ");
                            String idTimKiem = sc.next();
                            Item timKiem = listItem.timKiem(listItem, idTimKiem);
                            System.out.println("thong tin id tim kiem ");
                            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s%n", "Ten san pham", "Ma san pham",
                                    "Don vi", "Gia ca", "So luong", "Nha cung cap");
                            timKiem.Output();
                            break;
                        case 5:
                            System.out.println("Nhap id san pham muon thay doi thong tin :");
                            String idSanPhamThayDoi = sc.next();
                            System.out.printf("%-10s %-10s %-10s %-10s %-10s %-10s%n", "Ten san pham", "Ma san pham",
                                    "Don vi", "Gia ca", "So luong", "Nha cung cap");
                            Item timKiemThayDoi = listItem.timKiem(listItem, idSanPhamThayDoi);
                            timKiemThayDoi.Output();
                            System.out.println("Nhap thuoc tinh muon thay doi:");
                            String thuocTinh = sc.next();
                            System.out.println("Nhap gia tri moi hoac nhap 'n' neu khong muon thay doi :");
                            String giaTriMoi = sc.next();
                            listItem.changeItem(listItem, idSanPhamThayDoi, thuocTinh, giaTriMoi);
                            break;
                        case 6:
                            // Add your code for case 6
                            listItem.writeToFile("QuanLyVatTuXayDung\\src\\Data\\ListItem.txt");
                            break;
                        case 7:
                            listItem.ReadFile("QuanLyVatTuXayDung\\src\\Data\\DocListItem.txt");
                            break;
                        case 8:
                            listItem.sortPrice();
                            System.out.println("Hien danh sach sau khi sap xep");
                            listItem.Output();
                            break;
                        case 9:
                            System.out.println("Thoat chuong trinh.");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Lua chon khong hop le.");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("=========== QUAN LY NHA KHACH HANG ===========");
                    System.out.println("1. Hien thong tin nha KHACH HANG");
                    System.out.println("2. Them thong tin khach hang");
                    System.out.println("3. Xoa thong tin khach hang ");
                    System.out.println("4. Tim kiem khach hang");
                    System.out.println("5. Sua thong tin khach");
                    System.out.println("6. Dem so luong khach hang");
                    System.out.println("7. Thoat");
                    System.out.println("Nhap lua chon: ");
                    int dongKhachHang = sc.nextInt();
                    System.out.println("========================================");
                    switch (dongKhachHang) {
                        case 1:
                            // Hiển thị thông tin khách hàng
                            listCustomer.Output();
                            break;

                        case 2:
                            // Thêm thông tin khách hàng
                            System.out.println("Nhap so luong khach hang muon them vao danh sach quan ly");
                            n = sc.nextInt();
                            // Duyệt danh sách
                            for (int i = 1; i <= n; i++) {
                                Customer customer = new Customer();
                                customer.Input();
                                listCustomer.addCustomer(customer);
                            }
                            break;

                        case 3:
                            // Xóa thông tin khách hàng
                            System.out.println("Nhap id ban muon xoa");
                            String id = sc.next();
                            Customer customerToRemove = new Customer();
                            customerToRemove.setCode(id);
                            listCustomer.removeCustomer(customerToRemove);
                            break;

                        case 4:
                            // Tìm kiếm khách hàng
                            System.out.println("Nhap id khach hang muon tim kiem ");
                            String idTimKiem = sc.next();
                            // Customer timKiemCustomer = new Customer();
                            // timKiemCustomer.setId(idTimKiem);
                            Customer foundCustomer = listCustomer.timKiemCustomer(listCustomer, idTimKiem);
                            if (foundCustomer != null) {
                                System.out.println("Thong tin khach hang tim kiem:");
                                foundCustomer.Output();
                            } else {
                                System.out.println("Khong tim thay khach hang co ID: " + idTimKiem);
                            }
                            break;

                        case 5:
                            // Sửa thông tin khách hàng
                            System.out.println("Nhap id khach hang muon sua thong tin:");
                            String idSua = sc.next();
                            Customer customerToUpdate = new Customer();
                            customerToUpdate.setCode(idSua);
                            System.out.println("Nhap thuoc tinh muon thay doi:");
                            sc.nextLine(); // Consume the newline character
                            String thuocTinhSua = sc.nextLine();
                            System.out.println("Nhap gia tri moi hoac nhap 'n' neu khong muon thay doi :");
                            String giaTriMoi = sc.nextLine();
                            listCustomer.updateCustomerInfo(customerToUpdate, thuocTinhSua, giaTriMoi);
                            break;

                        case 6:
                            // Đếm số lượng khách hàng
                            int soLuongKhachHang = listCustomer.soLuongKhachHang();
                            System.out.println("So luong khach hang: " + soLuongKhachHang);
                            break;

                        default:
                            System.out.println("Lua chon khong hop le.");
                            break;
                    }
                    break;

                // ... (Các case khác)
                case 3:
                    // Quản lý hóa đơn
                    System.out.println("=========== QUAN LY Nha Cung Cap ===========");
                    System.out.println("1. Hien thong tin nha Nha Cung Cap");
                    System.out.println("2. Them thong tin Nha Cung Cap");
                    System.out.println("3. Xoa thong tin Nha Cung Cap ");
                    System.out.println("4. Tim kiem Nha Cung Cap");
                    System.out.println("5. Sua thong tin Nha Cung Cap");
                    System.out.println("6. Dem so luong Nha Cung Cap");
                    System.out.println("7. Ghi file");
                    System.out.println("8. Doc file");
                    System.out.println("7. Thoat");
                    System.out.println("Nhap lua chon: ");
                    int dongNhaCungCap = sc.nextInt();
                    System.out.println("========================================");
                    switch (dongNhaCungCap) {
                        case 1:
                            System.out.println("Thong tin nha Cung Cap:");
                            listNhaCungCap.Output();
                            break;
                        case 2:
                            System.out.println("Nha so luong muon them:");
                            int nSoLuong;
                            nSoLuong = sc.nextInt();
                            for (int i = 0; i < nSoLuong; i++) {
                                NhaCungCap ncc = new NhaCungCap();
                                ncc.Input();
                                listNhaCungCap.addNhaCungCap(ncc);
                            }
                            break;
                        case 3:
                            listNhaCungCap.nhaCungCapRemove(sc);
                            break;
                        case 4:
                            // Search Nha Cung Cap
                            System.out.println("Nhap code Nha Cung Cap muon tim kiem:");
                            String searchCode = sc.next();
                            NhaCungCap foundNhaCungCap = listNhaCungCap.searchNhaCungCapByCode(searchCode);
                            if (foundNhaCungCap != null) {
                                System.out.println("Nha Cung Cap tim kiem:");
                                foundNhaCungCap.Output(); // Assume you have an Output method in the NhaCungCap class
                            } else {
                                System.out.println("Khong tim thay Nha Cung Cap.");
                            }
                            break;
                        case 5:
                            // Update Nha Cung Cap
                            System.out.println("Nhap code Nha Cung Cap muon cap nhat:");
                            String updateCode = sc.next();
                            NhaCungCap updateNhaCungCap = listNhaCungCap.searchNhaCungCapByCode(updateCode);
                            if (updateNhaCungCap != null) {
                                updateNhaCungCap.Input(); // Assume you have an Input method in the NhaCungCap class
                                listNhaCungCap.updateNhaCungCap(updateNhaCungCap);
                            } else {
                                System.out.println("Khong tim thay Nha Cung Cap can cap nhat.");
                            }
                            break;
                        case 6:
                            System.out.println("Doc file :");
                            listNhaCungCap.readFromFile("QuanLyVatTuXayDung\\src\\Data\\GhiListNhaCungCap.txt");
                            break;
                        case 7:
                            listNhaCungCap.writeToFile("QuanLyVatTuXayDung\\src\\Data\\GhiListNhaCungCap.txt");
                            break;
                        case 8:
                            break;
                    }
                case 4:
                System.out.println("=========== QUAN LY HOA DON ===========");
                System.out.println("1. Xem danh sach hoa don");
                System.out.println("2. Them hoa don moi");
                System.out.println("3. Xoa hoa don");
                System.out.println("4. Cap nhat thong tin hoa don");
                System.out.println("5. Thoat");
                System.out.println("6. Tim kiem hoa don theo id :");
                System.out.println("7. ");
                System.out.print("Nhap lua chon: ");
    
                int dongHoaDon = sc.nextInt();
                switch (dongHoaDon) {
                    case 1:
                        System.out.println("Danh sach hoa don:");
                        // listHoaDon.; Đang lỗi không thể hiện danh sách 
                        listHoaDon.hienThiDanhSachHoaDon();
                        break;
                    case 2:
                        // Add new order
                        // ... (prompt user for details and add new HoaDon to listHoaDon)
                        break;
                    case 3:
                        // Remove order
                        System.out.print("Nhap ID hoa don muon xoa: ");
                        String orderIdToRemove = sc.next();
                        HoaDon hoaDonToRemove = listHoaDon.timKiemHoaDon(orderIdToRemove);
                        if (hoaDonToRemove != null) {
                            listHoaDon.removeHoaDon(hoaDonToRemove);
                            System.out.println("Da xoa hoa don co ID: " + orderIdToRemove);
                        } else {
                            System.out.println("Khong tim thay hoa don co ID: " + orderIdToRemove);
                        }
                        break;
                    case 4:
                        // Update order information
                        System.out.print("Nhap ID hoa don muon cap nhat: ");
                        String orderIdToUpdate = sc.next();
                        listHoaDon.updateHoaDonInfo(orderIdToUpdate, sc);
                        break;
                    case 5:
                        System.out.println("Thoat chuong trinh. Tam biet!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Lua chon khong hop le. Vui long thu lai.");
                }
            }
            // Điều chỉnh thêm số luọng hóa đơn , tổng tiền hóa đơn 
        } while (true);
    }
}
