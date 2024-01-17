package EvidencePojisteni;

import java.util.Scanner;

public class HlavniNabidkaUI {
    private final SpravcePojistenych spravce;
    private final Scanner sc;

    /**
     * Konstruktor třídy HlavniNabidkaUI pro vytvoření instance nabídky evidence pojištěných.
     * @param sc Scanner pro načítání vstupu od uživatele.
     * @param spravce Správce evidence pojištěných.
     */
    public HlavniNabidkaUI(Scanner sc, SpravcePojistenych spravce) {
        this.sc = sc;
        this.spravce = spravce;
    }

    /**
     * Metoda spustNabidku slouží k ovládání interaktivní nabídky evidence pojištěných.
     * Uživateli umožňuje vybírat z různých akcí, jako je přidání nového pojištěného, výpis všech pojištěných,
     * vyhledání pojištěného podle jména a příjmení, vymazání pojištěného nebo ukončení programu.
     * Nabídka je zobrazena v konzoli a uživatel volí akce zadáním čísla příslušné volby.
     * Po každé provedené akci se uživatele ptá, zda chce pokračovat, až do doby, kdy zadá volbu pro ukončení programu.
     * Při neplatných vstupech jsou poskytnuty odpovídající chybové zprávy.
     */
    public void spustNabidku() {
        String pokracovat = "ano";
        String volba = "";
        while ((pokracovat.equals("ano")) && (!volba.equals("5"))) {
            System.out.println("--------------------------");
            System.out.println("EVIDENCE POJISTĚNÝCH");
            System.out.println("--------------------------");
            System.out.println();
            System.out.println("Vyberte si akci:");
            System.out.println("1 - Přidat nového pojištěného");
            System.out.println("2 - Vypsat všechny pojištěné");
            System.out.println("3 - Vyhledat pojištěného podle jména a příjmení");
            System.out.println("4 - Vymaž pojištěného");
            System.out.println("5 - Konec");
            volba = sc.nextLine().trim();
            System.out.println();
            switch (volba) {
                case "1":
                    spravce.pridejZaznam();
                    break;
                case "2":
                    spravce.zobrazZaznamy();
                    break;
                case "3":
                    spravce.vyhledejZaznam();
                    break;
                case "4":
                    spravce.vymazZaznamy();
                    break;
                case "5":
                    System.out.println(spravce.konecProgramu);
                    break;
                default:
                    System.out.println("Zadali jste neplatnou volbu.");
                    break;
            }
            if (!volba.equals("5")) {
                System.out.println("Přejete si pokračovat? [ano/ne]");
                pokracovat = sc.nextLine().trim().toLowerCase();
            }
            if (pokracovat.equals("ne")) {
                System.out.println(spravce.konecProgramu);
            } else if (!pokracovat.equals("ano")) {
                System.out.println("Neplatná volba, program bude ukončen.");
            }
        }

    }
}
