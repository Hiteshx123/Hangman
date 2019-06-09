package com.company;

public class Hangman {

    String secretWord;

    private String[] hangmanStates = {
            " +---+\n" +
            "  |   |\n" +
            "      |\n" +
            "      |\n" +
            "      |\n" +
            "      |\n" +
            "=========",
            "+---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            "      |\n" +
            "      |\n" +
            "      |\n" +
            "=========",
            "+---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            "  |   |\n" +
            "      |\n" +
            "      |\n" +
            "=========",
            "+---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|   |\n" +
            "      |\n" +
            "      |\n" +
            "=========",
            "+---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\  |\n" +
            "      |\n" +
            "      |\n" +
            "=========",
            "+---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\  |\n" +
            " /    |\n" +
            "      |\n" +
            "=========",
            "+---+\n" +
            "  |   |\n" +
            "  O   |\n" +
            " /|\\  |\n" +
            " / \\  |\n" +
            "      |\n" +
            "========="};

    public String[] guesses = new String[26];
    public boolean[] wrong = new boolean[26];

    public Integer currentState = 0;

    public Hangman(String secretWord){
        this.secretWord = secretWord;
    }

    public void update(String[] guesses, boolean[] wrong){
        this.wrong = wrong;
        this.guesses = guesses;
        int updateState = 0;
        for (int i = 0; i < guesses.length; i++)
            if(guesses[i] != null && wrong[i])
                updateState++;
        currentState = updateState;

    }

    public boolean contains(String[] arr, String target){
        for (String a: arr)
            if(a.equalsIgnoreCase(target))
                return true;
        return false;
    }

    @Override
    public String toString(){
        String toString =  hangmanStates[currentState] + "\nGuesses - ";
            for (int i = 0; i < guesses.length; i++)
                if(guesses[i] != null && wrong[i])
                    toString += " " + guesses[i] + ",";

            toString += "\nNumber of Misses left - " + (6 - currentState) + "\n";
            String newWord = getWord();
            toString += newWord;

        return toString;
    }

    public String getWord(){
        String temp = secretWord;
        String[] word = new String[temp.length()];
        for (int i = 0; i < guesses.length; i++){
            if(guesses[i] != null && !wrong[i])
                while (temp.contains(guesses[i])) {
                    int index = temp.indexOf(guesses[i]);
                    word[index] = guesses[i];
                    temp = temp.replaceFirst(guesses[i], "_");
                }
        }
        for (int i =0; i < word.length; i++){
            if(word[i] == null)
                word[i] = "_";
        }
        String newWord = "";
        for (String a :word){
            newWord += a + " ";
        }

        return newWord;

    }
}
