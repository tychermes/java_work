package kosa.data;

import java.util.LinkedList;
import java.util.Stack;

public class StackQueueExample {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<Integer>(); // 스택 자료구조. 후입선출.		
		LinkedList<Integer> queue = new LinkedList<Integer>(); // 큐 자료구조. 선입선출.
		
		stack.push(1);
		stack.push(2);
		stack.push(3);

		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		
		System.out.println("--- stack ---");
		while(!stack.isEmpty()) {
			System.out.println(stack.pop()); // 가장 나중에 넣은 데이터를 반환
		}
		
		System.out.println("--- queue ---");
		while(!queue.isEmpty()) {
			System.out.println(queue.poll()); // 가장 먼저 넣은 데이터를 반환
		}
		
	}

}
