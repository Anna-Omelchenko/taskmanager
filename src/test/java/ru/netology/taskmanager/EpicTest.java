package ru.netology.taskmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class EpicTest {

    @Test
    public void testGetSubtasks() {
        int id = 10;
        String[] subtasks = {"Generate XML", "Convert to JSON", "Convert to Excel"};
        Epic epic = new Epic(id, subtasks);
        Assertions.assertArrayEquals(subtasks, epic.getSubtasks());
    }

    @Test
    public void testMatches() {
        //testing filled fields
        Epic epic = new Epic(103, new String[] {"Generate XML", "Convert to JSON", "Convert to Excel"});
        Assertions.assertTrue(epic.matches("XML"));
        Assertions.assertFalse(epic.matches("xml"));
        Assertions.assertFalse(epic.matches(""));
        Assertions.assertFalse(epic.matches(null));
        //testing matches with null title
        Epic epic2 = new Epic(104, new String[0]);
        Assertions.assertFalse(epic2.matches("aaa"));
        Epic epic3 = new Epic(105, null);
        Assertions.assertFalse(epic3.matches("bbb"));
    }
}
