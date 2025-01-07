class DisplayBMS extends Thread
{
    public void run()
    {
        try
        {
            while (true)
            {
                System.out.println("BMS College of Engineering");
                Thread.sleep(10000);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

class DisplayCSE extends Thread
{
    public void run()
    {
        try
        {
            while (true)
            {
                System.out.println("CSE");
                Thread.sleep(2000);
            }
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}

public class Main
{
    public static void main(String[] args)
    {
        DisplayBMS thread1 = new DisplayBMS();
        DisplayCSE thread2 = new DisplayCSE();
        thread1.start();
        thread2.start();
    }
}
