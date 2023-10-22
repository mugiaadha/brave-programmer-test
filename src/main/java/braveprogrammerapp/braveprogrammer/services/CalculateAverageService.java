package braveprogrammerapp.braveprogrammer.services;

import braveprogrammerapp.braveprogrammer.exception.AppException;
import braveprogrammerapp.braveprogrammer.model.request.VictimRequest;
import org.springframework.stereotype.Service;

@Service
public class CalculateAverageService {

    public Double calculateAverageVictim(VictimRequest victimA, VictimRequest victimB) {
        this.validateRequest(victimA, victimB);
        int avgA = victimA.getYearOfDeath() - victimA.getAgeAtDeath();
        int avgB = victimB.getYearOfDeath() - victimB.getAgeAtDeath();

        return (double) (avgA + avgB) / 2;
    }

    private void validateRequest(VictimRequest victimA, VictimRequest victimB) {
        if (victimA.getYearOfDeath() < 0) {
            throw new AppException("-1");
        }

        if (victimB.getYearOfDeath() < 0) {
            throw new AppException("-1");
        }

        if (victimA.getAgeAtDeath() < 0) {
            throw new AppException("-1");
        }

        if (victimB.getAgeAtDeath() < 0) {
            throw new AppException("-1");
        }

        if (victimA.getYearOfDeath() < victimA.getAgeAtDeath()) {
            throw new AppException("-1");
        }

        if (victimB.getYearOfDeath() < victimB.getAgeAtDeath()) {
            throw new AppException("-1");
        }
    }
}
