package step2.model;

import java.util.HashMap;
import step2.exception.MoneyException;

public class Payment {

	private static final int LOTTO_PRICE = 1000;
	private static final int DEFAULT_PRICE = 0;

	private int amountOfTicket(int cash) {
		if (cash < LOTTO_PRICE) {
			throw new MoneyException("금액이 부족합니다");
		}
		return cash / LOTTO_PRICE;
	}

	public double calculateBenefit(int cash, HashMap<Rank, Integer> totalCount) {
		int benefit = DEFAULT_PRICE;

		for (Rank rank : Rank.values()) {
			benefit += (rank.getWinningMoney() * totalCount.get(rank));
		}

		return benefit / (double) cash;
	}

	public int autoTicket(int cash, int handCount) {
		int autoTicket = amountOfTicket(cash) - handCount;

		if(autoTicket < DEFAULT_PRICE){
			throw new MoneyException("티켓을 살 돈이 부족합니다");
		}

		return autoTicket;


	}
}
