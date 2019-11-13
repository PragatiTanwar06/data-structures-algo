package com.pragati.cs435;

import java.util.*;

/**
 * Created by pragati on 12/11/19.
 */
public class ExpressionEval_Infix {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Character> stack = new Stack();

        Stack<Integer> stackInt = new Stack();

        for (; ; ) {
            String str = sc.next();

            for (int i = 0; i < str.length(); i++) {

                if (str.charAt(i) == '+' || str.charAt(i) == '-')
                    stack.push(str.charAt(i));
                else {
                    int a = str.charAt(i) - 48;

                    System.out.println("value: " + a);
                    stackInt.push(a);
                }
            }

            ExpressionEval_Infix obj = new ExpressionEval_Infix();
            obj.calculate(stack, stackInt);

        }
    }

    private void calculate(Stack<Character> stack, Stack<Integer> stackInt) {
        while(stack.size()!=0){
            char exp = stack.pop();

            int a = stackInt.pop();
            int b = stackInt.pop();

            if(exp =='+'){
                int c = b+a;
                stackInt.push(c);
            }
            else if(exp=='-'){
                int c = b-a;
                stackInt.push(c);
            }
        }

        System.out.println("Sol: "+ stackInt.pop());
    }
}
