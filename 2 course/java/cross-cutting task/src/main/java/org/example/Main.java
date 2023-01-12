package org.example;

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
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



public class Main {


    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException, ScriptException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        /*Key key = Cr.Encr("input.json");
        Cr.DeEncr("eninput.json", key);*/


        /*System.out.println("Enter type of input file");
        Scanner sc = new Scanner(System.in);
        String in_type = sc.nextLine();
        System.out.println("Type 1 if file is archived\nType 2 if file is encrypted\nType 3 if file is archived and then encrypted\nType 4 if file is encrypted and then archived\nType 0 if none of those");
        Integer in_type2 = sc.nextInt();
        System.out.println("Enter type of output file");
        String out_type = sc.nextLine();




        //проверка чтения  и запись txt - работает
        List<String> info1 = TXT.ReadTXT("input.txt");
        for(String s: info1)
        {
            System.out.println(s);
        }
        TXT.WriteTXT(Sol.Sol_M(info1));

        //проверка чтения и вывод xml - работает
        List<String> info2 = XML.ReadXML("input.xml");
        for(String s: info2)
        {
            System.out.println(s);
        }
        XML.WriteXML(Sol.Sol_M(info2), "output.xml");

        //проверка чтение и запись json - работает
        List<String> info3 = JSON.ReadJSON("input.json");
        for(String s: info3)
        {
            System.out.println(s);
        }
        JSON.WriteJSON(Sol.Sol_M(info3));*/

    }
}