package domain;

import java.util.Arrays;

public enum Rank {
	NONE(0, new WinningMoney(WinningMoneyConstant.NONE_MONEY)),
	FIFTH_WIN(3, new WinningMoney(WinningMoneyConstant.FIFTH_WIN_MONEY)),
	FOURTH_WIN(4, new WinningMoney(WinningMoneyConstant.FOURTH_WIN_MONEY)),
	THIRD_WIN(5, new WinningMoney(WinningMoneyConstant.THIRD_WIN_MONEY)),
	SECOND_WIN(5, new WinningMoney(WinningMoneyConstant.SECOND_WIN_MONEY)),
	FIRST_WIN(6, new WinningMoney(WinningMoneyConstant.FIRST_WIN_MONEY));

	private final int matchNumberCount;
	private final WinningMoney winningMoney;

	Rank(int matchNumberCount, WinningMoney winningMoney) {
		this.matchNumberCount = matchNumberCount;
		this.winningMoney = winningMoney;
	}

	public static Rank findByMatchNumberCount(int matchNumberCount, boolean hasBonusNumber) {
		if (matchNumberCount == SECOND_WIN.matchNumberCount && hasBonusNumber) {
			return SECOND_WIN;
		}
		if (matchNumberCount == THIRD_WIN.matchNumberCount) {
			return THIRD_WIN;
		}
		return Arrays.stream(Rank.values())
			.filter(rank -> rank.matchNumberCount == matchNumberCount)
			.findFirst()
			.orElse(NONE);
	}

	public WinningMoney getWinningMoney() {
		return winningMoney;
	}
}
