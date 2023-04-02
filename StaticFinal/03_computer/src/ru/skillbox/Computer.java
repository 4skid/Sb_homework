package ru.skillbox;

public class Computer {
    private final String vendor;
    private final String name;
    private Processor processor;
    private RAM ram;
    private Keyboard keyboard;
    private Drive drive;
    private Display display;

    public Computer(String vendor, String name) {
        this.vendor = vendor;
        this.name = name;
        this.processor = new Processor(3000,8,"Intel",200);
        this.ram = new RAM(RAMType.DDR2,3200, 25);
        this.keyboard = new Keyboard(KeyboardType.Безпроводная,true, 300);
        this.drive = new Drive(DriveType.SSD,1000, 400);
        this.display = new Display(23,DisplayType.PL,500);
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public Processor getProcessor() {
        return processor;
    }

    public void setProcessor(Processor processor) {
        this.processor = processor;
    }

    public RAM getRam() {
        return ram;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }

    public Drive getDrive() {
        return drive;
    }

    public void setDrive(Drive drive) {
        this.drive = drive;
    }

    public Display getDisplay() {
        return display;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "Компьютер\n" +
                "Производитель: " + getVendor() +
                "\nМодель: " + getName() +
                "\n" + processor +
                "\n" + drive +
                "\n" + ram +
                "\n" + display +
                "\n" + keyboard +
                "\nОбщий вес комплектующих: " + getTotalWeight();
    }

    public int getTotalWeight(){
        return  processor.getWeight() + drive.getWeight() +
                ram.getWeight() + display.getWeight() + keyboard.getWeight();
    }
}
