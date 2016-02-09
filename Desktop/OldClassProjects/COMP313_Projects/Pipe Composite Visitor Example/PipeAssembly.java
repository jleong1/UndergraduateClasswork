import java.util.*;

public class PipeAssembly extends Component {

	protected List<Component> components;
	
	public PipeAssembly(String name) {
		super(name);
		components = new ArrayList<Component>();
	}
	
	public void addComponent(Component c) {components.add(c);}
	public boolean removeComponent(Component c) {return components.remove(c);}
	public List<Component> getComponents() {return components;}
	
	public double getUKLength(){ // returns length in meters
		double totalUKLength = 0.0;
		for (Component c : components)
			totalUKLength += c.getUKLength();
		return totalUKLength;
	}
	public double getUSLength(){ // returns length in feet
		double totalUSLength = 0.0;
		for (Component c : components)
			totalUSLength += c.getUSLength();
		return totalUSLength;
	}
	
	// let the visitor traverse the structure and process all needed information
	public <Result> Result accept(ComponentVisitor<Result> v) {return v.visit(this);}
}
