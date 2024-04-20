package com.zrrd.util;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactory {
    private static Map<String,Object> map = new HashMap<>();

    static {

        try {
            InputStream resourceAsStream = BeanFactory.class.getClassLoader().getResourceAsStream("beans.xml");
            SAXReader saxReader = new SAXReader();
            Document document = saxReader.read(resourceAsStream);
            Element beans = document.getRootElement();
            List<Element> elements = beans.elements();
            for (Element element : elements
                 ) {
                String id = element.attributeValue("id");
                String className = element.attributeValue("class");
                Class<?> aClass = Class.forName(className);
                Object o = aClass.newInstance();
                map.put(id,o);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static Object getBean(String id){
        return map.get(id);
    }
}
