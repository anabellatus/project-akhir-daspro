import java.util.Scanner;

public class ProjectAkhir04 {

    static Scanner input = new Scanner(System.in);
    static int tgl;

    static String dataPelanggan[][] = {
        // nama, tanggal pemesanan, tanggal kirim, pilihan kirim, nomor telepon, status bayar, jenis pembayaran, pesanan
            { "Taehyung", "11", "12", "luar kota", "0812222", "lunas", "cash", "nasi kuning, nasi goreng" },
            { "Namjoon", "11", "13", "dalam kota", "0812223", "lunas", "debit", "nasi goreng, tumis sawi, salad buah"},
            { "Suga", "10", "11", "luar kota", "0812232", "dp", "cash", "salad buah"},
            {"", "", "", "", "", "", ""},
            {"", "", "", "", "", "", ""}
    };

    static int dataPesanan[][] = {
        //jumlah pesanan, total pesanan, ongkir
        {30, 150000, 60000},// nasi kuning 15, nasi goreng 15
        {31, 276000, 30000},
        {25, 125000, 60000} //nasi goreng 20, tumis sawi 3, salad buah 8
    };



    static String menuMakanan[] = { "nasi kuning", "nasi goreng", "tumis sawi", "salad buah" };

    static int harga[] = { 8000, 10000, 12000, 5000 };

    public static void main(String[] args) {
        transaksi();

    }

    static void transaksi() {

        String menuDipesan[];
        int jumlahPesanan[][];
        int baris, kodeMenu, jumlahPorsi, totalBayar = 0;

        System.out.print("Masukkan tanggal pesanan diantar : ");
        tgl = input.nextInt();

        tampilMenuMakanan();
        System.out.print("Ingin memesan berapa menu? : ");
        baris = input.nextInt();

        menuDipesan = new String[baris];
        jumlahPesanan = new int[baris][3];

        for (int i = 0; i < baris; i++) {

            System.out.print("Pilih Menu Makanan (1-4) : ");
            kodeMenu = input.nextInt();

            switch (kodeMenu) {
                case 1:
                    menuDipesan[i] = menuMakanan[0];
                    System.out.printf("Ingin pesan menu %s berapa porsi? : ", menuMakanan[0]);
                    jumlahPorsi = input.nextInt();
                    jumlahPesanan[i][0] = jumlahPorsi;
                    jumlahPesanan[i][1] = harga[0];
                    jumlahPesanan[i][2] = jumlahPorsi * harga[0];
                    totalBayar += jumlahPesanan[i][2];
                    break;
                case 2:
                    menuDipesan[i] = menuMakanan[1];
                    System.out.printf("Ingin pesan menu %s berapa porsi? : ", menuMakanan[0]);
                    jumlahPorsi = input.nextInt();
                    jumlahPesanan[i][0] = jumlahPorsi;
                    jumlahPesanan[i][1] = harga[1];
                    jumlahPesanan[i][2] = jumlahPorsi * harga[1];
                    totalBayar += jumlahPesanan[i][2];
                    break;
                case 3:
                    menuDipesan[i] = menuMakanan[2];
                    System.out.printf("Ingin pesan menu %s berapa porsi? : ", menuMakanan[0]);
                    jumlahPorsi = input.nextInt();
                    jumlahPesanan[i][0] = jumlahPorsi;
                    jumlahPesanan[i][1] = harga[2];
                    jumlahPesanan[i][2] = jumlahPorsi * harga[2];
                    totalBayar += jumlahPesanan[i][2];
                    break;
                case 4:
                    menuDipesan[i] = menuMakanan[3];
                    System.out.printf("Ingin pesan menu %s berapa porsi? : ", menuMakanan[0]);
                    jumlahPorsi = input.nextInt();
                    jumlahPesanan[i][0] = jumlahPorsi;
                    jumlahPesanan[i][1] = harga[3];
                    jumlahPesanan[i][2] = jumlahPorsi * harga[3];
                    totalBayar += jumlahPesanan[i][2];
                    break;
                default:
                    System.out.println("inputan menu tidak valid");
                    i--;
            }
        }

        System.out.println("Berikut menu makanan yang anda pesan : ");
        System.out.println("-------------------------------------------------------------------------");
        System.out.println("|\tNama Menu\t|\tJumlah\t|\tHarga\t|\tTotal\t|");
        System.out.println("-------------------------------------------------------------------------");
        for (int i = 0; i < menuDipesan.length; i++) {
            System.out.printf("|\t%s\t|\t%s\t|\t%s\t|\t%s\t|", menuDipesan[i], jumlahPesanan[i][0], jumlahPesanan[i][1],
                    jumlahPesanan[i][2]);
            System.out.println("\n-------------------------------------------------------------------------");
        }

        System.out.println("Total Pesanan sebanyak : " + totalBayar);

        input.nextLine();

        System.out.print("Masukkan tujuan pengiriman (dalam kota/luar kota): ");
        String inputPengiriman = input.nextLine();
        int tarifOngkir = hitungOngkir(inputPengiriman);

        System.out.println("Tarif Ongkos Kirim : " + tarifOngkir);

        totalBayar = hitungTotalBayar(totalBayar, tarifOngkir);

        System.out.println("Total Bayar : " + totalBayar);

    }

    static int hitungTotalBayar(int total, int ongkos) {
        int grandTotal = total + ongkos;
        return grandTotal;
    }

    static int hitungOngkir(String jenisPengiriman) {
        int ongkir;

        if (jenisPengiriman.equalsIgnoreCase("dalam kota")) {
            return ongkir = 30000;
        } else if (jenisPengiriman.equalsIgnoreCase("luar kota")) {
            return ongkir = 60000;
        } else {
            System.out.println("jenis tujuan tidak ada");
            return ongkir = 0;
        }
    }

    static void tampilMenuMakanan() {

        System.out.println("Menu : ");
        System.out.println("-----------------------------------------");
        for (int i = 0; i < menuMakanan.length; i++) {
            System.out.printf("|  %s  |\t%s\t|\t%s\t|\n", i + 1, menuMakanan[i], harga[i]);
            System.out.println("-----------------------------------------");
        }

    }
}