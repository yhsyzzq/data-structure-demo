package com.zzq.demo.charpter3;

import java.math.BigDecimal;
import java.util.Stack;

/**
 * 四则运算计算
 * Created by yhsyzzq on 2017-12-04.
 */
public class Calculator {
    public static Stack calculateStack = new Stack();

    public static String calculate(String suffixExpression) {
        String[] seArray = suffixExpression.split(" ");
        String numberPattern = "^[0-9]+$";

        for (int i = 0; i < seArray.length; i++) {
            String element = seArray[i];
            if (element.matches(numberPattern)) {
                calculateStack.push(element);
            } else {
                char symbol = element.charAt(0);
                if (symbol == '+') {
                    BigDecimal a = new BigDecimal((String) calculateStack.pop()); //加数
                    BigDecimal b = new BigDecimal((String) calculateStack.pop()); //被加数
                    BigDecimal result = b.add(a);
                    calculateStack.push(result.toString());
                } else if (symbol == '-') {
                    BigDecimal a = new BigDecimal((String) calculateStack.pop()); //减数
                    BigDecimal b = new BigDecimal((String) calculateStack.pop()); //被减数
                    BigDecimal result = b.subtract(a);
                    calculateStack.push(result.toString());
                } else if (symbol == '*') {
                    BigDecimal a = new BigDecimal((String) calculateStack.pop()); //乘数
                    BigDecimal b = new BigDecimal((String) calculateStack.pop()); //被乘数
                    BigDecimal result = b.multiply(a);
                    calculateStack.push(result.toString());
                } else if (symbol == '/') {
                    BigDecimal a = new BigDecimal((String) calculateStack.pop()); //除数
                    BigDecimal b = new BigDecimal((String) calculateStack.pop()); //被乘数
                    BigDecimal result = b.divide(a);
                    calculateStack.push(result.toString());
                }
            }
        }
        return calculateStack.peek().toString();
    }

    public static void main(String[] args) {
        String suffixExpression = ExpressTranslator.transToSuffixExpression("9+(3-1)*3+10/2");
        System.out.println(suffixExpression);
        int result = Integer.valueOf(Calculator.calculate(suffixExpression));
        System.out.println("calculate result is " + result);
    }

}
