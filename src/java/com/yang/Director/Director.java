/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yang.Director;

import com.yang.bean.CodeBean;
import com.yang.codeshape.IcodeShape;
import com.yang.codetype.Itype;
import com.yang.codetype.impl.CalculateType;
import com.yang.codetype.impl.ChineseType;
import com.yang.codetype.impl.EasyType;
import java.util.Random;

/**
 *
 * @author 杨亚宸
 */
public class Director {
    public static CodeBean creatCodeBean(Itype type){
        if(type!=null){
            return type.getcode();
        }
        return null;
    }
    

    public static CodeBean creatCodeBean() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        String []typemethod={"com.yang.codetype.impl.ChineseType","com.yang.codetype.impl.CalculateType","com.yang.codetype.impl.EasyType"};
        Random random=new Random();
        Class c=Class.forName(typemethod[random.nextInt(3)]);
        Object obj=c.newInstance();
        Itype type=(Itype)obj;
        return type.getcode();
    }
}
