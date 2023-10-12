import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Metin giriniz: ");
        String metin = scanner.nextLine();
        scanner.close();

        String[] kelimeler = metin.split("\\s+");
        for (int i = 0; i < kelimeler.length; i++) {
            kelimeler[i] = kelimeler[i].toLowerCase();
        }

        Map<String, Integer> kelimeSayilari = new HashMap<>();

        for (String kelime : kelimeler) {
            if (kelimeSayilari.containsKey(kelime)) {
                kelimeSayilari.put(kelime, kelimeSayilari.get(kelime) + 1);
            } else {
                kelimeSayilari.put(kelime, 1);
            }
        }

        int enCokGecenKelimeSayisi = 0;

        for (Integer sayi : kelimeSayilari.values()) {
            if (sayi > enCokGecenKelimeSayisi) {
                enCokGecenKelimeSayisi = sayi;
            }
        }

        List<String> enCokGecenKelimeler = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : kelimeSayilari.entrySet()) {
            if (entry.getValue() == enCokGecenKelimeSayisi) {
                enCokGecenKelimeler.add(entry.getKey());
            }
        }

        Random random = new Random();
        int randomIndex = random.nextInt(enCokGecenKelimeler.size());
        String secilenKelime = enCokGecenKelimeler.get(randomIndex);

        System.out.println("En çok geçen kelime(ler): " + enCokGecenKelimeler);
        //Max sayıda birden fazla kelime varsa aşağıdaki yorum satırının "//" kısmını kaldırarak maxlardan rastgele bir kelime seçtirebilirsiniz.
        //System.out.println("Rastgele seçilen kelime: " + secilenKelime);
    }
}
