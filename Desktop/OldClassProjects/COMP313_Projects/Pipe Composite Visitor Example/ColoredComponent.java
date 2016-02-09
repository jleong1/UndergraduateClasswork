public class ColoredComponent extends Component { // a decorator for leaf nodes (only)
	private String color;
	private Component decoratedComponent;
	
	public ColoredComponent(Component component, String color) {
		super(component.getName() + ", color " + color);
		this.color = color;
		decoratedComponent = component;
	}
	public String getColor() {return color;}
	public Component getDecoratedComponent() {return decoratedComponent;}
	
	public double getUKLength(){ return decoratedComponent.getUKLength(); } // delegation
	public double getUSLength(){ return decoratedComponent.getUSLength(); }
	
	public <Result> Result accept(ComponentVisitor<Result> v) {return v.visit(this);}
}
