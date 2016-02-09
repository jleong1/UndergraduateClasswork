public class UKPipe extends Component {
	protected double lengthInMeters;
	
	public UKPipe(String name, double length) {
		super(name);
		lengthInMeters = length;
	}
	
	public double getUKLength(){return lengthInMeters;} // returns length in meters
	public double getUSLength(){ // returns length in feet
		return lengthInMeters * FEET_PER_METER;
	}
	
	public <Result> Result accept(ComponentVisitor<Result> v) {return v.visit(this);}
}
