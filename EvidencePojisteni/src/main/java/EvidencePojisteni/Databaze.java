package EvidencePojisteni;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Databaze {
    private final ArrayList<Pojisteny> klienti;

    /**
     * Konstruktor třídy Databaze sloužící k inicializaci instance databáze a přednaplnění daty.
     * Vytváří nový seznam klientů typu ArrayList a inicializuje databázi pojištěných osob několika předdefinovanými záznamy.
     * Tyto záznamy obsahují jméno, příjmení, věk a telefonní číslo.
     * Přednastavené záznamy mají demonstrační charakter a slouží k zajištění testovacích dat při spuštění programu.
     */
    public Databaze() {
        klienti = new ArrayList<>();
        pridejPojistence("Luke", "Skywalker", 28, "+420601222333");
        pridejPojistence("Anakin", "Skywalker", 48, "+420602333444");
        pridejPojistence("Han", "Solo", 36, "+420603444555");
        pridejPojistence("Leia", "Organa", 28, "+420604555666");
    }

    /**
     * Metoda pro přidání nového záznamu o pojištěné osobě do databáze.
     * Vytváří novou instanci třídy Pojisteny s poskytnutými údaji (jméno, příjmení, věk, telefonní číslo)
     * a přidává ji do seznamu klientů v databázi.
     * @param jmeno Jméno pojištěné osoby.
     * @param prijmeni Příjmení pojištěné osoby.
     * @param vek Věk pojištěné osoby.
     * @param telefonniCislo Telefonní číslo pojištěné osoby.
     */
    public void pridejPojistence(String jmeno, String prijmeni, int vek, String telefonniCislo) {
            klienti.add(new Pojisteny(jmeno, prijmeni, vek, telefonniCislo));
    }

    /**
     * Metoda pro vyhledání pojištěných osob v databázi na základě zadaného jména a příjmení.
     * Prochází seznam klientů v databázi a porovnává záznamy s poskytnutým jménem a příjmením.
     * Pokud nalezne shodný záznam, přidá ho do seznamu nalezených pojištěných osob.
     * @param jmeno Jméno pojištěné osoby k vyhledání.
     * @param prijmeni Příjmení pojištěné osoby k vyhledání.
     * @return Nový seznam nalezených pojištěných osob odpovídajících zadaným kritériím.
     */
    public List<Pojisteny> najdiPojistence(String jmeno, String prijmeni) {
        List<Pojisteny> nalezeni = new ArrayList<>();
        for (Pojisteny klient : klienti) {
            if ((jmeno.equalsIgnoreCase(klient.getJmeno())) && (prijmeni.equalsIgnoreCase(klient.getPrijmeni()))) {
                nalezeni.add(klient);
            }
        }
        return nalezeni;
    }

    /**
     * Metoda pro zobrazení všech pojištěných osob v databázi.
     * Vrací neupravitelný seznam všech pojištěných osob v databázi.
     * Tato metoda umožňuje získání přehledu všech záznamů bez možnosti jejich modifikace.
     * @return Neupravitelný seznam všech pojištěných osob v databázi.
     */
    public List<Pojisteny> zobrazPojistence() {
            return Collections.unmodifiableList(klienti);
    }

    /**
     * Metoda pro vymazání pojištěných osob z databáze na základě zadaného jména a příjmení.
     * Nejprve vyhledá záznamy odpovídající zadaným kritériím a uloží je do seznamu záznamů.
     * Poté postupně odstraní nalezené záznamy z databáze. Vrátí seznam záznamů, které byly úspěšně odstraněny.
     * @param jmeno Jméno pojištěné osoby k vymazání.
     * @param prijmeni Příjmení pojištěné osoby k vymazání.
     * @return Seznam záznamů, které byly úspěšně odstraněny z databáze.
     */
    public List<Pojisteny> vymazPojistence(String jmeno, String prijmeni) {
        List<Pojisteny> zaznamy = najdiPojistence(jmeno, prijmeni);
        for (Pojisteny zaznam : zaznamy) {
            klienti.remove(zaznam);
        }
        return zaznamy;
    }
}
