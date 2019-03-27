package core;
import java.util.Stack;
public class OperatorPrecedenceParser {
	//http://www.montefiore.ulg.ac.be/~geurts/Cours/compil/2011/03-syntaxanalysis-3.pdf
    /**
	* Grammar is assumed to be correct. Upper case alphabets
	* indicate a non terminal and a lower case alphabet indicates
	* a terminal.
	**/
	private String grammar, targetString;
	private int[][] precedenceTable;
	/** 
	* The precedence table must contain values like so
	* 0 indicates equal precedence
	* 2 indicates greater precedence
	* 1 indicates lesser precedence
	* id must be in the 0th index
	* + must be in the first index
	* - must be in the second index
	* * must be in the third index
	* / must be in the fifth index
	**/
	private Stack<String> stack;
	private String tokens[];

	public static int EQUAL_PREC = 0;
	public static int GREATER_PREC = 2;
	public static int LESSER_PREC = 1;
	public OperatorPrecedenceParser(final String targetString, final String grammar, final int[][] precedenceTable){
		this.targetString = targetString;
		this.grammar = grammar;
		this.precedenceTable = precedenceTable;
		this.stack = new Stack();

	}


	public void exec(){
		this.stack.push("$");
		String current = this.nextToken(), xm="";
		this.initTokensArray();
		while(true){
			if(this.stack.peek().equals("$") && current.equals("$") )
				break;
			xm = this.stack.peek();


		}
	}

	private String reduce(String valToBeReduced){
		// finding terminal with  
	}

	private void initTokensArray(){
		this.tokens = this.targetString.split(" ");
	}

	private 
	public static void main(String arp[]){
		String targetString = "id + id * id";
		String grammar = "E+E|E*E|E+E|E-E|E|id";
		int[][] precedenceTable = {
			//id +  -  *  ^  /  (  )  $
			{ 0, 2, 2, 2, 2, 2, 1, 2, 2},// precedence of id wrt the others
			{ 1, 2, 2, 1, 1, 1, 1, 2, 2},// precedence of + wrt the others
			{ 1, 2, 2, 1, 1, 1, 1, 2, 2},// precedence of - wrt the others
			{ 1, 2, 2, 2, 1, 2, 1, 2, 2},// precedence of * wrt the others
		};
		OperatorPrecedenceParser p = new OperatorPrecedenceParser(targetString, grammar, precedenceTable);
		p.reduce();
	}
}
