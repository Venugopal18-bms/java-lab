import java.util.Scanner;

class Example
{
    String name;
    String usn;
    public int[] marks = new int[8];
    public int[] grades = new int[8];
    public int[] credits = new int[8];

    public int creditssum(int arr[])
    {
        int s = 0;
        for (int i : arr)
        {
            s += i;
        }
        return s;
    }

    public void accept()
    {
        System.out.println("Enter the details : ");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name : ");
        name = sc.nextLine();
        System.out.print("Enter your USN : ");
        usn = sc.nextLine();
        for (int i = 0; i < 8; i++)
        {
            System.out.print("Enter subject " + (i + 1) + " marks : ");
            marks[i] = sc.nextInt();
            System.out.print("Enter the subject credit : ");
            credits[i] = sc.nextInt();
            if (marks[i] >= 90 && marks[i] <= 100)
            {
                grades[i] = 10;
            }
            else if (marks[i] >= 80 && marks[i] < 90)
            {
                grades[i] = 9;
            }
            else if (marks[i] >= 70 && marks[i] < 80)
            {
                grades[i] = 8;
            }
            else if (marks[i] >= 60 && marks[i] < 70)
            {
                grades[i] = 7;
            }
            else if (marks[i] >= 50 && marks[i] < 60)
            {
                grades[i] = 6;
            }
            else if (marks[i] >= 40 && marks[i] < 50)
            {
                grades[i] = 5;
            }
            else if (marks[i] >= 30 && marks[i] < 40)
            {
                grades[i] = 4;
            }
            else if (marks[i] >= 20 && marks[i] < 30)
            {
                grades[i] = 3;
            }
            else if (marks[i] >= 10 && marks[i] < 20)
            {
                grades[i] = 2;
            }
            else if (marks[i] >= 0 && marks[i] < 10)
            {
                grades[i] = 1;
            }
        }
    }

    public void sgpa()
    {
        double sum = 0;
        System.out.println("\nName : " + name);
        System.out.println("USN : " + usn);
        int cr = creditssum(credits);
        for (int i = 0; i < 8; i++)
        {
            sum += (credits[i] * grades[i]);
        }
        System.out.println("SGPA is :" + sum / cr);
    }
}

public class Student
{
    public static void main(String[] args)
    {
        Example ex = new Example();
        ex.accept();
        ex.sgpa();
    }
}
