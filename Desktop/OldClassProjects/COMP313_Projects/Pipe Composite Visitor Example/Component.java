public abstract class Component {
	// in this class a leaf Component is a pipe with a specified length
	private String name;
	protected final static double FEET_PER_METER = 3.2808399;
	
	public Component(String name) {setName(name);}
	
	public String getName() {return name;}
	protected void setName(String name) {this.name = name;}
	
	// Components have lengths in either feet or meters
	public abstract double getUSLength(); // returns length in feet
	public abstract double getUKLength(); // returns length in meters
	public abstract <Result> Result accept(ComponentVisitor<Result> cv);
}
