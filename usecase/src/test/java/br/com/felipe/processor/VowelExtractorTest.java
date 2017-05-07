package br.com.felipe.processor;

import br.com.felipe.vo.Vowel;
import br.com.felipe.vo.Word;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

/**
 * Created by felipe on 06/05/17.
 */
public class VowelExtractorTest {

    private VowelExtractor vowelExtractor;

    @Before
    public void setup() {
        this.vowelExtractor = new VowelExtractor();
    }

    @Test
    public void shouldExtractVowelsFromAWord() {
        Word word = Word.withContent("Platon");

        List<Vowel> vowels = vowelExtractor.fromWord(word);

        assertThat(2, is(equalTo(vowels.size())));
    }

    @Test
    public void shouldExtractEmptyListIfNoVowelsInWord() {
        Word word = Word.withContent("crwth");

        List<Vowel> vowels = vowelExtractor.fromWord(word);

        assertThat(0, is(equalTo(vowels.size())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentWhenTheWordIsNull() {
        vowelExtractor.fromWord(null);
    }

}
