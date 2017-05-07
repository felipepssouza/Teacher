package br.com.felipe.vo;

/**
 * Created by felipe on 06/05/17.
 */
public class Word {

    private String content;

    private Word(){
        super();
    }

    public static Word withContent(final String content){
        Word word = new Word();
        word.content = content;
        return word;
    }


    @Override
    public String toString() {
        return content;
    }

    public int size(){
        return this.content.length();
    }

}
