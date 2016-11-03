import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter you expression to calculate: ");
        String exp = input.nextLine();
        String post = PostFix.getPostFix(exp);
        System.out.println("Postfix: " + post);
        String total = String.valueOf(Calc.calcExp(post));
        System.out.println("Result: " + total);
    }
}

