package com.revature.consoleUI;


import javax.swing.text.BadLocationException;
import javax.swing.text.Position;
import javax.swing.text.View;
import java.awt.*;

//we will be replacing it with an API very soon.
public class MainMenu extends View {


    @Override
    public float getPreferredSpan(int axis) {
        return 0;
    }

    @Override
    public void paint(Graphics g, Shape allocation) {

    }

    @Override
    public Shape modelToView(int pos, Shape a, Position.Bias b) throws BadLocationException {
        return null;
    }

    @Override
    public int viewToModel(float x, float y, Shape a, Position.Bias[] biasReturn) {
        return 0;
    }
}
