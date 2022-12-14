package lesson6.PokerWithOOP.model;

import java.util.Objects;

public class Gamer {

    private String name;

    public Gamer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gamer gamer = (Gamer) o;
        return Objects.equals(name, gamer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Gamer{" +
                "name='" + name + '\'' +
                '}';
    }
}
