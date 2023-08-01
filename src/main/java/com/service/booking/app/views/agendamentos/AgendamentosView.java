package com.service.booking.app.views.agendamentos;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.constants.Labels;
import com.service.booking.app.data.entity.Booking;
import com.service.booking.app.data.entity.BookingLogs;
import com.service.booking.app.data.entity.District;
import com.service.booking.app.data.entity.Document;
import com.service.booking.app.data.entity.Province;
import com.service.booking.app.data.service.BookingLogsService;
import com.service.booking.app.data.service.BookingService;
import com.service.booking.app.data.service.StatusService;
import com.service.booking.app.utils.BookingUtils;
import com.service.booking.app.data.entity.Status;
import com.service.booking.app.views.MainLayout;
import com.service.booking.app.utils.BookingUtils;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.applayout.AppLayout.Section;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.component.textfield.EmailField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.function.SerializableBiConsumer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.H5;
import com.vaadin.flow.component.html.H6;
import com.vaadin.flow.component.html.Hr;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.renderer.LitRenderer;
import com.vaadin.flow.data.renderer.Renderer;
import com.vaadin.flow.data.value.ValueChangeMode;

@SuppressWarnings("serial")
@PageTitle("Agendamentos | SIGAV - Sistema de Gestão de Agendamentos e Validações")
@Route(value = "agendamentos", layout = MainLayout.class)
@AnonymousAllowed
@Uses(Icon.class)
public class AgendamentosView extends VerticalLayout{ // Composite<VerticalLayout> {

	private Div headerDiv;
	private Div buttonsDiv;
	private H2 header;
	private Paragraph subtitle;
	
	private final BookingService bookingService;
	private final BookingLogsService bookingLogsService;
	private final StatusService statusService;
	
	private List<Booking> bookings;
	private List<String> searchOptions;
	
	private Grid<Booking> grid;
	
	private HorizontalLayout buttonsHorizontalLayout;

    private ConfirmDialog dialogCancel;
	
	private ComboBox<String> searchFor;
	
	private TextField searchCode;
	private TextField surname;
	
	private TextField phoneOrEmail;
	
	private FormLayout formLayout;
	
	private Button submitButton;
	private Button viewHistoryBtn;
	private Button cancelBtn;
	private Button rescheduleBtn;
	
    public AgendamentosView(BookingService bookingService, StatusService statusService, BookingLogsService bookingLogsService) {
    	
		setAlignItems(Alignment.CENTER);
		
		this.bookingService = bookingService;
		this.statusService = statusService;
		this.bookingLogsService = bookingLogsService;
		
        createVariables();
        createSearchOptions();
        add(createHeader());
        add(grid);
        add(createToolbar());
        //createCancelBookingConfirmDialog();
    }
    
    private Component createHeader() {
		headerDiv = new Div();
		//headerDiv.getStyle().set("text-transform", "uppercase");
		//headerDiv.getStyle().set("background-color", "rgba(23, 137, 252)");
		headerDiv.setWidth("100%");
		//headerDiv.getStyle().set("display", "flex");
        //headerDiv.getStyle().set("justify-content", "center");
        //headerDiv.getStyle().set("align-items", "center");

		
		headerDiv.addClassName("search-place");
		
		header = new H2(Labels.SEARCH_BOOKINGS_HEADER);
		subtitle = new Paragraph(Labels.SEARCH_BOOKINGS_SUB_HEARED);
		subtitle.addClassName(Margin.Top.NONE);
		subtitle.getStyle().set("color", "#4F565C");
		
		header.getStyle().set("color", "#4F565C");
		header.getStyle().set("text-transform", "uppercase");
		headerDiv.getStyle().set("text-align", "center");
		headerDiv.add(header, subtitle, createFormLayout());
		//headerDiv.getStyle().setTextAlign(Style.TextAlign.CENTER);
		
		
		
		return headerDiv;
	}
    
	private Component createFormLayout() {
		Div div = new Div();
		div.addClassName(Padding.XSMALL);
		div.addClassName("v-label-undef-w");
		div.getStyle().set("display", "flex");
        div.getStyle().set("justify-content", "center");
        div.getStyle().set("align-items", "center");
		
		Hr hr = new Hr();

		formLayout.add(searchFor, searchCode, surname, phoneOrEmail, hr, submitButton);
		//formLayout.setColspan(searchCode, 2);
		formLayout.setColspan(phoneOrEmail, 2);
		formLayout.setColspan(submitButton, 4);
		//formLayout.setColspan(email, 2);
		formLayout.setColspan(hr, 4);
		
		formLayout.setResponsiveSteps(
				// Use one column by default
		        new ResponsiveStep("0px", 1),
		        // Use two columns, if the layout's width exceeds 320px
		        new ResponsiveStep("500px", 2),
		        // Use three columns, if the layout's width exceeds 500px
		        new ResponsiveStep("760px", 3));
		
		div.add(new HorizontalLayout(formLayout));
		return div;
	}
    
    private void createVariables() {
    	formLayout = new FormLayout();
    	this.searchFor = new ComboBox<String>("Pesquisar por");
    	this.searchFor.addClassName(LumoUtility.TextColor.PRIMARY);
    	this.searchFor.addClassName(LumoUtility.BorderColor.CONTRAST_90);
    	
    	
    	this.searchCode = new TextField();
    	this.searchCode.setLabel(Labels.BOOKING_ID);
    	this.searchCode.setPlaceholder(Labels.SEARCH_BOOKING_FIELD);
    	this.searchCode.addClassName(LumoUtility.BorderColor.CONTRAST_90);
    	this.searchCode.setClearButtonVisible(true);
    	this.searchCode.setRequired(true);
    	
    	this.surname = new TextField(Labels.SURNAME);
		this.surname.setClearButtonVisible(true);
    	this.surname.addClassName(LumoUtility.BorderColor.CONTRAST_90);
    	this.surname.setPlaceholder(Labels.SEARCH_BY_YOUR_SURNAME);
    	//this.surname.setPrefixComponent(VaadinIcon.USER.create());
    	this.surname.setRequired(true);
    	
    	this.phoneOrEmail = new TextField(Labels.PHONE_OR_EMAIL);
        this.phoneOrEmail .setPlaceholder(Labels.PHONE_OR_EMAIL_PLACEHOLDER);
        this.phoneOrEmail.addClassName(LumoUtility.BorderColor.CONTRAST_90);
        this.phoneOrEmail.setClearButtonVisible(true);
        this.phoneOrEmail.setRequired(true);
        //this.phoneOrEmail.setPrefixComponent(VaadinIcon.ENVELOPE.create());
        /*
    	this.phoneNumber = new TextField(Labels.PHOME_NUMBER);
    	this.phoneNumber.setAllowedCharPattern("[0-9]");
    	this.phoneNumber.setMinLength(5);
    	this.phoneNumber.setMaxLength(18);
    	this.phoneNumber .setPlaceholder("82XXXXXXX");
        this.phoneNumber.setClearButtonVisible(true);
        this.phoneNumber.addClassName(LumoUtility.BorderColor.CONTRAST_90);
        this.phoneNumber.setPrefixComponent(VaadinIcon.PHONE.create());
        */
    	this.submitButton = new Button("Pesquisar");
    	this.submitButton.setIcon(VaadinIcon.SEARCH.create());
		submitButton.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		submitButton.getStyle().set("color", "white");
		submitButton.addClickListener(e -> searhForBooking());
		
		buttonsHorizontalLayout = new HorizontalLayout();
		dialogCancel = new ConfirmDialog();
        
        grid = new Grid<>(Booking.class);
		buidGrid();
        grid.setVisible(false);
    }
    
    
    private void createSearchOptions(){
    	searchOptions = List.of(Labels.BOOKING_ID, Labels.ID_DOCUMENT_NUMBER, Labels.PASSPORT_NUMBER, Labels.VISA);
    	
    	this.searchFor.setItems(searchOptions);
    	this.searchFor.setValue(searchOptions.get(0));
    	this.searchFor.setRequired(true);
    	this.searchFor.addValueChangeListener(event -> {
            if(searchFor.getValue().equals(Labels.ID_DOCUMENT_NUMBER)) {

            	this.searchCode.setLabel(Labels.ID_DOCUMENT_NUMBER);
            	this.searchCode.setPlaceholder(Labels.SEARCH_YOUR_IDENTITY_DOC_NUMBER);
            	this.searchCode.clear();
            	
            }else
            	if(searchFor.getValue().equals(Labels.PASSPORT_NUMBER)) {

                	this.searchCode.setLabel(Labels.PASSPORT_NUMBER);
                	this.searchCode.setPlaceholder(Labels.SEARCH_PASSPORT_NUMBER);
                	this.searchCode.clear();
                	
            	}else
            		if(searchFor.getValue().equals(Labels.VISA)) {

                    	this.searchCode.setLabel(Labels.VISA);
                    	this.searchCode.setPlaceholder(Labels.SEARCH_BY_YOUR_VISA);	
                    	this.searchCode.clear();
                    	
            		}else{
            			
            			this.searchFor.setValue(searchOptions.get(0));
            	    	this.searchCode.setLabel(Labels.BOOKING_ID);
            	    	this.searchCode.setPlaceholder(Labels.SEARCH_BOOKING_FIELD);
            	    	
            		}
        });
    }
    
    private void searhForBooking() {	
    	
    	if(!requiredFieldsAreFilled()) {
    		Notification notification = Notification.show(Labels.FILL_REQUIRED_FIELDS, 10000, Position.TOP_CENTER); 
			notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
			
    	}else {
    		if(searchFor.getValue().equals(Labels.BOOKING_ID)) {
    			bookings = bookingService.findBookingByIdAndSurnameAndContact(searchCode.getValue(), surname.getValue(), phoneOrEmail.getValue());
    			
    			if(bookings != null && bookings.size() > 0) {
        			updateGrid();
        			 // Execute JavaScript code to scroll to the section with the given id
                    getElement().executeJs("document.getElementById('booking_grid').scrollIntoView();");
        		}else {
        			notifyBookingNotFound();
        		}
        	}else
        		if(searchFor.getValue().equals(Labels.ID_DOCUMENT_NUMBER)) {
        			bookings = bookingService.findIDDocNumberAndSurnameAndContact(searchCode.getValue(), surname.getValue(), phoneOrEmail.getValue());
        			System.out.println("BOOKINGS: "+bookings);
            		if(bookings != null && bookings.size() > 0) {
            			updateGrid();
            			 // Execute JavaScript code to scroll to the section with the given id
                        getElement().executeJs("document.getElementById('booking_grid').scrollIntoView();");
            		}else {
            			notifyBookingNotFound();
            		}
        		}
    	}
    	
    }
    
    private boolean requiredFieldsAreFilled() {
    	if(searchCode.getValue() == null || searchCode.getValue().trim().isBlank()){
    		return false;
    	}else
    		if(surname.getValue() == null || surname.getValue().trim().isBlank()) {
    			return false;
    		}else 
    			if(phoneOrEmail.getValue() == null || phoneOrEmail.getValue().trim().isBlank()){
    			return false;
    		}
    	
    	return true;	
    }
    
    private void notifyBookingNotFound() {

		Notification notification = Notification.show(Labels.BOOKING_NOT_FOUND, 10000, Position.TOP_CENTER); 
		notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
    }
    
    public void buidGrid() {
        // Enable horizontal scrolling for the Grid
        //grid.getElement().getStyle().set("overflow-x", "auto");
        grid.setColumns();

		grid.addColumn(b -> b.getService().getName()).setHeader(Labels.DOCUMENT_TYPE).setAutoWidth(true).setFlexGrow(0).setSortable(true).setFrozen(true);
        grid.addColumn(Booking::getNameReq).setHeader(Labels.FULLNAME).setAutoWidth(true);
        grid.addColumn(Booking::getSurnameReq).setHeader(Labels.SURNAME).setAutoWidth(true);
		grid.addColumn(Booking::getDateToScheduleFormated).setHeader(Labels.SCHEDULED_DATE).setAutoWidth(true).setFlexGrow(0).setSortable(true);
		grid.addColumn(b -> b.getLocation().getName()).setHeader(Labels.SELECTED_LOCATION).setAutoWidth(true).setFlexGrow(0).setSortable(true);
		grid.addColumn(createStatusComponentRenderer()).setHeader(Labels.STATUS)
        .setAutoWidth(true).setFlexGrow(0).setSortable(true);
		
        grid.setId("booking_grid");
        grid.setMaxHeight("100px");
        grid.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS, GridVariant.LUMO_ROW_STRIPES);
        
    }
    
    private void updateGrid() {
    	grid.setVisible(true);
        grid.setItems(bookings);
        
        viewHistoryBtn.setVisible(true);
        cancelBtn.setVisible(true);
        rescheduleBtn.setVisible(true);
        
        cancelBtn.addClickListener(event -> {
        	dialogCancel = new ConfirmDialog();
            dialogCancel.setCancelable(true);
            dialogCancel.setCancelText(Labels.NO);
            dialogCancel.setCancelButtonTheme("error primary");
            dialogCancel.setConfirmText(Labels.YES);
            dialogCancel.setConfirmButton(Labels.YES, e -> cancelBooking());
            
            dialogCancel.setHeader(Labels.CONFIRM_BOOKING_CANCELLATION);
            dialogCancel.add(new H5(bookings.get(0).getService().getName()), new Paragraph());
            dialogCancel.add(new H4(Labels.CANCEL_BOOKING_CONFIRM_TEXT.replace("#", bookings.get(0).getBookingId())
            		));
            dialogCancel.setConfirmButtonTheme("success primary");
           
            dialogCancel.setWidth("50%");
           
        	dialogCancel.open();
        });
        //createCancelBookingConfirmDialog();
        if(bookings.get(0).getStatus().getCode().equals(Constants.STATUS_BOOKING_CANCELED_CODE)) {
    		cancelBtn.setEnabled(false);
    	}
        	
        
    }
    
    private static final SerializableBiConsumer<Span, Booking> statusComponentUpdater = (
            span, booking) -> {
        boolean isAvailable = Constants.STATUS_APROVEDAPPROVED_FOR_CAPTURE_CODE.equals(booking.getStatus().getCode());
        String theme = String.format("badge %s",
                isAvailable ? "success" : "error");
        span.getElement().setAttribute("theme", theme);
        span.setText(firstCharToUppercase(booking.getStatus().getDescription()));
    };

    private static ComponentRenderer<Span, Booking> createStatusComponentRenderer() {
        return new ComponentRenderer<>(Span::new, statusComponentUpdater);
    }
    
    private Component createToolbar() {
    	buttonsDiv = new Div();
		viewHistoryBtn = new Button(Labels.VIEW_BOOKING_HISTORY_BUTTON);
		viewHistoryBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY, ButtonVariant.LUMO_SUCCESS);
		viewHistoryBtn.setIcon(VaadinIcon.LIST.create());
		viewHistoryBtn.setVisible(false);
		
		cancelBtn = new Button(Labels.CANCEL_BOOKING_BUTTON);
		cancelBtn.addThemeVariants(ButtonVariant.LUMO_ERROR, ButtonVariant.LUMO_PRIMARY);
		cancelBtn.setIcon(VaadinIcon.FILE_REMOVE.create());
		cancelBtn.setVisible(false);
		
		rescheduleBtn = new Button(Labels.RESCHEDULE_BOOKING_BUTTON);
		rescheduleBtn.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		rescheduleBtn.setIcon(VaadinIcon.CALENDAR_CLOCK.create());
		rescheduleBtn.setVisible(false);
		
		buttonsHorizontalLayout.add(cancelBtn, rescheduleBtn, viewHistoryBtn);
		
		return buttonsHorizontalLayout;
	}
    
    public void cancelBooking() {
    	try {

            Booking booking = bookings.get(0);
            Status status = statusService.getStatusByCode(Constants.STATUS_BOOKING_CANCELED_CODE);
            
            if(status != null) {

            	BookingLogs bookingLogs = BookingUtils.setBookingLogsValues(booking);
            	booking.setStatus(status);
            	booking.setCancelledBy(booking.getNameReq()+" "+booking.getSurnameReq());
            	booking.setCancelledDate(new Date());
            	booking.setLastUpdateBy(booking.getNameReq()+" "+booking.getSurnameReq());
            	booking.setLastUpdateDate(new Date());
            	booking.setVersion(2);
            	
            	bookingService.save(booking);
            	bookings.get(0).setStatus(status);
            	
            	bookingLogsService.save(bookingLogs);
            	
            	updateGrid();

        		Notification notification = Notification.show(Labels.CANCELED_BOOKING_SUCCESSFULLY.replace("#", booking.getBookingId()), 10000, Position.TOP_CENTER); 
    			notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
    			
    			dialogCancel.close();
            }else {
        		Notification notification = Notification.show(Labels.CANCEL_BOOKING_FAILED, 10000, Position.TOP_CENTER); 
    			notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
            }
    	}catch(Exception e) {
    		System.out.println(e);
    		
    		Notification notification = Notification.show(Labels.CANCEL_BOOKING_FAILED, 10000, Position.TOP_CENTER); 
			notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
    	}
    }
    
    public static String firstCharToUppercase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String firstChar = input.substring(0, 1).toUpperCase();
        String restOfString = input.substring(1).toLowerCase();

        return firstChar + restOfString;
    }
}
