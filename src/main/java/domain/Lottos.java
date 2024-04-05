package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public List<Lotto> getLottos() {
		return Collections.unmodifiableList(lottos);
	}

	public WinningResult calculateWinningResult(WinningLotto winningLotto) {
		WinningResult result = new WinningResult();
		getLottos().forEach(lotto -> result.add(winningLotto.getRank(lotto)));
		return result;
	}
}
