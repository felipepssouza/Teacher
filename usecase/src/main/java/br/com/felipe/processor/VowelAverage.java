package br.com.felipe.processor;

import br.com.felipe.vo.Word;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

/**
 * Created by felipe on 07/05/17.
 */
public class VowelAverage {

    private VowelExtractor vowelExtractor;

    public VowelAverage(VowelExtractor vowelExtractor){
        this.vowelExtractor = vowelExtractor;
    }

    public Double averagePerWord(List<Word> words) {
        if(words == null || words.isEmpty())
            throw new IllegalArgumentException("Should not pass null or empty words");

        return words.stream()
                .mapToInt(word -> (vowelExtractor.fromWord(word)).size())
                .average().orElseGet(null);
    }

}
