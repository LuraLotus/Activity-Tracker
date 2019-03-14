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
    System.out.println("Activity has been added.");
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
      String[] temp = new String[size];
      /**
       * Moves the queue into an array.
       */
      for(int i = 0; i < size; i++)
      {
        temp[i] = head.data;
        head = head.link;
      }
      head = null;
      System.out.println("----------------------------------------------------------------------");
      System.out.print("Which activity would you like to move? ");
      int choice = input.nextInt();
      String choicedata = temp[choice];
      System.out.print("Where would you like to move it? ");
      int newloc = input.nextInt();
      if(choice > newloc)
      {
        for(int i = choice; i > newloc; i--)
        {
          temp[i] = temp[i - 1];
        }
        temp[newloc] = choicedata;
      }
      else
      {
        for(int i = choice; i < newloc; i++)
        {
          temp[i] = temp[i + 1];
        }
        temp[newloc] = choicedata;
      }
      /**
       * Moves the data of the array back into a queue.
       */
      for(int i = 0; i < temp.length; i++)
      {
        Add(temp[i]);
      }
      System.out.println("Activities reordered.");
    }
    else
    {
      System.out.println("There are no activities.");
    }
  }
}
