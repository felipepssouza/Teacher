package br.com.felipe.processor;

import br.com.felipe.vo.GroupedWords;
import br.com.felipe.vo.Word;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

/**
 * Created by felipe on 06/05/17.
 */
public class WordGrouperTest {

    private WordGrouper wordGrouper;

    @Before
    public void setup() {
        this.wordGrouper = new WordGrouper();
    }

    @Test
    public void shouldGroupWordsBySize() {
        List<Word> words = Arrays.asList(Word.withContent("Platon"), Word.withContent("made"),
                Word.withContent("bamboo"), Word.withContent("boats"));

        List<GroupedWords> groupedWords = wordGrouper.groupBySize(words);

        assertThat(3, is(equalTo(groupedWords.size())));
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentIfWordsAreNull() {
        List<Word> words = null;
        wordGrouper.groupBySize(words);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentIfWordsAreEmpty() {
        List<Word> words = new ArrayList<>();
        wordGrouper.groupBySize(words);
    }

}
