package transport;
public class Car extends Transport implements Competing {
    public enum BodyType {
        SEDAN("Седан"),
        HATCHBACK("Хэтчбек"),
        COUPE("Купе"),
        UNIVERSAL("Универсал"),
        CROSSOVER("Кроссовер"),
        SUV("Внедорожник"),
        PICKUP("Пикап"),
        VAN("Фургон"),
        MINIVAN("Минивэн");
        private final String stringBodyType;
        BodyType(String stringBodyType) {
            this.stringBodyType = stringBodyType;
        }
        public String getStringBodyType() {
            return stringBodyType;
        }
    }
    private BodyType bodyType;
    public Car(String brand, String model, Float engineVolume, String bodyType) {
        super(brand, model, engineVolume);
        setBodyType(bodyType);
    }
    public BodyType getBodyType() {
        return bodyType;
    }
    public void printType() {
        if (bodyType == null) {
            System.out.println("Тип не указан");
        } else {
            System.out.println("Это " + bodyType.getStringBodyType());
        }
    }
    void setBodyType(String bodyType) {
        if (bodyType == null || bodyType.isBlank()) this.bodyType = null;
        else {
            switch (bodyType.toLowerCase()) {
                case "седан":
                    this.bodyType = BodyType.SEDAN;
                    break;
                case "хэтчбек":
                    this.bodyType = BodyType.HATCHBACK;
                    break;
                case "купе":
                    this.bodyType = BodyType.COUPE;
                    break;
                case "универсал":
                    this.bodyType = BodyType.UNIVERSAL;
                    break;
                case "кроссовер":
                    this.bodyType = BodyType.CROSSOVER;
                    break;
                case "внедорожник":
                    this.bodyType = BodyType.SUV;
                    break;
                case "пикап":
                    this.bodyType = BodyType.PICKUP;
                    break;
                case "фургон":
                    this.bodyType = BodyType.VAN;
                    break;
                case "минивэн":
                    this.bodyType = BodyType.MINIVAN;
                    break;
                default:
                    this.bodyType = null;
            }
        }
    }

    @Override

        public void startMove() {
            System.out.println("Начало движения а/м");
        }

        @Override

            public void finishMove() {
                System.out.println("Конец движения а/м");
            }

            @Override
            public void pitstop() {
                System.out.println("А/м заправляют, меняют резину");
            }
            @Override
            public void bestTime() {
                System.out.println("А/м, лучшее время");
            }
            @Override
            public void maxSpeed() {
                System.out.println("А/м разгоняется до максимальной скорости");
            }


            @Override
            public boolean passTechnicalInspection() {
                return (int) (Math.random() * 100) != 2 && (int) (Math.random() * 100) != 55;
            }
        }
