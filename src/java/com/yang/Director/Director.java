/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yang.Director;

import com.yang.bean.CodeBean;
import com.yang.codeshape.IcodeShape;
import com.yang.codetype.Itype;

/**
 *
 * @author 杨亚宸
 */
public class Director {
    public Itype creatCodeBean(Itype type){
        if(type!=null){
            return type;
        }
        return null;
    }
}
