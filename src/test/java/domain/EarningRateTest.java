package domain;

import java.util.List;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class EarningRateTest {
	@Test
	@DisplayName("총 수익률을 계산한다.")
	void earningRateTest() {
		LottoMoney spent = new LottoMoney(10500);
		WinningResult winningResult = new WinningResult(List.of(Rank.FIFTH_WIN));

		EarningRate earningRate = EarningRate.of(spent, winningResult);
		double expected = (double) winningResult.getWinningMoney().getMoney() / spent.getSpentMoney();

		Assertions.assertThat(earningRate.getEarningRate()).isEqualTo(expected);
	}
}
