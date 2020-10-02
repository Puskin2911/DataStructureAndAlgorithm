package hw3_18001142;

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
		for (Complex complex : complexes) {
			real += complex.real;
			image += complex.image;
		}

		return new Complex(real, image);
	}

	public Complex time(Complex[] complexes) {
		float real = this.real;
		float image = this.image;

		for (Complex complex : complexes) {
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
		return new Complex(real * c.real - image * c.image, real * c.image + image * c.real);
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
}
