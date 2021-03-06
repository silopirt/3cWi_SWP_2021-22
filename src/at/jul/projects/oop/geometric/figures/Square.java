package at.jul.projects.oop.geometric.figures;

import at.jul.projects.oop.geometric.Figure;

public class Square extends Figure {
    private int a;

    public Square(String nameOfFigure, int a) {
        super(nameOfFigure);
        this.a = a;
    }

    @Override
    public int getArea() {
        return a*a;
    }

    public int getA() {
        return a;
    }
}
