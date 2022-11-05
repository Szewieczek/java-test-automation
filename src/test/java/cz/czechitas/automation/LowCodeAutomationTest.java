package cz.czechitas.automation;

import org.junit.jupiter.api.Test;

/**
 * Test class for custom student tests
 *
 * @author Jiri Koudelka
 * @since 1.0.0
 */
final class LowCodeAutomationTest extends TestRunner {

    /*Napište test, který přejde do sekce Pro rodiče -> Návody a formuláře*/
    @Test
     void jdiNaNavody() {
        prohlizec.jdiDoSekceNavodyAFormulareProRodice();
    }

    /*Napište test, který přejde do sekce Pro učitelé -> Objednávka pro MŠ/ZŠ a jako
    objednávanou službu v dolní části obrazovky zvolí Příměstský tábor.*/
    @Test
    void objednejPrimestskyTabor () {
        prohlizec.jdiDoSekceObjednavkaProMSZS();
        prohlizec.vyberMoznostPrimestskyTabor();
    }

    /*Napište test, který pustupně projde všechny sekce horního veřejného menu*/
    @Test
    void projdiSekce() {
        prohlizec.jdiDoSekceDomu();
        prohlizec.jdiDoSekceNavodyAFormulareProRodice();
        prohlizec.jdiDoSekceVytvorPrihlaskuProRodice();
        prohlizec.jdiDoSekceNavodyAFormulareProUcitele();
        prohlizec.jdiDoSekceObjednavkaProMSZS();
        prohlizec.jdiDoSekceKontakt();
    }

    /*Napište test, který přejde do sekce Pro učitelé -> Objednávka pro MŠ/ZŠ a do
políčka pro IČO vyplní IČO organizace czechitas*/
    @Test
    void vyplnICO() {
        prohlizec.jdiDoSekceObjednavkaProMSZS();
        prohlizec.vyplnICO("87456321");
    }

    /*. Přihlaste se do aplikace pod Vámi vytvořeným uživatelem. Klikněte na
vytvoření nové přihlášky. Vyberte období programování a nakonec klikněte na
vytvoření přihlášky. Výsledkem navigace by měla být obrazovka s formulářem pro
založení přihlášky.*/
    @Test
    void zalozPrihlasku() {
        prohlizec.klikniNaTlacitkoPrihlasit();
        prohlizec.vyplnEmail("carevna@email.com");
        prohlizec.vyplnHeslo("Rusko1729");
        prohlizec.provedPrihlaseni();
        prohlizec.klikniNaVytvoreniNovePrihlasky();
        prohlizec.vyberObdobiProgramovani();
        prohlizec.klikniNaVytvoritPrihlasku();
    }

/*Ověřte, že na úvodní stránce se nachází „dlaždice“ Programování.*/
    @Test
    void overDlazdiceProgramovani () {
        overeni.overExistenciDlazdiceProgramovani();
    }

/*Ověřte, že pokud jde uživatel do sekce pro vytváření přihlášky pro rodiče (Pro rodiče
-> Vytvořit přihlášku) a není přihlášen, je na obrazovce k dispozici tlačítko pro
    registraci.*/
    @Test
    void overTlacitkoProRegistraci() {
        prohlizec.jdiDoSekceVytvorPrihlaskuProRodice();
        overeni.overPritomnostTlacitkaZaregistrujteSe();
    }

/*Napište test, který provede přihlášení Vámi založeným uživatelem, otevře detail
    první přihlášky v seznamu přihlášek a zkontroluje, že způsob úhrady odpovídá
    způsobu úhrady, který jste zadali při jejím zakládání*/
    @Test
    void otevriDetailPrvniPrihlasky() {
        prohlizec.klikniNaTlacitkoPrihlasit();
        prohlizec.vyplnEmail("carevna@email.com");
        prohlizec.vyplnHeslo("Rusko1729");
        prohlizec.provedPrihlaseni();
        prohlizec.otevriDetailPrvniPrihlasky();
        overeni.overZpusobUhradyPrihlasky("Hotově");
    }
}
