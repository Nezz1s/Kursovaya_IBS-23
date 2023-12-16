import java.awt.*;

//одна станция метро
public class Station {
    public String name; //название
    public Point pos; //позиция при отрисовке
    public Color color; //цвет
    public int index; //для идентификации

    //конструктор
    public Station(String name, Point pos, Color color, int index) {
        this.name = name;
        this.pos = pos;
        this.color = color;
        this.index = index;
    }
}