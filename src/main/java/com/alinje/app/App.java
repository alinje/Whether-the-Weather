package com.alinje.app;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.alinje.app.control.BaseControl;
import com.alinje.app.control.Control;

/**
 * Application entrance point.
 * @author Aline Eikeland @alinje
 */
public class App {

    public static void main(String[] args){

        int w;
        int h;
        try {
            Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
            w = (int) screenDim.getWidth();
            h = (int) screenDim.getHeight();

        // exception is thrown if security does not allow app to get screen size
        } catch (SecurityException e){
            e.printStackTrace();

            // if that's the case, app sets window to 900x600 dimension
            w = 900;
            h = 600;
        }

        // TODO select view here
        Control control = new BaseControl(w,h);
    }
}
