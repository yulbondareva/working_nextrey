import java.util.Scanner;

public class homeworkforuniversity {

    public static void main(String[] args) {
        homeworkforuniversity ho_funck = new homeworkforuniversity();
        do{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите свои числа");
            int a = scanner.nextInt();
            ho_funck.greg_result(a);
            int b = scanner.nextInt();
            System.out.println("Хороши, ваши числа равны \n a= " + a + " b= " + b);
            System.out.println("Какое действие вы хотите выполнить? напишите знак действия");
            Scanner stscan = new Scanner(System.in);
            String sw = stscan.nextLine();
            switch (sw){
                case "-": System.out.println(ho_funck.minus(a,b));break;
                case "+": System.out.println(ho_funck.plus(a,b));break;
                case "/": System.out.println(ho_funck.delen(a,b));break;
                case "*": System.out.println(ho_funck.mnoj(a,b));break;
                default: System.out.println("Данного действия не предусмотренно, введите пожалуйста один из следующих символов * / + -\n Сейчас программа перезапустится");
            }

        }while (1==1);

    }

    public String greg_result (int result){
        int res10 = (int) result/10;
        int res = result - (res10*10);
        System.out.println(res10);
        System.out.println(res);
        return "res";

    }

    public String greg_normal(int a){
        switch (a){
            case 1: return "I";
            case 2: return "II";
            case 3: return "III";
            case 4: return "IV";
            case 5: return "V";
            case 6: return "VI";
            case 7: return "VII";
            case 8: return "VIII";
            case 9: return "IX";
            case 10: return "X";
            case 50: return "L";
        }
        return null;
    }

    public int minus (int a, int b){return a-b;}
    public int plus (int a, int b){return a+b;}
    public int delen (int a, int b){return a/b;}
    public int mnoj (int a, int b){return  a*b;}

}
