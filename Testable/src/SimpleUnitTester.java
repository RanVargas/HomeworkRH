import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class SimpleUnitTester {

    public int execute(Class clazz) throws Exception {
        int failedCount = 0;

        // your code
        ArrayList<Method> methods = new ArrayList<>();
        var inst = clazz.newInstance();
        Constructor constructor = inst.getClass().getConstructor();
        for (Method m :
                clazz.getDeclaredMethods()) {
            if (m.getName().startsWith("test")){
                if ( m.getReturnType() == boolean.class){
                    methods.add(m);
                }
            }
        }
        for (Method m :
                methods) {
            boolean val = (boolean) m.invoke(clazz);
            if (!val){
                failedCount++;
            }
        }
        return failedCount;
    }

}