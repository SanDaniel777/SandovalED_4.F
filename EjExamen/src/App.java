import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import java.util.Queue;

public class App {
    public static void main(String[] args) throws Exception {
       
       
        List<Student> students= new ArrayList<>();
        Queue<Student> fila= new ArrayDeque<>();
        Deque<Student> stack= new ArrayDeque<>();
        Student s1=new Student(1,"Student1","email1");
        Student s2=new Student(2,"Student2","email2");
        Student s3=new Student(3,"Student3","email3");

        students.add(s1);
        students.add(s2);
        students.add(s3);

            System.out.println("Lista og: "+students);

        Utils utils = new Utils(students);
        System.out.println(utils.reverse(students,students.size()-1));
        System.out.println("--------------------------------");

        for(Student student:utils.reverseList){
            fila.offer(student);
        }
        while(!fila.isEmpty()){
            Student s = fila.poll();
            System.out.println("En atencion: " +s);
            stack.push(s);
            if (fila.peek()==null) {
                System.out.println("No hay nadie en la fila");
                break;
            }
            System.out.println("Siguiente: "+ fila.peek());
        }
        System.out.println("En la cima del stack esta: ");
        System.out.println(stack.peek());
    }
}
