package cpit305.fcit.kau.edu.sa;

import cpit305.fcit.kau.edu.sa.OutOfRangeException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

import org.junit.jupiter.api.function.Executable;



public class Lab2Test {
    @Test
    void testValidSquares() {
        assertEquals(0, SquareCalcApp.square(0));
        assertEquals(1, SquareCalcApp.square(1));
        assertEquals(10000, SquareCalcApp.square(100));
        assertEquals(25, SquareCalcApp.square(5));
    }

    @Test
    void testOutOfRangeNumbers() {
        Method method = SquareCalcApp.class.getMethod("square");
        Class<?>[] exceptionTypes = method.getExceptionTypes();

        boolean hasOutOfRangeException = false;

        for (Class<?> exceptionType : exceptionTypes) {
            if (exceptionType.equals(OutOfRangeException.class)) {
                hasOutOfRangeException = true;
            }
        }
        assertTrue(hasOutOfRangeException, "Method does not throw OutOfRangeException");
    }
    @Test
    void assertThrowsOutOfRangeException() {
        assertThrows(OutOfRangeException.class, () -> {
            SquareCalcApp.square(-10);
        });
    }

}
