package com.zz.leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n){
        List<String> combinations = new ArrayList<>();
        generateAll(new char[2 * n], 0, combinations);
        return combinations;
    }

    private void generateAll(char[] current, int pos, List<String> result) {
        if (pos == current.length) {
            if(isValid(current))
                result.add(new String(current));
        } else {
            current[pos] = '(';
            generateAll(current, pos+1, result);
            current[pos] = ')';
            generateAll(current, pos+1, result);
        }
    }

    private Boolean isValid(char[] parenthes){
        Stack<Character> charStack = new Stack<>();
        for (int i = 0 ; i < parenthes.length ; ++i){
            if (charStack.empty()){
                if (parenthes[i] == ')') return false;
                charStack.push(parenthes[i]);
                continue;
            }

            if (!charStack.peek().equals(parenthes[i])){
                charStack.pop();
            }else{
                charStack.push(parenthes[i]);
            }
        }

        return charStack.empty() ? true : false;
    }

    public static void main(String[] args) {
        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }
}
