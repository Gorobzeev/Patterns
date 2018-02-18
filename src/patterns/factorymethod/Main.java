package patterns.factorymethod;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Creator creator = makeWatch("digital");
        Watch watch = creator.create();
        watch.showTime();
    }

    private static Creator makeWatch(String marker) {
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

interface Creator {
    Watch create();
}

class DigitalWatchCreator implements Creator {

    @Override
    public Watch create() {
        return new DigitalWatch();
    }
}

class RomeWatchCreator implements Creator {

    @Override
    public Watch create() {
        return new RomeWatch();
    }
}

