package braveprogrammerapp.braveprogrammer.sevices;

import braveprogrammerapp.braveprogrammer.exception.AppException;
import braveprogrammerapp.braveprogrammer.model.request.VictimRequest;
import braveprogrammerapp.braveprogrammer.services.CalculateAverageService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class CalculateAverageServiceTest {
    @Autowired
    private CalculateAverageService calculateAverageService;

    @Test
    public void testSuccessCalculateWithCorrectNumbers() {
        VictimRequest victimA = new VictimRequest();
        victimA.setAgeAtDeath(10);
        victimA.setYearOfDeath(12);

        VictimRequest victimB = new VictimRequest();
        victimB.setAgeAtDeath(12);
        victimB.setYearOfDeath(14);

        Double actual = calculateAverageService.calculateAverageVictim(victimA, victimB);
        Assertions.assertEquals(2.0, actual);
    }

    @Test
    public void testErrorWhenVictimAAgeAtDeathIsNegativeValue() {
        VictimRequest victimA = new VictimRequest();
        victimA.setAgeAtDeath(-10);
        victimA.setYearOfDeath(12);

        VictimRequest victimB = new VictimRequest();
        victimB.setAgeAtDeath(2);
        victimB.setYearOfDeath(14);

        Exception exception = Assertions.assertThrows(AppException.class, () -> {
            calculateAverageService.calculateAverageVictim(victimA, victimB);
        });

        Assertions.assertEquals("-1", exception.getMessage());
    }

    @Test
    public void testErrorWhenVictimAYearOfDeathIsNegativeValue() {
        VictimRequest victimA = new VictimRequest();
        victimA.setAgeAtDeath(10);
        victimA.setYearOfDeath(-12);

        VictimRequest victimB = new VictimRequest();
        victimB.setAgeAtDeath(2);
        victimB.setYearOfDeath(14);

        Exception exception = Assertions.assertThrows(AppException.class, () -> {
            calculateAverageService.calculateAverageVictim(victimA, victimB);
        });

        Assertions.assertEquals("-1", exception.getMessage());
    }

    @Test
    public void testErrorWhenVictimBAgeAtDeathIsNegativeValue() {
        VictimRequest victimA = new VictimRequest();
        victimA.setAgeAtDeath(-10);
        victimA.setYearOfDeath(12);

        VictimRequest victimB = new VictimRequest();
        victimB.setAgeAtDeath(-2);
        victimB.setYearOfDeath(14);

        Exception exception = Assertions.assertThrows(AppException.class, () -> {
            calculateAverageService.calculateAverageVictim(victimA, victimB);
        });

        Assertions.assertEquals("-1", exception.getMessage());
    }

    @Test
    public void testErrorWhenVictimBYearOfDeathIsNegativeValue() {
        VictimRequest victimA = new VictimRequest();
        victimA.setAgeAtDeath(10);
        victimA.setYearOfDeath(12);

        VictimRequest victimB = new VictimRequest();
        victimB.setAgeAtDeath(2);
        victimB.setYearOfDeath(-14);

        Exception exception = Assertions.assertThrows(AppException.class, () -> {
            calculateAverageService.calculateAverageVictim(victimA, victimB);
        });

        Assertions.assertEquals("-1", exception.getMessage());
    }

    @Test
    public void testErrorWhenVictimAYearOfDeathIsLessThanAgeOfDeath() {
        VictimRequest victimA = new VictimRequest();
        victimA.setAgeAtDeath(12);
        victimA.setYearOfDeath(1);

        VictimRequest victimB = new VictimRequest();
        victimB.setAgeAtDeath(1);
        victimB.setYearOfDeath(14);

        Exception exception = Assertions.assertThrows(AppException.class, () -> {
            calculateAverageService.calculateAverageVictim(victimA, victimB);
        });

        Assertions.assertEquals("-1", exception.getMessage());
    }

    @Test
    public void testErrorWhenVictimBYearOfDeathIsLessThanAgeOfDeath() {
        VictimRequest victimA = new VictimRequest();
        victimA.setAgeAtDeath(10);
        victimA.setYearOfDeath(12);

        VictimRequest victimB = new VictimRequest();
        victimB.setAgeAtDeath(12);
        victimB.setYearOfDeath(10);

        Exception exception = Assertions.assertThrows(AppException.class, () -> {
            calculateAverageService.calculateAverageVictim(victimA, victimB);
        });

        Assertions.assertEquals("-1", exception.getMessage());
    }
}
