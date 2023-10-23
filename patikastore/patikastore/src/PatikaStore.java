import java.util.Scanner;

public class PatikaStore {
    public void start() {
        Scanner input = new Scanner(System.in);
        System.out.println("\nWelcome to Patika Store!\n");
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("1-Notebook Ayarlar");
            System.out.println("2-Telefon Ayarlar");
            System.out.println("3-Liste");
            System.out.println("0-Çıkış");
            System.out.println("--------------------------------");
            System.out.print("Seçiminiz: ");
            int selected = input.nextInt();

            switch (selected) {
                case 1:
                    Notebook.notebookMenu();
                    break;
                case 2:
                    Mobile.phoneMenu();
                    break;
                case 3:
                    Brand.printBrands();
                    System.out.println();
                    break;
                case 0:
                    showMenu = false;
                    break;
                default:
                    System.out.println("Lütfen Geçerli Bir Seçim Yapınız");
            }
        }
    }
}