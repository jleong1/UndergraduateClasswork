package edu.luc.etl.cs313.android.shapes.android;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

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
		paint.setStyle(Style.STROKE);
	}

	@Override
	public Void onCircle(final Circle c) {
		canvas.drawCircle(0, 0, c.getRadius(), paint);
		return null;
	}

	@Override
	public Void onStroke(final Stroke c) {

        int color = paint.getColor();
        paint.setColor(c.getColor());
        c.getShape().accept(this);
        paint.setColor(color);

		return null;
	}

	@Override
	public Void onFill(final Fill f) {
        paint.setStyle(Style.FILL_AND_STROKE);
        f.getShape().accept(this);
		return null;
	}

	@Override
	public Void onGroup(final Group g) {
        for(int i = 0; i<g.getShapes().size();i++)
        {
            g.getShapes().get(i).accept(this);
        }
		return null;
	}

	@Override
	public Void onLocation(final Location l) {

        canvas.translate(l.getX(),l.getY());
        l.getShape().accept(this);
        canvas.translate(-l.getX(), -l.getY());

		return null;
	}

	@Override
	public Void onRectangle(final Rectangle r) {
        canvas.drawRect(0,0,r.getWidth(),r.getHeight(),paint);
		return null;
	}

	@Override
	public Void onOutline(Outline o) {
        paint.setStyle(Style.STROKE);
        o.getShape().accept(this);
		return null;
	}

	@Override
	public Void onPolygon(final Polygon s) {
        List<? extends Point> points = s.getPoints();
        final float[] pts = new float[(points.size()+1)*4];

        for(int i = 0;i<points.size()-1;i++)
        {
            pts[4*i]=points.get(i).getX();
            pts[4*i+1]=points.get(i).getY();
            pts[4*i+2]=points.get(i+1).getX();
            pts[4*i+3]=points.get(i+1).getY();
        }


        pts[pts.length-4]=points.get(points.size()-1).getX();
        pts[pts.length-3]=points.get(points.size()-1).getY();
        pts[pts.length-2]=points.get(0).getX();
        pts[pts.length-1]=points.get(0).getY();
        //need to get rid of line in polygon
        //
        //
		canvas.drawLines(pts, paint);
		return null;
	}
}
