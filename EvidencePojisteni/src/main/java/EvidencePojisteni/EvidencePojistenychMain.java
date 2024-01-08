package EvidencePojisteni;

import java.util.Scanner;

public class EvidencePojistenychMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "Windows-1250");
        SpravcePojistenych spravce = new SpravcePojistenych(new Databaze(), new VstupUzivatele(sc));
        HlavniNabidkaUI nabidka = new HlavniNabidkaUI(sc, spravce);

        nabidka.spustNabidku();
    }
}
