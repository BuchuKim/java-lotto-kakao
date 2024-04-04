package controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import domain.Lotto;
import domain.LottoGenerator;
import domain.LottoMoney;
import domain.LottoNumber;
import domain.Lottos;
import domain.WinningLotto;
import domain.WinningResult;
import view.LottoGameView;

public class LottoGameController {
	private final LottoGameView lottoGameView;
	private final LottoGenerator lottoGenerator;

	public LottoGameController(LottoGameView lottoGameView, LottoGenerator lottoGenerator) {
		this.lottoGameView = lottoGameView;
		this.lottoGenerator = lottoGenerator;
	}

	public void play() {
		LottoMoney lottoMoney = getLottoMoney();

		Lottos bought = buyLottos(lottoMoney);
		lottoGameView.printPurchasedLottos(bought);

		Lotto winningLottoNumbers = getWinningLottoNumbers();
		WinningLotto winningLotto = getWinningLotto(winningLottoNumbers);
		WinningResult winningResult = WinningResult.of(winningLotto, bought);

		lottoGameView.printWinningRank(winningResult);
		lottoGameView.printEarningRate(winningResult.calculateEarningRate(lottoMoney));
	}

	private LottoMoney getLottoMoney() {
		try {
			return new LottoMoney(lottoGameView.getLottoMoneyInput());
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
			return getLottoMoney();
		}
	}

	private Lottos buyLottos(LottoMoney lottoMoney) {
		int manualLottoCount = lottoGameView.getManualLottoCount();
		LottoMoney remain = lottoMoney.calculateRemainAfterBuy(manualLottoCount);

		List<Lotto> manualLottos = getManualLottos(manualLottoCount);
		List<Lotto> autoLottos = lottoGenerator.generateLottos(remain.calculateLottoCount());

		return new Lottos(autoLottos, manualLottos);
	}

	private List<Lotto> getManualLottos(int count) {
		return Stream.generate(lottoGameView::getManualLottoNumbers)
			.limit(count)
			.map(Lotto::new)
			.collect(Collectors.toList());
	}

	private Lotto getWinningLottoNumbers() {
		try {
			List<LottoNumber> winningLottos = lottoGameView.getWinningLottoNumbers();
			return new Lotto(winningLottos);
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
			return getWinningLottoNumbers();
		}
	}

	private WinningLotto getWinningLotto(Lotto winningLottoNumbers) {
		try {
			LottoNumber bonusNumber = new LottoNumber(lottoGameView.getBonusNumber());
			return new WinningLotto(winningLottoNumbers, bonusNumber);
		} catch (IllegalArgumentException e) {
			System.out.println("[ERROR] " + e.getMessage());
			return getWinningLotto(winningLottoNumbers);
		}
	}
}
