
import java.lang.reflect.Proxy;
import java.util.concurrent.atomic.AtomicBoolean;


public class MyServiceTest {

    @Test
    public void testVerifyInteraction() {

        AtomicBoolean getDataCalled = new AtomicBoolean(false);

        ExternalApi mockApi = (ExternalApi) Proxy.newProxyInstance(
                ExternalApi.class.getClassLoader(),
                new Class<?>[] { ExternalApi.class },
                (proxy, method, args) -> {
                    if ("getData".equals(method.getName())) {
                        getDataCalled.set(true);
                    }
                    Class<?> returnType = method.getReturnType();
                    if (returnType == boolean.class) {
                        return false;
                    }
                    if (returnType == byte.class) {
                        return (byte) 0;
                    }
                    if (returnType == short.class) {
                        return (short) 0;
                    }
                    if (returnType == int.class) {
                        return 0;
                    }
                    if (returnType == long.class) {
                        return 0L;
                    }
                    if (returnType == char.class) {
                        return '\0';
                    }
                    if (returnType == float.class) {
                        return 0f;
                    }
                    if (returnType == double.class) {
                        return 0d;
                    }
                    return null;
                });

        // Create Service
        MyService service = new MyService(mockApi);

        // Call Method
        service.fetchData();

        // Verify Interaction
        assertTrue(getDataCalled.get());
    }

    private void assertTrue(boolean get) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}