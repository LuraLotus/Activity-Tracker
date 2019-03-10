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
  	Node newNode = new Node();
  	newNode.link = null;
  	if(this.head == null){
  		this.head = current;
  	}
  	else
  	{
  		Node tail = this.head;
  		while(tail.link != null){
  			tail = tail.link;
  		}
  		tail.link = current;
  	}
  	this.size++;
  }
  //Deletes an activity (displays all added activities for the user to choose from)
  public void Delete()
  {
    Scanner input = new Scanner(System.in);
  	System.out.println("Select an activity to delete from the list (input the index): ");
    Display();
    Node dcurrent;
    dcurrent = head;
    int[] temp = new int[size];
    for(int i = 0; i < size; i++)
    {
      temp[i] = dcurrent.data;
      dcurrent.data = null;
      dcurrent = dcurrent.link;
    }
    int x = input.nextInt();
    if(x == temp.length - 1)
    {
      temp[x] = null;
    }
    else
    {
      for(int i = x; i < temp.length - 1; i++)
      {
        temp[i] = temp[i + 1];
      }
    }
    for(int i = 0; i < temp.length; i++)
    {
      this.Add(temp[i]);
    }
    this.size--;
    // String del = in.readLine();
  	// File SourceFile = new File(input);
    // Scanner input = new Scanner(SourceFile);
    // PrintWriter output = new PrintWriter(SourceFile);
    // while (input.hasNext())
  	// {
    //   String x = input.nextLine();
    //   String y = x.replaceAll(del, "");
    //   output.println(y);
    // }
    // input.close();
    // output.close();
    // System.out.println("Output: o" + input);
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
