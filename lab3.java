import java.util.Scanner;

class Book
{
    String name, author;
    double price;
    int num_pages;

    public Book(String name, String author, double price, int num_pages)
    {
        this.name = name;
        this.author = author;
        this.price = price;
        this.num_pages = num_pages;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setAuthor(String author)
    {
        this.author = author;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public void setNumPages(int num_pages)
    {
        this.num_pages = num_pages;
    }

    public String getName()
    {
        return this.name;
    }

    public String getAuthor()
    {
        return this.author;
    }

    public double getPrice()
    {
        return this.price;
    }

    public int getNumPages()
    {
        return this.num_pages;
    }

    public void display()
    {
        System.out.println("Book Name: " + name);
        System.out.println("Author: " + author);
        System.out.println("Price: " + price);
        System.out.println("Number of Pages: " + num_pages);
    }

    public String toString()
    {
        return "Book Name: " + name + "\nAuthor: " + author + 
               "\nPrice: " + price + "\nNumber of Pages: " + num_pages + "\n";
    }
}

public class Demo
{
    public static void main(String args[])
    {
        int n;
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of books : ");
        n = sc.nextInt();
        sc.nextLine(); // Consume newline

        Book books[] = new Book[n]; // Creating array of n books

        for (int i = 0; i < n; i++)
        {
            System.out.println("\nEnter details of book " + (i + 1) + ":");
            System.out.print("Name : ");
            String name = sc.nextLine();
            System.out.print("Author name : ");
            String author = sc.nextLine();
            System.out.print("Price : ");
            double price = sc.nextDouble();
            System.out.print("No. of Pages : ");
            int num_pages = sc.nextInt();
            sc.nextLine(); // Consume newline

            books[i] = new Book(name, author, price, num_pages);
        }

        for (int i = 0; i < n; i++)
        {
            System.out.println("\nThe book details are : ");
            books[i].display();
            System.out.println("\nDetails using overriding toString()");
            System.out.println(books[i]);
        }
    }
}
