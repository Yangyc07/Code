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
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Random;

/**
 *
 * @author 杨亚宸
 */
public class SimpleCodeShape implements IcodeShape{
    Random random = new Random();
    Itype type;

    int width = 90;
    int height = 30;
    int lineNum=2;
    
    public void drawpoint(BufferedImage bi)//画干扰点
    {
        float yawpRate = 0.05f;// 噪声率
        int area = (int) (yawpRate * width * height);
        for (int i = 0; i < area; i++) {
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            bi.setRGB(x, y, random.nextInt(255));
        }
    }
    
    public void drawline(BufferedImage bi){//画干扰线
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
        if (fc > 255)
            fc = 255;
        if (bc > 255)
            bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
}
    @Override
    public CodeBean getCodeShape() {
       int index=0;
       CodeBean codeBean=type.getcode();
       BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
       String result=codeBean.getResult();
       Graphics g = bi.getGraphics();
       Color c = new Color(200, 150, 255);
       g.setColor(c);
       g.fillRect(0, 0, width,height);
       drawline(bi);
       drawpoint(bi);
       for (int i = 0; i < 4; i++) {
                        index = random.nextInt(60);
                        g.setColor(new Color(random.nextInt(88), random.nextInt(188), random.nextInt(255)));
			g.drawString(result.charAt(i)+"", (i*15)+3, 18);
        }
       codeBean.setBufferedimage(bi);
       return codeBean;
    }

    public void setType(Itype type) {
        this.type = type;
    }

    public SimpleCodeShape(int width , int height , Itype type) {
        this.width=width;
        this.type=type;
        this.type = type;
    }
}
