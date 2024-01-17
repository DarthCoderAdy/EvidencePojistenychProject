package EvidencePojisteni;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class EvidencePojistenychMain {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, StandardCharsets.UTF_8);
        SpravcePojistenych spravce = new SpravcePojistenych(new Databaze(), new VstupUzivatele(sc));
        HlavniNabidkaUI nabidka = new HlavniNabidkaUI(sc, spravce);

        nabidka.spustNabidku();
    }
}

