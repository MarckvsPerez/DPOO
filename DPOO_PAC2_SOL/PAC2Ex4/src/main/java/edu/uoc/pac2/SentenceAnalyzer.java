package edu.uoc.pac2;

/**
 * Classe que analitza i manipula frases mitjançant els mètodes de les classes
 * StringBuilder i StringBuffer.
 *
 * Aquesta classe proporciona funcionalitats per a l'anàlisi i la manipulació
 * de frases, incloent-hi la inversió de paraules, la inversió de la frase i altres
 * operacions relacionades amb la gestió de text.
 */
public class SentenceAnalyzer {

    /**
     * Aquest mètode rep un paràmetre text (String) que conté una frase qualsevol, separada per espais en blanc,
     * i retorna la mateixa frase amb les paraules capgirades, però mantenint l'ordre de la frase.
     *
     * @param input Text que conté la frase a processar.
     * @return La mateixa frase amb les paraules capgirades.
     */
    public static String reverseWords(String input) {
        String[] words = input.split(" "); // Separa la frase en paraules mitjançant espais en blanc
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String reversedWord = new StringBuilder(word).reverse().toString(); // Inverteix la paraula
            result.append(reversedWord); // Afegeix la paraula invertida al resultat
            if (i < words.length - 1) {
                result.append(" "); // Afegeix un espai en blanc després de la paraula (excepte l'última)
            }
        }

        return result.toString();
    }

    /**
     * Aquest mètode rep un paràmetre text (String) que conté una frase i retorna
     * aquesta mateixa frase amb l'ordre de les paraules invertit.
     *
     * @param input Text que conté la frase a processar.
     * @return La mateixa frase amb l'ordre de les paraules invertit.
     */
    public static String reverseSentence(String input) {
        String[] words = input.split(" "); // Separa la frase en paraules mitjançant espais en blanc
        StringBuilder result = new StringBuilder();

        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]); // Afegeix la paraula a l'inrevès al resultat
            if (i > 0) {
                result.append(" "); // Afegeix un espai en blanc després de la paraula (excepte la primera)
            }
        }

        return result.toString();
    }


    /**
     * Aquest mètode rep una cadena de text en anglès (String) i un nombre
     * de desplaçaments (int.). Per a cada caràcter en el text que sigui una lletra, el
     * canvia pel caràcter que es troba a n posicions més endavant (si el valor del
     * desplaçament és positiu) o cap enrere (si el valor del desplaçament és negatiu)
     * dins de l'abecedari. Si s'arriba al final de l'abecedari, es continua pel principi
     * (i viceversa) per assegurar que el desplaçament sigui cíclic.
     *
     * @param text    Text que es vol xifrar.
     * @param shift   Nombre de posicions de desplaçament.
     * @return La cadena xifrada.
     */
    public static String encrypt(String text, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);

            if (Character.isLetter(currentChar)) {
                char base = (Character.isLowerCase(currentChar)) ? 'a' : 'A';
                int offset = (currentChar - base + shift) % 26; // 26 és la longitud de l'abecedari

                if (offset < 0) {
                    offset += 26; // Assegura que el desplaçament sigui cíclic
                }

                char encryptedChar = (char) (base + offset);
                encryptedText.append(encryptedChar);
            } else {
                encryptedText.append(currentChar); // Manté caràcters que no són lletres sense xifrar
            }
        }

        return encryptedText.toString();
    }


    /**
     * Aquest mètode rep una cadena de text en anglès (String) i un nombre
     * de desplaçaments (int.). Realitza la desxifra de la cadena de text mitjançant el
     * desplaçament especificat. És, essencialment, l'operació contrària de l'encriptació.
     *
     * @param text    Text que es vol desxifrar.
     * @param shift   Nombre de posicions de desplaçament.
     * @return La cadena desxifrada.
     */
    public static String decrypt(String text, int shift) {
        return encrypt(text, -shift); // La desxifra és simplement l'encriptació amb un desplaçament negatiu
    }

}
