package br.com.felipe.vo;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.core.Is.is;

/**
 * Created by felipe on 06/05/17.
 */
public class GroupedWordsTest {


    @Test
    public void shouldGroupWords() {
        List<Word> wordsOfSameGroup = Arrays.asList(Word.withContent("Platon"), Word.withContent("boats"));
        GroupType groupType = GroupType.LENGTH;

        GroupedWords groupedWords = GroupedWords.of(wordsOfSameGroup, groupType);

        assertThat(2, is(equalTo(groupedWords.getWords().size())));
    }

}
