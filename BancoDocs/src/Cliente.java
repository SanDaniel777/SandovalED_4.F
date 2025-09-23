import java.util.ArrayDeque;
import java.util.Deque;

public class Cliente {
int id;
String nombre;
Deque <String> documentos;

public Cliente(int id, String nombre){
    this.id=id;
    this.nombre=nombre;
    documentos=new ArrayDeque<>();
}

public Cliente(){}

public void agregarDocumentos(String documento){
documentos.push(documento);
}

public void atender(){
    while(!documentos.isEmpty()){
        System.out.println("Documento retirado: "+documentos.pop());
    }
}


}
