package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {
	@Test
	@DisplayName("당첨 번호와 비교하여 당첨 결과를 확인할 수 있다.")
	void checkWinningResultTest() {
		Lottos testLottos = generateTestLottos();
		WinningLotto winningLotto =
			new WinningLotto(generateLottoFrom(1, 2, 3, 4, 5, 6), new LottoNumber(7));

		WinningResult winningResult = testLottos.calculateWinningResult(winningLotto);

		assertThat(winningResult.getWinningCount(Rank.FIRST_WIN)).isEqualTo(1);
		assertThat(winningResult.getWinningCount(Rank.SECOND_WIN)).isEqualTo(1);
		assertThat(winningResult.getWinningCount(Rank.THIRD_WIN)).isEqualTo(0);
		assertThat(winningResult.getWinningCount(Rank.FOURTH_WIN)).isEqualTo(0);
		assertThat(winningResult.getWinningCount(Rank.FIFTH_WIN)).isEqualTo(1);
	}

	private Lottos generateTestLottos() {
		List<Lotto> testLottos = List.of(
			generateLottoFrom(1, 2, 3, 4, 5, 6),
			generateLottoFrom(2, 3, 4, 5, 6, 7),
			generateLottoFrom(4, 5, 6, 7, 8, 9),
			generateLottoFrom(5, 6, 7, 8, 9, 10));

		return new Lottos(testLottos);
	}

	private Lotto generateLottoFrom(int ...lottoNumbers) {
		return new Lotto(Arrays.stream(lottoNumbers)
			.mapToObj(LottoNumber::new)
			.collect(Collectors.toList()));
	}
}
