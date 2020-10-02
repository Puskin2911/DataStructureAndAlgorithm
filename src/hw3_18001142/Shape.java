package hw3_18001142;

import java.util.ArrayList;
import java.util.Random;

public abstract class Shape {
	protected String name;

	protected abstract double getArea();

	protected void setName(String name) {
		this.name = name;
	}

	protected String getName() {
		return this.name;
	}

	public static ArrayList<Circle> maxCircle(ArrayList<Shape> shapes) {
		ArrayList<Circle> circles = new ArrayList<Circle>();
		// Create a circle have radius = 0
		Circle circle = new Circle(0);

		// Find max
		for (Shape shape : shapes) {
			if (shape.getClass().getSimpleName().equals("Circle") && shape.getArea() > circle.getArea()) {
				circle = (Circle) shape;
			}
		}

		// Find all value equal max
		for (Shape shape : shapes) {
			if (shape.getClass().getSimpleName().equals("Circle") && shape.getArea() == circle.getArea()) {
				circles.add((Circle) shape);
			}
		}

		return circles;
	}

	public static void main(String[] args) {
		int length = 15;
		Shape[] shapes = new Shape[length];
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			int r = random.nextInt(3);
			double k = random.nextDouble() * 20;
			if (r == 1)
				shapes[i] = new Circle(k);
			else if (r == 2)
				shapes[i] = new Rectangle(r, k);
			else
				shapes[i] = new Sphere(k);
		}

		for (int i = 0; i < length; i++) {
			System.out.println(shapes[i].getClass().getSimpleName());
			System.out.println("Area: " + shapes[i].getArea());
			if (shapes[i] instanceof Circle) {
				System.out.println("Perimeter: " + ((Circle) shapes[i]).getPerimeter());
			} else if (shapes[i] instanceof Rectangle) {
				System.out.println("Perimeter: " + ((Rectangle) shapes[i]).getPerimeter());
			} else {
				System.out.println("Volume: " + ((Sphere) shapes[i]).getVolume());
			}
		}
	}
}

class Circle extends Shape {
	private double radius = 0;

	public Circle(double radius) {
		this.radius = radius;
	}

	@Override
	public double getArea() {
		return Math.PI * radius * radius;
	}

	public double getPerimeter() {
		return Math.PI * 2 * radius;
	}
}

class Sphere extends Shape {
	private double radius = 0;

	public Sphere(double radius) {
		this.radius = radius;
	}

	public double getVolume() {
		return Math.PI * Math.pow(radius, 3) * 4 / 3;
	}

	@Override
	public double getArea() {
		return 4 * Math.PI * radius * radius;
	}
}

class Rectangle extends Shape {
	private double width = 0;
	private double height = 0;

	public Rectangle(double width, double height) {
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return width * height;
	}

	public double getPerimeter() {
		return (width + height) * 2;
	}
}
