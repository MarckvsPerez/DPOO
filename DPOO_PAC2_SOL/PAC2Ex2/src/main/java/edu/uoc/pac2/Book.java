package edu.uoc.pac2;

import java.time.LocalDate;
import java.util.Date;

public class Book {

    /* Definició de variables */
    private String title;
    private String author;
    private String genre;
    private String publisher;
    private LocalDate releaseDate;
    private String language;
    private String isbn;
    private double price;
    private static String[] validLanguages = {
            "English", "Spanish", "French", "German", "Chinese", "Japanese", "Russian", "Arabic", "Portuguese", "Italian"
    };

    /* Constructor classe book */
    public Book(String title, String author, String genre, String publisher, LocalDate releaseDate, String language, String isbn, double price) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.publisher = publisher;
        this.releaseDate = releaseDate;
        this.language = language;
        this.isbn = isbn;
        this.price = price;
    }

    /* Titol */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && title.matches("^[a-zA-Z\\s-]*$")) { // Comprova que no es null i que només conté lletres, espais i/o guions
            this.title = title;
        } else {
            System.out.println("[ERROR] Invalid title format."); // Missatge d'error
        }
    }

    /* Autor */
    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author != null && !author.trim().isEmpty()) { // Fem servir trim per eliminar  espais en blanc al principi i al final
            this.author = author;
        } else {
            System.out.println("[ERROR] Author cannot be empty."); // Missatge d'error
        }
    }


    /* Genere */

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        if (genre != null && !genre.trim().isEmpty()) { // Fem servir trim per eliminar  espais en blanc al principi i al final
            this.genre = genre;
        } else {
            System.out.println("[ERROR] Genre cannot be empty."); // Missatge d'error
        }
    }

    /* Editorial */
    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        if (publisher != null && publisher.matches("^[a-zA-Z0-9\\s,\\.\\(\\)]*$")) { // Comprobar si és null i cumpleix les restriccions.
            this.publisher = publisher;
        } else {
            System.out.println("[ERROR] Invalid publisher format."); // Missatge d'error.
        }
    }

    /* Data */

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        LocalDate currentDate = LocalDate.now(); // Data actual
        LocalDate oldestDate = currentDate.minusYears(200); // Data de fa 200 anys

        if (releaseDate.isAfter(oldestDate) && !releaseDate.isAfter(currentDate)) { // Si es posterior a oldestDate  i no es posterior a la data d'avui
            this.releaseDate = releaseDate;
        } else {
            System.out.println("[ERROR] Invalid release date. It should be within the last 200 years and not in the future."); // Missatge d'error
        }
    }


    /* Llengua */

    public String getLanguage() {
        return language;
    }

    private boolean isValidLanguage(String language) {
        for (String validLang : validLanguages) { // Per cada valor de validLanguages
            if (validLang.equals(language)) { // Si coincideix
                return true;
            }
        }
        return false; // Sino
    }

    public void setLanguage(String language) {
        if (isValidLanguage(language)) { // Si es valid
            this.language = language;
        } else {
            System.out.println("[ERROR] Invalid language."); // Misstage d'error.
        }
    }

    /* Preu */

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        if (price > 0) { // Si es positiu
            this.price = price;
        } else {
            System.out.println("[ERROR] Price cannot be neither negative nor zero."); // Missatge d'error
        }
    }

    /* Comparador */
    public boolean isCheaperThan(Book otherBook) {
        return this.price < otherBook.getPrice(); // Compara el preu amb el preu del llibre passat com a parametre
    }

    /* Es escrit */
    public boolean isWrittenBy(String authorName) {
        return this.author.equalsIgnoreCase(authorName); // Compara autor ignorant les majúscules i minúscules
    }


    /*Classic */
    public boolean isClassic() {
        LocalDate currentDate = LocalDate.now();
        LocalDate releaseDate = this.releaseDate;
        LocalDate fiftyYearsAgo = currentDate.minusYears(50);

        return releaseDate.isBefore(fiftyYearsAgo);
    }

    /* ISBN */

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        // Eliminar caracteres no numerics (0-9) del ISBN
        String cleanedIsbn = isbn.replaceAll("[^0-9]", "");


        // Verificar la longitud de la cadena
        if (cleanedIsbn.length() == 10 || cleanedIsbn.length() == 13) {
            this.isbn = cleanedIsbn;
        } else {
            System.out.println("[ERROR] Invalid ISBN format."); // Missatge error
        }
    }

    /* Descomptes */
    public double applyDiscount(double discountPercentage) {
        if (discountPercentage >= 0 && discountPercentage <= 100) { // Comproba si el descompte està entre 0 i 100
            double discountedPrice;

            // Calcula el preu
            discountedPrice = price * (1 - discountPercentage / 100);

            return discountedPrice;
        } else {
            System.out.println("[ERROR] Invalid discount percentage.");
            return -1;
        }
    }
}
