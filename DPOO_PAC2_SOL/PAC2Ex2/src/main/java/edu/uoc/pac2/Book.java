package edu.uoc.pac2;

import java.time.LocalDate;

/**
 * Aquesta classe representa un llibre amb els seus paràmetres i mètodes
 */
public class Book {

    /**
     * Definició de les variables d'instància per a la classe Book.
     */
    private String title;       /** Títol del llibre */
    private String author;       /** Autor del llibre */
    private String genre;        /** Gènere del llibre */
    private String publisher;    /** Editorial del llibre */
    private LocalDate releaseDate;  /** Data de publicació del llibre */
    private String language;     /** Idioma del llibre */
    private String isbn;         /** Número d'identificació internacional del llibre (ISBN) */
    private double price;        /** Preu del llibre */

    /**
     * Llista d'idiomes vàlids per a la classe Book.
     */
    private static final String[] validLanguages = {
            "English", "Spanish", "French", "German", "Chinese", "Japanese", "Russian", "Arabic", "Portuguese", "Italian"
    };


    /**
     * Constructor de la classe book
     *
     * @param title       Títol del llibre
     * @param author      Autor del llibre
     * @param genre       Genere del llibre
     * @param publisher   Editorial  del llibre
     * @param releaseDate Data de publicació del llibre
     * @param language    Idioma  del llibre
     * @param isbn        ISBN  del llibre
     * @param price       Preu del llibre.
     */
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

    /**
     * Obté el títol del llibre
     *
     * @return Títol del llibre
     */
    public String getTitle() {
        return title;
    }

    /**
     * Estableix el títol del llibre.
     *
     * @param title Títol del llibre a establir.
     * @throws IllegalArgumentException Si el títol no compleix el format requerit, es llança una excepció amb un missatge d'error.
     */
    public void setTitle(String title) {
        if (title != null && title.matches("^[a-zA-Z\\s-]*$")) { // Comprova que no es null i que només conté lletres, espais i/o guions
            this.title = title;
        } else {
            throw new IllegalArgumentException("[ERROR] Invalid title format: " + title);
        }
    }

    /**
     * Obté l'autor del llibre.
     *
     * @return L'autor del llibre.
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Estableix l'autor del llibre.
     *
     * @param author L'autor del llibre a establir.
     * @throws IllegalArgumentException Si l'autor no compleix el format requerit, es llança una excepció amb un missatge d'error.
     */
    public void setAuthor(String author) {
        if (author != null && !author.trim().isEmpty()) { // Fem servir trim per eliminar espais en blanc al principi i al final
            this.author = author;
        } else {
            throw new IllegalArgumentException("[ERROR] Invalid author: " + author);
        }
    }


    /**
     * Obté el gènere del llibre.
     *
     * @return Gènere del llibre.
     */

    public String getGenre() {
        return genre;
    }

    /**
     * Estableix el gènere del llibre.
     *
     * @param genre Gènere del llibre a establir.
     * @throws IllegalArgumentException Si el gènere no compleix el format requerit o està buit, es llança una excepció amb un missatge d'error.
     */
    public void setGenre(String genre) {
        if (genre != null && !genre.trim().isEmpty()) { // Fem servir trim per eliminar espais en blanc al principi i al final
            this.genre = genre;
        } else {
            throw new IllegalArgumentException("[ERROR]  Genre cannot be empty" + genre);
        }
    }

    /**
     * Obté l'editorial del llibre.
     *
     * @return Editorial del llibre.
     */
    public String getPublisher() {
        return publisher;
    }

    /**
     * Estableix l'editorial del llibre.
     *
     * @param publisher Editorial del llibre a establir.
     * @throws IllegalArgumentException Si l'editorial no compleix el format requerit, es llança una excepció amb un missatge d'error.
     */
    public void setPublisher(String publisher) {
        if (publisher != null && publisher.matches("^[a-zA-Z0-9\\s,\\.\\(\\)]*$")) { // Comprovar si és null i compleix les restriccions.
            this.publisher = publisher;
        } else {
            throw new IllegalArgumentException("[ERROR] Invalid publisher format." + publisher);
        }
    }

    /**
     * Obté la data de publicació del llibre.
     *
     * @return Data de publicació del llibre.
     */

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    /**
     * Estableix la data de publicació del llibre.
     *
     * @param releaseDate Data de publicació del llibre a establir.
     * @throws IllegalArgumentException Si la data de publicació no compleix els requisits especificats, es llança una excepció amb un missatge d'error.
     */
    public void setReleaseDate(LocalDate releaseDate) {
        LocalDate currentDate = LocalDate.now(); // Data actual
        LocalDate oldestDate = currentDate.minusYears(200); // Data de fa 200 anys

        if (releaseDate.isAfter(oldestDate) && !releaseDate.isAfter(currentDate)) { // Si es posterior a oldestDate  i no es posterior a la data d'avui
            this.releaseDate = releaseDate;
        } else {
            throw new IllegalArgumentException("[ERROR] Invalid release date. It should be within the last 200 years and not in the future.");
        }
    }


    /**
     * Obté l'idioma del llibre.
     *
     * @return Idioma del llibre.
     */
    public String getLanguage() {
        return language;
    }

    /**
     * Comprova si un idioma és vàlid en funció de la llista d'idiomes vàlids.
     *
     * @param language Idioma a comprovar.
     * @return Cert si l'idioma és vàlid, fals altrament.
     */
    private boolean isValidLanguage(String language) {
        for (String validLang : validLanguages) { // Per cada valor de validLanguages
            if (validLang.equals(language)) { // Si coincideix
                return true;
            }
        }
        return false; // Si no
    }

    /**
     * Estableix l'idioma del llibre.
     *
     * @param language Idioma del llibre a establir.
     * @throws IllegalArgumentException Si l'idioma no és vàlid, es llança una excepció amb un missatge d'error.
     */
    public void setLanguage(String language) {
        if (isValidLanguage(language)) { // Si és vàlid
            this.language = language;
        } else {
            throw new IllegalArgumentException("[ERROR] Invalid language."); // Missatge d'error.
        }
    }

    /**
     * Obté el preu del llibre.
     *
     * @return Preu del llibre.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Estableix el preu del llibre.
     *
     * @param price Preu del llibre a establir.
     * @throws IllegalArgumentException Si el preu és negatiu o zero, es llança una excepció amb un missatge d'error.
     */
    public void setPrice(double price) {
        if (price > 0) { // Si és positiu
            this.price = price;
        } else {
            throw new IllegalArgumentException("[ERROR] Price cannot be neither negative nor zero."); // Missatge d'error
        }
    }

    /**
     * Comprova si aquest llibre és més econòmic que un altre llibre donat.
     *
     * @param otherBook Llibre amb el qual comparar el preu.
     * @return Cert si aquest llibre és més econòmic que l'altre llibre, fals altrament.
     */
    public boolean isCheaperThan(Book otherBook) {
        return this.price < otherBook.getPrice(); // Compara el preu amb el preu del llibre passat com a paràmetre
    }

    /**
     * Comprova si aquest llibre està escrit per un autor amb un nom donat, ignorant majúscules i minúscules.
     *
     * @param authorName Nom de l'autor a comparar.
     * @return Cert si aquest llibre està escrit per l'autor amb el nom donat, ignorant majúscules i minúscules, fals altrament.
     */
    public boolean isWrittenBy(String authorName) {
        return this.author.equalsIgnoreCase(authorName); // Compara autor ignorant les majúscules i minúscules
    }


    /**
     * Comprova si aquest llibre es considera una obra clàssica, la qual es defineix com una obra amb més de 50 anys de publicació.
     *
     * @return Cert si el llibre es considera una obra clàssica, fals altrament.
     */
    public boolean isClassic() {
        LocalDate currentDate = LocalDate.now();
        LocalDate releaseDate = this.releaseDate;
        LocalDate fiftyYearsAgo = currentDate.minusYears(50);

        return releaseDate.isBefore(fiftyYearsAgo);
    }

    /**
     * Obté el número d'identificació internacional del llibre (ISBN).
     *
     * @return ISBN del llibre.
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Estableix el número d'identificació internacional del llibre (ISBN).
     *
     * @param isbn ISBN del llibre a establir.
     * @throws IllegalArgumentException Si l'ISBN no compleix els requisits de longitud o conté caràcters no numèrics, es llança una excepció amb un missatge d'error.
     */
    public void setIsbn(String isbn) {
        // Elimina caràcters no numèrics (0-9) de l'ISBN
        String cleanedIsbn = isbn.replaceAll("[^0-9]", "");

        // Verifica la longitud de la cadena
        if (cleanedIsbn.length() == 10 || cleanedIsbn.length() == 13) {
            this.isbn = cleanedIsbn;
        } else {
            throw new IllegalArgumentException("[ERROR] Format d'ISBN no vàlid.");
        }
    }

    /**
     * Aplica un descompte al preu del llibre en funció d'un percentatge donat.
     *
     * @param discountPercentage Percentatge de descompte a aplicar.
     * @return Preu amb el descompte aplicat.
     * @throws IllegalArgumentException Si el percentatge de descompte no està dins de l'interval 0-100, es mostra un missatge d'error i es retorna -1.
     */
    public double applyDiscount(double discountPercentage) {
        if (discountPercentage >= 0 && discountPercentage <= 100) {
            double discountedPrice;

            // Calcula el preu descomptat
            discountedPrice = price * (1 - discountPercentage / 100);

            return discountedPrice;
        } else {
            System.out.println("[ERROR] Percentatge de descompte no vàlid.");
            return -1;
        }
    }
}
