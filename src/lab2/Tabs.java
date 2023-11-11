package lab2;
import java.util.Arrays;
import java.util.Random; //do zapełnienia ciągu liczbami (pseudo)losowymi
import java.util.Scanner;
public class Tabs {
    private int rozmiarT = 100; //rozmiar tablic
    private int[] pierwszaT = new int[rozmiarT];
    private int[] drugaT = new int[rozmiarT];
    private int minPierwszaT, maxPierwszaT, minDrugaT, maxDrugaT;
    //zmienne do niepotrzebnie przekombinowanych metod :)
    private int[] kopiaPierwszejT, wiekszaDrugaT, bezElementuPierwszaT, obydwieTablice;
    //deklaracje tablic do zadań
    public Tabs() { //konstruktor obiektu klasy Tabs
        Random random = new Random(); //obiekt klasy Random
        for (int i = 0; i < pierwszaT.length; i++) {
            pierwszaT[i] = random.nextInt(100);
        } //pętla do zapełnienia tablic liczbami z wykorzystaniem metody obiektu klasy Random
        System.out.println("Pierwsza tablica stuelementowa z losowymi liczbami:");
        print(pierwszaT); //metoda do wypisania na konsoli tablicy w bardziej skondensowanej formie
        for (int i = 0; i < drugaT.length; i++) {
            drugaT[i] = random.nextInt(100);
        } //pętla do zapełnienia tablic liczbami z wykorzystaniem metody obiektu klasy Random
        System.out.println("\nDruga tablica stuelementowa z losowymi liczbami:");
        print(drugaT);
    }
    public void sum() { //metoda wyświetla sumę elementów tablic
        System.out.println("\nSuma elementów pierwszej tablicy: "+Arrays.stream(pierwszaT).sum());
        //sum() sumuje stream() pierwszej tablicy, z tego, co rozumiem stream() to ciąg kolejnych elementów
        System.out.println("Suma elementów drugiej tablicy: "+Arrays.stream(drugaT).sum());
    }
    public void maxMin() { //metoda zapisuje max i min wartość z obydwu tablic w zmiennych, których użyję później
        System.out.println();
        maxPierwszaT = Arrays.stream(pierwszaT).max().getAsInt();
        minPierwszaT = Arrays.stream(pierwszaT).min().getAsInt();
        maxDrugaT = Arrays.stream(drugaT).max().getAsInt();
        minDrugaT = Arrays.stream(drugaT).min().getAsInt();
        System.out.println("Najwyższa wartość pierwszej tablicy: "+maxPierwszaT);
        System.out.println("Najniższa wartość pierwszej tablicy: "+minPierwszaT);
        System.out.println("Najwyższa wartość drugiej tablicy: "+maxDrugaT);
        System.out.println("Najniższa wartość drugiej tablicy: "+minDrugaT);
    }
    public void average() { //metoda wyświetla średnie arytmetyczne obydwu tablic
        System.out.println();
        System.out.println("Średnia z elementów pierwszej tablicy: "+Arrays.stream(pierwszaT).average().getAsDouble());
        System.out.println("Średnia z elementów drugiej tablicy: "+Arrays.stream(drugaT).average().getAsDouble());
    }
    public void copy() { //metoda kopiuje zawartość pierwszej tablicy do nowej,
        System.out.println();
        kopiaPierwszejT = Arrays.copyOf(pierwszaT,rozmiarT);
        System.out.println("Utworzono kopię pierwszej tablicy.");
        print(kopiaPierwszejT); //metoda do wyświetlenia na konsoli tablicy
    }
    public void bigger() { //metoda tworzy nową tablicę z elementami większymi od wskazanego przez użytkownika z tablicy drugiej
        System.out.println("\nTworzenie tablicy z elementami większymi od wskazanego z tablicy drugiej. ");
        int wieksza;
        Scanner scanner = new Scanner(System.in);
        while(true) { //pętla while(),  try-catch i if() wymuszają podanie poprawnej liczby
            System.out.print("Podaj liczbę całkowitą(od "+minDrugaT+", do "+maxDrugaT+"): ");
            try {
                wieksza = scanner.nextInt();
                if (wieksza >= minDrugaT && wieksza <= maxDrugaT) break;
            } catch (java.util.InputMismatchException e) {
                System.out.print("Błędna liczba. ");
                scanner.nextLine();
            }
        }
        //scanner.close(); z jakiegoś powodu psuje działanie scanner-a w metodzie remove
        int finalWieksza = wieksza; //IntelliJ każe by zmienna była 'final'
        wiekszaDrugaT = Arrays.stream(drugaT).filter(element -> element >= finalWieksza).toArray();
        //filter() porównuje po kolei każdy z elementów ze stream() do zmiennej i te które dadzą spełnią warunek
        //zapisywane są toArray()
        System.out.println("Nowa tablica: ");
        print(wiekszaDrugaT); //metoda do wyświetlenia na konsoli tablicy
    }
    public void remove() { //metoda do usunięcia elementu z tablicy i zapisania w nowej
        System.out.println("\nTworzenie tablicy bez wskazanego elementu z tablicy pierwszej.");
        int doUsuniecia;
        Scanner scanner = new Scanner(System.in);
        while(true) { //kolejne wymuszenie poprawnych danych
            System.out.print("Podaj liczbę całkowitą(od "+minPierwszaT+", do "+maxPierwszaT
                    +"): ");
            try {
                doUsuniecia = scanner.nextInt();
                int finalDoUsuniecia = doUsuniecia; //IntelliJ każe by zmienna była 'final'
                if (Arrays.stream(pierwszaT).anyMatch(element -> element == finalDoUsuniecia)) break;
                //anyMatch() sprawdza czy w stream() pojawi się szukany element
                else System.out.print("Brak elementu. ");
            } catch (java.util.InputMismatchException e) {
                System.out.print("Nieznany format. ");
                scanner.nextLine();
            }
        }
        int finalDoUsuniecia = doUsuniecia; //IntelliJ każe by zmienna była 'final'
        bezElementuPierwszaT = Arrays.stream(pierwszaT).filter(element -> element != finalDoUsuniecia).toArray();
        System.out.println("Nowa tablica: ");
        print(bezElementuPierwszaT); //metoda do wyświetlenia na konsoli tablicy
    }
    public void merge() { //metoda do łączenia dwóch tablic w jedną
        System.out.println();
        obydwieTablice = new int[pierwszaT.length + drugaT.length];
        //wielkość tablicy to długość pierwszej + długość drugiej tablicy
        System.arraycopy(pierwszaT, 0, obydwieTablice, 0, pierwszaT.length);
        //kopjowanie zawartości pierwszej tablicy od początku, do nowej tablicy, zapis od początku do końca pierwszej tablicy
        System.arraycopy(drugaT, 0, obydwieTablice, pierwszaT.length, drugaT.length);
        //kopjowanie zawartości drugiej tablicy od początku, do nowej tablicy, zapis od końca pierwszej do końca drugiej tablicy
        System.out.println("Tablica powstała z połączenia obydwu tablic: ");
        print(obydwieTablice); //metoda do wyświetlenia na konsoli tablicy
    }
    public void howMany() { //metoda szuka i zlicza ilość wystąpień danej liczby w drugiej tablicy
        System.out.println("\nLiczenie ile razy dany element wystąpił w drugiej tablicy.");
        int liczbaSzukana;
        Scanner scanner = new Scanner(System.in);
        while(true) { //wymuszenie poprawności danych
            System.out.print("Podaj liczbę całkowitą: ");
            try {
                liczbaSzukana = scanner.nextInt();
                if (liczbaSzukana >= minDrugaT && liczbaSzukana <= maxDrugaT) break;
            } catch (java.util.InputMismatchException e) {
                System.out.print("Błędna liczba. ");
                scanner.nextLine();
            }
        }
        int finalLiczbaSzukana = liczbaSzukana; //IntelliJ każe by zmienna była 'final'
        int liczbaWystapien = (int) Arrays.stream(drugaT).filter(element -> element == finalLiczbaSzukana).count();
        if (liczbaWystapien == 1) { //prosty if() do wypisania ile razy występuje zmienna z uwzględnieniem języka polskiego
            System.out.println("Liczba " + finalLiczbaSzukana + " występuje tylko raz.");
        } else if (liczbaWystapien == 0) {
            System.out.println("Liczba " + finalLiczbaSzukana + " nie występuje ani razu.");
        } else {
            System.out.println("Liczba " + finalLiczbaSzukana + " występuje " + liczbaWystapien + " razy.");
        }
        scanner.close();
    }
    public void print(int[] tablica) { //metoda do wyświetlenia na konsoli tablicy
        for (int i = 0; i < tablica.length; i++) {
            System.out.print(tablica[i] + "\t");
            if ((i+1)%20==0 || (i+1) == tablica.length) System.out.println();
        }
    }
}