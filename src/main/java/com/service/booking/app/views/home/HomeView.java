package com.service.booking.app.views.home;

import com.service.booking.app.views.MainLayout;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.Html;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.flow.theme.lumo.LumoUtility.Margin;

@PageTitle("Home | SIGAV - Sistema de Gestão de Agendamentos e Validações")
@Route(value = "home-not-in-use", layout = MainLayout.class)
@AnonymousAllowed
public class HomeView extends VerticalLayout {

    public HomeView() {
        setSpacing(false);
        Image img = new Image("images/empty-plant.png", "placeholder plant");
        img.setWidth("200px");
        add(img);

        H2 header = new H2("This place intentionally left empty");
        header.addClassNames(Margin.Top.XLARGE, Margin.Bottom.MEDIUM);
        add(header);
        add(new Paragraph("It’s a place where you can grow your own UI 🤗"));

        setSizeFull();
        setJustifyContentMode(JustifyContentMode.CENTER);
        setDefaultHorizontalComponentAlignment(Alignment.CENTER);
        getStyle().set("text-align", "center");
    }

	private Component createHeader() {
		Div sectionHeader = new Div();
		sectionHeader.addClassName("section-main-home");
		Image image = new Image("images/home/Home_first_image_01.jpeg", "Home main booking image");
		// Apply CSS styles to the image
        image.getElement().getStyle().set("width", "100%");
        image.getElement().getStyle().set("width", "25%");
        //image.getElement().getStyle().set("max-width", "100vw");

        //sectionHeader.add(image);
		return image;
	}

}
