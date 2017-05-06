package br.com.felipe;

import br.com.felipe.vo.GroupType;
import br.com.felipe.vo.GroupedWords;
import br.com.felipe.vo.Word;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by felipe on 06/05/17.
 */
public class WordGrouper {


    public List<GroupedWords> groupBySize(List<Word> words) {
        if(CollectionUtils.isEmpty(words))
            throw new IllegalArgumentException("Words to group should not be empty");

        return words.stream()
                .collect(Collectors.groupingBy(Word::size)).values()
                .stream().map(it -> GroupedWords.of(it, GroupType.LENGTH)).collect(Collectors.toList());
    }
}
