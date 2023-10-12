import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] dizi = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int indeks = kullaniciIndeksiniAl();
        int sonuc = elemaniGetir(dizi, indeks);
        if (sonuc != -1) {
            System.out.println("Belirtilen indeksteki eleman: " + sonuc);
        } else {
            System.err.println("Hata: Belirtilen indeks dizi boyutunun dışındadır.");
        }
    }
    public static int kullaniciIndeksiniAl() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Indeks giriniz: ");
        return scanner.nextInt();
    }
    public static int elemaniGetir(int[] dizi, int indeks) {
        if (indeks >= 0 && indeks < dizi.length) {
            return dizi[indeks];
        }
        return -1;
    }
}