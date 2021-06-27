import java.util.Stack;

public class Resolucion {

    public static Double solucion(String expresion) {
        Stack<Double> stack = new Stack<>();
        StringBuilder exp = new StringBuilder(expresion);
        exp.reverse();

        for (int i = 0; i < exp.length(); i++) {
            char car = exp.charAt(i);
            //Se evalua si es operador
            if (ExpressionParser.jerarquia(car) > 0) {
                double op1 = stack.pop();                
                double op2 = stack.pop();
                double aux = operacion(op1, op2, car);
                stack.push(aux);                
            }
            else{
                stack.push((double) (car - '0'));
            }
        }
        double resul = stack.pop();
        return resul;
    }

    public static Double operacion(double op1, double op2, char operador){
        switch (operador) {
            case '+':
                return op1 + op2; 
            case '-':
                return op1 - op2;
            case '*':
                return op1 * op2;
            case '/':
                return op1 / op2;     
        }
        return 0.0;
    }
}
