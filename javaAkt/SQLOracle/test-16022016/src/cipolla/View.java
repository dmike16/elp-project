package cipolla;

import java.util.Date;

public interface View {
	String getStringNotNull(String mesg);
	int getIntNotNull(String mesg);
	long getLongNotNull(String mesg);
	double getDoubleNotNull(String mesg);
	Date getDateNotNull(String mesg) throws NotValidDateException;
}
