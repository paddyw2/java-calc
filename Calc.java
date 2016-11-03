import java.util.Stack;

public class Calc
{
    public static Integer calcExp(String post)
    {
        Stack<Integer> myStack = new Stack<Integer>();
        int total;
        int i=0;
        while(i<post.length()) {
            char val = post.charAt(i);
            if(val >= 48 && val <= 57) {
                myStack.push(val-48);
            } else if (val == '*' || val == '/' ||
                       val == '+' || val =='-') {
                int val1 = myStack.pop();
                int val2 = myStack.pop();
                if(val == '*')
                    total = (val1*val2);
                else if(val == '/')
                    total = (val2/val1);
                else if(val == '+')
                    total = (val1+val2);
                else
                    total = (val2-val1);

                myStack.push(total);
            }
            i++;
        }
        return myStack.pop();
    }
}

