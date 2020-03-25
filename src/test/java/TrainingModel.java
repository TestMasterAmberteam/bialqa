

public class TrainingModel {
    private int maxParticipants;
    private String name;
    private String place;
    private int price;
    private String trainer;

    public int getMaxParticipants() {
        return maxParticipants;
    }

    public TrainingModel setMaxParticipants(int maxParticipants) {
        this.maxParticipants = maxParticipants;
        return this;
    }

    public String getName() {
        return name;
    }

    public TrainingModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getPlace() {
        return place;
    }

    public TrainingModel setPlace(String place) {
        this.place = place;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public TrainingModel setPrice(int price) {
        this.price = price;
        return this;
    }

    public String getTrainer() {
        return trainer;
    }

    public TrainingModel setTrainer(String trainer) {
        this.trainer = trainer;
        return this;
    }
}
