
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


//Using Stream convert the Employee list of object into Map<Designation, Gender> with count of gender in each designation(manager,Dev,tester)?
public class HelloWorld {

    private int id;
    private String desg;
    private String gender;
    private long salary;

    public int getId() {
        return id;
    }

    public String getDesg() {
        return desg;
    }

    public String getGender() {
        return gender;
    }

    public long getSalary() {
        return salary;
    }

    public HelloWorld(int id, String desg, String gender, int salary) {
        this.id = id;
        this.desg = desg;
        this.gender = gender;
        this.salary = salary;
    }



    public static void main(String [] args){
        //sorting object array
        HelloWorld h1= new HelloWorld(10, "Manager", "F", 10000);
        HelloWorld h2= new HelloWorld(20, "Developer", "F", 20000);
        HelloWorld h3= new HelloWorld(5, "Developer", "M", 5000);
        HelloWorld h4= new HelloWorld(1, "Tester", "M", 50000);

        List<HelloWorld> list = new ArrayList<>();
        list.add(h1);
        list.add(h2);
        list.add(h3);
        list.add(h4);

//give list of desgn with count of M and F.

        Map<String, List<HelloWorld>> map =list.stream()
                                     .collect(Collectors.groupingBy(HelloWorld :: getDesg));

        map.forEach((key,value) -> System.out.println("key ="+key + "/value =" + value));

    }

}



