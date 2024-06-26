package domain;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {

	@Test
	@DisplayName("로또 번호는 오름차순으로 정렬되어있다.")
	void sortLottoTest() {
		Lotto lotto = convertToLotto(6, 5, 4, 3, 2, 1);

		List<LottoNumber> sorted = lotto.getLottoNumbers();

		assertThat(sorted).isSorted();
	}

	@Test
	@DisplayName("로또 번호는 여섯 개로 이뤄져야한다.")
	void lottoSizeTest() {
		assertThatThrownBy(() -> convertToLotto(6, 5, 4, 3, 2, 1, 11))
			.isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> convertToLotto(6, 5, 4, 3, 2))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("특정 로또 번호가 존재하는지 여부를 확인 가능하다.")
	void lottoContainsTest() {
		Lotto lotto = convertToLotto(6, 5, 4, 3, 2, 1);

		assertThat(lotto.contains(new LottoNumber(6))).isTrue();
		assertThat(lotto.contains(new LottoNumber(7))).isFalse();
	}

	private Lotto convertToLotto(int ...lottoNumbers) {
		 return new Lotto(
			 Arrays.stream(lottoNumbers)
				 .mapToObj(LottoNumber::new)
				 .collect(Collectors.toList()));
	}
}
