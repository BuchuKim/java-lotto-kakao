package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LottoGeneratorTest {
	@Test
	@DisplayName("로또생성기는 1부터 45까지, 6개의 서로다른 숫자로 이뤄진 로또 번호를 생성한다.")
	void lottoNumberTest() {
		LottoGenerator generator = new RandomLottoGenerator();
		Lotto generated = generator.generateLotto();

		List<Integer> lottoNumbers = generated.getLottoNumbers();
		lottoNumbers.forEach(number -> {
			assertThat(number).isBetween(Lotto.LOTTO_LOWER_BOUND, Lotto.LOTTO_UPPER_BOUND);
		});
		Set<Integer> lottoNumberSet = new HashSet<>(lottoNumbers);
		assertThat(lottoNumberSet.size()).isEqualTo(Lotto.LOTTO_NUMBER_SIZE);
	}
}