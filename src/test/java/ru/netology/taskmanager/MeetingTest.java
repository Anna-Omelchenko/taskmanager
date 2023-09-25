package ru.netology.taskmanager;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MeetingTest {
    @Test
    public void testGetTopicProjectStart() {
        int id = 1;
        String topic = "Production";
        String project = "New site";
        String start = "15/12/24";
        Meeting meeting = new Meeting(id, topic, project, start);
        Assertions.assertEquals(topic, meeting.getTopic());
        Assertions.assertEquals(project, meeting.getProject());
        Assertions.assertEquals(start, meeting.getStart());
    }

    @Test
    public void testMatches() {
        //testing filled fields
        Meeting meeting = new Meeting(5, "Delivery", "Bot", "12/12/25");
        Assertions.assertTrue(meeting.matches("Del"));
        Assertions.assertTrue(meeting.matches("Bot"));
        Assertions.assertFalse(meeting.matches("12/25"));
        Assertions.assertFalse(meeting.matches(""));
        Assertions.assertFalse(meeting.matches(null));
        //testing matches with null fields
        Meeting meeting2 = new Meeting(5, null, null, null);
        Assertions.assertFalse(meeting2.matches("12/25"));
    }
}
