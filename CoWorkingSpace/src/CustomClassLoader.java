import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class CustomClassLoader extends ClassLoader{
    private final String directory;

    public CustomClassLoader(String directory) {
        this.directory = directory;
    }
    @Override
    protected Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> loadedClass = findLoadedClass(name);
        if (loadedClass == null) {
            try {
                loadedClass = load(name);
            } catch (ClassNotFoundException e) {
                loadedClass = super.loadClass(name, false);
            }
        }
        if (resolve) {
            resolveClass(loadedClass);
        }
        return loadedClass;
    }

    private Class<?> load(String name) throws ClassNotFoundException {
        try {
            String filePath = directory + File.separator + name.replace('.', File.separatorChar) + ".class";
            byte[] classBytes = null;
            try (FileInputStream fis = new FileInputStream(filePath)) {
                classBytes = fis.readAllBytes();
            }
            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException("Unable to load class: " + name, e);
        }
    }
}




