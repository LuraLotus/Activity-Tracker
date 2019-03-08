public class Queue
{
  public Node head;
  public Node tail;
  public int size;
  public Node current;

  public Queue()
  {
    this.head = null;
    this.tail = null;
    this.size = 0;
  }
  //Adds an activity
  public void Add(String input)
  {

  }
  //Deletes an activity (displays all added activities for the user to choose from)
  public void Delete()
  {
	System.out.println("Select an activity to delete from the list: ");
        String del = in.readLine();
		File SourceFile = new File(input);
        Scanner input = new Scanner(SourceFile);
        PrintWriter output = new PrintWriter(SourceFile);
        while (input.hasNext())
		{ 
            String x = input.nextLine();
            String y = x.replaceAll(del, "");
            output.println(y);
        }
        input.close();
        output.close();
        System.out.println("Output: o" + input);
  }
  }
  //Goes to next activity
  public void Next()
  {
    current.data = null;
    current = current.link;
  }
  public void Display()
  {
    Node discurrent;
    for(int i = 0; discurrent.data != null; i++)
    {
      System.out.println(i + " - " + discurrent.data);
      discurrent = discurrent.link;
    }
  }
  public void Reorder()
  {
    int[] array = array (size);
	    System.out.println( "input" );
  }
}
