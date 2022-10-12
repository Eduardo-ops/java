package tratamentodeexcecoes.aula06.excecoespersonalizadas.model.entities;

import tratamentodeexcecoes.aula06.excecoespersonalizadas.model.exceptions.DomainReservationException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {

    private Integer roomNumber;
    private Date checkIn;
    private Date checkOut;

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");

    public Reservation(Integer roomNumber, Date checkIn, Date checkOut) throws DomainReservationException {

        /*
         * Programação defensiva, muito utilizado para já realizar o tratamento de exceções
         * logo no início do trabalho com o objeto.
         * */
        if (!checkOut.after(checkIn)) {
            throw new DomainReservationException("Error in reservation: Check-out date must be after check-in date");
        }
        this.roomNumber = roomNumber;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    public Long duration() {
        long diff = checkOut.getTime() - checkIn.getTime();
        return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
    }

    public void updateDates(Date checkIn, Date checkOut) throws DomainReservationException {

        Date current = new Date();

        if (checkIn.before(current) || checkOut.before(checkOut)) {
            throw new IllegalArgumentException("Reservation dates for update must be future dates.");
        }
        if (!checkOut.after(current)) {
            throw new DomainReservationException("Error in reservation: Check-out date must be after check-in date");
        }
        this.checkIn = checkIn;
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "Room "
                + roomNumber
                + ", checkin:"
                + simpleDateFormat.format(checkIn)
                + ", checkout: "
                + simpleDateFormat.format(checkOut)
                + " "
                + duration()
                + " nights";
    }

    public Integer getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(Integer roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Date getCheckin() {
        return checkIn;
    }

    public Date getCheckout() {
        return checkOut;
    }
}
