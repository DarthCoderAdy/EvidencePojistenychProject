# EvidencePojistenychProject

# Pojištění - Hlavní Nabídka

Projekt sloužící k evidenci pojištěných osob s interaktivní nabídkou přes konzolové uživatelské rozhraní. Projekt byl vytvořen jako součást zkoušky.

## Spuštění projektu

Pro spuštění projektu je třeba mít nainstalované Java Runtime Environment (JRE) a kompilátor. Postupujte následovně:

Otevřete projekt ve vašem vývojovém prostředí Java (např. IntelliJ IDEA nebo Eclipse).
Kompilujte a spusťte třídu HlavniNabidkaUI.
## Funkce

### 1. Přidání nového pojištěného
   Uživatel může zadat informace o novém pojištěném, který bude přidán do evidence.

### 2. Výpis všech pojištěných
   Zobrazí seznam všech pojištěných osob uložených v evidenci.

### 3. Vyhledání pojištěného podle jména a příjmení
   Uživatel může vyhledat pojištěného podle jména a příjmení.

### 4. Vymazání pojištěného
   Umožňuje uživateli vymazat záznam o konkrétním pojištěném.

### 5. Konec
   Ukončuje program.

## Jak používat

Po spuštění programu vyberte akci zadáním odpovídajícího čísla.
Postupujte podle pokynů na obrazovce.
Po provedení akce vás program zeptá, zda chcete pokračovat nebo ukončit.

## Poznámky pro vývojáře

Projekt využívá třídu SpravcePojistenych pro manipulaci s daty.
Používá konzolové uživatelské rozhraní pro interakci s uživatelem.
Pro napojení na MySQL databázi jsou využity třídy v balíčku Databaze.
Připojení k MySQL databázi
Pro použití s MySQL databází je třeba upravit připojení v třídě Databaze:

Connection spojeni = DriverManager.getConnection("jdbc:mysql://localhost/pojistky?user=root&password=");
Změňte URL, uživatelské jméno a heslo tak, aby odpovídaly vaší MySQL konfiguraci.

## Autor

Adam Sommer

Budu rád za případné připomínky nebo rozšíření funkcí!

Feel free to contribute and enhance the functionality!
