import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//основная программа
public class Main extends JFrame {

    //справка
    public class Refer implements ActionListener {
        JFrame frame;

        @Override
        public void actionPerformed(ActionEvent e) {
            if (frame != null) {
                frame.dispose();
            }
            frame = new JFrame();
            frame.setVisible(true);
            frame.setSize(new Dimension(500, 280));
            frame.setTitle("Справка");
            frame.setLayout(null);
            JLabel about = new JLabel(
                    "<html>" +
                            "<p>'Начальная станция' - выбирается станция от которой начинается формирование кратчайшего пути;</p><br>" +
                            "<p>'Конечная станция' - выбирается станция до которой формируется кратчайший путь;</p><br>" +
                            "<p>'Общее время в пути' - длина кратчайшего пути в минутах;</p><br>" +
                            "<p>Кнопка 'Поиск' - отображает кратчайший путь красной линией на рисунке и добавляет его время в минутах на метку 'Общее время в пути';</p><br>" +
                            "<p>Кнопка 'Сброс' - сбрасывает начальную и конечную станции, а также убирает ранее найденный кратчайший путь;</p><br>" +
                    "</html>");
            about.setBounds(20, 20, 450, 220);
            frame.add(about);
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
            frame.setResizable(false);
        }
    }

    //конструктор
    public Main() {

        //настройка формы
        setResizable(false);
        setTitle("Схема метро");
        int w = 656;
        int h = 600;
        setPreferredSize(new java.awt.Dimension(w, h));
        GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        pack();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        //о программе
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("О программе");

        //справка
        JMenuItem refer = new JMenuItem("Справка");
        refer.addActionListener(new Refer());
        menu.add(refer);

        //размещаем меню
        menuBar.add(menu);
        setJMenuBar(menuBar);

        //добавляем панель
        JPanel panel = new Panel();
        panel.setBounds(0, 0, w, h);
        panel.setLayout(null);
        add(panel);
    }

    //главная функция
    public static void main(String[] args) {
        new Main().setVisible(true);
    }
}