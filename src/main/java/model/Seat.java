package model;

public class Seat {
	private int id;
    private int airplaneId;
    private String seatNumber;
    private String seatClass;
    private String seatStatus;

    public Seat() {
    }

    public Seat(int id, int airplaneId, String seatNumber, String seatClass, String seatStatus) {
        this.id = id;
        this.airplaneId = airplaneId;
        this.seatNumber = seatNumber;
        this.seatClass = seatClass;
        this.seatStatus = seatStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getSeatClass() {
        return seatClass;
    }

    public void setSeatClass(String seatClass) {
        this.seatClass = seatClass;
    }

    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String seatStatus) {
        this.seatStatus = seatStatus;
    }
}
