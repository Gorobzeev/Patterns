package patterns.builder;

public class Main {

    public static void main(String[] args) {
        Car bmw = new CarBuilder()
                .setSpeedCar(120)
                .setBrandCar("BMW")
                .build();
    }
}

class Car {
    private int speed;
    private String brand;

    Car(int speed, String brand) {
        this.speed = speed;
        this.brand = brand;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Car{");
        sb.append("speed=").append(speed);
        sb.append(", brand='").append(brand).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

class CarBuilder {
    private int speed;
    private String brand;

    CarBuilder() {
    }

    public CarBuilder setSpeedCar(int speed) {
        this.speed = speed;
        return this;
    }

    public CarBuilder setBrandCar(String brand) {
        this.brand = brand;
        return this;
    }

    public Car build() {
        return new Car(this.speed, this.brand);
    }

}