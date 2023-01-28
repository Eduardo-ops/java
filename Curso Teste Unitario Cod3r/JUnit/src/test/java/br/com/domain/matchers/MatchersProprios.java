package br.com.domain.matchers;

import java.util.Calendar;

public class MatchersProprios {

	public static DiaSemanaMatcher caiEm(Integer diaSemana) {
		return new DiaSemanaMatcher(diaSemana);
	}

	public static DiaSemanaMatcher caiNumaSegunda() {
		return new DiaSemanaMatcher(Calendar.MONDAY);
	}

	public static DataDiferenteDiasMatcher eHoje() {
		return new DataDiferenteDiasMatcher(0);
	}

	public static DataDiferenteDiasMatcher eHojeComDiferencaDias(Integer qtdDias) {
		return new DataDiferenteDiasMatcher(qtdDias);
	}
}
