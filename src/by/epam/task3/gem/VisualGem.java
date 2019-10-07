package by.epam.task3.gem;

public class VisualGem {
    private int transparency;
    private String color;
    private int edges;

    public VisualGem() {}

    public VisualGem(int transparency,String color,int edges) {
        this.transparency = transparency;
        this.color = color;
        this.edges = edges;
    }

    public void setTransparency(int transparency) {
        this.transparency = transparency;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setEdges(int edges) {
        this.edges = edges;
    }

    public int getTransparency() {
        return transparency;
    }

    public String getColor() {
        return color;
    }

    public int getEdges() {
        return edges;
    }
}
