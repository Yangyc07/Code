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
import com.yang.codetype.impl.ChineseType;
import com.yang.codetype.impl.EasyType;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author 杨亚宸
 */
public class TestServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        CodeBean cb = Director.creatCodeBean(new CalculateType());
        cb = new SimpleCodeShape(100, 30, cb,false).getCodeShape();
        BufferedImage bi = cb.getBufferedimage();
        String result = cb.getResult();
        request.getSession().setAttribute("piccode", result.toString());
        ImageIO.write(bi, "JPG", response.getOutputStream());
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
