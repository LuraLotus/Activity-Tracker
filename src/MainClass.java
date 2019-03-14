/**
 * Name:    Eann Lao, Deborah Rizon, Jan Webert Fabria, Niznik Alamban
 * Section: A
**/

/**
 * Title:       Tractivity (Activity Tracker)
 * Description: Keeps track of a user's activities.
**/

import java.util.Scanner;
import java.io.*;

public class MainClass
{
  public static void main(String[] args) throws IOException
  {
    Queue q = new Queue();
    Scanner in = new Scanner(new File("activities.txt"));
    PrintWriter out = null;
    /**
     * Reads the File line by line.
     */
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
      System.out.println();
      System.out.println("----------------------------------------------------------------------");
      System.out.print("Current Activity: ");
      /**
       * Displays the current activity(head of queue).
       */
      if(q.head == null)
      {
        System.out.println("None");
      }
      else
      {
        System.out.println(q.head.data);
      }
      System.out.println("----------------------------------------------------------------------");
      System.out.println("What would you like to do?");
      System.out.println("0 - Exit");
      System.out.println("1 - Next Activity");
      System.out.println("2 - New Activity");
      System.out.println("3 - Delete Activity");
      System.out.println("4 - Reorder Activity");
      System.out.println("5 - Display all activities");
      System.out.println("----------------------------------------------------------------------");
      System.out.print("Input: ");
      c = input.nextInt();
      switch(c)
      {
        case 0: bool = false;
                out = new PrintWriter("activities.txt");
                /**
                 * Writes all remaining activities to the file.
                 */
                while(q.head != null)
                {
                  out.println(q.head.data);
                  q.head = q.head.link;
                }
                out.close();
                break;
        case 1: q.Next();
                break;
        case 2: System.out.println("Enter activity to add: ");
                String addin = add.nextLine();
                q.Add(addin);
                break;
        case 3: q.Delete();
                break;
        case 4: System.out.println("----------------------------------------------------------------------");
                System.out.println("List of Activities: ");
                q.Reorder();
                break;
        case 5: System.out.println("----------------------------------------------------------------------");
                System.out.println("List of Activities: ");
                q.Display();
                break;
      }
    }
  }
}
