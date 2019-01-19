package Queues;

import java.util.NoSuchElementException;

public class MyQueue<T> 
{
	private static class QueueNode<T>
	{
		private T data;
		private QueueNode<T> next;
		
		public QueueNode(T data)
		{
			this.data = data;
		}
	}
	
	private QueueNode<T> first;
	private QueueNode<T> last;
	
	public void add(T item)
	{
		QueueNode<T> node = new QueueNode<T>(item);
		if(last != null)
		{
			last.next = node;
		}
		last = node;
		if(first == null)
		{
			first = last;
		}
	}
	
	public T remove()
	{
		if(first == null) throw new NoSuchElementException();
		T data = first.data;
		first = first.next;
		if(first == null)
		{
			last = null;
		}
		return data;
	}

	public T peek()
	{
		if(first == null) throw new NoSuchElementException();

		return first.data;
	}

	public boolean isEmpty()
	{
		return first == last;
	}

	public static void main(String[] args) 
	{
		MyQueue<Integer> mq = new MyQueue<>();
		mq.add(13);
		mq.add(9);
		mq.add(1994);
		
		System.out.println(mq.peek());
		System.out.println(mq.remove());
		System.out.println(mq.peek());
		System.out.println(mq.isEmpty());
	}
}