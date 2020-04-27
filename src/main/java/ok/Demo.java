package ok;

import org.springframework.util.FileCopyUtils;
import org.springframework.util.ResourceUtils;

import java.io.FileNotFoundException;

public class Demo {

    public static void main(String[] args) throws FileNotFoundException {
        ResourceUtils.getFile("demo");
        System.out.println("demo");
    }

}
