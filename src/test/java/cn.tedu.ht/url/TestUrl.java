package cn.tedu.ht.url;

import org.junit.Test;

import java.io.File;
import java.net.URL;
import java.util.Objects;

public class TestUrl {

    @Test
    public void test01() {
        URL url = ClassLoader.getSystemClassLoader().getResource("jdbc.properties");
        File file = new File(Objects.requireNonNull(url).getPath());
        System.out.println("运行时路径" + file.getPath());
        File parentFile = new File(file.getParent());
        System.out.println("运行时根目录" + parentFile.getPath());
    }
}
