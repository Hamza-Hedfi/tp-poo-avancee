package com.deuterium.tp01;

public class Main {
    public static void main(String[] args) {
        Graphique graphique = new Graphique();


        graphique.elementsGraphique.add(new Point(1.01, 5.014));
        graphique.elementsGraphique.add(new Segment(
                new Point[]{
                        new Point(1.01, 5.014),
                        new Point(1.01, 5.014)

                })
        );

//        System.out.println(graphique.elementsGraphique.get(0));

        System.out.println(graphique.elementsGraphique.get(1));
        graphique.elementsGraphique.get(1).deplacer(1.0, 0.5);
        System.out.println(graphique.elementsGraphique.get(1));


        graphique.elementsGraphique.get(1).deplacer();
        System.out.println(graphique.elementsGraphique.get(1));

    }
}
