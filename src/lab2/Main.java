package lab2;
public class Main {
    public static void main(String[] args) {
        Variables var = new Variables();    //utworzenie obiektu klasy Variables
        var.conversion();   //(trochę zbędna)metoda do konwersji typów zmiennych
        var.drukuj();   //użycie metody z klasy do wypisania rezultatu na konsoli
        System.out.println("\n- - - - - - - - - -\n"); //przerywnik między zadaniami
        Tabs tab = new Tabs(); //utworzenie obiektu klasy Tabs
        //każda z metod klasy Tabs, to podpunkt zadania
        tab.sum();
        tab.maxMin();
        tab.average();
        tab.copy();
        tab.bigger();
        tab.remove();
        tab.merge();
        tab.howMany();
    }
}