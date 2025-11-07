import CustomList.SinglyLinkedList;
import CustomQueue.ArrayQueue;
import CustomStack.ArrayStack;
import Model.JobCustom;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
       
        Scanner sc = new Scanner(System.in);
        ArrayQueue<JobCustom> queue= new ArrayQueue<>();
        ArrayStack<JobCustom> stack = new ArrayStack<>();
        SinglyLinkedList list= new SinglyLinkedList();

        while(true){
            System.out.println("Ingresa el comando >");
            String cmd=sc.nextLine().toUpperCase();//esto vuelve la recoleccion de la consola a mayusculas
            
            if(cmd.equals("ADD")){
                System.out.println("Dame el Id: ");
                String idJob=sc.nextLine(); 
                JobCustom job=new JobCustom(idJob);
                queue.offer(job);

            }else if(cmd.equals("PROCESS")){
                System.out.println("Dame la cantidad a procesar: ");
                int num= sc.nextInt(); 
                sc.nextLine(); 
                int cont=0;

                while(!queue.isEmpty() && cont<num){
                    JobCustom job=  (JobCustom) queue.poll();
                    stack.push(job);
                    cont++;
                }

            }else if(cmd.equals("COMMIT")){
                while(!stack.isEmpty()){
                    list.add(stack.pop());
                }

            }else if(cmd.equals("ROLLBACK")){
                System.out.println("Dame la cantidad a revertir: ");
                int m = sc.nextInt();
                sc.nextLine(); 
                int revertidos = 0;

                while(!list.isEmpty() && revertidos < m){
                    JobCustom job = list.removeLast();
                    queue.offer(job);
                    revertidos++;
                }

            }else if(cmd.equals("PRINT")){
                printData(queue, stack,list);

            }else if(cmd.equals("END")){
                break;

            }else{
                System.out.println("Comando no reconocido");
            }
        }

    }

    public static void printData(ArrayQueue queue, ArrayStack stack, SinglyLinkedList list){
        System.out.println("Queue:");
        queue.print();
        System.out.println("Stack: ");
        stack.print();
        System.out.println("List: ");
        list.printList();
    }

}