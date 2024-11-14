
package com.mycompany.casino;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Casino extends JFrame {
    private JPanel mainPanel;
    private JButton botondados;
    private JButton botonmonedas;
    private ImageIcon[] images = new ImageIcon[6];
   
    public Casino() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        mainPanel = new JPanel();
        botondados = new JButton("Dados");
        botonmonedas = new JButton("Traga Monedas");
        for (int n = 0; n < 6; n++) {
            ImageIcon originalImage = new ImageIcon("C:\\Users\\juche\\Documents\\NetBeansProjects\\casino\\src\\main\\java\\com\\mycompany\\casino\\Imagenes\\" + (n + 1) + ".jpg");
            Image scaledImage = originalImage.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
            images[n] = new ImageIcon(scaledImage);
        }


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
      

        public PanelDados() {
            setLayout(new BorderLayout());
            JLabel label = new JLabel("Juego de Dados", JLabel.CENTER);
            JButton volverButton = new JButton("Volver");
            JButton iniciarButton = new JButton("Iniciar");
            
            
            
            JPanel buttonPanel = new JPanel();
            buttonPanel.add(volverButton);
            buttonPanel.add(iniciarButton);
            add(buttonPanel, BorderLayout.SOUTH);
            volverButton.addActionListener((ActionEvent e) -> {
                ventanas(mainPanel);
            });

            iniciarButton.addActionListener((ActionEvent e) -> {

            });
        }
    }
 

    class PanelMonedas extends JPanel {
        private JLabel Imagen1;
        private JLabel Imagen2;
        private JLabel Imagen3;
        public PanelMonedas() {
            setLayout(new BorderLayout());
            JLabel label = new JLabel("", JLabel.CENTER);
            JButton volverButton = new JButton("Volver");
            JButton iniciarrButton = new JButton("Iniciar");

            JPanel imagePanel = new JPanel(new GridLayout(1, 2, 10, 10));

            Imagen1 = new JLabel(images[0], JLabel.CENTER);
            Imagen2 = new JLabel(images[1], JLabel.CENTER);
            Imagen3 = new JLabel(images[2], JLabel.CENTER);

            imagePanel.add(Imagen1);
            imagePanel.add(Imagen2);
            imagePanel.add(Imagen3);

            add(label, BorderLayout.NORTH);
            add(imagePanel, BorderLayout.CENTER);

            JPanel buttonPanel = new JPanel();
            buttonPanel.add(volverButton);
            buttonPanel.add(iniciarrButton);
            add(buttonPanel, BorderLayout.SOUTH);

            add(label, BorderLayout.NORTH);
            add(imagePanel, BorderLayout.CENTER);

            volverButton.addActionListener((ActionEvent e) -> {
                ventanas(mainPanel);
            });
            iniciarrButton.addActionListener((ActionEvent e) -> {
             Thread hilo = new Thread(new cambiarimagenes());
             hilo.start();
             Thread hilo2 = new Thread(new cambiarimagenes2());
             hilo2.start();
             Thread hilo3 = new Thread(new cambiarimagenes3());
             hilo3.start();
            });

        }
         private class cambiarimagenes implements Runnable {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        int randomIndex = (int) (Math.random() * images.length); // Genera un índice aleatorio para la cara
                        Imagen1.setIcon(images[randomIndex]); // Actualiza la imagen de la cara del dado
                        mainPanel.repaint();
                        Thread.sleep(200); // Pausa de 200 ms
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
         private class cambiarimagenes2 implements Runnable {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        int randomIndex = (int) (Math.random() * images.length); // Genera un índice aleatorio para la cara
                        Imagen2.setIcon(images[randomIndex]); // Actualiza la imagen de la cara del dado
                        mainPanel.repaint();
                        Thread.sleep(200); // Pausa de 200 ms
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }
         private class cambiarimagenes3 implements Runnable {
            @Override
            public void run() {
                try {
                    for (int i = 0; i < 10; i++) {
                        int randomIndex = (int) (Math.random() * images.length); // Genera un índice aleatorio para la cara
                        Imagen3.setIcon(images[randomIndex]); // Actualiza la imagen de la cara del dado
                        mainPanel.repaint();
                        Thread.sleep(200); // Pausa de 200 ms
                    }
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
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
