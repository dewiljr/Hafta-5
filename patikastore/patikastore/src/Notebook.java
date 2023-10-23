import java.util.ArrayList;
import java.util.Scanner;

public class Notebook extends Product {
    static Scanner input = new Scanner(System.in);

    private int id;
    private static ArrayList<Notebook> notebooks = new ArrayList<>();

    public Notebook (int id , String name , double price , double discountRate , int unitInStock , Brand brand , int storage , int ram , double screenSize)
    {
        super (id , name , price , discountRate , unitInStock , brand , storage , ram , screenSize);
    }

    static {
        notebooks.add(new Notebook(1, "HUAWEI Matebook 14", 7000, 0.5, 5, Brand.selectBrand(4), 512, 16, 14));
        notebooks.add(new Notebook(2, "Lenovo V14 IGL", 3699, 0, 5, Brand.selectBrand(5), 1024, 8, 14));
        notebooks.add(new Notebook(3, "ASUS Tuf Gaming", 8199, 0, 5, Brand.selectBrand(1), 2048, 32, 15.6));
    }



    public static void notebookMenu() {
        boolean showMenu = true;
        while (showMenu) {
            System.out.println("-----Notebook İşlemleri-----");
            System.out.println("1-Tüm Notebooklar");
            System.out.println("2-Notebook Ekleme");
            System.out.println("3-Notebook Silme");
            System.out.println("0-Çıkış");
            System.out.print("Seçiminiz: ");
            int select = input.nextInt();
            switch (select) {
                case 1:
                    printNotebook();
                    break;
                case 2:
                    addNotebook();
                    System.out.println("Yeni Ürününüz Eklendi");
                    break;
                case 3:
                    deleteNotebook();
                    notebooks.size();
                    System.out.println("Seçtiğiniz Ürün Silindi");
                    break;
                case 0:
                    showMenu = false;
                    break;
            }
        }
    }

    public static void printAllNotebooks() {
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-30s | %-10s    | %-10s | %-10s | %-10s | %-10s |\n",
                "ID", "İsim", "Ücret", "Marka", "Alan", "Ekran Boyutu", "RAM");
        System.out.println("-----------------------------------------------------------------------------------------------------------");

        for (Notebook n : notebooks) {
            System.out.format("| %-2d | %-30s | %-10.2f TL | %-10s | %-10d | %-10.1f  | %-10d |\n",
                    n.getId(), n.getName(), n.getPrice(), n.getBrand().getBrandName(),
                    n.getStorage(), n.getScreenSize(), n.getRam());
        }
        System.out.println("-----------------------------------------------------------------------------------------------------------");
    }

    public static void filterNotebookById(int Id) {
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-30s | %-10s    | %-10s | %-10s | %-10s | %-10s |\n",
                "ID", "İsim", "Ücret", "Marka", "Alan", "Ekran Boyutu", "RAM");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        boolean a = false;
        for (Notebook n : notebooks) {
            if (n.getId() == Id) {
                System.out.format("| %-2d | %-30s | %-10.2f TL | %-10s | %-10d | %-10.1f | %-10d |\n",
                        n.getId(), n.getName(), n.getPrice(), n.getBrand().getBrandName(),
                        n.getStorage(), n.getScreenSize(), n.getRam());
                a = true;
            }
        }
        if (!a) {
            System.out.println("Aradığınız Ürün Bulunamadı");
        }
    }

    public static void filterNotebookByBrand() {
        Brand.printBrands();
        System.out.print("Marka Seçiniz: ");
        int selectBrandNumber = input.nextInt() - 1;
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        System.out.format("| %-2s | %-30s | %-10s    | %-10s | %-10s | %-10s | %-10s |\n",
                "ID", "İsim", "Ücret", "Marka", "Alan", "Ekran Boyutu", "RAM");
        System.out.println("-----------------------------------------------------------------------------------------------------------");
        boolean a = false;
        for (Notebook n : notebooks) {
            if (n.getBrand().getBrandName().equals(Brand.filterBrand(selectBrandNumber))) {
                System.out.format("| %-2d | %-30s | %-10.2f TL | %-10s | %-10d | %-10.1f | %-10d |\n",
                        n.getId(), n.getName(), n.getPrice(), n.getBrand().getBrandName(),
                        n.getStorage(), n.getScreenSize(), n.getRam());
                a = true;
            }
        }

        if (!a) {
            System.out.println("Marka Bulunamadı");
        }
    }

    public static void printNotebook() {
        System.out.println("1-Notebooks Listesi");
        System.out.println("2-ID ye göre sıralama");
        System.out.println("3-Markaya göre sıralama");
        System.out.print("Seçiminiz");
        int select = input.nextInt();
        switch (select) {
            case 1:
                printAllNotebooks();
                break;
            case 2:
                System.out.println("ID:");
                int id = input.nextInt();
                filterNotebookById(id);
                break;
            case 3:
                filterNotebookByBrand();
                break;
        }
    }

    public static void addNotebook() {
        System.out.print("Ürün Adı: ");
        String name = input.next() + input.nextLine();
        System.out.print("Ürün Fiyatı: ");
        double price = input.nextDouble();
        System.out.print("İndirim: ");
        double discountRate = input.nextDouble();
        System.out.print("Eklediğiniz ürün sayısı: ");
        int unitInStock = input.nextInt();
        System.out.println("Marka");
        Brand.printBrands();
        System.out.print("Marka Seçiniz: ");
        int selectedBrand = input.nextInt() - 1;
        while (!(selectedBrand >= 0 && selectedBrand < 9)) {
            System.out.println("Geçersiz Giriş");
            System.out.print("Marka: ");
            selectedBrand = input.nextInt() - 1;
        }
        System.out.print("Depolama Alanı: ");
        int storage = input.nextInt();
        System.out.print("RAM: ");
        int ram = input.nextInt();
        System.out.print("Ekran Boyutu(inch): ");
        double screenSize = input.nextDouble();


        int maxId = 0;
        for (Notebook n : notebooks) {
            if (n.getId() > maxId) {
                maxId = n.getId();
            }
        }
        int newNotebookId = maxId + 1;

        notebooks.add(new Notebook(newNotebookId, name, price, discountRate, unitInStock, Brand.selectBrand(selectedBrand), storage, ram, screenSize));
    }

    public static void deleteNotebook() {
        printAllNotebooks();
        System.out.print("Silmek İstediğiniz Ürünün ID si: ");
        int selectId = input.nextInt();
        for (Notebook n : notebooks) {
            if (n.getId()==selectId) {
                notebooks.remove(n);
                break;
            }
        }
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }
}