package com.andremanuelbarbosa.euromillions.predictor.algorithms;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.andremanuelbarbosa.euromillions.predictor.domain.Bet;
import com.andremanuelbarbosa.euromillions.predictor.domain.Draws;
import com.andremanuelbarbosa.euromillions.predictor.domain.Number;
import com.andremanuelbarbosa.euromillions.predictor.domain.Star;

public class ReverseFreqAlgorithmIntegrationTest extends AlgorithmIntegrationTest {

  private ReverseFreqAlgorithm reverseFreqAlgorithm = new ReverseFreqAlgorithm();

  @Test
  public void shouldReturnNextBet() {

    Bet bet = reverseFreqAlgorithm.getNextBet();

    assertNotNull(bet);

    for (Number number : Draws.getNumbers()) {

      if (!bet.getNumbers().contains(number.getId())) {

        assertTrue(number.getRelativeFreq() >= reverseFreqAlgorithm.getMaximumRelativeFreqFromNumbers(bet.getNumbers()));
      }
    }

    for (Star star : Draws.getStars()) {

      if (!bet.getStars().contains(star.getId())) {

        assertTrue(star.getRelativeFreq() >= reverseFreqAlgorithm.getMaximumRelativeFreqFromStars(bet.getStars()));
      }
    }

    assertTrue(BET_PATTERN.matcher(bet.toString()).matches());
  }
}
