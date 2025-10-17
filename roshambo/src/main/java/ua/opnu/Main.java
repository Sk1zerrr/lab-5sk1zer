package ua.opnu;

import javax.swing.*;

import ua.opnu.roshambo.MainFrame;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainFrame("RoShamBo"));
    }
}
