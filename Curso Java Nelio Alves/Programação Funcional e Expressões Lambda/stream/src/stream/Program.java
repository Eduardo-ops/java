package stream;

import java.util.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Program {

	public static void main(String[] args) throws ParseException {

		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		SimpleDateFormat dateFormat2 = new SimpleDateFormat("dd/MM/yyyy");
		String option = "C";
		Boolean returns = false;

		Calendar clContratoRecompra = Calendar.getInstance();
		clContratoRecompra.set(2022, Calendar.NOVEMBER, 16);
		clContratoRecompra.set(Calendar.HOUR_OF_DAY, 0);
		clContratoRecompra.set(Calendar.MINUTE, 0);
		clContratoRecompra.set(Calendar.SECOND, 0);
		clContratoRecompra.set(Calendar.MILLISECOND, 0);
		System.out.println("Data de recompra: " + clContratoRecompra.getTime());

		System.out.println("Retorno do método: " + validarContrato(clContratoRecompra, option));

	}

	public static Boolean validarContrato(Calendar clContrato, String option) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar clPedido = Calendar.getInstance();
		Date dtAtual = new Date();
		clPedido.setTime(dtAtual);
		clPedido.set(Calendar.HOUR_OF_DAY, 0);
		clPedido.set(Calendar.MINUTE, 0);
		clPedido.set(Calendar.SECOND, 0);
		clPedido.set(Calendar.MILLISECOND, 0);

		if ("C".equals(option) && clPedido.before(clContrato) || clPedido.after(clContrato)) {
			System.out.println("O pedido não pode ser realizado nessa data. Próxima data de recompra "
					+ sdf.format(clContrato.getTime()));
			return true;
		}
		System.out.println("Data do pedido: " + clPedido.getTime());
		return false;
	}
}
