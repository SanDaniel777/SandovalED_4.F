public class Cliente {
private int id;
private String nombre;
private String documentos;

public Cliente(int id, String nombre, String documentos){
    this.id=id;
    this.nombre=nombre;
    this.documentos=documentos;
}

public Cliente(){}

public int getId(){
    return id;
}
public String getNombre(){
    return nombre;
}
public String getDocumentos(){
    return documentos;
}

public void setId(int newId){
    this.id=newId;
}
public void setNombre(String newNombre){
    this.nombre=newNombre;
}
public void setDocumentos(String newDocumentos){
    this.documentos=newDocumentos;
}




}
