import java.util.Stack;

class StockSpan {
    Stack<int[]> stack;

    public StockSpan() {
        stack = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek()[0] <= price) {
            span += stack.pop()[1];
        }
        stack.push(new int[]{price, span});
        return span;
    }

    public static void main(String[] args) {
        StockSpan stockSpan = new StockSpan();
        System.out.println(stockSpan.next(100)); // Output: 1
        System.out.println(stockSpan.next(80));  // Output: 1
        System.out.println(stockSpan.next(60));  // Output: 1
        System.out.println(stockSpan.next(70));  // Output: 2
        System.out.println(stockSpan.next(60));  // Output: 1
        System.out.println(stockSpan.next(75));  // Output: 4
        System.out.println(stockSpan.next(85));  // Output: 6
    }
}
