/*

Using Stream convert the Employee list of object into List<Id> with salary>20000 and sort in ascending order?

*/

public class FilterEmployee {

    public static void main(String [] args){

        Employee e1 = new Employee(1, "Rajat", 50000);
        Employee e2 = new Employee(1, "Rahul", 10000);
        Employee e3 = new Employee(1, "Salim", 40000);

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(e1);
        employeeList.add(e2);
        employeeList.add(e3);

        List<Integer> idList = employeeList.stream()
                                           .filter(e -> e.getSalary() > 20000)
                                           .sorted(Comparator.comparing(Employee::getName))
                                           .map(e -> e.id)
                                           .collect(Collectors.toList());
        
        for(Integer i : idList){
            System.out.println(i);
        }
    }
}

 class Employee{
    int id;
    String name;
    int salary;

    Employee(int id, String name, int salary){
        this.id= id;
        this.name = name;
        this.salary= salary;

    }

     public int getId() {
         return id;
     }

     public String getName() {
         return name;
     }

     public int getSalary() {
         return salary;
     }
 }

