package com.markerud.cxfbugexample.exceptionhandling;

import io.github.threetenjaxb.core.LocalDateTimeXmlAdapter;
import java.time.LocalDateTime;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "messageID",
    "timestamp"
})
@XmlRootElement(name = "Error")
public class Error {

  @XmlElement(name = "MessageID", required = true, defaultValue = "")
  private String messageID;

  @XmlElement(name = "Timestamp", required = true, type = String.class)
  @XmlJavaTypeAdapter(LocalDateTimeXmlAdapter.class)
  @XmlSchemaType(name = "dateTime")
  private LocalDateTime timestamp;
}
