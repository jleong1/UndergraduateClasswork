public class VisitorTest {
	// test program for Components and Visitors
	
	public static void main(String[] args) {
		// create some US pipes
		Component us1 = new USPipe("Short US pipe", 1);
		Component us2 = new USPipe("Medium US pipe", 2);
		Component us3 = new USPipe("Long US pipe", 3);
		
		// and some UK pipes
		Component uk1 = new UKPipe("Short UK pipe", 1);
		Component uk2 = new UKPipe("Medium UK pipe", 2);
		Component uk3 = new UKPipe("Long UK pipe", 3);
		
		// plus some colored pipes
		Component us1r = new ColoredComponent(us1, "red");
		Component us2g = new ColoredComponent(us2, "green");
		Component uk3b = new ColoredComponent(uk3, "beige");
		
		// and finally a structure to traverse
		PipeAssembly root = new PipeAssembly("root node");
		root.addComponent(us1r);
		root.addComponent(uk1);
		PipeAssembly subAssembly = new PipeAssembly("subnode");
		subAssembly.addComponent(us2g);
		subAssembly.addComponent(uk2);
		root.addComponent(subAssembly);
		PipeAssembly subSubAssembly = new PipeAssembly("subsubnode");
		subSubAssembly.addComponent(us3);
		subSubAssembly.addComponent(uk3b);
		subAssembly.addComponent(subSubAssembly);
		
		// check getName
		System.out.println("Some possibly decorated pipe names:");
		System.out.println(uk1.getName());
		System.out.println(us2g.getName());
		System.out.println(us3.getName());
		System.out.println();
		
		// first let the visitors traverse simple pipes
		ComponentVisitor nv = new NameVisitor();
		uk1.accept(nv);
		us2g.accept(nv);
		us3.accept(nv);
		System.out.println();
		
		ComponentVisitor uslv = new USLengthVisitor();
		uk1.accept(uslv);
		us2g.accept(uslv);
		us3.accept(uslv);
		System.out.println();
		
		ComponentVisitor uklv = new UKLengthVisitor();
		uk1.accept(uklv);
		us2g.accept(uklv);
		us3.accept(uklv);
		System.out.println();
		
		// then let the visitors visit the composite structures ...
		root.accept(nv);
		System.out.println();
		root.accept(uslv);
		System.out.println();
		root.accept(uklv);
	}
}
