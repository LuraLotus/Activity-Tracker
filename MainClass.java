/**
 * Name:    Eann Lao, Deborah Rizon, Jan Webert Fabria, Niznik Alamban
 * Section: A
**/

import java.util.Scanner;

class MainCLass
{
  public static void main(String[] args)
  {
    Queue q = new Queue();
    int c = 0;
    System.out.print("Current Activity: ");
    if(Queue.current == null)
    {
      System.out.println("None");
    }
    else
    {
      System.out.println(Queue.current);
    }
    System.out.println("What would you like to do?");
    System.out.println("0 - Exit");
    System.out.println("1 - Next Activity");
    System.out.println("2 - New Activity");
    System.out.println("3 - Delete Activity");
    System.out.println("4 - Reorder Activity");
    System.out.print("Input: ");
    Scanner input = new Scanner(System.in);
    c = input.nextInt();
    switch(c)
    {
      case 0: Exit();
      case 1: q.Next();
      case 2: System.out.println("Enter activity to add: ");
              q.Add(input.nextLine());
      case 3: System.out.println("Which activity would you like to remove?");
              q.Display();
              System.out.print("Input: ");
              q.Delete(input.nextInt());
      case 4:
    }
  }
}
