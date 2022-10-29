package transport;
public class Truck extends Transport implements Competing {
    public enum LoadCapacity {
        N1("До 3.5"),
        N2("3.5-12"),
        N3("Больше 12");
        private final String stringLoadCapacity;
        LoadCapacity(String stringCapacity) {
            this.stringLoadCapacity = stringCapacity;
        }
        public String getStringCapacity() {
            return stringLoadCapacity;
        }
    }
    private LoadCapacity loadCapacity;
    public Truck(String brand, String model, Float engineVolume, String capacity) {
        super(brand, model, engineVolume);
        setLoadCapacity(capacity);
    }
    public void printType() {
        if (loadCapacity == null) {
            System.out.println("Тип не указан");
        } else {
            System.out.println("Грузоподъемность " + loadCapacity.getStringCapacity());
        }
    }
    private void setLoadCapacity(String loadCapacity) {
        if (loadCapacity == null || loadCapacity.isBlank()) this.loadCapacity = null;
        else {
            switch (loadCapacity.toLowerCase()) {
                case "до 3.5":
                    this.loadCapacity = LoadCapacity.N1;
                    break;
                case "3.5-12":
                    this.loadCapacity = LoadCapacity.N2;
                    break;
                case "больше 12":
                    this.loadCapacity = LoadCapacity.N3;
                    break;
                default:
                    this.loadCapacity = null;
            }
        }
    }

    @Override
    public void startMove() {
        System.out.println("Начало движения грузовика");
    }

    @Override
    public void finishMove() {
        System.out.println("Конец движения грузовика");
    }

    @Override
    public void pitstop() {
        System.out.println("Грузовик заправляют, меняют резину");
    }
    @Override
    public void bestTime() {
        System.out.println("Грузовик, лучшее время");
    }
    @Override
    public void maxSpeed() {
        System.out.println("Грузовик разгоняется до максимальной скорости");
    }

    @Override
    public boolean passTechnicalInspection() {
        return (int) (Math.random() * 100) != 90 && (int) (Math.random() * 100) != 96;
    }
}
