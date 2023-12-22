package java.domain.model.users;

public class RequestDB {
    private int id;
    private int trainerId;
    private int clientId;
    private RequestStatus status;

    public RequestDB() {
        this.id = 0;
        this.trainerId = 0;
        this.clientId = 0;
        this.status = RequestStatus.UNCHECKED;
    }

    public RequestDB(int id, int trainerId, int clientId, RequestStatus status) {
        this.id = id;
        this.trainerId = trainerId;
        this.clientId = clientId;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public int getTrainerId() {
        return trainerId;
    }

    public int getClientId() {
        return clientId;
    }

    public RequestStatus getStatus() {
        return status;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setStatus(RequestStatus status) {
        this.status = status;
    }
}
