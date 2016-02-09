
/**
 * Write a description of class CheckRectangle here.
 * i) Look at the enclosed file called Rectangle.java which is an interface.
 * Use the interface to implement a Rectangle class by using appropriate variables
 * and implement the relevant methods.
(ii) Extend the Rectangle class to a Square class where each Square is defined by
 one value namely length of the side. (Think how the methods of computing area or 
 perimeter will work in the new Square class.)
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class CheckRectangle implements Rectangle
{
    protected double length = 0.00;
    protected double width = 0.00;
    public double computeArea(double width, double length)
    {
        return width*length;
    }
    double computePerimeter(double width, double length)
    {
        return 2*width + 2*length;
    }
    public void displayRectangle()
    {
       System.out.println("Length of Rectangle: " + length);
       System.out.println("Width of Rectanble: " + width);
    }
}
