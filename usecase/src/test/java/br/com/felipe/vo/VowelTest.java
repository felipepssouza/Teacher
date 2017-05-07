package br.com.felipe.vo;

import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

/**
 * Created by felipe on 07/05/17.
 */
public class VowelTest {

    @Test
    public void shouldGiveAVowel() {
        String word = "Platon";
        Vowel vowel = Vowel.of(word.charAt(2));

        assertThat("a", is(equalTo(vowel.toString())));
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowIllegalArgumentWhenIsValidReceiveNull() {
        Vowel.isValid(null);
    }

    @Test
    public void shouldCheckIfTheConsonantIsAVowel() {
        assertThat(false, is(Vowel.isValid("t".charAt(0))));
    }

    @Test
    public void shouldCheckIfTheVowelIsAVowel() {
        assertThat(true, is(Vowel.isValid("a".charAt(0))));
    }


}
