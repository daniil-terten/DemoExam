package com.polomka.UI;

import com.polomka.utils.TableManager;

import javax.swing.*;

public class ClientForm extends BaseForm{
    private JTable ClientTable;
    private JPanel panel;
    private JButton button1;

    public ClientForm(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setContentPane(panel);
        TableManager.refreshTable(ClientTable);
    }
}
