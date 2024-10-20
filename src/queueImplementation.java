    import java.util.Stack;

    public class queueImplementation {
        public static void main(String[] args) {

            queue queue= new queue();
            // Enqueue elements
            queue.push(1);
            queue.push(2);
            queue.push(3);

            // Dequeue and print elements
            System.out.println(queue.peek()); // Output: 1
            System.out.println(queue.pop()); // Output: 1
            System.out.println(queue.peek()); // Output: 2
            System.out.println(queue.pop()); // Output: 2
            System.out.println(queue.peek()); // Output: 3
            System.out.println(queue.pop()); // Output: 3

            // Check if queue is empty
            System.out.println(queue.isEmpty()); // Output: true
        }

        public static class queue{
            private Stack<Integer> stack1;
            private Stack<Integer> stack2;
            public queue(){
                stack1 = new Stack<>();
                stack2 = new Stack<>();
            }

            public void push(int val){
                stack1.push(val);
            }

            public int peek(){
                if(stack2.isEmpty()){
                    while(!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                }
                return stack2.peek();
            }

            public int pop(){
                if(stack2.isEmpty()){
                    while(!stack1.isEmpty()){
                        stack2.push(stack1.pop());
                    }
                }
                return stack2.pop();
            }

            public boolean isEmpty(){
                return stack1.isEmpty() && stack2.isEmpty();
            }
        }
    }
