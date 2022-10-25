package step2.model;

import java.util.List;

public class WinningLotto {

	private List<Integer> winNumList;
	private int bonusNumber;

	private WinningLotto(List<Integer> winNumList,int bonusNumber) {
		this.winNumList = winNumList;
		this.bonusNumber = bonusNumber;
	}

	public static WinningLotto of(List<Integer> winNumList,int bonusNumber){
		return new WinningLotto(winNumList,bonusNumber);
	}

	public int countOfMatch(List<Integer> lotto) {
		return (int) winNumList.stream()
			.filter(lotto::contains)
			.count();
	}

	public boolean isBonusNumber(List<Integer> lotto) {
		long matchOfBonus = lotto.stream().filter(s -> s.equals(bonusNumber)).count();
		if(matchOfBonus > 0){
			return true;
		}
		return false;
	}
}
