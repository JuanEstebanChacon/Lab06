
package com.mycompany.casino;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Casino extends JFrame {
    private JPanel mainPanel;
    private JButton botondados;
    private JButton botonmonedas;

    public Casino() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        botondados = new JButton("Dados");
        botonmonedas = new JButton("Traga Monedas");

        mainPanel.add(botondados);
        mainPanel.add(botonmonedas);
        add(mainPanel);

        botondados.addActionListener((ActionEvent e) -> {
            ventanas(new PanelDados());
        });

        botonmonedas.addActionListener((ActionEvent e) -> {
            ventanas(new PanelMonedas());
        });
        pack();
    }

    private void ventanas(JPanel ventana) {
        setContentPane(ventana);
        revalidate();
        repaint();
    }

    class PanelDados extends JPanel {
        public PanelDados() {
            setLayout(new BorderLayout());
            JLabel label = new JLabel("", JLabel.CENTER);
            JButton volverButton = new JButton("Volver");

            add(label, BorderLayout.CENTER);
            add(volverButton, BorderLayout.SOUTH);

            volverButton.addActionListener((ActionEvent e) -> {
                ventanas(mainPanel); 
            });
        }
    }

    class PanelMonedas extends JPanel {
        public PanelMonedas() {
            setLayout(new BorderLayout());
            JLabel label = new JLabel("", JLabel.CENTER);
            JButton volverButton = new JButton("Volver");

            add(label, BorderLayout.CENTER);
            add(volverButton, BorderLayout.SOUTH);

            volverButton.addActionListener((ActionEvent e) -> {
                ventanas(mainPanel); 
            });
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Casino().setVisible(true);
        });
    }
}
