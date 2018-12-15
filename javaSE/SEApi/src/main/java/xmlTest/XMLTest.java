package xmlTest;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.net.URL;
import java.util.List;

class XMLTest {

    public static void main(String[] args) throws DocumentException {
        SAXReader reader = new SAXReader();
        URL url = XMLTest.class.getClassLoader().getResource("xmlTest/book.xml");
        Document document = reader.read(url);

        Element root = document.getRootElement();
        List<Element> elements = root.elements();

        Element thirdElement = elements.get(0);
        String name = thirdElement.element("name").getText();
        String price = thirdElement.element("price").getText();
        System.out.println(name + ": " + price);
    }
}
