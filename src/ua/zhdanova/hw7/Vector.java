package ua.zhdanova.hw7;

public class Vector {

    public double x, y, z;

    public Vector(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public double length() {
        return Math.sqrt(x * x + y * y + z * z);
    }

    public Vector cross(Vector other) {
        return new Vector(
                this.y * other.z - this.z * other.y,
                this.z * other.x - this.x * other.z,
                this.x * other.y - this.y * other.x
        );
    }

    public double dot(Vector other) {
        return this.x * other.x + this.y * other.y + this.z * other.z;
    }

    public double cosine(Vector other) {
        return dot(other) / (this.length() * other.length());
    }

    public Vector add(Vector other) {
        return new Vector(this.x + other.x, this.y + other.y, this.z + other.z);
    }

    public Vector subtract(Vector other) {
        return new Vector(this.x - other.x, this.y - other.y, this.z - other.z);
    }

    public static Vector[] randomVectors(int n) {
        java.util.Random random = new java.util.Random();
        Vector[] vectors = new Vector[n];
        for (int i = 0; i < n; i++) {
            vectors[i] = new Vector(random.nextInt(21) - 10, random.nextInt(21) - 10, random.nextInt(21) - 10);
        }
        return vectors;
    }

    @Override
    public String toString() {
        return "Vector(" + x + ", " + y + ", " + z + ")";
    }

    public static void main(String[] args) {
        Vector v1 = new Vector(1, 2, 3);
        Vector v2 = new Vector(4, 5, 6);
        System.out.println(v1.length());
        System.out.println(v1.cross(v2));
        System.out.println(v1.cosine(v2));
        System.out.println(v1.add(v2));
        System.out.println(v1.subtract(v2));
        for (Vector v : randomVectors(5)) {
            System.out.println(v);
        }
    }
}

