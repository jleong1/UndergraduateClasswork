package edu.luc.etl.cs313.android.shapes.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import edu.luc.etl.cs313.android.shapes.model.*;

/**
 * A Visitor for drawing a shape to an Android canvas.
 */
public class Draw implements Visitor<Void> {

	// TODO entirely your job (except onCircle)

	private final Canvas canvas;

	private final Paint paint;

	public Draw(final Canvas canvas, final Paint paint) {
		this.canvas = canvas;
		this.paint = paint;
		this.paint.setStyle(Style.STROKE);
	}

	@Override
	public Void onCircle(final Circle c) {
		canvas.drawCircle(0, 0, c.getRadius(), paint);
		return null;
	}

	@Override
	public Void onStroke(final Stroke c) {
		final int previous = paint.getColor();
		paint.setColor(c.getColor());
		c.getShape().accept(this);
		paint.setColor(previous);
		return null;
	}

	@Override
	public Void onFill(final Fill f) {
		final Style previous = paint.getStyle();
		paint.setStyle(Style.FILL_AND_STROKE);
		f.getShape().accept(this);
		paint.setStyle(previous);
		return null;
	}

	@Override
	public Void onGroup(final Group g) {
		for (final Shape s : g.getShapes()) {
			s.accept(this);
		}
		return null;
	}

	@Override
	public Void onLocation(final Location l) {
		canvas.translate(l.getX(), l.getY());
		l.getShape().accept(this);
		canvas.translate(-l.getX(), -l.getY());
		return null;
	}

	@Override
	public Void onRectangle(final Rectangle r) {
		canvas.drawRect(0, 0, r.getWidth(), r.getHeight(), paint);
		return null;
	}

	@Override
	public Void onOutline(Outline o) {
		final Style previous = paint.getStyle();
		paint.setStyle(Style.STROKE);
		o.getShape().accept(this);
		paint.setStyle(previous);
		return null;
	}

	@Override
	public Void onPolygon(final Polygon s) {
		final int n = s.getPoints().size();
		final float[] pts = new float[4 * n];
		int k = 0;
		// set starting points
		for (final Point p : s.getPoints()) {
			pts[k] = p.getX();
			pts[k + 1] = p.getY();
			k += 4;
		}
		// set end points
		for (int l = 4; l < 4 * n; l += 4) {
			pts[l - 2] = pts[l];
			pts[l - 1] = pts[l + 1];
		}
		// close polygon
		pts[4 * n - 2] = pts[0];
		pts[4 * n - 1] = pts[1];
		// draw polygon
		canvas.drawLines(pts, paint);
		return null;
	}
}
