import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Hashtable;

//панель для отрисовки
public class Visual extends JPanel {
    private int w, h; //размеры панели

    private Hashtable<Integer, Station> dict; //словарь для быстрого доступа к данным
    private int[][] graph; //матрица смежности
    private ArrayList<Integer> path; //кратчайший маршрут

    //конструктор
    public Visual(int w, int h, ArrayList<Station> stations, int[][] graph) {
        this.w = w;
        this.h = h;
        this.graph = graph;
        dict = new Hashtable<>();
        for (int i = 0; i < stations.size(); i++) {
            dict.put(stations.get(i).index, stations.get(i));
        }
        setPath(new ArrayList<>());
    }

    //установка кр. маршрута
    public void setPath(ArrayList<Integer> path) {
        this.path = path;
        repaint();
    }

    //отрисовка компонентов
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawGraph(g);
    }

    //сброс
    public void reset() {
        setPath(new ArrayList<>());
        repaint();
    }

    //отрисовка графа
    void drawGraph(Graphics g) {
        int paddX = -25; //смещение по x
        int d = 15; //диаметр круга

        //пути для каждой вершины по матрице смежности
        g.setColor(Color.BLACK);
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                if (graph[i][j] != 0) {
                    Station start = dict.get(i);
                    Station end = dict.get(j);

                    //ребро
                    g.drawLine(start.pos.x + d / 2 + paddX, start.pos.y + d / 2,
                            end.pos.x + d / 2 + paddX, end.pos.y + d / 2);

                    //вес ребра
                    int mx = (start.pos.x + end.pos.x) / 2 + d / 2 + paddX;
                    int my = (start.pos.y + end.pos.y) / 2 + d / 2;
                    g.drawString(graph[i][j] + "", mx, my - 2);
                }
            }
        }

        //кратчайший путь
        if (path.size() > 1) {
            g.setColor(Color.red);
            for (int i = 0; i < path.size() - 1; i++) {
                Station start = dict.get(path.get(i));
                Station end = dict.get(path.get(i + 1));
                g.drawLine(start.pos.x + d / 2 + paddX, start.pos.y + d / 2,
                        end.pos.x + d / 2 + paddX, end.pos.y + d / 2);
            }
        }

        //названия и подписи
        for (int index : dict.keySet()) {
            Station s = dict.get(index);
            g.setColor(s.color);
            g.fillOval(s.pos.x + paddX, s.pos.y, d, d);
            g.drawString(s.name, s.pos.x + paddX, s.pos.y - 6);
        }
    }
}