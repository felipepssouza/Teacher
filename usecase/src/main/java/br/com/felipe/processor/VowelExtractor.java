package br.com.felipe.processor;

import br.com.felipe.vo.Vowel;
import br.com.felipe.vo.Word;
import com.google.common.primitives.Chars;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by felipe on 07/05/17.
 */
public class VowelExtractor {

    public List<Vowel> fromWord(Word word) {
        if(word == null)
            throw new IllegalArgumentException("Word should not be null on VowelExtractor");

        return Chars.asList(word.toString().toCharArray())
                .stream().filter(Vowel::isValid)
                .map(Vowel::of).collect(Collectors.toList());

    }
}
