import java.util.Scanner;

public class Queue
{
  public Node head;
  public Node tail;
  public int size;

  public Queue()
  {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }
  /**
   * Adds an activity.
   * @param input The new activity.
   */
  public void Add(String input)
  {
  	Node newNode = new Node();
    newNode.data = input;
  	if(head == null)
    {
      head = newNode;
      tail = newNode;
    }
    else
    {
      newNode.link = null;
      tail.link = newNode;
      tail = newNode;
    }
  	this.size++;
  }
  /**
   * Deletes an activity (displays all added activities for the user to choose from).
   */
  public void Delete()
  {
    Scanner input = new Scanner(System.in);
    if(head != null)
    {
      System.out.println("----------------------------------------------------------------------");
    	System.out.println("Select an activity to delete from the list (input the index): ");
      Display();
      System.out.println("----------------------------------------------------------------------");
      System.out.print("Input: ");
      int pos = input.nextInt();
      Node temp = head;
      if(pos == 0)
      {
        head = temp.link;
        this.size--;
        System.out.println("Activity has been deleted.");
      }
      else if(pos >= size)
      {
        System.out.println("Invalid input.");
        return;
      }
      else
      {
        for(int i = 0; temp != null && i < pos - 1; i++)
        {
          temp = temp.link;
        }
        Node del = temp.link.link;
        temp.link = del;
        this.size--;
        System.out.println("Activity has been deleted.");
      }
    }
    else
    {
      System.out.println("----------------------------------------------------------------------");
      System.out.println("There are no activities.");
    }
  }
  /**
   * Goes to next activity.
   */
  public void Next()
  {
    if(head == null)
    {
      System.out.println("----------------------------------------------------------------------");
      System.out.println("There are no more activites.");
    }
    else
    {
      head = head.link;
      this.size--;
    }
  }
  public void Display()
  {
    Node discurrent;
    discurrent = this.head;
    if(head != null)
    {
      for(int i = 0; discurrent != null; i++)
      {
        System.out.println(i + " - " + discurrent.data);
        discurrent = discurrent.link;
      }
    }
    else
    {
      System.out.println("There are no activities to display.");
    }
  }
  /**
   * Moves one activity into another position based on user input.
   */
  public void Reorder()
  {
    Scanner input = new Scanner(System.in);
    if(head != null)
    {
      Display();
      System.out.println("----------------------------------------------------------------------");
      System.out.print("Which activity would you like to move? ");
      int choice = input.nextInt();
      System.out.print("Where would you like to move it? ");
      int newloc = input.nextInt();
      if(choice == newloc || choice >= size || newloc >= size)
      {
        System.out.println("Invalid input.");
        return;
      }
      Node cNode = null;
      Node prevcNode = head;
      Node ncNode = null;
      Node prevncNode = head;
      if(newloc == 0)
      {
        ncNode = head;
        for(int i = 0; prevcNode != null && i < choice - 1; i++)
        {
          prevcNode = prevcNode.link;
        }
        cNode = prevcNode.link;
        if(choice == size - 1)
        {
          prevcNode.link = null;
          cNode.link = ncNode;
        }
        else
        {
          prevcNode.link = cNode.link;
          cNode.link = ncNode;
        }
        head = cNode;
      }
      else if(choice == 0)
      {
        cNode = head;
        for(int i = 0; prevncNode != null && i < newloc - 1; i++)
        {
          prevncNode = prevncNode.link;
        }
        ncNode = prevncNode.link;
        if(newloc == size - 1)
        {
          head = cNode.link;
          cNode.link = null;
          ncNode.link = cNode;
        }
        else
        {
          head = cNode.link;
          cNode.link = ncNode.link;
          ncNode.link = cNode;
        }
      }
      else
      {
        for(int i = 0; prevcNode != null && i < choice - 1; i++)
        {
          prevcNode = prevcNode.link;
        }
        cNode = prevcNode.link;
        for(int i = 0; prevncNode != null && i < newloc - 1; i++)
        {
          prevncNode = prevncNode.link;
        }
        ncNode = prevncNode.link;
        if(choice == newloc + 1)
        {
          prevncNode.link = cNode;
          ncNode.link = cNode.link;
          cNode.link = ncNode;
        }
        else if(newloc == choice + 1)
        {
          prevcNode.link = ncNode;
          cNode.link = ncNode.link;
          ncNode.link = cNode;
        }
        else
        {
          prevcNode.link = cNode.link;
          prevncNode.link = cNode;
          cNode.link = ncNode;
        }
      }
      System.out.println("Activities reordered.");
    }
    else
    {
      System.out.println("There are no activities.");
    }
  }
  public void Enter()
  {
    Scanner enter = new Scanner(System.in);
    System.out.println("Press enter to continue...");
    enter.nextLine();
  }
}
