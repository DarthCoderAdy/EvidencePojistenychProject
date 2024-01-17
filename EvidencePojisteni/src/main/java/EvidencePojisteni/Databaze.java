package EvidencePojisteni;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Databaze {
    private static final Logger LOGGER = Logger.getLogger(Databaze.class.getName());
    /**
     * Metoda pro přidání nového pojištěného do databáze.
     * Metoda přijímá parametry jméno, příjmení, datum narození a telefonní číslo.
     * @param jmeno Jméno pojištěného.
     * @param prijmeni Příjmení pojištěného.
     * @param datumNarozeni Datum narození pojištěného.
     * @param telefonniCislo Telefonní číslo pojištěného.
     */
    public void pridejPojistence(String jmeno, String prijmeni, LocalDate datumNarozeni, String telefonniCislo) {
        try (Connection spojeni = DriverManager.getConnection("jdbc:mysql://localhost/pojistky?user=root&password=");
             PreparedStatement dotaz = spojeni.prepareStatement("INSERT INTO pojistenci (jmeno, prijmeni, datum_narozeni, tel_cislo) VALUES (?, ?, ?, ?)")) {
            dotaz.setString(1, jmeno);
            dotaz.setString(2, prijmeni);
            dotaz.setDate(3, Date.valueOf(datumNarozeni));
            dotaz.setString(4, telefonniCislo);
            dotaz.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Chyba při komunikaci s databází", ex.getMessage());
        }
    }

    /**
     * Metoda pro vymazání pojištěného z databáze.
     * Metoda přijímá parametry jméno a příjmení.
     *
     * @param jmeno Jméno pojištěného.
     * @param prijmeni Příjmení pojištěného.
     */
    public void vymazPojistence(String jmeno, String prijmeni) {
        try (Connection spojeni = DriverManager.getConnection("jdbc:mysql://localhost/pojistky?user=root&password=");
             PreparedStatement dotaz = spojeni.prepareStatement("DELETE FROM pojistenci WHERE jmeno=? AND prijmeni=?")) {
            dotaz.setString(1, jmeno);
            dotaz.setString(2, prijmeni);
            dotaz.executeUpdate();
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Chyba při komunikaci s databází", ex.getMessage());
        }
    }

    /**
     * Metoda pro vyhledání pojištěného v databázi.
     * Metoda přijímá parametry jméno a příjmení.
     * Metoda vrací seznam pojištěných osob.
     * Pokud nebyl nalezen žádný záznam, vypíše se chybová zpráva.
     *
     * @param jmeno Jméno pojištěného.
     * @param prijmeni Příjmení pojištěného.
     * @return Seznam pojištěných osob.
     */
    public List<Pojisteny> vyhledejPojistence(String jmeno, String prijmeni) {
        List<Pojisteny> vysledky = new ArrayList<>();
        try (Connection spojeni = DriverManager.getConnection("jdbc:mysql://localhost/pojistky?user=root&password=");
             PreparedStatement dotaz = spojeni.prepareStatement("SELECT * FROM pojistenci WHERE jmeno= ? AND prijmeni= ?")) {
            dotaz.setString(1, jmeno);
            dotaz.setString(2, prijmeni);
            ResultSet vysledek = dotaz.executeQuery();
            while (vysledek.next()) {
                int id = vysledek.getInt(1);
                jmeno = vysledek.getString("jmeno");
                prijmeni = vysledek.getString("prijmeni");
                LocalDate datumNarozeni = vysledek.getDate("datum_narozeni").toLocalDate();
                String telCislo = vysledek.getString("tel_cislo");
                vysledky.add(new Pojisteny(id, jmeno, prijmeni, datumNarozeni, telCislo));
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Chyba při komunikaci s databází", ex.getMessage());
        }
        return vysledky;
    }

    /**
     * Metoda pro zobrazení všech pojištěných osob v databázi.
     *
     * @return Seznam všech pojištěných osob v databázi.
     */
    public List<Pojisteny> zobrazPojistence() {
        List<Pojisteny> seznam = new ArrayList<>();
        try (Connection spojeni = DriverManager.getConnection("jdbc:mysql://localhost/pojistky?user=root&password=");
             PreparedStatement dotaz = spojeni.prepareStatement("SELECT * FROM pojistenci");
             ResultSet vysledky = dotaz.executeQuery()) {
            while (vysledky.next()) {
                int id = vysledky.getInt(1);
                String jmeno = vysledky.getString("jmeno");
                String prijmeni = vysledky.getString("prijmeni");
                LocalDate datumNarozeni = vysledky.getDate("datum_narozeni").toLocalDate();
                String telCislo = vysledky.getString("tel_cislo");
                seznam.add(new Pojisteny(id, jmeno, prijmeni, datumNarozeni, telCislo));
            }
        } catch (SQLException ex) {
            LOGGER.log(Level.SEVERE, "Chyba při komunikaci s databází", ex.getMessage());
        }
        return seznam;
    }
}
