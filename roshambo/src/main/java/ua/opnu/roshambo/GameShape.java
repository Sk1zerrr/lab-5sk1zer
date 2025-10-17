package ua.opnu.roshambo;

public abstract class GameShape {
    public abstract String name();

    @Override
    public String toString() {
        return name();
    }
}
