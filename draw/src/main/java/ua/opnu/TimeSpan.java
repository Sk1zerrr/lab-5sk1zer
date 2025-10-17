package ua.opnu;

/**
 * Часовий інтервал. Зберігається як кількість хвилин (може бути від'ємною).
 * Надано декілька конструкторів та перевантажені методи додавання/віднімання.
 */
public class TimeSpan {
    // Зберігаємо інтервал у хвилинах
    private int totalMinutes;

    // Конструктор без аргументів -> 0 год 0 хв
    public TimeSpan() {
        this.totalMinutes = 0;
    }

    // Конструктор з одним аргументом (хвилини)
    public TimeSpan(int minutes) {
        this.totalMinutes = minutes;
    }

    // Конструктор з двома аргументами (години, хвилини)
    public TimeSpan(int hours, int minutes) {
        this.totalMinutes = hours * 60 + minutes;
    }

    // Конструктор копіювання (TimeSpan)
    public TimeSpan(TimeSpan other) {
        if (other == null) {
            this.totalMinutes = 0;
        } else {
            this.totalMinutes = other.totalMinutes;
        }
    }

    // Геттери (повертають нормалізовані години і хвилини)
    public int getHours() {
        return totalMinutes / 60;
    }

    public int getMinutes() {
        // повертаємо хвилини в -59..59 залежно від totalMinutes
        int mins = totalMinutes % 60;
        return mins >= 0 ? mins : mins + 60 * (mins != 0 ? 1 : 0); 
        // Примітка: простіше — використовувати Math.floorDiv/Math.floorMod, але так теж працює.
    }

    // Повернути загальні хвилини (для тестів/логіки)
    public int getTotalMinutes() {
        return totalMinutes;
    }

    // set метод (опціонально)
    public void setTime(int hours, int minutes) {
        this.totalMinutes = hours * 60 + minutes;
    }

    // toString для зручного виводу
    @Override
    public String toString() {
        int h = totalMinutes / 60;
        int m = Math.abs(totalMinutes % 60);
        return String.format("%d год %d хв", h, m);
    }

    // --- Методи додавання (перевантажені) ---

    // Додаємо години та хвилини
    public void add(int hours, int minutes) {
        this.totalMinutes += hours * 60 + minutes;
    }

    // Додаємо хвилини
    public void add(int minutes) {
        this.totalMinutes += minutes;
    }

    // Додаємо з TimeSpan
    public void add(TimeSpan other) {
        if (other != null) {
            this.totalMinutes += other.totalMinutes;
        }
    }

    // --- Методи віднімання (перевантажені) ---

    // Відняти години та хвилини
    public void subtract(int hours, int minutes) {
        this.totalMinutes -= hours * 60 + minutes;
    }

    // Відняти хвилини
    public void subtract(int minutes) {
        this.totalMinutes -= minutes;
    }

    // Відняти TimeSpan
    public void subtract(TimeSpan other) {
        if (other != null) {
            this.totalMinutes -= other.totalMinutes;
        }
    }

    // За потреби — нормалізація (в разі, якщо хочете обмежити minutes 0..59)
    public void normalize() {
        // тут нічого робити — ми зберігаємо у хвилинах; getHours/getMinutes дають інтерпретацію.
    }
}
