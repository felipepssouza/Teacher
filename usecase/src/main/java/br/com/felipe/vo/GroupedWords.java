package br.com.felipe.vo;

import java.util.List;

/**
 * Created by felipe on 06/05/17.
 */
public class GroupedWords {

    private List<Word> words;
    private GroupType type;


    public static GroupedWords of(final List<Word> words, GroupType type) {
        GroupedWords groupedWords = new GroupedWords();
        groupedWords.words = words;
        groupedWords.type = type;
        return groupedWords;
    }

    public List<Word> getWords() {
        return words;
    }
}
