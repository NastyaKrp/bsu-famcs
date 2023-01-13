package org.example.builders;

import com.sun.jdi.event.MonitorWaitEvent;
import org.example.*;
import org.xml.sax.SAXException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.script.ScriptException;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Director {

    public void construct(Key key) throws ScriptException, ParserConfigurationException, IOException, TransformerException, SAXException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        Director director = new Director();
        System.out.println("Enter type of input file");
        Scanner sc = new Scanner(System.in);
        String in_type = sc.nextLine();
        System.out.println("Enter type of output file");
        String out_type = sc.nextLine();
        System.out.println("Enter path to input file");
        String in_path = sc.nextLine();
        String zName = "";
        System.out.println("Type 1 if file is archived\nType 2 if file is encrypted\nType 3 if file is archived and then encrypted\nType 4 if file is encrypted and then archived\nType 0 if none of those");
        Integer in_type2 = sc.nextInt();
        switch(in_type2)
        {
            case 0:
                director.construct0(in_type, out_type, in_path);
                break;
            case 1:
                director.construct1(in_type, out_type, in_path);
                break;
            case 2:
                director.construct2(in_type, out_type, key, in_path);
                break;
            case 3:
                director.construct3(in_type, out_type, key, in_path);
                break;
            case 4:
                director.construct4(in_type, out_type, key, in_path);
                break;
        }
    }

    public void construct0(String in, String out, String path_in) throws ParserConfigurationException, IOException, SAXException, ScriptException, TransformerException {
        List<String> info = new ArrayList<>();
        switch (in)
        {
            case "txt":
                info = TXT.ReadTXT(path_in);
                break;
            case "xml":
                info = XML.ReadXML(path_in);
                break;
            case "json":
                info = JSON.ReadJSON(path_in);
                break;
        }
        info = Sol.Sol_M(info);
        switch (out)
        {
            case "txt":
                TXT.WriteTXT(info);
                break;
            case "xml":
                XML.WriteXML(info, "output.xml");
                break;
            case "json":
                JSON.WriteJSON(info);
                break;
        }
    }

    public void construct1(String in, String out, String path_in) throws ParserConfigurationException, IOException, SAXException, ScriptException, TransformerException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter type of archive: zip or jar");
        String type = sc.nextLine();
        System.out.println("Enter path to archive");
        String zName = sc.nextLine();
        List<String> info = new ArrayList<>();
        String add = "new";
        if(type == "zip")
        {
            Zip.Arch(zName);
        }
        else
        {
            add = "j" + add;
            Jar.exJAR(zName);
        }
        switch (in)
        {
            case "txt":
                info = TXT.ReadTXT(add + path_in);
                break;
            case "xml":
                info = XML.ReadXML(add + path_in);
                break;
            case "json":
                info = JSON.ReadJSON(add + path_in);
                break;
        }
        info = Sol.Sol_M(info);
        switch (out)
        {
            case "txt":
                TXT.WriteTXT(info);
                break;
            case "xml":
                XML.WriteXML(info, "output.xml");
                break;
            case "json":
                JSON.WriteJSON(info);
                break;
        }

    }

    public void construct2(String in, String out, Key key, String path_in) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, BadPaddingException, InvalidKeyException, ParserConfigurationException, SAXException, ScriptException, TransformerException {
        List<String> info = new ArrayList<>();
        Cr.DeEncr(path_in, key);
        switch (in)
        {
            case "txt":
                info = TXT.ReadTXT("de" + path_in);
                break;
            case "xml":
                info = XML.ReadXML("de" + path_in);
                break;
            case "json":
                info = JSON.ReadJSON("de" + path_in);
                break;
        }
        info = Sol.Sol_M(info);
        switch (out)
        {
            case "txt":
                TXT.WriteTXT(info);
                break;
            case "xml":
                XML.WriteXML(info, "output.xml");
                break;
            case "json":
                JSON.WriteJSON(info);
                break;
        }
    }

    public void construct3(String in, String out, Key key, String path_in) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, BadPaddingException, InvalidKeyException, ParserConfigurationException, SAXException, ScriptException, TransformerException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter type of archive: zip or jar");
        String type = sc.nextLine();
        System.out.println("Enter path to archive");
        String zName = sc.nextLine();
        List<String> info = new ArrayList<>();
        String add = "new";
        Cr.DeEncr(zName, key);
        if(type == "zip")
        {
            Zip.Arch("de" + zName);
        }
        else
        {
            add = "j" + add;
            Jar.exJAR("de" + zName);
        }
        switch (in)
        {
            case "txt":
                info = TXT.ReadTXT(add + path_in);
                break;
            case "xml":
                info = XML.ReadXML(add + path_in);
                break;
            case "json":
                info = JSON.ReadJSON(add + path_in);
                break;
        }
        info = Sol.Sol_M(info);
        switch (out)
        {
            case "txt":
                TXT.WriteTXT(info);
                break;
            case "xml":
                XML.WriteXML(info, "output.xml");
                break;
            case "json":
                JSON.WriteJSON(info);
                break;
        }
    }

    public void construct4(String in, String out, Key key, String path_in) throws NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, IOException, BadPaddingException, InvalidKeyException, ParserConfigurationException, SAXException, ScriptException, TransformerException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter type of archive: zip or jar");
        String type = sc.nextLine();
        System.out.println("Enter path to archive");
        String zName = sc.nextLine();
        String add = "new";
        if(type == "zip")
        {
            Zip.Arch(zName);
        }
        else
        {
            add = "j" + add;
            Jar.exJAR(zName);
        }
        List<String> info = new ArrayList<>();
        Cr.DeEncr(add + path_in, key);
        add = "de" + add;
        switch (in)
        {
            case "txt":
                info = TXT.ReadTXT(add + path_in);
                break;
            case "xml":
                info = XML.ReadXML(add + path_in);
                break;
            case "json":
                info = JSON.ReadJSON(add + path_in);
                break;
        }
        info = Sol.Sol_M(info);
        switch (out)
        {
            case "txt":
                TXT.WriteTXT(info);
                break;
            case "xml":
                XML.WriteXML(info, "output.xml");
                break;
            case "json":
                JSON.WriteJSON(info);
                break;
        }
    }
}
