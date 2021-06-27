import java.util.Scanner;

public class NotacionPolaca {
    public static void main(String[] arg) {
      System.out.println("Ingrese su expresion: ");
      Scanner scan = new Scanner(System.in);
      String expresion = scan.nextLine();
      String prefija = ExpressionParser.conversionPre(expresion).toString();
      System.out.println("Expresion infija: " + expresion); 
      System.out.println("Expresion prefija: " + prefija); 
      System.out.println("Resultado: " + Resolucion.solucion(prefija)); 
      scan.close();
    }
}