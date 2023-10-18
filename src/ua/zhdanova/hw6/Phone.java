package ua.zhdanova.hw6;
    // а)
    public class Phone {
        String number;
        String model;
        double weight;
        // б)
        public Phone(String number, String model, double weight) {
            this.number = number;
            this.model = model;
            this.weight = weight;
        }
        // в)
        public Phone(String number, String model) {
            this.number = number;
            this.model = model;
        }
        // г)
        public Phone() {
        }
        // и)
        public void receiveCall(String name) {
            System.out.println("Телефонує " + name);
        }
        public String getNumber() {
            return number;
        }
        public static void main(String[] args) {
            // д)
            Phone phone1 = new Phone("0957958753", "iPhone", 100.0);
            Phone phone2 = new Phone("0987654321", "Samsung", 150.50);
            Phone phone3 = new Phone("0957958444", "Huawei", 120.0);
            // ж)
            /*Phone myPhone1 = new Phone();
            myPhone1.number = "0957958753";
            myPhone1.model = "iPhone";
            myPhone1.weight = 100.0;
            Phone myPhone2 = new Phone();
            myPhone2.number = "0987654321";
            myPhone2.model = "Samsung";
            myPhone2.weight = 150.50;
            Phone myPhone3 = new Phone();
            myPhone3.number = "0957958444";
            myPhone3.model = "Huawei";
            myPhone3.weight = 120.00;*/
            // з)
            System.out.println("Phone1: " + phone1.number + ", " + phone1.model + ", " + phone1.weight);
            System.out.println("Phone2: " + phone2.number + ", " + phone2.model + ", " + phone2.weight);
            System.out.println("Phone3: " + phone3.number + ", " + phone3.model + ", " + phone3.weight);

            phone1.receiveCall("Оля");
            System.out.println("Phone1 number: " + phone1.getNumber());

            phone2.receiveCall("Катя");
            System.out.println("Phone2 number: " + phone2.getNumber());

            phone3.receiveCall("Віктор");
            System.out.println("Phone3 number: " + phone3.getNumber());
        }
    }