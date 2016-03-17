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
@XmlType(name="A", propOrder = { "dataA1", "dataA2" })
@XmlRootElement(name = "Base", namespace = "")
public class A extends Base {
    private String dataA1;
    private String dataA2;

    public String getDataA1() {
        return dataA1;
    }

    public void setDataA1(String dataA1) {
        this.dataA1 = dataA1;
    }

    public String getDataA2() {
        return dataA2;
    }

    public void setDataA2(String dataA2) {
        this.dataA2 = dataA2;
    }
}