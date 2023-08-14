package com.service.booking.app.constants;

public class Notifications {

	//EMAIL MESSAGES
	public static final String EMAIL_SUBJECT_BOOKING = "SIGAV - Agendamento Criado com Sucesso";
	public static final String EMAIL_HTML_BODY_BOOKING = "<p>Caro(a) #fullname</p>\n"
			+ "<p>O seu agendamento para o documento <b>#doc</b> foi efectuado com sucesso com o código \n"
			+ "    <b>#code</b> e para a data <b>#date</b>, por favor use o código para referênciar o agendamento e se \n"
			+ "    apresente no local <b>#local</b> na data agendada.</p>\n"
			+ "</br>\n"
			+ "<small style=\"color: gray;\">SIGAV - Sistema de Gestão de Agendamentos e Validações</small>";
	
	public static final String EMAIL_SUBJECT_BOOKING_CANCELED = "SIGAV - Agendamento Anulado com Sucesso";
	public static final String EMAIL_HTML_BODY_BOOKING_CANCELED = "<p>Caro(a) #fullname</p>\n"
			+ "<p>O seu agendamento para o documento <b>#doc</b> e com o código <b>#code</b> foi anulado com sucesso.</p>\n"
			+ "</br>\n"
			+ "<small style=\"color: gray;\">SIGAV - Sistema de Gestão de Agendamentos e Validações</small>";
	
}
