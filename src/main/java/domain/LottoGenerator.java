package domain;

import java.util.List;

import domain.lotto.Lotto;

public interface LottoGenerator {
	List<Lotto> generateLottos(int lottoCount);
}
