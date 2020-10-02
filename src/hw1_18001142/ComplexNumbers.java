package hw1_18001142;

import java.util.Scanner;

public class ComplexNumbers {
	Scanner scanner = new Scanner(System.in);
	double real;
	double img;
	
	public ComplexNumbers() {
	}
	
	public ComplexNumbers(double real, double img) {
		this.real = real;
		this.img = img;
	}
	
	public void input() {
		this.real = scanner.nextDouble();
		this.img = scanner.nextDouble();
	}
	
	public String toString() {
		return this.real + " + " + this.img + "i";
	}
	
	public ComplexNumbers add(ComplexNumbers[] complexs) {
		double real = this.real;
		double img = this.img;
		for(ComplexNumbers complex : complexs) {
			real += complex.real;
			img += complex.img;
		}
		
		return new ComplexNumbers(real, img);
		
	}
	
	public ComplexNumbers mutil(ComplexNumbers[] complexs) {
		double real = this.real;
		double img = this.img;
		
		for(ComplexNumbers complex : complexs) {
			double temp_real = real;
			double temp_img = img;
			real += temp_real * complex.real - temp_img * complex.img;
			img += temp_real * complex.img + temp_img * complex.real;
		}
		
		return new ComplexNumbers(real, img);
	}
	
	public static void main(String[] args) {
		ComplexNumbers complex = new ComplexNumbers();
		complex.input();
		System.out.println(complex.toString());
	}
}
