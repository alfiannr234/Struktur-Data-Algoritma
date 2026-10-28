import java.util.LinkedList;
import java.util.Queue;

class KlinikSehatSentosa {
    public static void main(String[] args) {
        // antrian menggunakan Queue
        Queue<String> antrian = new LinkedList<>();
        // daftar Panggilan
        Queue<String> panggilanUlang = new LinkedList<>();

        // Adi, Budi, dan Citra mendaftar
        antrian.add("Adi");
        antrian.add("Budi");
        antrian.add("Citra");
        System.out.println("Antrian awal: " + antrian);

        // Dina datang dengan kondisi darurat (prioritas)
        ((LinkedList<String>) antrian).addFirst("Dina");
        System.out.println("Dina datang (Darurat)! Antrian sekarang: " + antrian);

        System.out.println("\nProses Pemanggilan Pasien ");

        // proses pemanggilan
        while (!antrian.isEmpty()) {
            String pasienSekarang = antrian.poll(); // ambil pasien terdepan

            if (pasienSekarang.equals("Adi")) {
                System.out.println("Memanggil: " + pasienSekarang);
                System.out.println("Adi tidak ada di tempat \nDipindahkan ke panggilan ulang");
                panggilanUlang.add(pasienSekarang);
            } else {
                System.out.println("Memanggil: " + pasienSekarang + " \nPasien sedang diperiksa");
            }
        }

        // memanggil daftar panggilan ulang setelah antrian habis
        System.out.println("\nMemproses Daftar Panggilan Ulang ");
        while (!panggilanUlang.isEmpty()) {
            System.out.println("Memanggil kembali: " + panggilanUlang.poll());
        }

        System.out.println("\nSemua pasien sudah ditangani");
    }
}