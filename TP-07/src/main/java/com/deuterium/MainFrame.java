package com.deuterium;

import com.posadskiy.currencyconverter.CurrencyConverter;
import com.posadskiy.currencyconverter.config.ConfigBuilder;
import com.posadskiy.currencyconverter.enums.Currency;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    public static final String CURRENCY_CONVERTER_API_API_KEY = "586a734a1fcb6565b5c7";

    private JTextField jTextFieldAmount;
    private JComboBox<Currency> jComboBoxFrom;
    private JComboBox<Currency> jComboBoxTo;
    private JButton jButtonConvert;
    private JLabel jLabelResult;

    public MainFrame() {

        super("TP07 - Currency Converter - Hamza Hadfi");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        BoxLayout mgr = new BoxLayout(panel, BoxLayout.X_AXIS);
        panel.setLayout(mgr);


        jTextFieldAmount = new JTextField(10);

        jComboBoxFrom = new JComboBox<>(Currency.values());
        jComboBoxFrom.setSelectedItem(Currency.EUR);
        jComboBoxTo = new JComboBox<>(Currency.values());
        jComboBoxTo.setSelectedItem(Currency.TND);
        jButtonConvert = new JButton("Convert");

        jLabelResult = new JLabel("Result Here!!");

        jTextFieldAmount.setHorizontalAlignment(JTextField.CENTER);

        panel.add(Box.createRigidArea(new Dimension(5, 0)));
        panel.add(jTextFieldAmount);
        panel.add(Box.createRigidArea(new Dimension(5, 0)));
        panel.add(jComboBoxFrom);
        jComboBoxFrom.setNextFocusableComponent(jComboBoxTo);
        panel.add(Box.createRigidArea(new Dimension(5, 0)));
        panel.add(new JLabel("to"));
        panel.add(Box.createRigidArea(new Dimension(5, 0)));
        panel.add(jComboBoxTo);
        jComboBoxTo.setNextFocusableComponent(jButtonConvert);
        panel.add(Box.createRigidArea(new Dimension(5, 0)));
        panel.add(jButtonConvert);
        jButtonConvert.setNextFocusableComponent(jTextFieldAmount);
        panel.add(Box.createRigidArea(new Dimension(5, 0)));
        panel.add(jLabelResult);
        panel.add(Box.createRigidArea(new Dimension(5, 0)));

        panel.setBorder(BorderFactory.createRaisedSoftBevelBorder());

        jButtonConvert.addActionListener(e -> {
            CurrencyConverter converter = new CurrencyConverter(
                    new ConfigBuilder()
                            .currencyConverterApiApiKey(CURRENCY_CONVERTER_API_API_KEY)
                            .build()
            );

            Currency currencyFrom = (Currency) jComboBoxFrom.getSelectedItem();
            Currency currencyTo = (Currency) jComboBoxTo.getSelectedItem();


            Double conversionRate;
            Double amount;

            try {
                conversionRate = converter.rate(currencyFrom, currencyTo);
                amount = Double.valueOf(jTextFieldAmount.getText());
                jLabelResult.setText(String.format("%.3f", amount * conversionRate) + " " + java.util.Currency.getInstance(jComboBoxTo.getSelectedItem().toString()).getSymbol());
            } catch (NumberFormatException numberFormatException) {
                JOptionPane.showMessageDialog(MainFrame.this, "Please provide a valid amount 'Money' -- Please", "Amount Error", JOptionPane.ERROR_MESSAGE);
            } catch (Exception exception) {
                JOptionPane.showMessageDialog(MainFrame.this, "Can not connect to the exchange service", "Network Error", JOptionPane.ERROR_MESSAGE);
            }

        });

        add(panel);

        SwingUtilities.getRootPane(jButtonConvert).setDefaultButton(jButtonConvert);

        pack();
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
    }
}
