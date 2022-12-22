import java.util.*;
// Deque의 두가지 용도(Stack,Queue) 중 Stack 기능만을 사용하는 래핑클래스를 만들어서 사용해보자.
// Vector 같은 방법도 있긴 한데 그건 Non-thread 방식(구형 방식)이기 때문에 오류가 생길 수 있음 

//Generic I/F을 이용해서 Deque의 견고함 확보(변경 방지)
interface IStack<E>
{
	public boolean push(E item);
	public E pop();
}

// 별도의 class로 감싸주어 리더빌리티를 향상
// == 래핑클래스
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
		// IStack<String> deq = new MyStack<>(new ArrayDeque<String>());
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
