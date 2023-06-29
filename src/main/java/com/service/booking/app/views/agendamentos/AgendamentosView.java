package com.service.booking.app.views.agendamentos;

import com.service.booking.app.views.MainLayout;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.dependency.Uses;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.auth.AnonymousAllowed;

@PageTitle("Agendamentos")
@Route(value = "agendamentos", layout = MainLayout.class)
@AnonymousAllowed
@Uses(Icon.class)
public class AgendamentosView extends Composite<VerticalLayout> {

    public AgendamentosView() {
        getContent().setHeightFull();
        getContent().setWidthFull();
    }
}
