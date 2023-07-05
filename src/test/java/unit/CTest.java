package unit;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

class CTest {
    @Test
    @DisplayName("mock单例及其调用方法")
    void should_return_mock_when_mock_single_instance() {
        // mock静态方法因为要释放，所以spy必须放在mock静态方法之前，否则会有空指针
        C mockc = Mockito.spy(C.getInstance());
        // Mockito mock静态方法必须释放，否则会影响后续的mock
        try (MockedStatic<C> cMockedStatic = Mockito.mockStatic(C.class)) {
            Mockito.when(C.getInstance()).thenReturn(mockc);
            Mockito.when(mockc.funcC()).thenReturn("cMock");
            Assertions.assertEquals("cMock", C.getInstance().funcC());
        }
    }
}