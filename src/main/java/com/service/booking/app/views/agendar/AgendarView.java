package com.service.booking.app.views.agendar;

import com.service.booking.app.constants.Constants;
import com.service.booking.app.constants.Labels;
import com.service.booking.app.utils.documents.DocumentRequirement;
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
@Route(value = "/", layout = MainLayout.class)
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
	
	private DocumentRequirement requirements = new DocumentRequirement();
	
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

        VerticalLayout visaSolutions = new VerticalLayout(createForeignCategoryConfirmDialog(Constants.VISA_B11),
        		createForeignCategoryConfirmDialog(Constants.VISA_B12), createForeignCategoryConfirmDialog(Constants.VISA_B14),
        		createForeignCategoryConfirmDialog(Constants.VISA_B15), createForeignCategoryConfirmDialog(Constants.VISA_B16),
        		createForeignCategoryConfirmDialog(Constants.VISA_B17));
        visaSolutions.setSpacing(false);
        visaSolutions.setPadding(false);

        AccordionPanel visaSolutionsPanel = accordion.add("SOLICITAÇÃO DE VISTOS",
                visaSolutions);
        visaSolutionsPanel.addThemeVariants(DetailsVariant.FILLED);

        Span street = new Span("4027 Amber Lake Canyon");

        VerticalLayout workVisaSolutions = new VerticalLayout();
        workVisaSolutions.setSpacing(false);
        workVisaSolutions.setPadding(false);
        workVisaSolutions.add(createWorkVisaConfirmDialog(Constants.VISA_B131), createWorkVisaConfirmDialog(Constants.VISA_B132),
        		createWorkVisaConfirmDialog(Constants.VISA_B133));

        AccordionPanel workVisaSolutionsPanel = accordion.add("SOLICITAÇÃO DE VISTOS DE TRABALHO",
        		workVisaSolutions);
        workVisaSolutionsPanel.addThemeVariants(DetailsVariant.FILLED);
        
        VerticalLayout visaExtensionLayout = new VerticalLayout();
        visaExtensionLayout.setSpacing(false);
        visaExtensionLayout.setPadding(false);
        visaExtensionLayout.add(visaExtensionConfirmDialog(Constants.VISA_B21), visaExtensionConfirmDialog(Constants.VISA_B24),
        		visaExtensionConfirmDialog(Constants.VISA_B25), visaExtensionConfirmDialog(Constants.VISA_B26),
        		visaExtensionConfirmDialog(Constants.VISA_B27));

        AccordionPanel visaExtensionPanel = accordion.add("PRORROGAÇÃO DE VISTOS",
                visaExtensionLayout);
        visaExtensionPanel.addThemeVariants(DetailsVariant.FILLED);
        
        VerticalLayout workVisaExtensionLayout = new VerticalLayout();
        workVisaExtensionLayout.setSpacing(false);
        workVisaExtensionLayout.setPadding(false);
        workVisaExtensionLayout.add(workVisaExtensionConfirmDialog(Constants.VISA_B231), workVisaExtensionConfirmDialog(Constants.VISA_B232),
        		workVisaExtensionConfirmDialog(Constants.VISA_B233));

        AccordionPanel workVisaExtensionPanel = accordion.add("PRORROGAÇÃO DE VISTO DE TRABALHO",
        		workVisaExtensionLayout);
        workVisaExtensionPanel.addThemeVariants(DetailsVariant.FILLED);

        VerticalLayout direLayout = new VerticalLayout();
        direLayout.setSpacing(false);
        direLayout.setPadding(false);
        direLayout.add(createDireConfirmDialog(Constants.DIRE_B38), createDireConfirmDialog(Constants.DIRE_B31), createDireConfirmDialog(Constants.DIRE_B32),
        		createDireConfirmDialog(Constants.DIRE_B33), createDireConfirmDialog(Constants.DIRE_B34), createDireConfirmDialog(Constants.DIRE_B35),
        		createDireConfirmDialog(Constants.DIRE_B36), createDireConfirmDialog(Constants.DIRE_B37));       
        
        AccordionPanel direPanel = accordion.add("D.I.R.E", direLayout);
        direPanel.addThemeVariants(DetailsVariant.FILLED);
        
        VerticalLayout docVRefugiadoLayout = new VerticalLayout();
        docVRefugiadoLayout.setSpacing(false);
        docVRefugiadoLayout.setPadding(false);
        docVRefugiadoLayout.add(createDocumentConfirmDialog(Constants.DOCUMENT_B4), createDocumentConfirmDialog(Constants.DOCUMENT_B5),
        		createDocumentConfirmDialog(Constants.DOCUMENT_B8), createDocumentConfirmDialog(Constants.DOCUMENT_B7), createDocumentConfirmDialog(Constants.DOCUMENT_B6),
        		createDocumentConfirmDialog(Constants.DOCUMENT_B9));
        
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
            dialog.add(requirements.passportA11Requirements());
            dialog.setConfirmButtonTheme("success primary");
            
            dialog.addConfirmListener(event -> navigateToView("/passaportA11"));
            button = new Button(Labels.DOCUMENT_TYPE_PASSPORT_A11);
        }else
        	if(passportType.equals(Constants.PASSPORT_A12)) {
        		dialog.setHeader(Labels.DOCUMEMT_TYPE_PASSPORT_A12);
                dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
                dialog.add(requirements.passportA12Requirements());
                dialog.setConfirmButtonTheme("success primary");
                
        		dialog.addConfirmListener(event -> navigateToView("/passaportA12"));
                button = new Button(Labels.DOCUMEMT_TYPE_PASSPORT_A12);
        	}else
        		if(passportType.equals(Constants.PASSPORT_A13)) {
        			dialog.setHeader(Labels.DOCUMEMT_TYPE_PASSPORT_A13);
                    dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
                    dialog.add(requirements.passportA13Requirements());
                    dialog.setConfirmButtonTheme("success primary");
        			
        			dialog.addConfirmListener(event -> navigateToView("/passaportA13"));
                    button = new Button(Labels.DOCUMEMT_TYPE_PASSPORT_A13);
        		}else
        			if(passportType.equals(Constants.PASSPORT_A14)) {
            			dialog.setHeader(Labels.DOCUMEMT_TYPE_PASSPORT_A14);
                        dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
                        dialog.add(requirements.passportA14Requirements());
                        dialog.setConfirmButtonTheme("success primary");
            			
            			dialog.addConfirmListener(event -> navigateToView("/passaportA14"));
                        button = new Button(Labels.DOCUMEMT_TYPE_PASSPORT_A14);
            		}else 
            			if(passportType.equals(Constants.DOCUMENT_A2)){
            				dialog.setHeader(Labels.DOCUMENT_TYPE_TRAVEL_A2);
                            dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
                            dialog.add(requirements.documentA2Requirements());
                            dialog.setConfirmButtonTheme("success primary");
		        			
                            dialog.addConfirmListener(event -> navigateToView("/documentA2"));
		                    button = new Button(Labels.DOCUMENT_TYPE_TRAVEL_A2);
	        		}else
	        			if(passportType.equals(Constants.VISA_B21)){
	            			dialog.setHeader(Labels.DOCUMENT_TYPE_VISA_B21);
	                        dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
	                        dialog.add(requirements.visaRequirements());
	                        dialog.setConfirmButtonTheme("success primary");
	            			
	            			dialog.addConfirmListener(event -> navigateToView("/visaB17"));
	                        button = new Button(Labels.DOCUMENT_TYPE_VISA_B17);
	            		}
            			else {
	        			dialog.setHeader(Labels.DOCUMENT_TYPE_EMERGENCY_CERTIFICATE_A3);
                        dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
                        dialog.add(requirements.certificateA2Requirements());
                        dialog.setConfirmButtonTheme("success primary");
	        			
	        			dialog.addConfirmListener(event -> navigateToView("/certificateA2"));
	                    button = new Button(Labels.DOCUMENT_TYPE_EMERGENCY_CERTIFICATE_A3);
	        		}
                

        dialog.setWidth("50%");
        
        button.addClickListener(event -> {
            dialog.open();
        });

        div.add(button);
        
        return div;
    }
	
	public Component createForeignCategoryConfirmDialog(String documentType) {
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
        
        if(documentType.equals(Constants.VISA_B11)) {
        	dialog.setHeader(Labels.DOCUMENT_TYPE_VISA_B11);
            dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
            dialog.add(requirements.visaRequirements());
            dialog.setConfirmButtonTheme("success primary");
            
            dialog.addConfirmListener(event -> navigateToView("/visaB11"));
            button = new Button(Labels.DOCUMENT_TYPE_VISA_B11);
        }else
        	if(documentType.equals(Constants.VISA_B12)) {
        		dialog.setHeader(Labels.DOCUMENT_TYPE_VISA_B12);
                dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
                dialog.add(requirements.visaRequirements());
                dialog.setConfirmButtonTheme("success primary");
                
        		dialog.addConfirmListener(event -> navigateToView("/visaB12"));
                button = new Button(Labels.DOCUMENT_TYPE_VISA_B12);
        	}else
        		if(documentType.equals(Constants.VISA_B14)) {
        			dialog.setHeader(Labels.DOCUMENT_TYPE_VISA_B14);
                    dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
                    dialog.add(requirements.visaRequirements());
                    dialog.setConfirmButtonTheme("success primary");
        			
        			dialog.addConfirmListener(event -> navigateToView("/visaB14"));
                    button = new Button(Labels.DOCUMENT_TYPE_VISA_B14);
        		}else
        			if(documentType.equals(Constants.VISA_B15)) {
            			dialog.setHeader(Labels.DOCUMENT_TYPE_VISA_B15);
                        dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
                        dialog.add(requirements.visaRequirements());
                        dialog.setConfirmButtonTheme("success primary");
            			
            			dialog.addConfirmListener(event -> navigateToView("/visaB15"));
                        button = new Button(Labels.DOCUMENT_TYPE_VISA_B15);
            		}else 
            		if(documentType.equals(Constants.VISA_B16)){
            				dialog.setHeader(Labels.DOCUMENT_TYPE_VISA_B16);
                            dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
                            dialog.add(requirements.visaRequirements());
                            dialog.setConfirmButtonTheme("success primary");
		        			
                            dialog.addConfirmListener(event -> navigateToView("/visaB16"));
		                    button = new Button(Labels.DOCUMENT_TYPE_VISA_B16);
	        		}else {
	        			{
            				dialog.setHeader(Labels.DOCUMENT_TYPE_VISA_B17);
                            dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
                            dialog.add(requirements.visaRequirements());
                            dialog.setConfirmButtonTheme("success primary");
		        			
                            dialog.addConfirmListener(event -> navigateToView("/visaB17"));
		                    button = new Button(Labels.DOCUMENT_TYPE_VISA_B17);
	        		}
	        		}
        
        dialog.setWidth("50%");
        
        button.addClickListener(event -> {
            dialog.open();
        });

        div.add(button);
        
        return div;
    }
	
	public Component createWorkVisaConfirmDialog(String documentType) {
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
        
        if(documentType.equals(Constants.VISA_B131)) {
        	dialog.setHeader(Labels.DOCUMENT_TYPE_VISA_B131);
            dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
            dialog.add(requirements.visaRequirements());
            dialog.setConfirmButtonTheme("success primary");
            
            dialog.addConfirmListener(event -> navigateToView("/visaB131"));
            button = new Button(Labels.DOCUMENT_TYPE_VISA_B131);
        }else
        	if(documentType.equals(Constants.VISA_B132)) {
    			dialog.setHeader(Labels.DOCUMENT_TYPE_VISA_B132);
                dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
                dialog.add(requirements.visaRequirements());
                dialog.setConfirmButtonTheme("success primary");
    			
    			dialog.addConfirmListener(event -> navigateToView("/visaB132"));
                button = new Button(Labels.DOCUMENT_TYPE_VISA_B132);
    		}else
        		 {
        			dialog.setHeader(Labels.DOCUMENT_TYPE_VISA_B133);
                    dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
                    dialog.add(requirements.visaRequirements());
                    dialog.setConfirmButtonTheme("success primary");
        			
        			dialog.addConfirmListener(event -> navigateToView("/visaB133"));
                    button = new Button(Labels.DOCUMENT_TYPE_VISA_B133);
        		}
		        		
        
        dialog.setWidth("50%");
        
        button.addClickListener(event -> {
            dialog.open();
        });

        div.add(button);
        
        return div;
    }
	
	public Component createDireConfirmDialog(String documentType) {
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
        
        if(documentType.equals(Constants.DIRE_B38)) {
        	dialog.setHeader(Labels.DOCUMENT_TYPE_DIRE_B38);
            dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
            dialog.add(requirements.direRequirementsB38());
            dialog.setConfirmButtonTheme("success primary");
            
            dialog.addConfirmListener(event -> navigateToView("/direB38"));
            button = new Button(Labels.DOCUMENT_TYPE_DIRE_B38);
        }else
        	if(documentType.equals(Constants.DIRE_B31))
		 {
			dialog.setHeader(Labels.DOCUMENT_TYPE_DIRE_B31);
           dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
           dialog.add(requirements.direRequirementsB31());
           dialog.setConfirmButtonTheme("success primary");
			
			dialog.addConfirmListener(event -> navigateToView("/direB31"));
           button = new Button(Labels.DOCUMENT_TYPE_DIRE_B31);
		}
        else
        	if(documentType.equals(Constants.DIRE_B32))
			{
        	   dialog.setHeader(Labels.DOCUMENT_TYPE_DIRE_B32);
	           dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
	           dialog.add(requirements.direRequirementsB32());
	           dialog.setConfirmButtonTheme("success primary");
				
				dialog.addConfirmListener(event -> navigateToView("/direB32"));
	           button = new Button(Labels.DOCUMENT_TYPE_DIRE_B32);
			}else
				if(documentType.equals(Constants.DIRE_B33))
				{
	        	   dialog.setHeader(Labels.DOCUMENT_TYPE_DIRE_B33);
		           dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
		           dialog.add(requirements.direRequirementsB33());
		           dialog.setConfirmButtonTheme("success primary");
					
					dialog.addConfirmListener(event -> navigateToView("/direB33"));
		           button = new Button(Labels.DOCUMENT_TYPE_DIRE_B33);
				}
				else
					if(documentType.equals(Constants.DIRE_B34))
					{
		        	   dialog.setHeader(Labels.DOCUMENT_TYPE_DIRE_B34);
			           dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
			           dialog.add(requirements.direRequirementsB34());
			           dialog.setConfirmButtonTheme("success primary");
						
						dialog.addConfirmListener(event -> navigateToView("/direB34"));
			           button = new Button(Labels.DOCUMENT_TYPE_DIRE_B34);
					}
					else 
						if(documentType.equals(Constants.DIRE_B35)) {
						   dialog.setHeader(Labels.DOCUMENT_TYPE_DIRE_B35);
				           dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
				           dialog.add(requirements.direRequirementsB35());
				           dialog.setConfirmButtonTheme("success primary");
							
						   dialog.addConfirmListener(event -> navigateToView("/direB35"));
				           button = new Button(Labels.DOCUMENT_TYPE_DIRE_B35);
						}
						else 
							if(documentType.equals(Constants.DIRE_B36)) {
							   dialog.setHeader(Labels.DOCUMENT_TYPE_DIRE_B36);
					           dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
					           dialog.add(requirements.direRequirementsB36());
					           dialog.setConfirmButtonTheme("success primary");
								
							   dialog.addConfirmListener(event -> navigateToView("/direB36"));
					           button = new Button(Labels.DOCUMENT_TYPE_DIRE_B36);
						}else {
							   dialog.setHeader(Labels.DOCUMENT_TYPE_DIRE_B37);
					           dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
					           dialog.add(requirements.direRequirementsB37());
					           dialog.setConfirmButtonTheme("success primary");
								
							   dialog.addConfirmListener(event -> navigateToView("/direB37"));
					           button = new Button(Labels.DOCUMENT_TYPE_DIRE_B37);
						}
							
       		
		dialog.setWidth("50%");
		
		button.addClickListener(event -> {
		   dialog.open();
		});
		
		div.add(button);
	
		return div;

	}
	
	public Component createDocumentConfirmDialog(String documentType) {
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
        
        if(documentType.equals(Constants.DOCUMENT_B4)) {
        	dialog.setHeader(Labels.DOCUMENT_TYPE_TRIP_B4);
            dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
            dialog.add(requirements.documentRequirementsB4());
            dialog.setConfirmButtonTheme("success primary");
            
            dialog.addConfirmListener(event -> navigateToView("/documentB4"));
            button = new Button(Labels.DOCUMENT_TYPE_TRIP_B4);
        }else
        	if(documentType.equals(Constants.DOCUMENT_B5))
        	{
        		dialog.setHeader(Labels.DOCUMENT_TYPE_TRIP_B5);
	            dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
	            dialog.add(requirements.documentRequirementsB6());
	            dialog.setConfirmButtonTheme("success primary");
				
				dialog.addConfirmListener(event -> navigateToView("/documentB5"));
				button = new Button(Labels.DOCUMENT_TYPE_TRIP_B5);
		}
        else
        	if(documentType.equals(Constants.DOCUMENT_B8))
			{
        	   dialog.setHeader(Labels.DOCUMENT_TYPE_TRIP_B8);
	           //dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
	           dialog.add(requirements.documentNoRequirements());
	           dialog.setConfirmButtonTheme("success primary");
				
				dialog.addConfirmListener(event -> navigateToView("/documentB8"));
	           button = new Button(Labels.DOCUMENT_TYPE_TRIP_B8);
			}else
				if(documentType.equals(Constants.DOCUMENT_B7))
				{
	        	   dialog.setHeader(Labels.DOCUMENT_TYPE_TRIP_B7);
		           //dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
		           dialog.add(requirements.documentNoRequirements());
		           dialog.setConfirmButtonTheme("success primary");
					
					dialog.addConfirmListener(event -> navigateToView("/documentB7"));
		           button = new Button(Labels.DOCUMENT_TYPE_TRIP_B7);
				}
				else
					if(documentType.equals(Constants.DOCUMENT_B6))
					{
		        	   dialog.setHeader(Labels.DOCUMENT_TYPE_TRIP_B6);
			           //dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
			           dialog.add(requirements.documentNoRequirements());
			           dialog.setConfirmButtonTheme("success primary");
						
			           dialog.addConfirmListener(event -> navigateToView("/documentB6"));
			           button = new Button(Labels.DOCUMENT_TYPE_TRIP_B6);
					}
					else{
						   dialog.setHeader(Labels.DOCUMENT_TYPE_TRIP_B9);
				           //dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
				           dialog.add(requirements.documentNoRequirements());
				           dialog.setConfirmButtonTheme("success primary");
							
						   dialog.addConfirmListener(event -> navigateToView("/documentB9"));
				           button = new Button(Labels.DOCUMENT_TYPE_TRIP_B9);
						}
							
		dialog.setWidth("50%");
		
		button.addClickListener(event -> {
		   dialog.open();
		});
		
		div.add(button);
	
		return div;

	}
	
	public Component visaExtensionConfirmDialog(String documentType) {
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
        
        if(documentType.equals(Constants.VISA_B21)) {
        	dialog.setHeader(Labels.DOCUMENT_TYPE_VISA_B21);
            dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
            dialog.add(requirements.visaExtensionRequirements());
            dialog.setConfirmButtonTheme("success primary");
            
            dialog.addConfirmListener(event -> navigateToView("/visaB21"));
            button = new Button(Labels.DOCUMENT_TYPE_VISA_B21);
        }else 
        	if(documentType.equals(Constants.VISA_B24))
	        {
				dialog.setHeader(Labels.DOCUMENT_TYPE_VISA_B24);
	            dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
	            dialog.add(requirements.visaExtensionB24Requirements());
	            dialog.setConfirmButtonTheme("success primary");
				
				dialog.addConfirmListener(event -> navigateToView("/visaB24"));
	            button = new Button(Labels.DOCUMENT_TYPE_VISA_B24);
			}else 
				if(documentType.equals(Constants.VISA_B25)){
					dialog.setHeader(Labels.DOCUMENT_TYPE_VISA_B25);
		            dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
		            dialog.add(requirements.visaExtensionRequirements());
		            dialog.setConfirmButtonTheme("success primary");
					
					dialog.addConfirmListener(event -> navigateToView("/visaB25"));
		            button = new Button(Labels.DOCUMENT_TYPE_VISA_B25);
			}else 
				if(documentType.equals(Constants.VISA_B26)){
				dialog.setHeader(Labels.DOCUMENT_TYPE_VISA_B26);
	            dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
	            dialog.add(requirements.visaExtensionB26Requirements());
	            dialog.setConfirmButtonTheme("success primary");
				
				dialog.addConfirmListener(event -> navigateToView("/visaB26"));
	            button = new Button(Labels.DOCUMENT_TYPE_VISA_B26);
			}else {
				dialog.setHeader(Labels.DOCUMENT_TYPE_VISA_B27);
	            dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
	            dialog.add(requirements.visaExtensionB27Requirements());
	            dialog.setConfirmButtonTheme("success primary");
				
				dialog.addConfirmListener(event -> navigateToView("/visaB27"));
	            button = new Button(Labels.DOCUMENT_TYPE_VISA_B27);
			}
		        		
        
        dialog.setWidth("50%");
        
        button.addClickListener(event -> {
            dialog.open();
        });

        div.add(button);
        
        return div;
    }
	
	public Component workVisaExtensionConfirmDialog(String documentType) {
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

        if(documentType.equals(Constants.VISA_B231)){
			dialog.setHeader(Labels.DOCUMENT_TYPE_VISA_B231);
            dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
            dialog.add(requirements.visaExtensionB231Requirements());
            dialog.setConfirmButtonTheme("success primary");
			
			dialog.addConfirmListener(event -> navigateToView("/visaB231"));
            button = new Button(Labels.DOCUMENT_TYPE_VISA_B231);
		}else 
			if(documentType.equals(Constants.VISA_B232)){
				dialog.setHeader(Labels.DOCUMENT_TYPE_VISA_B232);
	            dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
	            dialog.add(requirements.visaExtensionB232Requirements());
	            dialog.setConfirmButtonTheme("success primary");
				
				dialog.addConfirmListener(event -> navigateToView("/visaB232"));
	            button = new Button(Labels.DOCUMENT_TYPE_VISA_B232);
			}else {
				dialog.setHeader(Labels.DOCUMENT_TYPE_VISA_B233);
	            dialog.add(new H4(Labels.DOCUMENT_REQUEST_REQUIREMENTS_TITLE));
	            dialog.add(requirements.visaExtensionB233Requirements());
	            dialog.setConfirmButtonTheme("success primary");
				
				dialog.addConfirmListener(event -> navigateToView("/visaB233"));
	            button = new Button(Labels.DOCUMENT_TYPE_VISA_B233);
		}		        		
        
        dialog.setWidth("50%");
        
        button.addClickListener(event -> {
            dialog.open();
        });

        div.add(button);
        
        return div;
    }	
	
	private void navigateToView(String route) {
		getUI().ifPresent(ui -> ui.navigate(route));
	}
}
