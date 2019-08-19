package rentalstore;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CustomerTest {

  @Test
  public void should_return_regular_statement_when_invoke_statement_given_movie_type_is_regular_and_day_rented_is_3() {
    Customer customer = new Customer("JOI");
    Movie movie = new Movie("BLADE RUNNER", 0);
    Rental rental = new Rental(movie, 3);
    customer.addRental(rental);

    String statement = customer.statement();
    String res = "Rental Record for JOI\n\tBLADE RUNNER\t3.5\nAmount owed is 3.5\nYou earned 1 frequent renter points";

    assertEquals(res, statement);
  }

  @Test
  public void should_return_regular_statement_when_invoke_statement_given_movie_type_is_regular_and_day_rented_is_1() {
    Customer customer = new Customer("JOI");
    Movie movie = new Movie("BLADE RUNNER", 0);
    Rental rental = new Rental(movie, 1);
    customer.addRental(rental);

    String statement = customer.statement();
    String res = "Rental Record for JOI\n\tBLADE RUNNER\t2.0\nAmount owed is 2.0\nYou earned 1 frequent renter points";

    assertEquals(res, statement);
  }

  @Test
  public void should_return_new_release_statement_when_invoke_statement_given_movie_type_is_new_release() {
    Customer customer = new Customer("JOI");
    Movie movie1 = new Movie("BLADE RUNNER", 0);
    Movie movie2 = new Movie("LALA LAND", 1);
    Rental rental1 = new Rental(movie1, 3);
    Rental rental2 = new Rental(movie2, 3);
    customer.addRental(rental1);
    customer.addRental(rental2);

    String statement = customer.statement();
    String res = "Rental Record for JOI\n\tBLADE RUNNER\t3.5\n\tLALA LAND\t9.0\nAmount owed is 12.5\nYou earned 3 frequent renter points";

    assertEquals(res, statement);
  }

  @Test
  public void should_return_children_statement_when_invoke_statement_given_movie_type_is_children_and_day_rented_is_4() {
    Customer customer = new Customer("JOI");
    Movie movie1 = new Movie("BLADE RUNNER", 0);
    Movie movie2 = new Movie("LALA LAND", 1);
    Movie movie3 = new Movie("HARRY POTTER", 2);
    Rental rental1 = new Rental(movie1, 3);
    Rental rental2 = new Rental(movie2, 3);
    Rental rental3 = new Rental(movie3, 4);
    customer.addRental(rental1);
    customer.addRental(rental2);
    customer.addRental(rental3);

    String statement = customer.statement();
    String res = "Rental Record for JOI\n\tBLADE RUNNER\t3.5\n\tLALA LAND\t9.0\n\tHARRY POTTER\t3.0\nAmount owed is 15.5\nYou earned 4 frequent renter points";

    assertEquals(res, statement);
  }

  @Test
  public void should_return_children_statement_when_invoke_statement_given_movie_type_is_children_and_day_rented_is_1() {
    Customer customer = new Customer("JOI");
    Movie movie1 = new Movie("BLADE RUNNER", 0);
    Movie movie2 = new Movie("LALA LAND", 1);
    Movie movie3 = new Movie("HARRY POTTER", 2);
    Rental rental1 = new Rental(movie1, 3);
    Rental rental2 = new Rental(movie2, 3);
    Rental rental3 = new Rental(movie3, 1);
    customer.addRental(rental1);
    customer.addRental(rental2);
    customer.addRental(rental3);

    String statement = customer.statement();
    String res = "Rental Record for JOI\n\tBLADE RUNNER\t3.5\n\tLALA LAND\t9.0\n\tHARRY POTTER\t1.5\nAmount owed is 14.0\nYou earned 4 frequent renter points";

    assertEquals(res, statement);
  }

  @Test
  public void should_return_empty_statement_when_invoke_statement_given_no_rental() {
    Customer customer = new Customer("JOI");

    String statement = customer.statement();
    String res = "Rental Record for JOI\nAmount owed is 0.0\nYou earned 0 frequent renter points";

    assertEquals(res, statement);
  }

  @Test
  public void should_return_empty_html_statement_when_invoke_statement_given_no_rental() {
    Customer customer = new Customer("JOI");

    String statement = customer.generateHtml();
    String res = "<H1>Rentals for <EM>JOI</EM></H1><P>\n</P>\n" +
        "<P>You owe<EM>0.0</EM><P>\n" +
        "On this rental you earned <EM>0</EM> frequent renter points<P>";

    assertEquals(res, statement);
  }

  @Test
  public void should_return_regular_html_statement_when_invoke_statement_given_movie_type_is_regular_and_day_rented_is_3() {
    Customer customer = new Customer("JOI");
    Movie movie = new Movie("BLADE RUNNER", 0);
    Rental rental = new Rental(movie, 3);
    customer.addRental(rental);

    String statement = customer.generateHtml();

    String res = "<H1>Rentals for <EM>JOI</EM></H1><P>\n" +
        "BLADE RUNNER: 3.5<BR></P>\n" +
        "<P>You owe<EM>3.5</EM><P>\n" +
        "On this rental you earned <EM>1</EM> frequent renter points<P>";
    assertEquals(res, statement);
  }

}
