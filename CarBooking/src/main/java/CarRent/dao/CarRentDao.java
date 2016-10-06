package CarRent.dao;

import CarRent.entity.BookingData;


public interface CarRentDao {
    BookingData readCarList();
    void saveCarList(BookingData carList); 
}
