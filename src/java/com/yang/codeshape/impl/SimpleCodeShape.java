/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.yang.codeshape.impl;

import com.yang.bean.CodeBean;
import com.yang.codeshape.IcodeShape;
import com.yang.codetype.Itype;
import com.yang.codetype.impl.EasyType;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author 杨亚宸
 */
public class SimpleCodeShape implements IcodeShape {

    
    Random random = new Random();
    Itype type;
    boolean transform=true;
    
    int width = 90;
    int height = 30;
    int lineNum = 2;

    public void drawPoint(BufferedImage bi)//画干扰点
    {
        float yawpRate = 0.05f;// 噪声率
        int area = (int) (yawpRate * width * height);
        for (int i = 0; i < area; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            bi.setRGB(x, y, random.nextInt(255));
        }
    }

    public void drawLine(BufferedImage bi) {//画干扰线
        Graphics graphics = bi.getGraphics();
        for (int i = 0; i < lineNum; i++) {
            int xs = random.nextInt(width);
            int ys = random.nextInt(height);
            int xe = xs + random.nextInt(width);
            int ye = ys + random.nextInt(height);
            graphics.setColor(getRandColor(1, 255));
            graphics.drawLine(xs, ys, xe, ye);
        }
    }

    public Color getRandColor(int fc, int bc) {// 给定范围获得随机颜色
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    @Override
    public CodeBean getCodeShape() {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = bi.getGraphics();
        Color color = new Color(253, 251, 255);
        graphics.setColor(color);
        graphics.fillRect(0, 0, width, height);
        drawLine(bi);
        drawPoint(bi);
        CodeBean codeBean=drawCode(graphics);
        codeBean.setBufferedimage(bi);
        return codeBean;
    }

    public void setType(Itype type) {
        this.type = type;
    }
    
    public CodeBean drawCode(Graphics graphics){
        CodeBean codeBean=type.getcode();
        if(codeBean!=null&&codeBean.getCodeArray()!=null&&codeBean.getResult()!=null){
            for(int i=0;i<codeBean.getCodeArray().length;i++){
                String code=String.valueOf(codeBean.getCodeArray()[i]);
                if(transform){
                    AffineTransform fontAT=new AffineTransform();//图像变形类
                    int rotate = random.nextInt(25);
                    fontAT.rotate(random.nextBoolean() ? Math.toRadians(rotate) : -Math.toRadians(rotate / 2));
                    Font fx = new Font(new String[] { "Times New Roman", "Verdana",
                            "arial" }[random.nextInt(2)], random.nextInt(5),
                            14 + random.nextInt(8)).deriveFont(fontAT);
                            graphics.setFont(fx);
                }
                  graphics.setColor(getRandColor(1, 255));
                  graphics.drawString(code, (i*width/5)+5, height/2+ random.nextInt(height/4));
            }
        }
        return codeBean;
    }
    
    public SimpleCodeShape(int width, int height, Itype type , boolean transform) {
        this.width = width;
        this.height = height;
        this.type = type;
        this.transform=transform;
    }
}
