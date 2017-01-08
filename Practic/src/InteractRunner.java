import java.util.Scanner;

/**
 * Created by Йотун on 08.01.2017.
 */
public class InteractRunner {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        Calculator calc = new Calculator();
        try {
            System.out.println("Выберите операцию:");
            System.out.println("1 - сложение, 2 - вычитание, 3 - умножение, 4 - деление, 5 - выход");
            int op = Integer.valueOf(scanner.next());
            int r=0;
            while (true) {
                if (op == 5) break;
                int first=0;
                int second = 0;
                if (r==0) {
                    first = Integer.valueOf(scanner.next());
                    second = Integer.valueOf(scanner.next());
                }
                if (r==1){
                    first=calc.getResult();
                    second = Integer.valueOf(scanner.next());
                }
                if ((r<0)||(r>1))
                    break;
                calc.clearResult();
                if (op == 1)
                    calc.add(first, second);
                if (op == 2)
                    calc.deduct(first, second);
                if (op == 3)
                    calc.multiply(first, second);
                if (op == 4)
                    calc.delete(first, second);
                if ((op<1)||(op>5)) {
                    System.out.println("Введено неправильное значение");
                    break;
                }
                System.out.println(calc.getResult());
                System.out.println("Выберите операцию:");
                System.out.println("1 - сложение, 2 - вычитание, 3 - умножение, 4 - деление, 5 - выход");
                op = Integer.valueOf(scanner.next());
                if (op == 5) break;
                System.out.println("Выберите операцию:");
                System.out.println("0 - новые значения, 1 - использовать предыдущее значение");
                r = Integer.valueOf(scanner.next());
            }

        }
        catch(Exception e){
            System.out.println("Введено неправильное значение");
        }
        finally {
            scanner.close();
        }
    }
}
