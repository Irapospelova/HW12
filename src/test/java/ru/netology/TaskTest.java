package ru.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TaskTest {
    @Test
    public void findSimpleTask() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");
        {

            boolean actual = simpleTask.matches("родителям");

            Assertions.assertTrue(actual);
        }
    }

    @Test
    public void shouldNotFindTaskIfNoMatches() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        {
            boolean actual = simpleTask.matches("детям");

            Assertions.assertFalse(actual);
        }
    }

    @Test
    public void findMeeting() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        {

            boolean actual = meeting.matches("НетоБанк");

            Assertions.assertTrue(actual);
        }

    }

    @Test
    public void shouldNotFindMeetingIfNoMatches() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии приложения", "Приложение НетоБанка", "Во вторник после обеда");
        {

            boolean actual = meeting.matches("Сбербанк");

            Assertions.assertFalse(actual);
        }

    }

    @Test
    public void findEpic() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Хлеб");

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotFindEpicIfNoMatches() {


        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        boolean actual = epic.matches("Пиво");

        Assertions.assertFalse(actual);
    }
}