
import java.util.ArrayList;
import java.util.List;

public class App {
    public static void main(String[] args) throws Exception {
        double SalarioTotal = 0;
        System.out.println("Hola Worker!");

        List<Worker> workers= new ArrayList<>();
        workers.add(new Worker(1,"Laura", 3500));
        workers.add(new Worker(2,"Pepe", 1200));
        workers.add(new Worker(3,"Nick", 800));
        workers.add(new Worker(4,"Paul", 2500));
        workers.add(new Worker(5,"Walker", 920));
        workers.add(new Worker(6,"Diego", 200));

        for (Worker worker:workers){
            SalarioTotal =+ worker.getSueldo();
            SalarioTotal= SalarioTotal/6;
        }
        System.out.println("Promedio: " +SalarioTotal);

    }
}
