package com.pursuit.salesCommission.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "FieldList")
public class FieldList {
	
		@Id
		@GeneratedValue
		@Column(name = "field_list_id")
		private long id;

		@Column(name = "fieldName")
		private String fieldName;

		@Column(name = "displayName")
		private String displayName;
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getFieldName() {
			return fieldName;
		}

		public void setFieldName(String fieldName) {
			this.fieldName = fieldName;
		}

		public String getDisplayName() {
			return displayName;
		}

		public void setDisplayName(String displayName) {
			this.displayName = displayName;
		}
}
