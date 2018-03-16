/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Test;

import com.yang.Director.Director;
import com.yang.bean.CodeBean;
import com.yang.codeshape.IcodeShape;
import com.yang.codeshape.impl.SimpleCodeShape;
import com.yang.codetype.Itype;
import com.yang.codetype.impl.CalculateType;
import com.yang.codetype.impl.EasyType;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author 杨亚宸
 */
public class CreatPhoto {
    public static void main(String []args) throws IOException{
        for(int i=0;i<10000;i++){
        Itype ty = Director.creatCodeBean(new EasyType());
        IcodeShape cs = new SimpleCodeShape(100, 30, ty,false);
        CodeBean cb = cs.getCodeShape();
        BufferedImage bi = cb.getBufferedimage();
        String result = cb.getResult();
        ImageIO.write(bi, "JPG", new File("g:/Photo/"+i+".jpg"));
        }
    }
}
