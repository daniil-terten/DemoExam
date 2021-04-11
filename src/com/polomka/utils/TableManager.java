package com.polomka.utils;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TableManager {
    public static void refreshTable(JTable table){
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        defaultTableModel.setColumnIdentifiers(new String[]{"Фамилия", "Имя", "Отчество", "Дата рождения", "Дата регистрации",
        "Email", "Телефон", "Пол", "Фотография"});
        DBHandler.openConnection();
        ResultSet resultSet = DBHandler.execQuery("SELECT p.LastName,p.FirstName,p.Patronymic," +
                "p.BirthDay,p.RegistrationDate,p.Email" +
                ",p.Phone,ps.Name,p.PhotoPath FROM client as p " +
                "INNER JOIN gender as ps ON ps.Code = p.GenderCode");
        try {
            while (resultSet.next()){
                defaultTableModel.addRow(new String[]{
                        resultSet.getString(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        resultSet.getString(4),
                        resultSet.getString(5),
                        resultSet.getString(6),
                        resultSet.getString(7),
                        resultSet.getString(8).equals("м")? "Мужской":"Женский",
                        resultSet.getString(9),

                });
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        table.setModel(defaultTableModel);
    }
}
