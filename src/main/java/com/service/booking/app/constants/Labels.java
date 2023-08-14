package com.service.booking.app.constants;

import java.time.format.DateTimeFormatter;

public class Labels {

	public Labels() {
		
	}
	
	public static final String SEARCH_BOOKINGS_HEADER = "Sistema de Gestão de Agendamentos e Validações";
	public static final String SEARCH_BOOKINGS_SUB_HEARED = "Pesquise aqui os seus agendamentos";
	
	public static final String DOCUMENT_TYPE_PASSPORT_A11 = "Passaporte Para Nacionais Maiores de 18 Anos (A11)";
	public static final String DOCUMEMT_TYPE_PASSPORT_A12 = "Passaporte Para Nacionais Menores de 18 Anos (A12)";
	public static final String DOCUMEMT_TYPE_PASSPORT_A13 = "Passaporte Para Estrangeiros Com Nacionalidade Moçambicana Adquirida (A13)";
	public static final String DOCUMEMT_TYPE_PASSPORT_A14 = "Passaporte Para Menor de Pais Estrangeiros (A14)";
	
	public static final String DOCUMENT_TYPE_TRAVEL_A2 = "Documento de Viagem Para Mineiros ou Trabalhadores Sazonais (A2)";
	public static final String DOCUMENT_TYPE_EMERGENCY_CERTIFICATE_A3 = "Certificado de Emergência Para Nacionnais (A3)";
	
	public static final String DOCUMENT_TYPE_VISA_B11 = "Visto de Permanência Temporária (B11)";
	public static final String DOCUMENT_TYPE_VISA_B12 = "Visto de Residência (B12)";
	public static final String DOCUMENT_TYPE_VISA_B131 = "Visto Para Trabalhador Por Conta de Outrem (B131)";
	public static final String DOCUMENT_TYPE_VISA_B132 = "Visto Para Trabalhador No Âmbito da Cooperação (B132)";
	public static final String DOCUMENT_TYPE_VISA_B133 = "Visto Para Missionário, Padre ou Sacerdote (B133)";
	public static final String DOCUMENT_TYPE_VISA_B14 = "Visto de Estudante (B14)";
	public static final String DOCUMENT_TYPE_VISA_B15 = "Visto de Actividades de Investimento (B15)";
	public static final String DOCUMENT_TYPE_VISA_B16 = "Visto de Actividades Culturais (B16)";
	public static final String DOCUMENT_TYPE_VISA_B17 = "Outros Vistos (Negócio, Turismo e Visita) (B17)";
	public static final String DOCUMENT_TYPE_VISA_B21 = "Prorrogação de Visto de Permanência Temporária (B21)";
	
	public static final String DOCUMENT_REQUEST_CONFIRM_DIALOG_TITLE = "Deseja solicitar o documento: {0}?";
	public static final String DOCUMENT_REQUEST_REQUIREMENTS_TITLE = "Requisitos para solicitar o documento: ";

	public static final String DOCUMENT_REQUIREMENT_ID_UNDER_18 = "Bilhete de identidade do menor";
	public static final String DOCUMENT_REQUIREMENT_LEGAL_REPRESENTATIVE_ID = "Bilhete de identidade do responsável ou representante legal";
	public static final String DOCUMENT_REQUIREMENT_LEGAL_REPRESENTATIVE_DECLARETION = "Declaração do representante legal";

	public static final String DOCUMENT_REQUIREMENT_ID_M18 = "Bilhete de Identidade (maior de 18 anos)";
	public static final String DOCUMENT_REQUIREMENT_EXPIRED_PASSPORT = "Passaporte anterior, se for renovação";
	public static final String DOCUMENT_REQUIREMENT_POLICE_STATEMENT = "Declaração da polícia, se tiver perdido o passaporte anterior";

	public static final String DOCUMENT_REQUIREMENT_ID_DOC = "Bilhete de Identidade do requerente";
	public static final String DOCUMENT_REQUIREMENT_MZ_NATIONALITY_AQUISITION = "Assento de aquisição de nacionalidade moçambicana";
	public static final String DOCUMENT_REQUIREMENT_BIRTH_SEAT = "Assento de nascimento";
	public static final String DOCUMENT_REQUIREMENT_WEDDING_SEAT = "Assento de casamento, se tiver adquirido a nacionalidade por via de casamento";
	public static final String DOCUMENT_REQUIREMENT_SPOUSES_ID_CARD = "Bilhete de identidade do cônjuge";
	public static final String DOCUMENT_REQUIREMENT_DIRE_RETURN_LETTER = "Carta de devolução de D.I.R.E.";
	
	public static final String DOCUMENT_REQUIREMENT_MZ_NATIONALITY_ATRIBUITION = "Assento de atribuição de nacionalidade moçambicana";
	public static final String DOCUMENT_REQUIREMENT_BIRTH__OF_MINOR_SEAT = "Assento de nascimento do menor";
	public static final String DOCUMENT_REQUIREMENT_RESIDENCE_IN_NATIONAL_TERRITORY = "Documento que atesta a residência no território nacional (D.I.R.E.)";
	
	public static final String DOCUMENT_REQUIREMENT_EMPLOYMENT_CONTRACT = "Contrato de trabalho (Bonassi), para trabalhadores mineiros";
	public static final String DOCUMENT_REQUIREMENT_MINER_ID_CARD = "Cartão de identificação de Mineiro";
	public static final String DOCUMENT_REQUIREMENT_EMPLOYMENT_CONTRACT_IN_FARMS = "Contrato de trabalho nas farmas, homologado pelo Ministério de Trabalho";
	
	public static final String DOCUMENT_REQUIREMENT_DECLARATION_OF_THE_LEGAL_REPRESENTATIVE = "Declaração do representante legal, em caso de menores";
	public static final String DOCUMENT_REQUIREMENT_WAITING_TICKET_AND_BIRTH_CERTIFICATE = "Talão de espera bilhete, acompanhado pelo assento de nascimento";
	
	public static final String DOCUMENT_REQUIREMENT_CONTACT_EMBASSY = "Entre em contacto com a embaixada ou altos comissariados proximos de si";
	
	public static final String DOCUMENT_REQUIREMENT_INVESTMENT_PROOF = "Comprovativo de investimento em Moçambique, no valor igual ou superior a 500 mil dólares americanos";
	public static final String DOCUMENT_REQUIREMENT_ACCOMMODATION_PROOF = "Comprovativo de garantia de alojamento em Moçambique";
	public static final String DOCUMENT_REQUIREMENT_INSS_CERTIFICATE = "Certidão de Quitação das finanças e de INSS";
	public static final String DOCUMENT_REQUIREMENT_REQUEST_LETTER = "Carta da solicitação da prorrogação do Visto";
	public static final String DOCUMENT_REQUIREMENT_PASSPORT_COPY = "Cópia do passaporte";
	public static final String DOCUMENT_REQUIREMENT_COPY_PREVIOUS_INVEST_VISA = "Cópia do visto de investimento anterior";
	public static final String DOCUMENT_REQUIREMENT_CRIMINAL_RECORD_OPTIONAL = "Registo Criminal, se for primeira vez (Opcional)";
	
	public static final String NATIONAL_SERVICE_CATEGORY_TITLE = "Serviços Disponíveis para Cidadãos Nacionais";
	public static final String FOREIGN_SERVICE_CATEGORY_TITLE = "Serviços Disponíveis para Cidadãos Estrangeiros";
	
	public static final String SERVICE_CATEGORY_TITLE = "Categorias de Serviço";
	public static final String SERVICE_CATEGORY_SUBTITLE = "Selecione nas opções abaixo, o tipo de documento que pretende solicitar, para fazer o seu agendamento";
	
	public static final String SERVICE_CATEGORY_NATIONAL = "Cidadão Nacional";
	public static final String SERVICE_CATEGORY_FOREING = "Cidadão Estrangeiro";
	public static final String DOCUMENT = "Documento";
	public static final String PERSONAL_DATA = "Dados Pessoais";
	public static final String CURRENT_ADDRESS = "Endereço Actual";
	public static final String ADDRESS = "Endereço";
	public static final String CONTACTS = "Contactos";
	public static final String ID_DOCUMENT = "Documento de Identificação";
	public static final String PROFESSION = "Profissão";
	public static final String ACCOMMODATION_ADDRESS = "Endereço do Local de Hospedagem em Moçambique";
	public static final String FAMILY_SECTION = "Familiares amigos residentes em Moçambique";
	

	//Forms Labels
	public static final String DOCUMENT_TYPE = "TIPO DE DOCUMENTO";
	public static final String SELECT_DOCUMENT_TYPE = "selecione o tipo de documento...";
	public static final String SELECT_DOCUMENT_TYPE_HELPER_TEXT = "Selecione o tipo de documento (obrigatório)";
	public static final String MODALITY = "MODALIDADE";
	public static final String SELECT_MODALITY = "Selecione a modalidade...";
	public static final String SELECT_MODALITY_HELPER_TEXT = "Selecione a modalidade que pretende (obrigatório)";
	public static final String SERVICE_FEE = "TAXA";
	public static final String SELECT_SERVICE_FEE = "selecione a taxa...";
	public static final String SELECT_SERVICE_FEE_HELPER_TEXT = "Selecione a taxa que pretende (obrigatório)";
	public static final String SURNAME = "APELIDO";
	public static final String TYPE_YOUR_SURNAME = "Forneça o seu apelido (obrigatório)";
	public static final String SEARCH_BY_YOUR_SURNAME = "Forneça o seu apelido";
	public static final String FULLNAME = "NOME COMPLETO";
	public static final String TYPE_YOUR_FULLNAME = "Forneça o seu nome completo (obrigatório)";
	public static final String NAME = "NOME";
	public static final String BITHDATE = "DATA DE NASCIMENTO";
	public static final String TYPE_YOUR_BITHDATE = "Forneça a sua data de nascimento (obrigatório)";
	public static final String IDENTITY_DOC_NUMBER = "Nº DE BILHETE DE IDENTIFICAÇÃO (B.I.)";
	public static final String PASSPORT_DOC_NUMBER = "Nº DE PASSAPORTE";
	public static final String TYPE_YOUR_IDENTITY_DOC_NUMBER = "Forneça o seu nº de B.I com 12 dígitos e uma letra (obrigatório)";
	public static final String TYPE_YOUR_PASSAPORT_DOC_NUMBER = "Forneça o seu nº de passaport (obrigatório)";
	public static final String SEARCH_YOUR_IDENTITY_DOC_NUMBER = "Forneça o seu nº de B.I";
	public static final String LIFETIME = "VITALÍCIO";
	public static final String LIFETIME_HELPER_TEXT = "Marque Sim se o seu B.I for vitalício e marque Não se não";
	public static final String YES = "SIM";
	public static final String NO = "NÃO";
	public static final String IDENTITY_DOC_VALIDATE = "DATA DE VALIDADE DO B.I";
	public static final String PASSPORT_DOC_VALIDATE = "DATA DE VALIDADE";
	public static final String TYPE_YOUR_IDENTITY_DOC_VALIDATE = "Forneça a data de validade do seu B.I (obrigatório)";
	public static final String TYPE_YOUR_PASSPORT_DOC_VALIDATE = "Forneça a data de validade do seu passaporte (obrigatório)";
	public static final String IDENTITY_DOC_ISSUE_DATE = "DATA DE EMISSÃO";
	public static final String TYPE_YOUR_IDENTITY_DOC_ISSUE_DATE = "Forneça a data de emissão (obrigatório)";
	public static final String LOCAL_OF_ISSUE = "LOCAL DE EMISSÃO";
	public static final String TYPE_YOUR_LOCAL_OF_ISSUE = "Forneça o local de emissão do seu B.I (obrigatório)";
	public static final String COUNTRY_OF_BIRTH = "PAÍS DE NASCIMENTO";
	public static final String SELECT_COUNTRY_OF_BIRTH = "selecione o país de nascimento...";
	public static final String SELECT_COUNTRY_OF_BIRTH_HELPER_TEXT = "Selecione o seu país de nascimento (obrigatório)";
	public static final String NEIGHBORHOOD = "BAIRRO";
	public static final String PERMANENT_RESIDENTIAL_ADDRESS = "ENDEREÇO ​​DA RESIDÊNCIA PERMANENTE";
	public static final String STREET_ADDRESS = "AVENIDA/RUA/ Nº DE CASA";
	public static final String HOTEL_RESERVATION = "NOME DO HOTEL E Nº DA RESERVA";
	public static final String REASON_FOR_TRAVEL = "MOTIVO DA VIAGEM";
	public static final String REASON_FOR_ENTRY_IN_MOZ = "MOTIVO DE ENTRADA EM MOÇAMBIQUE";
	public static final String REASON_FOR_TRAVEL_HELPER_TEXT = "Escreva de forma resumida o motivo da sua viagem (obrigatório)";
	public static final String REASON_FOR_ENTRY_IN_MOZ_HELPER_TEXT  = "Escreva de forma resumida o motivo da sua vinda a Moçambique (obrigatório)";
	public static final String NATIONALITY = "NACIONALIDADE";
	public static final String PASSPORT_NATIONALITY = "NACIONALIDADE DO PASSAPORTE";
	public static final String SELECT_NATIONALITY = "selecione a nacionalidade...";
	public static final String SELECT_YOUR_NATIONALITY = "Selecione a sua nacionalidade (obrigatório)";
	public static final String SELECT_YOUR_PASSPORT_NATIONALITY = "Selecione a nacionalidade do seu passaporte (obrigatório)";
	public static final String NOTE = "OBSERVAÇÃO";
	public static final String NOTE_HELPER_TEXT = "Forneça explicação adicional caso exista (opcional)";
	public static final String OPTIONAL = "(Opnional)";
	public static final String SCHEDULING = "Agendamento";
	public static final String DATE_TO_SCHEDULE = "DATA NA QUAL PRETENDE TRATAR O DOCUMENTO";
	public static final String DATE_TO_SCHEDULE_HELPER_TEXT = "A data pretendida deve estar no futuro e so são permitidas marcações para dias úteis, seg. a sexta-feira, exceto feriados (obrigatório)";
	public static final String PROVINCE = "PROVÍNCIA";
	public static final String SELECT_YOUR_PROVINCE = "Selecione a sua provincia (obrigatório)";
	public static final String SELECT_THE_PROVINCE = "selecione a província...";
	public static final String CITY_OR_DISTRICT = "CIDADE/DISTRITO";
	public static final String CITY = "CIDADE";
	public static final String TYPE_YOUR_CITY = "Forneça o nome sua cidade (obrigatório)";
	public static final String DISTRICT = "DISTRITO";
	public static final String SELECT_THE_DISTRICT = "selecione o distrito...";
	public static final String SELECT_YOUR_DISTRICT = "Selecione a sua cidade/distrito (obrigatório)";
	public static final String NO_DISTRICT_AVALIBLE = "NENHUM DISTRITO DISPONÍVEL PARA A PROVÍNCIA SELECIONADA...";
	public static final String PLACE_TO_SCHEDULE = "LOCAL ONDE PRETENDE TRATAR O DOCUMENTO";
	public static final String PLACE_TO_SCHEDULE_HELPER_TEXT = "Selecione o local onde pretende tratar o documento (obrigatório)";
	public static final String SELECT_PLACE_TO_SCHEDULE = "selecione o local...";
	public static final String PHOME_NUMBER = "TELEMÓVEL";
	public static final String TYPE_YOUR_PHONE_NUMBER = "Forneça o seu Telemóvel (obrigatório)";
	public static final String EMAIL = "E-MAIL";
	public static final String TYPE_YOUR_EMAIL = "Forneça um e-mail válido (opcional)";
	public static final String COUNTRY_CODE = "CÓDIGO DO PAÍS";
	public static final String SELECT_YOUR_COUNTRY_CODE = "Selecione o código do país do seu telemóvel";
	public static final String TYPE_CODE_OR_DOC_NUMBER = "Forneça o seu código de agendamento ou nº de B.I ou de Passaport ou Visa (obrigatório)";
	public static final String SINGLE_NAME = "NOME DE SOLTEIRO(A)";
	public static final String TYPE_YOUR_SINGLE_NAME = "Forneça o nome de solteiro(a) (opcional)";
	public static final String GENDER = "SEXO";
	public static final String SELECT_GENDER = "selecione o sexo...";
	public static final String GENDER_HELPER_TEXT = "Selecione o seu sexo (obrigatório)";
	public static final String MARITAL_STATUS = "ESTADO CIVIL";
	public static final String MARITAL_STATUS_HELPER_TEXT = "Selecione o seu estado civil (obrigatório)";
	public static final String PROFESSION_OCCUPATION = "PROFISSÃO/OCUPAÇÃO";
	public static final String TYPE_YOUR_PROFESSION_OCCUPATION = "Forneça a sua profissão ou ocupação (obrigatório)";
	public static final String POSITION_HELD = "CARGO QUE OCUPA";
	public static final String TYPE_YOUR_POSITION_HELD = "Forneça o cargo que ocupa (obrigatório)";
	public static final String COMPANY_OR_ORGANIZATION = "Instituição onde trabalha ou estuda";
	public static final String TYPE_YOUR_COMPANY_OR_ORGANIZATION = "Forneça a instituição, organização ou empresa onde trabalha ou estuda (obrigatório)";
	public static final String HAVE_BEEN_TO_MOZ = "ESTEVE ALGUMA VEZ EM MOÇAMBIQUE";
	public static final String REASON_TO_LEAVE_MOZ = "PORQUE SAIU DE MOÇAMBIQUE";
	public static final String DEPARTURE_DATE = "DATA DE SAÍDA";
	public static final String TYPE_YOUR_DEPARTURE_DATE = "Forneça a data de saída";
	public static final String COMPANIES_WORKED_FOR = "INDIQUE AS INSTITUIÇÕES E EMPRESAS A QUE ESTEVE LIGADO";
	public static final String HAVE_BEEN_RESIDENT_MOZ = "JA FOI RESIDENTE ALGUMA VEZ EM MOÇAMBIQUE";
	public static final String MARK_YOUR_HAVE_BEEN_RESIDENT_MOZ = "Marque Sim se ja tiver sido residente em Moçambique, caso contrário marque Não";
	public static final String PERIOD_OF_STAY = "TEMPO DE ESTADIA EM MOÇAMBIQUE";
	public static final String PERIOD_OF_STAY_HELPER_TEXT = "Selecione o seu tempo de estadia em Moçambique";
	public static final String FAMILY_RELATIONSHIP = "PARENTESCO";
	public static final String FAMILY_ADDRESS = "ENDEREÇO";
	
	//Validation Messages
	public static final String REQUIRED_FIELD = "Campo obrigatório";
	public static final String VALID_EMAIL = "Forneça um e-mail válido";
	public static final String SET_BIRTHDATE_IN_THE_PAST = "A data de nascimento deve ser uma data passada";
	public static final String SET_DATE_IN_THE_FUTURE = "A data definida deve ser estar no futuro";
	public static final String TYPE_VALID_PHONE_NUMBER = "Digite um número de telemóvel válido";
	public static final String TYPE_VALID_PHONE_NUMBER_258 = "Digite um número de telemóvel válido (ex: 821000001 ou 841000001 ou 861000001)";
	
	//Notification Messages
	public static final String SAVED_BOOKING_SUCCESSFULLY = "O seu agendamento foi criado com sucesso. \nO seu código de agendamento é: ";
	public static final String SAVED_BOOKING_ERROR = "Ocorreu um erro ao salvar o formulário. Por favor, tente novamente.";
	public static final String FILL_REQUIRED_FIELDS = "Preencha todos os campos obrigatórios (Campos cujo nome terminam com um ponto azul ou vermelho )";
	public static final String FILL_REQUIRED_FIELDS_BOOKING_ID = "Preencha o campo Código de Agendamento e tente novamente";
	public static final String BOOKING_NOT_FOUND = "Nenhum agendamento foi encontrado! Verifique os parâmetros de busca e tente novamente.";
	public static final String CANCEL_BOOKING_FAILED = "Não foi possível cancelar o seu agendamento. Tente novammente mais tarde"; 
	public static final String CANCELED_BOOKING_SUCCESSFULLY = "O agendamento com o código # foi cancelado com sucesso.";
	public static final String SELECT_ONLY_WORKING_DAYS = "Selecione um dia útil (de segunda-feira a sexta-feira).";
	public static final String SEARCH_FOR_BOOKING = "Pesquise seu agendamento usando o código de agendamento ou nº de B.I.";
	
	//Tooltips
	public static final String TOOLTIP_SAVE_FORM = "Salvar o formulário e criar o agendamento.";
	public static final String TOOLTIP_CANCEL_FORM = "Cancelar e voltar para a página de Categorias de Serviço";
	public static final String TOOLTIP_CLEAN_FIELDS_FORM = "Limpar todos os campos preenchidos";
	
	//Search Booking Form
	public static final String SEARCH_BOOKING_OPTIONS = "PESQUISAR POR";
	public static final String BOOKING_ID = "Código de Agendamento";
	public static final String SEARCH_BOOKING_FIELD = "Forneça o código do agendamento";
	public static final String ID_DOCUMENT_NUMBER = "B.I";
	public static final String PASSPORT_NUMBER = "Passaporte";
	public static final String SEARCH_PASSPORT_NUMBER = "Forneça o seu nº de passaporte";
	public static final String VISA = "Visa";
	public static final String SEARCH_BY_YOUR_VISA = "Forneça o seu nº visa";
	public static final String SEARCH_BOOKING_OPTIONS_HELPER_TEXT = "Selecione uma das opções de pesquisa (obrigatório)";
	public static final String SCHEDULED_DATE = "DATA MARCADA";
	public static final String SELECTED_LOCATION = "LOCAL SELECIONADO";
	public static final String STATUS = "ESTADO";
	public static final String PHONE_OR_EMAIL = "Telemóvel ou E-mail";
	public static final String PHONE_OR_EMAIL_PLACEHOLDER = "Forneça o seu nº de telemóvel ou e-mail se preferir";
	
	//Confirm Dialog
	public static final String CANCEL_BOOKING = "Anular Agendamento";
	public static final String CANCEL_BOOKING_CONFIRM_TEXT = "Tem certeza que deseja anular o agendamento com o código #?";
	public static final String BOOKING_CONFIRMATION = "Confirme a baixo os dados do seu agendamento para tratar o documento: ";
	public static final String CONFIRM_BOOKING = "Confirmação do Agendamento";
	public static final String CONFIRM_BOOKING_CANCELLATION = "Anular Agendamento";
	public static final String UNAVAILABLE_DATE = "Data Indisponível";
	public static final String UNAVAILABLE_DATE_TEXT_INFO = "<p>Já foi atingido o limite de agendamentos para o dia <b>"
	+"#</b>. Por favor selecione outra data."
	+ "<br/>Abaixo algumas sugestões de datas disponiveis: </p>";
	public static final String UNAVAILABLE_DATE_TEXT_INFO_NO_SUGGESTIONS = "<p>Já foi atingido o limite de agendamentos para o dia <b>"
			+"#</b>. Por favor selecione outra data.";
	public static final String APPLICANT_HAS_AN_ACTIVE_SCHEDULE = "JÁ POSSUE UM AGENDAMENTO ACTIVO";
	public static final String APPLICANT_HAS_AN_ACTIVE_SCHEDULE_TEXT_INFO = "<p>Já possue um agendamento activo para a data <b>#1</b> no local <b>#2</b> "
			+ "para tratar o documento <b>#3</b>.</br>Faça um reagendamento do seu agendamento actual ou selecione um documento diferente.</p>";
	public static final String APPLICANT_HAS_MORE_THAN_FIVE_BOOKINGS = "ATINGIU O LIMITE DE AGENDAMENTOS POR CONTACTO";
	public static final String APPLICANT_HAS_MORE_THAN_FIVE_BOOKINGS_TEXT_INFO = "<p>O número de telemóvel <b>#1</b> já atingiu o limite de agendamentos activos que pode associar!";
	
	//Buttons
	public static final String CONFIRM_BOOKING_BUTTON = "Confirmar";
	public static final String CONFIRM_BOOKING_LATER_BUTTON = "Confirmar mais tarde";
	public static final String VIEW_BOOKING_HISTORY_BUTTON = "Ver Histórico";
	public static final String CANCEL_BOOKING_BUTTON = "Anular";
	public static final String RESCHEDULE_BOOKING_BUTTON = "Reagendar";
	
}
