import java.util.ArrayList;
import java.util.Scanner;

public class Mobile extends Product {
    private int id;
    private int batteryPower;
    private String color;

    private static ArrayList<Mobile> mobilePhones = new ArrayList<> ();
    static Scanner scan = new Scanner (System.in);

    public Mobile (int id , String name , double price , double discountRate , int unitInStock , Brand brand , int storage , int ram , double screenSize , int batteryPower , String color)
    {
        super (id , name , price , discountRate , unitInStock , brand , storage , ram , screenSize);
        this.id = id;
        this.batteryPower = batteryPower;
        this.color = color;
    }

    static
    {
        mobilePhones.add (new Mobile (1 , "SAMSUNG GALAXY A51" , 3199.0 , 0.5 , 5 , Brand.selectBrand (7) , 128 , 6 , 6.5 , 4000 , "Black"));
        mobilePhones.add (new Mobile (2 , "iPhone 11 64 GB" , 7379.0 , 0 , 5 , Brand.selectBrand (0) , 64 , 6 , 6.1 , 3046 , "Blue"));
        mobilePhones.add (new Mobile (3 , "Redmi Note 10Pro 8 GB" , 4012 , 0.5 , 5 , Brand.selectBrand (8) , 128 , 12 , 6.5 , 4000 , "White"));
    }

    public static void phoneMenu ()
    {
        boolean showMenu = true;
        while (showMenu)
        {
            System.out.println ("-----Phone Operations-----");
            System.out.println ("1-List all Phones");
            System.out.println ("2-Add a New Phone");
            System.out.println ("3-Delete a Phone");
            System.out.println ("0-Exit");
            System.out.println ("--------------------------------");
            System.out.print ("Make a choice: ");
            int select = scan.nextInt ();

            switch (select)
            {
                case 1:
                    printPhones ();
                    break;
                case 2:
                    addPhone ();
                    System.out.println ("Product added successfully");
                    break;
                case 3:
                    deletePhone ();
                    mobilePhones.size ();
                    System.out.println ("Product deleted successfully");
                    break;
                case 0:
                    showMenu = false;
                    break;
            }
        }
    }

    public static void printPhones ()
    {
        System.out.println ("1-Telefonlar");
        System.out.println ("2-Telefon ID");
        System.out.println ("3-Marka");
        System.out.print ("Seçiminiz: ");
        int number = scan.nextInt ();
        switch (number)
        {
            case 1:
                printAllPhones ();
                break;
            case 2:
                System.out.print ("ID: ");
                int id = scan.nextInt ();
                filterPhoneById (id);
                break;
            case 3:
                filterPhoneByBrand ();
                break;
        }
    }

    public static void printAllPhones ()
    {
        System.out.println ("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format ("| %-3s | %-30s | %-10s    | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n" ,
                "ID" , "İsim" , "Fiyat" , "Marka" , "Depolama Alanı" , "Ekran" , "Kamera" , "Batarya" , "RAM" , "Renk");
        System.out.println ("---------------------------------------------------------------------------------------------------------------------------------------------------");

        for ( Mobile p : mobilePhones )
        {
            System.out.format ("| %-3d | %-30s | %-10.2f TL | %-10s | %-10d | %-10.1f | %-10d | %-10d | %-10s |\n" ,
                    p.getId () , p.getName () , p.getPrice () , p.getBrand ().getBrandName () ,
                    p.getStorage () , p.getScreenSize () , p.getBatteryPower () , p.getRam () , p.getColor ());
        }
    }

    public static void filterPhoneById (int Id)
    {
        System.out.println ("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format ("| %-3s | %-30s | %-10s    | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n" ,
                "ID" , "İsim" , "Fiyat" , "Marka" , "Depolama Alanı" , "Ekran" , "Kamera" , "Batarya" , "RAM" , "Renk");
        System.out.println ("---------------------------------------------------------------------------------------------------------------------------------------------------");
        boolean a = false;
        for ( Mobile p : mobilePhones )
        {
            if ( p.getId () == Id )
            {
                System.out.format ("| %-3d | %-30s | %-10.2f TL | %-10s | %-10d | %-10.1f| %-10d | %-10d | %-10s |\n" ,
                        p.getId () , p.getName () , p.getPrice () , p.getBrand ().getBrandName () ,
                        p.getStorage () , p.getScreenSize () , p.getBatteryPower () , p.getRam () , p.getColor ());
                a = true;
            }
        }
        if ( !a )
        {
            System.out.println ("Ürün ID si bulunamadı");
        }
    }

    public static void filterPhoneByBrand ()
    {
        Brand.printBrands ();
        System.out.print ("Marka Seçiniz: ");
        int selectBrandNumber = scan.nextInt () - 1;
        System.out.println ("---------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.format ("| %-3s | %-30s | %-10s    | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s | %-10s |\n" ,
                "ID" , "İsim" , "Fiyat" , "Marka" , "Depolama Alanı" , "Ekran" , "Kamera" , "Batarya" , "RAM" , "Renk");
        System.out.println ("---------------------------------------------------------------------------------------------------------------------------------------------------");
        boolean a = false;
        for ( Mobile p : mobilePhones )
        {
            if ( p.getBrand ().getBrandName ().equals (Brand.filterBrand (selectBrandNumber)) )
            {
                System.out.format ("| %-3d | %-30s | %-10.2f TL | %-10s | %-10d | %-10.1f | %-10d | %-10d | %-10s |\n" ,
                        p.getId () , p.getName () , p.getPrice () , p.getBrand ().getBrandName () ,
                        p.getStorage () , p.getScreenSize () , p.getBatteryPower () , p.getRam () , p.getColor ());
                a = true;
            }
        }
        if ( !a )
        {
            System.out.println ("Marka Bulunamadı");
        }
    }

    public static void addPhone ()
    {
        System.out.print ("Ürün Adı: ");
        String name = scan.next () + scan.nextLine ();
        System.out.print ("Fiyat: ");
        double price = scan.nextDouble ();
        System.out.print ("İndirim: ");
        double discountRate = scan.nextDouble ();
        System.out.print ("Ürün Sayısı: ");
        int unitInStock = scan.nextInt ();
        System.out.println ("Marka");
        Brand.printBrands ();
        System.out.print ("Marka Seçiniz: ");
        int selectedBrand = scan.nextInt () - 1;
        while (!( selectedBrand >= 0 && selectedBrand < 9 ))
        {
            System.out.println ("Başarısız Giriş");
            System.out.print ("Marka Seçiniz: ");
            selectedBrand = scan.nextInt () - 1;
        }
        System.out.print ("Depolama Alanı: ");
        int storage = scan.nextInt ();
        System.out.print ("RAM: ");
        int ram = scan.nextInt ();
        System.out.print ("Ekran Boyutu(inch): ");
        double screenSize = scan.nextDouble ();
        System.out.print ("Çözünürlük: ");
        int camera = scan.nextInt ();
        System.out.print ("Batarya Ömrü: ");
        int batteryPower = scan.nextInt ();
        System.out.print ("Renk: ");
        String color = scan.next ();

        int maxId = 0;
        for ( Mobile p : mobilePhones )
        {
            if ( p.getId () > maxId )
            {
                maxId = p.getId ();
            }
        }
        int newPhoneId = maxId + 1;

        mobilePhones.add (new Mobile (newPhoneId , name , price , discountRate , unitInStock , Brand.selectBrand (selectedBrand) , storage , ram , screenSize , batteryPower , color));
    }

    public static void deletePhone ()
    {
        printAllPhones ();
        System.out.print ("Silmek İstediğiniz Telefonun ID si: ");
        int selectId = scan.nextInt ();
        for ( Mobile p : mobilePhones )
        {
            if ( p.getId () == selectId )
            {
                mobilePhones.remove (p);
                break;
            }
        }
    }

    @Override
    public int getId ()
    {
        return id;
    }

    @Override
    public void setId (int id)
    {
        this.id = id;
    }

    public int getBatteryPower ()
    {
        return batteryPower;
    }

    public String getColor ()
    {
        return color;
    }
}