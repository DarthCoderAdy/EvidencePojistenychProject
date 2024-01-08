package EvidencePojisteni;

public class Pojisteny {
    private final String jmeno;
    private final String prijmeni;
    private final int vek;
    private final String telefonniCislo;

    /**
     * Konstruktor třídy Pojisteny pro vytvoření instance pojištěné osoby.
     * @param jmeno Jméno pojištěné osoby.
     * @param prijmeni Příjmení pojištěné osoby.
     * @param vek Věk pojištěné osoby.
     * @param telefonniCislo Telefonní číslo pojištěné osoby.
     */
    public Pojisteny(String jmeno, String prijmeni, int vek, String telefonniCislo) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.vek = vek;
        this.telefonniCislo = telefonniCislo;
    }

    /**
     *  Metoda pro získání jména pojištěné osoby.
     * @return Jméno pojištěné osoby.
     */
    public String getJmeno() {
        return jmeno;
    }

    /**
     *  Metoda pro získání příjmení pojištěné osoby.
     * @return Příjmení pojištěné osoby.
     */
    public String getPrijmeni() {
        return prijmeni;
    }

    /**
     * Metoda pro vytvoření textového reprezentace objektu třídy Pojisteny.
     * Tato metoda je přepsána z rodičovské třídy Object a slouží k získání formátovaného řetězce obsahujícího informace
     * o pojištěné osobě, včetně jména, příjmení, věku a telefonního čísla.
     * @return Textový řetězec s informacemi o pojištěné osobě.
     */
    @Override
    public String toString() {
        return String.format("Jméno:\t%s \tPříjmení:\t%s \tVěk:\t%s \tTel. číslo:\t%s", jmeno, prijmeni, vek, telefonniCislo);
    }
}
