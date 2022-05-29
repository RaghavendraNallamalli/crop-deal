package com.example.demo;

import com.controller.DealerController;
import com.model.Dealer;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import static java.lang.Boolean.TRUE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

class DealerControllerTest {

    @InjectMocks
    public com.controller.DealerController DealerController= Mockito.mock(DealerController.class);


    //Creating A Dealer
    String[] a ;
    Dealer F  = new Dealer("1","ragha","nall","power",new Date(),"ragh@gmail.com","R STReet",
            94l,"123",TRUE,a);

    public List<Dealer> getlist(){
        // Creating A Dealer List
        List<Dealer> testDealers = new ArrayList<Dealer>();
        testDealers.add(F);      // adding a Dealer
        Dealer s = new Dealer("2","ragha","nall","power",new Date(),"ragh@gmail.com","R STReet",
                94l,"123",TRUE,a);
        testDealers.add(s);
        return (testDealers);    //generating & Returning Response
    }
    @Test
    void getDealers() {
        List<Dealer> Response = getlist() ;
        when(DealerController.getDealers()).thenReturn(Response);               //  Setting The Response
        // Getting The Response
        List<Dealer>  result = DealerController.getDealers();
        assertThat(result).isEqualTo(Response);
        assertThat(result).isNotEqualTo(null);
    }

    @Test
    void findById() {
        List<Dealer> f = getlist();
        Dealer f1 = f.stream()
                .filter(Dealer -> "2".equals(Dealer.getId()))
                .findAny().orElse(null);
        assertThat(f1).isNotSameAs(F);
        assertThat(f1.getId()).isNotNull();
    }



    @Test
    void addDealer() {
        Dealer s = new Dealer("2", "ragha", "nall", "power", new Date(), "ragh@gmail.com", "R STReet",
                94l, "123", TRUE, a);
        when(DealerController.addDealer(s)).thenReturn(s);
        when(DealerController.addDealer(F)).thenReturn(null);
        Dealer result1 = DealerController.addDealer(F);
        Dealer result = DealerController.addDealer(s);
        assertThat(result).isEqualTo(s);
        assertThat(result1).isNull();
    }



    @Test
    void updateDealer() {
        Dealer s = new Dealer("2","ragha","nall","power",new Date(),"ragh@gmail.com","R STReet",
                94l,"123",TRUE,a);
        when(DealerController.updateDealer(s)).thenReturn(s);
        when(DealerController.updateDealer(F)).thenReturn(null);
        Dealer result1 = DealerController.updateDealer(F);
        Dealer result = DealerController.updateDealer(s);
        assertThat(result).isEqualTo(s);
        assertThat(result1).isNull();
        assertThat(result).isNotEqualTo(F);
    }

    @Test
    void deleteDealer() {
        when(DealerController.deleteDealer("1")).thenReturn("Deleted SuccessFully");
        when(DealerController.deleteDealer("2")).thenReturn("NOT_FOUND");
        String result1 = DealerController.deleteDealer("1");
        String result = DealerController.deleteDealer("2");
        assertThat(result1).isEqualTo("Deleted SuccessFully");
        assertThat(result).isEqualTo("NOT_FOUND");
    }

    @Test
    void dealerExits() {
        List<Dealer> f = getlist();
        Dealer f1 = f.stream()
                .filter(Dealer -> "1".equals(Dealer.getId()))
                .findAny().orElse(null);
        assertThat(f1.toString()).isEqualTo(F.toString());
        assertThat(f1.getId()).isEqualTo("1");
    }
}