/**
 * Name:    Eann Lao, Deborah Rizon, Jan Webert Fabria, Niznik Alamban
 * Section: A
**/

import java.util.Scanner;
import java.io.*;

class MainClass
{
  public static void main(String[] args) throws IOException
  {
    Queue q = new Queue();
    Scanner in = new Scanner(new File("activities.txt"));
    PrintWriter out = null;
    while(in.hasNextLine())
    {
      q.Add(in.nextLine());
    }

    Scanner input = new Scanner(System.in);
    Scanner add = new Scanner(System.in);
    int c = 0;
    boolean bool = true;
    while(bool == true)
    {
      System.out.print("Current Activity: ");
      if(q.head == null)
      {
        System.out.println("None");
      }
      else
      {
        System.out.println(q.head.data);
      }
      System.out.println("What would you like to do?");
      System.out.println("0 - Exit");
      System.out.println("1 - Next Activity");
      System.out.println("2 - New Activity");
      System.out.println("3 - Delete Activity");
      System.out.println("4 - Reorder Activity");
      System.out.println("5 - Display all activities");
      System.out.print("Input: ");
      c = input.nextInt();
      switch(c)
      {
        case 0: bool = false;
                break;
        case 1: q.Next();
                break;
        case 2: System.out.println("Enter activity to add: ");
                String addin = add.nextLine();
                q.Add(addin);
                break;
        case 3: q.Delete();
                break;
        case 4: System.out.println("List of Activities: ");
                q.Reorder();
                break;
        case 5: q.Display();
                break;
      }
    }
  }
}
