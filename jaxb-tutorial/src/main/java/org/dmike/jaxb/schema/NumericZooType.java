//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.02.12 at 07:57:54 PM CET 
//


package org.dmike.jaxb.schema;

import java.math.BigDecimal;
import java.math.BigInteger;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for NumericZooType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="NumericZooType"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="decimal" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="integer" type="{http://www.w3.org/2001/XMLSchema}integer"/&gt;
 *         &lt;element name="long" type="{http://www.w3.org/2001/XMLSchema}long"/&gt;
 *         &lt;element name="int" type="{http://www.w3.org/2001/XMLSchema}int"/&gt;
 *         &lt;element name="short_nil" type="{http://www.w3.org/2001/XMLSchema}short"/&gt;
 *         &lt;element name="byte" type="{http://www.w3.org/2001/XMLSchema}byte"/&gt;
 *         &lt;element name="nonNegative" type="{http://www.w3.org/2001/XMLSchema}nonNegativeInteger"/&gt;
 *         &lt;element name="unsignedLong" type="{http://www.w3.org/2001/XMLSchema}unsignedLong"/&gt;
 *         &lt;element name="unsignedInt" type="{http://www.w3.org/2001/XMLSchema}unsignedInt"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "NumericZooType", propOrder = {
    "decimal",
    "integer",
    "_long",
    "_int",
    "shortNil",
    "_byte",
    "nonNegative",
    "unsignedLong",
    "unsignedInt"
})
public class NumericZooType {

    @XmlElement(required = true)
    protected BigDecimal decimal;
    @XmlElement(required = true)
    protected BigInteger integer;
    @XmlElement(name = "long")
    protected long _long;
    @XmlElement(name = "int", defaultValue = "42")
    protected int _int;
    @XmlElement(name = "short_nil", required = true, type = Short.class, nillable = true)
    protected Short shortNil;
    @XmlElement(name = "byte", required = true, type = Byte.class, defaultValue = "13", nillable = true)
    protected Byte _byte;
    @XmlElement(required = true)
    @XmlSchemaType(name = "nonNegativeInteger")
    protected BigInteger nonNegative;
    @XmlElement(required = true)
    @XmlSchemaType(name = "unsignedLong")
    protected BigInteger unsignedLong;
    @XmlSchemaType(name = "unsignedInt")
    protected long unsignedInt;

    /**
     * Gets the value of the decimal property.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getDecimal() {
        return decimal;
    }

    /**
     * Sets the value of the decimal property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setDecimal(BigDecimal value) {
        this.decimal = value;
    }

    /**
     * Gets the value of the integer property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getInteger() {
        return integer;
    }

    /**
     * Sets the value of the integer property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setInteger(BigInteger value) {
        this.integer = value;
    }

    /**
     * Gets the value of the long property.
     * 
     */
    public long getLong() {
        return _long;
    }

    /**
     * Sets the value of the long property.
     * 
     */
    public void setLong(long value) {
        this._long = value;
    }

    /**
     * Gets the value of the int property.
     * 
     */
    public int getInt() {
        return _int;
    }

    /**
     * Sets the value of the int property.
     * 
     */
    public void setInt(int value) {
        this._int = value;
    }

    /**
     * Gets the value of the shortNil property.
     * 
     * @return
     *     possible object is
     *     {@link Short }
     *     
     */
    public Short getShortNil() {
        return shortNil;
    }

    /**
     * Sets the value of the shortNil property.
     * 
     * @param value
     *     allowed object is
     *     {@link Short }
     *     
     */
    public void setShortNil(Short value) {
        this.shortNil = value;
    }

    /**
     * Gets the value of the byte property.
     * 
     * @return
     *     possible object is
     *     {@link Byte }
     *     
     */
    public Byte getByte() {
        return _byte;
    }

    /**
     * Sets the value of the byte property.
     * 
     * @param value
     *     allowed object is
     *     {@link Byte }
     *     
     */
    public void setByte(Byte value) {
        this._byte = value;
    }

    /**
     * Gets the value of the nonNegative property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getNonNegative() {
        return nonNegative;
    }

    /**
     * Sets the value of the nonNegative property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setNonNegative(BigInteger value) {
        this.nonNegative = value;
    }

    /**
     * Gets the value of the unsignedLong property.
     * 
     * @return
     *     possible object is
     *     {@link BigInteger }
     *     
     */
    public BigInteger getUnsignedLong() {
        return unsignedLong;
    }

    /**
     * Sets the value of the unsignedLong property.
     * 
     * @param value
     *     allowed object is
     *     {@link BigInteger }
     *     
     */
    public void setUnsignedLong(BigInteger value) {
        this.unsignedLong = value;
    }

    /**
     * Gets the value of the unsignedInt property.
     * 
     */
    public long getUnsignedInt() {
        return unsignedInt;
    }

    /**
     * Sets the value of the unsignedInt property.
     * 
     */
    public void setUnsignedInt(long value) {
        this.unsignedInt = value;
    }

}
