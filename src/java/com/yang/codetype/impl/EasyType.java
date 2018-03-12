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
//该类是实现简单的数字字母验证码的生成
public class EasyType implements Itype{

    private static char[] ch = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
    Random random = new Random();
    private int length = 4;
    
    public EasyType() {
    }

    public int getLength() {
        return length;
    }
    
    
    @Override
    public CodeBean getcode() {
        
       CodeBean codeBean = new CodeBean();
       String codeArray[] = new String[length];
       
       StringBuffer builder = new StringBuffer();
       for(int i=0;i<length;i++){
           char c=ch[random.nextInt(ch.length)];
           String ch = String.valueOf(c);
           codeArray[i] = ch;
           builder.append(ch);
       } 
           codeBean.setCodeArray(codeArray);
           codeBean.setResult(builder.toString()); 
           System.out.println(codeArray);
           return codeBean;
    }    
}
