package EvidencePojisteni;

import java.util.List;

public class SpravcePojistenych {
    private final Databaze databaze;
    private final VstupUzivatele vstupUzivatele;
    private final String nenalezeno = "Nebyly nalezeny žádné záznamy.";
    private final String prazdnyRetezec = "Jméno pojištěného nesmí být prázdné!\nBudete přesměrováni do hlavní nabídky.";
    public String konecProgramu = "Děkuji za použití programu";

    /**
     * Konstruktor třídy SpravcePojistenych sloužící k inicializaci instance správce pojištěných osob.
     * Přijímá dvě důležité závislosti - instanci třídy Databaze a VstupUzivatele.
     * Tyto závislosti jsou nezbytné pro správné fungování třídy, protože Databaze obsahuje
     * metody pro manipulaci s daty pojištěných osob a VstupUzivatele zajišťuje uživatelské rozhraní pro interakci.
     * @param databaze Instance třídy Databaze, která poskytuje metody pro práci s daty o pojištěných osobách.
     * @param vstupUzivatele Instance třídy VstupUzivatele, která zprostředkovává interakci uživatele s programem prostřednictvím uživatelského rozhraní.
     */
    public SpravcePojistenych(Databaze databaze, VstupUzivatele vstupUzivatele) {
        this.vstupUzivatele = vstupUzivatele;
        this.databaze = databaze;
    }

    /**
     * Metoda pro přidání nového záznamu o pojištěné osobě do databáze.
     * Uživatel je vyzván k zadání jména, příjmení, věku a telefonního čísla.
     * Pokud uživatel nezadá jméno nebo příjmení, metoda skončí a vypíše chybovou zprávu.
     * Po úspěšném zadání údajů dojde k uložení nového záznamu do databáze.
     * Po dokončení vypíše potvrzující zprávu o uložení dat.
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
        int vek = vstupUzivatele.nactiVek();
        String telefonniCislo = vstupUzivatele.nactiTelCislo();
        databaze.pridejPojistence(jmeno, prijmeni, vek, telefonniCislo);
        System.out.println("Data byla uložena.");
    }

    /**
     * Metoda pro vyhledání a zobrazení záznamů o pojištěné osobě v databázi.
     * Uživatel je vyzván k zadání jména a příjmení pojištěné osoby.
     * Pokud uživatel nezadá jméno nebo příjmení, metoda skončí a vypíše chybovou zprávu.
     * Po úspěšném zadání údajů dojde k vyhledání záznamů v databázi a jejich zobrazení.
     * Pokud nebyly nalezeny žádné záznamy, vypíše se chybová zpráva o nenalezení dat.
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
     * Volá interní metodu zpracujZaznamy s parametry null, null, což v praxi znamená
     * získání a zobrazení všech dostupných záznamů bez filtru podle jména a příjmení.
     * Pokud databáze obsahuje záznamy, jsou zobrazeny. V opačném případě je vypsána
     * chybová zpráva o nenalezení dat.
     */
    public void zobrazZaznamy() {
        zpracujZaznamy(null, null);
    }

    /**
     * Interní metoda pro zpracování a zobrazení záznamů o pojištěných osobách na základě zadaného jména a příjmení.
     * Pokud jsou poskytnuty jméno a příjmení, volá metodu databáze pro vyhledání záznamů s odpovídajícími parametry.
     * V případě, že nejsou poskytnuty jméno a příjmení, volá metodu databáze pro zobrazení všech dostupných záznamů.
     * Získané záznamy jsou následně zobrazeny na standardní výstup. Pokud nebyly nalezeny žádné záznamy,
     * je vypsána chybová zpráva o nenalezení dat.
     * @param jmeno Jméno pojištěné osoby pro filtrování záznamů (může být null).
     * @param prijmeni Příjmení pojištěné osoby pro filtrování záznamů (může být null).
     */
    private void zpracujZaznamy(String jmeno, String prijmeni) {
        List<Pojisteny> klienti = (jmeno != null && prijmeni != null) ? databaze.najdiPojistence(jmeno, prijmeni) : databaze.zobrazPojistence();
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
     * Metoda pro vyhledání a vymazání záznamů o pojištěných osobách v databázi na základě zadaného jména a příjmení.
     * Uživatel je vyzván k zadání jména a příjmení pojištěné osoby.
     * Pokud uživatel nezadá jméno nebo příjmení, metoda skončí a vypíše chybovou zprávu.
     * Po úspěšném zadání údajů dojde k vyhledání záznamů v databázi s odpovídajícími parametry.
     * Tyto nalezené záznamy jsou následně odstraněny z databáze.
     * Po dokončení vypíše potvrzující zprávu o vymazání dat.
     * Pokud nebyly nalezeny žádné záznamy, je vypsána chybová zpráva o nenalezení dat.
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
        List<Pojisteny> klienti = databaze.vymazPojistence(jmeno, prijmeni);
        if (!klienti.isEmpty()) {
            System.out.println("Záznamy byly vymazány");
        } else {
            System.out.println(nenalezeno);
        }
    }
}
