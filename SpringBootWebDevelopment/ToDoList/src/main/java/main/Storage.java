package main;

import main.model.Task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private static Map<Integer, Task> tasks = new HashMap<>();
    private static int currentId = 1;

    public static synchronized Task getTask(int taskId) {
        if (tasks.containsKey(taskId)) {
            return tasks.get(taskId);
        }
        return null;
    }

    public static synchronized List<Task> getAllTasks() {
        return new ArrayList<>(tasks.values());
    }

    public static synchronized int addTask(Task task) {
        int id = currentId++;
        task.setId(id);
        tasks.put(id, task);
        return id;
    }

    public static synchronized void updateTask(int taskId, Task updatedTask) {
        tasks.replace(taskId, updatedTask);
    }

    public static synchronized void deleteTasks() {
        tasks.clear();
    }

    public static synchronized void deleteTask(int taskId) {
        if(tasks.containsKey(taskId)) {
            tasks.remove(taskId);
        }
    }
}
