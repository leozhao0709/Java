package runtime;

import java.io.IOException;

class RuntimeTest {

    public static void main(String[] args) throws IOException {
        Runtime.getRuntime().exec("open .");
    }
}
