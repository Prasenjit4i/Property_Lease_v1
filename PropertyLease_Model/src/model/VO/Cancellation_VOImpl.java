package model.VO;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jul 17 17:44:34 IST 2019
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class Cancellation_VOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public Cancellation_VOImpl() {
    }

    /**
     * Returns the variable value for p_cancelId.
     * @return variable value for p_cancelId
     */
    public String getp_cancelId() {
        return (String)ensureVariableManager().getVariableValue("p_cancelId");
    }

    /**
     * Sets <code>value</code> for variable p_cancelId.
     * @param value value to bind as p_cancelId
     */
    public void setp_cancelId(String value) {
        ensureVariableManager().setVariableValue("p_cancelId", value);
    }
}