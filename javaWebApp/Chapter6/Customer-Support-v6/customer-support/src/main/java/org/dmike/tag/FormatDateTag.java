package org.dmike.tag;

import org.apache.commons.lang3.StringUtils;
import org.apache.taglibs.standard.tag.common.core.Util;
import org.apache.taglibs.standard.tag.common.fmt.SetLocaleSupport;
import org.apache.taglibs.standard.tag.common.fmt.TimeZoneSupport;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspTagException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.function.Function;

/**
 * Created by dmike on 30/04/16.
 * @author dmike
 */
public class FormatDateTag extends TagSupport {
    public FormatDateTag(){
        super();
        init();
    }

    @Override
    public int doStartTag()
     throws JspException
    {
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag()
        throws JspException
    {
        if(this.value == null){
            if(var != null){
                pageContext.removeAttribute(var,scope);
            }
            return Tag.EVAL_PAGE;
        }

        String formatted = " ";
        Locale locale = this.getLocale();

        if(locale != null){
            if(this.timeZone == null){
                this.timeZone = this.getTimeZone();
            }
            if(this.timeZone == null){
                this.timeZone = TimeZone.getDefault();
            }

            if(this.value instanceof Date){
                formatted = this.formatDate((Date)value,locale);

            }else if(this.value instanceof Calendar){
                formatted = this.formatDate(((Calendar)value).getTime(),locale);

            }else{
                throw new JspTagException("Unsupported date type " + this.value.getClass().getCanonicalName() + ".");
            }
        }else{
            formatted = this.value.toString();
        }

        if(this.var != null){
            this.pageContext.setAttribute(this.var,formatted,this.scope);
        }else{
            try{
                this.pageContext.getOut().write(formatted);
            }catch (IOException e){
                throw new JspTagException(e.toString(),e);
            }
        }

        return Tag.EVAL_PAGE;
    }

    @Override
    public void release(){
        super.release();
        this.init();
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getType() {
        return type.name().toLowerCase();
    }

    public void setType(String type) {
        this.type = (StringUtils.isBlank(type)?null:Type.valueOf(type.toUpperCase()));
    }

    public String getVar() {
        return var;
    }

    public void setVar(String var) {
        this.var = var;
    }

    public int getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = Util.getScope(scope);
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = StringUtils.isBlank(pattern)?null:pattern;
    }

    private Locale getLocale()
        throws JspException
    {
        try{
            return (Locale) __GET_LOCALE.invoke(null,this.pageContext,this,true,true);
        }catch(IllegalAccessException | InvocationTargetException e){
            throw new JspException(e.toString(),e);
        }
    }

    private TimeZone getTimeZone()
        throws JspException
    {
        try{
            return (TimeZone)__GET_TIME_ZONE.invoke(null,this.pageContext,this);
        }catch(IllegalAccessException | InvocationTargetException e){
            throw new JspException(e.toString(),e);
        }
    }

    private void init(){
        this.type = Type.DATE;
        this.var = null;
        this.scope = PageContext.PAGE_SCOPE;
    }
    private static enum Type{
        DATE, TIME, BOTH
    }

    private String formatDate(Date value,Locale locale){
        if(this.pattern != null){
            SimpleDateFormat format = new SimpleDateFormat(this.pattern,locale);
            format.setTimeZone(this.timeZone);
            return format.format(value);
        }

        Function<Date,String> dateFormat = null;
        Function<Date,String> timeFormat = null;

        if(Type.DATE == this.type || this.type == Type.BOTH){
            DateFormat format = DateFormat.getDateInstance(DateFormat.SHORT,locale);
            format.setTimeZone(this.timeZone);
            dateFormat = format::format;
        }
        if(this.type == Type.TIME || this.type == Type.BOTH){
            DateFormat format = DateFormat.getTimeInstance(DateFormat.SHORT,locale);
            format.setTimeZone(this.timeZone);
            timeFormat = format::format;
        }

        return this.formatDate(dateFormat,timeFormat,value);
    }

    private <T> String formatDate(Function<T,String> dateFormat,
                                  Function<T,String> timeFormat, T value){
        String formatted = "";
        if(dateFormat != null){
            formatted += dateFormat.apply(value);
        }
        if(timeFormat != null){
            formatted += timeFormat.apply(value);
        }

        return formatted;
    }

    private Object value;
    private Type type;
    private String var;
    private int scope;
    private TimeZone timeZone;
    private String pattern;

    private static final Method __GET_LOCALE;
    private static final Method __GET_TIME_ZONE;

    static {
        try{
            __GET_LOCALE = SetLocaleSupport.class.getDeclaredMethod("getFormattingLocale",
                    PageContext.class,Tag.class,boolean.class,boolean.class);
            __GET_LOCALE.setAccessible(true);

            __GET_TIME_ZONE = TimeZoneSupport.class.getDeclaredMethod("getTimeZone",
                    PageContext.class,Tag.class);
            __GET_TIME_ZONE.setAccessible(true);

        }catch (NoSuchMethodException e){
            throw new RuntimeException(e);
        }
    }
}
