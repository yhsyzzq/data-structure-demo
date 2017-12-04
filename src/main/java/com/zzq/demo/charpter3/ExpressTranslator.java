package com.zzq.demo.charpter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 四则运算中缀表达式转后缀表达式
 * Created by yhsyzzq on 2017-12-04.
 */
public class ExpressTranslator {

    private static Stack expressionStack = new Stack();

    /**
     * 中缀表达式转后缀表达式，栈的应用【9+(3-1)*3+10/2】
     *
     * @param middleExpression
     * @return
     */
    public static String transToSuffixExpression(String middleExpression) {

        List<String> meList = new ArrayList<String>();
        String temp = "";

        //将中缀表达式拆分成字符串数组
        for (int i = 0; i < middleExpression.length(); i++) {
            char val = middleExpression.charAt(i);
            if (val >= 48 && val <= 57) {
                temp += val;
                if (i == middleExpression.length() - 1 && temp != "") {
                    meList.add(temp);
                }
            } else {
                if (temp != "") meList.add(temp);
                meList.add(String.valueOf(val));
                temp = "";
            }
        }

        StringBuilder sb = new StringBuilder();
        String numberPattern = "^[0-9]+$"; //数字正则表达式
        for (int i = 0; i < meList.size(); i++) {
            String element = meList.get(i);
            //获取栈顶元素
            String topElement = null;
            if (!expressionStack.empty()) {
                topElement = (String) expressionStack.peek();
            }
            //数字直接出栈，不放入
            if (element.matches(numberPattern)) {
                sb.append(element + " ");
            } else {
                if (expressionStack.empty()) {
                    expressionStack.push(element);
                } else {
                    //进栈元素为右括号
                    if (")".equals(element)) {
                        //进栈元素为有括号时，出栈左右括号之间的运算符，加入到表达式中
                        String symbol = (String) expressionStack.pop();
                        while (!"(".equals(symbol)) {
                            sb.append(symbol + " ");
                            symbol = (String) expressionStack.pop();
                        }
                    } else if (("+".equals(element) || "-".equals(element)) && (topElement != null && ("*".equals(topElement) || "/".equals(topElement)))) {
                        //进栈元素运算优先级高于栈顶元素
                        while (!expressionStack.empty()) {
                            String symbol = (String) expressionStack.pop();
                            sb.append(symbol + " ");
                        }
                        expressionStack.push(element);
                    } else {
                        expressionStack.push(element);
                    }
                }

            }
        }

        //遍历完之后，如果栈中还有元素，则将所有元素依次出栈
        while (!expressionStack.empty()) {
            String symbol = (String) expressionStack.pop();
            sb.append(symbol + " ");
        }

        return sb.toString();

    }

    public static void main(String[] args) {
        String suffixExpression = ExpressTranslator.transToSuffixExpression("9+(3-1)*3+10/2");
        System.out.println("");
        System.out.println(suffixExpression);
    }
}
