package EvidencePojisteni;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class VstupUzivatele {
    private final Scanner sc;
    /**
     * Konstanta pro formátování data bez času.
     */
    public static final DateTimeFormatter FORMAT_DATA_BEZ_CASU = DateTimeFormatter.ofPattern("d.M.y");

    /**
     * Konstruktor třídy VstupUzivatele pro vytvoření instance třídy VstupUzivatele.
     * @param sc Instance třídy Scanner pro načítání vstupu od uživatele.
     */
    public VstupUzivatele(Scanner sc) {
        this.sc = sc;
    }

    /**
     * Metoda pro načítání data od uživatele s kontrolou správnosti zadání.
     * Uživatel je vyzván k zadání data ve formátu "d.M.y" (např. 1.1.2021).
     * @return Načtené datum ve formátu "d.M.y".
     */
    private LocalDate naparsujDatum() {
        System.out.println("Zadejte datum ve tvaru [" + LocalDate.now().format(FORMAT_DATA_BEZ_CASU) + "]:");
        while (true) {
            try {
                return LocalDate.parse(sc.nextLine(), FORMAT_DATA_BEZ_CASU);
            } catch (Exception ex) {
                System.out.println("Nesprávně zadáno, zadejte prosím znovu.");
            }
        }
    }

    /**
     * Metoda pro načítání jména nebo příjmení od uživatele s kontrolou správnosti zadání.
     * Uživatel je vyzván k zadání jména nebo příjmení pojištěného.
     * @param vstup Textový řetězec, který se má vypsat uživateli před vyzváním k zadání jména nebo příjmení.
     * @return Načtené jméno nebo příjmení pojištěného.
     */
    public String nactiJmeno(String vstup) {
        String zadaneJmeno;
        String pokracovat = "ano";
        boolean spravneZadani = false;
        do {
            System.out.println("Zadejte " + vstup + " pojištěného: ");
            zadaneJmeno = sc.nextLine().trim();
            if (zadaneJmeno.isEmpty()) {
                System.out.println("Zadali jste prázdný řetězec, přejete si pokračovat? [ano/ne]");
                pokracovat = sc.nextLine().toLowerCase().trim();
            } else if (zadaneJmeno.length() < 2 || zadaneJmeno.length() > 20){
                System.out.println("Nesprávná délka jména...");
            } else {
                spravneZadani = true;
            }
        } while (!spravneZadani && pokracovat.equals("ano"));
        return zadaneJmeno;
    }

    /**
     * Metoda pro načítání telefonního čísla od uživatele s kontrolou správnosti zadání.
     * Uživatel je vyzván k zadání telefonního čísla ve formátu "+420111222333".
     * @return Načtené telefonní číslo.
     */
    public String nactiTelCislo() {
        String zadaneCislo;
        boolean spravneZadani = false;
        do {
            System.out.println("Zadejte telefonní číslo ve formátu \"+420111222333\":");
            zadaneCislo = sc.nextLine().trim();
            if (zadaneCislo.length() != 13 || !zadaneCislo.startsWith("+")) {
                System.out.println("Nesprávné zadání! Zadejte číslo ve formátu \"+420111222333\"");
            } else {
                spravneZadani = true;
            }
        } while (!spravneZadani);
        return zadaneCislo;
    }

    /**
     * Metoda pro načítání věku od uživatele s kontrolou správnosti zadání.
     * @return Metodu pro načítání data od uživatele s kontrolou správnosti zadání.
     */
    public LocalDate nactiDatumNarozeni () {
        return naparsujDatum();
    }
}




