package EvidencePojisteni;

import java.time.LocalDate;

public class Pojisteny {
    private final int id;
    private final String jmeno;
    private final String prijmeni;
    private final LocalDate datumNarozeni;
    private final String telefonniCislo;

    /**
     * Konstruktor třídy Pojisteny pro vytvoření instance pojištěné osoby.
     * @param jmeno Jméno pojištěné osoby.
     * @param prijmeni Příjmení pojištěné osoby.
     * @param datumNarozeni Datum narození pojištěné osoby.
     * @param telefonniCislo Telefonní číslo pojištěné osoby.
     */
    public Pojisteny(int id, String jmeno, String prijmeni, LocalDate datumNarozeni, String telefonniCislo) {
        this.id = id;
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.datumNarozeni = datumNarozeni;
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
     * Metoda pro získání Id pojištěné osoby.
     * @return Id pojištěné osoby.
     */
    public int getId() {
        return id;
    }

    /**
     * Metoda pro získání data narození pojištěné osoby.
     * @return Datum narození pojištěné osoby.
     */
    public LocalDate getDatumNarozeni() {
        return datumNarozeni;
    }

    /**
     * Metoda pro získání telefonního čísla pojištěné osoby.
     * @return Telefonní číslo pojištěné osoby.
     */
    public String getTelefonniCislo() {
        return telefonniCislo;
    }

    /**
     * Metoda pro získání textové reprezentace instance pojištěné osoby.
     * @return Textová reprezentace instance pojištěné osoby.
     */
    @Override
    public String toString() {
        return "Pojištěný{Id= " + id +
                " Jméno= " + jmeno +
                ", Příjmení= " + prijmeni +
                ", Datum narození= " + datumNarozeni.format(VstupUzivatele.FORMAT_DATA_BEZ_CASU) +
                ", Telefonní číslo= " + telefonniCislo +
                " }";
    }
}
