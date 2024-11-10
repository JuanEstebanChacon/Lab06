
package com.mycompany.casino;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
        this.setBounds(0, 0, 640, 366);
    }

    private void ventanas(JPanel ventana) {
        setContentPane(ventana);
        revalidate();
        repaint();
    }

    class PanelDados extends JPanel {
        private ImageIcon NumeroDados[] = new ImageIcon[6];
        private JLabel Dado1 = new JLabel(NumeroDados[0], JLabel.CENTER);
        private JLabel Dado2 = new JLabel(NumeroDados[0], JLabel.CENTER);
        public PanelDados() {
            setLayout(new BorderLayout());
            JLabel label = new JLabel("", JLabel.CENTER);
            JButton volverButton = new JButton("Volver");
            JButton iniciarrButton = new JButton("Iniciar");
            JPanel imagePanel = new JPanel();
            imagePanel.setLayout(new GridLayout(1, 2, 10, 10));
            imagePanel.add(Dado1);
            imagePanel.add(Dado2);

            add(label, BorderLayout.NORTH);
            add(imagePanel, BorderLayout.CENTER);
            
            
            
            add(label, BorderLayout.CENTER);
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(volverButton);
            buttonPanel.add(iniciarrButton);
            add(buttonPanel, BorderLayout.SOUTH);

            volverButton.addActionListener((ActionEvent e) -> {
                ventanas(mainPanel); 
            });
            iniciarrButton.addActionListener((ActionEvent e) -> {
                ventanas(mainPanel); 
            });
        }
    }

    class PanelMonedas extends JPanel {
        private ImageIcon Imagenes[] = new ImageIcon[7];
        private JLabel Imagen1 = new JLabel(Imagenes[0], JLabel.CENTER);
        private JLabel Imagen2 = new JLabel(Imagenes[0], JLabel.CENTER);
        private JLabel Imagen3 = new JLabel(Imagenes[0], JLabel.CENTER);
        public PanelMonedas() {
            setLayout(new BorderLayout());
            JLabel label = new JLabel("", JLabel.CENTER);
            JButton volverButton = new JButton("Volver");
            JButton iniciarrButton = new JButton("Iniciar");
            JPanel imagePanel = new JPanel();
            imagePanel.setLayout(new GridLayout(1, 2, 10, 10));
            imagePanel.add(Imagen1);
            imagePanel.add(Imagen2);
            imagePanel.add(Imagen3);
            
            add(label, BorderLayout.NORTH);
            add(imagePanel, BorderLayout.CENTER);
            
            
            
            add(label, BorderLayout.CENTER);
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(volverButton);
            buttonPanel.add(iniciarrButton);
            add(buttonPanel, BorderLayout.SOUTH);

            volverButton.addActionListener((ActionEvent e) -> {
                ventanas(mainPanel); 
            });
            iniciarrButton.addActionListener((ActionEvent e) -> {
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
