package domain.model.users;

public class Request {
    private int id;
    private User trainer;
    private User client;
    private RequestStatus status;

    public Request() {
        this.id = 0;
        this.trainer = new User();
        this.client = new User();
        this.status = RequestStatus.UNCHECKED;
    }

    public Request(int id, User trainer, User client, RequestStatus status) {
        this.id = id;
        this.trainer = trainer;
        this.client = client;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public User getTrainer() {
        return trainer;
    }

    public User getClient() {
        return client;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTrainer(User trainer) {
        this.trainer = trainer;
    }

    public void setClient(User client) {
        this.client = client;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}
