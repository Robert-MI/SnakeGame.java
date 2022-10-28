package SnakeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameOverPage extends JFrame implements ActionListener {
    JLabel scoreText = new JLabel();
    JLabel gameOverText = new JLabel();
    JButton buttonRestart = new JButton("Restart");
    JButton button = new JButton("Back to main menu");
    JButton buttonExit = new JButton("Exit");
    private ActionEvent e;

    GameOverPage(int number) {
        this.setTitle("Snake");
        scoreText.setText("Your final score is: "  + number);
        scoreText.setBounds(175, 100, 300, 40);
        scoreText.setForeground(new Color(2, 100, 100));
        scoreText.setSize(300, 50);
        scoreText.setFont(new Font("MV Boil", Font.BOLD, 25));
        this.add(scoreText);

        gameOverText.setText("Game Over");
        gameOverText.setBounds(220, 50, 300, 40);
        gameOverText.setForeground(new Color(255, 0, 0));
        gameOverText.setSize(300, 50);
        gameOverText.setFont(new Font("MV Boil", Font.BOLD, 30));
        this.add(gameOverText);

        buttonRestart.setBounds(200, 200, 200, 40);
        buttonRestart.setFocusable(false);
        buttonRestart.addActionListener(this);
        buttonExit.setBounds(200, 300, 200, 40);
        buttonExit.setFocusable(false);
        buttonExit.addActionListener(e1 -> System.exit(0));
        button.setBounds(200, 250, 200, 40);
        button.setFocusable(false);
        button.addActionListener(this);

        ImageIcon image = new ImageIcon("src\\SnakeGame\\snake.png");

        this.setIconImage(image.getImage());
        ImageIcon reset = new ImageIcon("src\\SnakeGame\\restart.png");
        Image newReset = reset.getImage();
        Image modifiedReset = newReset.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        reset = new ImageIcon(modifiedReset);
        buttonRestart.setHorizontalTextPosition(JButton.LEFT);
        buttonRestart.setIcon(reset);

        ImageIcon exitGame = new ImageIcon("src\\SnakeGame\\exit.png");
        Image newExit = exitGame.getImage();
        Image modifiedExit = newExit.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        exitGame = new ImageIcon(modifiedExit);
        buttonExit.setHorizontalTextPosition(JButton.LEFT);
        buttonExit.setIcon(exitGame);

        ImageIcon menuGame = new ImageIcon("src\\SnakeGame\\menu.png");
        Image newMenu = menuGame.getImage();
        Image modifiedMenu = newMenu.getScaledInstance(20,20, Image.SCALE_SMOOTH);
        menuGame = new ImageIcon(modifiedMenu);
        button.setHorizontalTextPosition(JButton.LEFT);
        button.setIcon(menuGame);

        this.setTitle("Snake");
        this.add(button);
        this.add(buttonExit);
        this.add(buttonRestart);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(615, 640);
        this.setLayout(null);
        this.setResizable(false);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == buttonRestart){
            dispose();
            new Thread(){
                @Override
                public void run(){
                    new Game();
                }
            }.start(); this.dispose();
        }
        if (e.getSource() == button){
            LunchPage lunchPage = new LunchPage();
            this.dispose();
        }
    }
}