/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.currencyconverter;

/**
 *
 * @author hp
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CURRENCYCONVERTER extends JFrame {
    private JTextField inputField;
    private JComboBox<String> fromComboBox;
    private JComboBox<String> toComboBox;
    private JLabel resultLabel;

    private String[] currencies = {"USD", "EUR", "GBP", "JPY", "CAD", "AUD", "INR"};

    private double[][] conversionRates = {
        // Conversion rates from USD to other currencies
        {1.0, 0.86, 0.72, 109.80, 1.25, 1.30, 74.76},
        // Conversion rates from EUR to other currencies
        {1.17, 1.0, 0.84, 128.20, 1.46, 1.52, 88.46},
        // Conversion rates from GBP to other currencies
        {1.39, 1.19, 1.0, 152.67, 1.74, 1.81, 105.91},
        // Conversion rates from JPY to other currencies
        {0.0091, 0.0078, 0.0066, 1.0, 0.011, 0.012, 0.692},
        // Conversion rates from CAD to other currencies
        {0.80, 0.68, 0.57, 87.34, 1.0, 1.04, 60.88},
        // Conversion rates from AUD to other currencies
        {0.77, 0.65, 0.54, 82.49, 0.96, 1.0, 58.47},
        // Conversion rates from INR to other currencies
        {0.013, 0.011, 0.0095, 1.44, 0.016, 0.017, 1.0}
    };

    public CURRENCYCONVERTER() {
        setTitle("Currency Converter");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(4, 2));

        JLabel inputLabel = new JLabel("Enter amount:");
        inputField = new JTextField();
        JLabel fromLabel = new JLabel("From:");
        fromComboBox = new JComboBox<>(currencies);
        JLabel toLabel = new JLabel("To:");
        toComboBox = new JComboBox<>(currencies);
        JButton convertButton = new JButton("Convert");
        resultLabel = new JLabel();

        convertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                convertCurrency();
            }
        });

        add(inputLabel);
        add(inputField);
        add(fromLabel);
        add(fromComboBox);
        add(toLabel);
        add(toComboBox);
        add(convertButton);
        add(resultLabel);
    }

    private void convertCurrency() {
        try {
            double amount = Double.parseDouble(inputField.getText());
            int fromIndex = fromComboBox.getSelectedIndex();
            int toIndex = toComboBox.getSelectedIndex();

            double conversionRate = conversionRates[fromIndex][toIndex];
            double result = amount * conversionRate;

            resultLabel.setText(String.format("%.2f %s = %.2f %s", amount, currencies[fromIndex], result, currencies[toIndex]));
        } catch (NumberFormatException e) {
            resultLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CURRENCYCONVERTER().setVisible(true);
            }
        });
    }
} 
