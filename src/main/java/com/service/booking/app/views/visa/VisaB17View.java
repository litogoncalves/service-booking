package com.service.booking.app.views.visa;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.stream.Collectors;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.constants.Labels;
import com.service.booking.app.constants.Notifications;
import com.service.booking.app.data.entity.Booking;
import com.service.booking.app.data.entity.BookingLimit;
import com.service.booking.app.data.entity.Country;
import com.service.booking.app.data.entity.CountryCode;
import com.service.booking.app.data.entity.District;
import com.service.booking.app.data.entity.Document;
import com.service.booking.app.data.entity.Family;
import com.service.booking.app.data.entity.GeneralData;
import com.service.booking.app.data.entity.IdentityDocument;
import com.service.booking.app.data.entity.Location;
import com.service.booking.app.data.entity.Modality;
import com.service.booking.app.data.entity.Nationality;
import com.service.booking.app.data.entity.Passport;
import com.service.booking.app.data.entity.Province;
import com.service.booking.app.data.entity.Service;
import com.service.booking.app.data.entity.ServiceFee;
import com.service.booking.app.data.entity.Status;
import com.service.booking.app.data.service.BookingLimitService;
import com.service.booking.app.data.service.BookingService;
import com.service.booking.app.data.service.CountryCodeService;
import com.service.booking.app.data.service.CountryService;
import com.service.booking.app.data.service.DistrictService;
import com.service.booking.app.data.service.DocumentService;
import com.service.booking.app.data.service.EmailReportService;
import com.service.booking.app.data.service.FamilyService;
import com.service.booking.app.data.service.GeneralDataService;
import com.service.booking.app.data.service.IdentityDocumentService;
import com.service.booking.app.data.service.LocationService;
import com.service.booking.app.data.service.ModalityService;
import com.service.booking.app.data.service.NationalityService;
import com.service.booking.app.data.service.PassportService;
import com.service.booking.app.data.service.ProvinceService;
import com.service.booking.app.data.service.ServFeeService;
import com.service.booking.app.data.service.ServService;
import com.service.booking.app.data.service.SmsReportService;
import com.service.booking.app.data.service.StatusService;
import com.service.booking.app.http.controller.NotificationManager;
import com.service.booking.app.utils.AlphanumericGenerator;
import com.service.booking.app.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValue;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.shared.Tooltip;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

@PageTitle("Visa B17 | SIGAV - Sistema de Gestão de Agendamentos e Validações")
@Route(value = "visaB17", layout = MainLayout.class)
@AnonymousAllowed
public class VisaB17View extends VerticalLayout {
	
	private static final long serialVersionUID = 1L;
	
	private final ServService servService;
	private final BookingService bookingService;
	private final StatusService statusService;
	private final DocumentService documentService;
	private final ModalityService modalityService;
	private final ServFeeService servFeeService;
	private final CountryService countryService;
	private final NationalityService nationalityService;
	private final ProvinceService provinceService;
	private final DistrictService districtService;
	private final LocationService locationService;
	private final CountryCodeService countryCodeService;
	private final GeneralDataService generalDataService;
	private final FamilyService familyService;
	private final BookingLimitService bookingLimitService;
	private final PassportService passportService;
	private final EmailReportService emailSendingReportService;
	private final SmsReportService smsSendingReportService;

	private NotificationManager notificationManager;
	
	private Status activeStatus;
	private Status aprovedStatus;
	private Passport passaport;
	private Booking booking;
	private Binder<Booking> binder;
	private List<BookingLimit> bookingLimit;
	
	private ComboBox<Document> documentType;
	private ComboBox<Modality> modality;
	private ComboBox<ServiceFee> serviceFee;
	private ComboBox<Country> countryOfBirthReq;
	private ComboBox<GeneralData> gender;
	private ComboBox<GeneralData> maritalStatus;
	private ComboBox<Nationality> nationality;
	private ComboBox<Nationality> passportNationality;
	private ComboBox<GeneralData> lengthOfStayMoz;
	private ComboBox<Province> provinceAddress;
	private ComboBox<District> districtAddress;
	private ComboBox<Location> location;
	private ComboBox<CountryCode> countryCode;
	
	private ComboBox<Nationality> familyNationality1, familyNationality2, familyNationality3;
	
	private RadioButtonGroup<String> haveEverBeenToMoz;
	private RadioButtonGroup<String> haveBeenResidentMoz;
	
	private ConfirmDialog confirmDialog;
	
	private TextField surnameReq;
	private TextField nameReq;
	private TextField singleName;
	private TextField idNumber;
	private TextField localOfIssue;
	private TextField phoneNumberReq;
	private TextField professionReq;
	private TextField positionReq;
	private TextField companyReq;
	private TextField cityAddress;
	private TextField familyName1, familyName2, familyName3;
	private TextField familyRelationship1, familyRelationship2, familyRelationship3;
	private TextField familyAddress1, familyAddress2, familyAddress3;
	
	private EmailField emailReq;
	
	private TextArea neighborhoodReq;
	private TextArea reasonForLeavingMoz;
	private TextArea companiesWorkedFor;
	private TextArea streetAddress;
	private TextArea hotelReservation;
	private TextArea reasonForTravel;
	private TextArea note;
	
	int ngHoodCharLimit = 140;
	int streetCharLimit = 140;
	int hotelRsCharLimit = 120;
	int rfTravelCharLimit = 140;
	int noteCharLimit = 140;
	int rfLeavingMozCharLimit = 120;
	int cpWorkedFor = 140;
	
	private DatePicker birthdateReq;
	private DatePicker idIssue;
	private DatePicker idValidate;
	private DatePicker departureDate;
	private DatePicker residentDepartureDate;
	private DatePicker dateToSchedule;
	
	MemoryBuffer buffer;
    Upload uploadIDDoc;
	
	private Button save;
	private Button cancel;
	private Button cleanFields;
	
	Tooltip tooltipSave;
	Tooltip tooltipCancel;
	Tooltip tooltipCleanFields;
	
	public static final String DOCUMENT_TITLE_ID = "document-data";
	public static final String PERSONAL_TITLE_ID = "personal-data";
    public static final String ADDRESS_TITLE_ID = "address-title";
    public static final String SCHEDULE_TITLE_ID = "schedule-data";
    public static final String CONTACT_TITLE_ID = "contact-title";
	
	private Div headerDiv;
	private H4 header;
	private Div formCard;
	
	public VisaB17View(ServService servService, BookingService bookingService, IdentityDocumentService identityDocService, 
			StatusService statusService, DocumentService documentService, ModalityService modalityService, ServFeeService servFeeService,
			CountryService countryService, NationalityService nationalityService, ProvinceService provinceService,
			DistrictService districtService, LocationService locationService, CountryCodeService countryCodeService, 
			GeneralDataService generalDataService, FamilyService familyService, BookingLimitService bookingLimitService,
			PassportService passportService, EmailReportService emailSendingReportService, SmsReportService smsSendingReportService) {

		this.servService = servService;
		this.bookingService = bookingService;
		this.statusService = statusService;
		this.documentService = documentService;
		this.modalityService = modalityService;
		this.servFeeService = servFeeService;
		this.countryService = countryService;
		this.nationalityService = nationalityService;
		this.provinceService = provinceService;
		this.districtService = districtService;
		this.locationService = locationService;
		this.countryCodeService = countryCodeService;
		this.generalDataService = generalDataService;
		this.familyService = familyService;
		this.bookingLimitService = bookingLimitService;
		this.passportService = passportService;
		this.emailSendingReportService = emailSendingReportService;
		this.smsSendingReportService = smsSendingReportService;
		
		setAlignItems(Alignment.CENTER);
		
		createVariables();
		createService();
		createStatus();
		createDocumentType();
		createModality();
		createServiceFee();
		createCountry();
		createNationality();
		createProvince();
		createLocation();
		createCountryCode();
		createGender();
		createMaritalStatus();
		createLengthOfStayMoz();
		createFamilyNationality();
		createBinder();
	    add(createFormLayout());
	}
	
	private void createBinder() {
		booking = new Booking(); 
		binder = new BeanValidationBinder<>(Booking.class);
		binder.bindInstanceFields(this);

		binder.forField(hotelReservation)
     	.asRequired(Labels.REQUIRED_FIELD)
     	.bind(Booking::getHotelReservation, Booking::setHotelReservation);

		binder.forField(reasonForTravel)
     	.asRequired(Labels.REQUIRED_FIELD)
     	.bind(Booking::getReasonForTravel, Booking::setReasonForTravel);

		binder.forField(idNumber)
     	.asRequired(Labels.REQUIRED_FIELD)
     	.bind(Booking::getIdNumber, Booking::setIdNumber);

		binder.forField(localOfIssue)
     	.asRequired(Labels.REQUIRED_FIELD)
     	.bind(Booking::getLocalOfIssue, Booking::setIdNumber);

		binder.forField(idIssue)
     	.asRequired(Labels.REQUIRED_FIELD)
     	.bind(Booking::getIdIssue, Booking::setIdIssue);

		binder.forField(idValidate)
     	.asRequired(Labels.REQUIRED_FIELD)
     	.bind(Booking::getIdValidate, Booking::setIdValidate);

		binder.forField(passportNationality)
     	.asRequired(Labels.REQUIRED_FIELD)
     	.bind(Booking::getPassportNationality, Booking::setPassportNationality);
		
	}
	
	private Component createHeader() {
		headerDiv = new Div();
		header = new H4(Labels.DOCUMENT_TYPE_VISA_B17);
		header.getStyle().set("color", "#fff");
		headerDiv.getStyle().set("text-transform", "uppercase");
		headerDiv.addClassName("formTitle"); //.getStyle().set("background-color", "rgba(23, 137, 252, 0.3)");
		headerDiv.setWidth("100%");
		headerDiv.addClassNames(Padding.Vertical.SMALL, "header-radius");
		headerDiv.add(header);
		headerDiv.getStyle().setTextAlign(Style.TextAlign.CENTER);
		
		return headerDiv;
	}
	
	private Component createFormLayout() {
		
		FormLayout formLayout = new FormLayout();
		Hr hr = new Hr(), hr1 = new Hr(), hr2 = new Hr(), hr3 = new Hr(), hr4 = new Hr(), hr5 = new Hr(), hr6 = new Hr(), hr7 = new Hr(),
				hr8 = new Hr(), hr9 = new Hr(), hr10 = new Hr(), hr11 = new Hr(), hr12 = new Hr();
		H4 document = new H4(Labels.DOCUMENT);
		H4 citizenAddress = new H4(Labels.ADDRESS);
		H4 personalData = new H4(Labels.PERSONAL_DATA);
		H4 scheduling = new H4(Labels.SCHEDULING);
		H4 contacts = new H4(Labels.CONTACTS);
		H4 idDocument = new H4(Labels.ID_DOCUMENT);
		H4 profession = new H4(Labels.PROFESSION);
		H4 accommodationAddress = new H4(Labels.ACCOMMODATION_ADDRESS);
		H4 family = new H4(Labels.FAMILY_SECTION);
		
		formLayout.add(hr, document, documentType, modality, serviceFee, hr1, personalData, nameReq, surnameReq, birthdateReq ,singleName);
		formLayout.add(countryOfBirthReq,gender, maritalStatus, nationality, hr6, idDocument,idNumber, idIssue, idValidate, passportNationality);
		formLayout.add(hr7, profession ,professionReq ,positionReq ,companyReq);
		formLayout.add(hr2);
		formLayout.add(citizenAddress);
		formLayout.add(neighborhoodReq,createRadioButtonHaveEverBeenToMoz(),reasonForLeavingMoz,departureDate, companiesWorkedFor,
				createRadioButtonHaveBeenResidentMoz(), lengthOfStayMoz, residentDepartureDate, hr8);
		formLayout.add(accommodationAddress);
		formLayout.add(provinceAddress, districtAddress, cityAddress, streetAddress, hotelReservation);
		formLayout.add(hr9);
		formLayout.add(family);
		formLayout.add(familyName1, familyNationality1, familyRelationship1, familyAddress1);
		formLayout.add(hr10);
		formLayout.add(familyName2, familyNationality2, familyRelationship2, familyAddress2);
		formLayout.add(hr11);
		formLayout.add(familyName3, familyNationality3, familyRelationship3, familyAddress3);
		formLayout.add(hr3);
		formLayout.add(scheduling);
		formLayout.add(location, dateToSchedule, reasonForTravel);
		formLayout.add(hr4);
		formLayout.add(contacts);
		formLayout.add(countryCode);
		formLayout.add(phoneNumberReq);
		formLayout.add(emailReq);		
		formLayout.add(hr5);
		formLayout.add(createButtons());

		citizenAddress.getStyle().setTextAlign(Style.TextAlign.CENTER);
		personalData.getStyle().setTextAlign(Style.TextAlign.CENTER);
		scheduling.getStyle().setTextAlign(Style.TextAlign.CENTER);
		contacts.getStyle().setTextAlign(Style.TextAlign.CENTER);
		document.getStyle().setTextAlign(Style.TextAlign.CENTER);
		idDocument.getStyle().setTextAlign(Style.TextAlign.CENTER);
		profession.getStyle().setTextAlign(Style.TextAlign.CENTER);
		accommodationAddress.getStyle().setTextAlign(Style.TextAlign.CENTER);
		family.getStyle().setTextAlign(Style.TextAlign.CENTER);
		
		formLayout.setColspan(hr, 4);
		formLayout.setColspan(document, 4);
		formLayout.setColspan(hr1, 4);
		formLayout.setColspan(personalData, 4);
		formLayout.setColspan(citizenAddress, 4);
		formLayout.setColspan(scheduling, 4);
		formLayout.setColspan(contacts, 4);
		formLayout.setColspan(idDocument, 4);
		formLayout.setColspan(profession, 4);
		formLayout.setColspan(accommodationAddress, 4);
		formLayout.setColspan(family, 4);
		formLayout.setColspan(neighborhoodReq, 2);
		formLayout.setColspan(reasonForLeavingMoz, 2);
		formLayout.setColspan(companiesWorkedFor, 2);
		formLayout.setColspan(streetAddress, 2);
		formLayout.setColspan(reasonForTravel, 4);
		formLayout.setColspan(reasonForTravel, 4);
		formLayout.setColspan(familyAddress1, 2);
		formLayout.setColspan(familyAddress2, 2);
		formLayout.setColspan(familyAddress3, 2);
		formLayout.setColspan(note, 1);
		formLayout.setColspan(location, 2);
		formLayout.setColspan(hr2, 4);
		formLayout.setColspan(hr3, 4);
		formLayout.setColspan(hr4, 4);
		formLayout.setColspan(hr5, 4);
		formLayout.setColspan(hr6, 4);
		formLayout.setColspan(hr7, 4);
		formLayout.setColspan(hr8, 4);
		formLayout.setColspan(hr9, 4);
		formLayout.setColspan(hr10, 4);
		formLayout.setColspan(hr11, 4);
		formLayout.setColspan(hr12, 4);
		
		formCard = new Div();
	    formCard.addClassName("card-forms");
	    formCard.setWidth("80%");
	    // Configure the columns and responsive behavior
	    formLayout.setResponsiveSteps(
                new ResponsiveStep("0px", 1),
                new ResponsiveStep("600px", 2),
                new ResponsiveStep("900px", 3)
        );
	    
	    formCard.add(createHeader(), formLayout);
	    
	    return formCard;
	}
	
	private Service createService() {
		Service service = servService.getServiceByName(Constants.VISA_B17);
		return service;
	}
	
	private void createDocumentType() {
		List<Document> documentTypeItems = documentService.findForeingDocs(Constants.DOCUMENT_TYPE_CATEGORY);
		documentType.setItems(documentTypeItems);
		documentType.setItemLabelGenerator(Document::getName);
		documentType.setValue(documentTypeItems.get(0));
	}
	
	private void createModality() {
		List<Modality> modalityItems = modalityService.findModalityByCategory(Constants.FOREIGN);
		modality.setItems(modalityItems);
		modality.setItemLabelGenerator(Modality::getName);
	}
	
	private void createServiceFee() {
		List<ServiceFee> serviceFeeItems = servFeeService.findForeignServiceFee();
		serviceFee.setItems(serviceFeeItems);
		serviceFee.setItemLabelGenerator(ServiceFee::getName);
		serviceFee.setValue(serviceFeeItems.get(0));
	}
	
	private void createCountry() {
		List<Country> countryItems = countryService.findAll();
		countryOfBirthReq.setItems(countryItems);
		countryOfBirthReq.setItemLabelGenerator(Country::getName);		
	}
	
	private void createNationality() {
		List<Nationality> nationalityItems = nationalityService.findAll();
		nationality.setItems(nationalityItems);
		nationality.setItemLabelGenerator(Nationality::getName);

		passportNationality.setItems(nationalityItems);
		passportNationality.setItemLabelGenerator(Nationality::getName);
	}
	
	private void createGender() {
		List<GeneralData> genderItems = generalDataService.findGeneralDataByCategory(Constants.GENDER); 
		gender.setItems(genderItems);
		gender.setItemLabelGenerator(GeneralData::getName);
	}
	
	private void createMaritalStatus() {
		List<GeneralData> maritalStatusItems = generalDataService.findGeneralDataByCategory(Constants.MARITAL_STATUS);
		maritalStatus.setItems(maritalStatusItems);
		maritalStatus.setItemLabelGenerator(GeneralData::getName);
	}
	
	private void createProvince() {
		List<Province> provinceItems = provinceService.findAll();
		provinceAddress.setItems(provinceItems);
		provinceAddress.setItemLabelGenerator(Province::getName);
	}
	
	private void createLocation() {
		List<Location> locationItems = locationService.findAll();
		location.setItems(locationItems);
		location.setItemLabelGenerator(Location::getName);
	}
	
	private void createCountryCode() {
		List<CountryCode> countryCodeItems = countryCodeService.findAll();
		
		CountryCode countryCodeMoz = countryCodeItems.stream()
                .filter(obj -> obj.getCode().equals(Constants.COUNTRY_CODE_MZ))
                .collect(Collectors.toList()).get(0);
		
		countryCode.setItems(countryCodeItems);
		countryCode.setValue(countryCodeMoz);
		countryCode.setItemLabelGenerator(CountryCode::getName);
	}
	
	private void createStatus() {
		activeStatus = statusService.getStatusByCode("A");
		aprovedStatus = statusService.getStatusByCode("AP");
	}
	
	private void createLengthOfStayMoz() {
		List<GeneralData> lengthOfStayItems = generalDataService.findGeneralDataByCategory(Constants.PERIOD_OF_STAY);
		lengthOfStayMoz.setItems(lengthOfStayItems);
		lengthOfStayMoz.setItemLabelGenerator(GeneralData::getName);
	}
	
	private void createFamilyNationality() {
		List<Nationality> nationalityItems = nationalityService.findAll();
		
		familyNationality1.setItems(nationalityItems);
		familyNationality1.setItemLabelGenerator(Nationality::getName);
		
		familyNationality2.setItems(nationalityItems);
		familyNationality2.setItemLabelGenerator(Nationality::getName);
		
		familyNationality3.setItems(nationalityItems);
		familyNationality3.setItemLabelGenerator(Nationality::getName);
		
	}
	/*
	private void createUploadIDDoc() {
		
		UploadExamplesI18N i18n = new UploadExamplesI18N();
        i18n.getAddFiles().setOne("Upload Report...");
        i18n.getDropFiles().setOne("Drop report here");
        i18n.getError().setIncorrectFileType(
                "The provided file does not have the correct format (PDF document).");
        uploadIDDoc.setI18n(i18n);

        H4 title = new H4("Upload report");
        title.getStyle().set("margin-top", "0");
        Paragraph hint = new Paragraph("Accepted file formats: PDF (.pdf)");
        hint.getStyle().set("color", "var(--lumo-secondary-text-color)");

	}*/
	
	private void createVariables() {
		this.booking = new Booking();
		new IdentityDocument();
		this.passaport = new Passport();
		this.documentType = new ComboBox<Document>(Labels.DOCUMENT_TYPE);
		this.documentType.setHelperText(Labels.SELECT_DOCUMENT_TYPE_HELPER_TEXT);
		
		this.modality = new ComboBox<Modality>(Labels.MODALITY);
		this.modality.setHelperText(Labels.SELECT_MODALITY_HELPER_TEXT);
		
		this.serviceFee = new ComboBox<ServiceFee>(Labels.SERVICE_FEE);
		this.serviceFee.setHelperText(Labels.SELECT_SERVICE_FEE_HELPER_TEXT);
		 
		this.surnameReq = new TextField(Labels.SURNAME);
		this.surnameReq.setHelperText(Labels.TYPE_YOUR_SURNAME);
		this.surnameReq.setClearButtonVisible(true);

		this.nameReq = new TextField(Labels.FULLNAME);
		this.nameReq.setHelperText(Labels.TYPE_YOUR_FULLNAME);
		this.nameReq.setClearButtonVisible(true);
		
		this.birthdateReq = new DatePicker(Labels.BITHDATE);
		this.birthdateReq.setHelperText(Labels.TYPE_YOUR_BITHDATE);
		this.birthdateReq.setClearButtonVisible(true);

        this.singleName = new TextField(Labels.SINGLE_NAME);
		this.singleName.setHelperText(Labels.TYPE_YOUR_SINGLE_NAME);
		this.singleName.setClearButtonVisible(true);
		
		this.idNumber = new TextField(Labels.PASSPORT_DOC_NUMBER);
		this.idNumber.setHelperText(Labels.TYPE_YOUR_PASSAPORT_DOC_NUMBER);
		this.idNumber.setRequired(true);
		this.idNumber.setClearButtonVisible(true);
		
		this.idValidate = new DatePicker(Labels.PASSPORT_DOC_VALIDATE);
		this.idValidate.setHelperText(Labels.TYPE_YOUR_PASSPORT_DOC_VALIDATE);
		this.idValidate.setRequired(true);
		this.idValidate.setClearButtonVisible(true);
		
		this.idIssue = new DatePicker(Labels.IDENTITY_DOC_ISSUE_DATE);
		this.idIssue.setHelperText(Labels.TYPE_YOUR_PASSAPORT_DOC_NUMBER);
		this.idIssue.setRequired(true);
		this.idIssue.setClearButtonVisible(true);
		
		this.localOfIssue = new TextField(Labels.LOCAL_OF_ISSUE);
		this.localOfIssue.setHelperText(Labels.TYPE_YOUR_LOCAL_OF_ISSUE);
		this.localOfIssue.setRequired(true);
		this.localOfIssue.setClearButtonVisible(true);
		
		this.countryOfBirthReq = new ComboBox<Country>(Labels.COUNTRY_OF_BIRTH);
		this.countryOfBirthReq.setHelperText(Labels.SELECT_COUNTRY_OF_BIRTH_HELPER_TEXT);
		
        this.gender = new ComboBox<GeneralData>(Labels.GENDER);
        this.gender.setHelperText(Labels.GENDER_HELPER_TEXT);
        this.gender.setRequired(true);
        
        this.maritalStatus = new ComboBox<GeneralData>(Labels.MARITAL_STATUS);
        this.maritalStatus.setHelperText(Labels.MARITAL_STATUS_HELPER_TEXT);
        this.maritalStatus.setRequired(true);

        this.nationality = new ComboBox<Nationality>(Labels.NATIONALITY);
        this.nationality.setHelperText(Labels.SELECT_YOUR_NATIONALITY);
                
        this.passportNationality = new ComboBox<Nationality>(Labels.PASSPORT_NATIONALITY);
        this.passportNationality.setHelperText(Labels.SELECT_YOUR_PASSPORT_NATIONALITY);
        
        this.professionReq = new TextField(Labels.PROFESSION_OCCUPATION);
		this.professionReq.setHelperText(Labels.TYPE_YOUR_PROFESSION_OCCUPATION);
		this.professionReq.setClearButtonVisible(true);

        this.positionReq = new TextField(Labels.POSITION_HELD);
		this.positionReq.setHelperText(Labels.TYPE_YOUR_POSITION_HELD);
		this.positionReq.setClearButtonVisible(true);

        this.companyReq = new TextField(Labels.COMPANY_OR_ORGANIZATION);
		this.companyReq.setHelperText(Labels.TYPE_YOUR_COMPANY_OR_ORGANIZATION);
		this.companyReq.setClearButtonVisible(true);

		this.neighborhoodReq = new TextArea(Labels.PERMANENT_RESIDENTIAL_ADDRESS);
		this.neighborhoodReq.setMaxLength(ngHoodCharLimit);
		this.neighborhoodReq.setValueChangeMode(ValueChangeMode.EAGER);
		this.neighborhoodReq.setHelperText("0/"+ngHoodCharLimit+" "+Labels.OPTIONAL);
		this.neighborhoodReq.setClearButtonVisible(true);
		this.neighborhoodReq.addValueChangeListener(e -> {
            e.getSource()
                    .setHelperText(e.getValue().length() + "/" + ngHoodCharLimit+" "+Labels.OPTIONAL);
        });
		
		this.reasonForLeavingMoz = new TextArea(Labels.REASON_TO_LEAVE_MOZ);
		this.reasonForLeavingMoz.setMaxLength(rfLeavingMozCharLimit);
		this.reasonForLeavingMoz.setValueChangeMode(ValueChangeMode.EAGER);
		this.reasonForLeavingMoz.setHelperText("0/"+rfLeavingMozCharLimit+" "+Labels.OPTIONAL);
		this.reasonForLeavingMoz.setClearButtonVisible(true);
		this.reasonForLeavingMoz.addValueChangeListener(e -> {
            e.getSource()
                    .setHelperText(e.getValue().length() + "/" + rfLeavingMozCharLimit+" "+Labels.OPTIONAL);
        });
		
		this.departureDate = new DatePicker(Labels.DEPARTURE_DATE);
		this.departureDate.setHelperText(Labels.TYPE_YOUR_DEPARTURE_DATE);
		this.departureDate.setClearButtonVisible(true);
		
        this.companiesWorkedFor = new TextArea(Labels.COMPANIES_WORKED_FOR);
        this.companiesWorkedFor.setMaxLength(cpWorkedFor);
        this.companiesWorkedFor.setValueChangeMode(ValueChangeMode.EAGER);
        this.companiesWorkedFor.setHelperText("0/"+cpWorkedFor);
        this.companiesWorkedFor.setClearButtonVisible(true);
        this.companiesWorkedFor.addValueChangeListener(e -> {
            e.getSource()
                    .setHelperText(e.getValue().length() + "/" + cpWorkedFor);
        });      

        this.provinceAddress = new ComboBox<Province>(Labels.PROVINCE);
        this.provinceAddress.setHelperText(Labels.SELECT_YOUR_PROVINCE);
		
		this.streetAddress = new TextArea(Labels.STREET_ADDRESS);
		this.streetAddress.setMaxLength(streetCharLimit);
		this.streetAddress.setValueChangeMode(ValueChangeMode.EAGER);
		this.streetAddress.setHelperText("0/"+streetCharLimit+" "+Labels.OPTIONAL);
		this.streetAddress.setClearButtonVisible(true);
		this.streetAddress.addValueChangeListener(e -> {
            e.getSource()
                    .setHelperText(e.getValue().length() + "/" + ngHoodCharLimit+" "+Labels.OPTIONAL);
        });
		
		this.hotelReservation = new TextArea(Labels.HOTEL_RESERVATION);
		this.hotelReservation.setMaxLength(hotelRsCharLimit);
		this.hotelReservation.setValueChangeMode(ValueChangeMode.EAGER);
		this.hotelReservation.setHelperText("0/"+hotelRsCharLimit+" "+Labels.OPTIONAL);
		this.hotelReservation.setClearButtonVisible(true);
		this.hotelReservation.addValueChangeListener(e -> {
            e.getSource()
                    .setHelperText(e.getValue().length() + "/" + hotelRsCharLimit+" "+Labels.OPTIONAL);
        });
		
		this.reasonForTravel = new TextArea(Labels.REASON_FOR_TRAVEL);
        this.reasonForTravel.setMaxLength(rfTravelCharLimit);
        this.reasonForTravel.setValueChangeMode(ValueChangeMode.EAGER);
        this.reasonForTravel.setHelperText("0/"+rfTravelCharLimit+" "+Labels.REASON_FOR_TRAVEL_HELPER_TEXT);
        this.reasonForTravel.setClearButtonVisible(true);
        this.reasonForTravel.addValueChangeListener(e -> {
            e.getSource()
                    .setHelperText(e.getValue().length() + "/" + rfTravelCharLimit+" "+Labels.REASON_FOR_TRAVEL_HELPER_TEXT);
        });
        
        this.note = new TextArea(Labels.NOTE);
        this.note.setMaxLength(noteCharLimit);
        this.note.setValueChangeMode(ValueChangeMode.EAGER);
        this.note.setHelperText("0/"+noteCharLimit+" "+Labels.NOTE_HELPER_TEXT);
        this.note.setClearButtonVisible(true);
        this.note.addValueChangeListener(e -> {
            e.getSource()
                    .setHelperText(e.getValue().length() + "/" + noteCharLimit+" "+Labels.OPTIONAL);
        });
        
       this.dateToSchedule = new DatePicker(Labels.DATE_TO_SCHEDULE);
        this.dateToSchedule.setEnabled(false);
        // Add a value change listener with the custom validator
        this.dateToSchedule.setHelperText(Labels.DATE_TO_SCHEDULE_HELPER_TEXT);
        this.dateToSchedule.setClearButtonVisible(true);
        // Add a value change listener with the custom validator
        dateToSchedule.addValueChangeListener(event -> {
            LocalDate selectedDate = event.getValue();
            if (selectedDate != null && !isWorkingDay(selectedDate)) {
                Notification notification = new Notification(Labels.SELECT_ONLY_WORKING_DAYS, 7000,
                        Position.TOP_CENTER);
                notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                notification.open();
                dateToSchedule.clear();
            }else
            	if(location.getValue() != null && dateToSchedule.getValue() != null) {
            		maximumDailyCapacityReached();
            	}
        });
        
        this.provinceAddress.addValueChangeListener(event -> {
            Province selectedValue = event.getValue();
            // Update options of targetComboBox based on selectedValue
            // You can fetch the options from a database or a predefined list
            List<District> options = districtService.findDistrictByProvinceId(selectedValue.getProvinceId());
            System.out.println(options.size());
            if(options != null && options.size() > 0) {
            	districtAddress.clear();
                districtAddress.setItems(options);
                districtAddress.setItemLabelGenerator(District::getName);
                districtAddress.setPlaceholder(Labels.SELECT_THE_DISTRICT);
                districtAddress.setEnabled(true);
                districtAddress.setHelperText(Labels.SELECT_YOUR_DISTRICT);
            }else {
            	System.out.println("ELSE");
            	districtAddress.clear();
            	districtAddress.setPlaceholder(Labels.SELECT_THE_DISTRICT);
            	districtAddress.setEnabled(false);
            }
            
        });
        
        this.districtAddress = new ComboBox<District>(Labels.CITY_OR_DISTRICT);
        this.districtAddress.setEnabled(false);

		this.cityAddress = new TextField(Labels.CITY);
		this.cityAddress.setHelperText(Labels.TYPE_YOUR_CITY);
		this.cityAddress.setClearButtonVisible(true);
		
		this.location = new ComboBox<Location>(Labels.PLACE_TO_SCHEDULE);
        this.location.setHelperText(Labels.PLACE_TO_SCHEDULE_HELPER_TEXT);
        this.location.addValueChangeListener(e -> {
        	if(location.getValue() != null)
        		dateToSchedule.setEnabled(true);
        	else {
        		dateToSchedule.setEnabled(false);
        		dateToSchedule.clear();
        	}
        });

        this.countryCode = new ComboBox<CountryCode>(Labels.COUNTRY_CODE);
        this.countryCode.setHelperText(Labels.SELECT_YOUR_COUNTRY_CODE);
        this.countryCode.addValueChangeListener(e -> {
        	if(this.countryCode.getValue() != null && this.countryCode.getValue().getName().equals("Mozambique(+258)"))
        	{
                this.phoneNumberReq.setMinLength(9);
                this.phoneNumberReq.setMaxLength(9);
        	}else {
                this.phoneNumberReq.setMinLength(5);
                this.phoneNumberReq.setMaxLength(18);
        	}
        });
        
        this.phoneNumberReq = new TextField(Labels.PHOME_NUMBER);
        this.phoneNumberReq.setHelperText(Labels.TYPE_YOUR_PHONE_NUMBER);
        this.phoneNumberReq.setPrefixComponent(VaadinIcon.PHONE.create());
        this.phoneNumberReq.setAllowedCharPattern("[0-9]");
        this.phoneNumberReq.addValueChangeListener(e -> {
        	if(this.countryCode.getValue() != null && this.countryCode.getValue().getName().equals("Mozambique(+258)"))
        	{	String number = this.phoneNumberReq.getValue();
        	
        		if(!number.startsWith("82") && !number.startsWith("83") && !number.startsWith("84") && !number.startsWith("85")
        				&& !number.startsWith("86") && !number.startsWith("87")) {
        			Notification notification = Notification.show(Labels.TYPE_VALID_PHONE_NUMBER_258, 5000,
                            Position.TOP_CENTER);
                    notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
                    
                    phoneNumberReq.clear();
        		}
        	}
        });
        this.phoneNumberReq.setClearButtonVisible(true);
        
        this.emailReq = new EmailField(Labels.EMAIL);
        this.emailReq.setHelperText(Labels.TYPE_YOUR_EMAIL);
        this.emailReq .setPlaceholder("exemplo@gmail.com");
        this.emailReq.setClearButtonVisible(true);
        this.emailReq.setPrefixComponent(VaadinIcon.ENVELOPE.create());
        
        this.lengthOfStayMoz = new ComboBox<GeneralData>(Labels.PERIOD_OF_STAY);
        this.lengthOfStayMoz.setHelperText(Labels.MARITAL_STATUS_HELPER_TEXT);
        this.lengthOfStayMoz.setRequired(true);
        
        this.residentDepartureDate = new DatePicker(Labels.DEPARTURE_DATE);
        this.residentDepartureDate.setHelperText(Labels.TYPE_YOUR_DEPARTURE_DATE);
        this.residentDepartureDate.setClearButtonVisible(true);
        
        this.familyName1 = new TextField(Labels.FULLNAME);
        this.familyName1.setClearButtonVisible(true);

        this.familyName2 = new TextField(Labels.FULLNAME);
        this.familyName2.setClearButtonVisible(true);

        this.familyName3 = new TextField(Labels.FULLNAME);
        this.familyName3.setClearButtonVisible(true);
        
        this.familyRelationship1 = new TextField(Labels.FAMILY_RELATIONSHIP);
        this.familyRelationship1.setClearButtonVisible(true);

        this.familyRelationship2 = new TextField(Labels.FAMILY_RELATIONSHIP);
        this.familyRelationship2.setClearButtonVisible(true);

        this.familyRelationship3 = new TextField(Labels.FAMILY_RELATIONSHIP);
        this.familyRelationship3.setClearButtonVisible(true);
        
        this.familyAddress1 = new TextField(Labels.FAMILY_ADDRESS);
        this.familyAddress1.setClearButtonVisible(true);

        this.familyAddress2 = new TextField(Labels.FAMILY_ADDRESS);
        this.familyAddress2.setClearButtonVisible(true);

        this.familyAddress3 = new TextField(Labels.FAMILY_ADDRESS);
        this.familyAddress3.setClearButtonVisible(true);
        
        this.familyNationality1 = new ComboBox<Nationality>(Labels.NATIONALITY);
        this.familyNationality2 = new ComboBox<Nationality>(Labels.NATIONALITY);
        this.familyNationality3 = new ComboBox<Nationality>(Labels.NATIONALITY);
        
        this.buffer = new MemoryBuffer();
        this.uploadIDDoc = new Upload(buffer);
        uploadIDDoc.setAcceptedFileTypes("application/pdf", ".pdf");
        uploadIDDoc.addFileRejectedListener(event -> {
            String errorMessage = event.getErrorMessage();

            Notification notification = Notification.show(errorMessage, 5000,
                    Notification.Position.MIDDLE);
            notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
        });
        
        confirmDialog = new ConfirmDialog();
        
        save = new Button(Constants.SAVE);
		this.cleanFields = new Button(Constants.CLEAN);
		this.cancel = new Button(Constants.CANCEL);
		
	}
	
	private Component createButtons() {
		save.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		tooltipSave = Tooltip.forComponent(save)
		        .withText(Labels.TOOLTIP_SAVE_FORM)
		        .withPosition(Tooltip.TooltipPosition.TOP_START);
		save.addClickListener(e -> createConfirmDialog());
		
		cancel.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_ERROR);
		tooltipCancel = Tooltip.forComponent(cancel)
		        .withText(Labels.TOOLTIP_CANCEL_FORM)
		        .withPosition(Tooltip.TooltipPosition.TOP_START);
		cancel.addClickListener(e -> navigateToView("/agendar"));
		
		cleanFields.addClickListener(e -> clearFields());
		tooltipCleanFields = Tooltip.forComponent(cleanFields)
		        .withText(Labels.TOOLTIP_CLEAN_FIELDS_FORM)
		        .withPosition(Tooltip.TooltipPosition.TOP);
		
		return new HorizontalLayout(cancel, cleanFields, save);
	}
	
	 private Component createRadioButtonHaveEverBeenToMoz() {
	        haveEverBeenToMoz = new RadioButtonGroup<>();
	        haveEverBeenToMoz.setLabel(Labels.HAVE_BEEN_TO_MOZ);
	        haveEverBeenToMoz.setItems(Labels.YES, Labels.NO);
	        haveEverBeenToMoz.setValue(Labels.NO);
	        return haveEverBeenToMoz;
	 }
	  
	 private Component createRadioButtonHaveBeenResidentMoz() {
		 	haveBeenResidentMoz = new RadioButtonGroup<>();
		 	haveBeenResidentMoz.setLabel(Labels.HAVE_BEEN_RESIDENT_MOZ);
		 	haveBeenResidentMoz.setHelperText(Labels.MARK_YOUR_HAVE_BEEN_RESIDENT_MOZ);
		 	haveBeenResidentMoz.setItems(Labels.YES, Labels.NO);
		 	haveBeenResidentMoz.setValue(Labels.NO);
	        return haveBeenResidentMoz;
	 }
	 
	 private void createConfirmDialog() {
		 try {
			 nameReq.setValue(nameReq.getValue().trim());
			 surnameReq.setValue(surnameReq.getValue().trim());
			 idNumber.setValue(idNumber.getValue().trim());
			 localOfIssue.setValue(localOfIssue.getValue().trim());
			 reasonForTravel.setValue(reasonForTravel.getValue().trim());
			 
			 this.idNumber.isRequiredIndicatorVisible();
			 this.idNumber.setInvalid(true);
			 if(binder.isValid()) {

				 binder.writeBean(booking);
				 
				 confirmDialog = new ConfirmDialog();
				 confirmDialog.setCancelable(true);
				 confirmDialog.setCancelText(Constants.CANCEL);
				 confirmDialog.setCancelButtonTheme("error primary");
				 confirmDialog.setConfirmText(Labels.CONFIRM_BOOKING_LATER_BUTTON);
				 confirmDialog.setConfirmButton(Labels.CONFIRM_BOOKING_BUTTON, e -> saveBooking());
		         
				 confirmDialog.setHeader(Labels.CONFIRM_BOOKING);
				 confirmDialog.add(new H5(Labels.BOOKING_CONFIRMATION+" "+Labels.DOCUMENT_TYPE_VISA_B17));
				 
				 UnorderedList unorderedList = new UnorderedList();
	
			        // Create and add list items to the UnorderedList
			        ListItem item1 = new ListItem(Labels.NAME+": "+nameReq.getValue()+" "+surnameReq.getValue());
			        ListItem item2 = new ListItem(Labels.DOCUMENT_TYPE+": "+documentType.getValue().getName());
			        ListItem item3 = new ListItem(Labels.SCHEDULED_DATE+": "+dateToSchedule.getValue());
			        ListItem item4 = new ListItem(Labels.SELECTED_LOCATION+": "+location.getValue().getName());
			        
			        unorderedList.add(item1, item2, item3, item4);
			        confirmDialog.add(unorderedList);
				 
				 confirmDialog.setConfirmButtonTheme("success primary");
		             
				 confirmDialog.setWidth("50%");
		        
				 confirmDialog.open();
			 }else {
				 	Notification notification = Notification.show(Labels.FILL_IN_ALL_REQUIRED_FIELDS, 7000, Position.TOP_CENTER); 
					notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
					binder.writeBean(booking);
			 }
				 
		 } catch (Exception e) {
			 if(binder.isValid()) {
					Notification notification = Notification.show(Labels.SAVED_BOOKING_ERROR); 
					notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
					notification.setPosition(Position.TOP_CENTER);
					
					e.printStackTrace();
				}
		}
	 }

	 private void saveBooking() {
			try {
				Div content = new Div();
				
				this.passaport.setName(booking.getNameReq());
				this.passaport.setSurname(booking.getSurnameReq());
				this.passaport.setPassportNumber(booking.getIdNumber());
				this.passaport.setValidate(booking.getIdValidate());
				this.passaport.setIssueDate(booking.getIdIssue());
				this.passaport.setCreatedBy(booking.getNameReq()+" "+booking.getSurnameReq());
				this.passaport.setStatus(activeStatus);
				this.passaport.setLocalOfIssue("");
				this.passaport.setNationality(passportNationality.getValue());
				
				this.booking.setBookingId(AlphanumericGenerator.generateAlphanumericValue());
				this.booking.setService(createService());
				this.booking.setCreatedBy(booking.getNameReq()+" "+booking.getSurnameReq());
				this.booking.setVersion(1);
				
				this.booking.setPassport(passaport);
				this.booking.setStatus(aprovedStatus);
				
				this.booking.setCompanyReq(Constants.NOT_APPLICABLE);
				this.booking.setProfessionReq(Constants.NOT_APPLICABLE);
				
				this.booking.setPositionReq(Constants.NOT_APPLICABLE);
				
				Booking activeBooking = bookingService.getBookingByIDDocNumberAndStatusAndDate(idNumber.getValue(), booking.getService().getServiceId(), Constants.STATUS_APROVEDAPPROVED_FOR_CAPTURE_CODE);
				List<Booking> bookingsWithSamePhone = bookingService.findByPhoneNumberAndStatusAndDate(phoneNumberReq.getValue(), Constants.STATUS_APROVEDAPPROVED_FOR_CAPTURE_CODE);
				
				if(activeBooking != null) {
					 ConfirmDialog dialog = new ConfirmDialog();
					 
				     dialog.setHeader(Labels.APPLICANT_HAS_AN_ACTIVE_SCHEDULE);
				     String html = Labels.APPLICANT_HAS_AN_ACTIVE_SCHEDULE_TEXT_INFO;
				     html = html.replace("#1", booking.getDateToScheduleFormated());
				     html = html.replace("#2", booking.getLocation().getName());
				     html = html.replace("#3", booking.getService().getName());
				     content.add(new Html(html));
				        
				     dialog.setText(content);
				     
				     dialog.setCancelable(true);
				     dialog.setCancelText("Pesquisar Agendamento");
				     dialog.addCancelListener(event -> { navigateToView("agendamentos"); });

				     dialog.setRejectable(true);
				     dialog.setRejectText("Reagendar");
				     dialog.setRejectButtonTheme("success primary");
				     dialog.addRejectListener(event -> { navigateToView("agendamentos"); 
				     	Notification notification = Notification.show(Labels.SEARCH_FOR_BOOKING, 10000, Position.BOTTOM_CENTER); 
						notification.addThemeVariants(NotificationVariant.LUMO_PRIMARY);
				     });

				     dialog.setConfirmText("Fechar");
				     dialog.addConfirmListener(event -> { navigateToView("agendar"); });
				     
				     dialog.open();
				}else 
				if(bookingsWithSamePhone != null && bookingsWithSamePhone.size() >= 5){
					ConfirmDialog dialog = new ConfirmDialog();
					 
				     dialog.setHeader(Labels.APPLICANT_HAS_MORE_THAN_FIVE_BOOKINGS);
				     String html = Labels.APPLICANT_HAS_MORE_THAN_FIVE_BOOKINGS_TEXT_INFO;
				     html = html.replace("#1", booking.getPhoneNumberReq());
				     content.add(new Html(html));
				        
				     dialog.setText(content);
				     
				     dialog.setConfirmText("OK");

				     dialog.open();
				}
				else{
					Booking existingBooking = bookingService.getBookingByBookingId(booking.getBookingId());
					while(existingBooking != null) {
						this.booking.setBookingId(AlphanumericGenerator.generateAlphanumericValue());
						existingBooking = bookingService.getBookingByBookingId(booking.getBookingId());
				}
					passportService.save(passaport);
					bookingService.save(booking);
					
					if(familyName1.getValue() != null && familyNationality1.getValue() != null) {
						familyService.save(createFamily(booking, familyName1.getValue(), familyNationality1.getValue(), familyRelationship1.getValue(), 
								familyAddress1.getValue(), booking.getNameReq()+" "+booking.getSurnameReq()));
					}
					if(familyName2.getValue() != null && familyNationality2.getValue() != null) {
						familyService.save(createFamily(booking, familyName2.getValue(), familyNationality2.getValue(), familyRelationship2.getValue(), 
								familyAddress2.getValue(), booking.getNameReq()+" "+booking.getSurnameReq()));
					}
					if(familyName3.getValue() != null && familyNationality3.getValue() != null) {
						familyService.save(createFamily(booking, familyName3.getValue(), familyNationality3.getValue(), familyRelationship3.getValue(), 
								familyAddress3.getValue(), booking.getNameReq()+" "+booking.getSurnameReq()));
					}
					
					notifyAfterBooking();
					
					navigateToView("/");
					Notification notification = Notification.show(Labels.SAVED_BOOKING_SUCCESSFULLY+" "+booking.getBookingId(), 10000, Position.TOP_CENTER); 
					notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
				}
				
			} catch (Exception e) {
				Notification notification = Notification.show(Labels.SAVED_BOOKING_ERROR); 
				notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
				notification.setPosition(Position.TOP_CENTER);
				
				e.printStackTrace();
				
			}
	 }
	 
	 private Family createFamily(Booking booking, String name, Nationality nationality, String relationship, String address, String createdBy) {
		 return new Family(booking, name, nationality, relationship, address, activeStatus, createdBy, LocalDate.now(), null, null, 1);
	 }
	 
	 private boolean maximumDailyCapacityReached() {
		 Location selectedLocal = location.getValue();		 
		 LocalDate date = dateToSchedule.getValue();
		 LocalDate date1 = getNexWorkingDay(date), date2 = getNexWorkingDay(date1), date3 = getNexWorkingDay(date2);
		 bookingLimit = bookingLimitService.findBookingLimitByDatesAndLocatio(date, date1, date2, date3, selectedLocal.getLocationId());
		 
		 if(bookingLimit != null && bookingLimit.get(0).getTotal_date_bookings() >= selectedLocal.getMaxLeadDays()) {
			 bookingMaxLeadDayDialog(dateToSchedule.getValue(), selectedLocal.getMaxLeadDays());
			 dateToSchedule.clear();
		 }
		 
		 if(selectedLocal.getMaxLeadDays() > 5)
			 return true;
		 
		 return false;
	 }
	 
	 private void notifyAfterBooking() {
		 
		 notificationManager = new NotificationManager(emailSendingReportService, smsSendingReportService);
		 String firstNameReq = booking.getNameReq().trim().contains(" ") ? booking.getNameReq().trim().split(" ")[0] : booking.getNameReq();
		 
		 notificationManager.sendSMSBookingNotification(booking, Notifications.SMS_BOOKING_SUCCESS.replace("#name", firstNameReq.concat(" "+booking.getSurnameReq()))
				 .replace("#code", booking.getBookingId()).replace("#doc", Labels.VISA).replace("#local", booking.getLocation().getName())
				 .replace("#date", booking.getDateToScheduleFormated()));
			
			if(booking.getEmailReq() != null && booking.getEmailReq().trim() != "") {
				
				String htmlBody = Notifications.EMAIL_HTML_BODY_BOOKING;
				htmlBody = htmlBody.replace("#fullname", booking.getNameReq().concat(" ").concat(booking.getSurnameReq()))
						.replace("#doc", booking.getService().getName())
						.replace("#code", booking.getBookingId()).replace("#date", booking.getDateToScheduleFormated())
						.replace("#local", booking.getLocation().getName());
				
				notificationManager.sendHtmlEmailNotification(booking.getEmailReq(), "", "", Notifications.EMAIL_SUBJECT_BOOKING, htmlBody, booking);
			}
	 }
	 
	 private LocalDate getNexWorkingDay(LocalDate date) {
		 if(date.getDayOfWeek() == DayOfWeek.FRIDAY) {
			 return date.plusDays(3);
		 }else
			 if(date.getDayOfWeek() == DayOfWeek.SATURDAY) {
				 return date.plusDays(2);
			 }else
				return date.plusDays(1);
	 }
	 
	 private void bookingMaxLeadDayDialog(LocalDate date, int limit) {
		 Div content = new Div();
		 Html text;
		 int count = 0;
		 UnorderedList unorderedList = new UnorderedList();
		 for(BookingLimit element : bookingLimit) {
			 if(element.getTotal_date_bookings() < limit)
			 {
				 ListItem item = new ListItem(element.getBooking_date().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
				 unorderedList.add(item);
				 count++;
			 }
		 }
		
		if(count > 0) 
			text = new Html(Labels.UNAVAILABLE_DATE_TEXT_INFO.replace("#", date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
		else
			text = new Html(Labels.UNAVAILABLE_DATE_TEXT_INFO);
	     
		 content.add(text, unorderedList);

	     ConfirmDialog dialog = new ConfirmDialog();
	     dialog.setHeader(Labels.UNAVAILABLE_DATE);
	        
	     dialog.setText(content);

	     dialog.setConfirmText("OK");

	     dialog.open();
	 }
	 
	 private void clearFields() {
			booking = new Booking();
			binder.getFields().forEach(HasValue::clear);
	}
	
	private void navigateToView(String route) {
		getUI().ifPresent(ui -> ui.navigate(route));
	}
	
	private boolean isWorkingDay(LocalDate date) {
     DayOfWeek dayOfWeek = date.getDayOfWeek();
     return dayOfWeek != DayOfWeek.SATURDAY && dayOfWeek != DayOfWeek.SUNDAY;
 }
}
