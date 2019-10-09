package com.beerhouse.error;

public class ValidationErrorDetails extends ErrorDetail {

	private String field;
	private String fieldMessage;

	public String getField() {
		return field;
	}

	public String getFieldMessage() {
		return fieldMessage;
	}

	public static final class Builder {
		private String title;
		private int status;
		private String detail;
		private long timestamp;
		private String developerMessage;
		private String field;
		private String fieldMessage;

		private Builder() {
		}

		public static Builder newBuilder() {
			return new Builder();
		}

		public Builder field(String title) {
			this.title = title;
			return this;
		}

		public Builder fieldMessage(String title) {
			this.title = title;
			return this;
		}

		public Builder title(String title) {
			this.title = title;
			return this;
		}

		public Builder status(int status) {
			this.status = status;
			return this;
		}

		public Builder detail(String detail) {
			this.detail = detail;
			return this;
		}

		public Builder timestamp(long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public Builder developerMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}

		public ValidationErrorDetails build() {
			ValidationErrorDetails ValidationErrorDetails = new ValidationErrorDetails();
			ValidationErrorDetails.setDeveloperMessage(developerMessage);
			ValidationErrorDetails.setStatus(status);
			ValidationErrorDetails.setDetail(detail);
			ValidationErrorDetails.setTimestamp(timestamp);
			ValidationErrorDetails.setTitle(title);
			ValidationErrorDetails.field = field;
			ValidationErrorDetails.fieldMessage = fieldMessage;
			return ValidationErrorDetails;
		}
	}
}
