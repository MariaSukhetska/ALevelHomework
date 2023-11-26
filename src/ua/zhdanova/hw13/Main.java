package ua.zhdanova.hw13;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Figure> figures=new ArrayList<>();
        Figure circle = new Circle( 7.0);
        Figure square = new Square( 5.0);
        Triangle triangle = new Triangle(6.0, 5.0, 2.0, 6.0, 1.561249499599599, 18.195);
        figures.add(circle);
        figures.add(square);
        figures.add(triangle);
        Comparator<Figure> areaComparator= Comparator.comparingDouble(figure -> figure.area());
        Comparator<Figure> perimeterComparator= Comparator.comparingDouble(figure -> figure.perimeter());
        Comparator<Figure> comparator = areaComparator.thenComparing(perimeterComparator);

        figures.sort(areaComparator);
        figures.sort(perimeterComparator);
        System.out.println(figures);

    }
}