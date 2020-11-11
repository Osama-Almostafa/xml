import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class javaObjectToXML {

    private static final String HtmlDTO_XML = "htmlDto-jaxb.xml";

    public static void main(String[] args) throws JAXBException {

        List<HtmlDTO> htmlDTOS = new ArrayList<>();
        HtmlDTO htmlDTO1 = new HtmlDTO();
        htmlDTO1.setCpr("090909898");
        htmlDTO1.setFirstName("blbb");
        htmlDTO1.setLastName("lllll");
        htmlDTO1.setEmail("ttr@gmail.com");
        htmlDTOS.add(htmlDTO1);
        convertObjectToXML(htmlDTO1);
    }

    private static void convertObjectToXML(HtmlDTO htmlDTO) throws JAXBException {
        // create JAXB context and instantiate marshaller
        JAXBContext context = JAXBContext.newInstance(HtmlDTO.class);
        Marshaller m = context.createMarshaller();
        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        // Write to System.out
        m.marshal(htmlDTO, System.out);
        // Write to File
        m.marshal(htmlDTO, new File(HtmlDTO_XML));
    }
}