package cerinta3;

import java.util.List;
import java.util.Scanner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class MainApp {
    public static void main(String[] args) {
        // 1. Incarcam Spring
        ApplicationContext context = new FileSystemXmlApplicationContext("beans_masini.xml");
        
        // 2. Cerem obiectul care face treaba
        GestiuneMasini manager = (GestiuneMasini) context.getBean("gestiuneMasini");
        
        Scanner scanner = new Scanner(System.in);
        
        while(true) {
            System.out.println("\n================ MENIU MASINI ================");
            System.out.println("1. Adauga o masina noua");
            System.out.println("2. Sterge o masina (dupa nr. inmatriculare)");
            System.out.println("3. Cauta o masina (dupa nr. inmatriculare)");
            System.out.println("4. Afiseaza TOATE masinile");
            System.out.println("5. Cate masini sunt dintr-o anumita marca?");
            System.out.println("6. Cate masini au sub 100.000 km?");
            System.out.println("7. Afiseaza masinile mai noi de 5 ani");
            System.out.println("0. IESIRE");
            System.out.println("==============================================");
            System.out.print("Alege optiunea: ");

            int optiune = scanner.nextInt();
            scanner.nextLine(); 

            switch(optiune) {
                case 1:
                    System.out.print("Nr. Inmatriculare: "); String nr = scanner.nextLine();
                    System.out.print("Marca: "); String marca = scanner.nextLine();
                    System.out.print("An fabricatie: "); int an = scanner.nextInt();
                    System.out.print("Culoare: "); String cul = scanner.nextLine();
                    scanner.nextLine();
                    System.out.print("Km: "); int km = scanner.nextInt();
                    manager.adaugaMasina(nr, marca, an, cul, km);
                    break;
                
                case 2:
                    System.out.print("Introdu Nr. Inmatriculare de sters: ");
                    manager.stergeMasina(scanner.nextLine());
                    break;
                
                case 3:
                    System.out.print("Cauta dupa Nr. Inmatriculare: ");
                    Masina m = manager.cautaMasina(scanner.nextLine());
                    if (m != null) {
                        System.out.println("Masina gasita: " + m);
                    } else {
                        System.out.println("Nu exista masina cu acest numar.");
                    }
                    break;
                
                case 4:
                    System.out.println("\nLista Masini:");
                    List<Masina> lista = manager.getToateMasinile();
                    for (Masina masina : lista) {
                        System.out.println(masina);
                    }
                    break;
                
                case 5:
                    System.out.print("Ce marca cauti? ");
                    String marcaCautata = scanner.next();
                    int nrMasini = manager.numarMasiniMarca(marcaCautata);
                    System.out.println("Sunt " + nrMasini + " masini marca " + marcaCautata);
                    break;
                
                case 6:
                    System.out.println("Masini sub 100k km: " + manager.numarMasiniSub100k());
                    break;
                
                case 7:
                    System.out.println("\nMasini noi (< 5 ani):");
                    List<Masina> noi = manager.getMasiniNoi();
                    for (Masina masina : noi) {
                        System.out.println(masina);
                    }
                    break;
                
                case 0:
                    System.out.println("La revedere!");
                    scanner.close();
                    return; // Opreste programul
                
                default:
                    System.out.println("Optiune invalida! Mai incearca.");
            }
        }
    }
}