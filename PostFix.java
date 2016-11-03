import java.util.Stack;
import java.util.Scanner;

public class PostFix
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter expression: ");
        String userInput = input.nextLine();
        String output = getPostFix(userInput);
        System.out.println(output);
    }

    public static String getPostFix(String input1)
    {
        Stack<Character> myStack = new Stack<Character>();
        String output = "";
        int i = 0;
        while(i < input1.length()) {
            char val = input1.charAt(i);
            if (val >= 48 && val <= 57) {
                // value is digit
                output = output + String.valueOf(val);
            } else if (val == '+' || val == '-' || val == '^' ||
                       val == '*' || val == '/') {
                if (myStack.isEmpty() || myStack.peek() == '(') {
                    myStack.push(val);
                } else {
                    // check precedence
                    // else pop until precedence met
                    char val2 = myStack.peek();
                    while(getPrec(val2)>=getPrec(val)) {
                        val2 = myStack.pop();
                        output = output + String.valueOf(val2);
                        if(myStack.isEmpty())
                            break;
                        else
                            val2 = myStack.peek();
                    }
                    myStack.push(val);
                }
            } else if (val == '(') {
                myStack.push(val);
            } else if (val == ')') {
                // check precedence
                char val2 = myStack.pop();
                while(val2 != '(') {
                    output = output + String.valueOf(val2);
                    val2 = myStack.pop();
                }
            }
            i++;
        }

        while(!myStack.isEmpty()) {
            char val2 = myStack.pop();
            output = output + String.valueOf(val2);
        }
        return output;
    }


    public static int getPrec(char val)
    {
        if(val == '+' || val == '-')
            return 0;
        else if (val == '*' || val == '/')
            return 1;
        else
            return 3;
    }
}
