public class DefaultPair<T> implements Pair<T> { 

    private T first, second;
    
    public DefaultPair(T first, T second) {
        this.first = first; this.second = second;
    }
    
    // methods required by the IntPair interface
    public T first() { return first; } 
    public T second() { return second; }
    
    public DefaultPair<T> reverse() {
        return new DefaultPair<T>(second, first);
    }
    
    // Overridden Object methods required by the @Test method calls
    @Override // optional
    public String toString() {
        return "<" + first + ", " + second + ">";
    }

    @Override // optional
    public boolean equals(final Object that) { // “final” is optional
        return (that instanceof DefaultPair<?>) &&
				(this.first().equals(((DefaultPair<?>) that).first())) &&
                (this.second().equals(((DefaultPair<?>) that).second()));
    }
}
