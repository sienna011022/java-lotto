package step2.controller;

import java.util.ArrayList;
import java.util.Arrays;
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

		int countOfHand = INPUT_VIEW.askForHand();
		handLotteries(countOfHand);
		int autoTicket = payment.autoTicket(money,countOfHand);

		OUTPUT_VIEW.showTotalTicket(autoTicket);

		Lotteries lotteries = Lotteries.of(autoTicket, lottoFactory);
		OUTPUT_VIEW.showLotteries(autoTicket, lotteries);

		HashMap<Rank, Integer> totalCount = lotteries.isMatch(INPUT_VIEW.winNumber(),
			INPUT_VIEW.askBonusNumber());

		OUTPUT_VIEW.resultView(totalCount);
		OUTPUT_VIEW.showRate(payment.calculateBenefit(money, totalCount));
	}

	public Lotteries handLotteries(int countOfHand){
		INPUT_VIEW.askHandNumber();
		List<Lotto> handLotto  = new ArrayList<>();
		for(int i = 0 ; i< countOfHand ; i++) {
			handLotto.add(new Lotto(INPUT_VIEW.handNumber()));
		}
		return new Lotteries(handLotto);
	}
}
