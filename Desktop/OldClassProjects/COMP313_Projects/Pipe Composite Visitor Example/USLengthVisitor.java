import java.util.*;

public class USLengthVisitor implements ComponentVisitor<Double> {
	private String howFar = ""; // how much in total to ident the output
	private String indent = "    "; // how far to indent each subcomponent (4 spaces)
	
	// use the default Java constructor

	public Double visit(UKPipe p) {
		System.out.println(howFar + "Visiting " + p.getName());
		double USLength = p.getUSLength();
		System.out.println(howFar + "Length of " + p.getName() + " is " + USLength + " feet");
		return USLength;
	}	
	public Double visit(USPipe p) {
		System.out.println(howFar + "Visiting " + p.getName());
		double USLength = p.getUSLength();
		System.out.println(howFar + "Length of " + p.getName() + " is " + USLength + " feet");
		return USLength;
	}
	public Double visit(PipeAssembly pa) {
		System.out.println(howFar + "Visiting " + pa.getName());
		double totalLength = 0.0;
		indent();
		List<Component> components = pa.getComponents();
		for (Component c : components) {
			totalLength += c.accept(this);
		}
		undent();
		System.out.println(howFar + "Total length of " + pa.getName() + " is " + totalLength + " feet");
		return totalLength;
	}
	public Double visit(ColoredComponent cc) { // color of Pipe is irrelevant for Length
		System.out.println(howFar + "Visiting " + cc.getName());
		indent();
		double USLength = cc.getDecoratedComponent().accept(this);
		undent();
		System.out.println(howFar + "Length of " + cc.getName() + " is " + USLength + " feet");
		return USLength;
	}
	private void indent() {howFar += indent;}
	private void undent() {howFar = howFar.substring(0, howFar.length() - indent.length());}
}
