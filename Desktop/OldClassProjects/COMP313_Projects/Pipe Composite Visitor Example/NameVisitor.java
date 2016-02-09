import java.util.*;

public class NameVisitor implements ComponentVisitor<Void> {
	private String howFar = ""; // how far in total to indent the output
	private String indent = "    "; // how far to indent each subcomponent (4 spaces)
	private boolean println = true; // whether to do a println or a print
	
	// use the default Java constructor

	public Void visit(UKPipe p) {
		System.out.print(howFar + "Visiting UK Pipe named " + p.getName());
		if (println) System.out.println();
		return null;
	}	
	public Void visit(USPipe p) {
		System.out.print(howFar + "Visiting US Pipe named " + p.getName());
		if (println) System.out.println();
		return null;
	}
	public Void visit(PipeAssembly pa) {
		System.out.println(howFar + "Visiting PipeAssembly named " + pa.getName());
		List<Component> components = pa.getComponents();
		for (Component c : components) {
			indent();
			c.accept(this);
			undent();
		}
		return null;
	}
	public Void visit(ColoredComponent cc) { // this is not an ideal decorator!!
		println = false; // do not do a println, do a print
		cc.getDecoratedComponent().accept(this);
		System.out.println(", color " + cc.getColor());
		println = true;
		return null;
	}
	private void indent() {howFar += indent;}
	private void undent() {howFar = howFar.substring(0, howFar.length() - indent.length());}
}
