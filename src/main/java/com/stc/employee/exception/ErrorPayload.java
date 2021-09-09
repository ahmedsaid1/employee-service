package com.stc.employee.exception;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ErrorPayload {
	private String message;
	private String type;
	private String timeStamp;
//private Map<String, Object> details;

}
