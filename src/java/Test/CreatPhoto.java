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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author 杨亚宸
 */
public class CreatPhoto {
    public static void main(String []args) throws IOException{
        try {
            //   for(int i=0;i<10000;i++){
            CodeBean codebean = Director.creatCodeBean();
            codebean = new SimpleCodeShape(100, 30, codebean,false);
            BufferedImage bi = codebean.getBufferedimage();
            String result = codebean.getResult();
            System.out.println(result);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreatPhoto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(CreatPhoto.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(CreatPhoto.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }
