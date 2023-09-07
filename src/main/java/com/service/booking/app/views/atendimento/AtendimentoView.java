package com.service.booking.app.views.atendimento;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.constants.Labels;
import com.service.booking.app.data.entity.Booking;
import com.service.booking.app.data.entity.Location;
import com.service.booking.app.data.entity.Service;
import com.service.booking.app.data.entity.Status;
import com.service.booking.app.data.service.BookingService;
import com.service.booking.app.data.service.LocationService;
import com.service.booking.app.data.service.ServService;
import com.service.booking.app.data.service.StatusService;
import com.service.booking.app.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.formlayout.FormLayout.ResponsiveStep;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.GridVariant;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.notification.NotificationVariant;
import com.vaadin.flow.component.notification.Notification.Position;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.renderer.ComponentRenderer;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.dom.Style;
import com.vaadin.flow.function.SerializableBiConsumer;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.ArrayList;
import jakarta.annotation.security.RolesAllowed;

@PageTitle("Atendimento | Service Bookings - Sistema de Gestão de Agendamentos e Validações")
@Route(value = "atendimento", layout = MainLayout.class)
@RolesAllowed("USER")
public class AtendimentoView extends VerticalLayout {
	private static final long serialVersionUID = 1L;
	
	private final BookingService bookingService;
	private final StatusService statusService;
	private final LocationService locationService;
	private final ServService servService;
	
	private List<Booking> bookings;
	
	private Grid<Booking> grid;
	private Div titleDiv;
	private H4 title;
	
	private DatePicker dateFrom;
	private DatePicker dateTo;
	
	private ComboBox<Status> status;
	private ComboBox<Location> location;
	private ComboBox<Service> document;
	
	private Button searchBtn, returnToSearchBtn;
	
    public AtendimentoView(BookingService bookingService, StatusService statusService, LocationService locationService, 
    		ServService servService) {
    	this.bookingService = bookingService;
    	this.statusService = statusService;
    	this.servService = servService;
    	this.locationService = locationService;
    	
    	//setSizeFull();
		setAlignItems(Alignment.CENTER);

        createFieldVariables();
        createStatusField();
        createLocationField();
        createDocumentField();
        configureGrid();
        loadBookings();
        
        add(createTitle(), createToolbar(), grid, returnToSearchBtn);
    }

    private Component createTitle() {
    	
    	title.getStyle().set("color", "#fff");
    	title.setId("gridTitle");
    	titleDiv.getStyle().set("text-transform", "uppercase");
    	titleDiv.addClassName("formTitle"); //.getStyle().set("background-color", "rgba(23, 137, 252, 0.3)");
    	titleDiv.setWidth("100%");
    	titleDiv.addClassNames(Padding.Vertical.SMALL, "header-radius");
    	titleDiv.getStyle().setTextAlign(Style.TextAlign.CENTER);
    	titleDiv.add(title);
    	
    	return titleDiv;
    }
    
	private void configureGrid() {
		//grid.setSizeFull();
		grid.setColumns();
		grid.addColumn(Booking::getBookingId).setKey("code").setHeader(Labels.BOOKING_CODE).setAutoWidth(true).setFlexGrow(0).setFrozen(true)
		.setFooter(createTotalBookingsFooter(bookings));
		grid.addColumn(b -> b.getNameReq().concat(" "+b.getSurnameReq())).setHeader(Labels.FULLNAME).setAutoWidth(true).setFlexGrow(0).setSortable(true).setFrozen(true);
        grid.addColumn(b -> b.getService().getName()).setHeader(Labels.DOCUMENT_TYPE).setAutoWidth(true).setFlexGrow(0).setSortable(true).setSortable(true);
		grid.addColumn(Booking::getDateToScheduleFormated).setHeader(Labels.SCHEDULED_DATE).setKey("schedule").setAutoWidth(true).setFlexGrow(0).
		setSortable(true).setFooter(createExpiredBookingsFooter(bookings));
		grid.addColumn(b -> b.getLocation().getName()).setHeader(Labels.LOCATION).setAutoWidth(true).setFlexGrow(0).setSortable(true);
		grid.addColumn(createStatusComponentRenderer()).setHeader(Labels.STATUS).setKey("status")
        .setAutoWidth(true).setFlexGrow(0).setSortable(true).setFooter(createNotApprovedBookingsFooter(bookings));;
		
        grid.setId("booking_grid");
        //grid.setMaxHeight("400px");
        grid.addThemeVariants(GridVariant.LUMO_COLUMN_BORDERS, GridVariant.LUMO_ROW_STRIPES);
        grid.setPageSize(2);
		
		//grid.getColumns().forEach(col -> col.setAutoWidth(true));
	}
	
	private Component createToolbar() {
		FormLayout formLayout = crateFormLayout();
		formLayout.setId("bkForm");
		
		dateFrom.setValue(LocalDate.now());
		dateFrom.setTooltipText(Labels.TOOLTIP_SERACH_BY_DATE1);
		dateFrom.setRequired(true);
		dateFrom.setHelperText(Labels.SEARCH_BOOKING_DATE_FROM_HELPER_TEXT);
		
		dateTo.setValue(LocalDate.now());
		dateTo.setTooltipText(Labels.TOOLTIP_SERACH_BY_DATE2);
		dateTo.setHelperText(Labels.SEARCH_BOOKING_DATE_TO_HELPER_TEXT);
		
		location.setPlaceholder(Labels.SEARCH_BOOKING_BY_LOCATION_PHOLDER);
		location.setHelperText(Labels.SEARCH_BOOKING_BY_LOCATION_HELPER_TEXT);
		location.setClearButtonVisible(true);
		
		document.setPlaceholder(Labels.SEARCH_BOOKING_BY_DOCUMENT_PHOLDER);
		document.setHelperText(Labels.SEARCH_BOOKING_BY_DOCUMENT_HELPER_TEXT);
		document.setClearButtonVisible(true);
		
		searchBtn = new Button("Pesquisar");
    	this.searchBtn.setIcon(VaadinIcon.SEARCH.create());
    	this.searchBtn.addThemeVariants(ButtonVariant.MATERIAL_CONTAINED);
    	this.searchBtn.addClickListener(e -> {
			if(isValidSearch())
			{	
				updateBookingsGrid();	
			}
		});
    	
		returnToSearchBtn = new Button("Voltar");
    	this.returnToSearchBtn.setIcon(VaadinIcon.ARROW_CIRCLE_UP.create());
    	this.returnToSearchBtn.addThemeVariants(ButtonVariant.MATERIAL_OUTLINED);
    	this.returnToSearchBtn.setTooltipText(Labels.TOOLTIP_BACK_TO_SEARCH_BUTTON);
    	this.returnToSearchBtn.setWidthFull();
    	this.returnToSearchBtn.addClickListener(e -> {
    		getElement().executeJs("document.getElementById('gridTitle').scrollIntoView();");
    	});
		
		formLayout.add(dateFrom, dateTo, location, document, status, searchBtn);

		formLayout.setColspan(location, 2);
		formLayout.setColspan(document, 2);
		formLayout.setColspan(status, 2);
		formLayout.setColspan(searchBtn, 4);
		
		return formLayout;
	}
	
	private void createStatusField() {
		List<Status> statusList = statusService.findStatusByCodes();
		Status selectStatus = statusList.stream()
                .filter(obj -> obj.getCode().equals(Constants.STATUS_APROVEDAPPROVED_FOR_CAPTURE_CODE))
                .collect(Collectors.toList()).get(0);
		
		status = new ComboBox<Status>();
		status.setItems(statusList);
		status.setItemLabelGenerator(Status::getDescription);
		status.setValue(selectStatus);
		status.setHelperText(Labels.SEARCH_BOOKING_BY_STATUS_HELPER_TEXT);
	}
	
	private void createLocationField() {
		List<Location> locationItems = locationService.findAll();
		location.setItems(locationItems);
		location.setItemLabelGenerator(Location::getName);
	}
	
	private void createDocumentField() {
		List<Service> serviceItems = servService.findAll();
		document.setItems(serviceItems);
		document.setItemLabelGenerator(Service::getName);	
	}
	
	private Component createNotApprovedBookingsFooter(List<Booking> bookings){
		long approvedBookingsCount = bookings.stream().filter(obj -> obj.getStatus().getCode().equals(Constants.STATUS_APROVEDAPPROVED_FOR_CAPTURE_CODE))
                .count();
		return createInfoSpan(String.format("%s Aprovados", approvedBookingsCount));
	}
	
	private Component createExpiredBookingsFooter(List<Booking> bookings){
		long expiredBookingsCount = bookings.stream().filter(obj -> obj.getDateToSchedule().compareTo(LocalDate.now()) < 0)
                .count();
		return createInfoSpan(String.format("%s Expirados", expiredBookingsCount));
	}
	
	private Component createTotalBookingsFooter(List<Booking> bookings){
		return createInfoSpan(String.format("%s Total agendamentos", bookings.size()));
	}
	
	private Component createInfoSpan(String text) {
		
		Span span = new Span();
		String theme = String.format("badge %s", "info");
        span.getElement().setAttribute("theme", theme);
        span.setText(text);
        
        return span;
	}
	
	private void updateBookingsGrid() {
		//List<Booking> bookings = new ArrayList<>();
		//
		//+ "and b.service.serviceId = :serviceId and b.location.locationId 
		if(dateFrom.getValue() != null) {
			if(dateTo.getValue() == null) {
				dateTo.setValue(dateFrom.getValue());
				bookings = createWhereConditions(dateFrom.getValue(), dateTo.getValue(), Constants.STATUS_APROVEDAPPROVED_FOR_CAPTURE_CODE);
						//bookingService.findByFilters(dateFrom.getValue(), dateTo.getValue(), Constants.STATUS_APROVEDAPPROVED_FOR_CAPTURE_CODE);
				grid.setItems(bookings);
		    	grid.getColumnByKey("code").setFooter(createTotalBookingsFooter(bookings));
		    	grid.getColumnByKey("status").setFooter(createNotApprovedBookingsFooter(bookings));
		    	grid.getColumnByKey("schedule").setFooter(createExpiredBookingsFooter(bookings));
				 // Execute JavaScript code to scroll to the section with the given id
                getElement().executeJs("document.getElementById('booking_grid').scrollIntoView();");
			}else
			if(dateFrom.getValue().compareTo(dateTo.getValue()) <= 0){
				bookings = createWhereConditions(dateFrom.getValue(), dateTo.getValue(), Constants.STATUS_APROVEDAPPROVED_FOR_CAPTURE_CODE);
				grid.setItems(bookings);
		    	grid.getColumnByKey("code").setFooter(createTotalBookingsFooter(bookings));
		    	grid.getColumnByKey("status").setFooter(createNotApprovedBookingsFooter(bookings));
		    	grid.getColumnByKey("schedule").setFooter(createExpiredBookingsFooter(bookings));
				//grid.setItems(bookingService.findByFilters(dateFrom.getValue(), dateTo.getValue(), Constants.STATUS_APROVEDAPPROVED_FOR_CAPTURE_CODE));
				 // Execute JavaScript code to scroll to the section with the given id
                getElement().executeJs("document.getElementById('booking_grid').scrollIntoView();");
			}
		}
		
		if(bookings == null || bookings.size() == 0) {
			showErrorNotification(Labels.NO_BOOKINGS_WHERE_FOUND_ON_SEARCH);
		}else {
			if(bookings.size() > 1) {
				String text = Labels.FOUND_BOOKINGS_SEARCHED;
				showSuccessNotification(text.replace("#", ""+bookings.size()));
			}
			else {
				showSuccessNotification(Labels.FOUND_ONE_BOOKING_SEARCHED);
			}
		}
	}
	
	private List<Booking> createWhereConditions(LocalDate date1, LocalDate date2, String statusId) {
		
		if(location.getValue() == null && document.getValue() == null) {
			return bookingService.findByFilters(date1, date2, Constants.STATUS_APROVEDAPPROVED_FOR_CAPTURE_CODE);
		}else if(location.getValue() != null && document.getValue() == null){
			return bookingService.findByLocationAndFilters(date1, date2, location.getValue().getLocationId(), Constants.STATUS_APROVEDAPPROVED_FOR_CAPTURE_CODE);
		}else if(location.getValue() == null && document.getValue() != null){
			System.out.println("Doc: "+document.getValue().getServiceId());
			return bookingService.findByDocAndFilters(date1, date2, document.getValue().getServiceId(), Constants.STATUS_APROVEDAPPROVED_FOR_CAPTURE_CODE);
		}else {
			System.out.println("Doc: "+document.getValue().getServiceId());
			return bookingService.findByAllFilters(date1, date2, document.getValue().getServiceId(), location.getValue().getLocationId(), Constants.STATUS_APROVEDAPPROVED_FOR_CAPTURE_CODE);
		}
	}
	
	private boolean isValidSearch() {
		if(status.getValue() == null) {
			showErrorNotification(Labels.SEARCH_BOOKINGS_ERROR_STATUS);
			return false;
		}
		
		return true;
	}
	
	private void showErrorNotification(String text) {
		Notification notification = Notification.show(text); 
		notification.addThemeVariants(NotificationVariant.LUMO_ERROR);
		notification.setPosition(Position.TOP_CENTER);
		notification.setDuration(10000);
	}
	
	private void showSuccessNotification(String text) {
		Notification notification = Notification.show(text); 
		notification.addThemeVariants(NotificationVariant.LUMO_SUCCESS);
		notification.setPosition(Position.TOP_CENTER);
		notification.setDuration(10000);
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
	
    public static String firstCharToUppercase(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }

        String firstChar = input.substring(0, 1).toUpperCase();
        String restOfString = input.substring(1).toLowerCase();

        return firstChar + restOfString;
    }
    
    private void loadBookings() {	
    	if(bookings == null || bookings.size() == 0) {
    		showErrorNotification(Labels.NO_BOOKINGS_WHERE_FOUND);
    	}else {
    		if(bookings.size() > 1) {
				String text = Labels.FOUND_BOOKINGS_TODAY;
				showSuccessNotification(text.replace("#", ""+bookings.size()));
			}
			else {
				showSuccessNotification(Labels.FOUND_ONE_BOOKING_TODAY);
			}
    	}
    	grid.setItems(bookings);
    }
    
    private FormLayout crateFormLayout() {
    	FormLayout formLayout = new FormLayout();
    	
    	//formLayout.getStyle().set("margin", "auto");
    	//formLayout.getStyle().set("display", "flex");
    	//formLayout.getStyle().set("flexDirection", "column");
    	formLayout.getStyle().set("alignItems", "center");
    	
    	formLayout.setResponsiveSteps(
                new ResponsiveStep("0px", 1),
                new ResponsiveStep("350px", 2),
                new ResponsiveStep("620px", 3),
                new ResponsiveStep("850px", 4)
        );
    	
    	return formLayout;
    }
    
    private void createFieldVariables() {
		this.grid = new Grid<>(Booking.class);
		titleDiv = new Div();
    	title = new H4(Labels.SERVICE_LIST_OF_BOOKINGS);
		dateFrom = new DatePicker();
		dateTo = new DatePicker();
		location = new ComboBox<Location>();
		document = new ComboBox<Service>();
    	
    	bookings = createWhereConditions(LocalDate.now(), LocalDate.now(), Constants.STATUS_APROVEDAPPROVED_FOR_CAPTURE_CODE);
	}
}
