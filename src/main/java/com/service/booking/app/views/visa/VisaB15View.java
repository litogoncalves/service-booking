package com.service.booking.app.views.visa;

import java.util.List;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.constants.Labels;
import com.service.booking.app.data.entity.Booking;
import com.service.booking.app.data.entity.Country;
import com.service.booking.app.data.entity.CountryCode;
import com.service.booking.app.data.entity.District;
import com.service.booking.app.data.entity.Document;
import com.service.booking.app.data.entity.GeneralData;
import com.service.booking.app.data.entity.IdentityDocument;
import com.service.booking.app.data.entity.Location;
import com.service.booking.app.data.entity.Modality;
import com.service.booking.app.data.entity.Nationality;
import com.service.booking.app.data.entity.Province;
import com.service.booking.app.data.entity.Service;
import com.service.booking.app.data.entity.ServiceFee;
import com.service.booking.app.data.entity.Status;
import com.service.booking.app.data.service.BookingService;
import com.service.booking.app.data.service.CountryCodeService;
import com.service.booking.app.data.service.CountryService;
import com.service.booking.app.data.service.DistrictService;
import com.service.booking.app.data.service.DocumentService;
import com.service.booking.app.data.service.GeneralDataService;
import com.service.booking.app.data.service.IdentityDocumentService;
import com.service.booking.app.data.service.LocationService;
import com.service.booking.app.data.service.ModalityService;
import com.service.booking.app.data.service.NationalityService;
import com.service.booking.app.data.service.ProvinceService;
import com.service.booking.app.data.service.ServFeeService;
import com.service.booking.app.data.service.ServService;
import com.service.booking.app.data.service.StatusService;
import com.service.booking.app.utils.AlphanumericGenerator;
import com.service.booking.app.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.HasValue;
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

@PageTitle("Visa B15 | SIGAV - Sistema de Gestão de Agendamentos e Validações")
@Route(value = "visaB15", layout = MainLayout.class)
@AnonymousAllowed
public class VisaB15View extends VerticalLayout {

	private static final long serialVersionUID = 1L;
	
	private final ServService servService;
	private final BookingService bookingService;
	private final IdentityDocumentService identityDocService;
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
	
	private Status activeStatus;
	private Status aprovedStatus;
	private IdentityDocument identityDoc;
	private Booking booking;
	private Binder<Booking> binder;
	
	private ComboBox<Document> documentType;
	private ComboBox<Modality> modality;
	private ComboBox<ServiceFee> serviceFee;
	private ComboBox<Country> countryOfBirthReq;
	private ComboBox<Nationality> nationality;
	private ComboBox<Nationality> passportNationality;
	private ComboBox<Province> provinceAddress;
	private ComboBox<District> districtAddress;
	private ComboBox<Location> location;
	private ComboBox<CountryCode> countryCode;
	private ComboBox<GeneralData> gender;
	private ComboBox<GeneralData> maritalStatus;
	private ComboBox<GeneralData> lengthOfStayMoz;
	
	private RadioButtonGroup<String> haveEverBeenToMoz;
	private RadioButtonGroup<String> haveBeenResidentMoz;
	
	private ConfirmDialog confirmDialog;
	
	private TextField surnameReq;
	private TextField nameReq;
	private TextField idNumber;
	private TextField localOfIssue;
	private TextField phoneNumberReq;
	private TextField singleName;
	private TextField professionReq;
	private TextField positionReq;
	private TextField companyReq;
	private TextField cityAddress;
	
	private EmailField emailReq;
	
	private TextArea neighborhoodReq;
	private TextArea streetAddress;
	private TextArea hotelReservation;
	private TextArea reasonForTravel;
	private TextArea note;
	private TextArea reasonForLeavingMoz;
	private TextArea companiesWorkedFor;
	
	int ngHoodCharLimit = 140;
	int streetCharLimit = 140;
	int hotelRsCharLimit = 120;
	int rfTravelCharLimit = 140;
	int noteCharLimit = 140;
	int rfLeavingMozCharLimit = 120;
	int cpWorkedFor = 140;
	
	private DatePicker birthdateReq;
	private DatePicker idIssueDate;
	private DatePicker idValidate;
	private DatePicker dateToSchedule;
	private DatePicker departureDate;
	private DatePicker residentDepartureDate;
	
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
	
	public VisaB15View(ServService servService, BookingService bookingService, IdentityDocumentService identityDocService, 
			StatusService statusService, DocumentService documentService, ModalityService modalityService, ServFeeService servFeeService,
			CountryService countryService, NationalityService nationalityService, ProvinceService provinceService,
			DistrictService districtService, LocationService locationService, CountryCodeService countryCodeService, GeneralDataService generalDataService) {

		this.servService = servService;
		this.bookingService = bookingService;
		this.identityDocService = identityDocService;
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
		
		setAlignItems(Alignment.CENTER);
		
		createVariables();
		//createService();
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
		createBinder();
	    add(createFormLayout());
	}
	
	private void createBinder() {
		booking = new Booking(); 
		binder = new BeanValidationBinder<>(Booking.class);
		binder.bindInstanceFields(this);
	}
	
	private Component createHeader() {
		headerDiv = new Div();
		header = new H4(Labels.DOCUMENT_TYPE_VISA_B15);
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
				hr8 = new Hr();
		H4 document = new H4(Labels.DOCUMENT);
		H4 citizenAddress = new H4(Labels.ADDRESS);
		H4 personalData = new H4(Labels.PERSONAL_DATA);
		H4 scheduling = new H4(Labels.SCHEDULING);
		H4 contacts = new H4(Labels.CONTACTS);
		H4 idDocument = new H4(Labels.ID_DOCUMENT);
		H4 profession = new H4(Labels.PROFESSION);
		H4 accommodationAddress = new H4(Labels.ACCOMMODATION_ADDRESS);
		
		formLayout.add(hr, document, documentType, modality, serviceFee, hr1, personalData, nameReq, surnameReq, birthdateReq, singleName);
		formLayout.add(countryOfBirthReq, gender, maritalStatus, nationality, hr6, idDocument,idNumber, idIssueDate, idValidate, passportNationality);
		formLayout.add(hr7, profession, professionReq, positionReq, companyReq);
		formLayout.add(hr2);
		formLayout.add(citizenAddress);
		formLayout.add(neighborhoodReq,createRadioButtonHaveEverBeenToMoz(), reasonForLeavingMoz,departureDate, companiesWorkedFor,
				createRadioButtonHaveBeenResidentMoz(), lengthOfStayMoz, residentDepartureDate,hr8);
		formLayout.add(accommodationAddress);
		formLayout.add(provinceAddress, districtAddress, cityAddress, streetAddress, hotelReservation);
		formLayout.add(hr3);
		formLayout.add(scheduling);
		formLayout.add(dateToSchedule, location, reasonForTravel);
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
		formLayout.setColspan(neighborhoodReq, 2);
		formLayout.setColspan(streetAddress, 2);
		formLayout.setColspan(reasonForLeavingMoz, 2);
		formLayout.setColspan(reasonForTravel, 4);
		formLayout.setColspan(note, 1);
		formLayout.setColspan(companiesWorkedFor, 2);
		formLayout.setColspan(location, 2);
		formLayout.setColspan(hr2, 4);
		formLayout.setColspan(hr3, 4);
		formLayout.setColspan(hr4, 4);
		formLayout.setColspan(hr5, 4);
		formLayout.setColspan(hr6, 4);
		formLayout.setColspan(hr7, 4);
		formLayout.setColspan(hr8, 4);
		
		formCard = new Div();
		//formCard.getStyle().set("text-transform", "uppercase");
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
		Service service = servService.getServiceByName(Constants.VISA_B15);
		return service;
	}
	
	private void createDocumentType() {
		List<Document> documentTypeItems = documentService.findAll();
		documentType.setItems(documentTypeItems);
		//documentType.setValue(documentTypeItems.get(0));
		documentType.setItemLabelGenerator(Document::getName);
	}
	
	private void createModality() {
		List<Modality> modalityItems = modalityService.findAll();
		modality.setItems(modalityItems);
		//modality.setValue(modalityItems.get(0));
		modality.setItemLabelGenerator(Modality::getName);
	}
	
	private void createServiceFee() {
		List<ServiceFee> serviceFeeItems = servFeeService.findAll();
		serviceFee.setItems(serviceFeeItems);
		//serviceFee.setValue(serviceFeeItems.get(0));
		serviceFee.setItemLabelGenerator(ServiceFee::getName);
	}
	
	private void createCountry() {
		List<Country> countryItems = countryService.findAll();
		countryOfBirthReq.setItems(countryItems);
		countryOfBirthReq.setItemLabelGenerator(Country::getName);
	}
	
	private void createNationality() {
		List<Nationality> nationalityItems = nationalityService.findAll();
		/*Optional<Nationality> moz = nationalityItems.stream().filter(element -> element.getCountryCode() == Constants.COUNTRY_CODE_MZ).findFirst();
		nationality.setItems(nationalityItems);
		if(moz != null) {
			nationality.setValue(moz.get());	
		}*/
		nationality.setItems(nationalityItems);
		nationality.setItemLabelGenerator(Nationality::getName);
		passportNationality.setItems(nationalityItems);
		passportNationality.setItemLabelGenerator(Nationality::getName);
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
		countryCode.setItems(countryCodeItems);
		countryCode.setValue(countryCodeItems.get(1));
		countryCode.setItemLabelGenerator(CountryCode::getName);
	}
	
	private void createStatus() {
		activeStatus = statusService.getStatusByCode("A");
		aprovedStatus = statusService.getStatusByCode("AP");
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
	
	private void createLengthOfStayMoz() {
		List<GeneralData> lengthOfStayItems = generalDataService.findGeneralDataByCategory(Constants.PERIOD_OF_STAY);
		lengthOfStayMoz.setItems(lengthOfStayItems);
		lengthOfStayMoz.setItemLabelGenerator(GeneralData::getName);
	}
	/*private void createUploadIDDoc() {
		
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
		this.identityDoc = new IdentityDocument();
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
		
		this.idNumber = new TextField(Labels.PASSPORT_DOC_NUMBER);
		this.idNumber.setHelperText(Labels.TYPE_YOUR_PASSAPORT_DOC_NUMBER);
		this.idNumber.setRequired(true);
		this.idNumber.setClearButtonVisible(true);
		
		this.idValidate = new DatePicker(Labels.PASSPORT_DOC_VALIDATE);
		this.idValidate.setHelperText(Labels.TYPE_YOUR_PASSPORT_DOC_VALIDATE);
		this.idValidate.setRequired(true);
		this.idValidate.setClearButtonVisible(true);
		
		this.idIssueDate = new DatePicker(Labels.IDENTITY_DOC_ISSUE_DATE);
		this.idIssueDate.setHelperText(Labels.TYPE_YOUR_PASSAPORT_DOC_NUMBER);
		this.idIssueDate.setRequired(true);
		this.idIssueDate.setClearButtonVisible(true);
		
		this.localOfIssue = new TextField(Labels.LOCAL_OF_ISSUE);
		this.localOfIssue.setHelperText(Labels.TYPE_YOUR_LOCAL_OF_ISSUE);
		this.localOfIssue.setRequired(true);
		this.localOfIssue.setClearButtonVisible(true);
		
		this.countryOfBirthReq = new ComboBox<Country>(Labels.COUNTRY_OF_BIRTH);
		this.countryOfBirthReq.setHelperText(Labels.SELECT_COUNTRY_OF_BIRTH_HELPER_TEXT);
		
        this.nationality = new ComboBox<Nationality>(Labels.NATIONALITY);
        this.nationality.setHelperText(Labels.SELECT_YOUR_NATIONALITY);

        this.passportNationality = new ComboBox<Nationality>(Labels.PASSPORT_NATIONALITY);
        this.passportNationality.setHelperText(Labels.SELECT_YOUR_PASSPORT_NATIONALITY);
        
		this.neighborhoodReq = new TextArea(Labels.PERMANENT_RESIDENTIAL_ADDRESS);
		this.neighborhoodReq.setMaxLength(ngHoodCharLimit);
		this.neighborhoodReq.setValueChangeMode(ValueChangeMode.EAGER);
		this.neighborhoodReq.setHelperText("0/"+ngHoodCharLimit+" "+Labels.OPTIONAL);
		this.neighborhoodReq.setClearButtonVisible(true);
		this.neighborhoodReq.addValueChangeListener(e -> {
            e.getSource()
                    .setHelperText(e.getValue().length() + "/" + ngHoodCharLimit+" "+Labels.OPTIONAL);
        });
		
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
		
        this.reasonForTravel = new TextArea(Labels.REASON_FOR_ENTRY_IN_MOZ);
        this.reasonForTravel.setMaxLength(rfTravelCharLimit);
        this.reasonForTravel.setValueChangeMode(ValueChangeMode.EAGER);
        this.reasonForTravel.setHelperText("0/"+rfTravelCharLimit+" "+Labels.REASON_FOR_ENTRY_IN_MOZ_HELPER_TEXT);
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
        
        this.companiesWorkedFor = new TextArea(Labels.COMPANIES_WORKED_FOR);
        this.companiesWorkedFor.setMaxLength(cpWorkedFor);
        this.companiesWorkedFor.setValueChangeMode(ValueChangeMode.EAGER);
        this.companiesWorkedFor.setHelperText("0/"+cpWorkedFor);
        this.companiesWorkedFor.setClearButtonVisible(true);
        this.companiesWorkedFor.addValueChangeListener(e -> {
            e.getSource()
                    .setHelperText(e.getValue().length() + "/" + cpWorkedFor);
        });
        
        this.dateToSchedule = new DatePicker(Labels.DATE_TO_SCHEDULE);
        this.dateToSchedule.setHelperText(Labels.DATE_TO_SCHEDULE_HELPER_TEXT);
        this.dateToSchedule.setClearButtonVisible(true);
        
        this.provinceAddress = new ComboBox<Province>(Labels.PROVINCE);
        this.provinceAddress.setHelperText(Labels.SELECT_YOUR_PROVINCE);
        
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
        
        this.districtAddress = new ComboBox<District>(Labels.DISTRICT);
        this.districtAddress.setEnabled(false);

		this.cityAddress = new TextField(Labels.CITY);
		this.cityAddress.setHelperText(Labels.TYPE_YOUR_CITY);
		this.cityAddress.setClearButtonVisible(true);
        
        this.location = new ComboBox<Location>(Labels.PLACE_TO_SCHEDULE);
        this.location.setHelperText(Labels.PLACE_TO_SCHEDULE_HELPER_TEXT);

        this.countryCode = new ComboBox<CountryCode>(Labels.COUNTRY_CODE);
        this.countryCode.setHelperText(Labels.SELECT_YOUR_COUNTRY_CODE);
        
        this.phoneNumberReq = new TextField(Labels.PHOME_NUMBER);
        this.phoneNumberReq.setHelperText(Labels.TYPE_YOUR_PHONE_NUMBER);
        this.phoneNumberReq .setPlaceholder("82XXXXXXX");
        this.phoneNumberReq.setPrefixComponent(VaadinIcon.PHONE.create());
        this.phoneNumberReq.setAllowedCharPattern("[0-9]");
        this.phoneNumberReq.setMinLength(5);
        this.phoneNumberReq.setMaxLength(18);
        this.phoneNumberReq.setClearButtonVisible(true);
        
        this.emailReq = new EmailField(Labels.EMAIL);
        this.emailReq.setHelperText(Labels.TYPE_YOUR_EMAIL);
        this.emailReq .setPlaceholder("exemplo@gmail.com");
        this.emailReq.setClearButtonVisible(true);
        this.emailReq.setPrefixComponent(VaadinIcon.ENVELOPE.create());
        
        this.singleName = new TextField(Labels.SINGLE_NAME);
		this.singleName.setHelperText(Labels.TYPE_YOUR_SINGLE_NAME);
		this.singleName.setClearButtonVisible(true);

        this.gender = new ComboBox<GeneralData>(Labels.GENDER);
        this.gender.setHelperText(Labels.GENDER_HELPER_TEXT);
        this.gender.setRequired(true);
        
        this.maritalStatus = new ComboBox<GeneralData>(Labels.MARITAL_STATUS);
        this.maritalStatus.setHelperText(Labels.MARITAL_STATUS_HELPER_TEXT);
        this.maritalStatus.setRequired(true);
        
        this.professionReq = new TextField(Labels.PROFESSION_OCCUPATION);
		this.professionReq.setHelperText(Labels.TYPE_YOUR_PROFESSION_OCCUPATION);
		this.professionReq.setClearButtonVisible(true);

        this.positionReq = new TextField(Labels.POSITION_HELD);
		this.positionReq.setHelperText(Labels.TYPE_YOUR_POSITION_HELD);
		this.positionReq.setClearButtonVisible(true);

        this.companyReq = new TextField(Labels.COMPANY_OR_ORGANIZATION);
		this.companyReq.setHelperText(Labels.TYPE_YOUR_COMPANY_OR_ORGANIZATION);
		this.companyReq.setClearButtonVisible(true);
		
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
		
        this.lengthOfStayMoz = new ComboBox<GeneralData>(Labels.PERIOD_OF_STAY);
        this.lengthOfStayMoz.setHelperText(Labels.MARITAL_STATUS_HELPER_TEXT);
        this.lengthOfStayMoz.setRequired(true);
        
        this.residentDepartureDate = new DatePicker(Labels.DEPARTURE_DATE);
        this.residentDepartureDate.setHelperText(Labels.TYPE_YOUR_DEPARTURE_DATE);
        this.residentDepartureDate.setClearButtonVisible(true);
		
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
			 binder.writeBean(booking);
			 
			 confirmDialog = new ConfirmDialog();
			 confirmDialog.setCancelable(true);
			 confirmDialog.setCancelText(Constants.CANCEL);
			 confirmDialog.setCancelButtonTheme("error primary");
			 confirmDialog.setConfirmText(Labels.CONFIRM_BOOKING_LATER_BUTTON);
			 confirmDialog.setConfirmButton(Labels.CONFIRM_BOOKING_BUTTON, e -> saveBooking());
	         
			 confirmDialog.setHeader(Labels.CONFIRM_BOOKING);
			 //confirmDialog.add(new H4(Labels.BOOKING_CONFIRMATION), new Paragraph());
			 confirmDialog.add(new H5(Labels.BOOKING_CONFIRMATION+" "+Labels.DOCUMENT_TYPE_PASSPORT_A11));
			 
			 UnorderedList unorderedList = new UnorderedList();

		        // Create and add list items to the UnorderedList
		        ListItem item1 = new ListItem(Labels.NAME+": "+nameReq.getValue()+" "+surnameReq.getValue());
		        ListItem item2 = new ListItem(Labels.DOCUMENT_TYPE+": "+documentType.getValue().getName());
		        ListItem item3 = new ListItem(Labels.SCHEDULED_DATE+": "+dateToSchedule.getValue());
		        ListItem item4 = new ListItem(Labels.SELECTED_LOCATION+": "+location.getValue().getName());
		        
		        unorderedList.add(item1, item2, item3, item4);
		        confirmDialog.add(unorderedList);
			/* confirmDialog.add(new Paragraph("Nome: "+nameReq.getValue()+" "+surnameReq.getValue()));
			 confirmDialog.add(new Paragraph("Tipo de Documento: "+documentType.getValue().getName()));
			 confirmDialog.add(new Paragraph("Data Marcada: "+dateToSchedule.getValue()));
			 confirmDialog.add(new Paragraph("Local: "+location.getValue().getName()));*/
			 
			 confirmDialog.setConfirmButtonTheme("success primary");
	             
	             //dialog.addConfirmListener(event -> navigateToView("/passaportA11"));
	             //button = new Button("Anular");
	        
			 confirmDialog.setWidth("50%");
	        
			 confirmDialog.open();
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
				this.identityDoc.setName(booking.getNameReq());
				this.identityDoc.setSurname(booking.getSurnameReq());
				this.identityDoc.setIdentityNumber(booking.getIdNumber());
				this.identityDoc.setValidate(booking.getIdValidate());
				this.identityDoc.setLocalOfIssue(booking.getLocalOfIssue());
				this.identityDoc.setIslifetime(haveEverBeenToMoz.getValue().equals(Labels.YES));
				this.identityDoc.setCreatedBy(booking.getNameReq()+" "+booking.getSurnameReq());
				this.identityDoc.setStatus(activeStatus);
				
				this.booking.setBookingId(AlphanumericGenerator.generateAlphanumericValue());
				this.booking.setService(createService());
				this.booking.setCreatedBy(booking.getNameReq()+" "+booking.getSurnameReq());
				this.booking.setVersion(1);
				this.booking.setIdentityDoc(identityDoc);
				this.booking.setStatus(aprovedStatus);
				
				identityDocService.save(identityDoc);
				bookingService.save(booking);
				//clearFields();
				navigateToView("/agendar");
				Notification notification = Notification.show(Labels.SAVED_BOOKING_SUCCESSFULLY+" "+booking.getBookingId(), 10000, Position.TOP_CENTER); 
				notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
				notification.setPosition(Position.TOP_CENTER);
			} catch (Exception e) {
				Notification notification = Notification.show(Labels.SAVED_BOOKING_ERROR); 
				notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
				notification.setPosition(Position.TOP_CENTER);
				
				e.printStackTrace();
				
			}
	}
	 
	 private void clearFields() {
			booking = new Booking();
			binder.getFields().forEach(HasValue::clear);
			countryCode.setValue(countryCodeService.findAll().get(1));
	}
	
	private void navigateToView(String route) {
		getUI().ifPresent(ui -> ui.navigate(route));
	}

}
