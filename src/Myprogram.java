import java.util.Scanner;


public class Myprogram {
        static String password = "Привет";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String str = new String();
        int i = 0;
        do {
            System.out.println("=================================");
            System.out.println("Введи пароль");
            str = input.nextLine();
            switch (str){
                case "Привет":
                    System.out.println("Верно");
                    i = 1;
                    break;
                default:
                    System.out.println("Попробйте снова");
                    break;
            }
            System.out.println("=================================");
        }
        while (i == 0);
    }
}
