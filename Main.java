import java.io.*;
import java.util.*;
public class Main {
public static void Main(String[] args) throws IOException {
    if (args.length !=1) {
        System.out.println("Usage:Main Source-codeFileName");
			System.exit(0);
    }
File file = new File(args[0]);
if (!file.exists()) {
	System.out.println("The file " + args[0] + " does not exist!");
	System.exit(1);
	}
Stack<Character> symbols = new Stack<>();
try (Scanner input = new Scanner(file);) { 
	while (input.hasNext()) {
	    String line = input.nextLine();
		for (int i = 0; i < line.length(); i++) {
			char ch = line.charAt(i);
			if (ch == '(' || ch == '{' || ch == '[') {
			symbols.push(ch);
            }
			else if (ch == ')' || ch == '}' || ch == ']') {
				processSymbols(symbols, ch);
			}
		}
	}
}
System.out.println("This code " + (symbols.isEmpty() ? "has" : "does not have") + " correct pairs.");	
	}
private static void processSymbols(Stack<Character> stack, Character ch) {
	if ((stack.peek() == '(' && ch == ')') || (stack.peek() == '[' && ch == ']') || (stack.peek() == '{' && ch == '}')) {
			stack.pop();	
		    else if ((stack.peek() != '(' && ch == ')') || (stack.peek() != '[' && ch == ']') || (stack.peek() != '{' && ch == '}')) {
			    System.out.println("The code does not have the correct pairs.");
			    System.exit(1);
		}
	}
}
}