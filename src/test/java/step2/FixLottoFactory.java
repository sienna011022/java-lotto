package step2;

import java.util.Arrays;
import java.util.List;
import step2.model.LottoFactory;

public class FixLottoFactory implements LottoFactory {

	private final static List<Integer> FIX_NUM_LIST = Arrays.asList(1,6,22,33,41,45);

	@Override
	public List<Integer> getLottoNum() {
		return FIX_NUM_LIST;
	}
}
