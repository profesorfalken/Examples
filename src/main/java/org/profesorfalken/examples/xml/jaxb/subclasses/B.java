/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profesorfalken.examples.xml.jaxb.subclasses;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "B", propOrder = {"dataB1", "dataB2"})
@XmlRootElement(name = "Base", namespace = "")
public class B extends Base {

    private String dataB1;
    private String dataB2;

    public String getDataB1() {
        return dataB1;
    }

    public void setDataB1(String dataB1) {
        this.dataB1 = dataB1;
    }

    public String getDataB2() {
        return dataB2;
    }

    public void setDataB2(String dataB2) {
        this.dataB2 = dataB2;
    }
}
