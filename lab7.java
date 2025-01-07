import java.util.Scanner;

class Main extends Exception
{
    Main(String message)
    {
        super(message);
    }
}

class Father
{
    int age;

    Father(int age) throws Main
    {
        if (age < 0)
        {
            throw new Main("WrongAge: Age cannot be negative");
        }
        this.age = age;
    }
}

class Son extends Father
{
    int sonAge;

    Son(int fatherAge, int sonAge) throws Main
    {
        super(fatherAge);
        if (sonAge >= fatherAge)
        {
            throw new Main("WrongAge: Son's age cannot be greater than or equal to Father's age");
        }
        this.sonAge = sonAge;
    }
}

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Father's age: ");
            int fatherAge = sc.nextInt();
            System.out.print("Enter Son's age: ");
            int sonAge = sc.nextInt();
            Son obj = new Son(fatherAge, sonAge);
            System.out.println("Father's age: " + fatherAge + ", Son's age: " + sonAge);
        }
        catch (Main e)
        {
            System.out.println(e.getMessage());
        }
    }
}
