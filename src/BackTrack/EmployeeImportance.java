package BackTrack;

import java.util.*;

/**
 * @author EvanHsia
 * @ClassName EmployeeImportance.java
 * @Description No.690 Easy BFS
 * @createTime 2019-10-10- 17:22
 */
public class EmployeeImportance {
    public int getImportance(List<Employee> employees,int id){
        //通过id可以查到人
        Map<Integer,Employee> map=new HashMap<>();
        for (int i=0;i<employees.size();i++){
            map.put(employees.get(i).id,employees.get(i));
        }
        int res=0;
        Queue<Employee> q=new LinkedList<>();
        q.offer(map.get(id));
        while (!q.isEmpty()){
            Employee employee=q.poll();
            res+=employee.importance;
            List<Integer> subordinates=employee.subordinates;
            subordinates.forEach(nextid->{
                q.offer(map.get(nextid));
            });
        }
        return res;
    }

    //dfs
    Map<Integer,Employee> emap;
    public int getImportance2(List<Employee> employees,int id){
        emap=new HashMap<>();
        employees.forEach(employee -> emap.put(employee.id,employee));
        return dfs(id);
    }

    private int dfs(int id){
        Employee employee=emap.get(id);
        int res=employee.importance;
        for (int nextid:employee.subordinates){
            res+=dfs(emap.get(nextid).id);
        }
        return res;
    }
    class Employee {
        // It's the unique id of each node;
        // unique id of this employee
        public int id;
        // the importance value of this employee
        public int importance;
        // the id of direct subordinates
        public List<Integer> subordinates;
    }
}
