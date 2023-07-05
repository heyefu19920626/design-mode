package unit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.lang.reflect.Field;

class ATest {
    @Test
    @DisplayName("mock方法中其余私有对象的方法调用")
    void test_other_obj_func() throws NoSuchFieldException, IllegalAccessException {
        // mock B的调用
        B mockB = Mockito.mock(B.class);
        Mockito.when(mockB.funcB()).thenReturn("3");
        // 将 mockB 对象注入到类 A 中
        A a = new A();
        Field b = a.getClass().getDeclaredField("b");
        b.setAccessible(true);
        b.set(a, mockB);
        // 调用类 A 的方法
        String result = a.funcA();
        Assertions.assertEquals("3", result);
    }

    @Test
    @DisplayName("mock方法中其余单例对象的方法调用")
    void test_other_single_obj_fuc() {
        C mockc = Mockito.spy(C.getInstance());
        try (MockedStatic<C> cMockedStatic = Mockito.mockStatic(C.class)) {
            Mockito.when(C.getInstance()).thenReturn(mockc);
            Mockito.when(mockc.funcC()).thenReturn("cMock");
            String result = new A().useSingle();
            Assertions.assertEquals("cMock", result);
        }
    }

    @Test
    @DisplayName("mock多个静态方法,并且静态方法中有互相调用")
    void test_static_contain_other_static_func() {
        C mockc = Mockito.spy(C.getInstance());
        A spyA = Mockito.spy(A.getInstance());
        try (MockedStatic<C> cMockedStatic = Mockito.mockStatic(C.class);
             MockedStatic<A> aMockedStatic = Mockito.mockStatic(A.class)) {
            cMockedStatic.when(C::getInstance).thenReturn(mockc);
            Mockito.when(mockc.funcC()).thenReturn("cMock");

            aMockedStatic.when(A::getInstance).thenReturn(spyA);
            Mockito.when(spyA.useCAddA()).thenReturn("amock");

            Assertions.assertEquals("amock", A.getInstance().useCAddA());
        }
    }
}