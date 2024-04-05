package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottosTest {
	@Test
	@DisplayName("수동과 자동으로 구매한 로또 개수를 확인 가능하다.")
	void lottoCountTest() {
		// given: 수동과 자동 로또가 각각 2개 존재한다.
		Lottos testLottos = generateTestLottos();

		assertThat(testLottos.getManualLottoCount()).isEqualTo(2);
		assertThat(testLottos.getAutoLottoCount()).isEqualTo(2);
	}

	@Test
	@DisplayName("전체 로또 정보를 조회할 수 있다.")
	void readAllLottoTest() {
		// given: 수동과 자동 로또가 각각 2개 존재한다.
		Lottos testLottos = generateTestLottos();

		assertThat(testLottos.getLottos().size()).isEqualTo(4);
	}

	@Test
	@DisplayName("당첨 번호와 비교하여 당첨 결과를 확인할 수 있다.")
	void checkWinningResultTest() {
		// given: 수동과 자동 로또가 각각 2개 존재한다.
		Lottos testLottos = generateTestLottos();
		WinningLotto winningLotto =
			new WinningLotto(generateLottoFrom(1, 2, 3, 4, 5, 6), new LottoNumber(7));

		// when: 당첨 번호와 비교하여 당첨 결과를 확인한다.
		WinningResult winningResult = testLottos.calculateWinningResult(winningLotto);

		assertThat(winningResult.getWinningCount(Rank.FIRST_WIN)).isEqualTo(1);
		assertThat(winningResult.getWinningCount(Rank.SECOND_WIN)).isEqualTo(1);
		assertThat(winningResult.getWinningCount(Rank.THIRD_WIN)).isEqualTo(0);
		assertThat(winningResult.getWinningCount(Rank.FOURTH_WIN)).isEqualTo(1);
		assertThat(winningResult.getWinningCount(Rank.FIFTH_WIN)).isEqualTo(1);
	}

	/**
	 * 수동, 자동 로또가 각각 2개 존재합니다.
	 * @return
	 */
	private Lottos generateTestLottos() {
		List<Lotto> autoLotto = List.of(
			generateLottoFrom(1, 2, 3, 4, 5, 6),
			generateLottoFrom(2, 3, 4, 5, 6, 7));
		List<Lotto> manualLotto = List.of(
			generateLottoFrom(3, 4, 5, 6, 7, 8),
			generateLottoFrom(4, 5, 6, 7, 8, 9));

		return new Lottos(autoLotto, manualLotto);
	}

	private Lotto generateLottoFrom(int ...lottoNumbers) {
		return new Lotto(Arrays.stream(lottoNumbers)
			.mapToObj(LottoNumber::new)
			.collect(Collectors.toList()));
	}
}
