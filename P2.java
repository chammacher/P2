import java.util.*;
import java.io.*;
import java_cup.runtime.*;  // defines Symbol

/**
 * This program is to be used to test the C-- scanner.
 * This version is set up to test all tokens, but more code is needed to test 
 * other aspects of the scanner (e.g., input that causes errors, character 
 * numbers, values associated with tokens)
 */
public class P2 {
    public static void main(String[] args) throws IOException {
                                           // exception may be thrown by yylex
        // test all tokens
        testAllTokens();
        CharNum.num = 1;
    
        // ADD CALLS TO OTHER TEST METHODS HERE
        testTokens();
        CharNum.num = 1;
    }

    /**
     * testTokens
     *
     * Open and read from file Tokens.in
     * For each token read, write the corresponding string and line number and char number to Tokens.out
     * If the input file contains all tokens, one per line, we can verify
     * correctness of the scanner by comparing the expected and output files
     * (e.g., using a 'diff' command).
     */
    private static void testTokens() throws IOException {
        // open input and output files
        FileReader inFile = null;
        PrintWriter outFile = null;
        try {
            inFile = new FileReader("Tokens.in");
            outFile = new PrintWriter(new FileWriter("Tokens.out"));
        } catch (FileNotFoundException ex) {
            System.err.println("File Tokens.in not found.");
            System.exit(-1);
        } catch (IOException ex) {
            System.err.println("Tokens.out cannot be opened.");
            System.exit(-1);
        }

        // create and call the scanner
        Yylex scanner = new Yylex(inFile);
        Symbol token = scanner.next_token();
        int lineCount = 0;
        while (token.sym != sym.EOF) {
            switch (token.sym) {
                case sym.BOOL:
                    outFile.println("bool CharNum: " + CharNum.num + " LineNum: " + linenum);
                    break;
                case sym.INT:
                    outFile.println("int CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.VOID:
                    outFile.println("void CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.TRUE:
                    outFile.println("true CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.FALSE:
                    outFile.println("false CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.STRUCT:
                    outFile.println("struct CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.CIN:
                    outFile.println("cin CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.COUT:
                    outFile.println("cout CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.IF:
                    outFile.println("if CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.ELSE:
                    outFile.println("else CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.WHILE:
                    outFile.println("while CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.RETURN:
                    outFile.println("return CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.ID:
                    outFile.println(((IdTokenVal)token.value).idVal + " CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.INTLITERAL:
                    outFile.println(((IntLitTokenVal)token.value).intVal + " CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.STRINGLITERAL:
                    outFile.println(((StrLitTokenVal)token.value).strVal + " CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.LCURLY:
                    outFile.println("{ CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.RCURLY:
                    outFile.println("} CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.LPAREN:
                    outFile.println("( CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.RPAREN:
                    outFile.println(") CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.SEMICOLON:
                    outFile.println("; CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.COMMA:
                    outFile.println(", CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.DOT:
                    outFile.println(". CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.WRITE:
                    outFile.println("<< CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.READ:
                    outFile.println(">> CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.PLUSPLUS:
                    outFile.println("++ CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.MINUSMINUS:
                    outFile.println("-- CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.PLUS:
                    outFile.println("+ CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.MINUS:
                    outFile.println("- CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.TIMES:
                    outFile.println("* CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.DIVIDE:
                    outFile.println("/ CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.NOT:
                    outFile.println("! CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.AND:
                    outFile.println("&& CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.OR:
                    outFile.println("|| CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.EQUALS:
                    outFile.println("== CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.NOTEQUALS:
                    outFile.println("!= CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.LESS:
                    outFile.println("< CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.GREATER:
                    outFile.println("> CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.LESSEQ:
                    outFile.println("<= CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.GREATEREQ:
                    outFile.println(">= CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                case sym.ASSIGN:
                    outFile.println("= CharNum: " + CharNum.num + " LineNum: " + lineCount);
                    break;
                default:
                    outFile.println("UNKNOWN TOKEN");
            } // end switch

            token = scanner.next_token();
        } // end while
        outFile.close();
    }

    /**
     * testAllTokens
     *
     * Open and read from file allTokens.txt
     * For each token read, write the corresponding string to allTokens.out
     * If the input file contains all tokens, one per line, we can verify
     * correctness of the scanner by comparing the input and output files
     * (e.g., using a 'diff' command).
     */
    private static void testAllTokens() throws IOException {
        // open input and output files
        FileReader inFile = null;
        PrintWriter outFile = null;
        try {
            inFile = new FileReader("allTokens.in");
            outFile = new PrintWriter(new FileWriter("allTokens.out"));
        } catch (FileNotFoundException ex) {
            System.err.println("File allTokens.in not found.");
            System.exit(-1);
        } catch (IOException ex) {
            System.err.println("allTokens.out cannot be opened.");
            System.exit(-1);
        }

        // create and call the scanner
        Yylex scanner = new Yylex(inFile);
        Symbol token = scanner.next_token();
        while (token.sym != sym.EOF) {
            switch (token.sym) {
            case sym.BOOL:
                outFile.println("bool"); 
                break;
			case sym.INT:
                outFile.println("int");
                break;
            case sym.VOID:
                outFile.println("void");
                break;
            case sym.TRUE:
                outFile.println("true"); 
                break;
            case sym.FALSE:
                outFile.println("false"); 
                break;
            case sym.STRUCT:
                outFile.println("struct"); 
                break;
            case sym.CIN:
                outFile.println("cin"); 
                break;
            case sym.COUT:
                outFile.println("cout");
                break;				
            case sym.IF:
                outFile.println("if");
                break;
            case sym.ELSE:
                outFile.println("else");
                break;
            case sym.WHILE:
                outFile.println("while");
                break;
            case sym.RETURN:
                outFile.println("return");
                break;
            case sym.ID:
                outFile.println(((IdTokenVal)token.value).idVal);
                break;
            case sym.INTLITERAL:  
                outFile.println(((IntLitTokenVal)token.value).intVal);
                break;
            case sym.STRINGLITERAL: 
                outFile.println(((StrLitTokenVal)token.value).strVal);
                break;    
            case sym.LCURLY:
                outFile.println("{");
                break;
            case sym.RCURLY:
                outFile.println("}");
                break;
            case sym.LPAREN:
                outFile.println("(");
                break;
            case sym.RPAREN:
                outFile.println(")");
                break;
            case sym.SEMICOLON:
                outFile.println(";");
                break;
            case sym.COMMA:
                outFile.println(",");
                break;
            case sym.DOT:
                outFile.println(".");
                break;
            case sym.WRITE:
                outFile.println("<<");
                break;
            case sym.READ:
                outFile.println(">>");
                break;				
            case sym.PLUSPLUS:
                outFile.println("++");
                break;
            case sym.MINUSMINUS:
                outFile.println("--");
                break;	
            case sym.PLUS:
                outFile.println("+");
                break;
            case sym.MINUS:
                outFile.println("-");
                break;
            case sym.TIMES:
                outFile.println("*");
                break;
            case sym.DIVIDE:
                outFile.println("/");
                break;
            case sym.NOT:
                outFile.println("!");
                break;
            case sym.AND:
                outFile.println("&&");
                break;
            case sym.OR:
                outFile.println("||");
                break;
            case sym.EQUALS:
                outFile.println("==");
                break;
            case sym.NOTEQUALS:
                outFile.println("!=");
                break;
            case sym.LESS:
                outFile.println("<");
                break;
            case sym.GREATER:
                outFile.println(">");
                break;
            case sym.LESSEQ:
                outFile.println("<=");
                break;
            case sym.GREATEREQ:
                outFile.println(">=");
                break;
			case sym.ASSIGN:
                outFile.println("=");
                break;
			default:
				outFile.println("UNKNOWN TOKEN");
            } // end switch

            token = scanner.next_token();
        } // end while
        outFile.close();
    }
}
