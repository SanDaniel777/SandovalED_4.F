import java.util.ArrayDeque;
import java.util.Queue;


public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Banco de Documentos");

        Queue<Cliente>fila=new ArrayDeque<>();

        Cliente c1 = new Cliente(1,"Pepe");
        c1.agregarDocumentos("Doc 1 de pepe");
        c1.agregarDocumentos("Doc 2 de pepe");

        Cliente c2 = new Cliente(2, "Maria");
        c2.agregarDocumentos("Doc 1 de maria");
        c2.agregarDocumentos("Doc 2 de maria");

        Cliente c3 = new Cliente(3, "Jose");
        c3.agregarDocumentos("Doc 1 de Jose");
        c3.agregarDocumentos("Doc 2 de Jose");

        fila.offer(c1);
        fila.offer(c2);
        fila.offer(c3);

        while(!fila.isEmpty()){
            Cliente clienteActual =fila.poll();
            System.out.println("Atendiendo al cliente: "+clienteActual.nombre);
            clienteActual.atender();

             System.out.print("Cola restante: [");
            boolean primero = true;
            for (Cliente c : fila) {
                if (!primero) System.out.print(", ");
                System.out.print(c.nombre);
                primero = false;
            }
            System.out.println("]");
        }
    }
}
