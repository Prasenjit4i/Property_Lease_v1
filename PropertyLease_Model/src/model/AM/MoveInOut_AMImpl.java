package model.AM;

import model.AM.common.MoveInOut_AM;

import model.VO.ApplianceDetails_VOImpl;
import model.VO.Cancellation_VOImpl;
import model.VO.KeyDetails_VOImpl;

import model.VO.LeaseAgreement_VOImpl;
import model.VO.MoveInOut_VOImpl;
import model.VO.PropertyMaster_VOImpl;

import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewCriteria;
import oracle.jbo.ViewCriteriaRow;
import oracle.jbo.ViewObject;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewLinkImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue May 15 18:51:34 IST 2018
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class MoveInOut_AMImpl extends ApplicationModuleImpl implements MoveInOut_AM {
    /**
     * This is the default constructor (do not remove).
     */
    public MoveInOut_AMImpl() {
    }

    /**
     * Container's getter for MoveInOut_VO1.
     * @return MoveInOut_VO1
     */
    public ViewObjectImpl getMoveInOut_VO1() {
        return (ViewObjectImpl)findViewObject("MoveInOut_VO1");
    }

    /**
     * Container's getter for ApplianceDetails_VO1.
     * @return ApplianceDetails_VO1
     */
    public ViewObjectImpl getApplianceDetails_VO1() {
        return (ViewObjectImpl)findViewObject("ApplianceDetails_VO1");
    }

    /**
     * Container's getter for KeyDetails_VO1.
     * @return KeyDetails_VO1
     */
    public ViewObjectImpl getKeyDetails_VO1() {
        return (ViewObjectImpl)findViewObject("KeyDetails_VO1");
    }

    /**
     * Container's getter for MeterReading_VO1.
     * @return MeterReading_VO1
     */
    public ViewObjectImpl getMeterReading_VO1() {
        return (ViewObjectImpl)findViewObject("MeterReading_VO1");
    }

    /**
     * Container's getter for MoveInOut_Appliance_VL1.
     * @return MoveInOut_Appliance_VL1
     */
    public ViewLinkImpl getMoveInOut_Appliance_VL1() {
        return (ViewLinkImpl)findViewLink("MoveInOut_Appliance_VL1");
    }

    /**
     * Container's getter for MoveInOut_Key_VL1.
     * @return MoveInOut_Key_VL1
     */
    public ViewLinkImpl getMoveInOut_Key_VL1() {
        return (ViewLinkImpl)findViewLink("MoveInOut_Key_VL1");
    }

    /**
     * Container's getter for MoveInOut_Meter_VL1.
     * @return MoveInOut_Meter_VL1
     */
    public ViewLinkImpl getMoveInOut_Meter_VL1() {
        return (ViewLinkImpl)findViewLink("MoveInOut_Meter_VL1");
    }

    /**
     * Container's getter for Lookup_View_ROVO1.
     * @return Lookup_View_ROVO1
     */
    public ViewObjectImpl getLookup_View_ROVO1() {
        return (ViewObjectImpl)findViewObject("Lookup_View_ROVO1");
    }

    /**
     * Container's getter for Lookup_View_ROVO2.
     * @return Lookup_View_ROVO2
     */
    public ViewObjectImpl getLookup_View_ROVO2() {
        return (ViewObjectImpl)findViewObject("Lookup_View_ROVO2");
    }

    /**
     * Container's getter for Lookup_View_ROVO3.
     * @return Lookup_View_ROVO3
     */
    public ViewObjectImpl getLookup_View_ROVO3() {
        return (ViewObjectImpl)findViewObject("Lookup_View_ROVO3");
    }
    
    public void onCreateMoveinMoveOut(){
       
        ViewObject Mhdr = this.getMoveInOut_VO1().getViewObject();
        ViewObject App = this.getApplianceDetails_VO1().getViewObject();
        ViewObject Keys = this.getKeyDetails_VO1().getViewObject();
        ViewObject Meter = this.getMeterReading_VO1().getViewObject();
        ViewObject LK1 = this.getLookup_View_ROVO1().getViewObject();
        ViewObject LK2 = this.getLookup_View_ROVO2().getViewObject();
        ViewObject LK3 = this.getLookup_View_ROVO3().getViewObject();
        
        
        Row MhdrRow=Mhdr.createRow();
        
        Mhdr.insertRow(MhdrRow);
        
        //ViewObject offerDtlVO=this.getOfferDetail_VO2().getViewObject();
        ViewCriteria LK1VC=LK1.createViewCriteria();
        ViewCriteriaRow LK1VCR=LK1VC.createViewCriteriaRow();
       LK1VCR.setAttribute("LookupTypeName", "APPLIANCES");
        LK1VC.addRow(LK1VCR);
        LK1.applyViewCriteria(LK1VC);
        LK1.executeQuery();
        // Iterating Lines
        RowSetIterator LK1RS=LK1.createRowSetIterator(null);
        while(LK1RS.hasNext()){
            Row LK1Row=LK1RS.next();
            Row AppRow=App.createRow();
            //            bookingRow.setAttribute("BookingId", this.getBookingHeader_VO1().getCurrentRow().getAttribute("BookingId"));
            AppRow.setAttribute("ItemCode", LK1Row.getAttribute("LookupValueName"));
            AppRow.setAttribute("Description", LK1Row.getAttribute("LookupValueNameDisp"));
            
            App.insertRow(AppRow);
        }
        App.executeQuery();
        
        
        
        
        ViewCriteria LK2VC=LK2.createViewCriteria();
        ViewCriteriaRow LK2VCR=LK2VC.createViewCriteriaRow();
        LK2VCR.setAttribute("LookupTypeName", "HANDOVER_KEYS");
        LK2VC.addRow(LK2VCR);
        LK2.applyViewCriteria(LK2VC);
        LK2.executeQuery();
        // Iterating Lines
        RowSetIterator LK2RS=LK2.createRowSetIterator(null);
        while(LK2RS.hasNext()){
            Row LK2Row=LK2RS.next();
            Row Keyrow=Keys.createRow();
            //            bookingRow.setAttribute("BookingId", this.getBookingHeader_VO1().getCurrentRow().getAttribute("BookingId"));
            Keyrow.setAttribute("KeyCode", LK2Row.getAttribute("LookupValueName"));
            Keyrow.setAttribute("Description", LK2Row.getAttribute("LookupValueNameDisp"));
            
            Keys.insertRow(Keyrow);
        }
        Keys.executeQuery();
        
        
        
        ViewCriteria LK3VC=LK3.createViewCriteria();
        ViewCriteriaRow LK3VCR=LK3VC.createViewCriteriaRow();
        LK3VCR.setAttribute("LookupTypeName", "METER_READINGS");
        LK3VC.addRow(LK3VCR);
        LK3.applyViewCriteria(LK3VC);
        LK3.executeQuery();
        // Iterating Lines
        RowSetIterator LK3RS=LK3.createRowSetIterator(null);
        while(LK3RS.hasNext()){
            Row LK3Row=LK3RS.next();
            Row Meterrow=Meter.createRow();
            //            bookingRow.setAttribute("BookingId", this.getBookingHeader_VO1().getCurrentRow().getAttribute("BookingId"));
            Meterrow.setAttribute("MeterCode", LK3Row.getAttribute("LookupValueName"));
           Meterrow.setAttribute("Description", LK3Row.getAttribute("LookupValueNameDisp"));
            
            Meter.insertRow(Meterrow);
        }
        Meter.executeQuery();

    }

    /**
     * Container's getter for getFunctionCodeROVO1.
     * @return getFunctionCodeROVO1
     */
    public ViewObjectImpl getgetFunctionCodeROVO1() {
        return (ViewObjectImpl)findViewObject("getFunctionCodeROVO1");
    }

    /**
     * Container's getter for LeaseAgreement_VO1.
     * @return LeaseAgreement_VO1
     */
    public ViewObjectImpl getLeaseAgreement_VO1() {
        return (ViewObjectImpl)findViewObject("LeaseAgreement_VO1");
    }

    /**
     * Container's getter for MoveInOut_VO2.
     * @return MoveInOut_VO2
     */
    public ViewObjectImpl getMoveInOut_VO2() {
        return (ViewObjectImpl)findViewObject("MoveInOut_VO2");
    }

    /**
     * Container's getter for LeaseMoveInMoveOutVL1.
     * @return LeaseMoveInMoveOutVL1
     */
    public ViewLinkImpl getLeaseMoveInMoveOutVL1() {
        return (ViewLinkImpl)findViewLink("LeaseMoveInMoveOutVL1");
    }

    /**
     * Container's getter for PropertyMaster_VO1.
     * @return PropertyMaster_VO1
     */
    public ViewObjectImpl getPropertyMaster_VO1() {
        return (ViewObjectImpl)findViewObject("PropertyMaster_VO1");
    }

    /**
     * Container's getter for BookingDetail_VO1.
     * @return BookingDetail_VO1
     */
    public ViewObjectImpl getBookingDetail_VO1() {
        return (ViewObjectImpl)findViewObject("BookingDetail_VO1");
    }

    /**
     * Container's getter for MoveInOut_VO4.
     * @return MoveInOut_VO4
     */
    public ViewObjectImpl getMoveInOut_VO4() {
        return (ViewObjectImpl)findViewObject("MoveInOut_VO4");
    }

    /**
     * Container's getter for ApplianceDetails_VO2.
     * @return ApplianceDetails_VO2
     */
    public ApplianceDetails_VOImpl getApplianceDetails_VO2() {
        return (ApplianceDetails_VOImpl)findViewObject("ApplianceDetails_VO2");
    }

    /**
     * Container's getter for MoveInOut_Appliance_VL2.
     * @return MoveInOut_Appliance_VL2
     */
    public ViewLinkImpl getMoveInOut_Appliance_VL2() {
        return (ViewLinkImpl)findViewLink("MoveInOut_Appliance_VL2");
    }

    /**
     * Container's getter for KeyDetails_VO2.
     * @return KeyDetails_VO2
     */
    public KeyDetails_VOImpl getKeyDetails_VO2() {
        return (KeyDetails_VOImpl)findViewObject("KeyDetails_VO2");
    }

    /**
     * Container's getter for MoveInOut_Key_VL2.
     * @return MoveInOut_Key_VL2
     */
    public ViewLinkImpl getMoveInOut_Key_VL2() {
        return (ViewLinkImpl)findViewLink("MoveInOut_Key_VL2");
    }

    /**
     * Container's getter for MeterReading_VO2.
     * @return MeterReading_VO2
     */
    public ViewObjectImpl getMeterReading_VO2() {
        return (ViewObjectImpl)findViewObject("MeterReading_VO2");
    }

    /**
     * Container's getter for MoveInOut_Meter_VL2.
     * @return MoveInOut_Meter_VL2
     */
    public ViewLinkImpl getMoveInOut_Meter_VL2() {
        return (ViewLinkImpl)findViewLink("MoveInOut_Meter_VL2");
    }

    /**
     * Container's getter for ApplianceDetails_VO3.
     * @return ApplianceDetails_VO3
     */
    public ApplianceDetails_VOImpl getApplianceDetails_VO3() {
        return (ApplianceDetails_VOImpl)findViewObject("ApplianceDetails_VO3");
    }

    /**
     * Container's getter for MeterReading_VO3.
     * @return MeterReading_VO3
     */
    public ViewObjectImpl getMeterReading_VO3() {
        return (ViewObjectImpl)findViewObject("MeterReading_VO3");
    }

    /**
     * Container's getter for KeyDetails_VO3.
     * @return KeyDetails_VO3
     */
    public KeyDetails_VOImpl getKeyDetails_VO3() {
        return (KeyDetails_VOImpl)findViewObject("KeyDetails_VO3");
    }

    /**
     * Container's getter for Lookup_View_ROVO4.
     * @return Lookup_View_ROVO4
     */
    public ViewObjectImpl getLookup_View_ROVO4() {
        return (ViewObjectImpl)findViewObject("Lookup_View_ROVO4");
    }

    /**
     * Container's getter for getApprovalHistoryROVo1.
     * @return getApprovalHistoryROVo1
     */
    public ViewObjectImpl getgetApprovalHistoryROVo1() {
        return (ViewObjectImpl)findViewObject("getApprovalHistoryROVo1");
    }

    /**
     * Container's getter for MoveinoutApprovalVL1.
     * @return MoveinoutApprovalVL1
     */
    public ViewLinkImpl getMoveinoutApprovalVL1() {
        return (ViewLinkImpl)findViewLink("MoveinoutApprovalVL1");
    }

    /**
     * Container's getter for Cancellation_VO1.
     * @return Cancellation_VO1
     */
    public Cancellation_VOImpl getCancellation_VO1() {
        return (Cancellation_VOImpl)findViewObject("Cancellation_VO1");
    }
}