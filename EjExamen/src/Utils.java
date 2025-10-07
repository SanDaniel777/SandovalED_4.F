import java.util.ArrayList;
import java.util.List;

public class Utils {

    List<Student>students;
    List<Student>reverseList=new ArrayList<>();

    Utils(List<Student>students){
        this.students=students;
    }

    public List<Student> reverse(List<Student>students, int index){
        if(index==0){
            this.reverseList.add(students.get(index));
            return students;
        }
        this.reverseList.add(students.get(index));
        reverse(students,index-1);

        return this.reverseList;
    }

}

//otra forma de darle la vuelta
    // public List<Student> reverse(List<Student>students){
    //     if(students.isEmpty()){
    //         return students;
    //     }
    //     Student student=students.get(0);
    //     students.remove(0);
    //     reverse(students);
    //     this.reverseList.add(student);

    //     return this.reverseList;
    // }
