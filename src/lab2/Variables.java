package lab2;
import java.util.Scanner;
public class Variables {
    //deklaracja zmiennych
    private int calkowita;
    private double zmienno;
    private char znak;
    private boolean logiczna;
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
                System.out.print("Nieznany format. ");
                scanner.nextLine();
            }
        }

        String tmp; //Scanner nie ma wbudowanej metody do odczytu char-u, stąd tymczasowy String
        System.out.print("Podaj jeden(!) znak z klawiatury: ");
        tmp=scanner.next();
        this.znak = tmp.charAt(0);  //pobranie pierwszego znaku ze String-u

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
        scanner.close();
    }
    public void drukuj() {  //bardzo prosta metoda do testowania działania programu
        System.out.printf(calkowita+"\t"+zmienno+"\t"+znak+"\t"+logiczna);
    }
}