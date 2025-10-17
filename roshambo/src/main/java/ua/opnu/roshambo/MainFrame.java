package ua.opnu.roshambo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame implements ActionListener {

    public MainFrame(String title) throws HeadlessException {
        super(title);

        this.setResizable(false);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        ((JComponent) getContentPane()).setBorder(
                BorderFactory.createMatteBorder(10, 10, 10, 10, Color.WHITE));

        JButton rockButton = new JButton("Камінь");
        rockButton.addActionListener(this);
        rockButton.setActionCommand("rock");

        JButton paperButton = new JButton("Папір");
        paperButton.addActionListener(this);
        paperButton.setActionCommand("paper");

        JButton scissorsButton = new JButton("Ножиці");
        scissorsButton.addActionListener(this);
        scissorsButton.setActionCommand("scissors");

        this.add(rockButton);
        this.add(paperButton);
        this.add(scissorsButton);

        this.pack();
        this.setVisible(true);
    }

    private GameShape generateShape() {
        return RoshamboUtils.getRandomShape();
    }

    private int checkWinner(GameShape player, GameShape computer) {
        return RoshamboUtils.checkWinner(player, computer);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        GameShape computerShape = generateShape();
        GameShape playerShape = null;

        switch (e.getActionCommand()) {
            case "rock":
                playerShape = new Rock();
                break;
            case "paper":
                playerShape = new Paper();
                break;
            case "scissors":
                playerShape = new Scissors();
                break;
        }

        int gameResult = checkWinner(playerShape, computerShape);

        String message = "Гравець: " + playerShape +
                "\nКомп’ютер: " + computerShape + "\n";

        switch (gameResult) {
            case -1:
                message += "Комп’ютер переміг!";
                break;
            case 0:
                message += "Нічия!";
                break;
            case 1:
                message += "Гравець переміг!";
                break;
        }

        JOptionPane.showMessageDialog(this, message);
    }

    public static void main(String[] args) {
        new MainFrame("Гра: Камінь, ножиці, папір");
    }
}
