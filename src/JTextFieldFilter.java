import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * Created with IntelliJ IDEA.
 * User: Modzel
 * Date: 18.06.13
 * Time: 22:39
 * To change this template use File | Settings | File Templates.
 */
class JTextFieldFilter extends PlainDocument {
    public static final String ALPHA = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMERIC = "0123456789";
    public static final String ALPHA_NUMERIC = ALPHA + NUMERIC;

    protected String acceptedChars = null;

    protected boolean negativeAccepted = false;

    public JTextFieldFilter() {
        this(ALPHA_NUMERIC);
    }

    public JTextFieldFilter(String acceptedchars) {
        acceptedChars = acceptedchars;
    }

    public void setNegativeAccepted(boolean negativeaccepted) {
        if (acceptedChars.equals(ALPHA_NUMERIC)) {
            negativeAccepted = negativeaccepted;
            acceptedChars += "-";
        }
    }

    public void insertString(int offset, String str, AttributeSet attr) throws BadLocationException {
        if (str == null)
            return;
        for (int i = 0; i < str.length(); i++) {
            if (acceptedChars.indexOf(str.valueOf(str.charAt(i))) == -1)
                return;
        }

        if (negativeAccepted) {
            if (str.indexOf(".") != -1) {
                if (getText(0, getLength()).indexOf(".") != -1) {
                    return;
                }
            }
        }

        if (negativeAccepted && str.indexOf("-") != -1) {
            if (str.indexOf("-") != 0 || offset != 0) {
                return;
            }
        }

        super.insertString(offset, str, attr);
    }
}