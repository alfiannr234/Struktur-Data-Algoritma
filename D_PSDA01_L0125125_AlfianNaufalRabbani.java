import java.util.Scanner; // import scanner

class nilaisiswa {
    public static void main(String[] args) {
        // buat fungsi input dari user
        Scanner input = new Scanner(System.in);

        // menentukan jumlah siswa
        int jumlah;
        System.out.print("jumlah siswa: ");
        jumlah = input.nextInt();
        int[] nilai = new int[jumlah];

        // deklarasi variabel total
        int total = 0;

        // input nilai berdasarkan jumlah siswa
        for (int i = 0; i < jumlah; i++) {
            System.out.print("nilai siswa ke-" + (i + 1) + ": ");
            nilai[i] = input.nextInt();
            // hitung semua total nilai siswa
            total += nilai[i];
        }

        // hitung rata2 total nilai siswa
        double rata = total / jumlah;
        System.out.println("rata-rata: " + rata);

        // menentukan grade berdasarkan rata2
        if (rata >= 90) {
            System.out.println("grade A");
        } else if (rata >= 80) {
            System.out.println("grade B");
        } else if (rata >= 70) {
            System.out.println("grade C");
        } else {
            System.out.println("grade D");
        }
    }
}