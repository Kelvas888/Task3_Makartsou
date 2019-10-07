package by.epam.task3.main;

import by.epam.task3.gem.Gem;
import by.epam.task3.parser.DOMParser;

import java.util.ArrayList;
import java.util.Collections;

public class Run {

    public static void main(String[] args) {
        DOMParser parser =  new DOMParser();
        ArrayList<Gem> gem = parser.parseGem();
        System.out.println(gem.toString());
        Collections.sort(gem, new SortByValue());
        System.out.println(gem.toString());

    }
}
