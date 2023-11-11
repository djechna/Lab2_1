package laboratorium.drugie.cwiczenia;
public class Book { //klasa książka
    private String title; //książka ma tytuł zapisany jako String
    private String author; //autor książki
    private int year; //rok wydania
    private int pageCount; //liczba stron
    private float rating; //ocena użytkowników
    private boolean isAvailable; //czy dostępna

    public Book(String _title, String _author, int _year, int _pageCount, float _rating) { //konstruktor obiektu klasy Book
        this.title = _title;
        this.author = _author;
        this.year = _year;
        this.pageCount = _pageCount;
        this.rating = _rating;
        this.isAvailable = true;
    }

    public void borrowBook() { //prosta metoda sprawdzająca, czy książka jest dostępna, jeśli tak to zmieniająca jej status
        System.out.println();
        if (isAvailable) {
            isAvailable = false;
            System.out.println("Książka \"" + title + "\" została wypożyczona.");
        } else {
            System.out.println("Książka \"" + title + "\" jest już wypożyczona.");
        }
    }

    public void returnBook() { //prosta metoda analogiczna do wcześniejszej
        System.out.println();
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("Książka \"" + title + "\" została zwrócona.");
        } else {
            System.out.println("Książka \"" + title + "\" nie została wypożyczona, więc nie może zostać zwrócona.");
        }
    }

    public void displayBookInfo() { //prosta metoda wypisująca dane obiektu klasy książka
        System.out.println();
        System.out.println("Tytuł: "+title);
        System.out.println("Autor: "+author);
        System.out.println("Rok wydania: "+year);
        System.out.println("Liczba stron: "+pageCount);
        System.out.println("Ocena użytkowników: "+rating);
        System.out.println("Dostępność: "+(isAvailable ? "Dostępna" : "Wypożyczona"));
        //skrócona wersja if() else sprawdzająca czy książka jest dostępna i wyświetlająca odpowiedni komunikat
    }
}