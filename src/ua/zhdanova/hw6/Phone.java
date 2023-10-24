package ua.zhdanova.hw6;

public class Phone {
    String number;
     String model;
     double weight;

    public Phone(String number, String model, double weight) {
        this.number = number;
        this.model = model;
        this.weight = weight;
    }

    public Phone(String number, String model) {
        this.number = number;
        this.model = model;
    }

    public Phone() {
    }

    public void receiveCall(String name) {

        System.out.println("Телефонує " + name);
    }

    public String getNumber() {

        return number;
    }

    @Override
    public String toString() {
        return "Phone{" + "number=" + number + ", model='" + model + '\'' + ", weight=" + weight + '}';
    }

    public static void main(String[] args) {
        Phone phone1 = new Phone();
        phone1.number = "0957958753";
        phone1.model = "iPhone";
        phone1.weight = 100.0;
        Phone phone2 = new Phone("0987654321", "Samsung", 150.5);
        Phone phone3 = new Phone("0957958444", "Huawei");
        phone3.weight = 120.0;

        System.out.println(phone1);
        System.out.println(phone2);
        System.out.println(phone3);

        phone1.receiveCall("Оля");
        System.out.println("Phone1 number: " + phone1.getNumber());

        phone2.receiveCall("Катя");
        System.out.println("Phone2 number: " + phone2.getNumber());

        phone3.receiveCall("Віктор");
        System.out.println("Phone3 number: " + phone3.getNumber());
    }
}