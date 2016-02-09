package edu.luc.etl.cs313.android.shapes.model;

/**
 * A shape visitor for calculating the bounding box, that is, the smallest
 * rectangle containing the shape. The resulting bounding box is returned as a
 * rectangle at a specific location.
 */
public class BoundingBox implements Visitor<Location> {

	// TODO entirely your job (except visitCircle)

	@Override
	public Location onCircle(final Circle c) {
		final int radius = c.getRadius();
		return new Location(-radius, -radius, new Rectangle(2 * radius,
				2 * radius));
	}

	@Override
	public Location onFill(final Fill f) {
		return f.getShape().accept(this);
	}

	@Override
	public Location onGroup(final Group g) {
		int xl = Integer.MAX_VALUE;
		int xr = Integer.MIN_VALUE;
		int yd = Integer.MAX_VALUE;
		int yu = Integer.MIN_VALUE;
		for (final Shape s : g.getShapes()) {
			Location b = s.accept(this);
			xl = Math.min(xl, b.getX());
			xr = Math.max(xr, b.getX() + ((Rectangle) b.getShape()).getWidth());
			yd = Math.min(yd, b.getY());
			yu = Math.max(yu, b.getY() + ((Rectangle) b.getShape()).getHeight());
		}
		return new Location(xl, yd, new Rectangle(xr - xl, yu - yd));
	}

	@Override
	public Location onLocation(final Location l) {
		final Location b = l.getShape().accept(this);
		return new Location(l.getX() + b.getX(), l.getY() + b.getY(),
				b.getShape());
	}

	@Override
	public Location onRectangle(final Rectangle r) {
		return new Location(0, 0, r);
	}

	@Override
	public Location onStroke(final Stroke c) {
		return c.getShape().accept(this);
	}

	@Override
	public Location onOutline(final Outline o) {
		return o.getShape().accept(this);
	}

	@Override
	public Location onPolygon(final Polygon s) {
		return onGroup(s);
	}
}
