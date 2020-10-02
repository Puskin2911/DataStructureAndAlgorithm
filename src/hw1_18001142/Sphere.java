package hw1_18001142;

public class Sphere {
	double radius;
	double x_axis;
	double y_axis;
	double z_axis;
	
	public Sphere() {
	}
	
	public Sphere(double radius, double x_axis, double y_axis, double z_axis) {
		super();
		this.radius = radius;
		this.x_axis = x_axis;
		this.y_axis = y_axis;
		this.z_axis = z_axis;
	}
	
	public double area() {	
		return 4 * Math.PI * radius * radius;
		
	}
	
	public double volum() {
		return Math.PI * Math.pow(radius, 3) * 4 / 3;
	}
	
	public boolean check_intersect(Sphere sphere) {
		double distance = Math.sqrt((x_axis - sphere.x_axis)*(x_axis - sphere.x_axis)
				+ (y_axis - sphere.y_axis)*y_axis - sphere.y_axis
				+ (z_axis - sphere.z_axis)*(z_axis - sphere.z_axis));
		
		if(distance <= radius + sphere.radius && distance >= Math.abs(radius) - sphere.radius) return true;
		else return false;
	}
	
	public static boolean check_bounded(Sphere first, Sphere second) {
		double distance = Math.sqrt(Math.pow(first.x_axis - second.x_axis, 2)
				+ Math.pow(first.y_axis - second.y_axis, 2)
				+ Math.pow(first.z_axis - second.z_axis, 2));
		
		if(distance < Math.abs(first.radius - second.radius)) {
			return true;
		}
		else return false;
	}
}
