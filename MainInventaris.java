import java.util.HashMap;

public class MainInventaris {
    public static void main(String[] args) {
        // 1. Inisialisasi HashMap (Key: kodeProduk, Value: objek Produk)
        HashMap<String, Produk> mapInventaris = new HashMap<>();

        // 2. Menambahkan minimal 5 produk ke dalam HashMap
        mapInventaris.put("P001", new Produk("P001", "Laptop", 10));
        mapInventaris.put("P002", new Produk("P002", "Mouse", 25));
        mapInventaris.put("P003", new Produk("P003", "Keyboard", 15));
        mapInventaris.put("P004", new Produk("P004", "Monitor", 8));
        mapInventaris.put("P005", new Produk("P005", "Headset", 12));

        // 3. Cetak Inventaris Awal
        System.out.println("=== DAFTAR INVENTARIS AWAL ===");
        tampilkanInventaris(mapInventaris);

        // 4. Ubah stok via .get(kode).setStok()
        System.out.println("\n--- PROSES UPDATE STOK ---");
        String kodeUpdate = "P002";
        if (mapInventaris.containsKey(kodeUpdate)) {
            mapInventaris.get(kodeUpdate).setStok(30); // Mengubah stok Mouse dari 25 menjadi 30
            System.out.println("Stok produk dengan kode " + kodeUpdate + " (" 
                               + mapInventaris.get(kodeUpdate).getnama() 
                               + ") berhasil diubah menjadi 30.");
        }

        // 5. Hapus satu produk via .remove(kode)
        System.out.println("\n--- PROSES HAPUS PRODUK ---");
        String kodeHapus = "P005";
        if (mapInventaris.containsKey(kodeHapus)) {
            Produk produkDihapus = mapInventaris.remove(kodeHapus); // Menghapus Headset
            System.out.println("Produk " + produkDihapus.getnama() + " (" + kodeHapus + ") telah dihapus dari inventaris.");
        }

        // 6. Cetak Inventaris Akhir
        System.out.println("\n=== DAFTAR INVENTARIS AKHIR ===");
        tampilkanInventaris(mapInventaris);
    }

    // Method pembantu untuk menampilkan daftar dan menghitung total stok
    public static void tampilkanInventaris(HashMap<String, Produk> mapInventaris) {
        int totalStok = 0; // Accumulator untuk menghitung total stok

        // Iterasi dengan For-Each menggunakan for (String key : mapInventaris.keySet())
        for (String key : mapInventaris.keySet()) {
            Produk p = mapInventaris.get(key);
            System.out.println("Kode: " + key + " | Nama: " + p.getnama() + " | Stok: " + p.getStok());
            
            totalStok += p.getStok(); // Menghitung accumulator total stok
        }

        System.out.println("Total Keseluruhan Stok: " + totalStok);
    }
}