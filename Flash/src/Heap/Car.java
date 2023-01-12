package Heap;

public class Car implements Comparable<Car> {
	
	
	String name;
	int speed;
	String color;
	
	
	public Car(String name, int speed, String color) {
		super();
		this.name = name;
		this.speed = speed;
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	@Override
	public int compareTo(Car o) {
		
		return this.speed-o.speed;
	}
	@Override
	public String toString() {
		return "Car [name=" + name + ", speed=" + speed + ", color=" + color + "]";
	}
	
	
	

}
