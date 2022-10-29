package transport;
public class Bus extends Transport implements Competing {
    public enum Capacity {
        XS("До 10"),
        S("10-25"),
        M("40-50"),
        L("60-80"),
        XL("100-120");
        private final String stringCapacity;
        Capacity(String stringCapacity) {
            this.stringCapacity = stringCapacity;
        }
        public String getStringCapacity() {
            return stringCapacity;
        }
    }

    private Capacity capacity;

    public Bus(String brand, String model, Float engineVolume, String capacity) {
        super(brand, model, engineVolume);
        setCapacity(capacity);
    }
    public void printType() {
        if (capacity == null) {
            System.out.println("Тип не указан");
        } else {
            System.out.println("Вместимость " + capacity.getStringCapacity());
        }
    }

    private void setCapacity(String capacity) {
        if (capacity == null || capacity.isBlank()) this.capacity = null;
        else {
            switch (capacity.toLowerCase()) {
                case "до 10":
                    this.capacity = Capacity.XS;
                    break;
                case "10-25":
                    this.capacity = Capacity.S;
                    break;
                case "40-50":
                    this.capacity = Capacity.M;
                    break;
                case "60-80":
                    this.capacity = Capacity.L;
                    break;
                case "100-120":
                    this.capacity = Capacity.XL;
                    break;
                default:
                    this.capacity = null;
            }
        }
    }

    @Override

        public void startMove() {
            System.out.println("Начало движения автобуса");
        }

        @Override

            public void finishMove() {
                System.out.println("Конец движения автобуса");
            }

            @Override
            public void pitstop() {
                System.out.println("Автобус заправляют, меняют резину");
            }
            @Override
            public void bestTime() {
                System.out.println("Автобус, лучшее время");
            }
            @Override
            public void maxSpeed() {
                System.out.println("Автобус разгоняется до максимальной скорости");
            }

            @Override
            public boolean passTechnicalInspection() {
                throw new UnsupportedOperationException("в диагностике не нуждается");
            }
        }
