package org.example;

import org.example.builders.Director;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.*;


public class Main {


    public static void main(String[] args) throws Exception {

        Director director = new Director();
        Key key = Cr.Encr("input.json"); // для 2 и 4 случаев
        Zip.Z("eninput.json", "eninput.zip"); // - для 4 случая
        Zip.Z("input.xml", "input.zip"); // - для 1 случая

        Zip.Z("input.xml", "input2.zip"); // для 3 случая
        Key key2 = Cr.Encr("input2.zip"); // для 3 случая

        //Примеры вызовов (учитывая, что изначально есть три файла input.txt, input.xml, input.json)
        //director.construct(key); //вызов 4ого случая (json, json, eninput.json, 4, eninput.zip)

        //director.construct(key);//вызов 0ого случая(txt, xml, input.txt, 0)

        //director.construct(key);//вызов 1ого случая(xml, txt, input.xml, 1, input.zip)

        //director.construct(key);//вызов 2ого случая(json, json, eninput.json, 2)

        //director.construct(key2);//вызов 3его случая(xml, xml, input.xml, 3, eninput2.zip)
    }
}