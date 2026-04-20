package model;

public class BookingSeat {
	private int id;
    private int bookingId;
    private int seatId;

    // TODO: Constructor
    public BookingSeat() {
    }

    public BookingSeat(int id, int bookingId, int seatId) {
        this.id = id;
        this.bookingId = bookingId;
        this.seatId = seatId;
    }

    // TODO: Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getSeatId() {
        return seatId;
    }

    public void setSeatId(int seatId) {
        this.seatId = seatId;
    }
}