import java.util.Scanner;


public class MyProgram {
    static String password = "Андрей_чепушила";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = new String();
        int i = 0;
        do {
            System.out.println("=================================>");
            System.out.println("Введи пароль: ");
            str = input.nextLine();
            switch (str){
                case "Андрей_чепушила":
                    System.out.println("Молодец!");
                    i = 1;
                    break;
                default:
                    System.out.println("Попробйте снова: ");
                    break;
            }
            System.out.println("=================================>");
        }
        while (i == 0);
    }
}
