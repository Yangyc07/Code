/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yang.codetype.impl;

import com.yang.bean.CodeBean;
import com.yang.codetype.Itype;
import java.util.Random;

/**
 *
 * @author 杨亚宸
 */
public class CalculateType implements Itype {

    Random random = new Random();
    private String[] codeArray;
    private static char[] operation = "+-*".toCharArray();
    private int result = 0;
    private int length = 4;

    public CalculateType() {
    }

    @Override
    public CodeBean getcode() {
        CodeBean codeBean = new CodeBean();
        codeArray = new String[length];
        char op = operation[random.nextInt(3)];
        int number1 = random.nextInt(10);
        int number2 = random.nextInt(10);

        if (op == '+') {
            result = number1 + number2;
        } else if (op == '-') {
            result = number1 - number2;
        } else {
            result = number1 * number2;
        }

        codeArray[0] = String.valueOf(number1);
        codeArray[1] = String.valueOf(number2);
        codeArray[2] = String.valueOf(op);
        codeArray[3] = String.valueOf("=");

        codeBean.setCodeArray(codeArray);
        codeBean.setResult(String.valueOf(result));
        return codeBean;
    }
}
