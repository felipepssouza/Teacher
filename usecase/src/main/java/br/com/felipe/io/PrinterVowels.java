package br.com.felipe.io;

import br.com.felipe.parser.WordParser;
import br.com.felipe.processor.VowelAverage;
import br.com.felipe.processor.VowelExtractor;
import br.com.felipe.processor.WordGrouper;
import br.com.felipe.vo.GroupedWords;
import br.com.felipe.vo.Vowel;
import br.com.felipe.vo.Word;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.SetUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by felipe on 08/05/17.
 */
public class PrinterVowels {

    private VowelExtractor vowelExtractor;
    private VowelAverage vowelAverage;
    private WordParser wordParser;
    private WordGrouper wordGrouper;

    public PrinterVowels(VowelExtractor vowelExtractor, VowelAverage vowelAverage,
                         WordParser wordParser, WordGrouper wordGrouper) {
        this.vowelExtractor = vowelExtractor;
        this.vowelAverage = vowelAverage;
        this.wordParser = wordParser;
        this.wordGrouper = wordGrouper;
    }

    public String print(String input) {
        StringBuilder output = new StringBuilder();
        List<GroupedWords> groupedWords = wordGrouper.groupBySize(wordParser.evaluateWords(input));
        groupedWords.forEach( groupedWord -> {
            // ({a, o}, 6) -> 2.5
            Set<Vowel> vowels = new LinkedHashSet<>();
            groupedWord.getWords().stream()
                    .forEach(word ->
                            vowels.addAll(vowelExtractor.fromWord(word)));
            Double averagePerWord = vowelAverage.averagePerWord(groupedWord.getWords());


            Optional<Integer> size = groupedWord.getWords().stream().findFirst().map(Word::size);

            output.append(String.format("({%s}, %d) -> %2.1f \n",
                    StringUtils.join(vowels, ","),
                    size.orElseGet(null), averagePerWord));
        });
        return output.toString();
    }
}
