package by.ITMan.homework.Lesson4;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Task1Test {

    @Test
    void isCoolNotebookExists() {
        int[][] notebooks = {
                {1, 2},
                {2, 1}
        };

        boolean result = Task1.isCoolNotebookExists(notebooks);
        assertTrue(result);
    }
}