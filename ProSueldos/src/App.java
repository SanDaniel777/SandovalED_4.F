
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        double SalarioTotal = 0;
        System.out.println("Hola Worker!");

        List<Worker> workers= new ArrayList<>();
        workers.add(new Worker(1,"Laura", 3500));
        workers.add(new Worker(2,"Pepe", 1200));
        workers.add(new Worker(3,"Nick", 800.40));
        workers.add(new Worker(4,"Paul", 2500));
        workers.add(new Worker(5,"Walker", 920));
        workers.add(new Worker(6,"Diego", 200.99));

        for (Worker worker:workers){
            SalarioTotal += worker.getSueldo();
        }
         SalarioTotal= SalarioTotal/workers.size();
        System.out.println("Promedio de salario: " +SalarioTotal);

        for(int i = workers.size() - 1; i >= 0; i--){
            if (workers.get(i).getSueldo() < 1000) {
                workers.remove(i);
            }
        }
        System.out.println("\nLista actualizada:");
        for (Worker worker : workers) {
            System.out.println("ID: " + worker.getId() +
                               ", Nombre: " + worker.getNombre() +
                               ", Sueldo: " + worker.getSueldo());
    }
}
}