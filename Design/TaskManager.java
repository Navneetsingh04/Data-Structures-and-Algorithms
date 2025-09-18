/*
L.C: 3408. Design Task Manager

There is a task management system that allows users to manage their tasks, each associated with a priority. The system should efficiently handle adding, modifying, executing, and removing tasks.

Implement the TaskManager class:
TaskManager(vector<vector<int>>& tasks) initializes the task manager with a list of user-task-priority triples. Each element in the input list is of the form [userId, taskId, priority], which adds a task to the specified user with the given priority.

void add(int userId, int taskId, int priority) adds a task with the specified taskId and priority to the user with userId. It is guaranteed that taskId does not exist in the system.

void edit(int taskId, int newPriority) updates the priority of the existing taskId to newPriority. It is guaranteed that taskId exists in the system.

void rmv(int taskId) removes the task identified by taskId from the system. It is guaranteed that taskId exists in the system.

int execTop() executes the task with the highest priority across all users. If there are multiple tasks with the same highest priority, execute the one with the highest taskId. After executing, the taskId is removed from the system. Return the userId associated with the executed task. If no tasks are available, return -1.

Note that a user may be assigned multiple tasks.

Example 1:
Input:
["TaskManager", "add", "edit", "execTop", "rmv", "add", "execTop"]
[[[[1, 101, 10], [2, 102, 20], [3, 103, 15]]], [4, 104, 5], [102, 8], [], [101], [5, 105, 15], []]

Output:
[null, null, null, 3, null, null, 5]
Explanation
TaskManager taskManager = new TaskManager([[1, 101, 10], [2, 102, 20], [3, 103, 15]]); // Initializes with three tasks for Users 1, 2, and 3.
taskManager.add(4, 104, 5); // Adds task 104 with priority 5 for User 4.
taskManager.edit(102, 8); // Updates priority of task 102 to 8.
taskManager.execTop(); // return 3. Executes task 103 for User 3.
taskManager.rmv(101); // Removes task 101 from the system.
taskManager.add(5, 105, 15); // Adds task 105 with priority 15 for User 5.
taskManager.execTop(); // return 5. Executes task 105 for User 5.
 
Constraints:
1 <= tasks.length <= 105
0 <= userId <= 105
0 <= taskId <= 105
0 <= priority <= 109
0 <= newPriority <= 109
At most 2 * 10^5 calls will be made in total to add, edit, rmv, and execTop methods.
The input is generated such that taskId will be valid. 
*/
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TaskManager{
    private class Pair{
        int user, task, prio;
        Pair(int user, int task, int prio){
            this.task = task;
            this.prio = prio;
            this.user = user;
        }
    }
    private static Map<Integer, Pair> taskMap = new HashMap<>();
    private PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> 
        a.prio != b.prio ? b.prio - a.prio : b.task - a.task
    );

    public TaskManager(List<List<Integer>> tasks){
        for (List<Integer> t : tasks) {
            int userId = t.get(0);
            int taskId = t.get(1);
            int prio = t.get(2);
            Pair task = new Pair(userId, taskId, prio);
            taskMap.put(taskId, task);
            pq.offer(task);
        }
    }

    public void add(int userId, int taskId, int priority){
        Pair task = new Pair(userId, taskId, priority);
        taskMap.put(taskId, task);
        pq.offer(task);
    }

    public void edit(int taskId, int newPriority){
        Pair old = taskMap.get(taskId);
        Pair update = new Pair(old.user,taskId,newPriority);
        taskMap.put(taskId,update);
        pq.offer(update);
    }

    public void rmv(int taskId) {
        taskMap.remove(taskId);
    }

    public int execTop() {
        while (!pq.isEmpty()) {
            Pair top = pq.poll();
            if (taskMap.containsKey(top.task) && taskMap.get(top.task) == top) {
                taskMap.remove(top.task);
                return top.user;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
         List<List<Integer>> tasks = Arrays.asList(
            Arrays.asList(1, 101, 10),
            Arrays.asList(2, 102, 20),
            Arrays.asList(3, 103, 15)
        );

        TaskManager obj = new TaskManager(tasks);
        obj.add(4, 104, 5);
        obj.edit(102, 8);
        System.out.println(obj.execTop()); 
        obj.rmv(101);
        obj.add(5, 105, 15);
        System.out.println(obj.execTop()); 
    }
}