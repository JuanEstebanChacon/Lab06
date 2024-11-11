
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
            Imagenes[0] = new ImageIcon(getClass().getResource("/casino/Imagenes/1.jpg"));
            Imagenes[1] = new ImageIcon(getClass().getResource("/casino/Imagenes/2.jpg"));
            Imagenes[2] = new ImageIcon(getClass().getResource("/casino/Imagenes/3.jpg"));
            Imagenes[3] = new ImageIcon(getClass().getResource("/casino/Imagenes/4.jpg"));
            Imagenes[4] = new ImageIcon(getClass().getResource("/casino/Imagenes/5.jpg"));
            Imagenes[5] = new ImageIcon(getClass().getResource("/casino/Imagenes/6.jpg"));
            Imagenes[6] = new ImageIcon(getClass().getResource("/casino/Imagenes/7.jpg"));
            
            Imagen1.setIcon(Imagenes[0]);
            Imagen2.setIcon(Imagenes[0]);
            Imagen3.setIcon(Imagenes[0]);
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
        private class RuletaImagen1 implements Runnable {
        
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        int randomIndex = (int) (Math.random() * Imagenes.length); // Genera un índice aleatorio para la cara
                        Imagen1.setIcon(Imagenes[randomIndex]); // Actualiza la imagen de la cara del dado
                        mainPanel.repaint();
                        Thread.sleep(200); // Pausa de 200 ms
                    }
                } catch (InterruptedException ex) {
                }
            }
        }
    }
    


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new Casino().setVisible(true);
        });
    }
}
