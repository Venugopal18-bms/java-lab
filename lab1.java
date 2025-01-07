class Quadratic
{
    double a;
    double b;
    double c;
    double root1, root2;

    public void calculateroots()
    {
        double discriminant = (b * b) - (4 * a * c);

        if (discriminant == 0)
        {
            System.out.println("Roots are real and equal");
            root1 = (-b + Math.sqrt(discriminant) / (2 * a));
            System.out.println("Root 1 : " + root1);
        }
        else if (discriminant < 0)
        {
            System.out.println("Roots are imaginary");
        }
        else
        {
            System.out.println("Roots are real and distinct");
            root1 = (-b + Math.sqrt(discriminant) / (2 * a));
            root2 = (-b - Math.sqrt(discriminant) / (2 * a));
            System.out.println("Root 1 : " + root1 + " Root 2 : " + root2);
        }
    }
}

public class Demoo
{
    public static void main(String args[])
    {
        Quadratic q = new Quadratic();
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a : ");
        q.a = sc.nextDouble();
        System.out.print("Enter b : ");
        q.b = sc.nextDouble();
        System.out.print("Enter c : ");
        q.c = sc.nextDouble();
        q.calculateroots();
    }
} 
