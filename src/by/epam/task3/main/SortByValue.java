package by.epam.task3.main;

import by.epam.task3.gem.Gem;

import java.util.Comparator;

public class SortByValue implements Comparator<Gem>{



    @Override
    public int compare(Gem o1, Gem o2) {

        int p1 = o1.getValue();
        int p2 = o2.getValue();

        if (p1 < p2){
            return 1;
        }
        else if (p1 > p2){
            return -1;
        }
        else return 0;    }
}
