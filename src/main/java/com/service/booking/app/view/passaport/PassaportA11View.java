package com.service.booking.app.view.passaport;

import java.util.List;
import java.util.Optional;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.constants.Labels;
import com.service.booking.app.data.entity.Booking;
import com.service.booking.app.data.entity.Country;
import com.service.booking.app.data.entity.CountryCode;
import com.service.booking.app.data.entity.District;
import com.service.booking.app.data.entity.Document;
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
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.shared.Tooltip;
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
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.notification.Notification.Position;
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
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.data.binder.BeanValidationBinder;
import com.vaadin.flow.data.binder.Binder;
import com.vaadin.flow.data.binder.ValidationException;


@PageTitle("Passaporte A11 | SIGAV - Sistema de Gestão de Agendamentos e Validações")
@Route(value = "passaportA11", layout = MainLayout.class)
@AnonymousAllowed
public class PassaportA11View extends VerticalLayout {
	
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
	
	private Status activeStatus;
	private Status aprovedStatus;
	private Status notConfirmedStatus;
	private IdentityDocument identityDoc;
	private Booking booking;
	private Binder<Booking> binder;
	
	private ComboBox<Document> documentType;
	private ComboBox<Modality> modality;
	private ComboBox<ServiceFee> serviceFee;
	private ComboBox<Country> countryOfBirthReq;
	private ComboBox<Nationality> nationality;
	private ComboBox<Province> provinceAddress;
	private ComboBox<District> districtAddress;
	private ComboBox<Location> location;
	private ComboBox<CountryCode> countryCode;
	
	private RadioButtonGroup<String> viatlicioRadioGroup;
	
	private ConfirmDialog confirmDialog;
	
	private TextField surnameReq;
	private TextField nameReq;
	private TextField idNumber;
	private TextField localOfIssue;
	private TextField phoneNumberReq;
	
	private EmailField emailReq;
	
	private TextArea neighborhoodReq;
	private TextArea reasonForTravel;
	private TextArea note;
	int ngHoodCharLimit = 140;
	int rfTravelCharLimit = 140;
	int noteCharLimit = 140;
	
	private DatePicker birthdateReq;
	private DatePicker idValidate;
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
	
	public PassaportA11View(ServService servService, BookingService bookingService, IdentityDocumentService identityDocService, 
			StatusService statusService, DocumentService documentService, ModalityService modalityService, ServFeeService servFeeService,
			CountryService countryService, NationalityService nationalityService, ProvinceService provinceService,
			DistrictService districtService, LocationService locationService, CountryCodeService countryCodeService) {

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
		header = new H4(Labels.DOCUMENT_TYPE_PASSPORT_A11);
		header.getStyle().set("color", "#4F565C");
		headerDiv.getStyle().set("text-transform", "uppercase");
		headerDiv.getStyle().set("background-color", "rgba(23, 137, 252, 0.3)");
		headerDiv.setWidth("100%");
		headerDiv.addClassNames(Padding.Vertical.SMALL, "header-radius");
		headerDiv.add(header);
		headerDiv.getStyle().setTextAlign(Style.TextAlign.CENTER);
		
		return headerDiv;
	}
	
	private Component createFormLayout() {
		
		FormLayout formLayout = new FormLayout();
		Hr hr = new Hr(), hr1 = new Hr(), hr2 = new Hr(), hr3 = new Hr(), hr4 = new Hr(), hr5 = new Hr();
		H4 document = new H4(Labels.DOCUMENT);
		H4 citizenAddress = new H4(Labels.CURRENT_ADDRESS);
		H4 personalData = new H4(Labels.PERSONAL_DATA);
		H4 scheduling = new H4(Labels.SCHEDULING);
		H4 contacts = new H4(Labels.CONTACTS);
		
		formLayout.add(hr, document, documentType, modality, serviceFee, hr1, personalData, nameReq, surnameReq, birthdateReq);
		formLayout.add(idNumber, createRadioButtonLifetimeDoc(), idValidate, localOfIssue, countryOfBirthReq, nationality);
		formLayout.add(hr2);
		
		formLayout.add(citizenAddress);
		formLayout.add(provinceAddress, districtAddress, neighborhoodReq);
		formLayout.add(hr3);
		formLayout.add(scheduling);
		formLayout.add(reasonForTravel, note, dateToSchedule, location);
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
		
		formLayout.setColspan(hr, 4);
		formLayout.setColspan(document, 4);
		formLayout.setColspan(hr1, 4);
		formLayout.setColspan(personalData, 4);
		formLayout.setColspan(citizenAddress, 4);
		formLayout.setColspan(scheduling, 4);
		formLayout.setColspan(contacts, 4);
		formLayout.setColspan(neighborhoodReq, 2);
		formLayout.setColspan(reasonForTravel, 2);
		formLayout.setColspan(note, 1);
		formLayout.setColspan(districtAddress, 2);
		formLayout.setColspan(hr2, 4);
		formLayout.setColspan(hr3, 4);
		formLayout.setColspan(hr4, 4);
		formLayout.setColspan(hr5, 4);
		
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
		Service service = servService.getServiceByName(Constants.PASSPORT_A11);
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
		
		this.idNumber = new TextField(Labels.IDENTITY_DOC_NUMBER);
		this.idNumber.setHelperText(Labels.TYPE_YOUR_IDENTITY_DOC_NUMBER);
		this.idNumber.setRequired(true);
		this.idNumber.setClearButtonVisible(true);
		
		this.idValidate = new DatePicker(Labels.IDENTITY_DOC_VALIDATE);
		this.idValidate.setHelperText(Labels.TYPE_YOUR_IDENTITY_DOC_VALIDATE);
		this.idValidate.setRequired(true);
		this.idValidate.setClearButtonVisible(true);
		
		this.localOfIssue = new TextField(Labels.LOCAL_OF_ISSUE);
		this.localOfIssue.setHelperText(Labels.TYPE_YOUR_LOCAL_OF_ISSUE);
		this.localOfIssue.setRequired(true);
		this.localOfIssue.setClearButtonVisible(true);
		
		this.countryOfBirthReq = new ComboBox<Country>(Labels.COUNTRY_OF_BIRTH);
		this.countryOfBirthReq.setHelperText(Labels.SELECT_COUNTRY_OF_BIRTH_HELPER_TEXT);
		
        this.nationality = new ComboBox<Nationality>(Labels.NATIONALITY);
        this.nationality.setHelperText(Labels.SELECT_YOUR_NATIONALITY);
		
		this.neighborhoodReq = new TextArea(Labels.NEIGHBORHOOD);
		this.neighborhoodReq.setMaxLength(ngHoodCharLimit);
		this.neighborhoodReq.setValueChangeMode(ValueChangeMode.EAGER);
		this.neighborhoodReq.setHelperText("0/"+ngHoodCharLimit+" "+Labels.OPTIONAL);
		this.neighborhoodReq.setClearButtonVisible(true);
		this.neighborhoodReq.addValueChangeListener(e -> {
            e.getSource()
                    .setHelperText(e.getValue().length() + "/" + ngHoodCharLimit+" "+Labels.OPTIONAL);
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
        
        this.districtAddress = new ComboBox<District>(Labels.CITY_OR_DISTRICT);
        this.districtAddress.setEnabled(false);
        
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
	
	 private Component createRadioButtonLifetimeDoc() {
	        viatlicioRadioGroup = new RadioButtonGroup<>();
	        //radioGroup.addThemeVariants(RadioGroupVariant.LUMO_VERTICAL);
	        viatlicioRadioGroup.setLabel(Labels.LIFETIME);
	        viatlicioRadioGroup.setItems(Labels.YES, Labels.NO);
	        viatlicioRadioGroup.setValue(Labels.NO);
	        viatlicioRadioGroup.setHelperText(Labels.LIFETIME_HELPER_TEXT);
	        return viatlicioRadioGroup;
	 }
	 
	 private void createConfirmDialog() {
		 try {
			 saveBooking();
			 
			 confirmDialog = new ConfirmDialog();
			 confirmDialog.setCancelable(true);
			 confirmDialog.setCancelText(Labels.NO);
			 confirmDialog.setCancelButtonTheme("error tertiary");
			 confirmDialog.setConfirmText(Labels.CONFIRM_BOOKING_LATER_BUTTON);
			 confirmDialog.setConfirmButton(Labels.CONFIRM_BOOKING_BUTTON, e -> {});
	         
			 confirmDialog.setHeader(Labels.BOOKING_CONFIRMATION);
			 confirmDialog.add(new H5(Labels.DOCUMENT_TYPE_PASSPORT_A11), new Paragraph());
			 confirmDialog.add(new H6(Labels.BOOKING_CONFIRMATION));
			 confirmDialog.add(new Paragraph("Nome: "+booking.getNameReq()+" "+booking.getSurnameReq()));
			 confirmDialog.add(new Paragraph("Data Marcada: "+booking.getDateToScheduleFormated()));
			 confirmDialog.add(new Paragraph("Local Selecionado Para Tratar o Documento: "+booking.getLocation().getName()));
			 confirmDialog.add(new Paragraph("Tipo de Documento: "+booking.getDocumentType().getName()));
	             //dialog.add(new H4("Data Marcada: "+grid.sel));
			 confirmDialog.setConfirmButtonTheme("success primary");
	             
	             //dialog.addConfirmListener(event -> navigateToView("/passaportA11"));
	             //button = new Button("Anular");
	        
			 confirmDialog.setWidth("50%");
	        
			 confirmDialog.open();
		 } catch (Exception e) {
			Notification notification = Notification.show(Labels.SAVED_BOOKING_ERROR); 
			notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
			notification.setPosition(Position.TOP_CENTER);
			
			e.printStackTrace();
			
		}
	 }

	 private void saveBooking() {
			try {
				binder.writeBean(booking);
				
				this.identityDoc.setName(booking.getNameReq());
				this.identityDoc.setSurname(booking.getSurnameReq());
				this.identityDoc.setIdentityNumber(booking.getIdNumber());
				this.identityDoc.setValidate(booking.getIdValidate());
				this.identityDoc.setLocalOfIssue(booking.getLocalOfIssue());
				this.identityDoc.setIslifetime(viatlicioRadioGroup.getValue().equals(Labels.YES));
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
