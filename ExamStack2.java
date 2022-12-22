import java.util.*;

//Generic I/F을 이용해서 Deque의 견고함 확보
interface IStack<E>
{
	public boolean push(E item);
	public E pop();
}

class MyStack<E> implements IStack<E>
{
	private Deque<E> deq;
	
	public MyStack()
	{
		
	}
	
	public MyStack(Deque<E> deq)
	{
		this.deq = deq;
	}
	
	@Override
	public boolean push(E item) 
	{
		return deq.offerFirst(item);
	}

	@Override
	public E pop() 
	{
		return deq.pollFirst();
	}
	
}

public class ExamStack2 {
	public static void main(String[] args) {
		// 1. MyStack 객체를 만든다.
		Deque<String> deq = new LinkedList<>();
		// 2. push()를 이용해서 5개정도의 데이터를 넣어보자.
		deq.push("a");
		deq.push("b");
		deq.push("c");
		deq.push("d");
		deq.push("e");
		
		System.out.println(deq);
		
		// 3. pop()을 이용해서 데이터 출력
		deq.pop();
		System.out.println(deq);
		
	}
}
