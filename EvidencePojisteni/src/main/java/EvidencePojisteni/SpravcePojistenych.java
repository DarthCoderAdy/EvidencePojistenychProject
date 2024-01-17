package EvidencePojisteni;

import java.time.LocalDate;
import java.util.List;

public class SpravcePojistenych {
    private final Databaze databaze;
    private final VstupUzivatele vstupUzivatele;
    private final String nenalezeno = "Nebyly nalezeny žádné záznamy.";
    private final String prazdnyRetezec = "Jméno pojištěného nesmí být prázdné!\nBudete přesměrováni do hlavní nabídky.";
    public String konecProgramu = "Děkuji za použití programu";

    /**
     * Konstruktor třídy SpravcePojistenych pro vytvoření instance třídy SpravcePojistenych.
     * @param databaze Instance třídy Databaze pro manipulaci s databází.
     * @param vstupUzivatele Instance třídy VstupUzivatele pro načítání vstupu od uživatele.
     */
    public SpravcePojistenych(Databaze databaze, VstupUzivatele vstupUzivatele) {
        this.vstupUzivatele = vstupUzivatele;
        this.databaze = databaze;
    }

    /**
     * Metoda pro přidání nového pojištěného do databáze.
     * Uživatel je vyzván k zadání jména, příjmení, data narození a telefonního čísla pojištěného.
     * Pokud uživatel nezadá jméno nebo příjmení, metoda skončí a vypíše chybovou zprávu.
     */
    public void pridejZaznam() {
        String jmeno = vstupUzivatele.nactiJmeno("jméno");
        if (jmeno.isEmpty()) {
            System.out.println(prazdnyRetezec);
            return;
        }
        String prijmeni = vstupUzivatele.nactiJmeno("příjmení");
        if (prijmeni.isEmpty()) {
            System.out.println(prazdnyRetezec);
            return;
        }
        LocalDate datumNarozeni = vstupUzivatele.nactiDatumNarozeni();
        String telefonniCislo = vstupUzivatele.nactiTelCislo();
        databaze.pridejPojistence(jmeno, prijmeni, datumNarozeni, telefonniCislo);
        System.out.println("Data byla uložena.");
    }

    /**
     * Metoda pro vyhledání a zobrazení záznamů o pojištěných osobách v databázi na základě zadaného jména a příjmení.
     */
    public void vyhledejZaznam() {
        String jmeno = vstupUzivatele.nactiJmeno("jméno");
        if (jmeno.isEmpty()) {
            System.out.println(prazdnyRetezec);
            return;
        }
        String prijmeni = vstupUzivatele.nactiJmeno("příjmení");
        if (prijmeni.isEmpty()) {
            System.out.println(prazdnyRetezec);
            return;
        }
        zpracujZaznamy(jmeno, prijmeni);
    }

    /**
     * Metoda pro zobrazení všech záznamů o pojištěných osobách v databázi.
     */
    public void zobrazZaznamy() {
        zpracujZaznamy(null, null);
    }

    /**
     * Metoda pro zpracování záznamů o pojištěných osobách v databázi na základě zadaného jména a příjmení.
     * Pokud uživatel nezadá jméno nebo příjmení, program zavolá metodu pro zobrazení všech záznamů.
     * Pokud nebyly nalezeny žádné záznamy, je vypsána chybová zpráva o nenalezení dat.
     * @param jmeno Jméno pojištěného.
     * @param prijmeni Příjmení pojištěného.
     */
    private void zpracujZaznamy(String jmeno, String prijmeni) {
        List<Pojisteny> klienti = ((jmeno != null) && (prijmeni != null)) ? databaze.vyhledejPojistence(jmeno, prijmeni) : databaze.zobrazPojistence();
        if (!klienti.isEmpty()) {
            System.out.println("Nalezeny tyto záznamy:");
            for (Pojisteny klient : klienti) {
                System.out.println(klient);
            }
        } else {
            System.out.println(nenalezeno);
        }
    }

    /**
     * Metoda pro vymazání záznamů o pojištěných osobách v databázi na základě zadaného jména a příjmení.
     * Pokud uživatel nezadá jméno nebo příjmení, metoda skončí a vypíše chybovou zprávu.
     */
    public void vymazZaznamy() {
        String jmeno = vstupUzivatele.nactiJmeno("jméno");
        if (jmeno.isEmpty()) {
            System.out.println(prazdnyRetezec);
            return;
        }
        String prijmeni = vstupUzivatele.nactiJmeno("příjmení");
        if (prijmeni.isEmpty()) {
            System.out.println(prazdnyRetezec);
            return;
        }
        List<Pojisteny> klienti = databaze.vyhledejPojistence(jmeno, prijmeni);
        if (!klienti.isEmpty()) {
            databaze.vymazPojistence(jmeno, prijmeni);
            System.out.println("Data byla vymazána.");
        } else {
            System.out.println(nenalezeno);
        }
    }
}
