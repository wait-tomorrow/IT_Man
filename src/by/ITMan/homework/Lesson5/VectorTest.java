package by.ITMan.homework.Lesson5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VectorTest {

    @Test
    void get() {
        Vector testVector = createVector();

        assertEquals("1", testVector.get(0));
    }

    Vector createVector(){
        Vector newVector = new Vector();

        newVector.add("1");
        newVector.add("2");
        newVector.add("3");
        newVector.add("4");
        newVector.add("5");

        return newVector;
    }

    @Test
    void set() {
        Vector newVector = new Vector();

        newVector.set(1, "999");

    }
}