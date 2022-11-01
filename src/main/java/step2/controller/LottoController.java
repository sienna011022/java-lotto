package step2.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import step2.model.Lotteries;
import step2.model.Lotto;
import step2.model.LottoFactory;
import step2.model.Payment;
import step2.model.Rank;
import step2.view.InputView;
import step2.view.OutputView;

public class LottoController {

	private static final OutputView OUTPUT_VIEW = new OutputView();
	private static final InputView INPUT_VIEW = new InputView();
	private Payment payment = new Payment();

	public void startLotto(LottoFactory lottoFactory) {

		int money = INPUT_VIEW.askMoneyForLotto();
		int totalTicket = payment.amountOfTicket(money);
		int handTicket = INPUT_VIEW.askForHand();
		payment.isValid(handTicket,totalTicket);

		int autoTicket = payment.autoTicket(totalTicket, handTicket);
		Lotteries lotteries = Lotteries.of(handLotteries(handTicket), autoTicket, lottoFactory);
		OUTPUT_VIEW.showTotalTicket(handTicket, autoTicket);
		OUTPUT_VIEW.showLotteries(totalTicket, lotteries);

		HashMap<Rank, Integer> totalCount =
			lotteries.isMatch(
				INPUT_VIEW.winNumber(),
				INPUT_VIEW.askBonusNumber());

		OUTPUT_VIEW.resultView(totalCount);

		OUTPUT_VIEW.showRate(
			payment.calculateBenefit(money, totalCount));
	}

	public List<Lotto> handLotteries(int countOfHand) {
		INPUT_VIEW.askHandNumber();
		List<Lotto> handLotto = new ArrayList<>();

		for (int i = 0; i < countOfHand; i++) {
			handLotto.add(new Lotto(INPUT_VIEW.handNumber()));
		}

		return handLotto;
	}
}
