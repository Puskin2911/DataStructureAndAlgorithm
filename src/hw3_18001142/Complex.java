package hw3_18001142;

import java.util.Scanner;

import hw1_18001142.ComplexNumbers;

public class Complex {
	private float real;
	private float image;

	public Complex(float real, float image) {
		this.real = real;
		this.image = image;
	}

	public Complex add(Complex c) {
		return new Complex(real + c.real, image + c.image);
	}
	
	public Complex add(Complex[] complexes) {
		float real = this.real;
		float image = this.image;
		for(Complex complex : complexes) {
			real += complex.real;
			image += complex.image;
		}
		
		return new Complex(real, image);
	}
	
	public Complex time(Complex[] complexes) {
		float real = this.real;
		float image = this.image;
		
		for(Complex complex : complexes) {
			float temp_real = real;
			float temp_image = image;
			real += temp_real * complex.real - temp_image * complex.image;
			image += temp_real * complex.image + temp_image * complex.real;
		}
		
		return new Complex(real, image);
	}


	public Complex minus(Complex c) {
		return new Complex(real - c.real, image - c.image);
	}

	public Complex time(Complex c) {
		return new Complex(real * c.real - image * c.image,
				real * c.image + image * c.real);
	}

	public float realpart() {
		return real;
	}

	public float imagepart() {
		return image;
	}

	@Override
	public String toString() {
		return real + " + " + image + "i";
	}
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int v = scanner.nextInt();
		Complex[] complexes = new Complex[n];
		
		Complex sum = new Complex(0, 0);
		for(int i = 0; i < n; i++) {
			float real = scanner.nextFloat();
			float image = scanner.nextFloat();
			
			complexes[i] = new Complex(real, image);
			sum = sum.add(complexes[i]);
		}
		
		System.out.println("Complex at " + v + ": " + complexes[v - 1]);
		System.out.println("Sum: " + sum.toString());
		
		// More Feature: add(complexes[]), time(complexes[])
		// And more Feature correspond minus(complexes[])
		// Add new Operation Division
		// ===> Small Calculator Application: 
		//		+ Desktop Application using Java Swing or JavaFX to build
		//		+ Web Application using Jsp + Servlet Or Spring FrameWork
		//      Well Done! Hello Every Body! Hulk was here!
	}
}
