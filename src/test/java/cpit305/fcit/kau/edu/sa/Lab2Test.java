package cpit305.fcit.kau.edu.sa;

import cpit305.fcit.kau.edu.sa.OutOfRangeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Method;

public class Lab2Test {
    @Test
    void testValidSquares() throws OutOfRangeException {
        assertEquals(0, SquareCalcApp.square(0));
        assertEquals(1, SquareCalcApp.square(1));
        assertEquals(10000, SquareCalcApp.square(100));
        assertEquals(25, SquareCalcApp.square(5));
    }

    @Test
    void testOutOfRangeNumbers() {
        Method[] methods = SquareCalcApp.class.getDeclaredMethods();
        boolean hasOutOfRangeException = false;
        for (Method method : methods) {
            if (method.getName().equalsIgnoreCase("square")) {
                Class<?>[] exceptionTypes = method.getExceptionTypes();

                for (Class<?> exceptionType : exceptionTypes) {
                    if (exceptionType.equals(OutOfRangeException.class)) {
                        hasOutOfRangeException = true;
                    }
                }
                assertTrue(hasOutOfRangeException, "Method does not throw OutOfRangeException");
                return;
            }
        }
        fail("square method not found. Please make sure the method is called square and has the correct signature");
    }

    @Test
    void assertThrowsOutOfRangeException() {
        assertThrows(OutOfRangeException.class, () -> {
            SquareCalcApp.square(-10);
        });
    }

}
