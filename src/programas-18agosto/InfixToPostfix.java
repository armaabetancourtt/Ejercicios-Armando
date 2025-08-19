package programas18agosto;

public class InfixToPostfix {
    
    // Método para verificar si un carácter es un operador
    private static boolean esOperador(char c) {
        return (c == '+' || c == '-' || c == '*' || c == '/' || c == '^');
    }

    // Método para asignar precedencia a los operadores
    private static int precedencia(char c) {
        switch (c) {
            case '+': 
            case '-': return 1;
            case '*': 
            case '/': return 2;
            case '^': return 3;
        }
        return -1;
    }

    // Método principal de conversión infijo -> postfijo
    public static String convertir(String expresion) {
        StringBuilder resultado = new StringBuilder();
        java.util.Stack<Character> pila = new java.util.Stack<>();

        for (int i = 0; i < expresion.length(); i++) {
            char c = expresion.charAt(i);

            // Si es un operando (letra o número)
            if (Character.isLetterOrDigit(c)) {
                resultado.append(c);
            }
            // Si es un paréntesis de apertura
            else if (c == '(') {
                pila.push(c);
            }
            // Si es un paréntesis de cierre
            else if (c == ')') {
                while (!pila.isEmpty() && pila.peek() != '(') {
                    resultado.append(pila.pop());
                }
                if (!pila.isEmpty() && pila.peek() != '(') {
                    return "Expresión inválida";
                } else {
                    pila.pop();
                }
            }
            // Si es un operador
            else if (esOperador(c)) {
                while (!pila.isEmpty() && precedencia(c) <= precedencia(pila.peek())) {
                    resultado.append(pila.pop());
                }
                pila.push(c);
            }
        }

        // Sacar los operadores restantes de la pila
        while (!pila.isEmpty()) {
            if (pila.peek() == '(') {
                return "Expresión inválida";
            }
            resultado.append(pila.pop());
        }

        return resultado.toString();
    }

    // Método main para probar
    public static void main(String[] args) {
        // Cambia esta expresión para probar otras
        String expresion = "A+(B*C)";
        System.out.println("Infijo: " + expresion);
        System.out.println("Postfijo: " + convertir(expresion));

        expresion = "(A+B)*C";
        System.out.println("\nInfijo: " + expresion);
        System.out.println("Postfijo: " + convertir(expresion));

        expresion = "A+B*C-(D/E^F)";
        System.out.println("\nInfijo: " + expresion);
        System.out.println("Postfijo: " + convertir(expresion));
    }
}
