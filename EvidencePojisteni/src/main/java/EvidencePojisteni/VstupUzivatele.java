package EvidencePojisteni;

import java.util.Scanner;

public class VstupUzivatele {
    private final Scanner sc;

    /**
     * Konstruktor třídy VstupUzivatele sloužící k inicializaci instance uživatelského rozhraní.
     * Přijímá jako parametr instanci třídy Scanner, která umožňuje čtení vstupu od uživatele.
     * Tato instance Scanner je klíčová pro interakci s uživatelem prostřednictvím konzole.
     * @param sc Instance třídy Scanner pro čtení vstupu od uživatele.
     */
    public VstupUzivatele(Scanner sc) {
        this.sc = sc;
    }

    /**
     * Metoda pro načítání jména pojištěného od uživatele s kontrolou správnosti zadání.
     * Vstupní parametr 'vstup' slouží k určení, zda uživatel zadává jméno či příjmení.
     * Uživatel je vyzván k zadání jména, přičemž metoda kontroluje správnost zadání.
     * Pokud uživatel zadá prázdný řetězec, je mu nabídnuta možnost pokračovat v zadávání nebo ukončit.
     * Dále se kontroluje délka jména, a pokud neodpovídá přijatelnému rozmezí (2 až 20 znaků),
     * uživateli je sděleno, že délka jména není správná. Cyklus probíhá tak dlouho, dokud není jméno
     * zadáno správně nebo uživatel rozhodne přerušit zadávání.
     * @param vstup Označení, zda uživatel zadává jméno nebo příjmení.
     * @return Načtené jméno pojištěného.
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
     * Uživatel je vyzván k zadání telefonního čísla v předepsaném formátu (+420111222333).
     * Metoda kontroluje délku a formát zadaného čísla. Pokud neodpovídá přijatelnému formátu nebo délce,
     * uživateli je sděleno, že zadání je nesprávné, a vyzván k novému zadání. Cyklus probíhá tak dlouho,
     * dokud uživatel nezadá číslo ve správném formátu.
     * @return Načtené telefonní číslo ve formátu "+420111222333".
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
     * Uživatel je vyzván k zadání věku, přičemž metoda kontroluje, zda zadání odpovídá platnému věku (1 - 120).
     * Pokud uživatel zadá neplatné číslo nebo nečíselný vstup, je mu vypsána chybová zpráva a vyzván k opětovnému zadání.
     * Cyklus probíhá tak dlouho, dokud uživatel nezadá věk ve správném rozmezí.
     * @return Načtený věk od uživatele.
     */
    public int nactiVek () {
        int zadanyVek = 0;
        boolean spravneZadani = false;
        do {
            System.out.println("Zadejte věk:");
            try {
                zadanyVek = Integer.parseInt(sc.nextLine());
                if ((zadanyVek > 0) && (zadanyVek < 120)) {
                    spravneZadani = true;
                } else {
                    System.out.println("Nesprávné zadání, věk musí být mezi 1 - 120");
                }
            } catch (NumberFormatException e) {
                System.out.println("Chyba při čtení čísla, zadejte platné číslo");
            }
        } while (!spravneZadani);
        return zadanyVek;
    }
}




