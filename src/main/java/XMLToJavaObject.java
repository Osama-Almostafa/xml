import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class XMLToJavaObject {
    public static void main(String[] args) {
        try {
            File file = new File("htmlDto-jaxb.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(HtmlDTO.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            HtmlDTO htmlDTO = (HtmlDTO) jaxbUnmarshaller.unmarshal(file);
            System.out.println("Cpr: " + htmlDTO.getCpr());
            System.out.println("First Name: " + htmlDTO.getFirstName());
            System.out.println("Last Name: " + htmlDTO.getLastName());
            System.out.println("Email: " + htmlDTO.getEmail());
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
