package WypozyczalniaSamochodow.gui;

import static javax.swing.BorderFactory.createEmptyBorder;
import static javax.swing.Box.createVerticalStrut;
import static java.lang.Math.*;


import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;

import java.util.Calendar;

import WypozyczalniaSamochodow.core.ListaSchemat;
import WypozyczalniaSamochodow.core.ZbytDuzoZnakow;

public class GlowneOkno extends JFrame {
    private static final long serialVersionUID = 1L;

    private JPanel glownyPanel;
    private JPanel kontrolaNowychZadan;
    private JButton dodajPrzycisk;
    private JButton dodajPrzycisk2;
    private JButton dodajPrzycisk3;
    private JButton dodajPrzycisk4;
    private JTextField nowePoleDoZadan;
    private JScrollPane panelZadan;
    private JPanel kontrolaListyZadan;
    private JButton przyciskDoGory;
    private JButton przyciskUsun;
    private JButton przyciskWDol;
    private JList<String> listaZadan;
    private JLabel pasekStatusu;

    private ListaSchemat listaSchemat;
    private WypozyczalniaModel todoListModel;

    int licznik = 0;

    static String s1 = "";


    public String stringFile = "";

    public GlowneOkno() {


        this.listaSchemat = new ListaSchemat();
        this.todoListModel = new WypozyczalniaModel(this.listaSchemat);

        this.setContentPane(this.getMainContentPane());

        this.setTitle("Wypozyczalnia samochodow");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setMinimumSize(new Dimension(900, 700));

        this.pack();
    }

    private Container getMainContentPane() {
        if (glownyPanel == null) {
            this.glownyPanel = new JPanel();
            this.glownyPanel.setLayout(new BorderLayout());

            this.glownyPanel.add(getNewTaskControls(), BorderLayout.NORTH);
            this.glownyPanel.add(getTasksListScrollPane(), BorderLayout.CENTER);
            this.glownyPanel.add(getTasksListControls(), BorderLayout.EAST);
            this.glownyPanel.add(getStatusBar(), BorderLayout.SOUTH);

        }
        return this.glownyPanel;
    }

    private Component getNewTaskControls() {
        if (this.kontrolaNowychZadan == null) {
            this.kontrolaNowychZadan = new JPanel();

            BorderLayout layout = new BorderLayout();
            this.kontrolaNowychZadan.setLayout(layout);
            layout.setHgap(5);
            this.kontrolaNowychZadan.setBorder(createEmptyBorder(10, 0, 10, 10));

            this.kontrolaNowychZadan.add(getNewTaskField(), BorderLayout.CENTER);
            this.kontrolaNowychZadan.add(getAddTaskButton(), BorderLayout.SOUTH);
            this.kontrolaNowychZadan.add(getAddTaskButton2(), BorderLayout.WEST);
            this.kontrolaNowychZadan.add(getAddTaskButton3(), BorderLayout.EAST);
            this.kontrolaNowychZadan.add(getAddTaskButton4(), BorderLayout.NORTH);
        }
        return this.kontrolaNowychZadan;
    }

    private JTextField getNewTaskField() {
        if (this.nowePoleDoZadan == null) {
            this.nowePoleDoZadan = new JTextField();
        }
        return this.nowePoleDoZadan;
    }

    private Component getTasksListScrollPane() {
        if (this.panelZadan == null) {
            this.panelZadan = new JScrollPane(getTaskList());
        }

        return this.panelZadan;
    }

    private JList<String> getTaskList() {
        if (this.listaZadan == null) {
            this.listaZadan = new JList<>();
            this.listaZadan.setModel(this.todoListModel);
        }

        return this.listaZadan;
    }

    private Component getTasksListControls() {
        if (this.kontrolaListyZadan == null) {
            this.kontrolaListyZadan = new JPanel();

            BoxLayout layout = new BoxLayout(this.kontrolaListyZadan, BoxLayout.Y_AXIS);
            this.kontrolaListyZadan.setLayout(layout);
            this.kontrolaListyZadan.setBorder(createEmptyBorder(5, 5, 5, 5));

            JButton button = getUpButton();
            button.setAlignmentX(CENTER_ALIGNMENT);
            this.kontrolaListyZadan.add(button);

            this.kontrolaListyZadan.add(createVerticalStrut(10));

            button = getDeleteButton();
            button.setAlignmentX(CENTER_ALIGNMENT);
            this.kontrolaListyZadan.add(button);

            this.kontrolaListyZadan.add(createVerticalStrut(10));

            button = getDownButton();
            button.setAlignmentX(CENTER_ALIGNMENT);
            this.kontrolaListyZadan.add(button);
        }

        return this.kontrolaListyZadan;
    }

    private JButton getUpButton() {
        if (this.przyciskDoGory == null) {
            this.przyciskDoGory = new JButton("Do góry");
            this.przyciskDoGory.setIcon(createIcon("up.png"));

            this.przyciskDoGory.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int pos = getTaskList().getSelectedIndex();
                    todoListModel.wGore(pos);

                    getTaskList().setSelectedIndex(max(0, pos - 1));
                }
            });
        }

        return this.przyciskDoGory;
    }

    private JButton getDeleteButton() {
        if (this.przyciskUsun == null) {
            this.przyciskUsun = new JButton("Usuń");


            this.przyciskUsun.setIcon(createIcon("bin.png"));

            this.przyciskUsun.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    todoListModel.usun(getTaskList().getSelectedIndex());
                }
            });
        }

        return this.przyciskUsun;
    }

    private JButton getDownButton() {
        if (this.przyciskWDol == null) {
            this.przyciskWDol = new JButton("W dół");
            this.przyciskWDol.setIcon(createIcon("down.png"));

            this.przyciskWDol.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    int pos = getTaskList().getSelectedIndex();
                    todoListModel.wDol(pos);

                    getTaskList().setSelectedIndex(
                            min(getTaskList().getModel().getSize() - 1, pos + 1));
                }
            });
        }

        return this.przyciskWDol;
    }


    int uaktualnijLicznik(String str1, String carName, String s, int n) {

        stringFile += s1;

        if (str1.equalsIgnoreCase("t")) {
            s1 = carName + "     " + getNewTaskField().getText() + "         " + s + "         " + (n * 1000) + " zł za okres tygodnia";
            todoListModel.dodaj(s1);
            return 0;
        }
        if (str1.equalsIgnoreCase("m")) {
            s1 = carName + "     " + getNewTaskField().getText() + "         " + s + "         " + (4 * n * 1000) + " zł za okres miesiąca";
            licznik += 3;
            todoListModel.dodaj(s1);
            return 1;
        }
        if (str1.equalsIgnoreCase("r")) {
            licznik = licznik + (n * 29);
            s1 = carName + "     " + getNewTaskField().getText() + "         " + s + "         " + (19 * n * 1000) + " zł za okres roku";
            todoListModel.dodaj(s1);
            return 2;
        }
        return 3;
    }

    public void mouseClickedMethod(JButton button, int n, String carName) {

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String str1 = JOptionPane.showInputDialog("Na jaki czas chcesz wypożyczyć auto? Wpisz t/m/r ('tydzień/ miesiąc/ rok')");


                String s = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());


                licznik += n;
                int count = (new GlowneOkno()).uaktualnijLicznik(str1, carName, s, n);


                switch (count) {
                    case 0:
                        todoListModel.dodaj(carName + "     " + getNewTaskField().getText() + "         " + s + "         " + (n * 1000) + " zł za okres tygodnia");
                        break;
                    case 1:
                        licznik += 3;
                        todoListModel.dodaj(carName + "     " + getNewTaskField().getText() + "         " + s + "         " + (4 * n * 1000) + " zł za okres miesiąca");
                        break;
                    case 2:
                        licznik = licznik + (n * 29);
                        todoListModel.dodaj(carName + "     " + getNewTaskField().getText() + "         " + s + "         " + (30 * n * 1000) + " zł za okres roku");
                        break;
                    default:
                        JOptionPane.showMessageDialog(dodajPrzycisk,
                                "Nie wybrałeś na jaki czas chcesz pożyczyć samochód. Wpisz t (tydzień), m (miesiąc) albo r (rok)",
                                "Złe dane wejściowe", JOptionPane.ERROR_MESSAGE);


                }


                if (getNewTaskField().getText().length() > 0) {


                    if (getNewTaskField().getText().length() > 100) {
                        try {
                            throw new ZbytDuzoZnakow();

                        } catch (ZbytDuzoZnakow tooManyCharacters) {
                            JOptionPane.showMessageDialog(dodajPrzycisk,
                                    "Wprowadź maksymalnie 100 znaków.",
                                    "Błąd", JOptionPane.ERROR_MESSAGE);
                        }
                    } else {
                        getTaskList().setSelectedIndex(getTaskList().getModel().getSize() - 1);

                        stringFile = stringFile + "\n" + s1;
                        try {

                            FileWriter fileWriter = new FileWriter("plik.txt");

                            fileWriter.write(stringFile);
                            fileWriter.close();
                        } catch (IOException e1) {
                            e1.printStackTrace();
                        }

                    }
                }
            }
        });
    }


    private JButton getAddTaskButton() {
        if (this.dodajPrzycisk == null) {
            this.dodajPrzycisk = new JButton();
            this.dodajPrzycisk.setIcon(createIcon("bmw.png"));


            mouseClickedMethod(dodajPrzycisk, 1, "BMW 5 Series");

        }

        return this.dodajPrzycisk;
    }


    private JButton getAddTaskButton2() {
        if (this.dodajPrzycisk2 == null) {
            this.dodajPrzycisk2 = new JButton();
            this.dodajPrzycisk2.setIcon(createIcon("jeep.png"));


            mouseClickedMethod(dodajPrzycisk2, 1, "Jeep Grand Cherokee");

        }

        return this.dodajPrzycisk2;
    }


    private JButton getAddTaskButton3() {
        if (this.dodajPrzycisk3 == null) {
            this.dodajPrzycisk3 = new JButton();
            this.dodajPrzycisk3.setIcon(createIcon("toyota.png"));


            mouseClickedMethod(dodajPrzycisk3, 1, "Toyota Vios 1.3 xe");

        }

        return this.dodajPrzycisk3;
    }


    private JButton getAddTaskButton4() {
        if (this.dodajPrzycisk4 == null) {
            this.dodajPrzycisk4 = new JButton();
            this.dodajPrzycisk4.setIcon(createIcon("ferrari.png"));


            mouseClickedMethod(dodajPrzycisk4, 3, "Ferrari f8 Tributo");

        }

        return this.dodajPrzycisk4;
    }


    private JLabel getStatusBar() {
        if (this.pasekStatusu == null) {
            this.pasekStatusu = new JLabel("Liczba wypożyczonych samochodów: 0. Opłaty łącznie: 0zł");

            this.todoListModel.addListDataListener(new ListDataListener() {
                @Override
                public void contentsChanged(ListDataEvent e) {
                    updateLabel(e);
                }

                private void updateLabel(ListDataEvent e) {
                    getStatusBar().setText("Liczba wypożyczonych samochodów: " +
                            ((WypozyczalniaModel) e.getSource()).getSize() + ". Opłaty łącznie: " + licznik * 1000 + "zł");
                }

                @Override
                public void intervalRemoved(ListDataEvent e) {
                }

                @Override
                public void intervalAdded(ListDataEvent e) {
                }
            });
        }

        return this.pasekStatusu;
    }

    private Icon createIcon(String iconfilename) {
        return new ImageIcon(
                getClass().
                        getResource("/" + iconfilename));
    }


}
