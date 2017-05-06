package br.com.felipe.parser;

import br.com.felipe.vo.Word;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

/**
 * Created by felipe on 06/05/17.
 */
public class WordParserTest {

    @Test
    public void shouldParseInputToWords(){
        String input = "Platon made bamboo boats";

        WordParser wordParser = new WordParser();
        List<Word> words = wordParser.evaluateWords(input);

        assertThat(4, is(equalTo(words.size())));
    }

    @Test
    public void shouldParseInputToWordsEvenWhenThereIsOneWord(){
        String input = "Platon";

        WordParser wordParser = new WordParser();
        List<Word> words = wordParser.evaluateWords(input);

        assertThat(1, is(equalTo(words.size())));
    }

    @Test
    public void shouldParseInputToWordsEvenWithMoreWhitespaces(){
        String input = "Platon   made";

        WordParser wordParser = new WordParser();
        List<Word> words = wordParser.evaluateWords(input);

        assertThat(2, is(equalTo(words.size())));
    }


    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentWhenIsNull(){
        String input = null;

        WordParser wordParser = new WordParser();
        wordParser.evaluateWords(input);
    }

    @Test(expected=IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentWhenIsEmpty(){
        String input = "";

        WordParser wordParser = new WordParser();
        wordParser.evaluateWords(input);
    }


}
