package ru.netology.taskmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void testSearchAll() {
        // Test search empty Todos
        Todos todos = new Todos();
        Assertions.assertArrayEquals(new Task[0], todos.search("aaa"));
        // Test search
        Task task1 = new SimpleTask(10, "Simple Task 10");
        Task task2 = new Epic(11, new String[]{"Task One", "Task Two", "Task Three"});
        Task task3 = new Meeting(12, "Team Retrospective", "Gosuslugi", "Sep 12 10:20");
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);
        Assertions.assertArrayEquals(new Task[]{task1, task2}, todos.search("Task"));
        Assertions.assertArrayEquals(new Task[]{task3}, todos.search("Gosuslugi"));
        Assertions.assertArrayEquals(new Task[0], todos.search("Nalog"));
        Assertions.assertArrayEquals(new Task[]{task1, task2, task3}, todos.search("T"));
    }

    @Test
    public void testFindAll() {
        Todos todos = new Todos();
        // Test empty
        Assertions.assertArrayEquals(new Task[0], todos.findAll());
        // Test non-empty
        Task task1 = new SimpleTask(10, "Simple Task 10");
        Task task2 = new Epic(11, new String[]{"Task One", "Task Two", "Task Three"});
        Task task3 = new Meeting(12, "Team Retrospective", "Gosuslugi", "Sep 12 10:20");
        todos.add(task1);
        todos.add(task2);
        todos.add(task3);
        Assertions.assertArrayEquals(new Task[]{task1, task2, task3}, todos.findAll());
    }
}
