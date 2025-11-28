import java.util.HashSet;
import java.util.Set;

public class App {
    public static void main(String[] args) throws Exception {
        
        Set<String>set= new HashSet<>();
        set.add("Rojo");
        set.add("Verde");
        set.add("Azul");
        set.add("Amarillo");
        set.add("Rojo");//se omite por duplicidad

        System.out.println(set);//impresion

        boolean existRed=set.contains("Rojo");//existe x objeto
        System.out.println("Existe el rojo?"+existRed);

        set.remove("Verde");//eliminar elemento
        int tam=set.size();//obtener tamano

        for(String data: set){//recorrido estandar
            System.out.println("Data:"+data);
        }
        System.out.println("Tamano del conjunto"+ tam);
    }
}
