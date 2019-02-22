// Program to allow the user to convert LocalDate time into SQL's Date.
// Package and important statements.
package controller;
import java.sql.Date;
import java.time.LocalDate;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

@Converter(autoApply = true)
public class LocalDateAttributeConverter implements AttributeConverter<LocalDate, Date> 
{
	@Override
	public Date convertToDatabaseColumn(LocalDate attribute) 
	{
		return (attribute == null ? null: Date.valueOf(attribute));
	}
	
	@Override
	public LocalDate convertToEntityAttribute(Date dbData) 
	{
		return (dbData == null ? null: dbData.toLocalDate());
	}
}
