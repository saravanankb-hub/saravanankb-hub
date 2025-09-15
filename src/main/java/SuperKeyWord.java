class SuperKeyWord {
    SuperKeyWord(String name) {
        System.out.println("From Parent class:" + name);
    }
}

class Dog extends SuperKeyWord {
    Dog() {
        super("Chuzu");
        System.out.println("Dog constructor called");
    }

    public static void main(String[] args) {
        Dog dog = new Dog();
    }
}
