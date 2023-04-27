package exercise;

// BEGIN
public class Circle {
    public Point point;
    public int radius;

    public Circle(Point point, int radius) {
        this.point = point;
        this.radius = radius;
    }
    
    public int getRadius() {
        return radius;
    }
    
    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Error: radius < 0");
        } else {
            return Math.PI * radius * radius;
        }
    }
}
// END
