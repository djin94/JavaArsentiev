package lesson5;
/**
 * Created by Йотун on 08.01.2017.
 */
public class ArgRunner {
    public static void main(String[] args) {
        try {
            int op = Integer.valueOf(args[0]);
            int first = Integer.valueOf(args[1]);
            int second = Integer.valueOf(args[2]);
            Calculator calc = new Calculator();
            if (op==1)
                calc.add(first,second);
            if (op==2)
                calc.deduct(first, second);
            if (op==3)
                calc.multiply(first,second);
            if (op==4)
                calc.delete(first,second);
            System.out.println(calc.getResult());
        } finally {

        }
    }
}
