package parser;

import br.com.felipe.vo.Word;
import org.apache.commons.lang.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

/**
 * Created by felipe on 06/05/17.
 */
public class WordParser {

    /***
     * Parse input of words to Word objects
     * Throws IllegalArgument if null or empty
     * @param input
     * @return
     */
    public List<Word> evaluateWords(String input) {
        if(StringUtils.isBlank(input))
            throw new IllegalArgumentException("input words should not be null");

        return stream(StringUtils.split(input))
                .map(Word::withContent).collect(Collectors.toList());
    }
}
