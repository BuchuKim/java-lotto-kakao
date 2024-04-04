package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lottos {
	private final List<Lotto> manualLottos;
	private final List<Lotto> autoLottos;

	public Lottos(List<Lotto> manualLottos, List<Lotto> autoLottos) {
		this.autoLottos = autoLottos;
		this.manualLottos = manualLottos;
	}

	public int getManualLottoCount() {
		return manualLottos.size();
	}

	public int getAutoLottoCount() {
		return autoLottos.size();
	}

	public List<Lotto> getLottos() {
		List<Lotto> totalLottos = new ArrayList<>();
		totalLottos.addAll(manualLottos);
		totalLottos.addAll(autoLottos);
		return Collections.unmodifiableList(totalLottos);
	}
}
