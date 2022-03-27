package hotelreservation.entities;

import hotelreservation.controllers.*;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import static org.junit.Assert.*;

public class HotelTest {
   private HotelControllerMock hotelController;

   @Before
   public void setUp()
   {
      hotelController = HotelControllerMock.getInstance();
   }

   @After
   public void tearDown()
   {
      hotelController = null;
   }

   @Test
   public void testGetId()
   {
      assertEquals((Integer)1, hotelController.getHotelByID(1).getId());
      assertEquals((Integer)2, hotelController.getHotelByID(2).getId());
      assertEquals((Integer)3, hotelController.getHotelByID(3).getId());
   }

   @Test
   public void testGetName()
   {
      assertEquals("Rangá", hotelController.getHotelByID(1).getName());
      assertEquals("Hilton", hotelController.getHotelByID(2).getName());
      assertEquals("Ölfus", hotelController.getHotelByID(3).getName());
   }

   @Test
   public void testGetPriceRating()
   {
      assertEquals((Integer)3, hotelController.getHotelByID(1).getPriceRating());
      assertEquals((Integer)4, hotelController.getHotelByID(2).getPriceRating());
      assertEquals((Integer)5, hotelController.getHotelByID(3).getPriceRating());
   }
}
