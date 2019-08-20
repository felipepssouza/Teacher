package br.com.felipe.io;

import br.com.felipe.parser.WordParser;
import br.com.felipe.processor.VowelAverage;
import br.com.felipe.processor.VowelExtractor;
import br.com.felipe.processor.WordGrouper;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by felipe on 08/05/17.
 */
public class PrinterVowelsTest {

    private PrinterVowels printerVowels;

    @Before
    public void setup() {
        this.printerVowels = new PrinterVowels(new VowelExtractor(), new VowelAverage(new VowelExtractor()),
                new WordParser(), new WordGrouper());
    }

    @Test
    public void shouldAverageOfVowelsPerWords() {
        String input = "Platon made bamboo boats";

        String printedByVowels = printerVowels.print(input);

        assertTrue(printedByVowels.contains("({a, o}, 6) -> 2.5"));
        assertTrue(printedByVowels.contains("({a, o}, 5) -> 2"));
        assertTrue(printedByVowels.contains("({a, e}, 4) -> 2"));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentWhenPrintParameterIsNull() {
        printerVowels.print(null);
    }

}
