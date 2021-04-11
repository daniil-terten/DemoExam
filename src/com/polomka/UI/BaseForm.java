package com.polomka.UI;

import javax.swing.*;
import java.awt.*;

public class BaseForm extends JFrame {
    public BaseForm(){
        setTitle("ООО Поломка");
        setMinimumSize(new Dimension(1200,800));
        setLocationRelativeTo(null);
        setIconImage(new ImageIcon(getClass().getResource("service_logo.png")).getImage());
    }
}
