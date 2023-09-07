package com.service.booking.app.utils.documents;

import com.service.booking.app.constants.Labels;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.UnorderedList;

public class DocumentRequirement {
	
	public DocumentRequirement() {
		
	}
	
	public Component passportA11Requirements() {
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
	
	public Component passportA12Requirements() {
		// Create an UnorderedList component
        UnorderedList unorderedList = new UnorderedList();
        
        // Create and add list items to the UnorderedList
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_ID_UNDER_18);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_LEGAL_REPRESENTATIVE_ID);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_LEGAL_REPRESENTATIVE_DECLARETION);

        unorderedList.add(item1, item2, item3);
        
        // Add the UnorderedList to the main view
        return unorderedList;
	}
	
	public Component passportA13Requirements() {
		// Create an UnorderedList component
        UnorderedList unorderedList = new UnorderedList();
        
        // Create and add list items to the UnorderedList
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_ID_DOC);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_MZ_NATIONALITY_AQUISITION);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_BIRTH_SEAT);
        ListItem item4 = new ListItem(Labels.DOCUMENT_REQUIREMENT_WEDDING_SEAT);
        ListItem item5 = new ListItem(Labels.DOCUMENT_REQUIREMENT_SPOUSES_ID_CARD);
        ListItem item6 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_RETURN_LETTER);

        unorderedList.add(item1, item2, item3, item4, item5, item6);
        
        // Add the UnorderedList to the main view
        return unorderedList;
	}
	
	public Component passportA14Requirements() {
		// Create an UnorderedList component
        UnorderedList unorderedList = new UnorderedList();
        
        // Create and add list items to the UnorderedList
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_ID_UNDER_18);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_LEGAL_REPRESENTATIVE_DECLARETION);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_MZ_NATIONALITY_ATRIBUITION);
        ListItem item4 = new ListItem(Labels.DOCUMENT_REQUIREMENT_BIRTH__OF_MINOR_SEAT);
        ListItem item5 = new ListItem(Labels.DOCUMENT_REQUIREMENT_RESIDENCE_IN_NATIONAL_TERRITORY);

        unorderedList.add(item1, item2, item3, item4, item5);
        
        // Add the UnorderedList to the main view
        return unorderedList;
	}
	
	public Component documentA2Requirements() {
		// Create an UnorderedList component
        UnorderedList unorderedList = new UnorderedList();
        
        // Create and add list items to the UnorderedList
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_ID_DOC);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_EMPLOYMENT_CONTRACT);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_MINER_ID_CARD);
        ListItem item4 = new ListItem(Labels.DOCUMENT_REQUIREMENT_EMPLOYMENT_CONTRACT_IN_FARMS);

        unorderedList.add(item1, item2, item3, item4);
        
        // Add the UnorderedList to the main view
        return unorderedList;
	}

	public Component certificateA2Requirements() {
		// Create an UnorderedList component
        UnorderedList unorderedList = new UnorderedList();
        
        // Create and add list items to the UnorderedList
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_ID_DOC);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DECLARATION_OF_THE_LEGAL_REPRESENTATIVE);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_WAITING_TICKET_AND_BIRTH_CERTIFICATE);

        unorderedList.add(item1, item2, item3);
        
        // Add the UnorderedList to the main view
        return unorderedList;
	}
	
	public Component visaRequirements() {
		UnorderedList unorderedList = new UnorderedList();
        
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_CONTACT_EMBASSY);
        
        unorderedList.add(item1);
        
        return unorderedList;
	}
	
	public Component visaExtensionRequirements() {
		UnorderedList unorderedList = new UnorderedList();
        
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_INVESTMENT_PROOF);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_ACCOMMODATION_PROOF);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_INSS_CERTIFICATE);
        ListItem item4 = new ListItem(Labels.DOCUMENT_REQUIREMENT_REQUEST_LETTER);
        ListItem item5 = new ListItem(Labels.DOCUMENT_REQUIREMENT_PASSPORT_COPY);
        ListItem item6 = new ListItem(Labels.DOCUMENT_REQUIREMENT_COPY_PREVIOUS_INVEST_VISA);
        ListItem item7 = new ListItem(Labels.DOCUMENT_REQUIREMENT_CRIMINAL_RECORD_OPTIONAL);
        
        unorderedList.add(item1,item2,item3,item4,item5,item6,item7);
        
        return unorderedList;
	}
	
	public Component visaExtensionB24Requirements() {
		UnorderedList unorderedList = new UnorderedList();
        
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_SCHOLARSHIP_PROOF);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_ACCOMMODATION_PROOF);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_EDUCATIONAL_ACCEPTANCE_REQUEST_LETTER);
        ListItem item4 = new ListItem(Labels.DOCUMENT_REQUIREMENT_RETURN_COMMITMENT_LETTER);
        ListItem item5 = new ListItem(Labels.DOCUMENT_REQUIREMENT_EMPLOYER_LETTER_OPTIONAL);
        ListItem item6 = new ListItem(Labels.DOCUMENT_REQUIREMENT_COPY_PREVIOUS_STUDENT_VISA);
        ListItem item7 = new ListItem(Labels.DOCUMENT_REQUIREMENT_PASSPORT_COPY);
        ListItem item8 = new ListItem(Labels.DOCUMENT_REQUIREMENT_CRIMINAL_RECORD_OPTIONAL);
        
        unorderedList.add(item1,item2,item3,item4,item5,item6,item7, item8);
        
        return unorderedList;
	}
	
	public Component visaExtensionB26Requirements() {
		UnorderedList unorderedList = new UnorderedList();
        
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_CREDENTIAL_ISSUED);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_ACCOMMODATION_PROOF);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_REQUEST_LETTER);
        ListItem item4 = new ListItem(Labels.DOCUMENT_REQUIREMENT_PASSPORT_COPY);
        ListItem item5 = new ListItem(Labels.DOCUMENT_REQUIREMENT_COPY_PREVIOUS_VISA);
        
        unorderedList.add(item1,item2,item3,item4,item5);
        
        return unorderedList;
	}
	
	public Component visaExtensionB27Requirements() {
		UnorderedList unorderedList = new UnorderedList();
        
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_PASSPORT_COPY);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_REQUEST_LETTER_WITH_REASON);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_COPY_PREVIOUS_VISA);
        ListItem item4 = new ListItem(Labels.DOCUMENT_REQUIREMENT_COPY_RETURN_TICKET);
        
        unorderedList.add(item1,item2,item3,item4);
        
        return unorderedList;
	}
	
	public Component visaExtensionB231Requirements() {
		UnorderedList unorderedList = new UnorderedList();
        
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_VISA_WORK_CONTRACT);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_WORK_AUTHORIZATION);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_VISA_PERMIT_OF_THE_COMPANY);
        ListItem item4 = new ListItem(Labels.DOCUMENT_REQUIREMENT_INSS_CERTIFICATE);
        ListItem item5 = new ListItem(Labels.DOCUMENT_REQUIREMENT_PASSPORT_COPY);
        ListItem item6 = new ListItem(Labels.DOCUMENT_REQUIREMENT_COMPANY_LETTER);
        ListItem item7 = new ListItem(Labels.DOCUMENT_REQUIREMENT_VISA_COPY_OF_WORK_VISA_DIRE);
        
        unorderedList.add(item1,item2,item3,item4, item5, item6, item7);
        
        return unorderedList;
	}
	
	public Component visaExtensionB232Requirements() {
		UnorderedList unorderedList = new UnorderedList();
        
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_VISA_AUTHORIZATION_FROM_MINISTER);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_PASSPORT_COPY);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_VISA_COPY_OF_WORK_VISA_DIRE);
        ListItem item4 = new ListItem(Labels.DOCUMENT_REQUIREMENT_VISA_GOVERNMENTAL_ENTITY_LETTER);
        
        unorderedList.add(item1,item2,item3,item4);
        
        return unorderedList;
	}
	
	public Component visaExtensionB233Requirements() {
		UnorderedList unorderedList = new UnorderedList();
        
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_VISA_AUTHORIZATION_FROM_MINISTER);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_PASSPORT_COPY);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_VISA_COPY_OF_WORK_VISA_DIRE);
        ListItem item4 = new ListItem(Labels.DOCUMENT_REQUIREMENT_VISA_CRIMINAL_RECORD_OPTIONAL);
        ListItem item5 = new ListItem(Labels.DOCUMENT_REQUIREMENT_CHURCH_CHARTER);
        
        unorderedList.add(item1,item2,item3,item4,item5);
        
        return unorderedList;
	}
	
	public Component direRequirementsB38() {
		UnorderedList unorderedList = new UnorderedList();
        
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_WORK_CONTRACT);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_WORK_AUTHORIZATION);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_PERMIT_OF_THE_COMPANY);
        ListItem item4 = new ListItem(Labels.DOCUMENT_REQUIREMENT_PASSPORT_COPY);
        ListItem item5 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_MARRIAGE_CERTIFICATE_TRANSLATED);
        ListItem item6 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_COPY_OF_WORK_VISA);
        ListItem item7 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_SPOUSES_CRIMINAL_RECORD);
        ListItem item8 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_COPY_OF_TEMPORARY_STAY_VISA);
        ListItem item9 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_STATEMENT_OF_RESPONSIBILITY);
        
        unorderedList.add(item1, item2, item3, item4, item5, item6, item7, item8, item9);
        
        return unorderedList;
	}
	
	public Component direRequirementsB31() {
		UnorderedList unorderedList = new UnorderedList();
        
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_SPOUSES_WORK_CONTRACT);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_SPOUSES_WORK_AUTHORIZATION);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_SPOUSES_PERMIT_OF_THE_COMPANY);
        ListItem item4 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_SPOUSES_PASSPORT_COPY);
        ListItem item5 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_MARRIAGE_CERTIFICATE_TRANSLATED);
        ListItem item6 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_SPOUSES_COPY_OF_WORK_VISA);
        ListItem item7 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_SPOUSES_CRIMINAL_RECORD);
        ListItem item8 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_SPOUSES_COPY_OF_TEMPORARY_STAY_VISA);
        ListItem item9 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_SPOUSES_STATEMENT_OF_RESPONSIBILITY);
        
        unorderedList.add(item1, item2, item3, item4, item5, item6, item7, item8, item9);
        
        return unorderedList;
	}
	
	public Component direRequirementsB32() {
		UnorderedList unorderedList = new UnorderedList();
        
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_PARENTS_WORK_CONTRACT);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_PARENTS_WORK_AUTHORIZATION);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_PARENTS_PERMIT_OF_THE_COMPANY);
        ListItem item4 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_KIDS_PASSPORT_COPY);
        ListItem item5 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_SPOUSES_COPY_OF_WORK_VISA);
        ListItem item6 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_HUSBANDS_COPY_OF_WORK_VISA);
        
        unorderedList.add(item1, item2, item3, item4, item5, item6);
        
        return unorderedList;
	}
	
	public Component direRequirementsB33() {
		UnorderedList unorderedList = new UnorderedList();
        
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_AUTHORIZATION_FROM_MINISTER);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_WIFES_PASSPORT_COPY);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_HUSBANDS_COPY_OF_WORK_VISA);
        ListItem item4 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_WIFES_CRIMINAL_RECORD);
        ListItem item5 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_MARRIAGE_CERTIFICATE_TRANSLATED);
        ListItem item6 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_SPOUSES_COPY_OF_TEMPORARY_STAY_VISA);
        ListItem item7 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_GOVERNMENT_ENTITY);
        ListItem item8 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_WIFES_STATEMENT_OF_RESPONSIBILITY);
        
        unorderedList.add(item1, item2, item3, item4, item5, item6, item7, item8);
        
        return unorderedList;
	}
	
	public Component direRequirementsB34() {
		UnorderedList unorderedList = new UnorderedList();
         
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_AUTHORIZATION_FROM_MINISTER);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_CHILD_PASSPORT_COPY);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_CHILD_COPY_OF_TEMPORARY_STAY_VISA);
        ListItem item4 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_PARENTS_COPY_OF_WORK_VISA);
        ListItem item5 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_PARENTS_STATEMENT_OF_RESPONSIBILITY);
        
        unorderedList.add(item1, item2, item3, item4, item5);
        
        return unorderedList;
	}
	
	public Component direRequirementsB35() {
		UnorderedList unorderedList = new UnorderedList();
         
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_AUTHORIZATION_FROM_MINISTER_DISPATCH_NOTICE);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_WIFES_CRIMINAL_RECORD);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_MARRIAGE_CERTIFICATE_TRANSLATED_PT);
        ListItem item4 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_WIFES_PASSPORT_COPY);
        ListItem item5 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_HUSBANDS_COPY_OF_WORK_VISA);
        ListItem item6 = new ListItem(Labels.DOCUMENT_REQUIREMENT_CHURCH_CHARTER);
        ListItem item7 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_SPOUSES_STATEMENT_OF_RESPONSIBILITY);
        
        unorderedList.add(item1, item2, item3, item4, item5, item6, item7);
        
        return unorderedList;
	}
	
	public Component direRequirementsB36() {
		UnorderedList unorderedList = new UnorderedList();
         
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_AUTHORIZATION_FROM_MINISTER_DISPATCH_NOTICE);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_SON_PASSPORT_COPY);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_SON_COPY_OF_TEMPORARY_STAY_VISA);
        ListItem item4 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_FATHER_COPY_OF_WORK_VISA);
        ListItem item5 = new ListItem(Labels.DOCUMENT_REQUIREMENT_CHURCH_CHARTER);
        ListItem item6 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_FATHER_STATEMENT_OF_RESPONSIBILITY);
        
        unorderedList.add(item1, item2, item3, item4, item5, item6);
        
        return unorderedList;
	}
	
	public Component direRequirementsB37() {
		UnorderedList unorderedList = new UnorderedList();
         
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_RESPONSIBLE_WORK_CONTRACT);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_FATHER_MOTHER_WORK_AUTHORIZATION);
        ListItem item3 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_FATHER_MOTHER_PERMIT_OF_THE_COMPANY);
        ListItem item4 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_RELIGIOUS_FIELD_AUTHORIZATION_FROM_MINISTER);
        ListItem item5 = new ListItem(Labels.DOCUMENT_REQUIREMENT_DIRE_COOPERATION_AUTHORIZATION_FROM_MINISTER);
        ListItem item6 = new ListItem(Labels.DOCUMENT_REQUIREMENT_MOZ_ID_COPY);
        
        unorderedList.add(item1, item2, item3, item4, item5, item6);
        
        return unorderedList;
	}
	
	public Component documentRequirementsB4() {
		UnorderedList unorderedList = new UnorderedList();
         
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_REFUGEE_ID);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_NAT_INSTITUTE_REFUGEE_ID);
        
        unorderedList.add(item1, item2);
        
        return unorderedList;
	}
	
	public Component documentRequirementsB6() {
		UnorderedList unorderedList = new UnorderedList();
         
        ListItem item1 = new ListItem(Labels.DOCUMENT_REQUIREMENT_RESIDENCE_ID);
        ListItem item2 = new ListItem(Labels.DOCUMENT_REQUIREMENT_POLICE_REPORT);
        
        unorderedList.add(item1, item2);
        
        return unorderedList;
	}
	
	public Component documentNoRequirements() {
		UnorderedList unorderedList = new UnorderedList();
         
        ListItem item1 = new ListItem(Labels.DOCUMENT_NO_REQUIREMENT);
        
        unorderedList.add(item1);
        
        return unorderedList;
	}
}
