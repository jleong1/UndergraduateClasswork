public class USPipe extends Component {
	protected double lengthInFeet;
	
	public USPipe(String name, double length) {
		super(name);
		lengthInFeet = length;
	}
		
	public double getUKLength(){ // returns length in meters
		return lengthInFeet / FEET_PER_METER;
	}
	public double getUSLength(){return lengthInFeet;} // returns length in feet
	
	public <Result> Result accept(ComponentVisitor<Result> v) {return v.visit(this);}
}
