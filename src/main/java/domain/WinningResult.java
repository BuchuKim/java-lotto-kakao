package domain;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WinningResult {
	private final Map<Rank, Integer> winningResult;

	public WinningResult(List<Rank> ranks) {
		winningResult = new HashMap<>();
		Arrays.stream(Rank.values()).forEach(rank -> winningResult.put(rank, 0));
		ranks.forEach(this::add);
	}

	public void add(Rank rank) {
		this.winningResult.put(rank, getWinningCount(rank) + 1);
	}

	public EarningRate calculateEarningRate(LottoMoney lottoMoney) {
		return EarningRate.of(lottoMoney, this);
	}

	public int getWinningCount(Rank rank) {
		return this.winningResult.get(rank);
	}

	public WinningMoney getWinningMoney() {
		long result = winningResult.keySet().stream()
			.map(rank -> rank.getWinningMoney().getMoney() * getWinningCount(rank))
			.mapToLong(Long::longValue)
			.sum();
		return new WinningMoney(result);
	}
}
