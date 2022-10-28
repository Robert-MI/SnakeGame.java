package SnakeGame;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import java.awt.Container;

public class MyFrame extends JFrame{
    MyFrame(Board br){
        Container c = br;
        this.setContentPane(c);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon image = new ImageIcon("src\\SnakeGame\\snake.png");
        this.setIconImage(image.getImage());
        this.setTitle("Snake");
        this.pack();
        this.setVisible(true);
        this.setResizable(false);
    }
}