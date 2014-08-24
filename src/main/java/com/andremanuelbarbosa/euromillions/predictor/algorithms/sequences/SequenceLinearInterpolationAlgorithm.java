package com.andremanuelbarbosa.euromillions.predictor.algorithms.sequences;

import java.util.List;

import org.apache.commons.math3.analysis.interpolation.LinearInterpolator;

import com.andremanuelbarbosa.euromillions.predictor.domain.Draw;
import com.andremanuelbarbosa.euromillions.predictor.domain.Item;

public class SequenceLinearInterpolationAlgorithm extends SequenceInterpolationAlgorithm {

  public SequenceLinearInterpolationAlgorithm(Item item, List<? extends Draw> draws) {

    super(item, draws);
  }

  void calculateNextValue() {

    loadValuesPolynomial();

    if (valuesPolynomialX.length < 2) {

      nextValue = draws.size();

    } else {

      nextValue = new LinearInterpolator().interpolate(valuesPolynomialX, valuesPolynomialY).value(
          item.getIntervals().size());
    }
  }
}
