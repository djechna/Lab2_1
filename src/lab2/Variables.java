package lab2;
import java.util.Scanner;
public class Variables {
    //deklaracja zmiennych
    private int calkowita;
    private double calkowitaDouble;
    private double zmienno;
    private int zmiennoInt;
    private char znak;
    private int znakInt;
    private boolean logiczna;
    private String logicznaString;

    public Variables() {    //konstruktor obiektu klasy
        Scanner scanner = new Scanner(System.in);

        while(true) {   //pętla sprawdzająca poprawność wprowadzonych danych przez użytkownika
            System.out.print("Podaj liczbę całkowitą: ");
            try {
                this.calkowita = scanner.nextInt();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.print("Nieznany format. ");
                scanner.nextLine();
            }
        }

        while(true) {   //pętla sprawdzająca poprawność wprowadzonych danych przez użytkownika
            System.out.print("Podaj liczbę zmiennoprzecinkową: ");
            try {
                this.zmienno = scanner.nextDouble();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.print("Nieznany format. (przecinek/kropka) ");
                scanner.nextLine();
            }
        }

        System.out.print("Podaj jeden(!) znak z klawiatury: ");
        this.znak = scanner.next().charAt(0);  //pobranie pierwszego znaku z linii w konsoli

        while(true) {   //pętla sprawdzająca poprawność wprowadzonych danych przez użytkownika
            System.out.print("Wpisz \"ture\" lub \"false\": ");
            try {
                this.logiczna = scanner.nextBoolean();
                break;
            } catch (java.util.InputMismatchException e) {
                System.out.print("Nieznany format. ");
                scanner.nextLine();
            }
        }
        //scanner.close(); psuje działanie scannera w klasie Tabs...
    }
    public void conversion() {
        calkowitaDouble = calkowita; // Intellij twierdzi, że rzutowanie w tym przypadku jest zbędne
        zmiennoInt = (int) Math.round(zmienno); // bez Math.round pominięta zostanie część liczby po przecinku
        //Math.round jak sama nazwa wskazuje, zaokrągla liczbę. Nadal jest rzutowana, bo metoda ta zwraca long, nie int
        znakInt = znak; // Intellij twierdzi, że rzutowanie w tym przypadku jest zbędne
        logicznaString = String.valueOf(logiczna); // zmiennych logicznych nie można rzutować, stąd użycie metody
    }
    public void drukuj() {  //bardzo prosta metoda do wyświetlania danych, powinna się nazywać print...
        System.out.println("Wprowadzone dane:");
        System.out.println(calkowita+"\t"+zmienno+"\t"+znak+"\t"+logiczna);
        System.out.println("Dane przekonwertowane:");
        System.out.println(calkowitaDouble+"\t"+zmiennoInt+"\t"+znakInt+"\t"+logicznaString);
    }
}