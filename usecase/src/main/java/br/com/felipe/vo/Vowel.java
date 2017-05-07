package br.com.felipe.vo;

import org.apache.commons.lang3.StringUtils;

import java.util.Arrays;
import java.util.List;

/**
 * Created by felipe on 07/05/17.
 */
public class Vowel {

    private Character character;

    private static final List<Character> VALID_VOWELS = Arrays.asList(
            "a".charAt(0),
            "e".charAt(0),
            "i".charAt(0),
            "o".charAt(0),
            "u".charAt(0)
    );

    private Vowel(){
        super();
    }

    public static Vowel of(Character character) {
        Vowel vowel = new Vowel();
        vowel.character = character;
        return vowel;
    }

    @Override
    public String toString() {
        return character.toString();
    }

    public static Boolean isValid(Character character) {
        if(character == null)
            throw new IllegalArgumentException("Vowel is valid should not get invalid char");

        return VALID_VOWELS.stream().anyMatch( validChar ->
                StringUtils.equals(validChar.toString(), character.toString().toLowerCase())
        );
    }
}
