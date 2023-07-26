package com.service.booking.app.views.agendar;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.constants.Labels;
import com.service.booking.app.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.details.DetailsVariant;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.accordion.*;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;
import com.vaadin.flow.theme.lumo.LumoUtility.Padding;
import com.vaadin.flow.component.confirmdialog.ConfirmDialog;
import com.vaadin.flow.component.orderedlayout.FlexComponent;


@PageTitle("Agendar Serviço | SIGAV - Sistema de Gestão de Agendamentos e Validações")
@Route(value = "agendar", layout = MainLayout.class)
@AnonymousAllowed
public class AgendarView extends VerticalLayout {
	
	private static final long serialVersionUID = 1L;
	private String cardNationalTitle = Labels.NATIONAL_SERVICE_CATEGORY_TITLE;
	private String cardForeignTitle = Labels.FOREIGN_SERVICE_CATEGORY_TITLE;
	private String cardSubTitle = Labels.SERVICE_CATEGORY_SUBTITLE;
	
	private Div cardDivNational;
	private Div cardDivForeign;
	private H3 serviceToolBarTitle;
	private Paragraph titleDescription;
	
	private Button nationalCitizen;
	private Button foreignCitizen;
	
	private Image imgNational;
	private Image imgForeign;
	
	public AgendarView() {
		
		 setAlignItems(Alignment.CENTER);

	     serviceToolBarTitle = new H3(Labels.SERVICE_CATEGORY_TITLE);
		 titleDescription = new Paragraph(Labels.SERVICE_CATEGORY_SUBTITLE);
	     titleDescription.getStyle().set("color", "#66717B");
	     titleDescription.addClassNames(Margin.Top.NONE, Margin.Bottom.SMALL);
	     
		 serviceToolBarTitle.addClassNames(Padding.NONE);
			
		 add(serviceToolBarTitle, createToolbar());
		 cardNational(cardNationalTitle, cardSubTitle);
		 cardForeign(cardForeignTitle, cardSubTitle);	
	}
	
	private Component createToolbar() {
		
		imgNational = new Image("images/flagmoz.png", "Moz Flag");
		imgNational.setWidth("30px");
		imgNational.getStyle().set("border-radius", "60%");
		
		imgForeign = new Image("images/flagforeign.png", "Foreign Flag");
		imgForeign.setWidth("30px");
		imgForeign.getStyle().set("border-radius", "60%");

		nationalCitizen = new Button(Labels.SERVICE_CATEGORY_NATIONAL);
		nationalCitizen.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		nationalCitizen.addClassNames(Margin.Left.XSMALL, Margin.Right.XSMALL, Padding.LARGE, "service-buttons");
		nationalCitizen.setIcon(imgNational);
		nationalCitizen.addClassName("service-btn-active");
		nationalCitizen.addClickListener(e -> nationalBtnAction());
		
		foreignCitizen = new Button(Labels.SERVICE_CATEGORY_FOREING);
		foreignCitizen.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		foreignCitizen.addClassNames(Padding.SMALL, Padding.LARGE, "service-buttons");
		foreignCitizen.setIcon(imgForeign);
		foreignCitizen.addClickListener(e -> foreignBtnAction());
				
		Div buttons = new Div(nationalCitizen, foreignCitizen);
		
		return new HorizontalLayout(serviceToolBarTitle,buttons);
	}
	
	private void nationalBtnAction() {
		
		nationalCitizen.addClassName("service-btn-active");
		foreignCitizen.removeClassName("service-btn-active");
		
		cardDivNational.getStyle().set("display", "block");
		cardDivForeign.getStyle().set("display", "none");
	}
	
	private void foreignBtnAction() {

		nationalCitizen.removeClassName("service-btn-active");
		foreignCitizen.addClassName("service-btn-active");

		cardDivForeign.getStyle().set("display", "block");
		cardDivNational.getStyle().set("display", "none");
	}
	
	private void cardNational(String title, String content) {
		
        H3 cardTitle = new H3(title);
        cardTitle.getStyle().set("text-transform", "uppercase");

        Paragraph cardContent = new Paragraph(content);
        
		cardDivNational = new Div(cardTitle, cardContent, createNationalAccordion());
		cardDivNational.addClassName("card");
		cardDivNational.setWidth("70%");

        add(cardDivNational);   
	}
	
	private void cardForeign(String title, String content) { 
		
		H3 cardTitle = new H3(title);
		cardTitle.getStyle().set("text-transform", "uppercase");

        Paragraph cardContent = new Paragraph(content);
        
        cardDivForeign = new Div(cardTitle, cardContent, createForeignAccordion());
		cardDivForeign.addClassName("card");
		cardDivForeign.setWidth("70%");
		cardDivForeign.getStyle().set("display", "none");

        add(cardDivForeign);
	}
	
	private Component createNationalAccordion() {
		Accordion accordion = new Accordion();

        VerticalLayout passportLayout = new VerticalLayout(createNationalCategoryConfirmDialog(Constants.PASSPORT_A11),
        		createNationalCategoryConfirmDialog(Constants.PASSPORT_A12),createNationalCategoryConfirmDialog(Constants.PASSPORT_A13), 
        		createNationalCategoryConfirmDialog(Constants.PASSPORT_A14));
        passportLayout.setSpacing(false);
        passportLayout.setPadding(false);

        AccordionPanel passportPanel = accordion.add("PASSAPORTE",
                passportLayout);
        passportPanel.addThemeVariants(DetailsVariant.FILLED);

        VerticalLayout documentLayout = new VerticalLayout(createNationalCategoryConfirmDialog(Constants.DOCUMENT_A2));
        documentLayout.setSpacing(false);
        documentLayout.setPadding(false);

        AccordionPanel documentPanel = accordion.add("DOCUMENTO DE VIAGEM PARA MINEIROS OU TRABALHADORES SAZIONAIS (A2)",
                documentLayout);
        documentPanel.addThemeVariants(DetailsVariant.FILLED);

        VerticalLayout certificateLayout = new VerticalLayout(createNationalCategoryConfirmDialog(Constants.DOCUMENT_A3));
        certificateLayout.setSpacing(false);
        certificateLayout.setPadding(false);

        AccordionPanel certificatePanel = accordion.add("CERTIFICADO DE EMERGÊNCIA PARA NACIONAIS (A3)", certificateLayout);
        certificatePanel.addThemeVariants(DetailsVariant.FILLED);
        
        return accordion;
	}

	private Component createForeignAccordion() {
		Accordion accordion = new Accordion();

        Span name = new Span("Sophia Williams");
        Span email = new Span("sophia.williams@company.com");
        Span phone = new Span("(501) 555-9128");

        VerticalLayout personalInformationLayout = new VerticalLayout(name,
                email, phone);
        personalInformationLayout.setSpacing(false);
        personalInformationLayout.setPadding(false);

        AccordionPanel personalInfoPanel = accordion.add("SOLICITAÇÃO DE VISTOS",
                personalInformationLayout);
        personalInfoPanel.addThemeVariants(DetailsVariant.FILLED);

        Span street = new Span("4027 Amber Lake Canyon");
        Span zipCode = new Span("72333-5884 Cozy Nook");
        Span city = new Span("Arkansas");

        VerticalLayout billingAddressLayout = new VerticalLayout();
        billingAddressLayout.setSpacing(false);
        billingAddressLayout.setPadding(false);
        billingAddressLayout.add(street, zipCode, city);

        AccordionPanel billingAddressPanel = accordion.add("PRORROGAÇÃO DE VISTOS",
                billingAddressLayout);
        billingAddressPanel.addThemeVariants(DetailsVariant.FILLED);

        Span cardBrand = new Span("Mastercard");
        Span cardNumber = new Span("1234 5678 9012 3456");
        Span expiryDate = new Span("Expires 06/21");

        VerticalLayout paymentLayout = new VerticalLayout();
        paymentLayout.setSpacing(false);
        paymentLayout.setPadding(false);
        paymentLayout.add(cardBrand, cardNumber, expiryDate);

        AccordionPanel paymentPanel = accordion.add("D.I.R.E", paymentLayout);
        paymentPanel.addThemeVariants(DetailsVariant.FILLED);
        
        Span cardFieldName = new Span("Mastercard");
        Span cardFieldNumber = new Span("1234 5678 9012 3456");
        Span fieldExpiryDate = new Span("Expires 06/21");
        
        VerticalLayout docVRefugiadoLayout = new VerticalLayout();
        docVRefugiadoLayout.setSpacing(false);
        docVRefugiadoLayout.setPadding(false);
        docVRefugiadoLayout.add(cardFieldName, cardFieldNumber, fieldExpiryDate);
        
        AccordionPanel docViagemRefugiadosPanel = accordion.add("DOCUMENTO DE VIAGEM PARA REFUGIADOS (B4)", docVRefugiadoLayout);
        docViagemRefugiadosPanel.addThemeVariants(DetailsVariant.FILLED);
        
        return accordion;
	}	
	
	public Component createNationalCategoryConfirmDialog(String passportType) {
        HorizontalLayout layout = new HorizontalLayout();
        Div div = new Div();
        Button button;
        layout.setAlignItems(FlexComponent.Alignment.CENTER);
        layout.setJustifyContentMode(FlexComponent.JustifyContentMode.CENTER);

        ConfirmDialog dialog = new ConfirmDialog();

        dialog.setCancelable(true);
        dialog.setCancelText(Constants.CANCEL);
        dialog.setCancelButtonTheme("error primary");
        dialog.setConfirmText(Constants.REQUEST_DOCUMENT);
        
        if(passportType.equals(Constants.PASSPORT_A11)) {
        	dialog.setHeader(Labels.DOCUMENT_TYPE_PASSPORT_A11);
            dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
            dialog.add(passportA11Requirements());
            dialog.setConfirmButtonTheme("success primary");
            
            dialog.addConfirmListener(event -> navigateToView("/passaportA11"));
            button = new Button(Labels.DOCUMENT_TYPE_PASSPORT_A11);
        }else
        	if(passportType.equals(Constants.PASSPORT_A12)) {
        	
        		dialog.addConfirmListener(event -> navigateToView("/passaportA11"));
                button = new Button(Labels.DOCUMEMT_TYPE_PASSPORT_A12);
        	}else
        		if(passportType.equals(Constants.PASSPORT_A13)) {
        			dialog.addConfirmListener(event -> navigateToView("/passaportA11"));
                    button = new Button(Labels.DOCUMEMT_TYPE_PASSPORT_A13);
        		}else 
        			if(passportType.equals(Constants.DOCUMENT_A2)){
        			dialog.addConfirmListener(event -> navigateToView("/passaportA11"));
                    button = new Button(Labels.DOCUMENT_TYPE_TRAVEL_A2);
        		}else {
        			dialog.addConfirmListener(event -> navigateToView("/passaportA11"));
                    button = new Button(Labels.DOCUMENT_TYPE_EMERGENCY_CERTIFICATE_A3);
        		}
                

        dialog.setWidth("50%");
        
        button.addClickListener(event -> {
            dialog.open();
        });

        div.add(button);
        
        return div;
    }
	
	private Component passportA11Requirements() {
		// Create an UnorderedList component
        UnorderedList unorderedList = new UnorderedList();

        // Create and add list items to the UnorderedList
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_ID_M18);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_EXPIRED_PASSPORT);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_POLICE_STATEMENT);

        unorderedList.add(item1, item2, item3);
        
        // Add the UnorderedList to the main view
        return unorderedList;
	}
	
	private void navigateToView(String route) {
		getUI().ifPresent(ui -> ui.navigate(route));
	}
}
