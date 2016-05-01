package org.dmike.tag;

import org.apache.commons.lang3.StringUtils;
import org.apache.taglibs.standard.tag.common.core.Util;
import org.apache.taglibs.standard.tag.common.fmt.SetLocaleSupport;
import org.apache.taglibs.standard.tag.common.fmt.TimeZoneSupport;

import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;
import javax.servlet.jsp.tagext.TagSupport;
import java.lang.reflect.Method;
import java.text.DateFormat;

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
    public int doStartTag(){
        return Tag.SKIP_BODY;
    }

    @Override
    public int doEndTag(){
        if(this.value == null){
            if(var != null){
                pageContext.removeAttribute(var,scope);
                return Tag.EVAL_PAGE;
            }
        }

        return Tag.EVAL_PAGE;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public Type getType() {
        return type;
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

    private void init(){
        this.type = Type.DATE;
        this.var = null;
        this.scope = PageContext.PAGE_SCOPE;
    }
    private static enum Type{
        DATE, TIME, BOTH
    }

    private Object value;
    private Type type;
    private String var;
    private int scope;

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
