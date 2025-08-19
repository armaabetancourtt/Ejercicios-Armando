package programas-19agosto;

/**
 *
 * @author Armando Betancourt Esparza
 */
public class Main {
    public static void main(String[] args) {
        try {
            //   Stack 
            System.out.println("\nNUMEROS BINARIOS :)");
            int numero = 42;
            System.out.println("Número decimal: " + numero);

            Stack<Integer> pila = new Stack<>();

            int n = numero;
            while (n > 0) {
                int residuo = n % 2;
                pila.push(residuo);
                n = n / 2;
            }

            System.out.print("Número binario: ");
            while (!pila.isEmpty()) {
                System.out.print(pila.pop());
            }
            System.out.println();

            // Queue
            Queue<String> colaImpresion = new Queue<>();

            colaImpresion.push("Tarea-EstructuraDatos.pdf");
            colaImpresion.push("CasosDePrueba.docx");
            colaImpresion.push("Hero-1.png");

            System.out.println("\nIMPRESORA :)");
            System.out.println("Colas de impresión:");
            while (!colaImpresion.isEmpty()) {
                System.out.println("Imprimiendo: " + colaImpresion.pop());
            }

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
