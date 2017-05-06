package br.com.felipe.vo;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

/**
 * Created by felipe on 06/05/17.
 */
public class WordTest {

    @Test
    public void shouldHaveLenghtEqualsSizeOfContent(){
        Word word = Word.withContent("Platon");

        assertThat(6, is(equalTo(word.size())));
    }

}
