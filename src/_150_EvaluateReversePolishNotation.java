import java.util.Stack;

public class _150_EvaluateReversePolishNotation {

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            String token = tokens[i];
            if (token.matches("-*[0-9]+")){
                stack.push(Integer.parseInt(token));
            }else {
                Integer b = stack.pop();
                Integer a = stack.pop();
                switch (token){
                    case "+":
                        stack.push(a + b);
                        break;
                    case "-":
                        stack.push(a - b);
                        break;
                    case "*":
                        stack.push(a * b);
                        break;
                    case "/":
                        stack.push(a / b);
                }
            }
        }
        return stack.pop();
    }

    public static int evalRPN_faster(String[] tokens) {
        int len = tokens.length;
        int[] stack = new int[len];
        int pointer = 0;
        for (int i = 0; i < len; i++) {
            String token = tokens[i];
            switch (token){
                case "+":
                    stack[pointer - 2] = stack[pointer - 2] + stack[pointer - 1];
                    pointer--;
                    break;
                case "-":
                    stack[pointer - 2] = stack[pointer - 2] - stack[pointer - 1];
                    pointer--;
                    break;
                case "*":
                    stack[pointer - 2] = stack[pointer - 2] * stack[pointer - 1];
                    pointer--;
                    break;
                case "/":
                    stack[pointer - 2] = stack[pointer - 2] / stack[pointer - 1];
                    pointer--;
                    break;
                default:
                    stack[pointer++] = Integer.parseInt(token);
            }
        }
        return stack[0];
    }

    public static void main(String[] args) {
/*        String str = "12";
        if (str.matches("-*[0-9]+")){
            System.out.println(true);
            System.out.println(Integer.parseInt(str));
        }else {
            System.out.println(false);
        }*/
        String[] input = {"2", "1", "+", "3", "*"};
//        String[] input = {"4", "13", "5", "/", "+"};
//        String[] input = {"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};
        System.out.println(evalRPN(input));
        System.out.println(evalRPN_faster(input));
    }
}
