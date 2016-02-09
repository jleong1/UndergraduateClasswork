interface ComponentVisitor<Result> {
	Result visit(UKPipe p);
	Result visit(USPipe p);
	Result visit(PipeAssembly pa);
	Result visit(ColoredComponent cc);
}
