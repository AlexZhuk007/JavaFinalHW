package sem6.HW;


import java.util.Objects;


public class Laptop {
    private String brand;
    private String os;
    private int ram;
    private int hdd;
    private String processor;
    private String color;

    public Laptop(String brand, String os, int ram, int hdd, String processor, String color) {
        this.brand = brand;
        this.os = os;
        this.ram = ram;
        this.hdd = hdd;
        this.processor = processor;
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public String getOs() {
        return os;
    }

    public int getRam() {
        return ram;
    }

    public int getHdd() {
        return hdd;
    }

    public String getProcessor() {
        return processor;
    }

    public String getColor() {
        return color;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "brand='" + brand + '\'' +
                ", os='" + os + '\'' +
                ", ram=" + ram +
                ", hdd=" + hdd +
                ", processor='" + processor + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Laptop laptop = (Laptop) o;
        return ram == laptop.ram &&
                hdd == laptop.hdd &&
                Objects.equals(brand, laptop.brand) &&
                Objects.equals(os, laptop.os) &&
                Objects.equals(processor, laptop.processor) &&
                Objects.equals(color, laptop.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, os, ram, hdd, processor, color);
    }
}
