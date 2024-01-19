package ua.zhdanova.hw21.builder;

public class Computer {
    private String processor;
    private int ramSize;
    private int storageCapacity;
    private String videoCard;
    private boolean isActive;

    public Computer(Builder builder) {
        this.processor = builder.processor;
        this.ramSize = builder.ramSize;
        this.storageCapacity = builder.storageCapacity;
        this.videoCard = builder.videoCard;
        this.isActive = builder.isActive;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "processor='" + processor + '\'' +
                ", ramSize=" + ramSize +
                ", storageCapacity=" + storageCapacity +
                ", videoCard='" + videoCard + '\'' +
                ", isActive=" + isActive +
                '}';
    }

    public static class Builder {
        private String processor;
        private int ramSize;
        private int storageCapacity;
        private String videoCard;
        private boolean isActive;

        public Builder(String processor, int ramSize, int storageCapacity, String videoCard, boolean isActive) {
            this.processor = processor;
            this.ramSize = ramSize;
            this.storageCapacity = storageCapacity;
            this.videoCard = videoCard;
            this.isActive = isActive;
        }

        public void setProcessor(String processor) {
            this.processor = processor;
        }

        public void setRamSize(int ramSize) {
            this.ramSize = ramSize;
        }

        public void setStorageCapacity(int storageCapacity) {
            this.storageCapacity = storageCapacity;
        }

        public void setVideoCard(String videoCard) {
            this.videoCard = videoCard;
        }

        public void setActive(boolean active) {
            isActive = active;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
