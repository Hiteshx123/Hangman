package com.company;

import javax.sound.sampled.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class HangmanGame {
    private ArrayList<String> lines;
    private ArrayList<String> emoji;
    private Integer setDifficulty = 8;

    public static void main(String[] args) {
        HangmanGame hangmanGame = new HangmanGame();
        hangmanGame.gameMenu();
    }

    public void gameMenu(){
        Thread gameAudio = new AudioPlayer("out/production/Hangman/com/company/Lo-fi chill mix - minutes.wav");
        gameAudio.start();
        System.out.println(
                "\t\t\t| .__________))______|\n" +
                        "\t\t\t| | / /      ||\n" +
                        "\t\t\t| |/ /       ||\n" +
                        "\t\t\t| | /        ||.-''.\n" +
                        "\t\t\t| |/         |/  _  \\\n" +
                        "\t\t\t| |          ||  `/,|\n" +
                        "\t\t\t| |          (\\\\`_.'\n" +
                        "\t\t\t| |         .-`--'.\n" +
                        "\t\t\t| |        /Y . . Y\\\n" +
                        "\t\t\t| |       // |   | \\\\\n" +
                        "\t\t\t| |      //  | . |  \\\\\n" +
                        "\t\t\t| |     ')   |   |   (`\n" +
                        "\t\t\t| |          ||'||\n" +
                        "\t\t\t| |          || ||\n" +
                        "\t\t\t| |          || ||\n" +
                        "\t\t\t| |          || ||\n" +
                        "\t\t\t| |         / | | \\\n" +
                        "\t\t\t\"\"\"\"\"\"\"\"\"\"|_`-' `-' |\"\"\"|\n" +
                        "\t\t\t|\"|\"\"\"\"\"\"\"\\ \\       '\"|\"|\n" +
                        "\t\t\t| |        \\ \\        | |\n" +
                        "\t\t\t: :         \\ \\       : :  \n" +
                        "\t\t\t. .          `'       . .");
        System.out.println(
                "          _____                    _____                    _____            _____                   _______                   _____                    _____                        _____                   _______                           _____                    _____                    _____                    _____                    _____                    _____                    _____                  \n" +
                        "         /\\    \\                  /\\    \\                  /\\    \\          /\\    \\                 /::\\    \\                 /\\    \\                  /\\    \\                      /\\    \\                 /::\\    \\                         /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\                  /\\    \\                 \n" +
                        "        /::\\____\\                /::\\    \\                /::\\____\\        /::\\    \\               /::::\\    \\               /::\\____\\                /::\\    \\                    /::\\    \\               /::::\\    \\                       /::\\____\\                /::\\    \\                /::\\____\\                /::\\    \\                /::\\____\\                /::\\    \\                /::\\____\\                \n" +
                        "       /:::/    /               /::::\\    \\              /:::/    /       /::::\\    \\             /::::::\\    \\             /::::|   |               /::::\\    \\                   \\:::\\    \\             /::::::\\    \\                     /:::/    /               /::::\\    \\              /::::|   |               /::::\\    \\              /::::|   |               /::::\\    \\              /::::|   |                \n" +
                        "      /:::/   _/___            /::::::\\    \\            /:::/    /       /::::::\\    \\           /::::::::\\    \\           /:::::|   |              /::::::\\    \\                   \\:::\\    \\           /::::::::\\    \\                   /:::/    /               /::::::\\    \\            /:::::|   |              /::::::\\    \\            /:::::|   |              /::::::\\    \\            /:::::|   |                \n" +
                        "     /:::/   /\\    \\          /:::/\\:::\\    \\          /:::/    /       /:::/\\:::\\    \\         /:::/~~\\:::\\    \\         /::::::|   |             /:::/\\:::\\    \\                   \\:::\\    \\         /:::/~~\\:::\\    \\                 /:::/    /               /:::/\\:::\\    \\          /::::::|   |             /:::/\\:::\\    \\          /::::::|   |             /:::/\\:::\\    \\          /::::::|   |                \n" +
                        "    /:::/   /::\\____\\        /:::/__\\:::\\    \\        /:::/    /       /:::/  \\:::\\    \\       /:::/    \\:::\\    \\       /:::/|::|   |            /:::/__\\:::\\    \\                   \\:::\\    \\       /:::/    \\:::\\    \\               /:::/____/               /:::/__\\:::\\    \\        /:::/|::|   |            /:::/  \\:::\\    \\        /:::/|::|   |            /:::/__\\:::\\    \\        /:::/|::|   |                \n" +
                        "   /:::/   /:::/    /       /::::\\   \\:::\\    \\      /:::/    /       /:::/    \\:::\\    \\     /:::/    / \\:::\\    \\     /:::/ |::|   |           /::::\\   \\:::\\    \\                  /::::\\    \\     /:::/    / \\:::\\    \\             /::::\\    \\              /::::\\   \\:::\\    \\      /:::/ |::|   |           /:::/    \\:::\\    \\      /:::/ |::|   |           /::::\\   \\:::\\    \\      /:::/ |::|   |                \n" +
                        "  /:::/   /:::/   _/___    /::::::\\   \\:::\\    \\    /:::/    /       /:::/    / \\:::\\    \\   /:::/____/   \\:::\\____\\   /:::/  |::|___|______    /::::::\\   \\:::\\    \\                /::::::\\    \\   /:::/____/   \\:::\\____\\           /::::::\\    \\   _____    /::::::\\   \\:::\\    \\    /:::/  |::|   | _____    /:::/    / \\:::\\    \\    /:::/  |::|___|______    /::::::\\   \\:::\\    \\    /:::/  |::|   | _____          \n" +
                        " /:::/___/:::/   /\\    \\  /:::/\\:::\\   \\:::\\    \\  /:::/    /       /:::/    /   \\:::\\    \\ |:::|    |     |:::|    | /:::/   |::::::::\\    \\  /:::/\\:::\\   \\:::\\    \\              /:::/\\:::\\    \\ |:::|    |     |:::|    |         /:::/\\:::\\    \\ /\\    \\  /:::/\\:::\\   \\:::\\    \\  /:::/   |::|   |/\\    \\  /:::/    /   \\:::\\ ___\\  /:::/   |::::::::\\    \\  /:::/\\:::\\   \\:::\\    \\  /:::/   |::|   |/\\    \\         \n" +
                        "|:::|   /:::/   /::\\____\\/:::/__\\:::\\   \\:::\\____\\/:::/____/       /:::/____/     \\:::\\____\\|:::|____|     |:::|    |/:::/    |:::::::::\\____\\/:::/__\\:::\\   \\:::\\____\\            /:::/  \\:::\\____\\|:::|____|     |:::|    |        /:::/  \\:::\\    /::\\____\\/:::/  \\:::\\   \\:::\\____\\/:: /    |::|   /::\\____\\/:::/____/  ___\\:::|    |/:::/    |:::::::::\\____\\/:::/  \\:::\\   \\:::\\____\\/:: /    |::|   /::\\____\\        \n" +
                        "|:::|__/:::/   /:::/    /\\:::\\   \\:::\\   \\::/    /\\:::\\    \\       \\:::\\    \\      \\::/    / \\:::\\    \\   /:::/    / \\::/    / ~~~~~/:::/    /\\:::\\   \\:::\\   \\::/    /           /:::/    \\::/    / \\:::\\    \\   /:::/    /         \\::/    \\:::\\  /:::/    /\\::/    \\:::\\  /:::/    /\\::/    /|::|  /:::/    /\\:::\\    \\ /\\  /:::|____|\\::/    / ~~~~~/:::/    /\\::/    \\:::\\  /:::/    /\\::/    /|::|  /:::/    /        \n" +
                        " \\:::\\/:::/   /:::/    /  \\:::\\   \\:::\\   \\/____/  \\:::\\    \\       \\:::\\    \\      \\/____/   \\:::\\    \\ /:::/    /   \\/____/      /:::/    /  \\:::\\   \\:::\\   \\/____/           /:::/    / \\/____/   \\:::\\    \\ /:::/    /           \\/____/ \\:::\\/:::/    /  \\/____/ \\:::\\/:::/    /  \\/____/ |::| /:::/    /  \\:::\\    /::\\ \\::/    /  \\/____/      /:::/    /  \\/____/ \\:::\\/:::/    /  \\/____/ |::| /:::/    /         \n" +
                        "  \\::::::/   /:::/    /    \\:::\\   \\:::\\    \\       \\:::\\    \\       \\:::\\    \\                \\:::\\    /:::/    /                /:::/    /    \\:::\\   \\:::\\    \\              /:::/    /             \\:::\\    /:::/    /                     \\::::::/    /            \\::::::/    /           |::|/:::/    /    \\:::\\   \\:::\\ \\/____/               /:::/    /            \\::::::/    /           |::|/:::/    /          \n" +
                        "   \\::::/___/:::/    /      \\:::\\   \\:::\\____\\       \\:::\\    \\       \\:::\\    \\                \\:::\\__/:::/    /                /:::/    /      \\:::\\   \\:::\\____\\            /:::/    /               \\:::\\__/:::/    /                       \\::::/    /              \\::::/    /            |::::::/    /      \\:::\\   \\:::\\____\\                /:::/    /              \\::::/    /            |::::::/    /           \n" +
                        "    \\:::\\__/:::/    /        \\:::\\   \\::/    /        \\:::\\    \\       \\:::\\    \\                \\::::::::/    /                /:::/    /        \\:::\\   \\::/    /            \\::/    /                 \\::::::::/    /                        /:::/    /               /:::/    /             |:::::/    /        \\:::\\  /:::/    /               /:::/    /               /:::/    /             |:::::/    /            \n" +
                        "     \\::::::::/    /          \\:::\\   \\/____/          \\:::\\    \\       \\:::\\    \\                \\::::::/    /                /:::/    /          \\:::\\   \\/____/              \\/____/                   \\::::::/    /                        /:::/    /               /:::/    /              |::::/    /          \\:::\\/:::/    /               /:::/    /               /:::/    /              |::::/    /             \n" +
                        "      \\::::::/    /            \\:::\\    \\               \\:::\\    \\       \\:::\\    \\                \\::::/    /                /:::/    /            \\:::\\    \\                                             \\::::/    /                        /:::/    /               /:::/    /               /:::/    /            \\::::::/    /               /:::/    /               /:::/    /               /:::/    /              \n" +
                        "       \\::::/    /              \\:::\\____\\               \\:::\\____\\       \\:::\\____\\                \\::/____/                /:::/    /              \\:::\\____\\                                             \\::/____/                        /:::/    /               /:::/    /               /:::/    /              \\::::/    /               /:::/    /               /:::/    /               /:::/    /               \n" +
                        "        \\::/____/                \\::/    /                \\::/    /        \\::/    /                 ~~                      \\::/    /                \\::/    /                                              ~~                              \\::/    /                \\::/    /                \\::/    /                \\::/____/                \\::/    /                \\::/    /                \\::/    /                \n" +
                        "         ~~                       \\/____/                  \\/____/          \\/____/                                           \\/____/                  \\/____/                                                                                \\/____/                  \\/____/                  \\/____/                                           \\/____/                  \\/____/                  \\/____/                 \n" +
                        "                                                                                                                                                                                                                                                                                                                                                                                                                            ");

        System.out.println("\n\n\n\n" +
                "__   __           ______      _          _ _ \n" +
                "\\ \\ / /           | ___ \\    | |        | | |\n" +
                " \\ V /__ _ _   _  | |_/ _   _| | ___ ___| | |\n" +
                "  \\ // _` | | | | |    | | | | |/ _ / __| | |\n" +
                "  | | (_| | |_| | | |\\ | |_| | |  __\\__ |_|_|\n" +
                "  \\_/\\__,_|\\__, | \\_| \\_\\__,_|_|\\___|___(_(_)\n" +
                "            __/ |                            \n" +
                "           |___/                             ");
        System.out.println("type in letters to guess the word, ITS HANGMAN Y U NEED RULES");
        Scanner in = new Scanner(System.in);
        int totalScore = 0;
        String statement = "";
        do {
                System.out.println("1.Start Game\n2.Options\n4.Tutorial");
                statement = in.nextLine();
                if (statement.equalsIgnoreCase("1")) {
                    do {
                        String word = "";
                        do {
                            word = lines.get((int)(Math.random()* lines.size()));
                        } while (word.length() > setDifficulty);
                        int score = round(word, in);
                        totalScore += score;
                        System.out.println("Current Score is - " + totalScore);
                        System.out.println("Would you like to continue onto (1)new game or start (2)next round or (3)exit");
                        statement = in.nextLine();
                        if(statement.equalsIgnoreCase("3"))
                            System.exit(1);
                    } while (!statement.equalsIgnoreCase("1"));
                } else if(statement.equalsIgnoreCase("2")){
                    System.out.println("What would you like to set the difficulty to / word length (enter a number)?");
                    setDifficulty = Integer.parseInt(in.nextLine());
                } else if(statement.equalsIgnoreCase("4")){
                    System.out.println("Lol I forgot to make this coming later but u get an emoji");
                    System.out.println(emoji.get((int)(Math.random()*emoji.size())));
                }
        } while (!statement.equalsIgnoreCase("3"));
    }

    public int round(String secretWord, Scanner in){
        String[] guesses = new String[26];
        boolean[] wrong = new boolean[26];
        Hangman hangman = new Hangman(secretWord);

        do{
            System.out.println(hangman.toString());

            int currentState = hangman.currentState;

            System.out.println("Please enter a guess");
            String guess = in.nextLine();

            while(contains(guesses, guess) || guess.length() > 1){
                System.out.println("You have already this letter or you used a phrase - try again");
                guess = in.nextLine();
            }

            if(secretWord.contains(guess)){
                int index = nextElement(guesses);
                guesses[index] = guess;
            } else {
                int index = nextElement(guesses);
                guesses[index] = guess;
                wrong[index] = true;
            }

            hangman.update(guesses, wrong);

            if(currentState < hangman.currentState)
                System.out.println("Woops that's not part of the word!");
            if(currentState == hangman.currentState)
                System.out.println("Hey u got a letter nice!");

            if(hangman.getWord().equalsIgnoreCase(secretWord)){
                System.out.println("Hey you won this round here is a point for u :)");
                return 1;
            }


        } while (hangman.currentState != 6);

        System.out.println(hangman.toString());
        System.out.println("You lost boo hoo\nThe word was " + secretWord);
        return 0;
    }

    public HangmanGame(){
        try{
            BufferedReader in =  new BufferedReader(new FileReader("out/production/Hangman/com/company/words_alpha.txt"));
            String a;
            lines = new ArrayList<>();
            while((a = in.readLine()) != null)
                lines.add(a);
            in.close();
        } catch (IOException E){
            System.out.println(E);
        }
        try{
            BufferedReader in =  new BufferedReader(new FileReader("out/production/Hangman/com/company/emoji.txt"));
            String a;
            emoji = new ArrayList<>();
            while((a = in.readLine()) != null) {
                emoji.add(a + "\n" + in.readLine());
                in.readLine();
            }
            in.close();
        } catch (IOException E){
            System.out.println(E);
        }
    }


    public int nextElement(Object[] arr){
        for (int i =0; i < arr.length; i++){
            if(arr[i] == null)
                return i;
        }
        return -1;
    }

    public boolean contains(String[] arr, String target){
        for (String a: arr)
            if(a != null && a.equalsIgnoreCase(target))
                return true;
        return false;
    }

    public class AudioPlayer extends Thread{
        String fileName;

        public AudioPlayer(String fileName){
            this.fileName = fileName;
        }
        @Override
        public void run() {
            playSound(fileName);
            start();
        }

        private final int BUFFER_SIZE = 128000;
        private File soundFile;
        private AudioInputStream audioStream;
        private AudioFormat audioFormat;
        private SourceDataLine sourceLine;

        public void playSound(String filename){

            String strFilename = filename;

            try {
                soundFile = new File(strFilename);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }

            try {
                audioStream = AudioSystem.getAudioInputStream(soundFile);
            } catch (Exception e){
                e.printStackTrace();
                System.exit(1);
            }

            audioFormat = audioStream.getFormat();

            DataLine.Info info = new DataLine.Info(SourceDataLine.class, audioFormat);
            try {
                sourceLine = (SourceDataLine) AudioSystem.getLine(info);
                sourceLine.open(audioFormat);
            } catch (LineUnavailableException e) {
                e.printStackTrace();
                System.exit(1);
            } catch (Exception e) {
                e.printStackTrace();
                System.exit(1);
            }

            sourceLine.start();

            int nBytesRead = 0;
            byte[] abData = new byte[BUFFER_SIZE];
            while (nBytesRead != -1) {
                try {
                    nBytesRead = audioStream.read(abData, 0, abData.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (nBytesRead >= 0) {
                    @SuppressWarnings("unused")
                    int nBytesWritten = sourceLine.write(abData, 0, nBytesRead);
                }
            }

            sourceLine.drain();
            sourceLine.close();
        }
    }


}
