/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.profesorfalken.examples.xml.jaxb.subclasses;

import javax.xml.bind.annotation.adapters.XmlAdapter;


public class BaseAdapter  extends XmlAdapter<BaseAdapter.BaseHandler,Base>{

    @Override
    public Base unmarshal(BaseHandler baseHandler) throws Exception {
        if (null == baseHandler) {
            return null;
        }
        if (null != baseHandler.dataA1) {
            A a = new A();
            a.setDataA1(baseHandler.dataA1);
            a.setDataA2(baseHandler.dataA2);            
            return a;
        } else {
            B b = new B();
            b.setDataB1(baseHandler.dataB1);
            b.setDataB2(baseHandler.dataB2);
            return b;
        }
    }

    @Override
    public BaseHandler marshal(Base base) throws Exception {
         if (null == base) {
            return null;
        }
        BaseHandler baseHandler = new BaseHandler();
        if (base instanceof A) {
            A a = (A) base;
            baseHandler.dataA1 = a.getDataA1();
            baseHandler.dataA2 = a.getDataA2();
        } else {
            B b = (B) base;
            baseHandler.dataB1 = b.getDataB1();
            baseHandler.dataB2 = b.getDataB2();
        }
        return baseHandler;
    }
    
    public static class BaseHandler {
        public String dataA1;
        public String dataA2;
        public String dataB1;
        public String dataB2;
    }
}
