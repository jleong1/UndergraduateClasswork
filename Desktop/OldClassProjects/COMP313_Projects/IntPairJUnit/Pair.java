public interface Pair<T> {  // public not required
    T first();
    T second();
    Pair<T> reverse();
	@Override boolean equals(Object that);
	@Override String toString();
}
