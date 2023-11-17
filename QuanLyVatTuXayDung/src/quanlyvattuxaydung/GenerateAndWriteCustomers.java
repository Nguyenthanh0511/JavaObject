package quanlyvattuxaydung;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateAndWriteCustomers {
    public static void main(String[] args) {
        ListNhaCungCap listNhaCungCap = new ListNhaCungCap();

        // Tạo 10 thông tin nhà cung cấp ngẫu nhiên và thêm vào danh sách
        for (int i = 1; i <= 10; i++) {
            NhaCungCap ncc = generateRandomSupplier(i);
            listNhaCungCap.addNhaCungCap(ncc);
        }

        // Ghi danh sách nhà cung cấp vào file
        listNhaCungCap.writeToFile("QuanLyVatTuXayDung\\src\\Data\\GhiListNhaCungCap.txt");

        System.out.println("Danh sách nhà cung cấp đã được tạo và ghi vào file 'GhiListNhaCungCap.txt'.");
    }

    private static NhaCungCap generateRandomSupplier(int index) {
        Random random = new Random();
        String[] names = {"NCC1", "NCC2", "NCC3", "NCC4", "NCC5", "NCC6", "NCC7", "NCC8", "NCC9", "NCC10"};
        String[] phoneNumbers = {"123456789", "987654321", "5551234567", "9998765432", "1112223333", "4445556666", "7778889999", "3334445555", "6667778888", "1231231234"};
        String[] tenSanPhams = {"ProductA", "ProductB", "ProductC", "ProductD", "ProductE", "ProductF", "ProductG", "ProductH", "ProductI", "ProductJ"};
        String[] addresses = {"An lao","Binh luc","Ha noi","HCM","Long Bien","Ca mau","Hue","Viet Tri","Phu Tho","Lai chau"};

        String name = names[random.nextInt(names.length)];
        String phoneNumber = phoneNumbers[random.nextInt(phoneNumbers.length)];
        String code = "ID" + index;
        String tenSanPham = tenSanPhams[random.nextInt(tenSanPhams.length)];
        String diaChi = addresses[random.nextInt(addresses.length)];

        NhaCungCap ncc = new NhaCungCap(name, code, phoneNumber, diaChi, ArrayList<Item> tenSanPham);

        // Tạo danh sách sản phẩm ngẫu nhiên và thêm vào nhà cung cấp
        for (int i = 1; i <= 3; i++) {
            Item sanPham = generateRandomItem(i);
            ncc.getSanPhams().add(sanPham);
        }

        return ncc;
    }

    private static Item generateRandomItem(int index) {
        Random random = new Random();
        String[] itemNames = {"ItemA", "ItemB", "ItemC", "ItemD", "ItemE", "ItemF", "ItemG", "ItemH", "ItemI", "ItemJ"};
        String itemName = itemNames[random.nextInt(itemNames.length)];
        String itemId = "ItemID" + index;
        double itemPrice = 10.0 * (random.nextDouble() + 1);
        String itemUnit = "Unit" + index;
        String itemDescription = "Description" + index;
        int itemQuantity = random.nextInt(100) + 1;

        return new Item(itemName, itemId, itemPrice, itemUnit, null, itemDescription, itemQuantity);
    }
}
