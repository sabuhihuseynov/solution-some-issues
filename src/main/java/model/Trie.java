package model;

import java.util.HashMap;

public class Trie {
    char c;
    public String word;
    public HashMap<Character, Trie> childs;

    public Trie(char c) {
        this.c = c;
        word = null;
        childs = new HashMap<>();
    }

}
