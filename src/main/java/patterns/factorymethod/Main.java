package patterns.factorymethod;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Factory fac = new RomeWatchCreator();
        Watch watch1 = fac.create();


        Factory factory = makeWatch("digital");
        Watch watch = factory.create();
        watch.showTime();
    }

    private static Factory makeWatch(String marker) {
        switch (marker) {
            case "digital":
                return new DigitalWatchCreator();
            case "rome":
                return new RomeWatchCreator();
            default:
                throw new RuntimeException("Error type watch");
        }
    }
}

interface Watch {
    void showTime();
}

class DigitalWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println(new Date());
    }
}

class RomeWatch implements Watch {

    @Override
    public void showTime() {
        System.out.println("XXVII");
    }
}

interface Factory {
    Watch create();
}

class DigitalWatchCreator implements Factory {

    @Override
    public Watch create() {
        return new DigitalWatch();
    }
}

class RomeWatchCreator implements Factory {

    @Override
    public Watch create() {
        return new RomeWatch();
    }
}

