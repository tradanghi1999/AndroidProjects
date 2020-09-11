package vn.edu.uel.nghiatd17411.model;

import java.io.Serializable;

public class Invoice implements Serializable {


    public Invoice(int id, Buyer _buyer, ShippingCenter _shipping, Supplier _supplier, String _shippingPeriod, double _onBillsValue, double _shippingFee, String _invoiceDate, String _paymentMethod) {
        this.id = id;
        this._buyer = _buyer;
        this._shipping = _shipping;
        this._supplier = _supplier;
        this._shippingPeriod = _shippingPeriod;
        this._onBillsValue = _onBillsValue;
        this._shippingFee = _shippingFee;
        this._invoiceDate = _invoiceDate;
        this._paymentMethod = _paymentMethod;
    }

    public Buyer get_buyer() {
        return _buyer;
    }

    public void set_buyer(Buyer _buyer) {
        this._buyer = _buyer;
    }

    public ShippingCenter get_shipping() {
        return _shipping;
    }

    public void set_shipping(ShippingCenter _shipping) {
        this._shipping = _shipping;
    }

    public Supplier get_supplier() {
        return _supplier;
    }

    public void set_supplier(Supplier _supplier) {
        this._supplier = _supplier;
    }

    public String get_shippingPeriod() {
        return _shippingPeriod;
    }

    public void set_shippingPeriod(String _shippingPeriod) {
        this._shippingPeriod = _shippingPeriod;
    }

    public double get_onBillsValue() {
        return _onBillsValue;
    }

    public void set_onBillsValue(double _onBillsValue) {
        this._onBillsValue = _onBillsValue;
    }

    public double get_shippingFee() {
        return _shippingFee;
    }

    public void set_shippingFee(double _shippingFee) {
        this._shippingFee = _shippingFee;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public String get_invoiceDate() {
        return _invoiceDate;
    }

    public void set_invoiceDate(String _invoiceDate) {
        this._invoiceDate = _invoiceDate;
    }



    public String get_paymentMethod() {
        return _paymentMethod;
    }

    public void set_paymentMethod(String _paymentMethod) {
        this._paymentMethod = _paymentMethod;
    }

    String _paymentMethod;
    int id;
    Buyer _buyer;
    ShippingCenter _shipping;
    Supplier _supplier;
    String _shippingPeriod;
    double _onBillsValue;
    double _shippingFee;
    String _invoiceDate;
}
