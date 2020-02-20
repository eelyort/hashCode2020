public class Book implements Comparable<Book>
{
	int bookID;
	int bookValue;
	public Book()
	{
		bookID = 0;
		bookValue = 0;
	}
	public Book(int id, int val)
	{
		bookID = id;
		bookValue = val;
	}
	public int compareTo(Book bk)
	{
		if(bookValue>bk.getValue())
		{
			return 1;
		}
		else if(bookValue==bk.getValue())
		{
			return 0;
		}
		else if(bookValue<bk.getValue())
		{
			return -1;
		}
	}
	public int getID()
	{
		return bookID;
	}
	public int getValue()
	{
		return bookValue;
	}
}
