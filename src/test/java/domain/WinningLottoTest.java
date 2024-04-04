package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoTest {
	@Test
	@DisplayName("3개가 일치하는 당첨 결과를 계산할 수 있다.")
	void matchThreeRank() {
		// 3등 당첨 Lotto, WinningLotto
		Lotto testLotto = convertToLotto(1, 2, 3, 4, 5, 6);
		Lotto winnigLotto = convertToLotto(1, 2, 3, 7, 8, 9);
		WinningLotto testWinningLotto = new WinningLotto(winnigLotto, new LottoNumber(10));

		Rank rank = testWinningLotto.getRank(testLotto);

		assertThat(rank).isEqualTo(Rank.FIFTH_WIN);
		assertThat(rank.getWinningMoney().getMoney()).isEqualTo(WinningMoneyConstant.FIFTH_WIN_MONEY);
	}

	@Test
	@DisplayName("4개가 일치하는 당첨 결과를 계산할 수 있다.")
	void matchFourRank() {
		// 4등 당첨 Lotto, WinningLotto
		Lotto testLotto = convertToLotto(1, 2, 3, 4, 5, 6);
		Lotto winnigLotto = convertToLotto(1, 2, 3, 4, 8, 9);
		WinningLotto testWinningLotto = new WinningLotto(winnigLotto, new LottoNumber(10));

		Rank rank = testWinningLotto.getRank(testLotto);

		assertThat(rank).isEqualTo(Rank.FOURTH_WIN);
		assertThat(rank.getWinningMoney().getMoney()).isEqualTo(WinningMoneyConstant.FOURTH_WIN_MONEY);
	}

	@Test
	@DisplayName("5개가 일치하는 당첨 결과를 계산할 수 있다.")
	void matchFiveRank() {
		// 5등 당첨 Lotto, WinningLotto
		Lotto testLotto = convertToLotto(1, 2, 3, 4, 5, 6);
		Lotto winnigLotto = convertToLotto(1, 2, 3, 4, 5, 9);
		WinningLotto testWinningLotto = new WinningLotto(winnigLotto, new LottoNumber(10));

		Rank rank = testWinningLotto.getRank(testLotto);

		assertThat(rank).isEqualTo(Rank.THIRD_WIN);
		assertThat(rank.getWinningMoney().getMoney()).isEqualTo(WinningMoneyConstant.THIRD_WIN_MONEY);
	}

	@Test
	@DisplayName("5개와 보너스 숫자가 일치하는 당첨 결과를 계산할 수 있다.")
	void matchFiveWithBonusRank() {
		// 5등 + 보너스 당첨 Lotto, WinningLotto
		Lotto testLotto = convertToLotto(1, 2, 3, 4, 5, 6);
		Lotto winnigLotto = convertToLotto(1, 2, 3, 4, 5, 9);
		WinningLotto testWinningLotto = new WinningLotto(winnigLotto, new LottoNumber(6));

		Rank rank = testWinningLotto.getRank(testLotto);

		assertThat(rank).isEqualTo(Rank.SECOND_WIN);
		assertThat(rank.getWinningMoney().getMoney()).isEqualTo(WinningMoneyConstant.SECOND_WIN_MONEY);
	}

	@Test
	@DisplayName("6개가 일치하는 당첨 결과를 계산할 수 있다.")
	void matchSixRank() {
		// 6등 당첨 Lotto, WinningLotto
		Lotto testLotto = convertToLotto(1, 2, 3, 4, 5, 6);
		Lotto winnigLotto = convertToLotto(1, 2, 3, 4, 5, 6);
		WinningLotto testWinningLotto = new WinningLotto(winnigLotto, new LottoNumber(10));

		Rank rank = testWinningLotto.getRank(testLotto);

		assertThat(rank).isEqualTo(Rank.FIRST_WIN);
		assertThat(rank.getWinningMoney().getMoney()).isEqualTo(WinningMoneyConstant.FIRST_WIN_MONEY);
	}

	private Lotto convertToLotto(int ...lottoNumbers) {
		return new Lotto(
			Arrays.stream(lottoNumbers)
				.mapToObj(LottoNumber::new)
				.collect(Collectors.toList()));
	}
}
