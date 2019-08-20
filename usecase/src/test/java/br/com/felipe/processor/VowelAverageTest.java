package br.com.felipe.processor;

import br.com.felipe.vo.Word;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

/**
 * Created by felipe on 07/05/17.
 */
public class VowelAverageTest {

    private VowelAverage vowelAverage;

    @Before
    public void setup() {
        this.vowelAverage = new VowelAverage(new VowelExtractor());
    }

    @Test
    public void shouldAverageOfVowelsPerWords() {
        List<Word> words = asList(Word.withContent("Platon"), Word.withContent("bamboo"));

        Double averagePerWord = vowelAverage.averagePerWord(words);

        assertThat(2.5, is(equalTo(averagePerWord)));
    }

    @Test
    public void shouldAverageOfVowelsPerWordsBeZeroIfHasNoneVowels() {
        List<Word> words = asList(Word.withContent("Tks"), Word.withContent("Thr"));

        Double averagePerWord = vowelAverage.averagePerWord(words);

        assertThat(0.0, is(equalTo(averagePerWord)));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentWhenNullIsPassed() {
        vowelAverage.averagePerWord(null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentWhenEmptyIsPassed() {
        vowelAverage.averagePerWord(new ArrayList<>());
    }

}
