package game;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class AuxiliaryWindow1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private static Gamezinho gamezinho;
    private Timer timer; //////////////////

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    AuxiliaryWindow1 frame = new AuxiliaryWindow1(gamezinho);
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public AuxiliaryWindow1(Gamezinho gamezinho) {
        AuxiliaryWindow1.gamezinho = gamezinho;
        initialize();
    }

    private void initialize() {
        setTitle("BlindGame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 520, 336);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Instancia e inicia o timer ao criar a janela
        timer = new Timer(33); ////////////////////////
        new Thread(() -> timer.start()).start();  ////////////////////////

        JButton continueButton = new JButton("Continuar");
        continueButton.setBounds(183, 258, 138, 23);
        continueButton.setFont(new Font("Arcadepix Plus", Font.PLAIN, 23));
        contentPane.add(continueButton);
        continueButton.setVisible(false);
        continueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Gamezinho.atualizarVidas();

                dispose();
                if (Pont_Sys.verify == 1) {
                    Gamezinho.Lilbelula.setIcon(new ImageIcon(Gamezinho.class.getResource("/img/morreu2.gif")));
                } else {
                    Gamezinho.Lilbelula.setIcon(new ImageIcon(Gamezinho.class.getResource("/img/walking1.gif")));
                }
                Pont_Sys.verifytovitory1= 1 ;
                
                timer.stop();  ////////////////////////
            }
        });

        JButton closeButton = new JButton("Fechar");
        closeButton.setFont(new Font("Arcadepix Plus", Font.PLAIN, 14));
        closeButton.setBounds(399, 11, 95, 23);
        getContentPane().add(closeButton);
        
        JLabel result = new JLabel("");
        result.setVerticalAlignment(SwingConstants.TOP);
        result.setFont(new Font("Arcadepix Plus", Font.PLAIN, 18));
        result.setBounds(21, 216, 300, 34);
        contentPane.add(result);
        
        JLabel vida = new JLabel(""); 
        vida.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        vida.setHorizontalAlignment(SwingConstants.CENTER);
        vida.setForeground(new Color(0, 0, 0));
        vida.setFont(new Font("Arcadepix Plus", Font.PLAIN, 36));
        vida.setBounds(403, 228, 70, 34);
        contentPane.add(vida);
        
        JLabel Vida1 = new JLabel("<html>Vidas:<html><br>"+ Pont_Sys.life_total + "<html>pts<html>" );
        Vida1.setFont(new Font("Arcadepix Plus", Font.PLAIN, 30));
        Vida1.setHorizontalAlignment(SwingConstants.CENTER);
        Vida1.setBounds(403, 159, 70, 58);
        contentPane.add(Vida1);
        
        JLabel timerLabel = new JLabel("");
        timerLabel.setFont(new Font("Arcadepix Plus", Font.PLAIN, 13));
        timerLabel.setBounds(169, 267, 166, 14);
        contentPane.add(timerLabel, BorderLayout.NORTH);
        
        JLabel lblNewLabel = new JLabel("Efeito da gravidade");
        lblNewLabel.setFont(new Font("Arcadepix Plus", Font.PLAIN, 30));
        lblNewLabel.setBounds(20, 11, 271, 29);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("<html>Sua caminhada esta tranquila ate que de repente,<br>a gravidade na sua area comeca a oscilar estranhamente...</html>");
        lblNewLabel_1.setFont(new Font("Arcadepix Plus", Font.PLAIN, 20));
        lblNewLabel_1.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_1.setBounds(20, 51, 474, 40);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("<html>Tentar correr apesar da gravidade flutuante</html>");
        lblNewLabel_1_1.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_1_1.setFont(new Font("Arcadepix Plus", Font.PLAIN, 20));
        lblNewLabel_1_1.setBounds(60, 108, 366, 29);
        contentPane.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_1_1 = new JLabel("<html>Pular e flutuar ate a locadora </html>");
        lblNewLabel_1_1_1.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_1_1_1.setFont(new Font("Arcadepix Plus", Font.PLAIN, 20));
        lblNewLabel_1_1_1.setBounds(60, 148, 255, 29);
        contentPane.add(lblNewLabel_1_1_1);
        
        JLabel lblNewLabel_1_1_1_1 = new JLabel("<html>Aguardar ate a gravidade estabilizar </html>");
        lblNewLabel_1_1_1_1.setVerticalAlignment(SwingConstants.TOP);
        lblNewLabel_1_1_1_1.setFont(new Font("Arcadepix Plus", Font.PLAIN, 20));
        lblNewLabel_1_1_1_1.setBounds(60, 188, 303, 29);
        contentPane.add(lblNewLabel_1_1_1_1);
        
        JButton btn2 = new JButton("2");
        btn2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                result.setText("<html>Voce avanca rapidamente, mas acaba se chocando com um passaro e tem uma morte tragica.</html>");
                vida.setForeground(Color.RED);
                vida.setText("<html>Você morreu</html>");
                Util.wait(1500);
                Pont_Sys.life_total = 0;
                vida.setFont(new Font("Arcadepix Plus", Font.PLAIN, 22));
                vida.setText("<html>Voce morreu!</html>");
                Vida1.setText("<html>Vidas:<html><br>"+ Pont_Sys.life_total + "<html>pts<html>" );
                Gamezinho.Lilbelula.setIcon(new ImageIcon(Gamezinho.class.getResource("/img/morreu2.gif")));
                AudioPlayer player = new AudioPlayer();
                player.playSound("src/audio/morreu.wav");
                Pont_Sys.cena1 = 0;
                Pont_Sys.cena2 = 0;
                Pont_Sys.cena3 = 0;
                Pont_Sys.cena4 = 0;
                Pont_Sys.life_total=0;
                Pont_Sys.verify = 1;
                Gamezinho.reiniciar.setVisible(true); // Torna o botão reiniciar visível
                Gamezinho.reiniciar.setEnabled(true); // Habilita o botão reiniciar
                Pont_Sys.life_total = 10;
                timerLabel.setVisible(false);
                continueButton.setVisible(true);

                
                timer.stop();  ////////////////////////
                
            }
        });
        btn2.setMargin(new Insets(0, 0, 0, 0));
        btn2.setFont(new Font("Arcadepix Plus", Font.PLAIN, 23));
        btn2.setBounds(20, 140, 30, 30);
        contentPane.add(btn2);
        
        JButton btn1 = new JButton("1\r\n");
        btn1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                result.setText("<html>Voce consegue, mas a corrida e extenuante e voce fica exausto.</html>");
                vida.setForeground(Color.RED);
            	vida.setFont(new Font("Arcadepix Plus", Font.PLAIN, 25));
            	Pont_Sys.life_total-=2;
            	vida.setText("<html>-2pt</html>");
            	Vida1.setText("<html>Vidas:<html><br>"+ Pont_Sys.life_total + "<html>pts<html>" );
            	System.out.println(Pont_Sys.life_total);
            	timerLabel.setVisible(false);
            	continueButton.setVisible(true);

                
                timer.stop(); ////////////////////////
                
            }
        });
        btn1.setMargin(new Insets(0, 0, 0, 0));
        btn1.setFont(new Font("Arcadepix Plus", Font.PLAIN, 23));
        btn1.setBounds(20, 100, 30, 30);
        contentPane.add(btn1);
        
        JButton btn3 = new JButton("3");
        btn3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
            	result.setText("<html>Voce aguarda pacientemente e nao sofre danos, mas o atraso e consideravel.</html>");
            	vida.setForeground(Color.RED);
            	vida.setFont(new Font("Arcadepix Plus", Font.PLAIN, 25));
            	Pont_Sys.life_total-=3;
            	vida.setText("<html>-3pt</html>");
            	Vida1.setText("<html>Vidas:<html><br>"+ Pont_Sys.life_total + "<html>pts<html>" );
            	System.out.println(Pont_Sys.life_total);
            	timerLabel.setVisible(false);
            	continueButton.setVisible(true);

                
                timer.stop();  ////////////////////////
                 
            }
        });
        btn3.setMargin(new Insets(0, 0, 0, 0));
        btn3.setFont(new Font("Arcadepix Plus", Font.PLAIN, 23));
        btn3.setBounds(20, 180, 30, 30);
        contentPane.add(btn3);
        
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	Pont_Sys.verifytovitory1= 1 ;
                timer.stop();  ////////////////////////
                dispose();
            }
        });

        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        
        new Thread(() -> {
            while (timer.isRunning()) { 
                int remainingTime = timer.getRemainingTime(); 
                
                SwingUtilities.invokeLater(() -> {
                	if (remainingTime <= 2) {
                    	timer.stop();
                    	dispose();
                    	AudioPlayer player = new AudioPlayer();
                        player.playSound("src/audio/morreu.wav");
                        try {
                            SwingUtilities.invokeLater(() -> {
                                Gamezinho.Lilbelula.setIcon(new ImageIcon(Gamezinho.class.getResource("/img/morreu2.gif")));
                                Gamezinho.Lilbelula.revalidate();
                                Gamezinho.Lilbelula.repaint();
                            });
                        } catch (Exception e1) {
                            System.out.println(e1);
                        }

                        Gamezinho.laife.setVisible(false);
                        Gamezinho.reiniciar.setVisible(true);
                    }
                	timerLabel.setForeground(Color.RED);
                    timerLabel.setText("Tempo restante: " + (remainingTime-3)+ " segundos"); // Atualiza a label
                });
                try {
                    Thread.sleep(1000); // Espera 1 segundo antes de verificar novamente
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
            }
        }).start();
    }
}
