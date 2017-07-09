package com.katermar.assignment5;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by USER on 7/8/2017.
 */
public class Vertex {
    private final Character value;
    private Set<Vertex> neighbours = new HashSet<>();

    public Vertex(Character v) {
        value = v;
    }

    public boolean addEdgeTo(Vertex other) {
        return neighbours.add(other);
    }

    public Character getValue() {
        return value;
    }

    public Set<Vertex> getNeighbours() {
        return neighbours;
    }

    @Override
    public String toString() {
        return "Vertex{item=" + value + ", neighbours=" + neighbours + "}";
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj != null && obj instanceof Vertex) {
            Vertex other = (Vertex) obj;
            return value.equals(other.value);
        }
        return false;
    }
}
