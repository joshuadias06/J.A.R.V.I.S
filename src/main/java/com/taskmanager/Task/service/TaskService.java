package com.taskmanager.Task.service;

import com.taskmanager.Task.model.Task;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TaskService {

    private final List<Task> tasks = new ArrayList<>();
    private final Stack<Task> history = new Stack<>();
    private final Queue<String> notifications = new LinkedList<>();
    private final Map<String, List<Task>> categorizeTasks = new HashMap<>();

    //(R)
    public List<Task> getAllTasks(){
        return tasks;
    }

    //(R)
    public Optional<Task> getTaskById(Long id){
        return tasks.stream().filter(t -> t.getId().equals(id)).findFirst();
    }

    //(C)
    public Task createTask(Task task){
        tasks.add(task);
        history.push(task);
        addNotification("Nova tarefa criada: " + task.getTitle());
        categorizeTask(task, "Geral");

        return task;
    }

    //(U)
    public Task updateTask(Long id, Task taskDetails){
        Task task = getTaskById(id).orElseThrow();
        history.push(new Task (task));
        task.setTitle(taskDetails.getTitle());
        task.setDescription(taskDetails.getDescription());
        task.setCompleted(taskDetails.isCompleted());
        addNotification("Tarefa atualizada: " + task.getTitle());

        return task;
    }

    //(D)
    public void deleteTask(Long id){
        Task task = getTaskById(id).orElseThrow();
        tasks.remove(task);
        history.push(task);
        addNotification("Tarefa removida: " + task.getTitle());
    }

    //
    public Task undoLastChange() {
        if (!history.isEmpty()) {
            Task lastTask = history.pop();
            tasks.removeIf(t -> t.getId().equals(lastTask.getId()));
            tasks.add(lastTask); // Restaura o estado anterior
            addNotification("Desfeita a última alteração na tarefa: " + lastTask.getTitle());
            return lastTask;
        }
        throw new IllegalStateException("Nenhuma alteração para desfazer");
    }

    private void categorizeTask(Task task, String category){
        categorizeTasks.computeIfAbsent(category, k -> new ArrayList<>()).add(task);
    }

    private void addNotification(String message){
        notifications.add(message);
    }

    public Queue<String> getNotifications() {
        return notifications;
    }

    public Map<String, List<Task>> getTasksByCategory() {
        return categorizeTasks;
    }
}