/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yang.bean;

import com.sun.corba.se.impl.encoding.BufferManagerReadGrow;
import java.awt.image.BufferedImage;

/**
 *
 * @author 杨亚宸
 */
//该类是验证码类
public class CodeBean {

    private String[] codeArray;
    private BufferedImage bufferedimage;
    private String result;

    public String[] getCodeArray() {
        return codeArray;
    }

    public void setCodeArray(String[] codeArray) {
        this.codeArray = codeArray;
    }

    public BufferedImage getBufferedimage() {
        return bufferedimage;
    }

    public void setBufferedimage(BufferedImage bufferedimage) {
        this.bufferedimage = bufferedimage;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
