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

}
