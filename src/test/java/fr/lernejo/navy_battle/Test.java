package fr.lernejo.navy_battle;

import fr.lernejo.Sample;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class Test {
    @org.junit.jupiter.api.Test
    void op_add() {
        int expected = 10;
        int actual = new Sample().op(Sample.Operation.ADD, 5, 5);
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void op_mult() {
        int expected = 20;
        int actual = new Sample().op(Sample.Operation.MULT, 5, 4);
        Assertions.assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void fact_0() {
        int expected = 1;
        int actual = new Sample().fact(0);
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void fact_5() {
        int expected = 120;
        int actual = new Sample().fact(5);
        Assertions.assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void fact_neg() {
        Exception exception = assertThrows(IllegalArgumentException.class, ()-> {
            new Sample().fact(-2);
        });
        Assertions.assertEquals("N should be positive", exception.getMessage());
    }
}
