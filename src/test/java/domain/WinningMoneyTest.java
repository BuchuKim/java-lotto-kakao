package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class WinningMoneyTest {
	@Test
	@DisplayName("당첨 상금을 더하는 것이 가능하다.")
	void addWinningAmountTest() {
		WinningMoney winningMoney = new WinningMoney(WinningMoneyConstant.FOURTH_WIN_MONEY);
		winningMoney.add(new WinningMoney(WinningMoneyConstant.THIRD_WIN_MONEY));

		long expectedAmount = WinningMoneyConstant.FOURTH_WIN_MONEY + WinningMoneyConstant.THIRD_WIN_MONEY;
		assertThat(winningMoney.getMoney()).isEqualTo(expectedAmount);
	}
}
