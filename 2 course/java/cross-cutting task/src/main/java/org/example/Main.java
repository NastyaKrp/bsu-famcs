package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, TransformerException {
        System.out.println("Enter type of input file");
        Scanner sc = new Scanner(System.in);
        String in_type = sc.nextLine();
        System.out.println("Type 1 if file is archived\nType 2 if file is encrypted\nType 3 if file is archived and then encrypted\nType 4 if file is encrypted and then archived\nType 0 if none of those");
        Integer in_type2 = sc.nextInt();
        System.out.println(in_type);
        System.out.println(in_type2);


        //проверка чтения  и запись txt - работает
        /*ReadTXT read = new ReadTXT();
        List<String> info = read.ReadTXT("input.txt");
        for(String s: info)
        {
            System.out.println(s);
        }
        read.WriteTXT(info);
        */

        //проверка чтения и вывод xml - работает
        /*ReadXML read = new ReadXML();
        List<String> info = read.ReadXML("input.xml");
        for(String s: info)
        {
            System.out.println(s);
        }
        read.WriteXML(info, "output.xml");
        */

    }
}