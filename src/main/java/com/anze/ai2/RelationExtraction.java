package com.anze.ai2;

import com.anze.ai2.tool.ReadLocalJsonFileDemo;

import java.io.IOException;
import java.util.Arrays;

public class RelationExtraction {
    public static void main(String[] args) throws IOException {
        String URL = "D:\\大三上\\AI\\t2\\experiment_data.jsonl";
        String[] split = ReadLocalJsonFileDemo.readerMethod(URL).split("\n");
        int n=0;
        for (String s:split){
            if(n++>20)
                break;
            String infobox = s.substring(s.indexOf("infobox")+11, s.indexOf("name")-4).replaceAll("\"","").replaceAll("\\s","");
            //System.out.println(infobox);
            String name = s.substring(s.indexOf("name")+8,s.indexOf("para")-4);
            System.out.println(name);
            String para = s.substring(s.indexOf("para")+8,s.indexOf("summary")-4);
            //System.out.println(para); 无[]
            String summary = s.substring(s.indexOf("summary")+9,s.length()-2);
            //System.out.println(summary);
            String[] infobox_arr = infobox.split(",");
            System.out.println(Arrays.toString(infobox_arr));
            String[] para_arr = para.split(",");
            //System.out.println(Arrays.toString(para_arr));
        }
    }
}
