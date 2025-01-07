abstract class Shape
{
    int s1, s2;

    public Shape(int a, int b)
    {
        this.s1 = a;
        this.s2 = b;
    }

    public Shape(int a)
    {
        this.s1 = a;
    }

    public abstract void printArea();
}

class Rectangle extends Shape
{
    public Rectangle(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void printArea()
    {
        System.out.println("Area : " + (s1 * s2));
    }
}

class Triangle extends Shape
{
    public Triangle(int x, int y)
    {
        super(x, y);
    }

    @Override
    public void printArea()
    {
        System.out.println("Area : " + (0.5 * s1 * s2));
    }
}

class Circle extends Shape
{
    public Circle(int x)
    {
        super(x);
    }

    @Override
    public void printArea()
    {
        System.out.println("Area : " + (Math.PI * s1 * s1));
    }
}

public class Demo
{
    public static void main(String args[])
    {
        Shape obj1 = new Rectangle(10, 20);
        obj1.printArea();

        Shape obj2 = new Triangle(1, 3);
        obj2.printArea();

        Shape obj3 = new Circle(10);
        obj3.printArea();
    }
}
