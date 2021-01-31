package by.it.doNotTouch.bunkov.jd01_14;

import java.io.File;

class Helper {

    static String getPath(Class<?> cl, String fileName) {
        String property = System.getProperty("user.dir") + File.separator + "src" + File.separator;
        String name = cl.getName().replace(cl.getSimpleName(),"").replace('.',File.separatorChar);
        String path = property + name + fileName;
        return path;
    }
}
