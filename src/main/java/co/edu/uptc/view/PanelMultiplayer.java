package co.edu.uptc.view;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;

import view.constants.ColorPalette;
import view.constants.FontPalette;

public class PanelMultiplayer extends JPanel {

    private Image backgroundImage;
    private JPanel keyboardBackground;
    private JPanel hangmanPanel;
    private JPanel opponentHangmanPanel;
    private WordDisplayPanel wordDisplayPanel;
    private WordDisplayPanel opponentWordDisplayPanel;

    public PanelMultiplayer() {
        setSize(1300, 800);
        setBorder(BorderFactory.createLineBorder(Color.BLACK));
        backgroundImage = new ImageIcon("frontend-proyecto\\resources\\FondoMadera2.jpg").getImage();
        setLayout(null);
        initComponents();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
    }

    private void initComponents() {
        addkeyboard();
        addHangmanPanel();
        addPlayerNamePanel();
        addWordDisplayPanel();
        addOpponentHangmanPanel();
    }

    private void addkeyboard() {
        keyboardBackground = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(ColorPalette.COLOR_KEYBOARD);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
            }
        };
        keyboardBackground.setOpaque(false);
        keyboardBackground.setBounds(680, 500, 570, 200);
        keyboardBackground.setLayout(null);
        add(keyboardBackground);

        int startX = 10;
        int startY = 10;
        int buttonSpacing = 55;

        keyboardBackground.add(createButton("Q", startX, startY));
        keyboardBackground.add(createButton("W", startX + buttonSpacing, startY));
        keyboardBackground.add(createButton("E", startX + 2 * buttonSpacing, startY));
        keyboardBackground.add(createButton("R", startX + 3 * buttonSpacing, startY));
        keyboardBackground.add(createButton("T", startX + 4 * buttonSpacing, startY));
        keyboardBackground.add(createButton("Y", startX + 5 * buttonSpacing, startY));
        keyboardBackground.add(createButton("U", startX + 6 * buttonSpacing, startY));
        keyboardBackground.add(createButton("I", startX + 7 * buttonSpacing, startY));
        keyboardBackground.add(createButton("O", startX + 8 * buttonSpacing, startY));
        keyboardBackground.add(createButton("P", startX + 9 * buttonSpacing, startY));

        startY += 60;
        keyboardBackground.add(createButton("A", startX, startY));
        keyboardBackground.add(createButton("S", startX + buttonSpacing, startY));
        keyboardBackground.add(createButton("D", startX + 2 * buttonSpacing, startY));
        keyboardBackground.add(createButton("F", startX + 3 * buttonSpacing, startY));
        keyboardBackground.add(createButton("G", startX + 4 * buttonSpacing, startY));
        keyboardBackground.add(createButton("H", startX + 5 * buttonSpacing, startY));
        keyboardBackground.add(createButton("J", startX + 6 * buttonSpacing, startY));
        keyboardBackground.add(createButton("K", startX + 7 * buttonSpacing, startY));
        keyboardBackground.add(createButton("L", startX + 8 * buttonSpacing, startY));
        keyboardBackground.add(createButton("Ñ", startX + 9 * buttonSpacing, startY));

        startY += 60;
        int offsetX = startX + buttonSpacing + 30;
        keyboardBackground.add(createButton("Z", offsetX, startY));
        keyboardBackground.add(createButton("X", offsetX + buttonSpacing, startY));
        keyboardBackground.add(createButton("C", offsetX + 2 * buttonSpacing, startY));
        keyboardBackground.add(createButton("V", offsetX + 3 * buttonSpacing, startY));
        keyboardBackground.add(createButton("B", offsetX + 4 * buttonSpacing, startY));
        keyboardBackground.add(createButton("N", offsetX + 5 * buttonSpacing, startY));
        keyboardBackground.add(createButton("M", offsetX + 6 * buttonSpacing, startY));
    }

    private void addHangmanPanel() {
        hangmanPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2d.setColor(ColorPalette.COLOR_HANGMAN_BACKGROUND);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
                g2d.setColor(Color.BLACK);

                // BASE X y Y centrados
                int baseX = getWidth() / 2 - 90;
                int baseY = 60;

                // Poste
                g2d.drawLine(baseX, baseY + 300, baseX + 60, baseY + 300); // base del suelo
                g2d.drawLine(baseX + 30, baseY + 300, baseX + 30, baseY); // poste vertical
                g2d.drawLine(baseX + 30, baseY, baseX + 150, baseY); // barra superior
                g2d.drawLine(baseX + 150, baseY, baseX + 150, baseY + 50); // cuerda

                // Cabeza
                g2d.drawOval(baseX + 135, baseY + 50, 30, 30);
                // Cuerpo
                g2d.drawLine(baseX + 150, baseY + 80, baseX + 150, baseY + 160);
                // Brazos
                g2d.drawLine(baseX + 110, baseY + 110, baseX + 190, baseY + 110);
                // Piernas
                g2d.drawLine(baseX + 150, baseY + 160, baseX + 120, baseY + 220);
                g2d.drawLine(baseX + 150, baseY + 160, baseX + 180, baseY + 220);
            }
        };

        hangmanPanel.setOpaque(false);
        hangmanPanel.setBounds(50, 50, 600, 500);
        hangmanPanel.setLayout(null);
        add(hangmanPanel);
    }

    private void addPlayerNamePanel() {
        JPanel namePanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(ColorPalette.COLOR_NAME_PLAYER_FOND);
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 60, 60);
            }
        };
        namePanel.setOpaque(false);
        namePanel.setLayout(new BorderLayout());
        namePanel.setBounds(830, 420, 280, 50);

        JLabel nameLabel = new JLabel("ANDRES", SwingConstants.CENTER);
        nameLabel.setFont(FontPalette.JLABEL_NAME_FONT);
        nameLabel.setForeground(Color.BLACK);

        namePanel.add(nameLabel, BorderLayout.CENTER);
        add(namePanel);
    }

    private void addWordDisplayPanel() {
        wordDisplayPanel = new WordDisplayPanel();
        wordDisplayPanel.setBounds(100, 630, 800, 70);
        add(wordDisplayPanel);
    }

    private void addOpponentHangmanPanel() {
        opponentHangmanPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                g2d.setColor(ColorPalette.COLOR_HANGMAN_BACKGROUND);
                g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 50, 50);
                g2d.setColor(Color.BLACK);

                int baseX = getWidth() / 2 - 45;
                int baseY = 50; 

                // Base del suelo
                g2d.drawLine(baseX, baseY + 170, baseX + 30, baseY + 170);
                // Poste vertical
                g2d.drawLine(baseX + 15, baseY + 170, baseX + 15, baseY);
                // Barra superior
                g2d.drawLine(baseX + 15, baseY, baseX + 85, baseY);
                // Cuerda
                g2d.drawLine(baseX + 85, baseY, baseX + 85, baseY + 30);
                // Cabeza 
                g2d.drawOval(baseX + 75, baseY + 30, 20, 20);
                // Cuerpo 
                g2d.drawLine(baseX + 85, baseY + 50, baseX + 85, baseY + 95);
                // Brazos 
                g2d.drawLine(baseX + 60, baseY + 65, baseX + 110, baseY + 65);
                // Piernas
                g2d.drawLine(baseX + 85, baseY + 95, baseX + 65, baseY + 135);
                g2d.drawLine(baseX + 85, baseY + 95, baseX + 105, baseY + 135);
            }
        };

        opponentHangmanPanel.setOpaque(false);
        opponentHangmanPanel.setLayout(null);
        opponentHangmanPanel.setBounds(700, 50, 550, 350);

        opponentWordDisplayPanel = new WordDisplayPanel();
        opponentWordDisplayPanel.setBounds(130, 260, 300, 60);
        opponentHangmanPanel.add(opponentWordDisplayPanel);

        add(opponentHangmanPanel);
    }

    private JButton createButton(String text, int x, int y) {
        RoundedButtonv2 button = new RoundedButtonv2(text, 20);
        button.setBounds(x, y, 50, 50);
        button.setBackground(ColorPalette.COLOR_BUTTON);
        button.setForeground(Color.WHITE);
        button.setFont(FontPalette.BUTTON_KERYBOARD_FONT);
        return button;
    }

}