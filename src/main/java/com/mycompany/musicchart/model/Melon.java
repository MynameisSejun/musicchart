/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.musicchart.model;

import java.util.ArrayList;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

/**
 *
 * @author 성명주
 */
public class Melon {
    ArrayList<String> listTitle;
    ArrayList<String> listName;
    public Melon() {
        String url = "https://www.melon.com/chart/index.htm";
        Document doc = null;
        
        try {
            doc = Jsoup.connect(url).get();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        listTitle = new ArrayList<>();
        listName = new ArrayList<>();
        
        Elements rank_list = doc.select("div.wrap_song_info div.ellipsis.rank01 span a");
        Elements rank_list_name = doc.select("div.wrap_song_info div.ellipsis.rank02 span a");
        
        for(Element a : rank_list) {
            listTitle.add(a.text());
        }
        for(Element b : rank_list_name) {
            listName.add(b.text());
        }
    }

    public ArrayList<String> getListTitle() {
        return listTitle;
    }

    public void setListTitle(ArrayList<String> listTitle) {
        this.listTitle = listTitle;
    }

    public ArrayList<String> getListName() {
        return listName;
    }

    public void setListName(ArrayList<String> listName) {
        this.listName = listName;
    }
    
}
