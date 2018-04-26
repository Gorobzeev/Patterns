package patterns.abstractfacroty;

public class Main {

    private static Application configureApplication() {
        Application app;
        GuiFactory factory;
        String osName = System.getProperty("os.name").toLowerCase();
        System.out.println(osName);
        if (osName.contains("linux")) {
            factory = new MacFactory();
            app = new Application(factory);
        } else {
            factory = new WindowFactory();
            app = new Application(factory);
        }
        return app;
    }

    public static void main(String[] args) {
        Application app = configureApplication();
        app.paint();
    }

}

class Application {
    private Button button;
    private CheckBox checkbox;

    Application(GuiFactory factory) {
        button = factory.createButton();
        checkbox = factory.createCheckBox();
    }

    public void paint() {
        button.createButton();
        checkbox.createCheckbox();
    }
}

interface Button {
    void createButton();
}

interface CheckBox {
    void createCheckbox();
}

class WindowButton implements Button {

    @Override
    public void createButton() {
        System.out.println("Create window Button");
    }
}

class MacButton implements Button {

    @Override
    public void createButton() {
        System.out.println("Create max Button");
    }
}

class WindowCheckBox implements CheckBox {

    @Override
    public void createCheckbox() {
        System.out.println("Create window checkbox");
    }
}


class MacCheckBox implements CheckBox {

    @Override
    public void createCheckbox() {
        System.out.println("Create mac checkbox");
    }
}

interface GuiFactory{
    Button createButton();
    CheckBox createCheckBox();
}

class WindowFactory implements GuiFactory{

    @Override
    public Button createButton() {
        return new WindowButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new WindowCheckBox();
    }
}

class MacFactory implements GuiFactory {

    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public CheckBox createCheckBox() {
        return new MacCheckBox();
    }
}




