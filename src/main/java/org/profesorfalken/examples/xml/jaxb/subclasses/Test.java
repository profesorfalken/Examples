/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profesorfalken.examples.xml.jaxb.subclasses;

import java.io.StringReader;
import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

public class Test {

    public static void main(String[] args) throws Exception {
        Container container = new Container();
        Base base = new A();
        base.setBaseData("BaseDataA");
        ((A) base).setDataA1("DataA1");
        ((A) base).setDataA2("DataA2");
        container.setBase(base);

        JAXBContext jc = JAXBContext.newInstance(Container.class,Base.class, A.class, B.class);

            // Marshal the object
            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            StringWriter sw = new StringWriter();
            marshaller.marshal(container, sw);

            // Unmarshal the object
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            String generatedXml = sw.toString();
            System.out.println(generatedXml);
            Container objectFromUnmarshall = (Container) unmarshaller.unmarshal(new StringReader(generatedXml));
            System.out.println(objectFromUnmarshall);

            // Re-marshal the object
            System.out.println("");
            sw = new StringWriter();
            marshaller.marshal(objectFromUnmarshall, sw);
            System.out.println(sw.toString());
    }
}
