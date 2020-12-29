package entity;

public class Pair<K, V> {
    public K first;
    public V second;

    public Pair(K first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", this.first, this.second);
    }

    public static void main(String[] args) {
        Pair<Integer, Integer> pair = new Pair<>(1, 2);
        System.out.println(pair);
    }
}
