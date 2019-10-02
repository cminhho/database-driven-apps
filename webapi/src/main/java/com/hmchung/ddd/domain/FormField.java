package com.hmchung.ddd.domain;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.hateoas.ResourceSupport;

@Entity
public class FormField extends ResourceSupport {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long fieldId;

	private String type;
	private String cssClass;
	private String label;
	private Boolean multiValued;

	@ManyToOne
	@JsonIgnoreProperties("fields")
	private SubModule subModule;

	public FormField(Long fieldId,
			String type,
			String cssClass,
			String label,
			Boolean multiValued
			) {
		this.type = type;
		this.cssClass = cssClass;
		this.label = label;
		this.fieldId = fieldId;
		this.multiValued = multiValued;
	}
	

	public FormField(String type,
			String cssClass,
			String label) {
		this.type = type;
		this.cssClass = cssClass;
		this.label = label;
	}
	
	public FormField() {
	}

	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}

	public long getFieldId() {
		return fieldId;
	}

	public void setFieldId(long fieldId) {
		this.fieldId = fieldId;
	}


	public Boolean getMultiValued() {
		return multiValued;
	}

	public Boolean isMultiValued() {
		return multiValued;
	}
	public void setMultiValued(Boolean multiValued) {
		this.multiValued = multiValued;
	}

	public SubModule getSubModule() {
		return subModule;
	}

	public void setSubModule(SubModule subModule) {
		this.subModule = subModule;
	}
}
