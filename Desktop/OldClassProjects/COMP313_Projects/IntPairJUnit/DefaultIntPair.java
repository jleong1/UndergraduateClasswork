public class DefaultIntPair implements IntPair { 

    private int first, second;
    
    public DefaultIntPair(int first, int second) {
        this.first = first; this.second = second;
    }
    
    // methods required by the IntPair interface
    public int first() { return first; } 
    public int second() { return second; }
    
    public DefaultIntPair reverse() {
        return new DefaultIntPair(second, first);
    }
    
    // Overridden Object methods required by the @Test method calls
    @Override // optional
    public String toString() {
        return "<" + first + ", " + second + ">";
    }

    @Override // optional
    public boolean equals(final Object that) { // “final” is optional
        return (that instanceof DefaultIntPair) && (this.first() == ((DefaultIntPair) that).first()) &&
                    (this.second() == ((DefaultIntPair) that).second());
    }
}