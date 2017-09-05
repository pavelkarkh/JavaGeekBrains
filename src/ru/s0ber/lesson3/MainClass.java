package ru.s0ber.lesson3;

import java.util.Random;
import java.util.Scanner;

public class MainClass {

    public static void main(String[] args) {

        startGame();

    }

    public static void startGame() {
        String[] words = {"apple", "orange", "lemon", "banana", "apricot", "avocado",
                "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak",
                "kiwi", "mango", "mushroom", "nut", "olive", "pea", "peanut", "pear",
                "pepper", "pineapple", "pumpkin", "potato"};

        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите игру:");
        System.out.println("1 - \"Угадай число\"");
        System.out.println("2 - \"Угадай слово\"");
        System.out.println("0 - Выход");
        System.out.print("Время выбирать: ");
        int choice;
        do {
            choice = scanner.nextInt();
            if (choice == 0) {
                break;
            }

            if (choice == 1) {
                guessNumberGame();
                break;
            }

            if (choice == 2) {
                guessWordGame(words);
                break;
            }

        } while (true);
    }

    public static void guessWordGame(String[] words) {

        Random random = new Random();
        String randomString = words[random.nextInt(words.length)];
        System.out.println("Умная коробка загадало слово! Это слово какое-то из перечисленных: ");
        printWordsArray(words);
        System.out.println();
        Scanner scanner = new Scanner(System.in);
        String guess;
        do {
            System.out.print("Введите слово: ");
            guess = scanner.nextLine();
            if (randomString.equals(guess)) {
                System.out.println("Победа!!! Компьютер загадал слово: " + randomString);
                break;
            } else {
                System.out.println("Не угадали, вот вам подсказка: ");
                System.out.println("(это буквы которые стоят на своем месте)");
                char[] arr = checkWords(guess, randomString);
                System.out.println(charArrayToString(arr));
                System.out.print("Попробуйте ещё раз. ");
            }

        } while (true);
    }

    public static void guessNumberGame()
    {
        do {

            Scanner scanner = new Scanner(System.in);
            Random random = new Random();
            int randomNumber = random.nextInt(9) + 1;
            int guess;
            int choice;
            int attempt = 3;
            System.out.println("Хитрая коробка загадала число. Пришло время его угадать!");
            System.out.print("Введите число от 1 до 9: ");

            do {
                if (attempt == 0) {
                    System.out.println("Увы у вас больше нет попыток!");
                    break;
                }
                System.out.print("Введите число от 1 до 9: ");
                guess = scanner.nextInt();
                if (guess == randomNumber) {
                    System.out.println("Победа!");
                    break;
                }
                if (guess > randomNumber) {
                    attempt--;
                    System.out.println("Не угадали, введёное число больше загаданного. У вас осталось " + attempt + " попыток");
                } else {
                    attempt--;
                    System.out.println("Не угадали, введёное число меньше загаданного.У вас осталось " + attempt + " попыток");
                }
            } while (true);

            System.out.println("Игра окончена. Загаданное число: " + randomNumber);
            System.out.println("Если желаете продолжить наберите 1, если хотите выйти наберите 0");

            choice = scanner.nextInt();

            if (choice == 0) {
                break;
            }
        } while (true);
    }

    public static String charArrayToString(char[] arr) {
        int arrLength = arr.length;
        String answer = "";
        for (int i = 0; i < arrLength; i++) {
            answer += arr[i];
        }
        return answer;
    }

    public static char[] checkWords(String guessWord, String randomWord) {
        int randomWordLength = randomWord.length();
        int guessWordLength = guessWord.length();
        char[] answerArray = new char[14];
        for (int i = 0; i < answerArray.length; i++) {
            if (randomWordLength > i && guessWordLength > i && randomWord.charAt(i) == guessWord.charAt(i)) {
                answerArray[i] = randomWord.charAt(i);
            } else {
                answerArray[i] = '#';
            }
        }
        return answerArray;
    }

    public static void printWordsArray(String[] arr) {
        int arrLength = arr.length;
        int count = 1;
        System.out.print("[ ");
        if (arrLength > 0) {
            for (int i = 0; i < arrLength; i++) {
                if (i + 1 == arrLength){
                    System.out.print(arr[i] + " ]");
                } else {
                    System.out.print(arr[i] + ", ");
                }

                count++;
                if (count == 5) {
                    System.out.print(arr[i]);
                    System.out.println();
                    count = 1;
                }
            }
        }
    }
}
