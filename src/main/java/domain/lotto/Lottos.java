package domain.lotto;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import domain.Rank;
import domain.WinningResult;

public class Lottos {
	private final List<Lotto> lottos;

	public Lottos(List<Lotto> lottos) {
		this.lottos = lottos;
	}

	public WinningResult calculateWinningResult(WinningLotto winningLotto) {
		List<Rank> ranks = this.lottos.stream()
			.map(winningLotto::getRank)
			.collect(Collectors.toList());
		return new WinningResult(ranks);
	}
	
	public Lottos concat(Lottos lottos) {
		return new Lottos(Stream.concat(this.lottos.stream(),
				lottos.getLottos().stream())
			.collect(Collectors.toList()));
	}
	
	public List<Lotto> getLottos() {
		return Collections.unmodifiableList(lottos);
	}
}
