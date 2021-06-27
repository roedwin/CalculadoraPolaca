import java.util.Stack;

public class ExpressionParser {
    static StringBuilder conversionPre(String expresion){
        StringBuilder exPrefija = new StringBuilder();
        StringBuilder exInfija = new StringBuilder(expresion);
        exInfija.reverse();
        Stack<Character> stack = new Stack<Character>();
        char[] carExp = new String(exInfija).toCharArray();

        //Ordenando Parentesis
        for(int i = 0; i < carExp.length; i++){
            if(carExp[i] == '('){
                carExp[i] = ')';
                i++;
            }
            else if (carExp[i] == ')'){
                carExp[i] = '(';
                i++;
            }
        }

        //Llenando el stack
        for(int i = 0; i < carExp.length; i++){
            char car = carExp[i];

            //operador
            if(jerarquia(car) > 0){
                while(stack.isEmpty() == false && jerarquia(stack.peek()) >= jerarquia(car)){
                    exPrefija.append(stack.pop());
                }
                stack.push(car);
            }
            // Parentesis de cierre
            else if(car == ')'){
                char aux = stack.pop();
                while(aux != '('){
                    exPrefija.append(aux);
                    aux = stack.pop();
                }
            }
            //Parentesis de apertura
            else if (car == '('){
                stack.push(car);
            }
            //Sea un numero
            else{
                exPrefija.append(car);
            }
        }
        //Vacias el Satck y meter elemento a exPrefija
        for (int i = 0; i <= stack.size(); i++) {
            exPrefija.append(stack.pop());
        }
        return exPrefija.reverse();
    }

    static int jerarquia(char car) {
        switch(car){
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }
}