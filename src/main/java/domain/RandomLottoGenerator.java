package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class RandomLottoGenerator implements LottoGenerator {
	private static final List<LottoNumber> numbers =
		IntStream.rangeClosed(LottoNumber.LOTTO_LOWER_BOUND, LottoNumber.LOTTO_UPPER_BOUND)
			.mapToObj(LottoNumber::new).collect(Collectors.toList());

	@Override
	public List<Lotto> generateLottos(int lottoCount) {
		return Stream.generate(this::generateLotto)
			.limit(lottoCount)
			.collect(Collectors.toList());
	}

	private Lotto generateLotto() {
		Collections.shuffle(numbers);
		List<LottoNumber> lottoNumbers = new ArrayList<>(numbers.subList(0, Lotto.LOTTO_NUMBER_SIZE));
		return new Lotto(lottoNumbers);
	}
}
