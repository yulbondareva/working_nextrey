import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println(calc(scanner.nextLine()));
        }catch (StringSizeException e){
            e.Error();
        }
        catch (DivisionByZeroException e){
            e.Error();
        }
        catch (NumbersOutOfRangeException e){
            e.Error();
        }
        catch (OperationException e){
            e.Error();
        }
        catch (SameNumbersException e){
            e.Error();
        }
        catch (AnswerIsLessThanOneException e){
            e.Error();
        }
    }

    public static String calc(String input) throws StringSizeException, DivisionByZeroException, NumbersOutOfRangeException, OperationException, SameNumbersException, AnswerIsLessThanOneException {
        String[] forSplit = input.split(" ");
        if (forSplit.length != 3) {
            throw new StringSizeException();
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
        boolean flagType = false;
        if ((!flagContainsFirst || !flagContainsSecond) && (!flagContainsRimFirst || !flagContainsRimSecond) && ((flagContainsFirst == flagContainsSecond) || (flagContainsRimFirst == flagContainsRimSecond))) {
            throw new NumbersOutOfRangeException();
        }
        if (!forSplit[1].equals("+") && !forSplit[1].equals("-") && !forSplit[1].equals("*") && !forSplit[1].equals("/")) {
            throw new OperationException();
        }
        if (!((flagContainsFirst == flagContainsSecond) && (flagContainsFirst)) && !((flagContainsRimFirst == flagContainsRimSecond) && (flagContainsRimFirst))) {
            throw new SameNumbersException();
        } else {
            if ((flagContainsFirst == flagContainsSecond) && (flagContainsFirst)) {
                flagType = true;
            }
            if ((flagContainsRimFirst == flagContainsRimSecond) && (flagContainsRimFirst)) {
                flagType = false;
            }
        }
        if (second == 0) {
            throw new DivisionByZeroException();
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
                throw new AnswerIsLessThanOneException();
            } else {
                if (answer < 10) {
                    return arrayRim[answer];
                } else {
                    int count = answer / 10;
                    String answerLine = "";
                    if (count < 4) {
                        for (int i = 0; i < count; i++) {
                            answerLine += "X";
                        }
                    }
                    if (count == 4) {
                        answerLine = "XL";
                    }
                    if (count > 4 && count < 9) {
                        answerLine = "L";
                        for (int i = 5; i < count; i++) {
                            answerLine += "X";
                        }
                    }
                    if (count == 9) {
                        answerLine = "XC";
                    }
                    if (count == 10) {
                        answerLine = "L";
                    }
                    if (answer % 10 != 0) {
                        answerLine += arrayRim[answer % 10];
                    }
                    return answerLine;
                }
            }
        }
    }
}