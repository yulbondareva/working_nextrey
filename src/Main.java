import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine()));
    }

    public static String calc(String input) {
        String[] forSplit = input.split(" ");
        if (forSplit.length != 3) {
            return "Данные не верны";
        }
        String[] arrayArab = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] arrayRim = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        boolean flagContainsFirst = false;
        boolean flagContainsSecond = false;
        int first = 0;
        int second = 0;
        for (int i = 0; i < arrayArab.length; i++) {
            if (forSplit[0].equals(arrayArab[i])) {
                flagContainsFirst = true;
                first = i;
            }
            if (forSplit[2].equals(arrayArab[i])) {
                flagContainsSecond = true;
                second = i;
            }
        }
        boolean flagContainsRimFirst = false;
        boolean flagContainsRimSecond = false;
        for (int i = 0; i < arrayRim.length; i++) {
            if (forSplit[0].equals(arrayRim[i])) {
                flagContainsRimFirst = true;
                first = i;
            }
            if (forSplit[2].equals(arrayRim[i])) {
                flagContainsRimSecond = true;
                second = i;
            }
        }
        if (second == 0) {
            return "Данные не верны";
        }
        boolean flagType = false;
        if ((!flagContainsFirst || !flagContainsSecond) && (!flagContainsRimFirst || !flagContainsRimSecond)) {
            return "Данные не верны";
        }
        if (!forSplit[1].equals("+") && !forSplit[1].equals("-") && !forSplit[1].equals("*") && !forSplit[1].equals("/")) {
            return "Данные не верны";
        }
        if (!((flagContainsFirst == flagContainsSecond) && (flagContainsFirst)) && !((flagContainsRimFirst == flagContainsRimSecond) && (flagContainsRimFirst))) {
            return "Данные не верны";
        } else {
            if ((flagContainsFirst == flagContainsSecond) && (flagContainsFirst)) {
                flagType = true;
            }
            if ((flagContainsRimFirst == flagContainsRimSecond) && (flagContainsRimFirst)) {
                flagType = false;
            }
        }
        int answer = 0;
        switch (forSplit[1]) {
            case "+":
                answer = first + second;
                break;
            case "-":
                answer = first - second;
                break;
            case "*":
                answer = first * second;
                break;
            case "/":
                answer = first / second;
                break;
        }
        if (flagType) {
            return Integer.toString(answer);
        } else {
            if (answer < 1) {
                return "Данные не верны";
            } else {
                int count = answer / 10;
                String answerLine = "";
                if (count > 1) {
                    for (int i = 0; i < count; i++) {
                        answerLine += "X";
                    }
                }
                if (answer == 50) {
                    return "L";
                }
                if (answer == 100) {
                    return "C";
                }
                answerLine += arrayRim[answer % 10];
                return answerLine;
            }
        }
    }
}