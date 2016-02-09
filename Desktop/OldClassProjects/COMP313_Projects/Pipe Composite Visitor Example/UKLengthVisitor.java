import java.util.*;

public class UKLengthVisitor implements ComponentVisitor<Double> {
	private String howFar = ""; // how much in total to ident the output
	private String indent = "    "; // how far to indent each subcomponent (4 spaces)
	
	// use the default Java constructor

	public Double visit(UKPipe p) {
		System.out.println(howFar + "Visiting " + p.getName());
		double UKLength = p.getUKLength();
		System.out.println(howFar + "Length of " + p.getName() + " is " + UKLength + " meters");
		return UKLength;
	}	
	public Double visit(USPipe p) {
		System.out.println(howFar + "Visiting " + p.getName());
		double UKLength = p.getUKLength();
		System.out.println(howFar + "Length of " + p.getName() + " is " + UKLength + " meters");
		return UKLength;
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
		System.out.println(howFar + "Total length of " + pa.getName() + " is " + totalLength + " meters");
		return totalLength;
	}
	public Double visit(ColoredComponent cc) { // color of Pipe is irrelevant for Length
		System.out.println(howFar + "Visiting " + cc.getName());
		indent();
		double UKLength = cc.getDecoratedComponent().accept(this);
		undent();
		System.out.println(howFar + "Length of " + cc.getName() + " is " + UKLength + " meters");
		return UKLength;
	}
	private void indent() {howFar += indent;}
	private void undent() {howFar = howFar.substring(0, howFar.length() - indent.length());}
}
