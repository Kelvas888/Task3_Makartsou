package by.epam.task3.gem;

public class Gem {

    private String id;
    private String name;
    private String preciousness;
    private String origin;
    private VisualGem param;
    private int value;

    public Gem() {}

    public Gem(String id,String name,String preciousness,String origin,VisualGem param,int value) {
        this.id = id;
        this.name = name;
        this.preciousness = preciousness;
        this.origin = origin;
        this.param = param;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPreciousness() {
        return preciousness;
    }

    public String getOrigin() {
        return origin;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public void setPreciousness(String preciousness) {
        this.preciousness = preciousness;
    }

    public void setParam(VisualGem param) {
        this.param = param;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("\n").append(" Name: ").append(this.getName()).append(" Preciousness: ").append(this.getPreciousness()).append("\n");
        result.append("ID: ").append(this.getId()).append("\n");
        result.append("Mined by: ").append(this.getOrigin()).append("\n");
        result.append("Transparency: ").append(param.getTransparency()).append(", Color: ").append(param.getColor()).append(", Edges: ").append(param.getEdges()).append("\n");
        result.append("Value: ").append(getValue());
        return result.toString();
    }


}
