package ru.netology.taskmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SimpleTaskTest {

    @Test
    public void testGetTitle() {
        String title = "Convert ePub";
        int id = 12;
        SimpleTask simpleTask = new SimpleTask(id, title);
        Assertions.assertEquals(id, simpleTask.getId());
        Assertions.assertEquals(title, simpleTask.getTitle());
    }

    @Test
    public void testMatches() {
        //testing filled fields
        SimpleTask simpleTask = new SimpleTask(15, "Convert ePub");
        Assertions.assertTrue(simpleTask.matches("Pub"));
        Assertions.assertFalse(simpleTask.matches("aaaa"));
        Assertions.assertFalse(simpleTask.matches(""));
        Assertions.assertFalse(simpleTask.matches(null));
        //testing matches with null title
        SimpleTask simpleTask2 = new SimpleTask(11, null);
        Assertions.assertFalse(simpleTask2.matches("aaa"));
    }
}
