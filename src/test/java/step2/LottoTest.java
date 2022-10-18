package step2;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoTest {
	@Test
	@DisplayName("로또 한세트(숫자 6개)를 만든다")
	void 로또_한세트_테스트(){
		Lotto randomNum = new Lotto();
		assertThat(randomNum.createLotto()).hasSameSizeAs(new int[6]);
	}


}
